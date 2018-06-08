package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b gYU;
    private HashMap<String, String> gYP;
    private DownloadData gYQ;

    /* loaded from: classes2.dex */
    public interface a {
        void bBg();

        void cq(String str, String str2);

        void uI(String str);
    }

    private b() {
    }

    public static b bBV() {
        if (gYU == null) {
            synchronized (b.class) {
                if (gYU == null) {
                    gYU = new b();
                }
            }
        }
        return gYU;
    }

    public String uS(String str) {
        String eL = ar.eL(str);
        if (eL == null) {
            return null;
        }
        if (this.gYP == null) {
            this.gYP = new HashMap<>();
            bBW();
            if (this.gYP.size() > 0) {
                return this.gYP.get(eL);
            }
            return null;
        }
        return this.gYP.get(eL);
    }

    public void bBW() {
        if (this.gYP == null) {
            this.gYP = new HashMap<>();
        } else {
            this.gYP.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gWn);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gYP.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String eL;
        if (!TextUtils.isEmpty(str2) && (eL = ar.eL(str2)) != null) {
            if (this.gYQ != null) {
                e.GZ().l(this.gYQ.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gWn);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gWn + eL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.gYQ != null && downloadData2.getUrl().equals(b.this.gYQ.getUrl())) {
                            b.this.gYQ = null;
                        }
                        if (aVar != null) {
                            aVar.bBg();
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
                        if (b.this.gYQ != null && downloadData2.getUrl().equals(b.this.gYQ.getUrl())) {
                            b.this.gYQ = null;
                        }
                        if (aVar != null) {
                            b.this.gYP.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gWn.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cq(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.gYQ != null && downloadData2.getUrl().equals(b.this.gYQ.getUrl())) {
                        b.this.gYQ = null;
                    }
                    if (aVar != null) {
                        aVar.uI(str3);
                    }
                }
            });
            this.gYQ = downloadData;
            e.GZ().f(downloadData);
        }
    }
}
