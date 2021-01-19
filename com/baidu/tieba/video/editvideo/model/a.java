package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    private static volatile a nCU;
    private HashMap<String, String> nCV;
    private DownloadData nCW;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0883a {
        void Tf(String str);

        void dPV();

        void gx(String str, String str2);
    }

    private a() {
    }

    public static a dQB() {
        if (nCU == null) {
            synchronized (a.class) {
                if (nCU == null) {
                    nCU = new a();
                }
            }
        }
        return nCU;
    }

    public String Tl(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nCV == null) {
            this.nCV = new HashMap<>();
            dQC();
            if (this.nCV.size() > 0) {
                return this.nCV.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nCV.get(nameMd5FromUrl);
    }

    public void dQC() {
        if (this.nCV == null) {
            this.nCV = new HashMap<>();
        } else {
            this.nCV.clear();
        }
        File file = new File(c.nAA);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nCV.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0883a interfaceC0883a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nCW != null) {
                if (!str2.equals(this.nCW.getUrl())) {
                    d.bAL().cancelDownLoadByUrl(this.nCW.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nAA);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nAA + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nCW != null && downloadData2.getUrl().equals(a.this.nCW.getUrl())) {
                            a.this.nCW = null;
                        }
                        if (interfaceC0883a != null) {
                            interfaceC0883a.dPV();
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
                        if (a.this.nCW != null && downloadData2.getUrl().equals(a.this.nCW.getUrl())) {
                            a.this.nCW = null;
                        }
                        if (interfaceC0883a != null) {
                            a.this.nCV.put(downloadData2.getPath().substring(c.nAA.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0883a.gx(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nCW != null && downloadData2.getUrl().equals(a.this.nCW.getUrl())) {
                        a.this.nCW = null;
                    }
                    if (interfaceC0883a != null) {
                        interfaceC0883a.Tf(str3);
                    }
                }
            });
            this.nCW = downloadData;
            d.bAL().f(downloadData);
        }
    }

    public void dQD() {
        if (this.nCW != null) {
            d.bAL().cancelDownLoadByUrl(this.nCW.getUrl(), true);
        }
    }
}
