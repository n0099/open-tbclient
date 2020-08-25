package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes17.dex */
public class a {
    private static volatile a mvW;
    private HashMap<String, String> mvX;
    private DownloadData mvY;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0815a {
        void RC(String str);

        void dBe();

        void fX(String str, String str2);
    }

    private a() {
    }

    public static a dBK() {
        if (mvW == null) {
            synchronized (a.class) {
                if (mvW == null) {
                    mvW = new a();
                }
            }
        }
        return mvW;
    }

    public String RI(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mvX == null) {
            this.mvX = new HashMap<>();
            dBL();
            if (this.mvX.size() > 0) {
                return this.mvX.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.mvX.get(nameMd5FromUrl);
    }

    public void dBL() {
        if (this.mvX == null) {
            this.mvX = new HashMap<>();
        } else {
            this.mvX.clear();
        }
        File file = new File(c.mty);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.mvX.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0815a interfaceC0815a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.mvY != null) {
                if (!str2.equals(this.mvY.getUrl())) {
                    d.brr().cancelDownLoadByUrl(this.mvY.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.mty);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mty + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.mvY != null && downloadData2.getUrl().equals(a.this.mvY.getUrl())) {
                            a.this.mvY = null;
                        }
                        if (interfaceC0815a != null) {
                            interfaceC0815a.dBe();
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
                        if (a.this.mvY != null && downloadData2.getUrl().equals(a.this.mvY.getUrl())) {
                            a.this.mvY = null;
                        }
                        if (interfaceC0815a != null) {
                            a.this.mvX.put(downloadData2.getPath().substring(c.mty.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0815a.fX(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.mvY != null && downloadData2.getUrl().equals(a.this.mvY.getUrl())) {
                        a.this.mvY = null;
                    }
                    if (interfaceC0815a != null) {
                        interfaceC0815a.RC(str3);
                    }
                }
            });
            this.mvY = downloadData;
            d.brr().f(downloadData);
        }
    }

    public void dBM() {
        if (this.mvY != null) {
            d.brr().cancelDownLoadByUrl(this.mvY.getUrl(), true);
        }
    }
}
