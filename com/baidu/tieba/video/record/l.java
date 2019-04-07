package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {
    public static final String jdl;
    private HashMap<String, String> iWS;
    private List<DownloadData> jdm;
    private a jdn;
    private String jdo;
    private com.baidu.tbadk.download.c jdp = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jdn != null && l.this.jdo.equals(downloadData.getUrl())) {
                    l.this.jdn.ciW();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jdl)) {
                l.this.v(downloadData);
                if (l.this.jdn != null && l.this.jdo.equals(downloadData.getUrl())) {
                    l.this.iWS.put(downloadData.getPath().substring(l.jdl.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jdn.ed(l.this.jdo, downloadData.getPath());
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
            if (l.this.jdn != null && l.this.jdo.equals(downloadData.getUrl())) {
                l.this.jdn.Ds(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void Ds(String str);

        void ciW();

        void ed(String str, String str2);
    }

    static {
        jdl = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String DP(String str) {
        String mL = as.mL(str);
        if (mL == null) {
            return null;
        }
        if (this.iWS == null) {
            this.iWS = new HashMap<>();
            clS();
        }
        return this.iWS.get(mL);
    }

    public void clS() {
        if (!StringUtils.isNull(jdl)) {
            if (this.iWS == null) {
                this.iWS = new HashMap<>();
            } else {
                this.iWS.clear();
            }
            File file = new File(jdl);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.iWS.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void DQ(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jdl)) {
            if (this.jdn != null) {
                this.jdn.Ds("");
                return;
            }
            return;
        }
        String mL = as.mL(str);
        if (mL != null) {
            File file = new File(jdl);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jdm == null) {
                this.jdm = new ArrayList();
            }
            if (!DR(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jdl + "/" + mL + str2);
                downloadData.setCallback(this.jdp);
                this.jdm.add(downloadData);
                com.baidu.tbadk.download.d.alJ().f(downloadData);
            }
        }
    }

    private boolean DR(String str) {
        if (v.T(this.jdm) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jdm) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.T(this.jdm) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jdm.size()) {
                    i = -1;
                    break;
                } else if (this.jdm.get(i) != null && this.jdm.get(i).getUrl() != null && this.jdm.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jdm.remove(i);
        }
    }

    public void a(a aVar) {
        this.jdn = aVar;
    }

    public void DS(String str) {
        if (str == null) {
            this.jdo = "";
        } else {
            this.jdo = str;
        }
    }
}
