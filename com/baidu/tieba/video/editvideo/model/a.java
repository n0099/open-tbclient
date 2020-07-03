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
    private static volatile a lWQ;
    private HashMap<String, String> lWR;
    private DownloadData lWS;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0752a {
        void NV(String str);

        void dmt();

        void fE(String str, String str2);
    }

    private a() {
    }

    public static a dna() {
        if (lWQ == null) {
            synchronized (a.class) {
                if (lWQ == null) {
                    lWQ = new a();
                }
            }
        }
        return lWQ;
    }

    public String Ob(String str) {
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lWR == null) {
            this.lWR = new HashMap<>();
            dnb();
            if (this.lWR.size() > 0) {
                return this.lWR.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lWR.get(nameMd5FromUrl);
    }

    public void dnb() {
        if (this.lWR == null) {
            this.lWR = new HashMap<>();
        } else {
            this.lWR.clear();
        }
        File file = new File(d.lUs);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lWR.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0752a interfaceC0752a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = at.getNameMd5FromUrl(str2)) != null) {
            if (this.lWS != null) {
                if (!str2.equals(this.lWS.getUrl())) {
                    com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWS.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(d.lUs);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(d.lUs + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.lWS != null && downloadData2.getUrl().equals(a.this.lWS.getUrl())) {
                            a.this.lWS = null;
                        }
                        if (interfaceC0752a != null) {
                            interfaceC0752a.dmt();
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
                        if (a.this.lWS != null && downloadData2.getUrl().equals(a.this.lWS.getUrl())) {
                            a.this.lWS = null;
                        }
                        if (interfaceC0752a != null) {
                            a.this.lWR.put(downloadData2.getPath().substring(d.lUs.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0752a.fE(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.lWS != null && downloadData2.getUrl().equals(a.this.lWS.getUrl())) {
                        a.this.lWS = null;
                    }
                    if (interfaceC0752a != null) {
                        interfaceC0752a.NV(str3);
                    }
                }
            });
            this.lWS = downloadData;
            com.baidu.tbadk.download.d.beW().f(downloadData);
        }
    }

    public void dnc() {
        if (this.lWS != null) {
            com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWS.getUrl(), true);
        }
    }
}
