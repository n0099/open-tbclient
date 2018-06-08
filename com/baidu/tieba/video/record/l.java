package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String hfn;
    private HashMap<String, String> gYP;
    private List<DownloadData> hfo;
    private a hfp;
    private String hfq;
    private com.baidu.tbadk.download.d hfr = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.x(downloadData);
                if (l.this.hfp != null && l.this.hfq.equals(downloadData.getUrl())) {
                    l.this.hfp.bBg();
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hfn)) {
                l.this.x(downloadData);
                if (l.this.hfp != null && l.this.hfq.equals(downloadData.getUrl())) {
                    l.this.gYP.put(downloadData.getPath().substring(l.hfn.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hfp.cq(l.this.hfq, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.x(downloadData);
            if (l.this.hfp != null && l.this.hfq.equals(downloadData.getUrl())) {
                l.this.hfp.uI(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bBg();

        void cq(String str, String str2);

        void uI(String str);
    }

    static {
        hfn = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String vg(String str) {
        String eL = ar.eL(str);
        if (eL == null) {
            return null;
        }
        if (this.gYP == null) {
            this.gYP = new HashMap<>();
            bEd();
        }
        return this.gYP.get(eL);
    }

    public void bEd() {
        if (!StringUtils.isNull(hfn)) {
            if (this.gYP == null) {
                this.gYP = new HashMap<>();
            } else {
                this.gYP.clear();
            }
            File file = new File(hfn);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gYP.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void vh(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hfn)) {
            if (this.hfp != null) {
                this.hfp.uI("");
                return;
            }
            return;
        }
        String eL = ar.eL(str);
        if (eL != null) {
            File file = new File(hfn);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hfo == null) {
                this.hfo = new ArrayList();
            }
            if (!gw(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hfn + "/" + eL + str2);
                downloadData.setCallback(this.hfr);
                this.hfo.add(downloadData);
                com.baidu.tbadk.download.e.GZ().f(downloadData);
            }
        }
    }

    private boolean gw(String str) {
        if (w.z(this.hfo) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hfo) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!w.z(this.hfo) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hfo.size()) {
                    i = -1;
                    break;
                } else if (this.hfo.get(i) != null && this.hfo.get(i).getUrl() != null && this.hfo.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hfo.remove(i);
        }
    }

    public void a(a aVar) {
        this.hfp = aVar;
    }

    public void vi(String str) {
        if (str == null) {
            this.hfq = "";
        } else {
            this.hfq = str;
        }
    }
}
