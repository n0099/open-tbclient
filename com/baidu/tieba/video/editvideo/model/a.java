package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private static volatile a kvZ;
    private HashMap<String, String> kwa;
    private DownloadData kwb;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0612a {
        void JG(String str);

        void cNR();

        void eA(String str, String str2);
    }

    private a() {
    }

    public static a cOB() {
        if (kvZ == null) {
            synchronized (a.class) {
                if (kvZ == null) {
                    kvZ = new a();
                }
            }
        }
        return kvZ;
    }

    public String JN(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kwa == null) {
            this.kwa = new HashMap<>();
            cOC();
            if (this.kwa.size() > 0) {
                return this.kwa.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kwa.get(nameMd5FromUrl);
    }

    public void cOC() {
        if (this.kwa == null) {
            this.kwa = new HashMap<>();
        } else {
            this.kwa.clear();
        }
        File file = new File(c.ktH);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kwa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0612a interfaceC0612a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kwb != null) {
                if (!str2.equals(this.kwb.getUrl())) {
                    d.aLR().cancelDownLoadByUrl(this.kwb.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.ktH);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.ktH + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.kwb != null && downloadData2.getUrl().equals(a.this.kwb.getUrl())) {
                            a.this.kwb = null;
                        }
                        if (interfaceC0612a != null) {
                            interfaceC0612a.cNR();
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
                        if (a.this.kwb != null && downloadData2.getUrl().equals(a.this.kwb.getUrl())) {
                            a.this.kwb = null;
                        }
                        if (interfaceC0612a != null) {
                            a.this.kwa.put(downloadData2.getPath().substring(c.ktH.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0612a.eA(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.kwb != null && downloadData2.getUrl().equals(a.this.kwb.getUrl())) {
                        a.this.kwb = null;
                    }
                    if (interfaceC0612a != null) {
                        interfaceC0612a.JG(str3);
                    }
                }
            });
            this.kwb = downloadData;
            d.aLR().f(downloadData);
        }
    }

    public void cOD() {
        if (this.kwb != null) {
            d.aLR().cancelDownLoadByUrl(this.kwb.getUrl(), true);
        }
    }
}
