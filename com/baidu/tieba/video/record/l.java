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
/* loaded from: classes17.dex */
public class l {
    public static final String mCp;
    private List<DownloadData> mCq;
    private a mCr;
    private String mCs;
    private com.baidu.tbadk.download.c mCt = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mCr != null && l.this.mCs.equals(downloadData.getUrl())) {
                    l.this.mCr.dBe();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mCp)) {
                l.this.w(downloadData);
                if (l.this.mCr != null && l.this.mCs.equals(downloadData.getUrl())) {
                    l.this.mvX.put(downloadData.getPath().substring(l.mCp.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mCr.fX(l.this.mCs, downloadData.getPath());
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
            if (l.this.mCr != null && l.this.mCs.equals(downloadData.getUrl())) {
                l.this.mCr.RC(str);
            }
        }
    };
    private HashMap<String, String> mvX;

    /* loaded from: classes17.dex */
    public interface a {
        void RC(String str);

        void dBe();

        void fX(String str, String str2);
    }

    static {
        mCp = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Sa(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mvX == null) {
            this.mvX = new HashMap<>();
            dDS();
        }
        return this.mvX.get(nameMd5FromUrl);
    }

    public void dDS() {
        if (!StringUtils.isNull(mCp)) {
            if (this.mvX == null) {
                this.mvX = new HashMap<>();
            } else {
                this.mvX.clear();
            }
            File file = new File(mCp);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.mvX.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Sb(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mCp)) {
            if (this.mCr != null) {
                this.mCr.RC("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mCp);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mCq == null) {
                this.mCq = new ArrayList();
            }
            if (!Sc(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mCp + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mCt);
                this.mCq.add(downloadData);
                com.baidu.tbadk.download.d.brr().f(downloadData);
            }
        }
    }

    private boolean Sc(String str) {
        if (y.isEmpty(this.mCq) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mCq) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.mCq) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mCq.size()) {
                    i = -1;
                    break;
                } else if (this.mCq.get(i) != null && this.mCq.get(i).getUrl() != null && this.mCq.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mCq.remove(i);
        }
    }

    public void a(a aVar) {
        this.mCr = aVar;
    }

    public void Sd(String str) {
        if (str == null) {
            this.mCs = "";
        } else {
            this.mCs = str;
        }
    }
}
