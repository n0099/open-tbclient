package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b hzl;
    private HashMap<String, String> hzg;
    private DownloadData hzh;

    /* loaded from: classes2.dex */
    public interface a {
        void bGJ();

        void co(String str, String str2);

        void tX(String str);
    }

    private b() {
    }

    public static b bHz() {
        if (hzl == null) {
            synchronized (b.class) {
                if (hzl == null) {
                    hzl = new b();
                }
            }
        }
        return hzl;
    }

    public String uh(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hzg == null) {
            this.hzg = new HashMap<>();
            bHA();
            if (this.hzg.size() > 0) {
                return this.hzg.get(ee);
            }
            return null;
        }
        return this.hzg.get(ee);
    }

    public void bHA() {
        if (this.hzg == null) {
            this.hzg = new HashMap<>();
        } else {
            this.hzg.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hwG);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hzg.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String ee;
        if (!TextUtils.isEmpty(str2) && (ee = ao.ee(str2)) != null) {
            if (this.hzh != null) {
                e.Kx().o(this.hzh.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.hwG);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hwG + ee + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hzh != null && downloadData2.getUrl().equals(b.this.hzh.getUrl())) {
                            b.this.hzh = null;
                        }
                        if (aVar != null) {
                            aVar.bGJ();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (b.this.hzh != null && downloadData2.getUrl().equals(b.this.hzh.getUrl())) {
                            b.this.hzh = null;
                        }
                        if (aVar != null) {
                            b.this.hzg.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hwG.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.co(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hzh != null && downloadData2.getUrl().equals(b.this.hzh.getUrl())) {
                        b.this.hzh = null;
                    }
                    if (aVar != null) {
                        aVar.tX(str3);
                    }
                }
            });
            this.hzh = downloadData;
            e.Kx().f(downloadData);
        }
    }
}
