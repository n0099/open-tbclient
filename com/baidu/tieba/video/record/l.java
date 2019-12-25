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
/* loaded from: classes7.dex */
public class l {
    public static final String kyE;
    private HashMap<String, String> ksx;
    private List<DownloadData> kyF;
    private a kyG;
    private String kyH;
    private com.baidu.tbadk.download.c kyI = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.kyG != null && l.this.kyH.equals(downloadData.getUrl())) {
                    l.this.kyG.cMM();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.kyE)) {
                l.this.w(downloadData);
                if (l.this.kyG != null && l.this.kyH.equals(downloadData.getUrl())) {
                    l.this.ksx.put(downloadData.getPath().substring(l.kyE.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.kyG.ey(l.this.kyH, downloadData.getPath());
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
            if (l.this.kyG != null && l.this.kyH.equals(downloadData.getUrl())) {
                l.this.kyG.Jw(str);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void Jw(String str);

        void cMM();

        void ey(String str, String str2);
    }

    static {
        kyE = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String JR(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ksx == null) {
            this.ksx = new HashMap<>();
            cPA();
        }
        return this.ksx.get(nameMd5FromUrl);
    }

    public void cPA() {
        if (!StringUtils.isNull(kyE)) {
            if (this.ksx == null) {
                this.ksx = new HashMap<>();
            } else {
                this.ksx.clear();
            }
            File file = new File(kyE);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.ksx.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void JS(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(kyE)) {
            if (this.kyG != null) {
                this.kyG.Jw("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(kyE);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.kyF == null) {
                this.kyF = new ArrayList();
            }
            if (!JT(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(kyE + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.kyI);
                this.kyF.add(downloadData);
                com.baidu.tbadk.download.d.aLy().f(downloadData);
            }
        }
    }

    private boolean JT(String str) {
        if (v.isEmpty(this.kyF) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.kyF) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.kyF) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.kyF.size()) {
                    i = -1;
                    break;
                } else if (this.kyF.get(i) != null && this.kyF.get(i).getUrl() != null && this.kyF.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.kyF.remove(i);
        }
    }

    public void a(a aVar) {
        this.kyG = aVar;
    }

    public void JU(String str) {
        if (str == null) {
            this.kyH = "";
        } else {
            this.kyH = str;
        }
    }
}
