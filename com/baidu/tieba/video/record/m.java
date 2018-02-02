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
    public static final String hwe;
    private HashMap<String, String> hpd;
    private List<DownloadData> hwf;
    private a hwg;
    private String hwh;
    private com.baidu.tbadk.download.d hwi = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hwg != null && m.this.hwh.equals(downloadData.getUrl())) {
                    m.this.hwg.bAi();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hwe)) {
                m.this.x(downloadData);
                if (m.this.hwg != null && m.this.hwh.equals(downloadData.getUrl())) {
                    m.this.hpd.put(downloadData.getPath().substring(m.hwe.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    m.this.hwg.ch(m.this.hwh, downloadData.getPath());
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
            if (m.this.hwg != null && m.this.hwh.equals(downloadData.getUrl())) {
                m.this.hwg.tA(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAi();

        void ch(String str, String str2);

        void tA(String str);
    }

    static {
        hwe = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String tY(String str) {
        String ej = ao.ej(str);
        if (ej == null) {
            return null;
        }
        if (this.hpd == null) {
            this.hpd = new HashMap<>();
            bDu();
        }
        return this.hpd.get(ej);
    }

    public void bDu() {
        if (!StringUtils.isNull(hwe)) {
            if (this.hpd == null) {
                this.hpd = new HashMap<>();
            } else {
                this.hpd.clear();
            }
            File file = new File(hwe);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hpd.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void tZ(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hwe)) {
            if (this.hwg != null) {
                this.hwg.tA("");
                return;
            }
            return;
        }
        String ej = ao.ej(str);
        if (ej != null) {
            File file = new File(hwe);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hwf == null) {
                this.hwf = new ArrayList();
            }
            if (!fX(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hwe + "/" + ej + str2);
                downloadData.setCallback(this.hwi);
                this.hwf.add(downloadData);
                com.baidu.tbadk.download.e.Ko().f(downloadData);
            }
        }
    }

    private boolean fX(String str) {
        if (v.E(this.hwf) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hwf) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.E(this.hwf) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hwf.size()) {
                    i = -1;
                    break;
                } else if (this.hwf.get(i) != null && this.hwf.get(i).getUrl() != null && this.hwf.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hwf.remove(i);
        }
    }

    public void a(a aVar) {
        this.hwg = aVar;
    }

    public void ua(String str) {
        if (str == null) {
            this.hwh = "";
        } else {
            this.hwh = str;
        }
    }
}
