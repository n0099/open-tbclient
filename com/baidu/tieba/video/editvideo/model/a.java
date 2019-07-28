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
    private static volatile a jwa;
    private HashMap<String, String> jwb;
    private DownloadData jwc;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0422a {
        void FE(String str);

        void ctN();

        void es(String str, String str2);
    }

    private a() {
    }

    public static a cuz() {
        if (jwa == null) {
            synchronized (a.class) {
                if (jwa == null) {
                    jwa = new a();
                }
            }
        }
        return jwa;
    }

    public String FM(String str) {
        String oj = at.oj(str);
        if (oj == null) {
            return null;
        }
        if (this.jwb == null) {
            this.jwb = new HashMap<>();
            cuA();
            if (this.jwb.size() > 0) {
                return this.jwb.get(oj);
            }
            return null;
        }
        return this.jwb.get(oj);
    }

    public void cuA() {
        if (this.jwb == null) {
            this.jwb = new HashMap<>();
        } else {
            this.jwb.clear();
        }
        File file = new File(c.jtx);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jwb.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0422a interfaceC0422a) {
        String oj;
        if (!TextUtils.isEmpty(str2) && (oj = at.oj(str2)) != null) {
            if (this.jwc != null) {
                if (!str2.equals(this.jwc.getUrl())) {
                    d.arS().S(this.jwc.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jtx);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jtx + oj + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jwc != null && downloadData2.getUrl().equals(a.this.jwc.getUrl())) {
                            a.this.jwc = null;
                        }
                        if (interfaceC0422a != null) {
                            interfaceC0422a.ctN();
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
                        if (a.this.jwc != null && downloadData2.getUrl().equals(a.this.jwc.getUrl())) {
                            a.this.jwc = null;
                        }
                        if (interfaceC0422a != null) {
                            a.this.jwb.put(downloadData2.getPath().substring(c.jtx.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (a.this.jwc != null && downloadData2.getUrl().equals(a.this.jwc.getUrl())) {
                        a.this.jwc = null;
                    }
                    if (interfaceC0422a != null) {
                        interfaceC0422a.FE(str3);
                    }
                }
            });
            this.jwc = downloadData;
            d.arS().f(downloadData);
        }
    }

    public void cuB() {
        if (this.jwc != null) {
            d.arS().S(this.jwc.getUrl(), true);
        }
    }
}
