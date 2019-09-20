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
/* loaded from: classes5.dex */
public class l {
    public static final String jFW;
    private List<DownloadData> jFX;
    private a jFY;
    private String jFZ;
    private com.baidu.tbadk.download.c jGa = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jFY != null && l.this.jFZ.equals(downloadData.getUrl())) {
                    l.this.jFY.cuX();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jFW)) {
                l.this.v(downloadData);
                if (l.this.jFY != null && l.this.jFZ.equals(downloadData.getUrl())) {
                    l.this.jzE.put(downloadData.getPath().substring(l.jFW.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jFY.et(l.this.jFZ, downloadData.getPath());
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
            if (l.this.jFY != null && l.this.jFZ.equals(downloadData.getUrl())) {
                l.this.jFY.Gf(str);
            }
        }
    };
    private HashMap<String, String> jzE;

    /* loaded from: classes5.dex */
    public interface a {
        void Gf(String str);

        void cuX();

        void et(String str, String str2);
    }

    static {
        jFW = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String GD(String str) {
        String ol = as.ol(str);
        if (ol == null) {
            return null;
        }
        if (this.jzE == null) {
            this.jzE = new HashMap<>();
            cxV();
        }
        return this.jzE.get(ol);
    }

    public void cxV() {
        if (!StringUtils.isNull(jFW)) {
            if (this.jzE == null) {
                this.jzE = new HashMap<>();
            } else {
                this.jzE.clear();
            }
            File file = new File(jFW);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jzE.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void GE(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jFW)) {
            if (this.jFY != null) {
                this.jFY.Gf("");
                return;
            }
            return;
        }
        String ol = as.ol(str);
        if (ol != null) {
            File file = new File(jFW);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jFX == null) {
                this.jFX = new ArrayList();
            }
            if (!GF(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jFW + "/" + ol + str2);
                downloadData.setCallback(this.jGa);
                this.jFX.add(downloadData);
                com.baidu.tbadk.download.d.asg().f(downloadData);
            }
        }
    }

    private boolean GF(String str) {
        if (v.aa(this.jFX) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jFX) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jFX) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jFX.size()) {
                    i = -1;
                    break;
                } else if (this.jFX.get(i) != null && this.jFX.get(i).getUrl() != null && this.jFX.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jFX.remove(i);
        }
    }

    public void a(a aVar) {
        this.jFY = aVar;
    }

    public void GG(String str) {
        if (str == null) {
            this.jFZ = "";
        } else {
            this.jFZ = str;
        }
    }
}
