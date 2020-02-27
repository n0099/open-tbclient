package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static volatile b kxf;
    private HashMap<String, String> kxa;
    private DownloadData kxb;

    /* loaded from: classes10.dex */
    public interface a {
        void JT(String str);

        void cPo();

        void eJ(String str, String str2);
    }

    private b() {
    }

    public static b cPZ() {
        if (kxf == null) {
            synchronized (b.class) {
                if (kxf == null) {
                    kxf = new b();
                }
            }
        }
        return kxf;
    }

    public String Kb(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxa == null) {
            this.kxa = new HashMap<>();
            cQa();
            if (this.kxa.size() > 0) {
                return this.kxa.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kxa.get(nameMd5FromUrl);
    }

    public void cQa() {
        if (this.kxa == null) {
            this.kxa = new HashMap<>();
        } else {
            this.kxa.clear();
        }
        File file = new File(c.kuN);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kxa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kxb != null) {
                d.aOn().cancelDownLoadByUrl(this.kxb.getUrl(), true);
            }
            File file = new File(c.kuN);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kuN + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.kxb != null && downloadData2.getUrl().equals(b.this.kxb.getUrl())) {
                            b.this.kxb = null;
                        }
                        if (aVar != null) {
                            aVar.cPo();
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
                        if (b.this.kxb != null && downloadData2.getUrl().equals(b.this.kxb.getUrl())) {
                            b.this.kxb = null;
                        }
                        if (aVar != null) {
                            b.this.kxa.put(downloadData2.getPath().substring(c.kuN.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.eJ(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.kxb != null && downloadData2.getUrl().equals(b.this.kxb.getUrl())) {
                        b.this.kxb = null;
                    }
                    if (aVar != null) {
                        aVar.JT(str3);
                    }
                }
            });
            this.kxb = downloadData;
            d.aOn().f(downloadData);
        }
    }
}
