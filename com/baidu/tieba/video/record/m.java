package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class m {
    public static final String hxs;
    private HashMap<String, String> hqs;
    private List<DownloadData> hxt;
    private a hxu;
    private String hxv;
    private com.baidu.tbadk.download.d hxw = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hxu != null && m.this.hxv.equals(downloadData.getUrl())) {
                    m.this.hxu.bAS();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hxs)) {
                m.this.x(downloadData);
                if (m.this.hxu != null && m.this.hxv.equals(downloadData.getUrl())) {
                    m.this.hqs.put(downloadData.getPath().substring(m.hxs.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    m.this.hxu.cj(m.this.hxv, downloadData.getPath());
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
            if (m.this.hxu != null && m.this.hxv.equals(downloadData.getUrl())) {
                m.this.hxu.tE(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAS();

        void cj(String str, String str2);

        void tE(String str);
    }

    static {
        hxs = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uc(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqs == null) {
            this.hqs = new HashMap<>();
            bEc();
        }
        return this.hqs.get(eu);
    }

    public void bEc() {
        if (!StringUtils.isNull(hxs)) {
            if (this.hqs == null) {
                this.hqs = new HashMap<>();
            } else {
                this.hqs.clear();
            }
            File file = new File(hxs);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hqs.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void ud(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hxs)) {
            if (this.hxu != null) {
                this.hxu.tE("");
                return;
            }
            return;
        }
        String eu = ap.eu(str);
        if (eu != null) {
            File file = new File(hxs);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.hxt == null) {
                this.hxt = new ArrayList();
            }
            if (!gg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hxs + "/" + eu + str2);
                downloadData.setCallback(this.hxw);
                this.hxt.add(downloadData);
                com.baidu.tbadk.download.e.KU().f(downloadData);
            }
        }
    }

    private boolean gg(String str) {
        if (v.E(this.hxt) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hxt) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.E(this.hxt) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hxt.size()) {
                    i = -1;
                    break;
                } else if (this.hxt.get(i) != null && this.hxt.get(i).getUrl() != null && this.hxt.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hxt.remove(i);
        }
    }

    public void a(a aVar) {
        this.hxu = aVar;
    }

    public void ue(String str) {
        if (str == null) {
            this.hxv = "";
        } else {
            this.hxv = str;
        }
    }
}
