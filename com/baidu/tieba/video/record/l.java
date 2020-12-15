package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes23.dex */
public class l {
    public static final String nJJ;
    private HashMap<String, String> nDv;
    private List<DownloadData> nJK;
    private a nJL;
    private String nJM;
    private com.baidu.tbadk.download.c nJN = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nJL != null && l.this.nJM.equals(downloadData.getUrl())) {
                    l.this.nJL.dTV();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nJJ)) {
                l.this.w(downloadData);
                if (l.this.nJL != null && l.this.nJM.equals(downloadData.getUrl())) {
                    l.this.nDv.put(downloadData.getPath().substring(l.nJJ.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nJL.gB(l.this.nJM, downloadData.getPath());
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
            if (l.this.nJL != null && l.this.nJM.equals(downloadData.getUrl())) {
                l.this.nJL.UG(str);
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void UG(String str);

        void dTV();

        void gB(String str, String str2);
    }

    static {
        nJJ = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ve(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nDv == null) {
            this.nDv = new HashMap<>();
            dWL();
        }
        return this.nDv.get(nameMd5FromUrl);
    }

    public void dWL() {
        if (!StringUtils.isNull(nJJ)) {
            if (this.nDv == null) {
                this.nDv = new HashMap<>();
            } else {
                this.nDv.clear();
            }
            File file = new File(nJJ);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nDv.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Vf(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nJJ)) {
            if (this.nJL != null) {
                this.nJL.UG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nJJ);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nJK == null) {
                this.nJK = new ArrayList();
            }
            if (!Vg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nJJ + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nJN);
                this.nJK.add(downloadData);
                com.baidu.tbadk.download.d.bCj().f(downloadData);
            }
        }
    }

    private boolean Vg(String str) {
        if (y.isEmpty(this.nJK) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nJK) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nJK) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nJK.size()) {
                    i = -1;
                    break;
                } else if (this.nJK.get(i) != null && this.nJK.get(i).getUrl() != null && this.nJK.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nJK.remove(i);
        }
    }

    public void a(a aVar) {
        this.nJL = aVar;
    }

    public void Vh(String str) {
        if (str == null) {
            this.nJM = "";
        } else {
            this.nJM = str;
        }
    }
}
