package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static final String hsy;
    private HashMap<String, String> hlZ;
    private a hsA;
    private String hsB;
    private com.baidu.tbadk.download.c hsC = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.hsA != null && l.this.hsB.equals(downloadData.getUrl())) {
                    l.this.hsA.bDi();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.hsy)) {
                l.this.v(downloadData);
                if (l.this.hsA != null && l.this.hsB.equals(downloadData.getUrl())) {
                    l.this.hlZ.put(downloadData.getPath().substring(l.hsy.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.hsA.cB(l.this.hsB, downloadData.getPath());
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
            if (l.this.hsA != null && l.this.hsB.equals(downloadData.getUrl())) {
                l.this.hsA.vp(str);
            }
        }
    };
    private List<DownloadData> hsz;

    /* loaded from: classes2.dex */
    public interface a {
        void bDi();

        void cB(String str, String str2);

        void vp(String str);
    }

    static {
        hsy = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String vN(String str) {
        String fe = ar.fe(str);
        if (fe == null) {
            return null;
        }
        if (this.hlZ == null) {
            this.hlZ = new HashMap<>();
            bGe();
        }
        return this.hlZ.get(fe);
    }

    public void bGe() {
        if (!StringUtils.isNull(hsy)) {
            if (this.hlZ == null) {
                this.hlZ = new HashMap<>();
            } else {
                this.hlZ.clear();
            }
            File file = new File(hsy);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.hlZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void vO(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(hsy)) {
            if (this.hsA != null) {
                this.hsA.vp("");
                return;
            }
            return;
        }
        String fe = ar.fe(str);
        if (fe != null) {
            File file = new File(hsy);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.hsz == null) {
                this.hsz = new ArrayList();
            }
            if (!vP(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(hsy + "/" + fe + str2);
                downloadData.setCallback(this.hsC);
                this.hsz.add(downloadData);
                com.baidu.tbadk.download.d.ID().f(downloadData);
            }
        }
    }

    private boolean vP(String str) {
        if (v.z(this.hsz) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.hsz) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.z(this.hsz) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.hsz.size()) {
                    i = -1;
                    break;
                } else if (this.hsz.get(i) != null && this.hsz.get(i).getUrl() != null && this.hsz.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.hsz.remove(i);
        }
    }

    public void a(a aVar) {
        this.hsA = aVar;
    }

    public void vQ(String str) {
        if (str == null) {
            this.hsB = "";
        } else {
            this.hsB = str;
        }
    }
}
