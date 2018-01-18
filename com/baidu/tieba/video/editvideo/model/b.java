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
    private static volatile b hoO;
    private HashMap<String, String> hoJ;
    private DownloadData hoK;

    /* loaded from: classes2.dex */
    public interface a {
        void bAg();

        void ci(String str, String str2);

        void ts(String str);
    }

    private b() {
    }

    public static b bAW() {
        if (hoO == null) {
            synchronized (b.class) {
                if (hoO == null) {
                    hoO = new b();
                }
            }
        }
        return hoO;
    }

    public String tC(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hoJ == null) {
            this.hoJ = new HashMap<>();
            bAX();
            if (this.hoJ.size() > 0) {
                return this.hoJ.get(ee);
            }
            return null;
        }
        return this.hoJ.get(ee);
    }

    public void bAX() {
        if (this.hoJ == null) {
            this.hoJ = new HashMap<>();
        } else {
            this.hoJ.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hmj);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hoJ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String ee;
        if (!TextUtils.isEmpty(str2) && (ee = ao.ee(str2)) != null) {
            if (this.hoK != null) {
                e.Km().o(this.hoK.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.hmj);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hmj + ee + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hoK != null && downloadData2.getUrl().equals(b.this.hoK.getUrl())) {
                            b.this.hoK = null;
                        }
                        if (aVar != null) {
                            aVar.bAg();
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
                        if (b.this.hoK != null && downloadData2.getUrl().equals(b.this.hoK.getUrl())) {
                            b.this.hoK = null;
                        }
                        if (aVar != null) {
                            b.this.hoJ.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hmj.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.ci(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hoK != null && downloadData2.getUrl().equals(b.this.hoK.getUrl())) {
                        b.this.hoK = null;
                    }
                    if (aVar != null) {
                        aVar.ts(str3);
                    }
                }
            });
            this.hoK = downloadData;
            e.Km().f(downloadData);
        }
    }
}
