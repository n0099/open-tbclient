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
/* loaded from: classes8.dex */
public class l {
    public static final String kCl;
    private List<DownloadData> kCm;
    private a kCn;
    private String kCo;
    private com.baidu.tbadk.download.c kCp = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kCn != null && l.this.kCo.equals(downloadData.getUrl())) {
                    l.this.kCn.cNT();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kCl)) {
                l.this.w(downloadData);
                if (l.this.kCn != null && l.this.kCo.equals(downloadData.getUrl())) {
                    l.this.kwf.put(downloadData.getPath().substring(l.kCl.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kCn.eA(l.this.kCo, downloadData.getPath());
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
            if (l.this.kCn != null && l.this.kCo.equals(downloadData.getUrl())) {
                l.this.kCn.JG(str);
            }
        }
    };
    private HashMap<String, String> kwf;

    /* loaded from: classes8.dex */
    public interface a {
        void JG(String str);

        void cNT();

        void eA(String str, String str2);
    }

    static {
        kCl = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Kb(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kwf == null) {
            this.kwf = new HashMap<>();
            cQF();
        }
        return this.kwf.get(nameMd5FromUrl);
    }

    public void cQF() {
        if (!StringUtils.isNull(kCl)) {
            if (this.kwf == null) {
                this.kwf = new HashMap<>();
            } else {
                this.kwf.clear();
            }
            File file = new File(kCl);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kwf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kc(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kCl)) {
            if (this.kCn != null) {
                this.kCn.JG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kCl);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kCm == null) {
                this.kCm = new ArrayList();
            }
            if (!Kd(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kCl + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kCp);
                this.kCm.add(downloadData);
                com.baidu.tbadk.download.d.aLR().f(downloadData);
            }
        }
    }

    private boolean Kd(String str) {
        if (v.isEmpty(this.kCm) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kCm) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kCm) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kCm.size()) {
                    i = -1;
                    break;
                } else if (this.kCm.get(i) != null && this.kCm.get(i).getUrl() != null && this.kCm.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kCm.remove(i);
        }
    }

    public void a(a aVar) {
        this.kCn = aVar;
    }

    public void Ke(String str) {
        if (str == null) {
            this.kCo = "";
        } else {
            this.kCo = str;
        }
    }
}
