package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    public static final String nNd;
    private HashMap<String, String> nHz;
    private List<DownloadData> nNe;
    private a nNf;
    private String nNg;
    private com.baidu.tbadk.download.c nNh = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nNf != null && l.this.nNg.equals(downloadData.getUrl())) {
                    l.this.nNf.dTN();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nNd)) {
                l.this.w(downloadData);
                if (l.this.nNf != null && l.this.nNg.equals(downloadData.getUrl())) {
                    l.this.nHz.put(downloadData.getPath().substring(l.nNd.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nNf.gy(l.this.nNg, downloadData.getPath());
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
            if (l.this.nNf != null && l.this.nNg.equals(downloadData.getUrl())) {
                l.this.nNf.Um(str);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void Um(String str);

        void dTN();

        void gy(String str, String str2);
    }

    static {
        nNd = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String UH(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nHz == null) {
            this.nHz = new HashMap<>();
            dWp();
        }
        return this.nHz.get(nameMd5FromUrl);
    }

    public void dWp() {
        if (!StringUtils.isNull(nNd)) {
            if (this.nHz == null) {
                this.nHz = new HashMap<>();
            } else {
                this.nHz.clear();
            }
            File file = new File(nNd);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nHz.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void UI(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nNd)) {
            if (this.nNf != null) {
                this.nNf.Um("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nNd);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nNe == null) {
                this.nNe = new ArrayList();
            }
            if (!UJ(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nNd + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nNh);
                this.nNe.add(downloadData);
                com.baidu.tbadk.download.d.bEF().f(downloadData);
            }
        }
    }

    private boolean UJ(String str) {
        if (x.isEmpty(this.nNe) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nNe) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.nNe) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nNe.size()) {
                    i = -1;
                    break;
                } else if (this.nNe.get(i) != null && this.nNe.get(i).getUrl() != null && this.nNe.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nNe.remove(i);
        }
    }

    public void a(a aVar) {
        this.nNf = aVar;
    }

    public void UK(String str) {
        if (str == null) {
            this.nNg = "";
        } else {
            this.nNg = str;
        }
    }
}
