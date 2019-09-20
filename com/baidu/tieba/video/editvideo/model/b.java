package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b jzJ;
    private HashMap<String, String> jzE;
    private DownloadData jzF;

    /* loaded from: classes5.dex */
    public interface a {
        void Gf(String str);

        void cuX();

        void et(String str, String str2);
    }

    private b() {
    }

    public static b cvM() {
        if (jzJ == null) {
            synchronized (b.class) {
                if (jzJ == null) {
                    jzJ = new b();
                }
            }
        }
        return jzJ;
    }

    public String Go(String str) {
        String ol = as.ol(str);
        if (ol == null) {
            return null;
        }
        if (this.jzE == null) {
            this.jzE = new HashMap<>();
            cvN();
            if (this.jzE.size() > 0) {
                return this.jzE.get(ol);
            }
            return null;
        }
        return this.jzE.get(ol);
    }

    public void cvN() {
        if (this.jzE == null) {
            this.jzE = new HashMap<>();
        } else {
            this.jzE.clear();
        }
        File file = new File(c.jxe);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jzE.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String ol;
        if (!TextUtils.isEmpty(str2) && (ol = as.ol(str2)) != null) {
            if (this.jzF != null) {
                d.asg().S(this.jzF.getUrl(), true);
            }
            File file = new File(c.jxe);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jxe + ol + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.jzF != null && downloadData2.getUrl().equals(b.this.jzF.getUrl())) {
                            b.this.jzF = null;
                        }
                        if (aVar != null) {
                            aVar.cuX();
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
                        if (b.this.jzF != null && downloadData2.getUrl().equals(b.this.jzF.getUrl())) {
                            b.this.jzF = null;
                        }
                        if (aVar != null) {
                            b.this.jzE.put(downloadData2.getPath().substring(c.jxe.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.et(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.jzF != null && downloadData2.getUrl().equals(b.this.jzF.getUrl())) {
                        b.this.jzF = null;
                    }
                    if (aVar != null) {
                        aVar.Gf(str3);
                    }
                }
            });
            this.jzF = downloadData;
            d.asg().f(downloadData);
        }
    }
}
