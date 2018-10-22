package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a hto;
    private HashMap<String, String> htp;
    private DownloadData htq;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0283a {
        void bGw();

        void cM(String str, String str2);

        void vR(String str);
    }

    private a() {
    }

    public static a bHi() {
        if (hto == null) {
            synchronized (a.class) {
                if (hto == null) {
                    hto = new a();
                }
            }
        }
        return hto;
    }

    public String vZ(String str) {
        String fs = ar.fs(str);
        if (fs == null) {
            return null;
        }
        if (this.htp == null) {
            this.htp = new HashMap<>();
            bHj();
            if (this.htp.size() > 0) {
                return this.htp.get(fs);
            }
            return null;
        }
        return this.htp.get(fs);
    }

    public void bHj() {
        if (this.htp == null) {
            this.htp = new HashMap<>();
        } else {
            this.htp.clear();
        }
        File file = new File(c.hqL);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.htp.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0283a interfaceC0283a) {
        String fs;
        if (!TextUtils.isEmpty(str2) && (fs = ar.fs(str2)) != null) {
            if (this.htq != null) {
                if (!str2.equals(this.htq.getUrl())) {
                    d.KB().t(this.htq.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hqL);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hqL + fs + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.htq != null && downloadData2.getUrl().equals(a.this.htq.getUrl())) {
                            a.this.htq = null;
                        }
                        if (interfaceC0283a != null) {
                            interfaceC0283a.bGw();
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
                        if (a.this.htq != null && downloadData2.getUrl().equals(a.this.htq.getUrl())) {
                            a.this.htq = null;
                        }
                        if (interfaceC0283a != null) {
                            a.this.htp.put(downloadData2.getPath().substring(c.hqL.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0283a.cM(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.htq != null && downloadData2.getUrl().equals(a.this.htq.getUrl())) {
                        a.this.htq = null;
                    }
                    if (interfaceC0283a != null) {
                        interfaceC0283a.vR(str3);
                    }
                }
            });
            this.htq = downloadData;
            d.KB().f(downloadData);
        }
    }

    public void bHk() {
        if (this.htq != null) {
            d.KB().t(this.htq.getUrl(), true);
        }
    }
}
