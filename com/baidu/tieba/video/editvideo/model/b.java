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
    private static volatile b hGI;
    private HashMap<String, String> hGD;
    private DownloadData hGE;

    /* loaded from: classes5.dex */
    public interface a {
        void bJy();

        void cT(String str, String str2);

        void wS(String str);
    }

    private b() {
    }

    public static b bKn() {
        if (hGI == null) {
            synchronized (b.class) {
                if (hGI == null) {
                    hGI = new b();
                }
            }
        }
        return hGI;
    }

    public String xb(String str) {
        String fY = ar.fY(str);
        if (fY == null) {
            return null;
        }
        if (this.hGD == null) {
            this.hGD = new HashMap<>();
            bKo();
            if (this.hGD.size() > 0) {
                return this.hGD.get(fY);
            }
            return null;
        }
        return this.hGD.get(fY);
    }

    public void bKo() {
        if (this.hGD == null) {
            this.hGD = new HashMap<>();
        } else {
            this.hGD.clear();
        }
        File file = new File(c.hEd);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hGD.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String fY;
        if (!TextUtils.isEmpty(str2) && (fY = ar.fY(str2)) != null) {
            if (this.hGE != null) {
                d.Mj().u(this.hGE.getUrl(), true);
            }
            File file = new File(c.hEd);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hEd + fY + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hGE != null && downloadData2.getUrl().equals(b.this.hGE.getUrl())) {
                            b.this.hGE = null;
                        }
                        if (aVar != null) {
                            aVar.bJy();
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
                        if (b.this.hGE != null && downloadData2.getUrl().equals(b.this.hGE.getUrl())) {
                            b.this.hGE = null;
                        }
                        if (aVar != null) {
                            b.this.hGD.put(downloadData2.getPath().substring(c.hEd.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cT(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hGE != null && downloadData2.getUrl().equals(b.this.hGE.getUrl())) {
                        b.this.hGE = null;
                    }
                    if (aVar != null) {
                        aVar.wS(str3);
                    }
                }
            });
            this.hGE = downloadData;
            d.Mj().f(downloadData);
        }
    }
}
