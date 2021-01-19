package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static volatile b nDa;
    private HashMap<String, String> nCV;
    private DownloadData nCW;

    /* loaded from: classes7.dex */
    public interface a {
        void Tf(String str);

        void dPV();

        void gx(String str, String str2);
    }

    private b() {
    }

    public static b dQE() {
        if (nDa == null) {
            synchronized (b.class) {
                if (nDa == null) {
                    nDa = new b();
                }
            }
        }
        return nDa;
    }

    public String Tm(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nCV == null) {
            this.nCV = new HashMap<>();
            dQF();
            if (this.nCV.size() > 0) {
                return this.nCV.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nCV.get(nameMd5FromUrl);
    }

    public void dQF() {
        if (this.nCV == null) {
            this.nCV = new HashMap<>();
        } else {
            this.nCV.clear();
        }
        File file = new File(c.nAE);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nCV.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nCW != null) {
                d.bAL().cancelDownLoadByUrl(this.nCW.getUrl(), true);
            }
            File file = new File(c.nAE);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nAE + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nCW != null && downloadData2.getUrl().equals(b.this.nCW.getUrl())) {
                            b.this.nCW = null;
                        }
                        if (aVar != null) {
                            aVar.dPV();
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
                        if (b.this.nCW != null && downloadData2.getUrl().equals(b.this.nCW.getUrl())) {
                            b.this.nCW = null;
                        }
                        if (aVar != null) {
                            b.this.nCV.put(downloadData2.getPath().substring(c.nAE.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gx(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nCW != null && downloadData2.getUrl().equals(b.this.nCW.getUrl())) {
                        b.this.nCW = null;
                    }
                    if (aVar != null) {
                        aVar.Tf(str3);
                    }
                }
            });
            this.nCW = downloadData;
            d.bAL().f(downloadData);
        }
    }
}
