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
    public static final String hxf;
    private HashMap<String, String> hqf;
    private List<DownloadData> hxg;
    private a hxh;
    private String hxi;
    private com.baidu.tbadk.download.d hxj = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hxh != null && m.this.hxi.equals(downloadData.getUrl())) {
                    m.this.hxh.bAR();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hxf)) {
                m.this.x(downloadData);
                if (m.this.hxh != null && m.this.hxi.equals(downloadData.getUrl())) {
                    m.this.hqf.put(downloadData.getPath().substring(m.hxf.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    m.this.hxh.cj(m.this.hxi, downloadData.getPath());
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
            if (m.this.hxh != null && m.this.hxi.equals(downloadData.getUrl())) {
                m.this.hxh.tE(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAR();

        void cj(String str, String str2);

        void tE(String str);
    }

    static {
        hxf = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uc(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqf == null) {
            this.hqf = new HashMap<>();
            bEb();
        }
        return this.hqf.get(eu);
    }

    public void bEb() {
        if (!StringUtils.isNull(hxf)) {
            if (this.hqf == null) {
                this.hqf = new HashMap<>();
            } else {
                this.hqf.clear();
            }
            File file = new File(hxf);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hqf.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void ud(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hxf)) {
            if (this.hxh != null) {
                this.hxh.tE("");
                return;
            }
            return;
        }
        String eu = ap.eu(str);
        if (eu != null) {
            File file = new File(hxf);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.hxg == null) {
                this.hxg = new ArrayList();
            }
            if (!gg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hxf + "/" + eu + str2);
                downloadData.setCallback(this.hxj);
                this.hxg.add(downloadData);
                com.baidu.tbadk.download.e.KT().f(downloadData);
            }
        }
    }

    private boolean gg(String str) {
        if (v.E(this.hxg) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hxg) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.E(this.hxg) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hxg.size()) {
                    i = -1;
                    break;
                } else if (this.hxg.get(i) != null && this.hxg.get(i).getUrl() != null && this.hxg.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hxg.remove(i);
        }
    }

    public void a(a aVar) {
        this.hxh = aVar;
    }

    public void ue(String str) {
        if (str == null) {
            this.hxi = "";
        } else {
            this.hxi = str;
        }
    }
}
