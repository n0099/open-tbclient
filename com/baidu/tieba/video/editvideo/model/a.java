package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a jxh;
    private HashMap<String, String> jxi;
    private DownloadData jxj;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0422a {
        void FF(String str);

        void cuj();

        void es(String str, String str2);
    }

    private a() {
    }

    public static a cuV() {
        if (jxh == null) {
            synchronized (a.class) {
                if (jxh == null) {
                    jxh = new a();
                }
            }
        }
        return jxh;
    }

    public String FN(String str) {
        String oj = at.oj(str);
        if (oj == null) {
            return null;
        }
        if (this.jxi == null) {
            this.jxi = new HashMap<>();
            cuW();
            if (this.jxi.size() > 0) {
                return this.jxi.get(oj);
            }
            return null;
        }
        return this.jxi.get(oj);
    }

    public void cuW() {
        if (this.jxi == null) {
            this.jxi = new HashMap<>();
        } else {
            this.jxi.clear();
        }
        File file = new File(c.juE);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jxi.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0422a interfaceC0422a) {
        String oj;
        if (!TextUtils.isEmpty(str2) && (oj = at.oj(str2)) != null) {
            if (this.jxj != null) {
                if (!str2.equals(this.jxj.getUrl())) {
                    d.arU().S(this.jxj.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.juE);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.juE + oj + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jxj != null && downloadData2.getUrl().equals(a.this.jxj.getUrl())) {
                            a.this.jxj = null;
                        }
                        if (interfaceC0422a != null) {
                            interfaceC0422a.cuj();
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
                        if (a.this.jxj != null && downloadData2.getUrl().equals(a.this.jxj.getUrl())) {
                            a.this.jxj = null;
                        }
                        if (interfaceC0422a != null) {
                            a.this.jxi.put(downloadData2.getPath().substring(c.juE.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0422a.es(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jxj != null && downloadData2.getUrl().equals(a.this.jxj.getUrl())) {
                        a.this.jxj = null;
                    }
                    if (interfaceC0422a != null) {
                        interfaceC0422a.FF(str3);
                    }
                }
            });
            this.jxj = downloadData;
            d.arU().f(downloadData);
        }
    }

    public void cuX() {
        if (this.jxj != null) {
            d.arU().S(this.jxj.getUrl(), true);
        }
    }
}
