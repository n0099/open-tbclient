package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    public static final String nSg;
    private HashMap<String, String> nMF;
    private List<DownloadData> nSh;
    private a nSi;
    private String nSj;
    private com.baidu.tbadk.download.c nSk = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nSi != null && l.this.nSj.equals(downloadData.getUrl())) {
                    l.this.nSi.dSg();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nSg)) {
                l.this.w(downloadData);
                if (l.this.nSi != null && l.this.nSj.equals(downloadData.getUrl())) {
                    l.this.nMF.put(downloadData.getPath().substring(l.nSg.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nSi.gD(l.this.nSj, downloadData.getPath());
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
            if (l.this.nSi != null && l.this.nSj.equals(downloadData.getUrl())) {
                l.this.nSi.Uc(str);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void Uc(String str);

        void dSg();

        void gD(String str, String str2);
    }

    static {
        nSg = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ux(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nMF == null) {
            this.nMF = new HashMap<>();
            dUI();
        }
        return this.nMF.get(nameMd5FromUrl);
    }

    public void dUI() {
        if (!StringUtils.isNull(nSg)) {
            if (this.nMF == null) {
                this.nMF = new HashMap<>();
            } else {
                this.nMF.clear();
            }
            File file = new File(nSg);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nMF.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Uy(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nSg)) {
            if (this.nSi != null) {
                this.nSi.Uc("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nSg);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nSh == null) {
                this.nSh = new ArrayList();
            }
            if (!Uz(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nSg + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nSk);
                this.nSh.add(downloadData);
                com.baidu.tbadk.download.d.bBd().f(downloadData);
            }
        }
    }

    private boolean Uz(String str) {
        if (y.isEmpty(this.nSh) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nSh) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nSh) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nSh.size()) {
                    i = -1;
                    break;
                } else if (this.nSh.get(i) != null && this.nSh.get(i).getUrl() != null && this.nSh.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nSh.remove(i);
        }
    }

    public void a(a aVar) {
        this.nSi = aVar;
    }

    public void UA(String str) {
        if (str == null) {
            this.nSj = "";
        } else {
            this.nSj = str;
        }
    }
}
