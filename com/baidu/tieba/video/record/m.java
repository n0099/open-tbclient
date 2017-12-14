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
public class m {
    public static final String gYZ;
    private HashMap<String, String> gRZ;
    private List<DownloadData> gZa;
    private a gZb;
    private String gZc;
    private com.baidu.tbadk.download.d gZd = new com.baidu.tbadk.download.d() { // from class: com.baidu.tieba.video.record.m.1
        @Override // com.baidu.tbadk.download.d
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                m.this.x(downloadData);
                if (m.this.gZb != null && m.this.gZc.equals(downloadData.getUrl())) {
                    m.this.gZb.bBm();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(m.gYZ)) {
                m.this.x(downloadData);
                if (m.this.gZb != null && m.this.gZc.equals(downloadData.getUrl())) {
                    m.this.gRZ.put(downloadData.getPath().substring(m.gYZ.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    m.this.gZb.cn(m.this.gZc, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.d
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            m.this.x(downloadData);
            if (m.this.gZb != null && m.this.gZc.equals(downloadData.getUrl())) {
                m.this.gZb.tW(str);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bBm();

        void cn(String str, String str2);

        void tW(String str);
    }

    static {
        gYZ = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String uu(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gRZ == null) {
            this.gRZ = new HashMap<>();
            bEt();
        }
        return this.gRZ.get(dX);
    }

    public void bEt() {
        if (!StringUtils.isNull(gYZ)) {
            if (this.gRZ == null) {
                this.gRZ = new HashMap<>();
            } else {
                this.gRZ.clear();
            }
            File file = new File(gYZ);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.gRZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void uv(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(gYZ)) {
            if (this.gZb != null) {
                this.gZb.tW("");
                return;
            }
            return;
        }
        String dX = ao.dX(str);
        if (dX != null) {
            File file = new File(gYZ);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.gZa == null) {
                this.gZa = new ArrayList();
            }
            if (!fH(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(gYZ + "/" + dX + str2);
                downloadData.setCallback(this.gZd);
                this.gZa.add(downloadData);
                com.baidu.tbadk.download.e.CW().f(downloadData);
            }
        }
    }

    private boolean fH(String str) {
        if (v.w(this.gZa) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.gZa) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(DownloadData downloadData) {
        int i;
        if (!v.w(this.gZa) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.gZa.size()) {
                    i = -1;
                    break;
                } else if (this.gZa.get(i) != null && this.gZa.get(i).getUrl() != null && this.gZa.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.gZa.remove(i);
        }
    }

    public void a(a aVar) {
        this.gZb = aVar;
    }

    public void uw(String str) {
        if (str == null) {
            this.gZc = "";
        } else {
            this.gZc = str;
        }
    }
}
