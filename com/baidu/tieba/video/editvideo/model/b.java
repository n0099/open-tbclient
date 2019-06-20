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
    private static volatile b jpY;
    private HashMap<String, String> jpT;
    private DownloadData jpU;

    /* loaded from: classes5.dex */
    public interface a {
        void EQ(String str);

        void crc();

        void er(String str, String str2);
    }

    private b() {
    }

    public static b crP() {
        if (jpY == null) {
            synchronized (b.class) {
                if (jpY == null) {
                    jpY = new b();
                }
            }
        }
        return jpY;
    }

    public String EZ(String str) {
        String nS = as.nS(str);
        if (nS == null) {
            return null;
        }
        if (this.jpT == null) {
            this.jpT = new HashMap<>();
            crQ();
            if (this.jpT.size() > 0) {
                return this.jpT.get(nS);
            }
            return null;
        }
        return this.jpT.get(nS);
    }

    public void crQ() {
        if (this.jpT == null) {
            this.jpT = new HashMap<>();
        } else {
            this.jpT.clear();
        }
        File file = new File(c.jnu);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jpT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final a aVar) {
        String nS;
        if (!TextUtils.isEmpty(str2) && (nS = as.nS(str2)) != null) {
            if (this.jpU != null) {
                d.aqM().Q(this.jpU.getUrl(), true);
            }
            File file = new File(c.jnu);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(18);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jnu + nS + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.b.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (b.this.jpU != null && downloadData2.getUrl().equals(b.this.jpU.getUrl())) {
                            b.this.jpU = null;
                        }
                        if (aVar != null) {
                            aVar.crc();
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
                        if (b.this.jpU != null && downloadData2.getUrl().equals(b.this.jpU.getUrl())) {
                            b.this.jpU = null;
                        }
                        if (aVar != null) {
                            b.this.jpT.put(downloadData2.getPath().substring(c.jnu.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            aVar.er(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (b.this.jpU != null && downloadData2.getUrl().equals(b.this.jpU.getUrl())) {
                        b.this.jpU = null;
                    }
                    if (aVar != null) {
                        aVar.EQ(str3);
                    }
                }
            });
            this.jpU = downloadData;
            d.aqM().f(downloadData);
        }
    }
}
