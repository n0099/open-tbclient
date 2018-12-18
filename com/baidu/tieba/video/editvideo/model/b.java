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
    private static volatile b hCp;
    private HashMap<String, String> hCk;
    private DownloadData hCl;

    /* loaded from: classes5.dex */
    public interface a {
        void bHZ();

        void cR(String str, String str2);

        void wz(String str);
    }

    private b() {
    }

    public static b bIO() {
        if (hCp == null) {
            synchronized (b.class) {
                if (hCp == null) {
                    hCp = new b();
                }
            }
        }
        return hCp;
    }

    public String wI(String str) {
        String fK = ar.fK(str);
        if (fK == null) {
            return null;
        }
        if (this.hCk == null) {
            this.hCk = new HashMap<>();
            bIP();
            if (this.hCk.size() > 0) {
                return this.hCk.get(fK);
            }
            return null;
        }
        return this.hCk.get(fK);
    }

    public void bIP() {
        if (this.hCk == null) {
            this.hCk = new HashMap<>();
        } else {
            this.hCk.clear();
        }
        File file = new File(c.hzK);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hCk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String fK;
        if (!TextUtils.isEmpty(str2) && (fK = ar.fK(str2)) != null) {
            if (this.hCl != null) {
                d.LR().u(this.hCl.getUrl(), true);
            }
            File file = new File(c.hzK);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hzK + fK + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hCl != null && downloadData2.getUrl().equals(b.this.hCl.getUrl())) {
                            b.this.hCl = null;
                        }
                        if (aVar != null) {
                            aVar.bHZ();
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
                        if (b.this.hCl != null && downloadData2.getUrl().equals(b.this.hCl.getUrl())) {
                            b.this.hCl = null;
                        }
                        if (aVar != null) {
                            b.this.hCk.put(downloadData2.getPath().substring(c.hzK.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.hCl != null && downloadData2.getUrl().equals(b.this.hCl.getUrl())) {
                        b.this.hCl = null;
                    }
                    if (aVar != null) {
                        aVar.wz(str3);
                    }
                }
            });
            this.hCl = downloadData;
            d.LR().f(downloadData);
        }
    }
}
