package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class b {
    private static volatile b nDA;
    private HashMap<String, String> nDv;
    private DownloadData nDw;

    /* loaded from: classes23.dex */
    public interface a {
        void UG(String str);

        void dTV();

        void gB(String str, String str2);
    }

    private b() {
    }

    public static b dUE() {
        if (nDA == null) {
            synchronized (b.class) {
                if (nDA == null) {
                    nDA = new b();
                }
            }
        }
        return nDA;
    }

    public String UN(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nDv == null) {
            this.nDv = new HashMap<>();
            dUF();
            if (this.nDv.size() > 0) {
                return this.nDv.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nDv.get(nameMd5FromUrl);
    }

    public void dUF() {
        if (this.nDv == null) {
            this.nDv = new HashMap<>();
        } else {
            this.nDv.clear();
        }
        File file = new File(c.nBb);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nDv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nDw != null) {
                d.bCj().cancelDownLoadByUrl(this.nDw.getUrl(), true);
            }
            File file = new File(c.nBb);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nBb + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nDw != null && downloadData2.getUrl().equals(b.this.nDw.getUrl())) {
                            b.this.nDw = null;
                        }
                        if (aVar != null) {
                            aVar.dTV();
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
                        if (b.this.nDw != null && downloadData2.getUrl().equals(b.this.nDw.getUrl())) {
                            b.this.nDw = null;
                        }
                        if (aVar != null) {
                            b.this.nDv.put(downloadData2.getPath().substring(c.nBb.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gB(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nDw != null && downloadData2.getUrl().equals(b.this.nDw.getUrl())) {
                        b.this.nDw = null;
                    }
                    if (aVar != null) {
                        aVar.UG(str3);
                    }
                }
            });
            this.nDw = downloadData;
            d.bCj().f(downloadData);
        }
    }
}
