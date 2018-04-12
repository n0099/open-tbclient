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
    public static final String gSL;
    private HashMap<String, String> gMn;
    private List<DownloadData> gSM;
    private a gSN;
    private String gSO;
    private com.baidu.tbadk.download.d gSP = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.x(downloadData);
                if (l.this.gSN != null && l.this.gSO.equals(downloadData.getUrl())) {
                    l.this.gSN.bwb();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.gSL)) {
                l.this.x(downloadData);
                if (l.this.gSN != null && l.this.gSO.equals(downloadData.getUrl())) {
                    l.this.gMn.put(downloadData.getPath().substring(l.gSL.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    l.this.gSN.ci(l.this.gSO, downloadData.getPath());
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
            if (l.this.gSN != null && l.this.gSO.equals(downloadData.getUrl())) {
                l.this.gSN.tL(str);
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
        gSL = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uj(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gMn == null) {
            this.gMn = new HashMap<>();
            byZ();
        }
        return this.gMn.get(em);
    }

    public void byZ() {
        if (!StringUtils.isNull(gSL)) {
            if (this.gMn == null) {
                this.gMn = new HashMap<>();
            } else {
                this.gMn.clear();
            }
            File file = new File(gSL);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gMn.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void uk(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gSL)) {
            if (this.gSN != null) {
                this.gSN.tL("");
                return;
            }
            return;
        }
        String em = aq.em(str);
        if (em != null) {
            File file = new File(gSL);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.gSM == null) {
                this.gSM = new ArrayList();
            }
            if (!fX(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gSL + "/" + em + str2);
                downloadData.setCallback(this.gSP);
                this.gSM.add(downloadData);
                com.baidu.tbadk.download.e.Dy().f(downloadData);
            }
        }
    }

    private boolean fX(String str) {
        if (v.w(this.gSM) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gSM) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.w(this.gSM) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gSM.size()) {
                    i = -1;
                    break;
                } else if (this.gSM.get(i) != null && this.gSM.get(i).getUrl() != null && this.gSM.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gSM.remove(i);
        }
    }

    public void a(a aVar) {
        this.gSN = aVar;
    }

    public void ul(String str) {
        if (str == null) {
            this.gSO = "";
        } else {
            this.gSO = str;
        }
    }
}
