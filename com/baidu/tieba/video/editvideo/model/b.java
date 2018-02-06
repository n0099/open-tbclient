package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b hqx;
    private HashMap<String, String> hqs;
    private DownloadData hqt;

    /* loaded from: classes2.dex */
    public interface a {
        void bAS();

        void cj(String str, String str2);

        void tE(String str);
    }

    private b() {
    }

    public static b bBH() {
        if (hqx == null) {
            synchronized (b.class) {
                if (hqx == null) {
                    hqx = new b();
                }
            }
        }
        return hqx;
    }

    public String tO(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqs == null) {
            this.hqs = new HashMap<>();
            bBI();
            if (this.hqs.size() > 0) {
                return this.hqs.get(eu);
            }
            return null;
        }
        return this.hqs.get(eu);
    }

    public void bBI() {
        if (this.hqs == null) {
            this.hqs = new HashMap<>();
        } else {
            this.hqs.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hnS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hqs.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String eu;
        if (!TextUtils.isEmpty(str2) && (eu = ap.eu(str2)) != null) {
            if (this.hqt != null) {
                e.KU().o(this.hqt.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.hnS);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hnS + eu + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hqt != null && downloadData2.getUrl().equals(b.this.hqt.getUrl())) {
                            b.this.hqt = null;
                        }
                        if (aVar != null) {
                            aVar.bAS();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (b.this.hqt != null && downloadData2.getUrl().equals(b.this.hqt.getUrl())) {
                            b.this.hqt = null;
                        }
                        if (aVar != null) {
                            b.this.hqs.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hnS.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
                            aVar.cj(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hqt != null && downloadData2.getUrl().equals(b.this.hqt.getUrl())) {
                        b.this.hqt = null;
                    }
                    if (aVar != null) {
                        aVar.tE(str3);
                    }
                }
            });
            this.hqt = downloadData;
            e.KU().f(downloadData);
        }
    }
}
