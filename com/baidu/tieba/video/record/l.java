package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes23.dex */
public class l {
    public static final String ncc;
    private HashMap<String, String> mVN;
    private List<DownloadData> ncd;
    private a nce;
    private String ncf;
    private com.baidu.tbadk.download.c ncg = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nce != null && l.this.ncf.equals(downloadData.getUrl())) {
                    l.this.nce.dIT();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.ncc)) {
                l.this.w(downloadData);
                if (l.this.nce != null && l.this.ncf.equals(downloadData.getUrl())) {
                    l.this.mVN.put(downloadData.getPath().substring(l.ncc.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nce.gr(l.this.ncf, downloadData.getPath());
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
            if (l.this.nce != null && l.this.ncf.equals(downloadData.getUrl())) {
                l.this.nce.SQ(str);
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void SQ(String str);

        void dIT();

        void gr(String str, String str2);
    }

    static {
        ncc = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String To(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mVN == null) {
            this.mVN = new HashMap<>();
            dLH();
        }
        return this.mVN.get(nameMd5FromUrl);
    }

    public void dLH() {
        if (!StringUtils.isNull(ncc)) {
            if (this.mVN == null) {
                this.mVN = new HashMap<>();
            } else {
                this.mVN.clear();
            }
            File file = new File(ncc);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.mVN.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Tp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(ncc)) {
            if (this.nce != null) {
                this.nce.SQ("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(ncc);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.ncd == null) {
                this.ncd = new ArrayList();
            }
            if (!Tq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(ncc + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.ncg);
                this.ncd.add(downloadData);
                com.baidu.tbadk.download.d.bvb().f(downloadData);
            }
        }
    }

    private boolean Tq(String str) {
        if (y.isEmpty(this.ncd) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.ncd) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.ncd) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.ncd.size()) {
                    i = -1;
                    break;
                } else if (this.ncd.get(i) != null && this.ncd.get(i).getUrl() != null && this.ncd.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.ncd.remove(i);
        }
    }

    public void a(a aVar) {
        this.nce = aVar;
    }

    public void Tr(String str) {
        if (str == null) {
            this.ncf = "";
        } else {
            this.ncf = str;
        }
    }
}
