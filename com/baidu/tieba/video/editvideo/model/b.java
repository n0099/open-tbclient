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
public class b {
    private static volatile b ljt;
    private HashMap<String, String> ljo;
    private DownloadData ljp;

    /* loaded from: classes10.dex */
    public interface a {
        void LG(String str);

        void daF();

        void eW(String str, String str2);
    }

    private b() {
    }

    public static b dbr() {
        if (ljt == null) {
            synchronized (b.class) {
                if (ljt == null) {
                    ljt = new b();
                }
            }
        }
        return ljt;
    }

    public String LP(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljo == null) {
            this.ljo = new HashMap<>();
            dbs();
            if (this.ljo.size() > 0) {
                return this.ljo.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.ljo.get(nameMd5FromUrl);
    }

    public void dbs() {
        if (this.ljo == null) {
            this.ljo = new HashMap<>();
        } else {
            this.ljo.clear();
        }
        File file = new File(c.lgW);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.ljo.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.ljp != null) {
                d.aWJ().cancelDownLoadByUrl(this.ljp.getUrl(), true);
            }
            File file = new File(c.lgW);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lgW + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.ljp != null && downloadData2.getUrl().equals(b.this.ljp.getUrl())) {
                            b.this.ljp = null;
                        }
                        if (aVar != null) {
                            aVar.daF();
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
                        if (b.this.ljp != null && downloadData2.getUrl().equals(b.this.ljp.getUrl())) {
                            b.this.ljp = null;
                        }
                        if (aVar != null) {
                            b.this.ljo.put(downloadData2.getPath().substring(c.lgW.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.eW(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.ljp != null && downloadData2.getUrl().equals(b.this.ljp.getUrl())) {
                        b.this.ljp = null;
                    }
                    if (aVar != null) {
                        aVar.LG(str3);
                    }
                }
            });
            this.ljp = downloadData;
            d.aWJ().f(downloadData);
        }
    }
}
