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
    private static volatile b gSe;
    private HashMap<String, String> gRZ;
    private DownloadData gSa;

    /* loaded from: classes2.dex */
    public interface a {
        void bBm();

        void cn(String str, String str2);

        void tW(String str);
    }

    private b() {
    }

    public static b bCc() {
        if (gSe == null) {
            synchronized (b.class) {
                if (gSe == null) {
                    gSe = new b();
                }
            }
        }
        return gSe;
    }

    public String ug(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gRZ == null) {
            this.gRZ = new HashMap<>();
            bCd();
            if (this.gRZ.size() > 0) {
                return this.gRZ.get(dX);
            }
            return null;
        }
        return this.gRZ.get(dX);
    }

    public void bCd() {
        if (this.gRZ == null) {
            this.gRZ = new HashMap<>();
        } else {
            this.gRZ.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gPD);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gRZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String dX;
        if (!TextUtils.isEmpty(str2) && (dX = ao.dX(str2)) != null) {
            if (this.gSa != null) {
                e.CW().p(this.gSa.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gPD);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gPD + dX + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.gSa != null && downloadData2.getUrl().equals(b.this.gSa.getUrl())) {
                            b.this.gSa = null;
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
                        if (b.this.gSa != null && downloadData2.getUrl().equals(b.this.gSa.getUrl())) {
                            b.this.gSa = null;
                        }
                        if (aVar != null) {
                            b.this.gRZ.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gPD.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.gSa != null && downloadData2.getUrl().equals(b.this.gSa.getUrl())) {
                        b.this.gSa = null;
                    }
                    if (aVar != null) {
                        aVar.tW(str3);
                    }
                }
            });
            this.gSa = downloadData;
            e.CW().f(downloadData);
        }
    }
}
