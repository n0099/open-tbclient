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
    public static final String nJH;
    private HashMap<String, String> nDt;
    private List<DownloadData> nJI;
    private a nJJ;
    private String nJK;
    private com.baidu.tbadk.download.c nJL = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nJJ != null && l.this.nJK.equals(downloadData.getUrl())) {
                    l.this.nJJ.dTU();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nJH)) {
                l.this.w(downloadData);
                if (l.this.nJJ != null && l.this.nJK.equals(downloadData.getUrl())) {
                    l.this.nDt.put(downloadData.getPath().substring(l.nJH.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nJJ.gB(l.this.nJK, downloadData.getPath());
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
            if (l.this.nJJ != null && l.this.nJK.equals(downloadData.getUrl())) {
                l.this.nJJ.UG(str);
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void UG(String str);

        void dTU();

        void gB(String str, String str2);
    }

    static {
        nJH = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ve(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nDt == null) {
            this.nDt = new HashMap<>();
            dWK();
        }
        return this.nDt.get(nameMd5FromUrl);
    }

    public void dWK() {
        if (!StringUtils.isNull(nJH)) {
            if (this.nDt == null) {
                this.nDt = new HashMap<>();
            } else {
                this.nDt.clear();
            }
            File file = new File(nJH);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nDt.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Vf(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nJH)) {
            if (this.nJJ != null) {
                this.nJJ.UG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nJH);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nJI == null) {
                this.nJI = new ArrayList();
            }
            if (!Vg(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nJH + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nJL);
                this.nJI.add(downloadData);
                com.baidu.tbadk.download.d.bCj().f(downloadData);
            }
        }
    }

    private boolean Vg(String str) {
        if (y.isEmpty(this.nJI) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nJI) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nJI) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nJI.size()) {
                    i = -1;
                    break;
                } else if (this.nJI.get(i) != null && this.nJI.get(i).getUrl() != null && this.nJI.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nJI.remove(i);
        }
    }

    public void a(a aVar) {
        this.nJJ = aVar;
    }

    public void Vh(String str) {
        if (str == null) {
            this.nJK = "";
        } else {
            this.nJK = str;
        }
    }
}
