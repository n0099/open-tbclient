package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes17.dex */
public class b {
    private static volatile b mes;
    private HashMap<String, String> men;
    private DownloadData meo;

    /* loaded from: classes17.dex */
    public interface a {
        void OE(String str);

        void dpJ();

        void fG(String str, String str2);
    }

    private b() {
    }

    public static b dqs() {
        if (mes == null) {
            synchronized (b.class) {
                if (mes == null) {
                    mes = new b();
                }
            }
        }
        return mes;
    }

    public String OL(String str) {
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.men == null) {
            this.men = new HashMap<>();
            dqt();
            if (this.men.size() > 0) {
                return this.men.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.men.get(nameMd5FromUrl);
    }

    public void dqt() {
        if (this.men == null) {
            this.men = new HashMap<>();
        } else {
            this.men.clear();
        }
        File file = new File(c.mbR);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.men.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = au.getNameMd5FromUrl(str2)) != null) {
            if (this.meo != null) {
                d.biF().cancelDownLoadByUrl(this.meo.getUrl(), true);
            }
            File file = new File(c.mbR);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mbR + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.meo != null && downloadData2.getUrl().equals(b.this.meo.getUrl())) {
                            b.this.meo = null;
                        }
                        if (aVar != null) {
                            aVar.dpJ();
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
                        if (b.this.meo != null && downloadData2.getUrl().equals(b.this.meo.getUrl())) {
                            b.this.meo = null;
                        }
                        if (aVar != null) {
                            b.this.men.put(downloadData2.getPath().substring(c.mbR.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.fG(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.meo != null && downloadData2.getUrl().equals(b.this.meo.getUrl())) {
                        b.this.meo = null;
                    }
                    if (aVar != null) {
                        aVar.OE(str3);
                    }
                }
            });
            this.meo = downloadData;
            d.biF().f(downloadData);
        }
    }
}
