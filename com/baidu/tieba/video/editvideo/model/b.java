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
    private static volatile b kyY;
    private HashMap<String, String> kyT;
    private DownloadData kyU;

    /* loaded from: classes10.dex */
    public interface a {
        void JU(String str);

        void cPL();

        void eH(String str, String str2);
    }

    private b() {
    }

    public static b cQw() {
        if (kyY == null) {
            synchronized (b.class) {
                if (kyY == null) {
                    kyY = new b();
                }
            }
        }
        return kyY;
    }

    public String Kc(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kyT == null) {
            this.kyT = new HashMap<>();
            cQx();
            if (this.kyT.size() > 0) {
                return this.kyT.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kyT.get(nameMd5FromUrl);
    }

    public void cQx() {
        if (this.kyT == null) {
            this.kyT = new HashMap<>();
        } else {
            this.kyT.clear();
        }
        File file = new File(c.kwF);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kyT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kyU != null) {
                d.aOu().cancelDownLoadByUrl(this.kyU.getUrl(), true);
            }
            File file = new File(c.kwF);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kwF + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.kyU != null && downloadData2.getUrl().equals(b.this.kyU.getUrl())) {
                            b.this.kyU = null;
                        }
                        if (aVar != null) {
                            aVar.cPL();
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
                        if (b.this.kyU != null && downloadData2.getUrl().equals(b.this.kyU.getUrl())) {
                            b.this.kyU = null;
                        }
                        if (aVar != null) {
                            b.this.kyT.put(downloadData2.getPath().substring(c.kwF.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.eH(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.kyU != null && downloadData2.getUrl().equals(b.this.kyU.getUrl())) {
                        b.this.kyU = null;
                    }
                    if (aVar != null) {
                        aVar.JU(str3);
                    }
                }
            });
            this.kyU = downloadData;
            d.aOu().f(downloadData);
        }
    }
}
