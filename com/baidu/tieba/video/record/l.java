package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    public static final String kCg;
    private List<DownloadData> kCh;
    private a kCi;
    private String kCj;
    private com.baidu.tbadk.download.c kCk = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kCi != null && l.this.kCj.equals(downloadData.getUrl())) {
                    l.this.kCi.cNR();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kCg)) {
                l.this.w(downloadData);
                if (l.this.kCi != null && l.this.kCj.equals(downloadData.getUrl())) {
                    l.this.kwa.put(downloadData.getPath().substring(l.kCg.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kCi.eA(l.this.kCj, downloadData.getPath());
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
            if (l.this.kCi != null && l.this.kCj.equals(downloadData.getUrl())) {
                l.this.kCi.JG(str);
            }
        }
    };
    private HashMap<String, String> kwa;

    /* loaded from: classes8.dex */
    public interface a {
        void JG(String str);

        void cNR();

        void eA(String str, String str2);
    }

    static {
        kCg = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Kb(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kwa == null) {
            this.kwa = new HashMap<>();
            cQD();
        }
        return this.kwa.get(nameMd5FromUrl);
    }

    public void cQD() {
        if (!StringUtils.isNull(kCg)) {
            if (this.kwa == null) {
                this.kwa = new HashMap<>();
            } else {
                this.kwa.clear();
            }
            File file = new File(kCg);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kwa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kc(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kCg)) {
            if (this.kCi != null) {
                this.kCi.JG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kCg);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kCh == null) {
                this.kCh = new ArrayList();
            }
            if (!Kd(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kCg + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kCk);
                this.kCh.add(downloadData);
                com.baidu.tbadk.download.d.aLR().f(downloadData);
            }
        }
    }

    private boolean Kd(String str) {
        if (v.isEmpty(this.kCh) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kCh) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kCh) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kCh.size()) {
                    i = -1;
                    break;
                } else if (this.kCh.get(i) != null && this.kCh.get(i).getUrl() != null && this.kCh.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kCh.remove(i);
        }
    }

    public void a(a aVar) {
        this.kCi = aVar;
    }

    public void Ke(String str) {
        if (str == null) {
            this.kCj = "";
        } else {
            this.kCj = str;
        }
    }
}
