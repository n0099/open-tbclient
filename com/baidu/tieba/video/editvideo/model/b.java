package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b jyK;
    private HashMap<String, String> jyF;
    private DownloadData jyG;

    /* loaded from: classes5.dex */
    public interface a {
        void EH(String str);

        void csK();

        void ef(String str, String str2);
    }

    private b() {
    }

    public static b cty() {
        if (jyK == null) {
            synchronized (b.class) {
                if (jyK == null) {
                    jyK = new b();
                }
            }
        }
        return jyK;
    }

    public String EQ(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.jyF == null) {
            this.jyF = new HashMap<>();
            ctz();
            if (this.jyF.size() > 0) {
                return this.jyF.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.jyF.get(nameMd5FromUrl);
    }

    public void ctz() {
        if (this.jyF == null) {
            this.jyF = new HashMap<>();
        } else {
            this.jyF.clear();
        }
        File file = new File(c.jwf);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jyF.put(file2.getName().substring(0, file2.getName().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.jyG != null) {
                d.atT().cancelDownLoadByUrl(this.jyG.getUrl(), true);
            }
            File file = new File(c.jwf);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jwf + nameMd5FromUrl + (DefaultConfig.TOKEN_SEPARATOR + str2.substring(str2.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.jyG != null && downloadData2.getUrl().equals(b.this.jyG.getUrl())) {
                            b.this.jyG = null;
                        }
                        if (aVar != null) {
                            aVar.csK();
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
                        if (b.this.jyG != null && downloadData2.getUrl().equals(b.this.jyG.getUrl())) {
                            b.this.jyG = null;
                        }
                        if (aVar != null) {
                            b.this.jyF.put(downloadData2.getPath().substring(c.jwf.length(), downloadData2.getPath().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), downloadData2.getPath());
                            aVar.ef(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.jyG != null && downloadData2.getUrl().equals(b.this.jyG.getUrl())) {
                        b.this.jyG = null;
                    }
                    if (aVar != null) {
                        aVar.EH(str3);
                    }
                }
            });
            this.jyG = downloadData;
            d.atT().f(downloadData);
        }
    }
}
