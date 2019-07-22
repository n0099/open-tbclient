package com.baidu.tieba.video.record;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {
    public static final String jCt;
    private List<DownloadData> jCu;
    private a jCv;
    private String jCw;
    private com.baidu.tbadk.download.c jCx = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jCv != null && l.this.jCw.equals(downloadData.getUrl())) {
                    l.this.jCv.ctN();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jCt)) {
                l.this.v(downloadData);
                if (l.this.jCv != null && l.this.jCw.equals(downloadData.getUrl())) {
                    l.this.jwb.put(downloadData.getPath().substring(l.jCt.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jCv.es(l.this.jCw, downloadData.getPath());
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
            if (l.this.jCv != null && l.this.jCw.equals(downloadData.getUrl())) {
                l.this.jCv.FE(str);
            }
        }
    };
    private HashMap<String, String> jwb;

    /* loaded from: classes5.dex */
    public interface a {
        void FE(String str);

        void ctN();

        void es(String str, String str2);
    }

    static {
        jCt = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Gc(String str) {
        String oj = at.oj(str);
        if (oj == null) {
            return null;
        }
        if (this.jwb == null) {
            this.jwb = new HashMap<>();
            cwL();
        }
        return this.jwb.get(oj);
    }

    public void cwL() {
        if (!StringUtils.isNull(jCt)) {
            if (this.jwb == null) {
                this.jwb = new HashMap<>();
            } else {
                this.jwb.clear();
            }
            File file = new File(jCt);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jwb.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Gd(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jCt)) {
            if (this.jCv != null) {
                this.jCv.FE("");
                return;
            }
            return;
        }
        String oj = at.oj(str);
        if (oj != null) {
            File file = new File(jCt);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jCu == null) {
                this.jCu = new ArrayList();
            }
            if (!Ge(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jCt + "/" + oj + str2);
                downloadData.setCallback(this.jCx);
                this.jCu.add(downloadData);
                com.baidu.tbadk.download.d.arS().f(downloadData);
            }
        }
    }

    private boolean Ge(String str) {
        if (v.aa(this.jCu) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jCu) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jCu) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jCu.size()) {
                    i = -1;
                    break;
                } else if (this.jCu.get(i) != null && this.jCu.get(i).getUrl() != null && this.jCu.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jCu.remove(i);
        }
    }

    public void a(a aVar) {
        this.jCv = aVar;
    }

    public void Gf(String str) {
        if (str == null) {
            this.jCw = "";
        } else {
            this.jCw = str;
        }
    }
}
