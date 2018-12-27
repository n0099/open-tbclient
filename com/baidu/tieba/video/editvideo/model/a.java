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
    private static volatile a hFu;
    private HashMap<String, String> hFv;
    private DownloadData hFw;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0325a {
        void bIP();

        void cR(String str, String str2);

        void wC(String str);
    }

    private a() {
    }

    public static a bJB() {
        if (hFu == null) {
            synchronized (a.class) {
                if (hFu == null) {
                    hFu = new a();
                }
            }
        }
        return hFu;
    }

    public String wK(String str) {
        String fL = ar.fL(str);
        if (fL == null) {
            return null;
        }
        if (this.hFv == null) {
            this.hFv = new HashMap<>();
            bJC();
            if (this.hFv.size() > 0) {
                return this.hFv.get(fL);
            }
            return null;
        }
        return this.hFv.get(fL);
    }

    public void bJC() {
        if (this.hFv == null) {
            this.hFv = new HashMap<>();
        } else {
            this.hFv.clear();
        }
        File file = new File(c.hCR);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hFv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0325a interfaceC0325a) {
        String fL;
        if (!TextUtils.isEmpty(str2) && (fL = ar.fL(str2)) != null) {
            if (this.hFw != null) {
                if (!str2.equals(this.hFw.getUrl())) {
                    d.LS().u(this.hFw.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hCR);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hCR + fL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hFw != null && downloadData2.getUrl().equals(a.this.hFw.getUrl())) {
                            a.this.hFw = null;
                        }
                        if (interfaceC0325a != null) {
                            interfaceC0325a.bIP();
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
                        if (a.this.hFw != null && downloadData2.getUrl().equals(a.this.hFw.getUrl())) {
                            a.this.hFw = null;
                        }
                        if (interfaceC0325a != null) {
                            a.this.hFv.put(downloadData2.getPath().substring(c.hCR.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0325a.cR(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hFw != null && downloadData2.getUrl().equals(a.this.hFw.getUrl())) {
                        a.this.hFw = null;
                    }
                    if (interfaceC0325a != null) {
                        interfaceC0325a.wC(str3);
                    }
                }
            });
            this.hFw = downloadData;
            d.LS().f(downloadData);
        }
    }

    public void bJD() {
        if (this.hFw != null) {
            d.LS().u(this.hFw.getUrl(), true);
        }
    }
}
