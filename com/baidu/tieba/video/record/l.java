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
public class l {
    public static final String gKp;
    private HashMap<String, String> gEf;
    private List<DownloadData> gKq;
    private a gKr;
    private String gKs;
    private com.baidu.tbadk.download.d gKt = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.gKr != null && l.this.gKs.equals(downloadData.getUrl())) {
                    l.this.gKr.byq();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.gKp)) {
                l.this.w(downloadData);
                if (l.this.gKr != null && l.this.gKs.equals(downloadData.getUrl())) {
                    l.this.gEf.put(downloadData.getPath().substring(l.gKp.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.gKr.cf(l.this.gKs, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.w(downloadData);
            if (l.this.gKr != null && l.this.gKs.equals(downloadData.getUrl())) {
                l.this.gKr.tf(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void byq();

        void cf(String str, String str2);

        void tf(String str);
    }

    static {
        gKp = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String tB(String str) {
        String dV = ao.dV(str);
        if (dV == null) {
            return null;
        }
        if (this.gEf == null) {
            this.gEf = new HashMap<>();
            bAR();
        }
        return this.gEf.get(dV);
    }

    public void bAR() {
        if (!StringUtils.isNull(gKp)) {
            if (this.gEf == null) {
                this.gEf = new HashMap<>();
            } else {
                this.gEf.clear();
            }
            File file = new File(gKp);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gEf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void tC(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gKp)) {
            if (this.gKr != null) {
                this.gKr.tf("");
                return;
            }
            return;
        }
        String dV = ao.dV(str);
        if (dV != null) {
            File file = new File(gKp);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gKq == null) {
                this.gKq = new ArrayList();
            }
            if (!fB(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gKp + "/" + dV + str2);
                downloadData.setCallback(this.gKt);
                this.gKq.add(downloadData);
                com.baidu.tbadk.download.e.CA().f(downloadData);
            }
        }
    }

    private boolean fB(String str) {
        if (v.v(this.gKq) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gKq) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.v(this.gKq) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gKq.size()) {
                    i = -1;
                    break;
                } else if (this.gKq.get(i) != null && this.gKq.get(i).getUrl() != null && this.gKq.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gKq.remove(i);
        }
    }

    public void a(a aVar) {
        this.gKr = aVar;
    }

    public void tD(String str) {
        if (str == null) {
            this.gKs = "";
        } else {
            this.gKs = str;
        }
    }
}
