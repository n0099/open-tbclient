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
public class b {
    private static volatile b noo;
    private HashMap<String, String> noj;
    private DownloadData nok;

    /* loaded from: classes23.dex */
    public interface a {
        void TG(String str);

        void dOD();

        void gw(String str, String str2);
    }

    private b() {
    }

    public static b dPm() {
        if (noo == null) {
            synchronized (b.class) {
                if (noo == null) {
                    noo = new b();
                }
            }
        }
        return noo;
    }

    public String TN(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.noj == null) {
            this.noj = new HashMap<>();
            dPn();
            if (this.noj.size() > 0) {
                return this.noj.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.noj.get(nameMd5FromUrl);
    }

    public void dPn() {
        if (this.noj == null) {
            this.noj = new HashMap<>();
        } else {
            this.noj.clear();
        }
        File file = new File(c.nlP);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.noj.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nok != null) {
                d.bzt().cancelDownLoadByUrl(this.nok.getUrl(), true);
            }
            File file = new File(c.nlP);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nlP + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nok != null && downloadData2.getUrl().equals(b.this.nok.getUrl())) {
                            b.this.nok = null;
                        }
                        if (aVar != null) {
                            aVar.dOD();
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
                        if (b.this.nok != null && downloadData2.getUrl().equals(b.this.nok.getUrl())) {
                            b.this.nok = null;
                        }
                        if (aVar != null) {
                            b.this.noj.put(downloadData2.getPath().substring(c.nlP.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gw(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nok != null && downloadData2.getUrl().equals(b.this.nok.getUrl())) {
                        b.this.nok = null;
                    }
                    if (aVar != null) {
                        aVar.TG(str3);
                    }
                }
            });
            this.nok = downloadData;
            d.bzt().f(downloadData);
        }
    }
}
