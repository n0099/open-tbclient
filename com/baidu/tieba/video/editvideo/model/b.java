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
    private static volatile b hGH;
    private HashMap<String, String> hGC;
    private DownloadData hGD;

    /* loaded from: classes5.dex */
    public interface a {
        void bJy();

        void cT(String str, String str2);

        void wS(String str);
    }

    private b() {
    }

    public static b bKn() {
        if (hGH == null) {
            synchronized (b.class) {
                if (hGH == null) {
                    hGH = new b();
                }
            }
        }
        return hGH;
    }

    public String xb(String str) {
        String fY = ar.fY(str);
        if (fY == null) {
            return null;
        }
        if (this.hGC == null) {
            this.hGC = new HashMap<>();
            bKo();
            if (this.hGC.size() > 0) {
                return this.hGC.get(fY);
            }
            return null;
        }
        return this.hGC.get(fY);
    }

    public void bKo() {
        if (this.hGC == null) {
            this.hGC = new HashMap<>();
        } else {
            this.hGC.clear();
        }
        File file = new File(c.hEc);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hGC.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String fY;
        if (!TextUtils.isEmpty(str2) && (fY = ar.fY(str2)) != null) {
            if (this.hGD != null) {
                d.Mj().u(this.hGD.getUrl(), true);
            }
            File file = new File(c.hEc);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hEc + fY + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hGD != null && downloadData2.getUrl().equals(b.this.hGD.getUrl())) {
                            b.this.hGD = null;
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
                        if (b.this.hGD != null && downloadData2.getUrl().equals(b.this.hGD.getUrl())) {
                            b.this.hGD = null;
                        }
                        if (aVar != null) {
                            b.this.hGC.put(downloadData2.getPath().substring(c.hEc.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.hGD != null && downloadData2.getUrl().equals(b.this.hGD.getUrl())) {
                        b.this.hGD = null;
                    }
                    if (aVar != null) {
                        aVar.wS(str3);
                    }
                }
            });
            this.hGD = downloadData;
            d.Mj().f(downloadData);
        }
    }
}
