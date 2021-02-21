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
public class b {
    private static volatile b nNk;
    private HashMap<String, String> nNf;
    private DownloadData nNg;

    /* loaded from: classes8.dex */
    public interface a {
        void Uo(String str);

        void dSo();

        void gF(String str, String str2);
    }

    private b() {
    }

    public static b dSX() {
        if (nNk == null) {
            synchronized (b.class) {
                if (nNk == null) {
                    nNk = new b();
                }
            }
        }
        return nNk;
    }

    public String Uv(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nNf == null) {
            this.nNf = new HashMap<>();
            dSY();
            if (this.nNf.size() > 0) {
                return this.nNf.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nNf.get(nameMd5FromUrl);
    }

    public void dSY() {
        if (this.nNf == null) {
            this.nNf = new HashMap<>();
        } else {
            this.nNf.clear();
        }
        File file = new File(c.nKO);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nNf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nNg != null) {
                d.bBd().cancelDownLoadByUrl(this.nNg.getUrl(), true);
            }
            File file = new File(c.nKO);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nKO + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nNg != null && downloadData2.getUrl().equals(b.this.nNg.getUrl())) {
                            b.this.nNg = null;
                        }
                        if (aVar != null) {
                            aVar.dSo();
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
                        if (b.this.nNg != null && downloadData2.getUrl().equals(b.this.nNg.getUrl())) {
                            b.this.nNg = null;
                        }
                        if (aVar != null) {
                            b.this.nNf.put(downloadData2.getPath().substring(c.nKO.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gF(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nNg != null && downloadData2.getUrl().equals(b.this.nNg.getUrl())) {
                        b.this.nNg = null;
                    }
                    if (aVar != null) {
                        aVar.Uo(str3);
                    }
                }
            });
            this.nNg = downloadData;
            d.bBd().f(downloadData);
        }
    }
}
