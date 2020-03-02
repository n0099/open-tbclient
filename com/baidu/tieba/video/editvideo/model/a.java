package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    private static volatile a kxb;
    private HashMap<String, String> kxc;
    private DownloadData kxd;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0620a {
        void JT(String str);

        void cPq();

        void eJ(String str, String str2);
    }

    private a() {
    }

    public static a cPY() {
        if (kxb == null) {
            synchronized (a.class) {
                if (kxb == null) {
                    kxb = new a();
                }
            }
        }
        return kxb;
    }

    public String Ka(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxc == null) {
            this.kxc = new HashMap<>();
            cPZ();
            if (this.kxc.size() > 0) {
                return this.kxc.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kxc.get(nameMd5FromUrl);
    }

    public void cPZ() {
        if (this.kxc == null) {
            this.kxc = new HashMap<>();
        } else {
            this.kxc.clear();
        }
        File file = new File(c.kuL);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kxc.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0620a interfaceC0620a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kxd != null) {
                if (!str2.equals(this.kxd.getUrl())) {
                    d.aOp().cancelDownLoadByUrl(this.kxd.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.kuL);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kuL + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.kxd != null && downloadData2.getUrl().equals(a.this.kxd.getUrl())) {
                            a.this.kxd = null;
                        }
                        if (interfaceC0620a != null) {
                            interfaceC0620a.cPq();
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
                        if (a.this.kxd != null && downloadData2.getUrl().equals(a.this.kxd.getUrl())) {
                            a.this.kxd = null;
                        }
                        if (interfaceC0620a != null) {
                            a.this.kxc.put(downloadData2.getPath().substring(c.kuL.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0620a.eJ(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.kxd != null && downloadData2.getUrl().equals(a.this.kxd.getUrl())) {
                        a.this.kxd = null;
                    }
                    if (interfaceC0620a != null) {
                        interfaceC0620a.JT(str3);
                    }
                }
            });
            this.kxd = downloadData;
            d.aOp().f(downloadData);
        }
    }

    public void cQa() {
        if (this.kxd != null) {
            d.aOp().cancelDownLoadByUrl(this.kxd.getUrl(), true);
        }
    }
}
