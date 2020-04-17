package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    private static volatile a ljj;
    private HashMap<String, String> ljk;
    private DownloadData ljl;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0662a {
        void LD(String str);

        void daH();

        void eW(String str, String str2);
    }

    private a() {
    }

    public static a dbq() {
        if (ljj == null) {
            synchronized (a.class) {
                if (ljj == null) {
                    ljj = new a();
                }
            }
        }
        return ljj;
    }

    public String LL(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.ljk == null) {
            this.ljk = new HashMap<>();
            dbr();
            if (this.ljk.size() > 0) {
                return this.ljk.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.ljk.get(nameMd5FromUrl);
    }

    public void dbr() {
        if (this.ljk == null) {
            this.ljk = new HashMap<>();
        } else {
            this.ljk.clear();
        }
        File file = new File(c.lgO);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.ljk.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0662a interfaceC0662a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.ljl != null) {
                if (!str2.equals(this.ljl.getUrl())) {
                    d.aWL().cancelDownLoadByUrl(this.ljl.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.lgO);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.lgO + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.ljl != null && downloadData2.getUrl().equals(a.this.ljl.getUrl())) {
                            a.this.ljl = null;
                        }
                        if (interfaceC0662a != null) {
                            interfaceC0662a.daH();
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
                        if (a.this.ljl != null && downloadData2.getUrl().equals(a.this.ljl.getUrl())) {
                            a.this.ljl = null;
                        }
                        if (interfaceC0662a != null) {
                            a.this.ljk.put(downloadData2.getPath().substring(c.lgO.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0662a.eW(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.ljl != null && downloadData2.getUrl().equals(a.this.ljl.getUrl())) {
                        a.this.ljl = null;
                    }
                    if (interfaceC0662a != null) {
                        interfaceC0662a.LD(str3);
                    }
                }
            });
            this.ljl = downloadData;
            d.aWL().f(downloadData);
        }
    }

    public void dbs() {
        if (this.ljl != null) {
            d.aWL().cancelDownLoadByUrl(this.ljl.getUrl(), true);
        }
    }
}
