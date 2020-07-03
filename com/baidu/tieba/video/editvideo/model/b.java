package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.c;
import com.baidu.tieba.video.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static volatile b lWW;
    private HashMap<String, String> lWR;
    private DownloadData lWS;

    /* loaded from: classes10.dex */
    public interface a {
        void NV(String str);

        void dmt();

        void fE(String str, String str2);
    }

    private b() {
    }

    public static b dnd() {
        if (lWW == null) {
            synchronized (b.class) {
                if (lWW == null) {
                    lWW = new b();
                }
            }
        }
        return lWW;
    }

    public String Oc(String str) {
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lWR == null) {
            this.lWR = new HashMap<>();
            dne();
            if (this.lWR.size() > 0) {
                return this.lWR.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.lWR.get(nameMd5FromUrl);
    }

    public void dne() {
        if (this.lWR == null) {
            this.lWR = new HashMap<>();
        } else {
            this.lWR.clear();
        }
        File file = new File(d.lUw);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.lWR.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = at.getNameMd5FromUrl(str2)) != null) {
            if (this.lWS != null) {
                com.baidu.tbadk.download.d.beW().cancelDownLoadByUrl(this.lWS.getUrl(), true);
            }
            File file = new File(d.lUw);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(d.lUw + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.lWS != null && downloadData2.getUrl().equals(b.this.lWS.getUrl())) {
                            b.this.lWS = null;
                        }
                        if (aVar != null) {
                            aVar.dmt();
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
                        if (b.this.lWS != null && downloadData2.getUrl().equals(b.this.lWS.getUrl())) {
                            b.this.lWS = null;
                        }
                        if (aVar != null) {
                            b.this.lWR.put(downloadData2.getPath().substring(d.lUw.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.fE(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.lWS != null && downloadData2.getUrl().equals(b.this.lWS.getUrl())) {
                        b.this.lWS = null;
                    }
                    if (aVar != null) {
                        aVar.NV(str3);
                    }
                }
            });
            this.lWS = downloadData;
            com.baidu.tbadk.download.d.beW().f(downloadData);
        }
    }
}
