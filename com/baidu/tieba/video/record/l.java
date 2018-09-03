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
    public static final String hkJ;
    private HashMap<String, String> heh;
    private List<DownloadData> hkK;
    private a hkL;
    private String hkM;
    private com.baidu.tbadk.download.c hkN = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hkL != null && l.this.hkM.equals(downloadData.getUrl())) {
                    l.this.hkL.bAt();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hkJ)) {
                l.this.v(downloadData);
                if (l.this.hkL != null && l.this.hkM.equals(downloadData.getUrl())) {
                    l.this.heh.put(downloadData.getPath().substring(l.hkJ.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hkL.cr(l.this.hkM, downloadData.getPath());
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
            if (l.this.hkL != null && l.this.hkM.equals(downloadData.getUrl())) {
                l.this.hkL.uG(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bAt();

        void cr(String str, String str2);

        void uG(String str);
    }

    static {
        hkJ = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String ve(String str) {
        String eM = as.eM(str);
        if (eM == null) {
            return null;
        }
        if (this.heh == null) {
            this.heh = new HashMap<>();
            bDp();
        }
        return this.heh.get(eM);
    }

    public void bDp() {
        if (!StringUtils.isNull(hkJ)) {
            if (this.heh == null) {
                this.heh = new HashMap<>();
            } else {
                this.heh.clear();
            }
            File file = new File(hkJ);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.heh.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void vf(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hkJ)) {
            if (this.hkL != null) {
                this.hkL.uG("");
                return;
            }
            return;
        }
        String eM = as.eM(str);
        if (eM != null) {
            File file = new File(hkJ);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hkK == null) {
                this.hkK = new ArrayList();
            }
            if (!vg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hkJ + "/" + eM + str2);
                downloadData.setCallback(this.hkN);
                this.hkK.add(downloadData);
                com.baidu.tbadk.download.d.Hn().f(downloadData);
            }
        }
    }

    private boolean vg(String str) {
        if (w.z(this.hkK) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hkK) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!w.z(this.hkK) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hkK.size()) {
                    i = -1;
                    break;
                } else if (this.hkK.get(i) != null && this.hkK.get(i).getUrl() != null && this.hkK.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hkK.remove(i);
        }
    }

    public void a(a aVar) {
        this.hkL = aVar;
    }

    public void vh(String str) {
        if (str == null) {
            this.hkM = "";
        } else {
            this.hkM = str;
        }
    }
}
