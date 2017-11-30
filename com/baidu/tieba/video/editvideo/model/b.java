package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b gPv;
    private HashMap<String, String> gPq;
    private DownloadData gPr;

    /* loaded from: classes2.dex */
    public interface a {
        void bAF();

        void cm(String str, String str2);

        void tR(String str);
    }

    private b() {
    }

    public static b bBv() {
        if (gPv == null) {
            synchronized (b.class) {
                if (gPv == null) {
                    gPv = new b();
                }
            }
        }
        return gPv;
    }

    public String ub(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gPq == null) {
            this.gPq = new HashMap<>();
            bBw();
            if (this.gPq.size() > 0) {
                return this.gPq.get(dX);
            }
            return null;
        }
        return this.gPq.get(dX);
    }

    public void bBw() {
        if (this.gPq == null) {
            this.gPq = new HashMap<>();
        } else {
            this.gPq.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gMV);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gPq.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String dX;
        if (!TextUtils.isEmpty(str2) && (dX = ao.dX(str2)) != null) {
            if (this.gPr != null) {
                e.CV().o(this.gPr.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gMV);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gMV + dX + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.gPr != null && downloadData2.getUrl().equals(b.this.gPr.getUrl())) {
                            b.this.gPr = null;
                        }
                        if (aVar != null) {
                            aVar.bAF();
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
                        if (b.this.gPr != null && downloadData2.getUrl().equals(b.this.gPr.getUrl())) {
                            b.this.gPr = null;
                        }
                        if (aVar != null) {
                            b.this.gPq.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gMV.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cm(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.gPr != null && downloadData2.getUrl().equals(b.this.gPr.getUrl())) {
                        b.this.gPr = null;
                    }
                    if (aVar != null) {
                        aVar.tR(str3);
                    }
                }
            });
            this.gPr = downloadData;
            e.CV().f(downloadData);
        }
    }
}
