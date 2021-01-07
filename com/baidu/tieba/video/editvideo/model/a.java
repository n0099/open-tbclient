package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private static volatile a nHy;
    private DownloadData nHA;
    private HashMap<String, String> nHz;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0900a {
        void Um(String str);

        void dTN();

        void gy(String str, String str2);
    }

    private a() {
    }

    public static a dUt() {
        if (nHy == null) {
            synchronized (a.class) {
                if (nHy == null) {
                    nHy = new a();
                }
            }
        }
        return nHy;
    }

    public String Us(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nHz == null) {
            this.nHz = new HashMap<>();
            dUu();
            if (this.nHz.size() > 0) {
                return this.nHz.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nHz.get(nameMd5FromUrl);
    }

    public void dUu() {
        if (this.nHz == null) {
            this.nHz = new HashMap<>();
        } else {
            this.nHz.clear();
        }
        File file = new File(c.nFe);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nHz.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0900a interfaceC0900a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nHA != null) {
                if (!str2.equals(this.nHA.getUrl())) {
                    d.bEF().cancelDownLoadByUrl(this.nHA.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nFe);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nFe + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nHA != null && downloadData2.getUrl().equals(a.this.nHA.getUrl())) {
                            a.this.nHA = null;
                        }
                        if (interfaceC0900a != null) {
                            interfaceC0900a.dTN();
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
                        if (a.this.nHA != null && downloadData2.getUrl().equals(a.this.nHA.getUrl())) {
                            a.this.nHA = null;
                        }
                        if (interfaceC0900a != null) {
                            a.this.nHz.put(downloadData2.getPath().substring(c.nFe.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0900a.gy(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nHA != null && downloadData2.getUrl().equals(a.this.nHA.getUrl())) {
                        a.this.nHA = null;
                    }
                    if (interfaceC0900a != null) {
                        interfaceC0900a.Um(str3);
                    }
                }
            });
            this.nHA = downloadData;
            d.bEF().f(downloadData);
        }
    }

    public void dUv() {
        if (this.nHA != null) {
            d.bEF().cancelDownLoadByUrl(this.nHA.getUrl(), true);
        }
    }
}
