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
    private static volatile b ljp;
    private HashMap<String, String> ljk;
    private DownloadData ljl;

    /* loaded from: classes10.dex */
    public interface a {
        void LD(String str);

        void daH();

        void eW(String str, String str2);
    }

    private b() {
    }

    public static b dbt() {
        if (ljp == null) {
            synchronized (b.class) {
                if (ljp == null) {
                    ljp = new b();
                }
            }
        }
        return ljp;
    }

    public String LM(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljk == null) {
            this.ljk = new HashMap<>();
            dbu();
            if (this.ljk.size() > 0) {
                return this.ljk.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.ljk.get(nameMd5FromUrl);
    }

    public void dbu() {
        if (this.ljk == null) {
            this.ljk = new HashMap<>();
        } else {
            this.ljk.clear();
        }
        File file = new File(c.lgS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.ljk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.ljl != null) {
                d.aWL().cancelDownLoadByUrl(this.ljl.getUrl(), true);
            }
            File file = new File(c.lgS);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lgS + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.ljl != null && downloadData2.getUrl().equals(b.this.ljl.getUrl())) {
                            b.this.ljl = null;
                        }
                        if (aVar != null) {
                            aVar.daH();
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
                        if (b.this.ljl != null && downloadData2.getUrl().equals(b.this.ljl.getUrl())) {
                            b.this.ljl = null;
                        }
                        if (aVar != null) {
                            b.this.ljk.put(downloadData2.getPath().substring(c.lgS.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.ljl != null && downloadData2.getUrl().equals(b.this.ljl.getUrl())) {
                        b.this.ljl = null;
                    }
                    if (aVar != null) {
                        aVar.LD(str3);
                    }
                }
            });
            this.ljl = downloadData;
            d.aWL().f(downloadData);
        }
    }
}
