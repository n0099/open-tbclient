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
    public static final String gTM;
    private HashMap<String, String> gNn;
    private List<DownloadData> gTN;
    private a gTO;
    private String gTP;
    private com.baidu.tbadk.download.d gTQ = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.x(downloadData);
                if (l.this.gTO != null && l.this.gTP.equals(downloadData.getUrl())) {
                    l.this.gTO.bvZ();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.gTM)) {
                l.this.x(downloadData);
                if (l.this.gTO != null && l.this.gTP.equals(downloadData.getUrl())) {
                    l.this.gNn.put(downloadData.getPath().substring(l.gTM.length() + 1, downloadData.getPath().lastIndexOf(Constants.DOT)), downloadData.getPath());
                    l.this.gTO.ci(l.this.gTP, downloadData.getPath());
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
            if (l.this.gTO != null && l.this.gTP.equals(downloadData.getUrl())) {
                l.this.gTO.tO(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bvZ();

        void ci(String str, String str2);

        void tO(String str);
    }

    static {
        gTM = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String um(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gNn == null) {
            this.gNn = new HashMap<>();
            byX();
        }
        return this.gNn.get(em);
    }

    public void byX() {
        if (!StringUtils.isNull(gTM)) {
            if (this.gNn == null) {
                this.gNn = new HashMap<>();
            } else {
                this.gNn.clear();
            }
            File file = new File(gTM);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gNn.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void un(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gTM)) {
            if (this.gTO != null) {
                this.gTO.tO("");
                return;
            }
            return;
        }
        String em = aq.em(str);
        if (em != null) {
            File file = new File(gTM);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = Constants.DOT + str.substring(str.lastIndexOf(Constants.DOT) + 1);
            if (this.gTN == null) {
                this.gTN = new ArrayList();
            }
            if (!fX(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gTM + "/" + em + str2);
                downloadData.setCallback(this.gTQ);
                this.gTN.add(downloadData);
                com.baidu.tbadk.download.e.Dw().f(downloadData);
            }
        }
    }

    private boolean fX(String str) {
        if (v.w(this.gTN) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gTN) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.w(this.gTN) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gTN.size()) {
                    i = -1;
                    break;
                } else if (this.gTN.get(i) != null && this.gTN.get(i).getUrl() != null && this.gTN.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gTN.remove(i);
        }
    }

    public void a(a aVar) {
        this.gTO = aVar;
    }

    public void uo(String str) {
        if (str == null) {
            this.gTP = "";
        } else {
            this.gTP = str;
        }
    }
}
