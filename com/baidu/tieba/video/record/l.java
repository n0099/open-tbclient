package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String gLx;
    private HashMap<String, String> gFn;
    private String gLA;
    private com.baidu.tbadk.download.d gLB = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.gLz != null && l.this.gLA.equals(downloadData.getUrl())) {
                    l.this.gLz.byC();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.gLx)) {
                l.this.w(downloadData);
                if (l.this.gLz != null && l.this.gLA.equals(downloadData.getUrl())) {
                    l.this.gFn.put(downloadData.getPath().substring(l.gLx.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.gLz.cj(l.this.gLA, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.w(downloadData);
            if (l.this.gLz != null && l.this.gLA.equals(downloadData.getUrl())) {
                l.this.gLz.tl(str);
            }
        }
    };
    private List<DownloadData> gLy;
    private a gLz;

    /* loaded from: classes2.dex */
    public interface a {
        void byC();

        void cj(String str, String str2);

        void tl(String str);
    }

    static {
        gLx = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String tH(String str) {
        String dV = ao.dV(str);
        if (dV == null) {
            return null;
        }
        if (this.gFn == null) {
            this.gFn = new HashMap<>();
            bBd();
        }
        return this.gFn.get(dV);
    }

    public void bBd() {
        if (!StringUtils.isNull(gLx)) {
            if (this.gFn == null) {
                this.gFn = new HashMap<>();
            } else {
                this.gFn.clear();
            }
            File file = new File(gLx);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gFn.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void tI(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gLx)) {
            if (this.gLz != null) {
                this.gLz.tl("");
                return;
            }
            return;
        }
        String dV = ao.dV(str);
        if (dV != null) {
            File file = new File(gLx);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gLy == null) {
                this.gLy = new ArrayList();
            }
            if (!fC(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gLx + "/" + dV + str2);
                downloadData.setCallback(this.gLB);
                this.gLy.add(downloadData);
                com.baidu.tbadk.download.e.CM().f(downloadData);
            }
        }
    }

    private boolean fC(String str) {
        if (v.v(this.gLy) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gLy) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.v(this.gLy) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gLy.size()) {
                    i = -1;
                    break;
                } else if (this.gLy.get(i) != null && this.gLy.get(i).getUrl() != null && this.gLy.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gLy.remove(i);
        }
    }

    public void a(a aVar) {
        this.gLz = aVar;
    }

    public void tJ(String str) {
        if (str == null) {
            this.gLA = "";
        } else {
            this.gLA = str;
        }
    }
}
