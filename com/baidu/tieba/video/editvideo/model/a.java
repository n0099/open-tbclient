package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private static volatile a nNe;
    private HashMap<String, String> nNf;
    private DownloadData nNg;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0888a {
        void Uo(String str);

        void dSo();

        void gF(String str, String str2);
    }

    private a() {
    }

    public static a dSU() {
        if (nNe == null) {
            synchronized (a.class) {
                if (nNe == null) {
                    nNe = new a();
                }
            }
        }
        return nNe;
    }

    public String Uu(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nNf == null) {
            this.nNf = new HashMap<>();
            dSV();
            if (this.nNf.size() > 0) {
                return this.nNf.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nNf.get(nameMd5FromUrl);
    }

    public void dSV() {
        if (this.nNf == null) {
            this.nNf = new HashMap<>();
        } else {
            this.nNf.clear();
        }
        File file = new File(c.nKK);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nNf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0888a interfaceC0888a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nNg != null) {
                if (!str2.equals(this.nNg.getUrl())) {
                    d.bBd().cancelDownLoadByUrl(this.nNg.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nKK);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nKK + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nNg != null && downloadData2.getUrl().equals(a.this.nNg.getUrl())) {
                            a.this.nNg = null;
                        }
                        if (interfaceC0888a != null) {
                            interfaceC0888a.dSo();
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
                        if (a.this.nNg != null && downloadData2.getUrl().equals(a.this.nNg.getUrl())) {
                            a.this.nNg = null;
                        }
                        if (interfaceC0888a != null) {
                            a.this.nNf.put(downloadData2.getPath().substring(c.nKK.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0888a.gF(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nNg != null && downloadData2.getUrl().equals(a.this.nNg.getUrl())) {
                        a.this.nNg = null;
                    }
                    if (interfaceC0888a != null) {
                        interfaceC0888a.Uo(str3);
                    }
                }
            });
            this.nNg = downloadData;
            d.bBd().f(downloadData);
        }
    }

    public void dSW() {
        if (this.nNg != null) {
            d.bBd().cancelDownLoadByUrl(this.nNg.getUrl(), true);
        }
    }
}
