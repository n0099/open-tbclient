package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class b {
    private static volatile b nit;
    private HashMap<String, String> nio;
    private DownloadData nip;

    /* loaded from: classes23.dex */
    public interface a {
        void Tp(String str);

        void dMb();

        void gw(String str, String str2);
    }

    private b() {
    }

    public static b dMK() {
        if (nit == null) {
            synchronized (b.class) {
                if (nit == null) {
                    nit = new b();
                }
            }
        }
        return nit;
    }

    public String Tw(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nio == null) {
            this.nio = new HashMap<>();
            dML();
            if (this.nio.size() > 0) {
                return this.nio.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nio.get(nameMd5FromUrl);
    }

    public void dML() {
        if (this.nio == null) {
            this.nio = new HashMap<>();
        } else {
            this.nio.clear();
        }
        File file = new File(c.nfT);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nio.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nip != null) {
                d.bwU().cancelDownLoadByUrl(this.nip.getUrl(), true);
            }
            File file = new File(c.nfT);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nfT + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nip != null && downloadData2.getUrl().equals(b.this.nip.getUrl())) {
                            b.this.nip = null;
                        }
                        if (aVar != null) {
                            aVar.dMb();
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
                        if (b.this.nip != null && downloadData2.getUrl().equals(b.this.nip.getUrl())) {
                            b.this.nip = null;
                        }
                        if (aVar != null) {
                            b.this.nio.put(downloadData2.getPath().substring(c.nfT.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gw(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nip != null && downloadData2.getUrl().equals(b.this.nip.getUrl())) {
                        b.this.nip = null;
                    }
                    if (aVar != null) {
                        aVar.Tp(str3);
                    }
                }
            });
            this.nip = downloadData;
            d.bwU().f(downloadData);
        }
    }
}
