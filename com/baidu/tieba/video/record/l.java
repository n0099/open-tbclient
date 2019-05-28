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
    public static final String jwh;
    private HashMap<String, String> jpQ;
    private List<DownloadData> jwi;
    private a jwj;
    private String jwk;
    private com.baidu.tbadk.download.c jwl = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jwj != null && l.this.jwk.equals(downloadData.getUrl())) {
                    l.this.jwj.crb();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jwh)) {
                l.this.v(downloadData);
                if (l.this.jwj != null && l.this.jwk.equals(downloadData.getUrl())) {
                    l.this.jpQ.put(downloadData.getPath().substring(l.jwh.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jwj.er(l.this.jwk, downloadData.getPath());
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
            if (l.this.jwj != null && l.this.jwk.equals(downloadData.getUrl())) {
                l.this.jwj.EO(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void EO(String str);

        void crb();

        void er(String str, String str2);
    }

    static {
        jwh = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Fl(String str) {
        String nT = as.nT(str);
        if (nT == null) {
            return null;
        }
        if (this.jpQ == null) {
            this.jpQ = new HashMap<>();
            ctX();
        }
        return this.jpQ.get(nT);
    }

    public void ctX() {
        if (!StringUtils.isNull(jwh)) {
            if (this.jpQ == null) {
                this.jpQ = new HashMap<>();
            } else {
                this.jpQ.clear();
            }
            File file = new File(jwh);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jpQ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Fm(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jwh)) {
            if (this.jwj != null) {
                this.jwj.EO("");
                return;
            }
            return;
        }
        String nT = as.nT(str);
        if (nT != null) {
            File file = new File(jwh);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jwi == null) {
                this.jwi = new ArrayList();
            }
            if (!Fn(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jwh + "/" + nT + str2);
                downloadData.setCallback(this.jwl);
                this.jwi.add(downloadData);
                com.baidu.tbadk.download.d.aqM().f(downloadData);
            }
        }
    }

    private boolean Fn(String str) {
        if (v.aa(this.jwi) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jwi) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jwi) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jwi.size()) {
                    i = -1;
                    break;
                } else if (this.jwi.get(i) != null && this.jwi.get(i).getUrl() != null && this.jwi.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jwi.remove(i);
        }
    }

    public void a(a aVar) {
        this.jwj = aVar;
    }

    public void Fo(String str) {
        if (str == null) {
            this.jwk = "";
        } else {
            this.jwk = str;
        }
    }
}
