package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static volatile b ksC;
    private HashMap<String, String> ksx;
    private DownloadData ksy;

    /* loaded from: classes7.dex */
    public interface a {
        void Jw(String str);

        void cMM();

        void ey(String str, String str2);
    }

    private b() {
    }

    public static b cNz() {
        if (ksC == null) {
            synchronized (b.class) {
                if (ksC == null) {
                    ksC = new b();
                }
            }
        }
        return ksC;
    }

    public String JE(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ksx == null) {
            this.ksx = new HashMap<>();
            cNA();
            if (this.ksx.size() > 0) {
                return this.ksx.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.ksx.get(nameMd5FromUrl);
    }

    public void cNA() {
        if (this.ksx == null) {
            this.ksx = new HashMap<>();
        } else {
            this.ksx.clear();
        }
        File file = new File(c.kqi);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.ksx.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.ksy != null) {
                d.aLy().cancelDownLoadByUrl(this.ksy.getUrl(), true);
            }
            File file = new File(c.kqi);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kqi + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.ksy != null && downloadData2.getUrl().equals(b.this.ksy.getUrl())) {
                            b.this.ksy = null;
                        }
                        if (aVar != null) {
                            aVar.cMM();
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
                        if (b.this.ksy != null && downloadData2.getUrl().equals(b.this.ksy.getUrl())) {
                            b.this.ksy = null;
                        }
                        if (aVar != null) {
                            b.this.ksx.put(downloadData2.getPath().substring(c.kqi.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.ey(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.ksy != null && downloadData2.getUrl().equals(b.this.ksy.getUrl())) {
                        b.this.ksy = null;
                    }
                    if (aVar != null) {
                        aVar.Jw(str3);
                    }
                }
            });
            this.ksy = downloadData;
            d.aLy().f(downloadData);
        }
    }
}
