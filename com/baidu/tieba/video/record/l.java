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
/* loaded from: classes22.dex */
public class l {
    public static final String mMw;
    private HashMap<String, String> mGa;
    private com.baidu.tbadk.download.c mMA = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mMy != null && l.this.mMz.equals(downloadData.getUrl())) {
                    l.this.mMy.dFh();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mMw)) {
                l.this.w(downloadData);
                if (l.this.mMy != null && l.this.mMz.equals(downloadData.getUrl())) {
                    l.this.mGa.put(downloadData.getPath().substring(l.mMw.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mMy.gk(l.this.mMz, downloadData.getPath());
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
            if (l.this.mMy != null && l.this.mMz.equals(downloadData.getUrl())) {
                l.this.mMy.Sc(str);
            }
        }
    };
    private List<DownloadData> mMx;
    private a mMy;
    private String mMz;

    /* loaded from: classes22.dex */
    public interface a {
        void Sc(String str);

        void dFh();

        void gk(String str, String str2);
    }

    static {
        mMw = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String SA(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mGa == null) {
            this.mGa = new HashMap<>();
            dHV();
        }
        return this.mGa.get(nameMd5FromUrl);
    }

    public void dHV() {
        if (!StringUtils.isNull(mMw)) {
            if (this.mGa == null) {
                this.mGa = new HashMap<>();
            } else {
                this.mGa.clear();
            }
            File file = new File(mMw);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.mGa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void SB(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mMw)) {
            if (this.mMy != null) {
                this.mMy.Sc("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mMw);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mMx == null) {
                this.mMx = new ArrayList();
            }
            if (!SC(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mMw + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mMA);
                this.mMx.add(downloadData);
                com.baidu.tbadk.download.d.bsr().f(downloadData);
            }
        }
    }

    private boolean SC(String str) {
        if (y.isEmpty(this.mMx) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mMx) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.mMx) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mMx.size()) {
                    i = -1;
                    break;
                } else if (this.mMx.get(i) != null && this.mMx.get(i).getUrl() != null && this.mMx.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mMx.remove(i);
        }
    }

    public void a(a aVar) {
        this.mMy = aVar;
    }

    public void SD(String str) {
        if (str == null) {
            this.mMz = "";
        } else {
            this.mMz = str;
        }
    }
}
