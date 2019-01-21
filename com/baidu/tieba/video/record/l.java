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
    public static final String hNb;
    private HashMap<String, String> hGD;
    private List<DownloadData> hNc;
    private a hNd;
    private String hNe;
    private com.baidu.tbadk.download.c hNf = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hNd != null && l.this.hNe.equals(downloadData.getUrl())) {
                    l.this.hNd.bJy();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hNb)) {
                l.this.v(downloadData);
                if (l.this.hNd != null && l.this.hNe.equals(downloadData.getUrl())) {
                    l.this.hGD.put(downloadData.getPath().substring(l.hNb.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hNd.cT(l.this.hNe, downloadData.getPath());
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
            if (l.this.hNd != null && l.this.hNe.equals(downloadData.getUrl())) {
                l.this.hNd.wS(str);
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
        hNb = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String xp(String str) {
        String fY = ar.fY(str);
        if (fY == null) {
            return null;
        }
        if (this.hGD == null) {
            this.hGD = new HashMap<>();
            bMt();
        }
        return this.hGD.get(fY);
    }

    public void bMt() {
        if (!StringUtils.isNull(hNb)) {
            if (this.hGD == null) {
                this.hGD = new HashMap<>();
            } else {
                this.hGD.clear();
            }
            File file = new File(hNb);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hGD.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void xq(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hNb)) {
            if (this.hNd != null) {
                this.hNd.wS("");
                return;
            }
            return;
        }
        String fY = ar.fY(str);
        if (fY != null) {
            File file = new File(hNb);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hNc == null) {
                this.hNc = new ArrayList();
            }
            if (!xr(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hNb + "/" + fY + str2);
                downloadData.setCallback(this.hNf);
                this.hNc.add(downloadData);
                com.baidu.tbadk.download.d.Mj().f(downloadData);
            }
        }
    }

    private boolean xr(String str) {
        if (v.I(this.hNc) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hNc) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.I(this.hNc) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hNc.size()) {
                    i = -1;
                    break;
                } else if (this.hNc.get(i) != null && this.hNc.get(i).getUrl() != null && this.hNc.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hNc.remove(i);
        }
    }

    public void a(a aVar) {
        this.hNd = aVar;
    }

    public void xs(String str) {
        if (str == null) {
            this.hNe = "";
        } else {
            this.hNe = str;
        }
    }
}
