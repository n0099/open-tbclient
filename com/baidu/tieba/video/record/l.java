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
/* loaded from: classes10.dex */
public class l {
    public static final String lpH;
    private HashMap<String, String> ljo;
    private List<DownloadData> lpI;
    private a lpJ;
    private String lpK;
    private com.baidu.tbadk.download.c lpL = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.record.l.1
        @Override // com.baidu.tbadk.download.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.w(downloadData);
                if (l.this.lpJ != null && l.this.lpK.equals(downloadData.getUrl())) {
                    l.this.lpJ.daF();
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
            if (downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(l.lpH)) {
                l.this.w(downloadData);
                if (l.this.lpJ != null && l.this.lpK.equals(downloadData.getUrl())) {
                    l.this.ljo.put(downloadData.getPath().substring(l.lpH.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                    l.this.lpJ.eW(l.this.lpK, downloadData.getPath());
                }
            }
        }

        @Override // com.baidu.tbadk.download.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.w(downloadData);
            if (l.this.lpJ != null && l.this.lpK.equals(downloadData.getUrl())) {
                l.this.lpJ.LG(str);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void LG(String str);

        void daF();

        void eW(String str, String str2);
    }

    static {
        lpH = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public String Md(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljo == null) {
            this.ljo = new HashMap<>();
            ddu();
        }
        return this.ljo.get(nameMd5FromUrl);
    }

    public void ddu() {
        if (!StringUtils.isNull(lpH)) {
            if (this.ljo == null) {
                this.ljo = new HashMap<>();
            } else {
                this.ljo.clear();
            }
            File file = new File(lpH);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        this.ljo.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void Me(String str) {
        if (TextUtils.isEmpty(str) || StringUtils.isNull(lpH)) {
            if (this.lpJ != null) {
                this.lpJ.LG("");
                return;
            }
            return;
        }
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl != null) {
            File file = new File(lpH);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.lpI == null) {
                this.lpI = new ArrayList();
            }
            if (!Mf(str)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(lpH + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.lpL);
                this.lpI.add(downloadData);
                com.baidu.tbadk.download.d.aWJ().f(downloadData);
            }
        }
    }

    private boolean Mf(String str) {
        if (v.isEmpty(this.lpI) || str == null) {
            return false;
        }
        for (DownloadData downloadData : this.lpI) {
            if (downloadData != null && str.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadData downloadData) {
        int i;
        if (!v.isEmpty(this.lpI) && downloadData != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.lpI.size()) {
                    i = -1;
                    break;
                } else if (this.lpI.get(i) != null && this.lpI.get(i).getUrl() != null && this.lpI.get(i).getUrl().equals(downloadData.getUrl())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.lpI.remove(i);
        }
    }

    public void a(a aVar) {
        this.lpJ = aVar;
    }

    public void Mg(String str) {
        if (str == null) {
            this.lpK = "";
        } else {
            this.lpK = str;
        }
    }
}
