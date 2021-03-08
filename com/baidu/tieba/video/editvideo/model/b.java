package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static volatile b nPp;
    private HashMap<String, String> nPk;
    private DownloadData nPl;

    /* loaded from: classes7.dex */
    public interface a {
        void Uv(String str);

        void dSw();

        void gF(String str, String str2);
    }

    private b() {
    }

    public static b dTf() {
        if (nPp == null) {
            synchronized (b.class) {
                if (nPp == null) {
                    nPp = new b();
                }
            }
        }
        return nPp;
    }

    public String UC(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nPk == null) {
            this.nPk = new HashMap<>();
            dTg();
            if (this.nPk.size() > 0) {
                return this.nPk.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nPk.get(nameMd5FromUrl);
    }

    public void dTg() {
        if (this.nPk == null) {
            this.nPk = new HashMap<>();
        } else {
            this.nPk.clear();
        }
        File file = new File(c.nMT);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nPk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.nPl != null) {
                d.bBg().cancelDownLoadByUrl(this.nPl.getUrl(), true);
            }
            File file = new File(c.nMT);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nMT + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nPl != null && downloadData2.getUrl().equals(b.this.nPl.getUrl())) {
                            b.this.nPl = null;
                        }
                        if (aVar != null) {
                            aVar.dSw();
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
                        if (b.this.nPl != null && downloadData2.getUrl().equals(b.this.nPl.getUrl())) {
                            b.this.nPl = null;
                        }
                        if (aVar != null) {
                            b.this.nPk.put(downloadData2.getPath().substring(c.nMT.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gF(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nPl != null && downloadData2.getUrl().equals(b.this.nPl.getUrl())) {
                        b.this.nPl = null;
                    }
                    if (aVar != null) {
                        aVar.Uv(str3);
                    }
                }
            });
            this.nPl = downloadData;
            d.bBg().f(downloadData);
        }
    }
}
