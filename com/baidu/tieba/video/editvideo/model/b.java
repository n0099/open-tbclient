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
    private static volatile b lCe;
    private HashMap<String, String> lBZ;
    private DownloadData lCa;

    /* loaded from: classes10.dex */
    public interface a {
        void Nt(String str);

        void dhT();

        void fx(String str, String str2);
    }

    private b() {
    }

    public static b diF() {
        if (lCe == null) {
            synchronized (b.class) {
                if (lCe == null) {
                    lCe = new b();
                }
            }
        }
        return lCe;
    }

    public String NC(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lBZ == null) {
            this.lBZ = new HashMap<>();
            diG();
            if (this.lBZ.size() > 0) {
                return this.lBZ.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lBZ.get(nameMd5FromUrl);
    }

    public void diG() {
        if (this.lBZ == null) {
            this.lBZ = new HashMap<>();
        } else {
            this.lBZ.clear();
        }
        File file = new File(c.lzH);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lBZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.lCa != null) {
                d.bcT().cancelDownLoadByUrl(this.lCa.getUrl(), true);
            }
            File file = new File(c.lzH);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lzH + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.lCa != null && downloadData2.getUrl().equals(b.this.lCa.getUrl())) {
                            b.this.lCa = null;
                        }
                        if (aVar != null) {
                            aVar.dhT();
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
                        if (b.this.lCa != null && downloadData2.getUrl().equals(b.this.lCa.getUrl())) {
                            b.this.lCa = null;
                        }
                        if (aVar != null) {
                            b.this.lBZ.put(downloadData2.getPath().substring(c.lzH.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.fx(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.lCa != null && downloadData2.getUrl().equals(b.this.lCa.getUrl())) {
                        b.this.lCa = null;
                    }
                    if (aVar != null) {
                        aVar.Nt(str3);
                    }
                }
            });
            this.lCa = downloadData;
            d.bcT().f(downloadData);
        }
    }
}
