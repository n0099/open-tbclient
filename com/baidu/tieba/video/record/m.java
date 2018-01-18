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
public class m {
    public static final String hvK;
    private HashMap<String, String> hoJ;
    private List<DownloadData> hvL;
    private a hvM;
    private String hvN;
    private com.baidu.tbadk.download.d hvO = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hvM != null && m.this.hvN.equals(downloadData.getUrl())) {
                    m.this.hvM.bAg();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hvK)) {
                m.this.x(downloadData);
                if (m.this.hvM != null && m.this.hvN.equals(downloadData.getUrl())) {
                    m.this.hoJ.put(downloadData.getPath().substring(m.hvK.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    m.this.hvM.ci(m.this.hvN, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            m.this.x(downloadData);
            if (m.this.hvM != null && m.this.hvN.equals(downloadData.getUrl())) {
                m.this.hvM.ts(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAg();

        void ci(String str, String str2);

        void ts(String str);
    }

    static {
        hvK = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String tQ(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hoJ == null) {
            this.hoJ = new HashMap<>();
            bDs();
        }
        return this.hoJ.get(ee);
    }

    public void bDs() {
        if (!StringUtils.isNull(hvK)) {
            if (this.hoJ == null) {
                this.hoJ = new HashMap<>();
            } else {
                this.hoJ.clear();
            }
            File file = new File(hvK);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hoJ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void tR(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hvK)) {
            if (this.hvM != null) {
                this.hvM.ts("");
                return;
            }
            return;
        }
        String ee = ao.ee(str);
        if (ee != null) {
            File file = new File(hvK);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hvL == null) {
                this.hvL = new ArrayList();
            }
            if (!fP(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hvK + "/" + ee + str2);
                downloadData.setCallback(this.hvO);
                this.hvL.add(downloadData);
                com.baidu.tbadk.download.e.Km().f(downloadData);
            }
        }
    }

    private boolean fP(String str) {
        if (v.E(this.hvL) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hvL) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.E(this.hvL) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hvL.size()) {
                    i = -1;
                    break;
                } else if (this.hvL.get(i) != null && this.hvL.get(i).getUrl() != null && this.hvL.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hvL.remove(i);
        }
    }

    public void a(a aVar) {
        this.hvM = aVar;
    }

    public void tS(String str) {
        if (str == null) {
            this.hvN = "";
        } else {
            this.hvN = str;
        }
    }
}
