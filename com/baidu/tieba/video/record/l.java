package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {
    public static final String hNa;
    private HashMap<String, String> hGC;
    private List<DownloadData> hNb;
    private a hNc;
    private String hNd;
    private com.baidu.tbadk.download.c hNe = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hNc != null && l.this.hNd.equals(downloadData.getUrl())) {
                    l.this.hNc.bJy();
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hNa)) {
                l.this.v(downloadData);
                if (l.this.hNc != null && l.this.hNd.equals(downloadData.getUrl())) {
                    l.this.hGC.put(downloadData.getPath().substring(l.hNa.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hNc.cT(l.this.hNd, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.v(downloadData);
            if (l.this.hNc != null && l.this.hNd.equals(downloadData.getUrl())) {
                l.this.hNc.wS(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void bJy();

        void cT(String str, String str2);

        void wS(String str);
    }

    static {
        hNa = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String xp(String str) {
        String fY = ar.fY(str);
        if (fY == null) {
            return null;
        }
        if (this.hGC == null) {
            this.hGC = new HashMap<>();
            bMt();
        }
        return this.hGC.get(fY);
    }

    public void bMt() {
        if (!StringUtils.isNull(hNa)) {
            if (this.hGC == null) {
                this.hGC = new HashMap<>();
            } else {
                this.hGC.clear();
            }
            File file = new File(hNa);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hGC.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void xq(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hNa)) {
            if (this.hNc != null) {
                this.hNc.wS("");
                return;
            }
            return;
        }
        String fY = ar.fY(str);
        if (fY != null) {
            File file = new File(hNa);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hNb == null) {
                this.hNb = new ArrayList();
            }
            if (!xr(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hNa + "/" + fY + str2);
                downloadData.setCallback(this.hNe);
                this.hNb.add(downloadData);
                com.baidu.tbadk.download.d.Mj().f(downloadData);
            }
        }
    }

    private boolean xr(String str) {
        if (v.I(this.hNb) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hNb) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.I(this.hNb) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hNb.size()) {
                    i = -1;
                    break;
                } else if (this.hNb.get(i) != null && this.hNb.get(i).getUrl() != null && this.hNb.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hNb.remove(i);
        }
    }

    public void a(a aVar) {
        this.hNc = aVar;
    }

    public void xs(String str) {
        if (str == null) {
            this.hNd = "";
        } else {
            this.hNd = str;
        }
    }
}
