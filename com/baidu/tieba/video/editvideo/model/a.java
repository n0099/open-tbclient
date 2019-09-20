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
    private static volatile a jzD;
    private HashMap<String, String> jzE;
    private DownloadData jzF;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0433a {
        void Gf(String str);

        void cuX();

        void et(String str, String str2);
    }

    private a() {
    }

    public static a cvJ() {
        if (jzD == null) {
            synchronized (a.class) {
                if (jzD == null) {
                    jzD = new a();
                }
            }
        }
        return jzD;
    }

    public String Gn(String str) {
        String ol = as.ol(str);
        if (ol == null) {
            return null;
        }
        if (this.jzE == null) {
            this.jzE = new HashMap<>();
            cvK();
            if (this.jzE.size() > 0) {
                return this.jzE.get(ol);
            }
            return null;
        }
        return this.jzE.get(ol);
    }

    public void cvK() {
        if (this.jzE == null) {
            this.jzE = new HashMap<>();
        } else {
            this.jzE.clear();
        }
        File file = new File(c.jxa);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jzE.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0433a interfaceC0433a) {
        String ol;
        if (!TextUtils.isEmpty(str2) && (ol = as.ol(str2)) != null) {
            if (this.jzF != null) {
                if (!str2.equals(this.jzF.getUrl())) {
                    d.asg().S(this.jzF.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jxa);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jxa + ol + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jzF != null && downloadData2.getUrl().equals(a.this.jzF.getUrl())) {
                            a.this.jzF = null;
                        }
                        if (interfaceC0433a != null) {
                            interfaceC0433a.cuX();
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
                        if (a.this.jzF != null && downloadData2.getUrl().equals(a.this.jzF.getUrl())) {
                            a.this.jzF = null;
                        }
                        if (interfaceC0433a != null) {
                            a.this.jzE.put(downloadData2.getPath().substring(c.jxa.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0433a.et(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jzF != null && downloadData2.getUrl().equals(a.this.jzF.getUrl())) {
                        a.this.jzF = null;
                    }
                    if (interfaceC0433a != null) {
                        interfaceC0433a.Gf(str3);
                    }
                }
            });
            this.jzF = downloadData;
            d.asg().f(downloadData);
        }
    }

    public void cvL() {
        if (this.jzF != null) {
            d.asg().S(this.jzF.getUrl(), true);
        }
    }
}
