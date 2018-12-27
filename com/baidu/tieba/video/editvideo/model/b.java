package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b hFA;
    private HashMap<String, String> hFv;
    private DownloadData hFw;

    /* loaded from: classes5.dex */
    public interface a {
        void bIP();

        void cR(String str, String str2);

        void wC(String str);
    }

    private b() {
    }

    public static b bJE() {
        if (hFA == null) {
            synchronized (b.class) {
                if (hFA == null) {
                    hFA = new b();
                }
            }
        }
        return hFA;
    }

    public String wL(String str) {
        String fL = ar.fL(str);
        if (fL == null) {
            return null;
        }
        if (this.hFv == null) {
            this.hFv = new HashMap<>();
            bJF();
            if (this.hFv.size() > 0) {
                return this.hFv.get(fL);
            }
            return null;
        }
        return this.hFv.get(fL);
    }

    public void bJF() {
        if (this.hFv == null) {
            this.hFv = new HashMap<>();
        } else {
            this.hFv.clear();
        }
        File file = new File(c.hCV);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hFv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String fL;
        if (!TextUtils.isEmpty(str2) && (fL = ar.fL(str2)) != null) {
            if (this.hFw != null) {
                d.LS().u(this.hFw.getUrl(), true);
            }
            File file = new File(c.hCV);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hCV + fL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hFw != null && downloadData2.getUrl().equals(b.this.hFw.getUrl())) {
                            b.this.hFw = null;
                        }
                        if (aVar != null) {
                            aVar.bIP();
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
                        if (b.this.hFw != null && downloadData2.getUrl().equals(b.this.hFw.getUrl())) {
                            b.this.hFw = null;
                        }
                        if (aVar != null) {
                            b.this.hFv.put(downloadData2.getPath().substring(c.hCV.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cR(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hFw != null && downloadData2.getUrl().equals(b.this.hFw.getUrl())) {
                        b.this.hFw = null;
                    }
                    if (aVar != null) {
                        aVar.wC(str3);
                    }
                }
            });
            this.hFw = downloadData;
            d.LS().f(downloadData);
        }
    }
}
