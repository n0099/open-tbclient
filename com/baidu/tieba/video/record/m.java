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
    public static final String gWn;
    private HashMap<String, String> gPq;
    private List<DownloadData> gWo;
    private a gWp;
    private String gWq;
    private com.baidu.tbadk.download.d gWr = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.gWp != null && m.this.gWq.equals(downloadData.getUrl())) {
                    m.this.gWp.bAF();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.gWn)) {
                m.this.x(downloadData);
                if (m.this.gWp != null && m.this.gWq.equals(downloadData.getUrl())) {
                    m.this.gPq.put(downloadData.getPath().substring(m.gWn.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    m.this.gWp.cm(m.this.gWq, downloadData.getPath());
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
            if (m.this.gWp != null && m.this.gWq.equals(downloadData.getUrl())) {
                m.this.gWp.tR(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAF();

        void cm(String str, String str2);

        void tR(String str);
    }

    static {
        gWn = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String up(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gPq == null) {
            this.gPq = new HashMap<>();
            bDK();
        }
        return this.gPq.get(dX);
    }

    public void bDK() {
        if (!StringUtils.isNull(gWn)) {
            if (this.gPq == null) {
                this.gPq = new HashMap<>();
            } else {
                this.gPq.clear();
            }
            File file = new File(gWn);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gPq.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void uq(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gWn)) {
            if (this.gWp != null) {
                this.gWp.tR("");
                return;
            }
            return;
        }
        String dX = ao.dX(str);
        if (dX != null) {
            File file = new File(gWn);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gWo == null) {
                this.gWo = new ArrayList();
            }
            if (!fI(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gWn + "/" + dX + str2);
                downloadData.setCallback(this.gWr);
                this.gWo.add(downloadData);
                com.baidu.tbadk.download.e.CV().f(downloadData);
            }
        }
    }

    private boolean fI(String str) {
        if (v.w(this.gWo) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gWo) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.w(this.gWo) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gWo.size()) {
                    i = -1;
                    break;
                } else if (this.gWo.get(i) != null && this.gWo.get(i).getUrl() != null && this.gWo.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gWo.remove(i);
        }
    }

    public void a(a aVar) {
        this.gWp = aVar;
    }

    public void ur(String str) {
        if (str == null) {
            this.gWq = "";
        } else {
            this.gWq = str;
        }
    }
}
