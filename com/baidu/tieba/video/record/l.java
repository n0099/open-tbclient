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
    public static final String lIm;
    private HashMap<String, String> lBZ;
    private List<DownloadData> lIn;
    private a lIo;
    private String lIp;
    private com.baidu.tbadk.download.c lIq = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.lIo != null && l.this.lIp.equals(downloadData.getUrl())) {
                    l.this.lIo.dhT();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.lIm)) {
                l.this.w(downloadData);
                if (l.this.lIo != null && l.this.lIp.equals(downloadData.getUrl())) {
                    l.this.lBZ.put(downloadData.getPath().substring(l.lIm.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.lIo.fx(l.this.lIp, downloadData.getPath());
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
            if (l.this.lIo != null && l.this.lIp.equals(downloadData.getUrl())) {
                l.this.lIo.Nt(str);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Nt(String str);

        void dhT();

        void fx(String str, String str2);
    }

    static {
        lIm = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String NQ(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.lBZ == null) {
            this.lBZ = new HashMap<>();
            dkI();
        }
        return this.lBZ.get(nameMd5FromUrl);
    }

    public void dkI() {
        if (!StringUtils.isNull(lIm)) {
            if (this.lBZ == null) {
                this.lBZ = new HashMap<>();
            } else {
                this.lBZ.clear();
            }
            File file = new File(lIm);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.lBZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void NR(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(lIm)) {
            if (this.lIo != null) {
                this.lIo.Nt("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(lIm);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.lIn == null) {
                this.lIn = new ArrayList();
            }
            if (!NS(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(lIm + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.lIq);
                this.lIn.add(downloadData);
                com.baidu.tbadk.download.d.bcT().f(downloadData);
            }
        }
    }

    private boolean NS(String str) {
        if (v.isEmpty(this.lIn) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.lIn) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.lIn) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.lIn.size()) {
                    i = -1;
                    break;
                } else if (this.lIn.get(i) != null && this.lIn.get(i).getUrl() != null && this.lIn.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.lIn.remove(i);
        }
    }

    public void a(a aVar) {
        this.lIo = aVar;
    }

    public void NT(String str) {
        if (str == null) {
            this.lIp = "";
        } else {
            this.lIp = str;
        }
    }
}
