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
    public static final String kFb;
    private List<DownloadData> kFc;
    private a kFd;
    private String kFe;
    private com.baidu.tbadk.download.c kFf = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kFd != null && l.this.kFe.equals(downloadData.getUrl())) {
                    l.this.kFd.cPL();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kFb)) {
                l.this.w(downloadData);
                if (l.this.kFd != null && l.this.kFe.equals(downloadData.getUrl())) {
                    l.this.kyT.put(downloadData.getPath().substring(l.kFb.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kFd.eH(l.this.kFe, downloadData.getPath());
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
            if (l.this.kFd != null && l.this.kFe.equals(downloadData.getUrl())) {
                l.this.kFd.JT(str);
            }
        }
    };
    private HashMap<String, String> kyT;

    /* loaded from: classes10.dex */
    public interface a {
        void JT(String str);

        void cPL();

        void eH(String str, String str2);
    }

    static {
        kFb = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ko(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kyT == null) {
            this.kyT = new HashMap<>();
            cSv();
        }
        return this.kyT.get(nameMd5FromUrl);
    }

    public void cSv() {
        if (!StringUtils.isNull(kFb)) {
            if (this.kyT == null) {
                this.kyT = new HashMap<>();
            } else {
                this.kyT.clear();
            }
            File file = new File(kFb);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kyT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kp(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kFb)) {
            if (this.kFd != null) {
                this.kFd.JT("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kFb);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kFc == null) {
                this.kFc = new ArrayList();
            }
            if (!Kq(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kFb + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kFf);
                this.kFc.add(downloadData);
                com.baidu.tbadk.download.d.aOu().f(downloadData);
            }
        }
    }

    private boolean Kq(String str) {
        if (v.isEmpty(this.kFc) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kFc) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kFc) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kFc.size()) {
                    i = -1;
                    break;
                } else if (this.kFc.get(i) != null && this.kFc.get(i).getUrl() != null && this.kFc.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kFc.remove(i);
        }
    }

    public void a(a aVar) {
        this.kFd = aVar;
    }

    public void Kr(String str) {
        if (str == null) {
            this.kFe = "";
        } else {
            this.kFe = str;
        }
    }
}
