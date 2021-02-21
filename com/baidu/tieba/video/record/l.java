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
    public static final String nSG;
    private HashMap<String, String> nNf;
    private List<DownloadData> nSH;
    private a nSI;
    private String nSJ;
    private com.baidu.tbadk.download.c nSK = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.nSI != null && l.this.nSJ.equals(downloadData.getUrl())) {
                    l.this.nSI.dSo();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nSG)) {
                l.this.v(downloadData);
                if (l.this.nSI != null && l.this.nSJ.equals(downloadData.getUrl())) {
                    l.this.nNf.put(downloadData.getPath().substring(l.nSG.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nSI.gF(l.this.nSJ, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.v(downloadData);
            if (l.this.nSI != null && l.this.nSJ.equals(downloadData.getUrl())) {
                l.this.nSI.Uo(str);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void Uo(String str);

        void dSo();

        void gF(String str, String str2);
    }

    static {
        nSG = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String UJ(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nNf == null) {
            this.nNf = new HashMap<>();
            dUQ();
        }
        return this.nNf.get(nameMd5FromUrl);
    }

    public void dUQ() {
        if (!StringUtils.isNull(nSG)) {
            if (this.nNf == null) {
                this.nNf = new HashMap<>();
            } else {
                this.nNf.clear();
            }
            File file = new File(nSG);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nNf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void UK(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nSG)) {
            if (this.nSI != null) {
                this.nSI.Uo("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nSG);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nSH == null) {
                this.nSH = new ArrayList();
            }
            if (!UL(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nSG + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nSK);
                this.nSH.add(downloadData);
                com.baidu.tbadk.download.d.bBd().f(downloadData);
            }
        }
    }

    private boolean UL(String str) {
        if (y.isEmpty(this.nSH) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nSH) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nSH) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nSH.size()) {
                    i = -1;
                    break;
                } else if (this.nSH.get(i) != null && this.nSH.get(i).getUrl() != null && this.nSH.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nSH.remove(i);
        }
    }

    public void a(a aVar) {
        this.nSI = aVar;
    }

    public void UM(String str) {
        if (str == null) {
            this.nSJ = "";
        } else {
            this.nSJ = str;
        }
    }
}
