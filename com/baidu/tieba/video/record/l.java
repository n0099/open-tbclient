package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static final String nUL;
    private HashMap<String, String> nPk;
    private List<DownloadData> nUM;
    private a nUN;
    private String nUO;
    private com.baidu.tbadk.download.c nUP = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.nUN != null && l.this.nUO.equals(downloadData.getUrl())) {
                    l.this.nUN.dSw();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nUL)) {
                l.this.v(downloadData);
                if (l.this.nUN != null && l.this.nUO.equals(downloadData.getUrl())) {
                    l.this.nPk.put(downloadData.getPath().substring(l.nUL.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nUN.gF(l.this.nUO, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.v(downloadData);
            if (l.this.nUN != null && l.this.nUO.equals(downloadData.getUrl())) {
                l.this.nUN.Uv(str);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void Uv(String str);

        void dSw();

        void gF(String str, String str2);
    }

    static {
        nUL = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String UQ(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nPk == null) {
            this.nPk = new HashMap<>();
            dUY();
        }
        return this.nPk.get(nameMd5FromUrl);
    }

    public void dUY() {
        if (!StringUtils.isNull(nUL)) {
            if (this.nPk == null) {
                this.nPk = new HashMap<>();
            } else {
                this.nPk.clear();
            }
            File file = new File(nUL);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nPk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void UR(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nUL)) {
            if (this.nUN != null) {
                this.nUN.Uv("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nUL);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nUM == null) {
                this.nUM = new ArrayList();
            }
            if (!US(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nUL + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nUP);
                this.nUM.add(downloadData);
                com.baidu.tbadk.download.d.bBg().f(downloadData);
            }
        }
    }

    private boolean US(String str) {
        if (y.isEmpty(this.nUM) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nUM) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nUM) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nUM.size()) {
                    i = -1;
                    break;
                } else if (this.nUM.get(i) != null && this.nUM.get(i).getUrl() != null && this.nUM.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nUM.remove(i);
        }
    }

    public void a(a aVar) {
        this.nUN = aVar;
    }

    public void UT(String str) {
        if (str == null) {
            this.nUO = "";
        } else {
            this.nUO = str;
        }
    }
}
