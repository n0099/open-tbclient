package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes17.dex */
public class l {
    public static final String mkG;
    private HashMap<String, String> men;
    private List<DownloadData> mkH;
    private a mkI;
    private String mkJ;
    private com.baidu.tbadk.download.c mkK = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mkI != null && l.this.mkJ.equals(downloadData.getUrl())) {
                    l.this.mkI.dpJ();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mkG)) {
                l.this.w(downloadData);
                if (l.this.mkI != null && l.this.mkJ.equals(downloadData.getUrl())) {
                    l.this.men.put(downloadData.getPath().substring(l.mkG.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mkI.fG(l.this.mkJ, downloadData.getPath());
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
            if (l.this.mkI != null && l.this.mkJ.equals(downloadData.getUrl())) {
                l.this.mkI.OE(str);
            }
        }
    };

    /* loaded from: classes17.dex */
    public interface a {
        void OE(String str);

        void dpJ();

        void fG(String str, String str2);
    }

    static {
        mkG = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Pc(String str) {
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.men == null) {
            this.men = new HashMap<>();
            dsx();
        }
        return this.men.get(nameMd5FromUrl);
    }

    public void dsx() {
        if (!StringUtils.isNull(mkG)) {
            if (this.men == null) {
                this.men = new HashMap<>();
            } else {
                this.men.clear();
            }
            File file = new File(mkG);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.men.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Pd(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mkG)) {
            if (this.mkI != null) {
                this.mkI.OE("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mkG);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mkH == null) {
                this.mkH = new ArrayList();
            }
            if (!Pe(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mkG + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mkK);
                this.mkH.add(downloadData);
                com.baidu.tbadk.download.d.biF().f(downloadData);
            }
        }
    }

    private boolean Pe(String str) {
        if (x.isEmpty(this.mkH) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mkH) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.mkH) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mkH.size()) {
                    i = -1;
                    break;
                } else if (this.mkH.get(i) != null && this.mkH.get(i).getUrl() != null && this.mkH.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mkH.remove(i);
        }
    }

    public void a(a aVar) {
        this.mkI = aVar;
    }

    public void Pf(String str) {
        if (str == null) {
            this.mkJ = "";
        } else {
            this.mkJ = str;
        }
    }
}
