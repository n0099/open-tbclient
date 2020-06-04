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
/* loaded from: classes10.dex */
public class l {
    public static final String lJu;
    private HashMap<String, String> lDi;
    private List<DownloadData> lJv;
    private a lJw;
    private String lJx;
    private com.baidu.tbadk.download.c lJy = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.lJw != null && l.this.lJx.equals(downloadData.getUrl())) {
                    l.this.lJw.dii();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.lJu)) {
                l.this.w(downloadData);
                if (l.this.lJw != null && l.this.lJx.equals(downloadData.getUrl())) {
                    l.this.lDi.put(downloadData.getPath().substring(l.lJu.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.lJw.fx(l.this.lJx, downloadData.getPath());
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
            if (l.this.lJw != null && l.this.lJx.equals(downloadData.getUrl())) {
                l.this.lJw.Nu(str);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Nu(String str);

        void dii();

        void fx(String str, String str2);
    }

    static {
        lJu = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String NR(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lDi == null) {
            this.lDi = new HashMap<>();
            dkX();
        }
        return this.lDi.get(nameMd5FromUrl);
    }

    public void dkX() {
        if (!StringUtils.isNull(lJu)) {
            if (this.lDi == null) {
                this.lDi = new HashMap<>();
            } else {
                this.lDi.clear();
            }
            File file = new File(lJu);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.lDi.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void NS(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(lJu)) {
            if (this.lJw != null) {
                this.lJw.Nu("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(lJu);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.lJv == null) {
                this.lJv = new ArrayList();
            }
            if (!NT(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(lJu + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.lJy);
                this.lJv.add(downloadData);
                com.baidu.tbadk.download.d.bcU().f(downloadData);
            }
        }
    }

    private boolean NT(String str) {
        if (v.isEmpty(this.lJv) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.lJv) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.lJv) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.lJv.size()) {
                    i = -1;
                    break;
                } else if (this.lJv.get(i) != null && this.lJv.get(i).getUrl() != null && this.lJv.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.lJv.remove(i);
        }
    }

    public void a(a aVar) {
        this.lJw = aVar;
    }

    public void NU(String str) {
        if (str == null) {
            this.lJx = "";
        } else {
            this.lJx = str;
        }
    }
}
