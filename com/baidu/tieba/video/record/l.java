package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String hju;
    private HashMap<String, String> hcU;
    private List<DownloadData> hjv;
    private a hjw;
    private String hjx;
    private com.baidu.tbadk.download.d hjy = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.x(downloadData);
                if (l.this.hjw != null && l.this.hjx.equals(downloadData.getUrl())) {
                    l.this.hjw.bBG();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hju)) {
                l.this.x(downloadData);
                if (l.this.hjw != null && l.this.hjx.equals(downloadData.getUrl())) {
                    l.this.hcU.put(downloadData.getPath().substring(l.hju.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hjw.cu(l.this.hjx, downloadData.getPath());
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
            if (l.this.hjw != null && l.this.hjx.equals(downloadData.getUrl())) {
                l.this.hjw.uE(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bBG();

        void cu(String str, String str2);

        void uE(String str);
    }

    static {
        hju = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String vc(String str) {
        String eO = as.eO(str);
        if (eO == null) {
            return null;
        }
        if (this.hcU == null) {
            this.hcU = new HashMap<>();
            bED();
        }
        return this.hcU.get(eO);
    }

    public void bED() {
        if (!StringUtils.isNull(hju)) {
            if (this.hcU == null) {
                this.hcU = new HashMap<>();
            } else {
                this.hcU.clear();
            }
            File file = new File(hju);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hcU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void vd(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hju)) {
            if (this.hjw != null) {
                this.hjw.uE("");
                return;
            }
            return;
        }
        String eO = as.eO(str);
        if (eO != null) {
            File file = new File(hju);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hjv == null) {
                this.hjv = new ArrayList();
            }
            if (!gA(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hju + "/" + eO + str2);
                downloadData.setCallback(this.hjy);
                this.hjv.add(downloadData);
                com.baidu.tbadk.download.e.Hr().f(downloadData);
            }
        }
    }

    private boolean gA(String str) {
        if (w.A(this.hjv) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hjv) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!w.A(this.hjv) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hjv.size()) {
                    i = -1;
                    break;
                } else if (this.hjv.get(i) != null && this.hjv.get(i).getUrl() != null && this.hjv.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hjv.remove(i);
        }
    }

    public void a(a aVar) {
        this.hjw = aVar;
    }

    public void ve(String str) {
        if (str == null) {
            this.hjx = "";
        } else {
            this.hjx = str;
        }
    }
}
