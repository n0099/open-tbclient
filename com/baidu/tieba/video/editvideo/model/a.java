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
    private static volatile a nHz;
    private HashMap<String, String> nHA;
    private DownloadData nHB;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0862a {
        void Un(String str);

        void dTM();

        void gy(String str, String str2);
    }

    private a() {
    }

    public static a dUs() {
        if (nHz == null) {
            synchronized (a.class) {
                if (nHz == null) {
                    nHz = new a();
                }
            }
        }
        return nHz;
    }

    public String Ut(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nHA == null) {
            this.nHA = new HashMap<>();
            dUt();
            if (this.nHA.size() > 0) {
                return this.nHA.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nHA.get(nameMd5FromUrl);
    }

    public void dUt() {
        if (this.nHA == null) {
            this.nHA = new HashMap<>();
        } else {
            this.nHA.clear();
        }
        File file = new File(c.nFf);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nHA.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0862a interfaceC0862a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nHB != null) {
                if (!str2.equals(this.nHB.getUrl())) {
                    d.bEE().cancelDownLoadByUrl(this.nHB.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nFf);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nFf + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nHB != null && downloadData2.getUrl().equals(a.this.nHB.getUrl())) {
                            a.this.nHB = null;
                        }
                        if (interfaceC0862a != null) {
                            interfaceC0862a.dTM();
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
                        if (a.this.nHB != null && downloadData2.getUrl().equals(a.this.nHB.getUrl())) {
                            a.this.nHB = null;
                        }
                        if (interfaceC0862a != null) {
                            a.this.nHA.put(downloadData2.getPath().substring(c.nFf.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0862a.gy(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nHB != null && downloadData2.getUrl().equals(a.this.nHB.getUrl())) {
                        a.this.nHB = null;
                    }
                    if (interfaceC0862a != null) {
                        interfaceC0862a.Un(str3);
                    }
                }
            });
            this.nHB = downloadData;
            d.bEE().f(downloadData);
        }
    }

    public void dUu() {
        if (this.nHB != null) {
            d.bEE().cancelDownLoadByUrl(this.nHB.getUrl(), true);
        }
    }
}
