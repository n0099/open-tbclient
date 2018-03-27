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
    private static volatile b hqI;
    private HashMap<String, String> hqD;
    private DownloadData hqE;

    /* loaded from: classes2.dex */
    public interface a {
        void bAW();

        void cj(String str, String str2);

        void tE(String str);
    }

    private b() {
    }

    public static b bBL() {
        if (hqI == null) {
            synchronized (b.class) {
                if (hqI == null) {
                    hqI = new b();
                }
            }
        }
        return hqI;
    }

    public String tO(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqD == null) {
            this.hqD = new HashMap<>();
            bBM();
            if (this.hqD.size() > 0) {
                return this.hqD.get(eu);
            }
            return null;
        }
        return this.hqD.get(eu);
    }

    public void bBM() {
        if (this.hqD == null) {
            this.hqD = new HashMap<>();
        } else {
            this.hqD.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hod);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hqD.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String eu;
        if (!TextUtils.isEmpty(str2) && (eu = ap.eu(str2)) != null) {
            if (this.hqE != null) {
                e.KU().n(this.hqE.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.hod);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hod + eu + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hqE != null && downloadData2.getUrl().equals(b.this.hqE.getUrl())) {
                            b.this.hqE = null;
                        }
                        if (aVar != null) {
                            aVar.bAW();
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
                        if (b.this.hqE != null && downloadData2.getUrl().equals(b.this.hqE.getUrl())) {
                            b.this.hqE = null;
                        }
                        if (aVar != null) {
                            b.this.hqD.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hod.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
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
                    if (b.this.hqE != null && downloadData2.getUrl().equals(b.this.hqE.getUrl())) {
                        b.this.hqE = null;
                    }
                    if (aVar != null) {
                        aVar.tE(str3);
                    }
                }
            });
            this.hqE = downloadData;
            e.KU().f(downloadData);
        }
    }
}
