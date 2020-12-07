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
    private static volatile a nDs;
    private HashMap<String, String> nDt;
    private DownloadData nDu;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0879a {
        void UG(String str);

        void dTU();

        void gB(String str, String str2);
    }

    private a() {
    }

    public static a dUA() {
        if (nDs == null) {
            synchronized (a.class) {
                if (nDs == null) {
                    nDs = new a();
                }
            }
        }
        return nDs;
    }

    public String UM(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nDt == null) {
            this.nDt = new HashMap<>();
            dUB();
            if (this.nDt.size() > 0) {
                return this.nDt.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nDt.get(nameMd5FromUrl);
    }

    public void dUB() {
        if (this.nDt == null) {
            this.nDt = new HashMap<>();
        } else {
            this.nDt.clear();
        }
        File file = new File(c.nAV);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nDt.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0879a interfaceC0879a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nDu != null) {
                if (!str2.equals(this.nDu.getUrl())) {
                    d.bCj().cancelDownLoadByUrl(this.nDu.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nAV);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nAV + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nDu != null && downloadData2.getUrl().equals(a.this.nDu.getUrl())) {
                            a.this.nDu = null;
                        }
                        if (interfaceC0879a != null) {
                            interfaceC0879a.dTU();
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
                        if (a.this.nDu != null && downloadData2.getUrl().equals(a.this.nDu.getUrl())) {
                            a.this.nDu = null;
                        }
                        if (interfaceC0879a != null) {
                            a.this.nDt.put(downloadData2.getPath().substring(c.nAV.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (a.this.nDu != null && downloadData2.getUrl().equals(a.this.nDu.getUrl())) {
                        a.this.nDu = null;
                    }
                    if (interfaceC0879a != null) {
                        interfaceC0879a.UG(str3);
                    }
                }
            });
            this.nDu = downloadData;
            d.bCj().f(downloadData);
        }
    }

    public void dUC() {
        if (this.nDu != null) {
            d.bCj().cancelDownLoadByUrl(this.nDu.getUrl(), true);
        }
    }
}
