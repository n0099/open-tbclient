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
    private static volatile a jyE;
    private HashMap<String, String> jyF;
    private DownloadData jyG;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0523a {
        void EH(String str);

        void csK();

        void ef(String str, String str2);
    }

    private a() {
    }

    public static a ctv() {
        if (jyE == null) {
            synchronized (a.class) {
                if (jyE == null) {
                    jyE = new a();
                }
            }
        }
        return jyE;
    }

    public String EP(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.jyF == null) {
            this.jyF = new HashMap<>();
            ctw();
            if (this.jyF.size() > 0) {
                return this.jyF.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.jyF.get(nameMd5FromUrl);
    }

    public void ctw() {
        if (this.jyF == null) {
            this.jyF = new HashMap<>();
        } else {
            this.jyF.clear();
        }
        File file = new File(c.jwb);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jyF.put(file2.getName().substring(0, file2.getName().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0523a interfaceC0523a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.jyG != null) {
                if (!str2.equals(this.jyG.getUrl())) {
                    d.atT().cancelDownLoadByUrl(this.jyG.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jwb);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jwb + nameMd5FromUrl + (DefaultConfig.TOKEN_SEPARATOR + str2.substring(str2.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jyG != null && downloadData2.getUrl().equals(a.this.jyG.getUrl())) {
                            a.this.jyG = null;
                        }
                        if (interfaceC0523a != null) {
                            interfaceC0523a.csK();
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
                        if (a.this.jyG != null && downloadData2.getUrl().equals(a.this.jyG.getUrl())) {
                            a.this.jyG = null;
                        }
                        if (interfaceC0523a != null) {
                            a.this.jyF.put(downloadData2.getPath().substring(c.jwb.length(), downloadData2.getPath().lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)), downloadData2.getPath());
                            interfaceC0523a.ef(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jyG != null && downloadData2.getUrl().equals(a.this.jyG.getUrl())) {
                        a.this.jyG = null;
                    }
                    if (interfaceC0523a != null) {
                        interfaceC0523a.EH(str3);
                    }
                }
            });
            this.jyG = downloadData;
            d.atT().f(downloadData);
        }
    }

    public void ctx() {
        if (this.jyG != null) {
            d.atT().cancelDownLoadByUrl(this.jyG.getUrl(), true);
        }
    }
}
