package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a iWR;
    private HashMap<String, String> iWS;
    private DownloadData iWT;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0398a {
        void Ds(String str);

        void ciW();

        void ed(String str, String str2);
    }

    private a() {
    }

    public static a cjI() {
        if (iWR == null) {
            synchronized (a.class) {
                if (iWR == null) {
                    iWR = new a();
                }
            }
        }
        return iWR;
    }

    public String DA(String str) {
        String mL = as.mL(str);
        if (mL == null) {
            return null;
        }
        if (this.iWS == null) {
            this.iWS = new HashMap<>();
            cjJ();
            if (this.iWS.size() > 0) {
                return this.iWS.get(mL);
            }
            return null;
        }
        return this.iWS.get(mL);
    }

    public void cjJ() {
        if (this.iWS == null) {
            this.iWS = new HashMap<>();
        } else {
            this.iWS.clear();
        }
        File file = new File(c.iUn);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.iWS.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0398a interfaceC0398a) {
        String mL;
        if (!TextUtils.isEmpty(str2) && (mL = as.mL(str2)) != null) {
            if (this.iWT != null) {
                if (!str2.equals(this.iWT.getUrl())) {
                    d.alJ().O(this.iWT.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.iUn);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.iUn + mL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.iWT != null && downloadData2.getUrl().equals(a.this.iWT.getUrl())) {
                            a.this.iWT = null;
                        }
                        if (interfaceC0398a != null) {
                            interfaceC0398a.ciW();
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
                        if (a.this.iWT != null && downloadData2.getUrl().equals(a.this.iWT.getUrl())) {
                            a.this.iWT = null;
                        }
                        if (interfaceC0398a != null) {
                            a.this.iWS.put(downloadData2.getPath().substring(c.iUn.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0398a.ed(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.iWT != null && downloadData2.getUrl().equals(a.this.iWT.getUrl())) {
                        a.this.iWT = null;
                    }
                    if (interfaceC0398a != null) {
                        interfaceC0398a.Ds(str3);
                    }
                }
            });
            this.iWT = downloadData;
            d.alJ().f(downloadData);
        }
    }

    public void cjK() {
        if (this.iWT != null) {
            d.alJ().O(this.iWT.getUrl(), true);
        }
    }
}
