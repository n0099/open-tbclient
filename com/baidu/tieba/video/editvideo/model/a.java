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
    private static volatile a kwZ;
    private HashMap<String, String> kxa;
    private DownloadData kxb;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0620a {
        void JT(String str);

        void cPo();

        void eJ(String str, String str2);
    }

    private a() {
    }

    public static a cPW() {
        if (kwZ == null) {
            synchronized (a.class) {
                if (kwZ == null) {
                    kwZ = new a();
                }
            }
        }
        return kwZ;
    }

    public String Ka(String str) {
        String nameMd5FromUrl = as.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.kxa == null) {
            this.kxa = new HashMap<>();
            cPX();
            if (this.kxa.size() > 0) {
                return this.kxa.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.kxa.get(nameMd5FromUrl);
    }

    public void cPX() {
        if (this.kxa == null) {
            this.kxa = new HashMap<>();
        } else {
            this.kxa.clear();
        }
        File file = new File(c.kuJ);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.kxa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0620a interfaceC0620a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = as.getNameMd5FromUrl(str2)) != null) {
            if (this.kxb != null) {
                if (!str2.equals(this.kxb.getUrl())) {
                    d.aOn().cancelDownLoadByUrl(this.kxb.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.kuJ);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.kuJ + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.kxb != null && downloadData2.getUrl().equals(a.this.kxb.getUrl())) {
                            a.this.kxb = null;
                        }
                        if (interfaceC0620a != null) {
                            interfaceC0620a.cPo();
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
                        if (a.this.kxb != null && downloadData2.getUrl().equals(a.this.kxb.getUrl())) {
                            a.this.kxb = null;
                        }
                        if (interfaceC0620a != null) {
                            a.this.kxa.put(downloadData2.getPath().substring(c.kuJ.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0620a.eJ(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.kxb != null && downloadData2.getUrl().equals(a.this.kxb.getUrl())) {
                        a.this.kxb = null;
                    }
                    if (interfaceC0620a != null) {
                        interfaceC0620a.JT(str3);
                    }
                }
            });
            this.kxb = downloadData;
            d.aOn().f(downloadData);
        }
    }

    public void cPY() {
        if (this.kxb != null) {
            d.aOn().cancelDownLoadByUrl(this.kxb.getUrl(), true);
        }
    }
}
