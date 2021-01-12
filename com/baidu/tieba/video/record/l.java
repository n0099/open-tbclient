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
    public static final String nIy;
    private HashMap<String, String> nCU;
    private a nIA;
    private String nIB;
    private com.baidu.tbadk.download.c nIC = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nIA != null && l.this.nIB.equals(downloadData.getUrl())) {
                    l.this.nIA.dPV();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nIy)) {
                l.this.w(downloadData);
                if (l.this.nIA != null && l.this.nIB.equals(downloadData.getUrl())) {
                    l.this.nCU.put(downloadData.getPath().substring(l.nIy.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nIA.gx(l.this.nIB, downloadData.getPath());
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
            if (l.this.nIA != null && l.this.nIB.equals(downloadData.getUrl())) {
                l.this.nIA.Te(str);
            }
        }
    };
    private List<DownloadData> nIz;

    /* loaded from: classes7.dex */
    public interface a {
        void Te(String str);

        void dPV();

        void gx(String str, String str2);
    }

    static {
        nIy = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Tz(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nCU == null) {
            this.nCU = new HashMap<>();
            dSx();
        }
        return this.nCU.get(nameMd5FromUrl);
    }

    public void dSx() {
        if (!StringUtils.isNull(nIy)) {
            if (this.nCU == null) {
                this.nCU = new HashMap<>();
            } else {
                this.nCU.clear();
            }
            File file = new File(nIy);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nCU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void TA(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nIy)) {
            if (this.nIA != null) {
                this.nIA.Te("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nIy);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nIz == null) {
                this.nIz = new ArrayList();
            }
            if (!TB(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nIy + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nIC);
                this.nIz.add(downloadData);
                com.baidu.tbadk.download.d.bAL().f(downloadData);
            }
        }
    }

    private boolean TB(String str) {
        if (x.isEmpty(this.nIz) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nIz) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.nIz) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nIz.size()) {
                    i = -1;
                    break;
                } else if (this.nIz.get(i) != null && this.nIz.get(i).getUrl() != null && this.nIz.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nIz.remove(i);
        }
    }

    public void a(a aVar) {
        this.nIA = aVar;
    }

    public void TC(String str) {
        if (str == null) {
            this.nIB = "";
        } else {
            this.nIB = str;
        }
    }
}
