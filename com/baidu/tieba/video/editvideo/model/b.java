package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b hel;
    private HashMap<String, String> heg;
    private DownloadData heh;

    /* loaded from: classes2.dex */
    public interface a {
        void bAr();

        void cr(String str, String str2);

        void uC(String str);
    }

    private b() {
    }

    public static b bBg() {
        if (hel == null) {
            synchronized (b.class) {
                if (hel == null) {
                    hel = new b();
                }
            }
        }
        return hel;
    }

    public String uM(String str) {
        String eM = as.eM(str);
        if (eM == null) {
            return null;
        }
        if (this.heg == null) {
            this.heg = new HashMap<>();
            bBh();
            if (this.heg.size() > 0) {
                return this.heg.get(eM);
            }
            return null;
        }
        return this.heg.get(eM);
    }

    public void bBh() {
        if (this.heg == null) {
            this.heg = new HashMap<>();
        } else {
            this.heg.clear();
        }
        File file = new File(c.hbF);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.heg.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String eM;
        if (!TextUtils.isEmpty(str2) && (eM = as.eM(str2)) != null) {
            if (this.heh != null) {
                d.Hn().k(this.heh.getUrl(), true);
            }
            File file = new File(c.hbF);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hbF + eM + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.heh != null && downloadData2.getUrl().equals(b.this.heh.getUrl())) {
                            b.this.heh = null;
                        }
                        if (aVar != null) {
                            aVar.bAr();
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
                        if (b.this.heh != null && downloadData2.getUrl().equals(b.this.heh.getUrl())) {
                            b.this.heh = null;
                        }
                        if (aVar != null) {
                            b.this.heg.put(downloadData2.getPath().substring(c.hbF.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cr(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.heh != null && downloadData2.getUrl().equals(b.this.heh.getUrl())) {
                        b.this.heh = null;
                    }
                    if (aVar != null) {
                        aVar.uC(str3);
                    }
                }
            });
            this.heh = downloadData;
            d.Hn().f(downloadData);
        }
    }
}
