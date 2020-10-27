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
    public static final String noE;
    private HashMap<String, String> nio;
    private List<DownloadData> noF;
    private a noG;
    private String noH;
    private com.baidu.tbadk.download.c noI = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.noG != null && l.this.noH.equals(downloadData.getUrl())) {
                    l.this.noG.dMb();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.noE)) {
                l.this.w(downloadData);
                if (l.this.noG != null && l.this.noH.equals(downloadData.getUrl())) {
                    l.this.nio.put(downloadData.getPath().substring(l.noE.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.noG.gw(l.this.noH, downloadData.getPath());
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
            if (l.this.noG != null && l.this.noH.equals(downloadData.getUrl())) {
                l.this.noG.Tp(str);
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void Tp(String str);

        void dMb();

        void gw(String str, String str2);
    }

    static {
        noE = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String TN(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nio == null) {
            this.nio = new HashMap<>();
            dOP();
        }
        return this.nio.get(nameMd5FromUrl);
    }

    public void dOP() {
        if (!StringUtils.isNull(noE)) {
            if (this.nio == null) {
                this.nio = new HashMap<>();
            } else {
                this.nio.clear();
            }
            File file = new File(noE);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nio.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void TO(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(noE)) {
            if (this.noG != null) {
                this.noG.Tp("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(noE);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.noF == null) {
                this.noF = new ArrayList();
            }
            if (!TP(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(noE + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.noI);
                this.noF.add(downloadData);
                com.baidu.tbadk.download.d.bwU().f(downloadData);
            }
        }
    }

    private boolean TP(String str) {
        if (y.isEmpty(this.noF) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.noF) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.noF) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.noF.size()) {
                    i = -1;
                    break;
                } else if (this.noF.get(i) != null && this.noF.get(i).getUrl() != null && this.noF.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.noF.remove(i);
        }
    }

    public void a(a aVar) {
        this.noG = aVar;
    }

    public void TQ(String str) {
        if (str == null) {
            this.noH = "";
        } else {
            this.noH = str;
        }
    }
}
