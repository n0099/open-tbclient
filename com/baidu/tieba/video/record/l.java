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
    public static final String mCI;
    private List<DownloadData> mCJ;
    private a mCK;
    private String mCL;
    private com.baidu.tbadk.download.c mCM = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mCK != null && l.this.mCL.equals(downloadData.getUrl())) {
                    l.this.mCK.dBn();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mCI)) {
                l.this.w(downloadData);
                if (l.this.mCK != null && l.this.mCL.equals(downloadData.getUrl())) {
                    l.this.mwp.put(downloadData.getPath().substring(l.mCI.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mCK.fY(l.this.mCL, downloadData.getPath());
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
            if (l.this.mCK != null && l.this.mCL.equals(downloadData.getUrl())) {
                l.this.mCK.RC(str);
            }
        }
    };
    private HashMap<String, String> mwp;

    /* loaded from: classes17.dex */
    public interface a {
        void RC(String str);

        void dBn();

        void fY(String str, String str2);
    }

    static {
        mCI = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Sa(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mwp == null) {
            this.mwp = new HashMap<>();
            dEb();
        }
        return this.mwp.get(nameMd5FromUrl);
    }

    public void dEb() {
        if (!StringUtils.isNull(mCI)) {
            if (this.mwp == null) {
                this.mwp = new HashMap<>();
            } else {
                this.mwp.clear();
            }
            File file = new File(mCI);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.mwp.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Sb(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mCI)) {
            if (this.mCK != null) {
                this.mCK.RC("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mCI);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mCJ == null) {
                this.mCJ = new ArrayList();
            }
            if (!Sc(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mCI + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mCM);
                this.mCJ.add(downloadData);
                com.baidu.tbadk.download.d.brs().f(downloadData);
            }
        }
    }

    private boolean Sc(String str) {
        if (y.isEmpty(this.mCJ) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mCJ) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.mCJ) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mCJ.size()) {
                    i = -1;
                    break;
                } else if (this.mCJ.get(i) != null && this.mCJ.get(i).getUrl() != null && this.mCJ.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mCJ.remove(i);
        }
    }

    public void a(a aVar) {
        this.mCK = aVar;
    }

    public void Sd(String str) {
        if (str == null) {
            this.mCL = "";
        } else {
            this.mCL = str;
        }
    }
}
