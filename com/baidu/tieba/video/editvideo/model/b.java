package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static volatile b hcZ;
    private HashMap<String, String> hcU;
    private DownloadData hcV;

    /* loaded from: classes2.dex */
    public interface a {
        void bBG();

        void cu(String str, String str2);

        void uE(String str);
    }

    private b() {
    }

    public static b bCv() {
        if (hcZ == null) {
            synchronized (b.class) {
                if (hcZ == null) {
                    hcZ = new b();
                }
            }
        }
        return hcZ;
    }

    public String uO(String str) {
        String eO = as.eO(str);
        if (eO == null) {
            return null;
        }
        if (this.hcU == null) {
            this.hcU = new HashMap<>();
            bCw();
            if (this.hcU.size() > 0) {
                return this.hcU.get(eO);
            }
            return null;
        }
        return this.hcU.get(eO);
    }

    public void bCw() {
        if (this.hcU == null) {
            this.hcU = new HashMap<>();
        } else {
            this.hcU.clear();
        }
        File file = new File(com.baidu.tieba.video.b.has);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hcU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String eO;
        if (!TextUtils.isEmpty(str2) && (eO = as.eO(str2)) != null) {
            if (this.hcV != null) {
                e.Hr().l(this.hcV.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.has);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.has + eO + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.hcV != null && downloadData2.getUrl().equals(b.this.hcV.getUrl())) {
                            b.this.hcV = null;
                        }
                        if (aVar != null) {
                            aVar.bBG();
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
                        if (b.this.hcV != null && downloadData2.getUrl().equals(b.this.hcV.getUrl())) {
                            b.this.hcV = null;
                        }
                        if (aVar != null) {
                            b.this.hcU.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.has.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.cu(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.hcV != null && downloadData2.getUrl().equals(b.this.hcV.getUrl())) {
                        b.this.hcV = null;
                    }
                    if (aVar != null) {
                        aVar.uE(str3);
                    }
                }
            });
            this.hcV = downloadData;
            e.Hr().f(downloadData);
        }
    }
}
