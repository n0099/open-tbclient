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
    private static volatile b hpi;
    private HashMap<String, String> hpd;
    private DownloadData hpe;

    /* loaded from: classes2.dex */
    public interface a {
        void bAi();

        void ch(String str, String str2);

        void tz(String str);
    }

    private b() {
    }

    public static b bAY() {
        if (hpi == null) {
            synchronized (b.class) {
                if (hpi == null) {
                    hpi = new b();
                }
            }
        }
        return hpi;
    }

    public String tJ(String str) {
        String ei = ao.ei(str);
        if (ei == null) {
            return null;
        }
        if (this.hpd == null) {
            this.hpd = new HashMap<>();
            bAZ();
            if (this.hpd.size() > 0) {
                return this.hpd.get(ei);
            }
            return null;
        }
        return this.hpd.get(ei);
    }

    public void bAZ() {
        if (this.hpd == null) {
            this.hpd = new HashMap<>();
        } else {
            this.hpd.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hmD);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hpd.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String ei;
        if (!TextUtils.isEmpty(str2) && (ei = ao.ei(str2)) != null) {
            if (this.hpe != null) {
                e.Ko().o(this.hpe.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.hmD);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hmD + ei + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hpe != null && downloadData2.getUrl().equals(b.this.hpe.getUrl())) {
                            b.this.hpe = null;
                        }
                        if (aVar != null) {
                            aVar.bAi();
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
                        if (b.this.hpe != null && downloadData2.getUrl().equals(b.this.hpe.getUrl())) {
                            b.this.hpe = null;
                        }
                        if (aVar != null) {
                            b.this.hpd.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hmD.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.ch(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hpe != null && downloadData2.getUrl().equals(b.this.hpe.getUrl())) {
                        b.this.hpe = null;
                    }
                    if (aVar != null) {
                        aVar.tz(str3);
                    }
                }
            });
            this.hpe = downloadData;
            e.Ko().f(downloadData);
        }
    }
}
