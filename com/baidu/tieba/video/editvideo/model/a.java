package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class a {
    private static volatile a nDu;
    private HashMap<String, String> nDv;
    private DownloadData nDw;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0879a {
        void UG(String str);

        void dTV();

        void gB(String str, String str2);
    }

    private a() {
    }

    public static a dUB() {
        if (nDu == null) {
            synchronized (a.class) {
                if (nDu == null) {
                    nDu = new a();
                }
            }
        }
        return nDu;
    }

    public String UM(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nDv == null) {
            this.nDv = new HashMap<>();
            dUC();
            if (this.nDv.size() > 0) {
                return this.nDv.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nDv.get(nameMd5FromUrl);
    }

    public void dUC() {
        if (this.nDv == null) {
            this.nDv = new HashMap<>();
        } else {
            this.nDv.clear();
        }
        File file = new File(c.nAX);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nDv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0879a interfaceC0879a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nDw != null) {
                if (!str2.equals(this.nDw.getUrl())) {
                    d.bCj().cancelDownLoadByUrl(this.nDw.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nAX);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nAX + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nDw != null && downloadData2.getUrl().equals(a.this.nDw.getUrl())) {
                            a.this.nDw = null;
                        }
                        if (interfaceC0879a != null) {
                            interfaceC0879a.dTV();
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
                        if (a.this.nDw != null && downloadData2.getUrl().equals(a.this.nDw.getUrl())) {
                            a.this.nDw = null;
                        }
                        if (interfaceC0879a != null) {
                            a.this.nDv.put(downloadData2.getPath().substring(c.nAX.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0879a.gB(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nDw != null && downloadData2.getUrl().equals(a.this.nDw.getUrl())) {
                        a.this.nDw = null;
                    }
                    if (interfaceC0879a != null) {
                        interfaceC0879a.UG(str3);
                    }
                }
            });
            this.nDw = downloadData;
            d.bCj().f(downloadData);
        }
    }

    public void dUD() {
        if (this.nDw != null) {
            d.bCj().cancelDownLoadByUrl(this.nDw.getUrl(), true);
        }
    }
}
