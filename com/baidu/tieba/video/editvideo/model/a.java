package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class a {
    private static volatile a noi;
    private HashMap<String, String> noj;
    private DownloadData nok;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0860a {
        void TG(String str);

        void dOD();

        void gw(String str, String str2);
    }

    private a() {
    }

    public static a dPj() {
        if (noi == null) {
            synchronized (a.class) {
                if (noi == null) {
                    noi = new a();
                }
            }
        }
        return noi;
    }

    public String TM(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.noj == null) {
            this.noj = new HashMap<>();
            dPk();
            if (this.noj.size() > 0) {
                return this.noj.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.noj.get(nameMd5FromUrl);
    }

    public void dPk() {
        if (this.noj == null) {
            this.noj = new HashMap<>();
        } else {
            this.noj.clear();
        }
        File file = new File(c.nlL);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.noj.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0860a interfaceC0860a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nok != null) {
                if (!str2.equals(this.nok.getUrl())) {
                    d.bzt().cancelDownLoadByUrl(this.nok.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nlL);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nlL + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.nok != null && downloadData2.getUrl().equals(a.this.nok.getUrl())) {
                            a.this.nok = null;
                        }
                        if (interfaceC0860a != null) {
                            interfaceC0860a.dOD();
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
                        if (a.this.nok != null && downloadData2.getUrl().equals(a.this.nok.getUrl())) {
                            a.this.nok = null;
                        }
                        if (interfaceC0860a != null) {
                            a.this.noj.put(downloadData2.getPath().substring(c.nlL.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0860a.gw(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.nok != null && downloadData2.getUrl().equals(a.this.nok.getUrl())) {
                        a.this.nok = null;
                    }
                    if (interfaceC0860a != null) {
                        interfaceC0860a.TG(str3);
                    }
                }
            });
            this.nok = downloadData;
            d.bzt().f(downloadData);
        }
    }

    public void dPl() {
        if (this.nok != null) {
            d.bzt().cancelDownLoadByUrl(this.nok.getUrl(), true);
        }
    }
}
