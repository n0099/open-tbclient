package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String hkI;
    private HashMap<String, String> heg;
    private List<DownloadData> hkJ;
    private a hkK;
    private String hkL;
    private com.baidu.tbadk.download.c hkM = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hkK != null && l.this.hkL.equals(downloadData.getUrl())) {
                    l.this.hkK.bAr();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hkI)) {
                l.this.v(downloadData);
                if (l.this.hkK != null && l.this.hkL.equals(downloadData.getUrl())) {
                    l.this.heg.put(downloadData.getPath().substring(l.hkI.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hkK.cr(l.this.hkL, downloadData.getPath());
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
            if (l.this.hkK != null && l.this.hkL.equals(downloadData.getUrl())) {
                l.this.hkK.uC(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAr();

        void cr(String str, String str2);

        void uC(String str);
    }

    static {
        hkI = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String va(String str) {
        String eM = as.eM(str);
        if (eM == null) {
            return null;
        }
        if (this.heg == null) {
            this.heg = new HashMap<>();
            bDn();
        }
        return this.heg.get(eM);
    }

    public void bDn() {
        if (!StringUtils.isNull(hkI)) {
            if (this.heg == null) {
                this.heg = new HashMap<>();
            } else {
                this.heg.clear();
            }
            File file = new File(hkI);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.heg.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void vb(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hkI)) {
            if (this.hkK != null) {
                this.hkK.uC("");
                return;
            }
            return;
        }
        String eM = as.eM(str);
        if (eM != null) {
            File file = new File(hkI);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hkJ == null) {
                this.hkJ = new ArrayList();
            }
            if (!vc(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hkI + "/" + eM + str2);
                downloadData.setCallback(this.hkM);
                this.hkJ.add(downloadData);
                com.baidu.tbadk.download.d.Hn().f(downloadData);
            }
        }
    }

    private boolean vc(String str) {
        if (w.z(this.hkJ) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hkJ) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!w.z(this.hkJ) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hkJ.size()) {
                    i = -1;
                    break;
                } else if (this.hkJ.get(i) != null && this.hkJ.get(i).getUrl() != null && this.hkJ.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hkJ.remove(i);
        }
    }

    public void a(a aVar) {
        this.hkK = aVar;
    }

    public void vd(String str) {
        if (str == null) {
            this.hkL = "";
        } else {
            this.hkL = str;
        }
    }
}
