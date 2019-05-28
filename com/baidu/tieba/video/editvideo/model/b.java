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
    private static volatile b jpV;
    private HashMap<String, String> jpQ;
    private DownloadData jpR;

    /* loaded from: classes5.dex */
    public interface a {
        void EO(String str);

        void crb();

        void er(String str, String str2);
    }

    private b() {
    }

    public static b crQ() {
        if (jpV == null) {
            synchronized (b.class) {
                if (jpV == null) {
                    jpV = new b();
                }
            }
        }
        return jpV;
    }

    public String EX(String str) {
        String nT = as.nT(str);
        if (nT == null) {
            return null;
        }
        if (this.jpQ == null) {
            this.jpQ = new HashMap<>();
            crR();
            if (this.jpQ.size() > 0) {
                return this.jpQ.get(nT);
            }
            return null;
        }
        return this.jpQ.get(nT);
    }

    public void crR() {
        if (this.jpQ == null) {
            this.jpQ = new HashMap<>();
        } else {
            this.jpQ.clear();
        }
        File file = new File(c.jnq);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jpQ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nT;
        if (!TextUtils.isEmpty(str2) && (nT = as.nT(str2)) != null) {
            if (this.jpR != null) {
                d.aqM().Q(this.jpR.getUrl(), true);
            }
            File file = new File(c.jnq);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jnq + nT + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.jpR != null && downloadData2.getUrl().equals(b.this.jpR.getUrl())) {
                            b.this.jpR = null;
                        }
                        if (aVar != null) {
                            aVar.crb();
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
                        if (b.this.jpR != null && downloadData2.getUrl().equals(b.this.jpR.getUrl())) {
                            b.this.jpR = null;
                        }
                        if (aVar != null) {
                            b.this.jpQ.put(downloadData2.getPath().substring(c.jnq.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.er(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.jpR != null && downloadData2.getUrl().equals(b.this.jpR.getUrl())) {
                        b.this.jpR = null;
                    }
                    if (aVar != null) {
                        aVar.EO(str3);
                    }
                }
            });
            this.jpR = downloadData;
            d.aqM().f(downloadData);
        }
    }
}
