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
    public static final String gAC;
    private List<DownloadData> gAD;
    private a gAE;
    private String gAF;
    private com.baidu.tbadk.download.d gAG = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.k.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                k.this.w(downloadData);
                if (k.this.gAE != null && k.this.gAF.equals(downloadData.getUrl())) {
                    k.this.gAE.bvn();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(k.gAC)) {
                k.this.w(downloadData);
                if (k.this.gAE != null && k.this.gAF.equals(downloadData.getUrl())) {
                    k.this.gvf.put(downloadData.getPath().substring(k.gAC.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    k.this.gAE.ci(k.this.gAF, downloadData.getPath());
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
            if (k.this.gAE != null && k.this.gAF.equals(downloadData.getUrl())) {
                k.this.gAE.sx(str);
            }
        }
    };
    private HashMap<String, String> gvf;

    /* loaded from: classes2.dex */
    public interface a {
        void bvn();

        void ci(String str, String str2);

        void sx(String str);
    }

    static {
        gAC = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String sP(String str) {
        String dP = ao.dP(str);
        if (dP == null) {
            return null;
        }
        if (this.gvf == null) {
            this.gvf = new HashMap<>();
            bxz();
        }
        return this.gvf.get(dP);
    }

    public void bxz() {
        if (!StringUtils.isNull(gAC)) {
            if (this.gvf == null) {
                this.gvf = new HashMap<>();
            } else {
                this.gvf.clear();
            }
            File file = new File(gAC);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gvf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void sQ(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gAC)) {
            if (this.gAE != null) {
                this.gAE.sx("");
                return;
            }
            return;
        }
        String dP = ao.dP(str);
        if (dP != null) {
            File file = new File(gAC);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gAD == null) {
                this.gAD = new ArrayList();
            }
            if (!fu(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gAC + "/" + dP + str2);
                downloadData.setCallback(this.gAG);
                this.gAD.add(downloadData);
                com.baidu.tbadk.download.e.Cl().f(downloadData);
            }
        }
    }

    private boolean fu(String str) {
        if (v.u(this.gAD) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gAD) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.u(this.gAD) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gAD.size()) {
                    i = -1;
                    break;
                } else if (this.gAD.get(i) != null && this.gAD.get(i).getUrl() != null && this.gAD.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gAD.remove(i);
        }
    }

    public void a(a aVar) {
        this.gAE = aVar;
    }

    public void sR(String str) {
        if (str == null) {
            this.gAF = "";
        } else {
            this.gAF = str;
        }
    }
}
