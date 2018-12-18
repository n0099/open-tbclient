package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {
    public static final String hII;
    private HashMap<String, String> hCk;
    private List<DownloadData> hIJ;
    private a hIK;
    private String hIL;
    private com.baidu.tbadk.download.c hIM = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hIK != null && l.this.hIL.equals(downloadData.getUrl())) {
                    l.this.hIK.bHZ();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hII)) {
                l.this.v(downloadData);
                if (l.this.hIK != null && l.this.hIL.equals(downloadData.getUrl())) {
                    l.this.hCk.put(downloadData.getPath().substring(l.hII.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hIK.cR(l.this.hIL, downloadData.getPath());
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
            if (l.this.hIK != null && l.this.hIL.equals(downloadData.getUrl())) {
                l.this.hIK.wz(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void bHZ();

        void cR(String str, String str2);

        void wz(String str);
    }

    static {
        hII = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String wW(String str) {
        String fK = ar.fK(str);
        if (fK == null) {
            return null;
        }
        if (this.hCk == null) {
            this.hCk = new HashMap<>();
            bKU();
        }
        return this.hCk.get(fK);
    }

    public void bKU() {
        if (!StringUtils.isNull(hII)) {
            if (this.hCk == null) {
                this.hCk = new HashMap<>();
            } else {
                this.hCk.clear();
            }
            File file = new File(hII);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hCk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void wX(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hII)) {
            if (this.hIK != null) {
                this.hIK.wz("");
                return;
            }
            return;
        }
        String fK = ar.fK(str);
        if (fK != null) {
            File file = new File(hII);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hIJ == null) {
                this.hIJ = new ArrayList();
            }
            if (!wY(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hII + "/" + fK + str2);
                downloadData.setCallback(this.hIM);
                this.hIJ.add(downloadData);
                com.baidu.tbadk.download.d.LR().f(downloadData);
            }
        }
    }

    private boolean wY(String str) {
        if (v.I(this.hIJ) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hIJ) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.I(this.hIJ) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hIJ.size()) {
                    i = -1;
                    break;
                } else if (this.hIJ.get(i) != null && this.hIJ.get(i).getUrl() != null && this.hIJ.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hIJ.remove(i);
        }
    }

    public void a(a aVar) {
        this.hIK = aVar;
    }

    public void wZ(String str) {
        if (str == null) {
            this.hIL = "";
        } else {
            this.hIL = str;
        }
    }
}
