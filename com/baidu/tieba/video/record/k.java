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
    public static final String gAS = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath();
    private List<DownloadData> gAT;
    private a gAU;
    private String gAV;
    private com.baidu.tbadk.download.d gAW = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.k.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                k.this.w(downloadData);
                if (k.this.gAU != null && k.this.gAV.equals(downloadData.getUrl())) {
                    k.this.gAU.bvw();
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
                if (k.this.gAU != null && k.this.gAV.equals(downloadData.getUrl())) {
                    k.this.gvu.put(downloadData.getPath().substring(k.gAS.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    k.this.gAU.cj(k.this.gAV, downloadData.getPath());
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
            if (k.this.gAU != null && k.this.gAV.equals(downloadData.getUrl())) {
                k.this.gAU.sy(str);
            }
        }
    };
    private HashMap<String, String> gvu;

    /* loaded from: classes2.dex */
    public interface a {
        void bvw();

        void cj(String str, String str2);

        void sy(String str);
    }

    public String sQ(String str) {
        String dQ = ao.dQ(str);
        if (dQ == null) {
            return null;
        }
        if (this.gvu == null) {
            this.gvu = new HashMap<>();
            bxI();
        }
        return this.gvu.get(dQ);
    }

    public void bxI() {
        if (this.gvu == null) {
            this.gvu = new HashMap<>();
        } else {
            this.gvu.clear();
        }
        File file = new File(gAS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gvu.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void sR(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.gAU != null) {
                this.gAU.sy("");
                return;
            }
            return;
        }
        String dQ = ao.dQ(str);
        if (dQ != null) {
            File file = new File(gAS);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gAT == null) {
                this.gAT = new ArrayList();
            }
            if (!fv(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gAS + "/" + dQ + str2);
                downloadData.setCallback(this.gAW);
                this.gAT.add(downloadData);
                com.baidu.tbadk.download.e.Cr().f(downloadData);
            }
        }
    }

    private boolean fv(String str) {
        if (v.u(this.gAT) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gAT) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.u(this.gAT) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gAT.size()) {
                    i = -1;
                    break;
                } else if (this.gAT.get(i) != null && this.gAT.get(i).getUrl() != null && this.gAT.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gAT.remove(i);
        }
    }

    public void a(a aVar) {
        this.gAU = aVar;
    }

    public void sS(String str) {
        if (str == null) {
            this.gAV = "";
        } else {
            this.gAV = str;
        }
    }
}
