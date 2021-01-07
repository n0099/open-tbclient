package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private static volatile b nHE;
    private DownloadData nHA;
    private HashMap<String, String> nHz;

    /* loaded from: classes8.dex */
    public interface a {
        void Um(String str);

        void dTN();

        void gy(String str, String str2);
    }

    private b() {
    }

    public static b dUw() {
        if (nHE == null) {
            synchronized (b.class) {
                if (nHE == null) {
                    nHE = new b();
                }
            }
        }
        return nHE;
    }

    public String Ut(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nHz == null) {
            this.nHz = new HashMap<>();
            dUx();
            if (this.nHz.size() > 0) {
                return this.nHz.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nHz.get(nameMd5FromUrl);
    }

    public void dUx() {
        if (this.nHz == null) {
            this.nHz = new HashMap<>();
        } else {
            this.nHz.clear();
        }
        File file = new File(c.nFi);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nHz.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nHA != null) {
                d.bEF().cancelDownLoadByUrl(this.nHA.getUrl(), true);
            }
            File file = new File(c.nFi);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nFi + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nHA != null && downloadData2.getUrl().equals(b.this.nHA.getUrl())) {
                            b.this.nHA = null;
                        }
                        if (aVar != null) {
                            aVar.dTN();
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
                        if (b.this.nHA != null && downloadData2.getUrl().equals(b.this.nHA.getUrl())) {
                            b.this.nHA = null;
                        }
                        if (aVar != null) {
                            b.this.nHz.put(downloadData2.getPath().substring(c.nFi.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gy(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nHA != null && downloadData2.getUrl().equals(b.this.nHA.getUrl())) {
                        b.this.nHA = null;
                    }
                    if (aVar != null) {
                        aVar.Um(str3);
                    }
                }
            });
            this.nHA = downloadData;
            d.bEF().f(downloadData);
        }
    }
}
