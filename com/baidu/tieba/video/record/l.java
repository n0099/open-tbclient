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
    public static final String jdx;
    private HashMap<String, String> iXe;
    private String jdA;
    private com.baidu.tbadk.download.c jdB = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jdz != null && l.this.jdA.equals(downloadData.getUrl())) {
                    l.this.jdz.ciY();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jdx)) {
                l.this.v(downloadData);
                if (l.this.jdz != null && l.this.jdA.equals(downloadData.getUrl())) {
                    l.this.iXe.put(downloadData.getPath().substring(l.jdx.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jdz.ec(l.this.jdA, downloadData.getPath());
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
            if (l.this.jdz != null && l.this.jdA.equals(downloadData.getUrl())) {
                l.this.jdz.Dt(str);
            }
        }
    };
    private List<DownloadData> jdy;
    private a jdz;

    /* loaded from: classes5.dex */
    public interface a {
        void Dt(String str);

        void ciY();

        void ec(String str, String str2);
    }

    static {
        jdx = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String DQ(String str) {
        String mK = as.mK(str);
        if (mK == null) {
            return null;
        }
        if (this.iXe == null) {
            this.iXe = new HashMap<>();
            clU();
        }
        return this.iXe.get(mK);
    }

    public void clU() {
        if (!StringUtils.isNull(jdx)) {
            if (this.iXe == null) {
                this.iXe = new HashMap<>();
            } else {
                this.iXe.clear();
            }
            File file = new File(jdx);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.iXe.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void DR(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jdx)) {
            if (this.jdz != null) {
                this.jdz.Dt("");
                return;
            }
            return;
        }
        String mK = as.mK(str);
        if (mK != null) {
            File file = new File(jdx);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jdy == null) {
                this.jdy = new ArrayList();
            }
            if (!DS(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jdx + "/" + mK + str2);
                downloadData.setCallback(this.jdB);
                this.jdy.add(downloadData);
                com.baidu.tbadk.download.d.alM().f(downloadData);
            }
        }
    }

    private boolean DS(String str) {
        if (v.T(this.jdy) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jdy) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.T(this.jdy) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jdy.size()) {
                    i = -1;
                    break;
                } else if (this.jdy.get(i) != null && this.jdy.get(i).getUrl() != null && this.jdy.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jdy.remove(i);
        }
    }

    public void a(a aVar) {
        this.jdz = aVar;
    }

    public void DT(String str) {
        if (str == null) {
            this.jdA = "";
        } else {
            this.jdA = str;
        }
    }
}
