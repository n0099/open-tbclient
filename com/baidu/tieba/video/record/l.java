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
    public static final String kDu;
    private List<DownloadData> kDv;
    private a kDw;
    private String kDx;
    private com.baidu.tbadk.download.c kDy = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kDw != null && l.this.kDx.equals(downloadData.getUrl())) {
                    l.this.kDw.cPr();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kDu)) {
                l.this.w(downloadData);
                if (l.this.kDw != null && l.this.kDx.equals(downloadData.getUrl())) {
                    l.this.kxo.put(downloadData.getPath().substring(l.kDu.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kDw.eJ(l.this.kDx, downloadData.getPath());
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
            if (l.this.kDw != null && l.this.kDx.equals(downloadData.getUrl())) {
                l.this.kDw.JU(str);
            }
        }
    };
    private HashMap<String, String> kxo;

    /* loaded from: classes10.dex */
    public interface a {
        void JU(String str);

        void cPr();

        void eJ(String str, String str2);
    }

    static {
        kDu = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Kp(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxo == null) {
            this.kxo = new HashMap<>();
            cSb();
        }
        return this.kxo.get(nameMd5FromUrl);
    }

    public void cSb() {
        if (!StringUtils.isNull(kDu)) {
            if (this.kxo == null) {
                this.kxo = new HashMap<>();
            } else {
                this.kxo.clear();
            }
            File file = new File(kDu);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.kxo.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Kq(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kDu)) {
            if (this.kDw != null) {
                this.kDw.JU("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kDu);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kDv == null) {
                this.kDv = new ArrayList();
            }
            if (!Kr(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kDu + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kDy);
                this.kDv.add(downloadData);
                com.baidu.tbadk.download.d.aOq().f(downloadData);
            }
        }
    }

    private boolean Kr(String str) {
        if (v.isEmpty(this.kDv) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kDv) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kDv) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kDv.size()) {
                    i = -1;
                    break;
                } else if (this.kDv.get(i) != null && this.kDv.get(i).getUrl() != null && this.kDv.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kDv.remove(i);
        }
    }

    public void a(a aVar) {
        this.kDw = aVar;
    }

    public void Ks(String str) {
        if (str == null) {
            this.kDx = "";
        } else {
            this.kDx = str;
        }
    }
}
