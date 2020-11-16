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
/* loaded from: classes22.dex */
public class l {
    public static final String nvG;
    private HashMap<String, String> nps;
    private List<DownloadData> nvH;
    private a nvI;
    private String nvJ;
    private com.baidu.tbadk.download.c nvK = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.nvI != null && l.this.nvJ.equals(downloadData.getUrl())) {
                    l.this.nvI.dOC();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.nvG)) {
                l.this.w(downloadData);
                if (l.this.nvI != null && l.this.nvJ.equals(downloadData.getUrl())) {
                    l.this.nps.put(downloadData.getPath().substring(l.nvG.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.nvI.gw(l.this.nvJ, downloadData.getPath());
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
            if (l.this.nvI != null && l.this.nvJ.equals(downloadData.getUrl())) {
                l.this.nvI.Tr(str);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void Tr(String str);

        void dOC();

        void gw(String str, String str2);
    }

    static {
        nvG = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String TP(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nps == null) {
            this.nps = new HashMap<>();
            dRq();
        }
        return this.nps.get(nameMd5FromUrl);
    }

    public void dRq() {
        if (!StringUtils.isNull(nvG)) {
            if (this.nps == null) {
                this.nps = new HashMap<>();
            } else {
                this.nps.clear();
            }
            File file = new File(nvG);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.nps.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void TQ(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(nvG)) {
            if (this.nvI != null) {
                this.nvI.Tr("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(nvG);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.nvH == null) {
                this.nvH = new ArrayList();
            }
            if (!TR(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(nvG + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.nvK);
                this.nvH.add(downloadData);
                com.baidu.tbadk.download.d.byJ().f(downloadData);
            }
        }
    }

    private boolean TR(String str) {
        if (y.isEmpty(this.nvH) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.nvH) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!y.isEmpty(this.nvH) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.nvH.size()) {
                    i = -1;
                    break;
                } else if (this.nvH.get(i) != null && this.nvH.get(i).getUrl() != null && this.nvH.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.nvH.remove(i);
        }
    }

    public void a(a aVar) {
        this.nvI = aVar;
    }

    public void TS(String str) {
        if (str == null) {
            this.nvJ = "";
        } else {
            this.nvJ = str;
        }
    }
}
