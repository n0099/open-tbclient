package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class b {
    private static volatile b npx;
    private HashMap<String, String> nps;
    private DownloadData npt;

    /* loaded from: classes22.dex */
    public interface a {
        void Tr(String str);

        void dOC();

        void gw(String str, String str2);
    }

    private b() {
    }

    public static b dPl() {
        if (npx == null) {
            synchronized (b.class) {
                if (npx == null) {
                    npx = new b();
                }
            }
        }
        return npx;
    }

    public String Ty(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nps == null) {
            this.nps = new HashMap<>();
            dPm();
            if (this.nps.size() > 0) {
                return this.nps.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nps.get(nameMd5FromUrl);
    }

    public void dPm() {
        if (this.nps == null) {
            this.nps = new HashMap<>();
        } else {
            this.nps.clear();
        }
        File file = new File(c.nmW);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nps.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.npt != null) {
                d.byJ().cancelDownLoadByUrl(this.npt.getUrl(), true);
            }
            File file = new File(c.nmW);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nmW + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.npt != null && downloadData2.getUrl().equals(b.this.npt.getUrl())) {
                            b.this.npt = null;
                        }
                        if (aVar != null) {
                            aVar.dOC();
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
                        if (b.this.npt != null && downloadData2.getUrl().equals(b.this.npt.getUrl())) {
                            b.this.npt = null;
                        }
                        if (aVar != null) {
                            b.this.nps.put(downloadData2.getPath().substring(c.nmW.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.npt != null && downloadData2.getUrl().equals(b.this.npt.getUrl())) {
                        b.this.npt = null;
                    }
                    if (aVar != null) {
                        aVar.Tr(str3);
                    }
                }
            });
            this.npt = downloadData;
            d.byJ().f(downloadData);
        }
    }
}
