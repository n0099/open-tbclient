package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.c;
import com.baidu.tieba.video.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static volatile b lWZ;
    private HashMap<String, String> lWU;
    private DownloadData lWV;

    /* loaded from: classes10.dex */
    public interface a {
        void NW(String str);

        void dmx();

        void fE(String str, String str2);
    }

    private b() {
    }

    public static b dnh() {
        if (lWZ == null) {
            synchronized (b.class) {
                if (lWZ == null) {
                    lWZ = new b();
                }
            }
        }
        return lWZ;
    }

    public String Od(String str) {
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lWU == null) {
            this.lWU = new HashMap<>();
            dni();
            if (this.lWU.size() > 0) {
                return this.lWU.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lWU.get(nameMd5FromUrl);
    }

    public void dni() {
        if (this.lWU == null) {
            this.lWU = new HashMap<>();
        } else {
            this.lWU.clear();
        }
        File file = new File(d.lUz);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lWU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = at.getNameMd5FromUrl(str2)) != null) {
            if (this.lWV != null) {
                com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWV.getUrl(), true);
            }
            File file = new File(d.lUz);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(d.lUz + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.lWV != null && downloadData2.getUrl().equals(b.this.lWV.getUrl())) {
                            b.this.lWV = null;
                        }
                        if (aVar != null) {
                            aVar.dmx();
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
                        if (b.this.lWV != null && downloadData2.getUrl().equals(b.this.lWV.getUrl())) {
                            b.this.lWV = null;
                        }
                        if (aVar != null) {
                            b.this.lWU.put(downloadData2.getPath().substring(d.lUz.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.fE(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.lWV != null && downloadData2.getUrl().equals(b.this.lWV.getUrl())) {
                        b.this.lWV = null;
                    }
                    if (aVar != null) {
                        aVar.NW(str3);
                    }
                }
            });
            this.lWV = downloadData;
            com.baidu.tbadk.download.d.beW().f(downloadData);
        }
    }
}
