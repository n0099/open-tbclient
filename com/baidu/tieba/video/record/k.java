package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static final String gAR = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath();
    private List<DownloadData> gAS;
    private a gAT;
    private String gAU;
    private com.baidu.tbadk.download.d gAV = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.k.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                k.this.w(downloadData);
                if (k.this.gAT != null && k.this.gAU.equals(downloadData.getUrl())) {
                    k.this.gAT.bvv();
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath())) {
                k.this.w(downloadData);
                if (k.this.gAT != null && k.this.gAU.equals(downloadData.getUrl())) {
                    k.this.gvt.put(downloadData.getPath().substring(k.gAR.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    k.this.gAT.cj(k.this.gAU, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            k.this.w(downloadData);
            if (k.this.gAT != null && k.this.gAU.equals(downloadData.getUrl())) {
                k.this.gAT.sy(str);
            }
        }
    };
    private HashMap<String, String> gvt;

    /* loaded from: classes2.dex */
    public interface a {
        void bvv();

        void cj(String str, String str2);

        void sy(String str);
    }

    public String sQ(String str) {
        String dQ = ao.dQ(str);
        if (dQ == null) {
            return null;
        }
        if (this.gvt == null) {
            this.gvt = new HashMap<>();
            bxH();
        }
        return this.gvt.get(dQ);
    }

    public void bxH() {
        if (this.gvt == null) {
            this.gvt = new HashMap<>();
        } else {
            this.gvt.clear();
        }
        File file = new File(gAR);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gvt.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void sR(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.gAT != null) {
                this.gAT.sy("");
                return;
            }
            return;
        }
        String dQ = ao.dQ(str);
        if (dQ != null) {
            File file = new File(gAR);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gAS == null) {
                this.gAS = new ArrayList();
            }
            if (!fv(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gAR + "/" + dQ + str2);
                downloadData.setCallback(this.gAV);
                this.gAS.add(downloadData);
                com.baidu.tbadk.download.e.Cr().f(downloadData);
            }
        }
    }

    private boolean fv(String str) {
        if (v.u(this.gAS) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gAS) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.u(this.gAS) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gAS.size()) {
                    i = -1;
                    break;
                } else if (this.gAS.get(i) != null && this.gAS.get(i).getUrl() != null && this.gAS.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gAS.remove(i);
        }
    }

    public void a(a aVar) {
        this.gAT = aVar;
    }

    public void sS(String str) {
        if (str == null) {
            this.gAU = "";
        } else {
            this.gAU = str;
        }
    }
}
