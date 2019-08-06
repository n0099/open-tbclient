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
    public static final String jDA;
    private List<DownloadData> jDB;
    private a jDC;
    private String jDD;
    private com.baidu.tbadk.download.c jDE = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.v(downloadData);
                if (l.this.jDC != null && l.this.jDD.equals(downloadData.getUrl())) {
                    l.this.jDC.cuj();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.jDA)) {
                l.this.v(downloadData);
                if (l.this.jDC != null && l.this.jDD.equals(downloadData.getUrl())) {
                    l.this.jxi.put(downloadData.getPath().substring(l.jDA.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.jDC.es(l.this.jDD, downloadData.getPath());
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
            if (l.this.jDC != null && l.this.jDD.equals(downloadData.getUrl())) {
                l.this.jDC.FF(str);
            }
        }
    };
    private HashMap<String, String> jxi;

    /* loaded from: classes5.dex */
    public interface a {
        void FF(String str);

        void cuj();

        void es(String str, String str2);
    }

    static {
        jDA = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Gd(String str) {
        String oj = at.oj(str);
        if (oj == null) {
            return null;
        }
        if (this.jxi == null) {
            this.jxi = new HashMap<>();
            cxh();
        }
        return this.jxi.get(oj);
    }

    public void cxh() {
        if (!StringUtils.isNull(jDA)) {
            if (this.jxi == null) {
                this.jxi = new HashMap<>();
            } else {
                this.jxi.clear();
            }
            File file = new File(jDA);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.jxi.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Ge(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(jDA)) {
            if (this.jDC != null) {
                this.jDC.FF("");
                return;
            }
            return;
        }
        String oj = at.oj(str);
        if (oj != null) {
            File file = new File(jDA);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.jDB == null) {
                this.jDB = new ArrayList();
            }
            if (!Gf(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(jDA + "/" + oj + str2);
                downloadData.setCallback(this.jDE);
                this.jDB.add(downloadData);
                com.baidu.tbadk.download.d.arU().f(downloadData);
            }
        }
    }

    private boolean Gf(String str) {
        if (v.aa(this.jDB) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.jDB) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DownloadData downloadData) {
        int i;
        if (!v.aa(this.jDB) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.jDB.size()) {
                    i = -1;
                    break;
                } else if (this.jDB.get(i) != null && this.jDB.get(i).getUrl() != null && this.jDB.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.jDB.remove(i);
        }
    }

    public void a(a aVar) {
        this.jDC = aVar;
    }

    public void Gg(String str) {
        if (str == null) {
            this.jDD = "";
        } else {
            this.jDD = str;
        }
    }
}
