package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes23.dex */
public class l {
    public static final String nuz;
    private HashMap<String, String> noj;
    private List<DownloadData> nuA;
    private a nuB;
    private String nuC;
    private com.baidu.tbadk.download.c nuD = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nuB != null && l.this.nuC.equals(downloadData.getUrl())) {
                    l.this.nuB.dOD();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nuz)) {
                l.this.w(downloadData);
                if (l.this.nuB != null && l.this.nuC.equals(downloadData.getUrl())) {
                    l.this.noj.put(downloadData.getPath().substring(l.nuz.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nuB.gw(l.this.nuC, downloadData.getPath());
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
            if (l.this.nuB != null && l.this.nuC.equals(downloadData.getUrl())) {
                l.this.nuB.TG(str);
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void TG(String str);

        void dOD();

        void gw(String str, String str2);
    }

    static {
        nuz = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ue(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.noj == null) {
            this.noj = new HashMap<>();
            dRr();
        }
        return this.noj.get(nameMd5FromUrl);
    }

    public void dRr() {
        if (!StringUtils.isNull(nuz)) {
            if (this.noj == null) {
                this.noj = new HashMap<>();
            } else {
                this.noj.clear();
            }
            File file = new File(nuz);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.noj.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Uf(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nuz)) {
            if (this.nuB != null) {
                this.nuB.TG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nuz);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nuA == null) {
                this.nuA = new ArrayList();
            }
            if (!Ug(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nuz + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nuD);
                this.nuA.add(downloadData);
                com.baidu.tbadk.download.d.bzt().f(downloadData);
            }
        }
    }

    private boolean Ug(String str) {
        if (y.isEmpty(this.nuA) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nuA) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nuA) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nuA.size()) {
                    i = -1;
                    break;
                } else if (this.nuA.get(i) != null && this.nuA.get(i).getUrl() != null && this.nuA.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nuA.remove(i);
        }
    }

    public void a(a aVar) {
        this.nuB = aVar;
    }

    public void Uh(String str) {
        if (str == null) {
            this.nuC = "";
        } else {
            this.nuC = str;
        }
    }
}
