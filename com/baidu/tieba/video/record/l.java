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
    public static final String kDi;
    private List<DownloadData> kDj;
    private a kDk;
    private String kDl;
    private com.baidu.tbadk.download.c kDm = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kDk != null && l.this.kDl.equals(downloadData.getUrl())) {
                    l.this.kDk.cPq();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kDi)) {
                l.this.w(downloadData);
                if (l.this.kDk != null && l.this.kDl.equals(downloadData.getUrl())) {
                    l.this.kxc.put(downloadData.getPath().substring(l.kDi.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kDk.eJ(l.this.kDl, downloadData.getPath());
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
            if (l.this.kDk != null && l.this.kDl.equals(downloadData.getUrl())) {
                l.this.kDk.JT(str);
            }
        }
    };
    private HashMap<String, String> kxc;

    /* loaded from: classes10.dex */
    public interface a {
        void JT(String str);

        void cPq();

        void eJ(String str, String str2);
    }

    static {
        kDi = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ko(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxc == null) {
            this.kxc = new HashMap<>();
            cSa();
        }
        return this.kxc.get(nameMd5FromUrl);
    }

    public void cSa() {
        if (!StringUtils.isNull(kDi)) {
            if (this.kxc == null) {
                this.kxc = new HashMap<>();
            } else {
                this.kxc.clear();
            }
            File file = new File(kDi);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kxc.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kDi)) {
            if (this.kDk != null) {
                this.kDk.JT("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kDi);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kDj == null) {
                this.kDj = new ArrayList();
            }
            if (!Kq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kDi + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kDm);
                this.kDj.add(downloadData);
                com.baidu.tbadk.download.d.aOp().f(downloadData);
            }
        }
    }

    private boolean Kq(String str) {
        if (v.isEmpty(this.kDj) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kDj) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kDj) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kDj.size()) {
                    i = -1;
                    break;
                } else if (this.kDj.get(i) != null && this.kDj.get(i).getUrl() != null && this.kDj.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kDj.remove(i);
        }
    }

    public void a(a aVar) {
        this.kDk = aVar;
    }

    public void Kr(String str) {
        if (str == null) {
            this.kDl = "";
        } else {
            this.kDl = str;
        }
    }
}
