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
/* loaded from: classes10.dex */
public class l {
    public static final String kDg;
    private List<DownloadData> kDh;
    private a kDi;
    private String kDj;
    private com.baidu.tbadk.download.c kDk = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kDi != null && l.this.kDj.equals(downloadData.getUrl())) {
                    l.this.kDi.cPo();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kDg)) {
                l.this.w(downloadData);
                if (l.this.kDi != null && l.this.kDj.equals(downloadData.getUrl())) {
                    l.this.kxa.put(downloadData.getPath().substring(l.kDg.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kDi.eJ(l.this.kDj, downloadData.getPath());
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
            if (l.this.kDi != null && l.this.kDj.equals(downloadData.getUrl())) {
                l.this.kDi.JT(str);
            }
        }
    };
    private HashMap<String, String> kxa;

    /* loaded from: classes10.dex */
    public interface a {
        void JT(String str);

        void cPo();

        void eJ(String str, String str2);
    }

    static {
        kDg = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ko(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxa == null) {
            this.kxa = new HashMap<>();
            cRY();
        }
        return this.kxa.get(nameMd5FromUrl);
    }

    public void cRY() {
        if (!StringUtils.isNull(kDg)) {
            if (this.kxa == null) {
                this.kxa = new HashMap<>();
            } else {
                this.kxa.clear();
            }
            File file = new File(kDg);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kxa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kDg)) {
            if (this.kDi != null) {
                this.kDi.JT("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kDg);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kDh == null) {
                this.kDh = new ArrayList();
            }
            if (!Kq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kDg + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kDk);
                this.kDh.add(downloadData);
                com.baidu.tbadk.download.d.aOn().f(downloadData);
            }
        }
    }

    private boolean Kq(String str) {
        if (v.isEmpty(this.kDh) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kDh) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kDh) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kDh.size()) {
                    i = -1;
                    break;
                } else if (this.kDh.get(i) != null && this.kDh.get(i).getUrl() != null && this.kDh.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kDh.remove(i);
        }
    }

    public void a(a aVar) {
        this.kDi = aVar;
    }

    public void Kr(String str) {
        if (str == null) {
            this.kDj = "";
        } else {
            this.kDj = str;
        }
    }
}
