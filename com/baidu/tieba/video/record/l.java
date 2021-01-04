package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    public static final String nNe;
    private HashMap<String, String> nHA;
    private List<DownloadData> nNf;
    private a nNg;
    private String nNh;
    private com.baidu.tbadk.download.c nNi = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nNg != null && l.this.nNh.equals(downloadData.getUrl())) {
                    l.this.nNg.dTM();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nNe)) {
                l.this.w(downloadData);
                if (l.this.nNg != null && l.this.nNh.equals(downloadData.getUrl())) {
                    l.this.nHA.put(downloadData.getPath().substring(l.nNe.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nNg.gy(l.this.nNh, downloadData.getPath());
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
            if (l.this.nNg != null && l.this.nNh.equals(downloadData.getUrl())) {
                l.this.nNg.Un(str);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void Un(String str);

        void dTM();

        void gy(String str, String str2);
    }

    static {
        nNe = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String UI(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nHA == null) {
            this.nHA = new HashMap<>();
            dWo();
        }
        return this.nHA.get(nameMd5FromUrl);
    }

    public void dWo() {
        if (!StringUtils.isNull(nNe)) {
            if (this.nHA == null) {
                this.nHA = new HashMap<>();
            } else {
                this.nHA.clear();
            }
            File file = new File(nNe);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nHA.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void UJ(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nNe)) {
            if (this.nNg != null) {
                this.nNg.Un("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nNe);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nNf == null) {
                this.nNf = new ArrayList();
            }
            if (!UK(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nNe + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nNi);
                this.nNf.add(downloadData);
                com.baidu.tbadk.download.d.bEE().f(downloadData);
            }
        }
    }

    private boolean UK(String str) {
        if (x.isEmpty(this.nNf) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nNf) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!x.isEmpty(this.nNf) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nNf.size()) {
                    i = -1;
                    break;
                } else if (this.nNf.get(i) != null && this.nNf.get(i).getUrl() != null && this.nNf.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nNf.remove(i);
        }
    }

    public void a(a aVar) {
        this.nNg = aVar;
    }

    public void UL(String str) {
        if (str == null) {
            this.nNh = "";
        } else {
            this.nNh = str;
        }
    }
}
