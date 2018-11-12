package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b hvd;
    private HashMap<String, String> huY;
    private DownloadData huZ;

    /* loaded from: classes5.dex */
    public interface a {
        void bFV();

        void cM(String str, String str2);

        void vW(String str);
    }

    private b() {
    }

    public static b bGK() {
        if (hvd == null) {
            synchronized (b.class) {
                if (hvd == null) {
                    hvd = new b();
                }
            }
        }
        return hvd;
    }

    public String wf(String str) {
        String fs = ar.fs(str);
        if (fs == null) {
            return null;
        }
        if (this.huY == null) {
            this.huY = new HashMap<>();
            bGL();
            if (this.huY.size() > 0) {
                return this.huY.get(fs);
            }
            return null;
        }
        return this.huY.get(fs);
    }

    public void bGL() {
        if (this.huY == null) {
            this.huY = new HashMap<>();
        } else {
            this.huY.clear();
        }
        File file = new File(c.hsy);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.huY.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String fs;
        if (!TextUtils.isEmpty(str2) && (fs = ar.fs(str2)) != null) {
            if (this.huZ != null) {
                d.KN().t(this.huZ.getUrl(), true);
            }
            File file = new File(c.hsy);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hsy + fs + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.huZ != null && downloadData2.getUrl().equals(b.this.huZ.getUrl())) {
                            b.this.huZ = null;
                        }
                        if (aVar != null) {
                            aVar.bFV();
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
                        if (b.this.huZ != null && downloadData2.getUrl().equals(b.this.huZ.getUrl())) {
                            b.this.huZ = null;
                        }
                        if (aVar != null) {
                            b.this.huY.put(downloadData2.getPath().substring(c.hsy.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cM(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.huZ != null && downloadData2.getUrl().equals(b.this.huZ.getUrl())) {
                        b.this.huZ = null;
                    }
                    if (aVar != null) {
                        aVar.vW(str3);
                    }
                }
            });
            this.huZ = downloadData;
            d.KN().f(downloadData);
        }
    }
}
