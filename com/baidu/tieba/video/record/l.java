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
    public static final String jwk;
    private HashMap<String, String> jpT;
    private List<DownloadData> jwl;
    private a jwm;
    private String jwn;
    private com.baidu.tbadk.download.c jwo = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jwm != null && l.this.jwn.equals(downloadData.getUrl())) {
                    l.this.jwm.crc();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jwk)) {
                l.this.v(downloadData);
                if (l.this.jwm != null && l.this.jwn.equals(downloadData.getUrl())) {
                    l.this.jpT.put(downloadData.getPath().substring(l.jwk.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jwm.er(l.this.jwn, downloadData.getPath());
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
            if (l.this.jwm != null && l.this.jwn.equals(downloadData.getUrl())) {
                l.this.jwm.EQ(str);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void EQ(String str);

        void crc();

        void er(String str, String str2);
    }

    static {
        jwk = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Fn(String str) {
        String nS = as.nS(str);
        if (nS == null) {
            return null;
        }
        if (this.jpT == null) {
            this.jpT = new HashMap<>();
            ctW();
        }
        return this.jpT.get(nS);
    }

    public void ctW() {
        if (!StringUtils.isNull(jwk)) {
            if (this.jpT == null) {
                this.jpT = new HashMap<>();
            } else {
                this.jpT.clear();
            }
            File file = new File(jwk);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jpT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Fo(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jwk)) {
            if (this.jwm != null) {
                this.jwm.EQ("");
                return;
            }
            return;
        }
        String nS = as.nS(str);
        if (nS != null) {
            File file = new File(jwk);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jwl == null) {
                this.jwl = new ArrayList();
            }
            if (!Fp(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jwk + "/" + nS + str2);
                downloadData.setCallback(this.jwo);
                this.jwl.add(downloadData);
                com.baidu.tbadk.download.d.aqM().f(downloadData);
            }
        }
    }

    private boolean Fp(String str) {
        if (v.aa(this.jwl) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jwl) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jwl) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jwl.size()) {
                    i = -1;
                    break;
                } else if (this.jwl.get(i) != null && this.jwl.get(i).getUrl() != null && this.jwl.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jwl.remove(i);
        }
    }

    public void a(a aVar) {
        this.jwm = aVar;
    }

    public void Fq(String str) {
        if (str == null) {
            this.jwn = "";
        } else {
            this.jwn = str;
        }
    }
}
