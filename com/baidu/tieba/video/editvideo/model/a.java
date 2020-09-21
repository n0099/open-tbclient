package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class a {
    private static volatile a mFZ;
    private HashMap<String, String> mGa;
    private DownloadData mGb;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0812a {
        void Sc(String str);

        void dFh();

        void gk(String str, String str2);
    }

    private a() {
    }

    public static a dFN() {
        if (mFZ == null) {
            synchronized (a.class) {
                if (mFZ == null) {
                    mFZ = new a();
                }
            }
        }
        return mFZ;
    }

    public String Si(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mGa == null) {
            this.mGa = new HashMap<>();
            dFO();
            if (this.mGa.size() > 0) {
                return this.mGa.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.mGa.get(nameMd5FromUrl);
    }

    public void dFO() {
        if (this.mGa == null) {
            this.mGa = new HashMap<>();
        } else {
            this.mGa.clear();
        }
        File file = new File(c.mDB);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.mGa.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0812a interfaceC0812a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.mGb != null) {
                if (!str2.equals(this.mGb.getUrl())) {
                    d.bsr().cancelDownLoadByUrl(this.mGb.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.mDB);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mDB + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.mGb != null && downloadData2.getUrl().equals(a.this.mGb.getUrl())) {
                            a.this.mGb = null;
                        }
                        if (interfaceC0812a != null) {
                            interfaceC0812a.dFh();
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
                        if (a.this.mGb != null && downloadData2.getUrl().equals(a.this.mGb.getUrl())) {
                            a.this.mGb = null;
                        }
                        if (interfaceC0812a != null) {
                            a.this.mGa.put(downloadData2.getPath().substring(c.mDB.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0812a.gk(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.mGb != null && downloadData2.getUrl().equals(a.this.mGb.getUrl())) {
                        a.this.mGb = null;
                    }
                    if (interfaceC0812a != null) {
                        interfaceC0812a.Sc(str3);
                    }
                }
            });
            this.mGb = downloadData;
            d.bsr().f(downloadData);
        }
    }

    public void dFP() {
        if (this.mGb != null) {
            d.bsr().cancelDownLoadByUrl(this.mGb.getUrl(), true);
        }
    }
}
