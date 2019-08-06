package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b jxn;
    private HashMap<String, String> jxi;
    private DownloadData jxj;

    /* loaded from: classes5.dex */
    public interface a {
        void FF(String str);

        void cuj();

        void es(String str, String str2);
    }

    private b() {
    }

    public static b cuY() {
        if (jxn == null) {
            synchronized (b.class) {
                if (jxn == null) {
                    jxn = new b();
                }
            }
        }
        return jxn;
    }

    public String FO(String str) {
        String oj = at.oj(str);
        if (oj == null) {
            return null;
        }
        if (this.jxi == null) {
            this.jxi = new HashMap<>();
            cuZ();
            if (this.jxi.size() > 0) {
                return this.jxi.get(oj);
            }
            return null;
        }
        return this.jxi.get(oj);
    }

    public void cuZ() {
        if (this.jxi == null) {
            this.jxi = new HashMap<>();
        } else {
            this.jxi.clear();
        }
        File file = new File(c.juI);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jxi.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String oj;
        if (!TextUtils.isEmpty(str2) && (oj = at.oj(str2)) != null) {
            if (this.jxj != null) {
                d.arU().S(this.jxj.getUrl(), true);
            }
            File file = new File(c.juI);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.juI + oj + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.jxj != null && downloadData2.getUrl().equals(b.this.jxj.getUrl())) {
                            b.this.jxj = null;
                        }
                        if (aVar != null) {
                            aVar.cuj();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (b.this.jxj != null && downloadData2.getUrl().equals(b.this.jxj.getUrl())) {
                            b.this.jxj = null;
                        }
                        if (aVar != null) {
                            b.this.jxi.put(downloadData2.getPath().substring(c.juI.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.es(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.jxj != null && downloadData2.getUrl().equals(b.this.jxj.getUrl())) {
                        b.this.jxj = null;
                    }
                    if (aVar != null) {
                        aVar.FF(str3);
                    }
                }
            });
            this.jxj = downloadData;
            d.arU().f(downloadData);
        }
    }
}
