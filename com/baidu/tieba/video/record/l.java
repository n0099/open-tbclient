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
/* loaded from: classes10.dex */
public class l {
    public static final String lpD;
    private HashMap<String, String> ljk;
    private List<DownloadData> lpE;
    private a lpF;
    private String lpG;
    private com.baidu.tbadk.download.c lpH = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.lpF != null && l.this.lpG.equals(downloadData.getUrl())) {
                    l.this.lpF.daH();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.lpD)) {
                l.this.w(downloadData);
                if (l.this.lpF != null && l.this.lpG.equals(downloadData.getUrl())) {
                    l.this.ljk.put(downloadData.getPath().substring(l.lpD.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.lpF.eW(l.this.lpG, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.w(downloadData);
            if (l.this.lpF != null && l.this.lpG.equals(downloadData.getUrl())) {
                l.this.lpF.LD(str);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void LD(String str);

        void daH();

        void eW(String str, String str2);
    }

    static {
        lpD = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ma(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljk == null) {
            this.ljk = new HashMap<>();
            ddw();
        }
        return this.ljk.get(nameMd5FromUrl);
    }

    public void ddw() {
        if (!StringUtils.isNull(lpD)) {
            if (this.ljk == null) {
                this.ljk = new HashMap<>();
            } else {
                this.ljk.clear();
            }
            File file = new File(lpD);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.ljk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Mb(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(lpD)) {
            if (this.lpF != null) {
                this.lpF.LD("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(lpD);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.lpE == null) {
                this.lpE = new ArrayList();
            }
            if (!Mc(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(lpD + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.lpH);
                this.lpE.add(downloadData);
                com.baidu.tbadk.download.d.aWL().f(downloadData);
            }
        }
    }

    private boolean Mc(String str) {
        if (v.isEmpty(this.lpE) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.lpE) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.lpE) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.lpE.size()) {
                    i = -1;
                    break;
                } else if (this.lpE.get(i) != null && this.lpE.get(i).getUrl() != null && this.lpE.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.lpE.remove(i);
        }
    }

    public void a(a aVar) {
        this.lpF = aVar;
    }

    public void Md(String str) {
        if (str == null) {
            this.lpG = "";
        } else {
            this.lpG = str;
        }
    }
}
