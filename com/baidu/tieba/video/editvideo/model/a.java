package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.c;
import com.baidu.tieba.video.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    private static volatile a lWT;
    private HashMap<String, String> lWU;
    private DownloadData lWV;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0753a {
        void NW(String str);

        void dmx();

        void fE(String str, String str2);
    }

    private a() {
    }

    public static a dne() {
        if (lWT == null) {
            synchronized (a.class) {
                if (lWT == null) {
                    lWT = new a();
                }
            }
        }
        return lWT;
    }

    public String Oc(String str) {
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lWU == null) {
            this.lWU = new HashMap<>();
            dnf();
            if (this.lWU.size() > 0) {
                return this.lWU.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lWU.get(nameMd5FromUrl);
    }

    public void dnf() {
        if (this.lWU == null) {
            this.lWU = new HashMap<>();
        } else {
            this.lWU.clear();
        }
        File file = new File(d.lUv);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lWU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0753a interfaceC0753a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = at.getNameMd5FromUrl(str2)) != null) {
            if (this.lWV != null) {
                if (!str2.equals(this.lWV.getUrl())) {
                    com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWV.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(d.lUv);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(d.lUv + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.lWV != null && downloadData2.getUrl().equals(a.this.lWV.getUrl())) {
                            a.this.lWV = null;
                        }
                        if (interfaceC0753a != null) {
                            interfaceC0753a.dmx();
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
                        if (a.this.lWV != null && downloadData2.getUrl().equals(a.this.lWV.getUrl())) {
                            a.this.lWV = null;
                        }
                        if (interfaceC0753a != null) {
                            a.this.lWU.put(downloadData2.getPath().substring(d.lUv.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0753a.fE(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.lWV != null && downloadData2.getUrl().equals(a.this.lWV.getUrl())) {
                        a.this.lWV = null;
                    }
                    if (interfaceC0753a != null) {
                        interfaceC0753a.NW(str3);
                    }
                }
            });
            this.lWV = downloadData;
            com.baidu.tbadk.download.d.beW().f(downloadData);
        }
    }

    public void dng() {
        if (this.lWV != null) {
            com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWV.getUrl(), true);
        }
    }
}
