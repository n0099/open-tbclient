package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b gMs;
    private HashMap<String, String> gMn;
    private DownloadData gMo;

    /* loaded from: classes2.dex */
    public interface a {
        void bwb();

        void ci(String str, String str2);

        void tL(String str);
    }

    private b() {
    }

    public static b bwQ() {
        if (gMs == null) {
            synchronized (b.class) {
                if (gMs == null) {
                    gMs = new b();
                }
            }
        }
        return gMs;
    }

    public String tV(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gMn == null) {
            this.gMn = new HashMap<>();
            bwR();
            if (this.gMn.size() > 0) {
                return this.gMn.get(em);
            }
            return null;
        }
        return this.gMn.get(em);
    }

    public void bwR() {
        if (this.gMn == null) {
            this.gMn = new HashMap<>();
        } else {
            this.gMn.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gJL);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gMn.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String em;
        if (!TextUtils.isEmpty(str2) && (em = aq.em(str2)) != null) {
            if (this.gMo != null) {
                e.Dy().l(this.gMo.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gJL);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gJL + em + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.gMo != null && downloadData2.getUrl().equals(b.this.gMo.getUrl())) {
                            b.this.gMo = null;
                        }
                        if (aVar != null) {
                            aVar.bwb();
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
                        if (b.this.gMo != null && downloadData2.getUrl().equals(b.this.gMo.getUrl())) {
                            b.this.gMo = null;
                        }
                        if (aVar != null) {
                            b.this.gMn.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gJL.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
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
                    if (b.this.gMo != null && downloadData2.getUrl().equals(b.this.gMo.getUrl())) {
                        b.this.gMo = null;
                    }
                    if (aVar != null) {
                        aVar.tL(str3);
                    }
                }
            });
            this.gMo = downloadData;
            e.Dy().f(downloadData);
        }
    }
}
