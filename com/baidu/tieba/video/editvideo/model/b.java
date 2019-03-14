package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b iXj;
    private HashMap<String, String> iXe;
    private DownloadData iXf;

    /* loaded from: classes5.dex */
    public interface a {
        void Dt(String str);

        void ciY();

        void ec(String str, String str2);
    }

    private b() {
    }

    public static b cjN() {
        if (iXj == null) {
            synchronized (b.class) {
                if (iXj == null) {
                    iXj = new b();
                }
            }
        }
        return iXj;
    }

    public String DC(String str) {
        String mK = as.mK(str);
        if (mK == null) {
            return null;
        }
        if (this.iXe == null) {
            this.iXe = new HashMap<>();
            cjO();
            if (this.iXe.size() > 0) {
                return this.iXe.get(mK);
            }
            return null;
        }
        return this.iXe.get(mK);
    }

    public void cjO() {
        if (this.iXe == null) {
            this.iXe = new HashMap<>();
        } else {
            this.iXe.clear();
        }
        File file = new File(c.iUD);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.iXe.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String mK;
        if (!TextUtils.isEmpty(str2) && (mK = as.mK(str2)) != null) {
            if (this.iXf != null) {
                d.alM().O(this.iXf.getUrl(), true);
            }
            File file = new File(c.iUD);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.iUD + mK + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.iXf != null && downloadData2.getUrl().equals(b.this.iXf.getUrl())) {
                            b.this.iXf = null;
                        }
                        if (aVar != null) {
                            aVar.ciY();
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
                        if (b.this.iXf != null && downloadData2.getUrl().equals(b.this.iXf.getUrl())) {
                            b.this.iXf = null;
                        }
                        if (aVar != null) {
                            b.this.iXe.put(downloadData2.getPath().substring(c.iUD.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.ec(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.iXf != null && downloadData2.getUrl().equals(b.this.iXf.getUrl())) {
                        b.this.iXf = null;
                    }
                    if (aVar != null) {
                        aVar.Dt(str3);
                    }
                }
            });
            this.iXf = downloadData;
            d.alM().f(downloadData);
        }
    }
}
