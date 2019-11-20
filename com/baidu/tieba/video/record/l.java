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
    public static final String jEV;
    private List<DownloadData> jEW;
    private a jEX;
    private String jEY;
    private com.baidu.tbadk.download.c jEZ = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.jEX != null && l.this.jEY.equals(downloadData.getUrl())) {
                    l.this.jEX.csK();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jEV)) {
                l.this.w(downloadData);
                if (l.this.jEX != null && l.this.jEY.equals(downloadData.getUrl())) {
                    l.this.jyF.put(downloadData.getPath().substring(l.jEV.length() + 1, downloadData.getPath().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), downloadData.getPath());
                    l.this.jEX.ef(l.this.jEY, downloadData.getPath());
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
            if (l.this.jEX != null && l.this.jEY.equals(downloadData.getUrl())) {
                l.this.jEX.EH(str);
            }
        }
    };
    private HashMap<String, String> jyF;

    /* loaded from: classes5.dex */
    public interface a {
        void EH(String str);

        void csK();

        void ef(String str, String str2);
    }

    static {
        jEV = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Ff(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.jyF == null) {
            this.jyF = new HashMap<>();
            cvJ();
        }
        return this.jyF.get(nameMd5FromUrl);
    }

    public void cvJ() {
        if (!StringUtils.isNull(jEV)) {
            if (this.jyF == null) {
                this.jyF = new HashMap<>();
            } else {
                this.jyF.clear();
            }
            File file = new File(jEV);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jyF.put(file2.getName().substring(0, file2.getName().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Fg(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jEV)) {
            if (this.jEX != null) {
                this.jEX.EH("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(jEV);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = DefaultConfig.TOKEN_SEPARATOR + str.substring(str.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1);
            if (this.jEW == null) {
                this.jEW = new ArrayList();
            }
            if (!Fh(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jEV + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.jEZ);
                this.jEW.add(downloadData);
                com.baidu.tbadk.download.d.atT().f(downloadData);
            }
        }
    }

    private boolean Fh(String str) {
        if (v.isEmpty(this.jEW) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jEW) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.jEW) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jEW.size()) {
                    i = -1;
                    break;
                } else if (this.jEW.get(i) != null && this.jEW.get(i).getUrl() != null && this.jEW.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jEW.remove(i);
        }
    }

    public void a(a aVar) {
        this.jEX = aVar;
    }

    public void Fi(String str) {
        if (str == null) {
            this.jEY = "";
        } else {
            this.jEY = str;
        }
    }
}
