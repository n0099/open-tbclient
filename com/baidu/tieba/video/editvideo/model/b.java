package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b iWX;
    private HashMap<String, String> iWS;
    private DownloadData iWT;

    /* loaded from: classes5.dex */
    public interface a {
        void Ds(String str);

        void ciW();

        void ed(String str, String str2);
    }

    private b() {
    }

    public static b cjL() {
        if (iWX == null) {
            synchronized (b.class) {
                if (iWX == null) {
                    iWX = new b();
                }
            }
        }
        return iWX;
    }

    public String DB(String str) {
        String mL = as.mL(str);
        if (mL == null) {
            return null;
        }
        if (this.iWS == null) {
            this.iWS = new HashMap<>();
            cjM();
            if (this.iWS.size() > 0) {
                return this.iWS.get(mL);
            }
            return null;
        }
        return this.iWS.get(mL);
    }

    public void cjM() {
        if (this.iWS == null) {
            this.iWS = new HashMap<>();
        } else {
            this.iWS.clear();
        }
        File file = new File(c.iUr);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.iWS.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String mL;
        if (!TextUtils.isEmpty(str2) && (mL = as.mL(str2)) != null) {
            if (this.iWT != null) {
                d.alJ().O(this.iWT.getUrl(), true);
            }
            File file = new File(c.iUr);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.iUr + mL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.iWT != null && downloadData2.getUrl().equals(b.this.iWT.getUrl())) {
                            b.this.iWT = null;
                        }
                        if (aVar != null) {
                            aVar.ciW();
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
                        if (b.this.iWT != null && downloadData2.getUrl().equals(b.this.iWT.getUrl())) {
                            b.this.iWT = null;
                        }
                        if (aVar != null) {
                            b.this.iWS.put(downloadData2.getPath().substring(c.iUr.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.ed(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.iWT != null && downloadData2.getUrl().equals(b.this.iWT.getUrl())) {
                        b.this.iWT = null;
                    }
                    if (aVar != null) {
                        aVar.Ds(str3);
                    }
                }
            });
            this.iWT = downloadData;
            d.alJ().f(downloadData);
        }
    }
}
