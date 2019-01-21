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
public class a {
    private static volatile a hGC;
    private HashMap<String, String> hGD;
    private DownloadData hGE;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0324a {
        void bJy();

        void cT(String str, String str2);

        void wS(String str);
    }

    private a() {
    }

    public static a bKk() {
        if (hGC == null) {
            synchronized (a.class) {
                if (hGC == null) {
                    hGC = new a();
                }
            }
        }
        return hGC;
    }

    public String xa(String str) {
        String fY = ar.fY(str);
        if (fY == null) {
            return null;
        }
        if (this.hGD == null) {
            this.hGD = new HashMap<>();
            bKl();
            if (this.hGD.size() > 0) {
                return this.hGD.get(fY);
            }
            return null;
        }
        return this.hGD.get(fY);
    }

    public void bKl() {
        if (this.hGD == null) {
            this.hGD = new HashMap<>();
        } else {
            this.hGD.clear();
        }
        File file = new File(c.hDZ);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hGD.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0324a interfaceC0324a) {
        String fY;
        if (!TextUtils.isEmpty(str2) && (fY = ar.fY(str2)) != null) {
            if (this.hGE != null) {
                if (!str2.equals(this.hGE.getUrl())) {
                    d.Mj().u(this.hGE.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hDZ);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hDZ + fY + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hGE != null && downloadData2.getUrl().equals(a.this.hGE.getUrl())) {
                            a.this.hGE = null;
                        }
                        if (interfaceC0324a != null) {
                            interfaceC0324a.bJy();
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
                        if (a.this.hGE != null && downloadData2.getUrl().equals(a.this.hGE.getUrl())) {
                            a.this.hGE = null;
                        }
                        if (interfaceC0324a != null) {
                            a.this.hGD.put(downloadData2.getPath().substring(c.hDZ.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0324a.cT(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hGE != null && downloadData2.getUrl().equals(a.this.hGE.getUrl())) {
                        a.this.hGE = null;
                    }
                    if (interfaceC0324a != null) {
                        interfaceC0324a.wS(str3);
                    }
                }
            });
            this.hGE = downloadData;
            d.Mj().f(downloadData);
        }
    }

    public void bKm() {
        if (this.hGE != null) {
            d.Mj().u(this.hGE.getUrl(), true);
        }
    }
}
