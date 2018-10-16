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
    public static final String hzL;
    private HashMap<String, String> hto;
    private List<DownloadData> hzM;
    private a hzN;
    private String hzO;
    private com.baidu.tbadk.download.c hzP = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hzN != null && l.this.hzO.equals(downloadData.getUrl())) {
                    l.this.hzN.bGw();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hzL)) {
                l.this.v(downloadData);
                if (l.this.hzN != null && l.this.hzO.equals(downloadData.getUrl())) {
                    l.this.hto.put(downloadData.getPath().substring(l.hzL.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hzN.cM(l.this.hzO, downloadData.getPath());
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
            if (l.this.hzN != null && l.this.hzO.equals(downloadData.getUrl())) {
                l.this.hzN.vR(str);
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
        hzL = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String wo(String str) {
        String fs = ar.fs(str);
        if (fs == null) {
            return null;
        }
        if (this.hto == null) {
            this.hto = new HashMap<>();
            bJr();
        }
        return this.hto.get(fs);
    }

    public void bJr() {
        if (!StringUtils.isNull(hzL)) {
            if (this.hto == null) {
                this.hto = new HashMap<>();
            } else {
                this.hto.clear();
            }
            File file = new File(hzL);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hto.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void wp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hzL)) {
            if (this.hzN != null) {
                this.hzN.vR("");
                return;
            }
            return;
        }
        String fs = ar.fs(str);
        if (fs != null) {
            File file = new File(hzL);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hzM == null) {
                this.hzM = new ArrayList();
            }
            if (!wq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hzL + "/" + fs + str2);
                downloadData.setCallback(this.hzP);
                this.hzM.add(downloadData);
                com.baidu.tbadk.download.d.KB().f(downloadData);
            }
        }
    }

    private boolean wq(String str) {
        if (v.J(this.hzM) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hzM) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.J(this.hzM) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hzM.size()) {
                    i = -1;
                    break;
                } else if (this.hzM.get(i) != null && this.hzM.get(i).getUrl() != null && this.hzM.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hzM.remove(i);
        }
    }

    public void a(a aVar) {
        this.hzN = aVar;
    }

    public void wr(String str) {
        if (str == null) {
            this.hzO = "";
        } else {
            this.hzO = str;
        }
    }
}
