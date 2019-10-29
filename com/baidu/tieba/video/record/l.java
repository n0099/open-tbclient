package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {
    public static final String jFM;
    private List<DownloadData> jFN;
    private a jFO;
    private String jFP;
    private com.baidu.tbadk.download.c jFQ = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.jFO != null && l.this.jFP.equals(downloadData.getUrl())) {
                    l.this.jFO.csM();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jFM)) {
                l.this.w(downloadData);
                if (l.this.jFO != null && l.this.jFP.equals(downloadData.getUrl())) {
                    l.this.jzw.put(downloadData.getPath().substring(l.jFM.length() + 1, downloadData.getPath().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), downloadData.getPath());
                    l.this.jFO.ef(l.this.jFP, downloadData.getPath());
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
            if (l.this.jFO != null && l.this.jFP.equals(downloadData.getUrl())) {
                l.this.jFO.EH(str);
            }
        }
    };
    private HashMap<String, String> jzw;

    /* loaded from: classes5.dex */
    public interface a {
        void EH(String str);

        void csM();

        void ef(String str, String str2);
    }

    static {
        jFM = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ff(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.jzw == null) {
            this.jzw = new HashMap<>();
            cvL();
        }
        return this.jzw.get(nameMd5FromUrl);
    }

    public void cvL() {
        if (!StringUtils.isNull(jFM)) {
            if (this.jzw == null) {
                this.jzw = new HashMap<>();
            } else {
                this.jzw.clear();
            }
            File file = new File(jFM);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jzw.put(file2.getName().substring(0, file2.getName().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Fg(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jFM)) {
            if (this.jFO != null) {
                this.jFO.EH("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(jFM);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = DefaultConfig.TOKEN_SEPARATOR + str.substring(str.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1);
            if (this.jFN == null) {
                this.jFN = new ArrayList();
            }
            if (!Fh(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jFM + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.jFQ);
                this.jFN.add(downloadData);
                com.baidu.tbadk.download.d.atV().f(downloadData);
            }
        }
    }

    private boolean Fh(String str) {
        if (v.isEmpty(this.jFN) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jFN) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.jFN) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jFN.size()) {
                    i = -1;
                    break;
                } else if (this.jFN.get(i) != null && this.jFN.get(i).getUrl() != null && this.jFN.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jFN.remove(i);
        }
    }

    public void a(a aVar) {
        this.jFO = aVar;
    }

    public void Fi(String str) {
        if (str == null) {
            this.jFP = "";
        } else {
            this.jFP = str;
        }
    }
}
