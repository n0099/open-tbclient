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
    public static final String hzM;
    private HashMap<String, String> htp;
    private List<DownloadData> hzN;
    private a hzO;
    private String hzP;
    private com.baidu.tbadk.download.c hzQ = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hzO != null && l.this.hzP.equals(downloadData.getUrl())) {
                    l.this.hzO.bGw();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hzM)) {
                l.this.v(downloadData);
                if (l.this.hzO != null && l.this.hzP.equals(downloadData.getUrl())) {
                    l.this.htp.put(downloadData.getPath().substring(l.hzM.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hzO.cM(l.this.hzP, downloadData.getPath());
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
            if (l.this.hzO != null && l.this.hzP.equals(downloadData.getUrl())) {
                l.this.hzO.vR(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void bGw();

        void cM(String str, String str2);

        void vR(String str);
    }

    static {
        hzM = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String wo(String str) {
        String fs = ar.fs(str);
        if (fs == null) {
            return null;
        }
        if (this.htp == null) {
            this.htp = new HashMap<>();
            bJr();
        }
        return this.htp.get(fs);
    }

    public void bJr() {
        if (!StringUtils.isNull(hzM)) {
            if (this.htp == null) {
                this.htp = new HashMap<>();
            } else {
                this.htp.clear();
            }
            File file = new File(hzM);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.htp.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void wp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hzM)) {
            if (this.hzO != null) {
                this.hzO.vR("");
                return;
            }
            return;
        }
        String fs = ar.fs(str);
        if (fs != null) {
            File file = new File(hzM);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hzN == null) {
                this.hzN = new ArrayList();
            }
            if (!wq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hzM + "/" + fs + str2);
                downloadData.setCallback(this.hzQ);
                this.hzN.add(downloadData);
                com.baidu.tbadk.download.d.KB().f(downloadData);
            }
        }
    }

    private boolean wq(String str) {
        if (v.J(this.hzN) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hzN) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.J(this.hzN) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hzN.size()) {
                    i = -1;
                    break;
                } else if (this.hzN.get(i) != null && this.hzN.get(i).getUrl() != null && this.hzN.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hzN.remove(i);
        }
    }

    public void a(a aVar) {
        this.hzO = aVar;
    }

    public void wr(String str) {
        if (str == null) {
            this.hzP = "";
        } else {
            this.hzP = str;
        }
    }
}
