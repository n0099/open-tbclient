package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes17.dex */
public class a {
    private static volatile a mel;
    private HashMap<String, String> men;
    private DownloadData meo;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0763a {
        void OE(String str);

        void dpJ();

        void fG(String str, String str2);
    }

    private a() {
    }

    public static a dqp() {
        if (mel == null) {
            synchronized (a.class) {
                if (mel == null) {
                    mel = new a();
                }
            }
        }
        return mel;
    }

    public String OK(String str) {
        String nameMd5FromUrl = au.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.men == null) {
            this.men = new HashMap<>();
            dqq();
            if (this.men.size() > 0) {
                return this.men.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.men.get(nameMd5FromUrl);
    }

    public void dqq() {
        if (this.men == null) {
            this.men = new HashMap<>();
        } else {
            this.men.clear();
        }
        File file = new File(c.mbN);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.men.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0763a interfaceC0763a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = au.getNameMd5FromUrl(str2)) != null) {
            if (this.meo != null) {
                if (!str2.equals(this.meo.getUrl())) {
                    d.biF().cancelDownLoadByUrl(this.meo.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.mbN);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mbN + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.meo != null && downloadData2.getUrl().equals(a.this.meo.getUrl())) {
                            a.this.meo = null;
                        }
                        if (interfaceC0763a != null) {
                            interfaceC0763a.dpJ();
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
                        if (a.this.meo != null && downloadData2.getUrl().equals(a.this.meo.getUrl())) {
                            a.this.meo = null;
                        }
                        if (interfaceC0763a != null) {
                            a.this.men.put(downloadData2.getPath().substring(c.mbN.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0763a.fG(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.meo != null && downloadData2.getUrl().equals(a.this.meo.getUrl())) {
                        a.this.meo = null;
                    }
                    if (interfaceC0763a != null) {
                        interfaceC0763a.OE(str3);
                    }
                }
            });
            this.meo = downloadData;
            d.biF().f(downloadData);
        }
    }

    public void dqr() {
        if (this.meo != null) {
            d.biF().cancelDownLoadByUrl(this.meo.getUrl(), true);
        }
    }
}
