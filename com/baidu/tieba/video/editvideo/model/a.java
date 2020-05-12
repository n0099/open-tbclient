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
    private static volatile a ljn;
    private HashMap<String, String> ljo;
    private DownloadData ljp;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0683a {
        void LG(String str);

        void daF();

        void eW(String str, String str2);
    }

    private a() {
    }

    public static a dbo() {
        if (ljn == null) {
            synchronized (a.class) {
                if (ljn == null) {
                    ljn = new a();
                }
            }
        }
        return ljn;
    }

    public String LO(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljo == null) {
            this.ljo = new HashMap<>();
            dbp();
            if (this.ljo.size() > 0) {
                return this.ljo.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.ljo.get(nameMd5FromUrl);
    }

    public void dbp() {
        if (this.ljo == null) {
            this.ljo = new HashMap<>();
        } else {
            this.ljo.clear();
        }
        File file = new File(c.lgS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.ljo.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0683a interfaceC0683a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.ljp != null) {
                if (!str2.equals(this.ljp.getUrl())) {
                    d.aWJ().cancelDownLoadByUrl(this.ljp.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.lgS);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lgS + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.ljp != null && downloadData2.getUrl().equals(a.this.ljp.getUrl())) {
                            a.this.ljp = null;
                        }
                        if (interfaceC0683a != null) {
                            interfaceC0683a.daF();
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
                        if (a.this.ljp != null && downloadData2.getUrl().equals(a.this.ljp.getUrl())) {
                            a.this.ljp = null;
                        }
                        if (interfaceC0683a != null) {
                            a.this.ljo.put(downloadData2.getPath().substring(c.lgS.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0683a.eW(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.ljp != null && downloadData2.getUrl().equals(a.this.ljp.getUrl())) {
                        a.this.ljp = null;
                    }
                    if (interfaceC0683a != null) {
                        interfaceC0683a.LG(str3);
                    }
                }
            });
            this.ljp = downloadData;
            d.aWJ().f(downloadData);
        }
    }

    public void dbq() {
        if (this.ljp != null) {
            d.aWJ().cancelDownLoadByUrl(this.ljp.getUrl(), true);
        }
    }
}
