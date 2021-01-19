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
/* loaded from: classes7.dex */
public class l {
    public static final String nIz;
    private HashMap<String, String> nCV;
    private List<DownloadData> nIA;
    private a nIB;
    private String nIC;
    private com.baidu.tbadk.download.c nID = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nIB != null && l.this.nIC.equals(downloadData.getUrl())) {
                    l.this.nIB.dPV();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nIz)) {
                l.this.w(downloadData);
                if (l.this.nIB != null && l.this.nIC.equals(downloadData.getUrl())) {
                    l.this.nCV.put(downloadData.getPath().substring(l.nIz.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nIB.gx(l.this.nIC, downloadData.getPath());
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
            if (l.this.nIB != null && l.this.nIC.equals(downloadData.getUrl())) {
                l.this.nIB.Tf(str);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void Tf(String str);

        void dPV();

        void gx(String str, String str2);
    }

    static {
        nIz = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String TA(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nCV == null) {
            this.nCV = new HashMap<>();
            dSx();
        }
        return this.nCV.get(nameMd5FromUrl);
    }

    public void dSx() {
        if (!StringUtils.isNull(nIz)) {
            if (this.nCV == null) {
                this.nCV = new HashMap<>();
            } else {
                this.nCV.clear();
            }
            File file = new File(nIz);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nCV.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void TB(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nIz)) {
            if (this.nIB != null) {
                this.nIB.Tf("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nIz);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nIA == null) {
                this.nIA = new ArrayList();
            }
            if (!TC(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nIz + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nID);
                this.nIA.add(downloadData);
                com.baidu.tbadk.download.d.bAL().f(downloadData);
            }
        }
    }

    private boolean TC(String str) {
        if (x.isEmpty(this.nIA) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nIA) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.nIA) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nIA.size()) {
                    i = -1;
                    break;
                } else if (this.nIA.get(i) != null && this.nIA.get(i).getUrl() != null && this.nIA.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nIA.remove(i);
        }
    }

    public void a(a aVar) {
        this.nIB = aVar;
    }

    public void TD(String str) {
        if (str == null) {
            this.nIC = "";
        } else {
            this.nIC = str;
        }
    }
}
