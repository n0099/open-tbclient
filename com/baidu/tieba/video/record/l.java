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
    public static final String mkE;
    private HashMap<String, String> mek;
    private List<DownloadData> mkF;
    private a mkG;
    private String mkH;
    private com.baidu.tbadk.download.c mkI = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mkG != null && l.this.mkH.equals(downloadData.getUrl())) {
                    l.this.mkG.dpI();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mkE)) {
                l.this.w(downloadData);
                if (l.this.mkG != null && l.this.mkH.equals(downloadData.getUrl())) {
                    l.this.mek.put(downloadData.getPath().substring(l.mkE.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mkG.fG(l.this.mkH, downloadData.getPath());
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
            if (l.this.mkG != null && l.this.mkH.equals(downloadData.getUrl())) {
                l.this.mkG.OE(str);
            }
        }
    };

    /* loaded from: classes17.dex */
    public interface a {
        void OE(String str);

        void dpI();

        void fG(String str, String str2);
    }

    static {
        mkE = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Pc(String str) {
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mek == null) {
            this.mek = new HashMap<>();
            dsw();
        }
        return this.mek.get(nameMd5FromUrl);
    }

    public void dsw() {
        if (!StringUtils.isNull(mkE)) {
            if (this.mek == null) {
                this.mek = new HashMap<>();
            } else {
                this.mek.clear();
            }
            File file = new File(mkE);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.mek.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Pd(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mkE)) {
            if (this.mkG != null) {
                this.mkG.OE("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mkE);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mkF == null) {
                this.mkF = new ArrayList();
            }
            if (!Pe(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mkE + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mkI);
                this.mkF.add(downloadData);
                com.baidu.tbadk.download.d.biF().f(downloadData);
            }
        }
    }

    private boolean Pe(String str) {
        if (x.isEmpty(this.mkF) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mkF) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.mkF) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mkF.size()) {
                    i = -1;
                    break;
                } else if (this.mkF.get(i) != null && this.mkF.get(i).getUrl() != null && this.mkF.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mkF.remove(i);
        }
    }

    public void a(a aVar) {
        this.mkG = aVar;
    }

    public void Pf(String str) {
        if (str == null) {
            this.mkH = "";
        } else {
            this.mkH = str;
        }
    }
}
