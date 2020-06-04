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
    private static volatile a lDh;
    private HashMap<String, String> lDi;
    private DownloadData lDj;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0737a {
        void Nu(String str);

        void dii();

        void fx(String str, String str2);
    }

    private a() {
    }

    public static a diR() {
        if (lDh == null) {
            synchronized (a.class) {
                if (lDh == null) {
                    lDh = new a();
                }
            }
        }
        return lDh;
    }

    public String NC(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lDi == null) {
            this.lDi = new HashMap<>();
            diS();
            if (this.lDi.size() > 0) {
                return this.lDi.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lDi.get(nameMd5FromUrl);
    }

    public void diS() {
        if (this.lDi == null) {
            this.lDi = new HashMap<>();
        } else {
            this.lDi.clear();
        }
        File file = new File(c.lAM);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lDi.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0737a interfaceC0737a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.lDj != null) {
                if (!str2.equals(this.lDj.getUrl())) {
                    d.bcU().cancelDownLoadByUrl(this.lDj.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.lAM);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lAM + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.lDj != null && downloadData2.getUrl().equals(a.this.lDj.getUrl())) {
                            a.this.lDj = null;
                        }
                        if (interfaceC0737a != null) {
                            interfaceC0737a.dii();
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
                        if (a.this.lDj != null && downloadData2.getUrl().equals(a.this.lDj.getUrl())) {
                            a.this.lDj = null;
                        }
                        if (interfaceC0737a != null) {
                            a.this.lDi.put(downloadData2.getPath().substring(c.lAM.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0737a.fx(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.lDj != null && downloadData2.getUrl().equals(a.this.lDj.getUrl())) {
                        a.this.lDj = null;
                    }
                    if (interfaceC0737a != null) {
                        interfaceC0737a.Nu(str3);
                    }
                }
            });
            this.lDj = downloadData;
            d.bcU().f(downloadData);
        }
    }

    public void diT() {
        if (this.lDj != null) {
            d.bcU().cancelDownLoadByUrl(this.lDj.getUrl(), true);
        }
    }
}
