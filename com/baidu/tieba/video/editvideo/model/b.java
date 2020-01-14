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
public class b {
    private static volatile b kwk;
    private HashMap<String, String> kwf;
    private DownloadData kwg;

    /* loaded from: classes8.dex */
    public interface a {
        void JG(String str);

        void cNT();

        void eA(String str, String str2);
    }

    private b() {
    }

    public static b cOG() {
        if (kwk == null) {
            synchronized (b.class) {
                if (kwk == null) {
                    kwk = new b();
                }
            }
        }
        return kwk;
    }

    public String JO(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kwf == null) {
            this.kwf = new HashMap<>();
            cOH();
            if (this.kwf.size() > 0) {
                return this.kwf.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kwf.get(nameMd5FromUrl);
    }

    public void cOH() {
        if (this.kwf == null) {
            this.kwf = new HashMap<>();
        } else {
            this.kwf.clear();
        }
        File file = new File(c.ktQ);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kwf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kwg != null) {
                d.aLR().cancelDownLoadByUrl(this.kwg.getUrl(), true);
            }
            File file = new File(c.ktQ);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.ktQ + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.kwg != null && downloadData2.getUrl().equals(b.this.kwg.getUrl())) {
                            b.this.kwg = null;
                        }
                        if (aVar != null) {
                            aVar.cNT();
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
                        if (b.this.kwg != null && downloadData2.getUrl().equals(b.this.kwg.getUrl())) {
                            b.this.kwg = null;
                        }
                        if (aVar != null) {
                            b.this.kwf.put(downloadData2.getPath().substring(c.ktQ.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.eA(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.kwg != null && downloadData2.getUrl().equals(b.this.kwg.getUrl())) {
                        b.this.kwg = null;
                    }
                    if (aVar != null) {
                        aVar.JG(str3);
                    }
                }
            });
            this.kwg = downloadData;
            d.aLR().f(downloadData);
        }
    }
}
