package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class l {
    public static final String mdl;
    private HashMap<String, String> lWR;
    private List<DownloadData> mdm;
    private a mdn;
    private String mdo;
    private com.baidu.tbadk.download.c mdp = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.mdn != null && l.this.mdo.equals(downloadData.getUrl())) {
                    l.this.mdn.dmt();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.mdl)) {
                l.this.w(downloadData);
                if (l.this.mdn != null && l.this.mdo.equals(downloadData.getUrl())) {
                    l.this.lWR.put(downloadData.getPath().substring(l.mdl.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.mdn.fE(l.this.mdo, downloadData.getPath());
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
            if (l.this.mdn != null && l.this.mdo.equals(downloadData.getUrl())) {
                l.this.mdn.NV(str);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void NV(String str);

        void dmt();

        void fE(String str, String str2);
    }

    static {
        mdl = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ot(String str) {
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lWR == null) {
            this.lWR = new HashMap<>();
            dpj();
        }
        return this.lWR.get(nameMd5FromUrl);
    }

    public void dpj() {
        if (!StringUtils.isNull(mdl)) {
            if (this.lWR == null) {
                this.lWR = new HashMap<>();
            } else {
                this.lWR.clear();
            }
            File file = new File(mdl);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.lWR.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Ou(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(mdl)) {
            if (this.mdn != null) {
                this.mdn.NV("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = at.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(mdl);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.mdm == null) {
                this.mdm = new ArrayList();
            }
            if (!Ov(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(mdl + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.mdp);
                this.mdm.add(downloadData);
                com.baidu.tbadk.download.d.beW().f(downloadData);
            }
        }
    }

    private boolean Ov(String str) {
        if (w.isEmpty(this.mdm) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.mdm) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!w.isEmpty(this.mdm) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.mdm.size()) {
                    i = -1;
                    break;
                } else if (this.mdm.get(i) != null && this.mdm.get(i).getUrl() != null && this.mdm.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.mdm.remove(i);
        }
    }

    public void a(a aVar) {
        this.mdn = aVar;
    }

    public void Ow(String str) {
        if (str == null) {
            this.mdo = "";
        } else {
            this.mdo = str;
        }
    }
}
