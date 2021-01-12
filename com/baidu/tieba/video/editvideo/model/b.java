package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static volatile b nCZ;
    private HashMap<String, String> nCU;
    private DownloadData nCV;

    /* loaded from: classes7.dex */
    public interface a {
        void Te(String str);

        void dPV();

        void gx(String str, String str2);
    }

    private b() {
    }

    public static b dQE() {
        if (nCZ == null) {
            synchronized (b.class) {
                if (nCZ == null) {
                    nCZ = new b();
                }
            }
        }
        return nCZ;
    }

    public String Tl(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nCU == null) {
            this.nCU = new HashMap<>();
            dQF();
            if (this.nCU.size() > 0) {
                return this.nCU.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nCU.get(nameMd5FromUrl);
    }

    public void dQF() {
        if (this.nCU == null) {
            this.nCU = new HashMap<>();
        } else {
            this.nCU.clear();
        }
        File file = new File(c.nAD);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nCU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.nCV != null) {
                d.bAL().cancelDownLoadByUrl(this.nCV.getUrl(), true);
            }
            File file = new File(c.nAD);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nAD + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.nCV != null && downloadData2.getUrl().equals(b.this.nCV.getUrl())) {
                            b.this.nCV = null;
                        }
                        if (aVar != null) {
                            aVar.dPV();
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
                        if (b.this.nCV != null && downloadData2.getUrl().equals(b.this.nCV.getUrl())) {
                            b.this.nCV = null;
                        }
                        if (aVar != null) {
                            b.this.nCU.put(downloadData2.getPath().substring(c.nAD.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.gx(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.nCV != null && downloadData2.getUrl().equals(b.this.nCV.getUrl())) {
                        b.this.nCV = null;
                    }
                    if (aVar != null) {
                        aVar.Te(str3);
                    }
                }
            });
            this.nCV = downloadData;
            d.bAL().f(downloadData);
        }
    }
}
