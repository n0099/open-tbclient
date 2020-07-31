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
    private static volatile b meq;
    private HashMap<String, String> mek;
    private DownloadData mel;

    /* loaded from: classes17.dex */
    public interface a {
        void OE(String str);

        void dpI();

        void fG(String str, String str2);
    }

    private b() {
    }

    public static b dqr() {
        if (meq == null) {
            synchronized (b.class) {
                if (meq == null) {
                    meq = new b();
                }
            }
        }
        return meq;
    }

    public String OL(String str) {
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mek == null) {
            this.mek = new HashMap<>();
            dqs();
            if (this.mek.size() > 0) {
                return this.mek.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.mek.get(nameMd5FromUrl);
    }

    public void dqs() {
        if (this.mek == null) {
            this.mek = new HashMap<>();
        } else {
            this.mek.clear();
        }
        File file = new File(c.mbP);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.mek.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = au.getNameMd5FromUrl(str2)) != null) {
            if (this.mel != null) {
                d.biF().cancelDownLoadByUrl(this.mel.getUrl(), true);
            }
            File file = new File(c.mbP);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mbP + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.mel != null && downloadData2.getUrl().equals(b.this.mel.getUrl())) {
                            b.this.mel = null;
                        }
                        if (aVar != null) {
                            aVar.dpI();
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
                        if (b.this.mel != null && downloadData2.getUrl().equals(b.this.mel.getUrl())) {
                            b.this.mel = null;
                        }
                        if (aVar != null) {
                            b.this.mek.put(downloadData2.getPath().substring(c.mbP.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (b.this.mel != null && downloadData2.getUrl().equals(b.this.mel.getUrl())) {
                        b.this.mel = null;
                    }
                    if (aVar != null) {
                        aVar.OE(str3);
                    }
                }
            });
            this.mel = downloadData;
            d.biF().f(downloadData);
        }
    }
}
