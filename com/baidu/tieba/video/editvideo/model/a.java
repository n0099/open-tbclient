package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a jpO;
    private HashMap<String, String> jpP;
    private DownloadData jpQ;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0417a {
        void EO(String str);

        void cqZ();

        void er(String str, String str2);
    }

    private a() {
    }

    public static a crL() {
        if (jpO == null) {
            synchronized (a.class) {
                if (jpO == null) {
                    jpO = new a();
                }
            }
        }
        return jpO;
    }

    public String EW(String str) {
        String nT = as.nT(str);
        if (nT == null) {
            return null;
        }
        if (this.jpP == null) {
            this.jpP = new HashMap<>();
            crM();
            if (this.jpP.size() > 0) {
                return this.jpP.get(nT);
            }
            return null;
        }
        return this.jpP.get(nT);
    }

    public void crM() {
        if (this.jpP == null) {
            this.jpP = new HashMap<>();
        } else {
            this.jpP.clear();
        }
        File file = new File(c.jnl);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jpP.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0417a interfaceC0417a) {
        String nT;
        if (!TextUtils.isEmpty(str2) && (nT = as.nT(str2)) != null) {
            if (this.jpQ != null) {
                if (!str2.equals(this.jpQ.getUrl())) {
                    d.aqM().Q(this.jpQ.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jnl);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jnl + nT + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jpQ != null && downloadData2.getUrl().equals(a.this.jpQ.getUrl())) {
                            a.this.jpQ = null;
                        }
                        if (interfaceC0417a != null) {
                            interfaceC0417a.cqZ();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (a.this.jpQ != null && downloadData2.getUrl().equals(a.this.jpQ.getUrl())) {
                            a.this.jpQ = null;
                        }
                        if (interfaceC0417a != null) {
                            a.this.jpP.put(downloadData2.getPath().substring(c.jnl.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0417a.er(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jpQ != null && downloadData2.getUrl().equals(a.this.jpQ.getUrl())) {
                        a.this.jpQ = null;
                    }
                    if (interfaceC0417a != null) {
                        interfaceC0417a.EO(str3);
                    }
                }
            });
            this.jpQ = downloadData;
            d.aqM().f(downloadData);
        }
    }

    public void crN() {
        if (this.jpQ != null) {
            d.aqM().Q(this.jpQ.getUrl(), true);
        }
    }
}
