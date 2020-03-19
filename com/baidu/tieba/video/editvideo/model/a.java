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
    private static volatile a kyS;
    private HashMap<String, String> kyT;
    private DownloadData kyU;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0621a {
        void JU(String str);

        void cPL();

        void eH(String str, String str2);
    }

    private a() {
    }

    public static a cQt() {
        if (kyS == null) {
            synchronized (a.class) {
                if (kyS == null) {
                    kyS = new a();
                }
            }
        }
        return kyS;
    }

    public String Kb(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kyT == null) {
            this.kyT = new HashMap<>();
            cQu();
            if (this.kyT.size() > 0) {
                return this.kyT.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kyT.get(nameMd5FromUrl);
    }

    public void cQu() {
        if (this.kyT == null) {
            this.kyT = new HashMap<>();
        } else {
            this.kyT.clear();
        }
        File file = new File(c.kwB);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kyT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0621a interfaceC0621a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kyU != null) {
                if (!str2.equals(this.kyU.getUrl())) {
                    d.aOu().cancelDownLoadByUrl(this.kyU.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.kwB);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kwB + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.kyU != null && downloadData2.getUrl().equals(a.this.kyU.getUrl())) {
                            a.this.kyU = null;
                        }
                        if (interfaceC0621a != null) {
                            interfaceC0621a.cPL();
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
                        if (a.this.kyU != null && downloadData2.getUrl().equals(a.this.kyU.getUrl())) {
                            a.this.kyU = null;
                        }
                        if (interfaceC0621a != null) {
                            a.this.kyT.put(downloadData2.getPath().substring(c.kwB.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0621a.eH(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.kyU != null && downloadData2.getUrl().equals(a.this.kyU.getUrl())) {
                        a.this.kyU = null;
                    }
                    if (interfaceC0621a != null) {
                        interfaceC0621a.JU(str3);
                    }
                }
            });
            this.kyU = downloadData;
            d.aOu().f(downloadData);
        }
    }

    public void cQv() {
        if (this.kyU != null) {
            d.aOu().cancelDownLoadByUrl(this.kyU.getUrl(), true);
        }
    }
}
