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
    public static final String jwg;
    private HashMap<String, String> jpP;
    private List<DownloadData> jwh;
    private a jwi;
    private String jwj;
    private com.baidu.tbadk.download.c jwk = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jwi != null && l.this.jwj.equals(downloadData.getUrl())) {
                    l.this.jwi.cqZ();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jwg)) {
                l.this.v(downloadData);
                if (l.this.jwi != null && l.this.jwj.equals(downloadData.getUrl())) {
                    l.this.jpP.put(downloadData.getPath().substring(l.jwg.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jwi.er(l.this.jwj, downloadData.getPath());
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
            if (l.this.jwi != null && l.this.jwj.equals(downloadData.getUrl())) {
                l.this.jwi.EO(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void EO(String str);

        void cqZ();

        void er(String str, String str2);
    }

    static {
        jwg = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Fl(String str) {
        String nT = as.nT(str);
        if (nT == null) {
            return null;
        }
        if (this.jpP == null) {
            this.jpP = new HashMap<>();
            ctV();
        }
        return this.jpP.get(nT);
    }

    public void ctV() {
        if (!StringUtils.isNull(jwg)) {
            if (this.jpP == null) {
                this.jpP = new HashMap<>();
            } else {
                this.jpP.clear();
            }
            File file = new File(jwg);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jpP.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Fm(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jwg)) {
            if (this.jwi != null) {
                this.jwi.EO("");
                return;
            }
            return;
        }
        String nT = as.nT(str);
        if (nT != null) {
            File file = new File(jwg);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jwh == null) {
                this.jwh = new ArrayList();
            }
            if (!Fn(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jwg + "/" + nT + str2);
                downloadData.setCallback(this.jwk);
                this.jwh.add(downloadData);
                com.baidu.tbadk.download.d.aqM().f(downloadData);
            }
        }
    }

    private boolean Fn(String str) {
        if (v.aa(this.jwh) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jwh) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jwh) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jwh.size()) {
                    i = -1;
                    break;
                } else if (this.jwh.get(i) != null && this.jwh.get(i).getUrl() != null && this.jwh.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jwh.remove(i);
        }
    }

    public void a(a aVar) {
        this.jwi = aVar;
    }

    public void Fo(String str) {
        if (str == null) {
            this.jwj = "";
        } else {
            this.jwj = str;
        }
    }
}
