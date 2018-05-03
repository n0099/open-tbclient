package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String gSI;
    private HashMap<String, String> gMk;
    private List<DownloadData> gSJ;
    private a gSK;
    private String gSL;
    private com.baidu.tbadk.download.d gSM = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.x(downloadData);
                if (l.this.gSK != null && l.this.gSL.equals(downloadData.getUrl())) {
                    l.this.gSK.bwb();
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.gSI)) {
                l.this.x(downloadData);
                if (l.this.gSK != null && l.this.gSL.equals(downloadData.getUrl())) {
                    l.this.gMk.put(downloadData.getPath().substring(l.gSI.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    l.this.gSK.ci(l.this.gSL, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.x(downloadData);
            if (l.this.gSK != null && l.this.gSL.equals(downloadData.getUrl())) {
                l.this.gSK.tL(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bwb();

        void ci(String str, String str2);

        void tL(String str);
    }

    static {
        gSI = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uj(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gMk == null) {
            this.gMk = new HashMap<>();
            byZ();
        }
        return this.gMk.get(em);
    }

    public void byZ() {
        if (!StringUtils.isNull(gSI)) {
            if (this.gMk == null) {
                this.gMk = new HashMap<>();
            } else {
                this.gMk.clear();
            }
            File file = new File(gSI);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gMk.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void uk(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gSI)) {
            if (this.gSK != null) {
                this.gSK.tL("");
                return;
            }
            return;
        }
        String em = aq.em(str);
        if (em != null) {
            File file = new File(gSI);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.gSJ == null) {
                this.gSJ = new ArrayList();
            }
            if (!fX(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gSI + "/" + em + str2);
                downloadData.setCallback(this.gSM);
                this.gSJ.add(downloadData);
                com.baidu.tbadk.download.e.Dy().f(downloadData);
            }
        }
    }

    private boolean fX(String str) {
        if (v.w(this.gSJ) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gSJ) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.w(this.gSJ) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gSJ.size()) {
                    i = -1;
                    break;
                } else if (this.gSJ.get(i) != null && this.gSJ.get(i).getUrl() != null && this.gSJ.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gSJ.remove(i);
        }
    }

    public void a(a aVar) {
        this.gSK = aVar;
    }

    public void ul(String str) {
        if (str == null) {
            this.gSL = "";
        } else {
            this.gSL = str;
        }
    }
}
