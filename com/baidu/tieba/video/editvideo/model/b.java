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
    private static volatile b nMK;
    private HashMap<String, String> nMF;
    private DownloadData nMG;

    /* loaded from: classes8.dex */
    public interface a {
        void Uc(String str);

        void dSg();

        void gD(String str, String str2);
    }

    private b() {
    }

    public static b dSP() {
        if (nMK == null) {
            synchronized (b.class) {
                if (nMK == null) {
                    nMK = new b();
                }
            }
        }
        return nMK;
    }

    public String Uj(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nMF == null) {
            this.nMF = new HashMap<>();
            dSQ();
            if (this.nMF.size() > 0) {
                return this.nMF.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nMF.get(nameMd5FromUrl);
    }

    public void dSQ() {
        if (this.nMF == null) {
            this.nMF = new HashMap<>();
        } else {
            this.nMF.clear();
        }
        File file = new File(c.nKo);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nMF.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nMG != null) {
                d.bBd().cancelDownLoadByUrl(this.nMG.getUrl(), true);
            }
            File file = new File(c.nKo);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nKo + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nMG != null && downloadData2.getUrl().equals(b.this.nMG.getUrl())) {
                            b.this.nMG = null;
                        }
                        if (aVar != null) {
                            aVar.dSg();
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
                        if (b.this.nMG != null && downloadData2.getUrl().equals(b.this.nMG.getUrl())) {
                            b.this.nMG = null;
                        }
                        if (aVar != null) {
                            b.this.nMF.put(downloadData2.getPath().substring(c.nKo.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gD(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nMG != null && downloadData2.getUrl().equals(b.this.nMG.getUrl())) {
                        b.this.nMG = null;
                    }
                    if (aVar != null) {
                        aVar.Uc(str3);
                    }
                }
            });
            this.nMG = downloadData;
            d.bBd().f(downloadData);
        }
    }
}
