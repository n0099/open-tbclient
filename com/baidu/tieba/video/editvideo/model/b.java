package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes17.dex */
public class b {
    private static volatile b mwu;
    private HashMap<String, String> mwp;
    private DownloadData mwq;

    /* loaded from: classes17.dex */
    public interface a {
        void RC(String str);

        void dBn();

        void fY(String str, String str2);
    }

    private b() {
    }

    public static b dBW() {
        if (mwu == null) {
            synchronized (b.class) {
                if (mwu == null) {
                    mwu = new b();
                }
            }
        }
        return mwu;
    }

    public String RJ(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mwp == null) {
            this.mwp = new HashMap<>();
            dBX();
            if (this.mwp.size() > 0) {
                return this.mwp.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.mwp.get(nameMd5FromUrl);
    }

    public void dBX() {
        if (this.mwp == null) {
            this.mwp = new HashMap<>();
        } else {
            this.mwp.clear();
        }
        File file = new File(c.mtU);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.mwp.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.mwq != null) {
                d.brs().cancelDownLoadByUrl(this.mwq.getUrl(), true);
            }
            File file = new File(c.mtU);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mtU + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.mwq != null && downloadData2.getUrl().equals(b.this.mwq.getUrl())) {
                            b.this.mwq = null;
                        }
                        if (aVar != null) {
                            aVar.dBn();
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
                        if (b.this.mwq != null && downloadData2.getUrl().equals(b.this.mwq.getUrl())) {
                            b.this.mwq = null;
                        }
                        if (aVar != null) {
                            b.this.mwp.put(downloadData2.getPath().substring(c.mtU.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.fY(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.mwq != null && downloadData2.getUrl().equals(b.this.mwq.getUrl())) {
                        b.this.mwq = null;
                    }
                    if (aVar != null) {
                        aVar.RC(str3);
                    }
                }
            });
            this.mwq = downloadData;
            d.brs().f(downloadData);
        }
    }
}
