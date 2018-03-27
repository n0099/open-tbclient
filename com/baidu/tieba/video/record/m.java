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
    public static final String hxD;
    private HashMap<String, String> hqD;
    private List<DownloadData> hxE;
    private a hxF;
    private String hxG;
    private com.baidu.tbadk.download.d hxH = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.hxF != null && m.this.hxG.equals(downloadData.getUrl())) {
                    m.this.hxF.bAW();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.hxD)) {
                m.this.x(downloadData);
                if (m.this.hxF != null && m.this.hxG.equals(downloadData.getUrl())) {
                    m.this.hqD.put(downloadData.getPath().substring(m.hxD.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    m.this.hxF.cj(m.this.hxG, downloadData.getPath());
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
            if (m.this.hxF != null && m.this.hxG.equals(downloadData.getUrl())) {
                m.this.hxF.tE(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAW();

        void cj(String str, String str2);

        void tE(String str);
    }

    static {
        hxD = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uc(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqD == null) {
            this.hqD = new HashMap<>();
            bEg();
        }
        return this.hqD.get(eu);
    }

    public void bEg() {
        if (!StringUtils.isNull(hxD)) {
            if (this.hqD == null) {
                this.hqD = new HashMap<>();
            } else {
                this.hqD.clear();
            }
            File file = new File(hxD);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hqD.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void ud(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hxD)) {
            if (this.hxF != null) {
                this.hxF.tE("");
                return;
            }
            return;
        }
        String eu = ap.eu(str);
        if (eu != null) {
            File file = new File(hxD);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.hxE == null) {
                this.hxE = new ArrayList();
            }
            if (!gg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hxD + "/" + eu + str2);
                downloadData.setCallback(this.hxH);
                this.hxE.add(downloadData);
                com.baidu.tbadk.download.e.KU().f(downloadData);
            }
        }
    }

    private boolean gg(String str) {
        if (v.E(this.hxE) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hxE) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.E(this.hxE) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hxE.size()) {
                    i = -1;
                    break;
                } else if (this.hxE.get(i) != null && this.hxE.get(i).getUrl() != null && this.hxE.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hxE.remove(i);
        }
    }

    public void a(a aVar) {
        this.hxF = aVar;
    }

    public void ue(String str) {
        if (str == null) {
            this.hxG = "";
        } else {
            this.hxG = str;
        }
    }
}
