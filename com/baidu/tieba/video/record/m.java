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
    public static final String hGh;
    private List<DownloadData> hGi;
    private a hGj;
    private String hGk;
    private com.baidu.tbadk.download.d hGl = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hGj != null && m.this.hGk.equals(downloadData.getUrl())) {
                    m.this.hGj.bGJ();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hGh)) {
                m.this.x(downloadData);
                if (m.this.hGj != null && m.this.hGk.equals(downloadData.getUrl())) {
                    m.this.hzg.put(downloadData.getPath().substring(m.hGh.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    m.this.hGj.co(m.this.hGk, downloadData.getPath());
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
            if (m.this.hGj != null && m.this.hGk.equals(downloadData.getUrl())) {
                m.this.hGj.tX(str);
            }
        }
    };
    private HashMap<String, String> hzg;

    /* loaded from: classes2.dex */
    public interface a {
        void bGJ();

        void co(String str, String str2);

        void tX(String str);
    }

    static {
        hGh = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uv(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hzg == null) {
            this.hzg = new HashMap<>();
            bJV();
        }
        return this.hzg.get(ee);
    }

    public void bJV() {
        if (!StringUtils.isNull(hGh)) {
            if (this.hzg == null) {
                this.hzg = new HashMap<>();
            } else {
                this.hzg.clear();
            }
            File file = new File(hGh);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hzg.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void uw(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hGh)) {
            if (this.hGj != null) {
                this.hGj.tX("");
                return;
            }
            return;
        }
        String ee = ao.ee(str);
        if (ee != null) {
            File file = new File(hGh);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hGi == null) {
                this.hGi = new ArrayList();
            }
            if (!fO(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hGh + "/" + ee + str2);
                downloadData.setCallback(this.hGl);
                this.hGi.add(downloadData);
                com.baidu.tbadk.download.e.Kx().f(downloadData);
            }
        }
    }

    private boolean fO(String str) {
        if (v.G(this.hGi) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hGi) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.G(this.hGi) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hGi.size()) {
                    i = -1;
                    break;
                } else if (this.hGi.get(i) != null && this.hGi.get(i).getUrl() != null && this.hGi.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hGi.remove(i);
        }
    }

    public void a(a aVar) {
        this.hGj = aVar;
    }

    public void ux(String str) {
        if (str == null) {
            this.hGk = "";
        } else {
            this.hGk = str;
        }
    }
}
