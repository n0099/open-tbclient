package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a heg;
    private HashMap<String, String> heh;
    private DownloadData hei;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0242a {
        void bAt();

        void cr(String str, String str2);

        void uG(String str);
    }

    private a() {
    }

    public static a bBf() {
        if (heg == null) {
            synchronized (a.class) {
                if (heg == null) {
                    heg = new a();
                }
            }
        }
        return heg;
    }

    public String uP(String str) {
        String eM = as.eM(str);
        if (eM == null) {
            return null;
        }
        if (this.heh == null) {
            this.heh = new HashMap<>();
            bBg();
            if (this.heh.size() > 0) {
                return this.heh.get(eM);
            }
            return null;
        }
        return this.heh.get(eM);
    }

    public void bBg() {
        if (this.heh == null) {
            this.heh = new HashMap<>();
        } else {
            this.heh.clear();
        }
        File file = new File(c.hbC);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.heh.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0242a interfaceC0242a) {
        String eM;
        if (!TextUtils.isEmpty(str2) && (eM = as.eM(str2)) != null) {
            if (this.hei != null) {
                if (!str2.equals(this.hei.getUrl())) {
                    d.Hn().k(this.hei.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hbC);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hbC + eM + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hei != null && downloadData2.getUrl().equals(a.this.hei.getUrl())) {
                            a.this.hei = null;
                        }
                        if (interfaceC0242a != null) {
                            interfaceC0242a.bAt();
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
                        if (a.this.hei != null && downloadData2.getUrl().equals(a.this.hei.getUrl())) {
                            a.this.hei = null;
                        }
                        if (interfaceC0242a != null) {
                            a.this.heh.put(downloadData2.getPath().substring(c.hbC.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0242a.cr(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hei != null && downloadData2.getUrl().equals(a.this.hei.getUrl())) {
                        a.this.hei = null;
                    }
                    if (interfaceC0242a != null) {
                        interfaceC0242a.uG(str3);
                    }
                }
            });
            this.hei = downloadData;
            d.Hn().f(downloadData);
        }
    }

    public void bBh() {
        if (this.hei != null) {
            d.Hn().k(this.hei.getUrl(), true);
        }
    }
}
