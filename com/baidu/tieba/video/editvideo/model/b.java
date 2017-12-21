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
    private static volatile b gSj;
    private HashMap<String, String> gSe;
    private DownloadData gSf;

    /* loaded from: classes2.dex */
    public interface a {
        void bBm();

        void cn(String str, String str2);

        void tW(String str);
    }

    private b() {
    }

    public static b bCc() {
        if (gSj == null) {
            synchronized (b.class) {
                if (gSj == null) {
                    gSj = new b();
                }
            }
        }
        return gSj;
    }

    public String ug(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gSe == null) {
            this.gSe = new HashMap<>();
            bCd();
            if (this.gSe.size() > 0) {
                return this.gSe.get(dX);
            }
            return null;
        }
        return this.gSe.get(dX);
    }

    public void bCd() {
        if (this.gSe == null) {
            this.gSe = new HashMap<>();
        } else {
            this.gSe.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gPI);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gSe.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String dX;
        if (!TextUtils.isEmpty(str2) && (dX = ao.dX(str2)) != null) {
            if (this.gSf != null) {
                e.CW().p(this.gSf.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gPI);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gPI + dX + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.gSf != null && downloadData2.getUrl().equals(b.this.gSf.getUrl())) {
                            b.this.gSf = null;
                        }
                        if (aVar != null) {
                            aVar.bBm();
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
                        if (b.this.gSf != null && downloadData2.getUrl().equals(b.this.gSf.getUrl())) {
                            b.this.gSf = null;
                        }
                        if (aVar != null) {
                            b.this.gSe.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gPI.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cn(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.gSf != null && downloadData2.getUrl().equals(b.this.gSf.getUrl())) {
                        b.this.gSf = null;
                    }
                    if (aVar != null) {
                        aVar.tW(str3);
                    }
                }
            });
            this.gSf = downloadData;
            e.CW().f(downloadData);
        }
    }
}
