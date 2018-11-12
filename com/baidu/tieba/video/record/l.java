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
    public static final String hBw;
    private com.baidu.tbadk.download.c hBA = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hBy != null && l.this.hBz.equals(downloadData.getUrl())) {
                    l.this.hBy.bFV();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hBw)) {
                l.this.v(downloadData);
                if (l.this.hBy != null && l.this.hBz.equals(downloadData.getUrl())) {
                    l.this.huY.put(downloadData.getPath().substring(l.hBw.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hBy.cM(l.this.hBz, downloadData.getPath());
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
            if (l.this.hBy != null && l.this.hBz.equals(downloadData.getUrl())) {
                l.this.hBy.vW(str);
            }
        }
    };
    private List<DownloadData> hBx;
    private a hBy;
    private String hBz;
    private HashMap<String, String> huY;

    /* loaded from: classes5.dex */
    public interface a {
        void bFV();

        void cM(String str, String str2);

        void vW(String str);
    }

    static {
        hBw = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String wt(String str) {
        String fs = ar.fs(str);
        if (fs == null) {
            return null;
        }
        if (this.huY == null) {
            this.huY = new HashMap<>();
            bIQ();
        }
        return this.huY.get(fs);
    }

    public void bIQ() {
        if (!StringUtils.isNull(hBw)) {
            if (this.huY == null) {
                this.huY = new HashMap<>();
            } else {
                this.huY.clear();
            }
            File file = new File(hBw);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.huY.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void wu(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hBw)) {
            if (this.hBy != null) {
                this.hBy.vW("");
                return;
            }
            return;
        }
        String fs = ar.fs(str);
        if (fs != null) {
            File file = new File(hBw);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hBx == null) {
                this.hBx = new ArrayList();
            }
            if (!wv(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hBw + "/" + fs + str2);
                downloadData.setCallback(this.hBA);
                this.hBx.add(downloadData);
                com.baidu.tbadk.download.d.KN().f(downloadData);
            }
        }
    }

    private boolean wv(String str) {
        if (v.I(this.hBx) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hBx) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.I(this.hBx) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hBx.size()) {
                    i = -1;
                    break;
                } else if (this.hBx.get(i) != null && this.hBx.get(i).getUrl() != null && this.hBx.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hBx.remove(i);
        }
    }

    public void a(a aVar) {
        this.hBy = aVar;
    }

    public void ww(String str) {
        if (str == null) {
            this.hBz = "";
        } else {
            this.hBz = str;
        }
    }
}
