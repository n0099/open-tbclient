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
    private static volatile a hCj;
    private HashMap<String, String> hCk;
    private DownloadData hCl;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0325a {
        void bHZ();

        void cR(String str, String str2);

        void wz(String str);
    }

    private a() {
    }

    public static a bIL() {
        if (hCj == null) {
            synchronized (a.class) {
                if (hCj == null) {
                    hCj = new a();
                }
            }
        }
        return hCj;
    }

    public String wH(String str) {
        String fK = ar.fK(str);
        if (fK == null) {
            return null;
        }
        if (this.hCk == null) {
            this.hCk = new HashMap<>();
            bIM();
            if (this.hCk.size() > 0) {
                return this.hCk.get(fK);
            }
            return null;
        }
        return this.hCk.get(fK);
    }

    public void bIM() {
        if (this.hCk == null) {
            this.hCk = new HashMap<>();
        } else {
            this.hCk.clear();
        }
        File file = new File(c.hzG);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hCk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0325a interfaceC0325a) {
        String fK;
        if (!TextUtils.isEmpty(str2) && (fK = ar.fK(str2)) != null) {
            if (this.hCl != null) {
                if (!str2.equals(this.hCl.getUrl())) {
                    d.LR().u(this.hCl.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hzG);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hzG + fK + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hCl != null && downloadData2.getUrl().equals(a.this.hCl.getUrl())) {
                            a.this.hCl = null;
                        }
                        if (interfaceC0325a != null) {
                            interfaceC0325a.bHZ();
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
                        if (a.this.hCl != null && downloadData2.getUrl().equals(a.this.hCl.getUrl())) {
                            a.this.hCl = null;
                        }
                        if (interfaceC0325a != null) {
                            a.this.hCk.put(downloadData2.getPath().substring(c.hzG.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (a.this.hCl != null && downloadData2.getUrl().equals(a.this.hCl.getUrl())) {
                        a.this.hCl = null;
                    }
                    if (interfaceC0325a != null) {
                        interfaceC0325a.wz(str3);
                    }
                }
            });
            this.hCl = downloadData;
            d.LR().f(downloadData);
        }
    }

    public void bIN() {
        if (this.hCl != null) {
            d.LR().u(this.hCl.getUrl(), true);
        }
    }
}
