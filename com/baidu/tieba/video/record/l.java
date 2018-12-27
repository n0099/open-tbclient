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
    public static final String hLT;
    private HashMap<String, String> hFv;
    private List<DownloadData> hLU;
    private a hLV;
    private String hLW;
    private com.baidu.tbadk.download.c hLX = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hLV != null && l.this.hLW.equals(downloadData.getUrl())) {
                    l.this.hLV.bIP();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hLT)) {
                l.this.v(downloadData);
                if (l.this.hLV != null && l.this.hLW.equals(downloadData.getUrl())) {
                    l.this.hFv.put(downloadData.getPath().substring(l.hLT.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hLV.cR(l.this.hLW, downloadData.getPath());
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
            if (l.this.hLV != null && l.this.hLW.equals(downloadData.getUrl())) {
                l.this.hLV.wC(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void bIP();

        void cR(String str, String str2);

        void wC(String str);
    }

    static {
        hLT = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String wZ(String str) {
        String fL = ar.fL(str);
        if (fL == null) {
            return null;
        }
        if (this.hFv == null) {
            this.hFv = new HashMap<>();
            bLK();
        }
        return this.hFv.get(fL);
    }

    public void bLK() {
        if (!StringUtils.isNull(hLT)) {
            if (this.hFv == null) {
                this.hFv = new HashMap<>();
            } else {
                this.hFv.clear();
            }
            File file = new File(hLT);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hFv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void xa(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hLT)) {
            if (this.hLV != null) {
                this.hLV.wC("");
                return;
            }
            return;
        }
        String fL = ar.fL(str);
        if (fL != null) {
            File file = new File(hLT);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hLU == null) {
                this.hLU = new ArrayList();
            }
            if (!xb(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hLT + "/" + fL + str2);
                downloadData.setCallback(this.hLX);
                this.hLU.add(downloadData);
                com.baidu.tbadk.download.d.LS().f(downloadData);
            }
        }
    }

    private boolean xb(String str) {
        if (v.I(this.hLU) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hLU) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.I(this.hLU) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hLU.size()) {
                    i = -1;
                    break;
                } else if (this.hLU.get(i) != null && this.hLU.get(i).getUrl() != null && this.hLU.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hLU.remove(i);
        }
    }

    public void a(a aVar) {
        this.hLV = aVar;
    }

    public void xc(String str) {
        if (str == null) {
            this.hLW = "";
        } else {
            this.hLW = str;
        }
    }
}
