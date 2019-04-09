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
    private static volatile a iWS;
    private HashMap<String, String> iWT;
    private DownloadData iWU;

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
        if (iWS == null) {
            synchronized (a.class) {
                if (iWS == null) {
                    iWS = new a();
                }
            }
        }
        return iWS;
    }

    public String DA(String str) {
        String mL = as.mL(str);
        if (mL == null) {
            return null;
        }
        if (this.iWT == null) {
            this.iWT = new HashMap<>();
            cjJ();
            if (this.iWT.size() > 0) {
                return this.iWT.get(mL);
            }
            return null;
        }
        return this.iWT.get(mL);
    }

    public void cjJ() {
        if (this.iWT == null) {
            this.iWT = new HashMap<>();
        } else {
            this.iWT.clear();
        }
        File file = new File(c.iUo);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.iWT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0398a interfaceC0398a) {
        String mL;
        if (!TextUtils.isEmpty(str2) && (mL = as.mL(str2)) != null) {
            if (this.iWU != null) {
                if (!str2.equals(this.iWU.getUrl())) {
                    d.alJ().O(this.iWU.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.iUo);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.iUo + mL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.iWU != null && downloadData2.getUrl().equals(a.this.iWU.getUrl())) {
                            a.this.iWU = null;
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
                        if (a.this.iWU != null && downloadData2.getUrl().equals(a.this.iWU.getUrl())) {
                            a.this.iWU = null;
                        }
                        if (interfaceC0398a != null) {
                            a.this.iWT.put(downloadData2.getPath().substring(c.iUo.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
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
                    if (a.this.iWU != null && downloadData2.getUrl().equals(a.this.iWU.getUrl())) {
                        a.this.iWU = null;
                    }
                    if (interfaceC0398a != null) {
                        interfaceC0398a.Ds(str3);
                    }
                }
            });
            this.iWU = downloadData;
            d.alJ().f(downloadData);
        }
    }

    public void cjK() {
        if (this.iWU != null) {
            d.alJ().O(this.iWU.getUrl(), true);
        }
    }
}
