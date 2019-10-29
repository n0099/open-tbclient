package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a jzv;
    private HashMap<String, String> jzw;
    private DownloadData jzx;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0528a {
        void EH(String str);

        void csM();

        void ef(String str, String str2);
    }

    private a() {
    }

    public static a ctx() {
        if (jzv == null) {
            synchronized (a.class) {
                if (jzv == null) {
                    jzv = new a();
                }
            }
        }
        return jzv;
    }

    public String EP(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.jzw == null) {
            this.jzw = new HashMap<>();
            cty();
            if (this.jzw.size() > 0) {
                return this.jzw.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.jzw.get(nameMd5FromUrl);
    }

    public void cty() {
        if (this.jzw == null) {
            this.jzw = new HashMap<>();
        } else {
            this.jzw.clear();
        }
        File file = new File(c.jwS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jzw.put(file2.getName().substring(0, file2.getName().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0528a interfaceC0528a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.jzx != null) {
                if (!str2.equals(this.jzx.getUrl())) {
                    d.atV().cancelDownLoadByUrl(this.jzx.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jwS);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jwS + nameMd5FromUrl + (DefaultConfig.TOKEN_SEPARATOR + str2.substring(str2.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jzx != null && downloadData2.getUrl().equals(a.this.jzx.getUrl())) {
                            a.this.jzx = null;
                        }
                        if (interfaceC0528a != null) {
                            interfaceC0528a.csM();
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
                        if (a.this.jzx != null && downloadData2.getUrl().equals(a.this.jzx.getUrl())) {
                            a.this.jzx = null;
                        }
                        if (interfaceC0528a != null) {
                            a.this.jzw.put(downloadData2.getPath().substring(c.jwS.length(), downloadData2.getPath().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), downloadData2.getPath());
                            interfaceC0528a.ef(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jzx != null && downloadData2.getUrl().equals(a.this.jzx.getUrl())) {
                        a.this.jzx = null;
                    }
                    if (interfaceC0528a != null) {
                        interfaceC0528a.EH(str3);
                    }
                }
            });
            this.jzx = downloadData;
            d.atV().f(downloadData);
        }
    }

    public void ctz() {
        if (this.jzx != null) {
            d.atV().cancelDownLoadByUrl(this.jzx.getUrl(), true);
        }
    }
}
