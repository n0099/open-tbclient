package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a hlY;
    private HashMap<String, String> hlZ;
    private DownloadData hma;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0248a {
        void bDi();

        void cB(String str, String str2);

        void vp(String str);
    }

    private a() {
    }

    public static a bDU() {
        if (hlY == null) {
            synchronized (a.class) {
                if (hlY == null) {
                    hlY = new a();
                }
            }
        }
        return hlY;
    }

    public String vy(String str) {
        String fe = ar.fe(str);
        if (fe == null) {
            return null;
        }
        if (this.hlZ == null) {
            this.hlZ = new HashMap<>();
            bDV();
            if (this.hlZ.size() > 0) {
                return this.hlZ.get(fe);
            }
            return null;
        }
        return this.hlZ.get(fe);
    }

    public void bDV() {
        if (this.hlZ == null) {
            this.hlZ = new HashMap<>();
        } else {
            this.hlZ.clear();
        }
        File file = new File(c.hju);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hlZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0248a interfaceC0248a) {
        String fe;
        if (!TextUtils.isEmpty(str2) && (fe = ar.fe(str2)) != null) {
            if (this.hma != null) {
                if (!str2.equals(this.hma.getUrl())) {
                    d.ID().m(this.hma.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.hju);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.hju + fe + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hma != null && downloadData2.getUrl().equals(a.this.hma.getUrl())) {
                            a.this.hma = null;
                        }
                        if (interfaceC0248a != null) {
                            interfaceC0248a.bDi();
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
                        if (a.this.hma != null && downloadData2.getUrl().equals(a.this.hma.getUrl())) {
                            a.this.hma = null;
                        }
                        if (interfaceC0248a != null) {
                            a.this.hlZ.put(downloadData2.getPath().substring(c.hju.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0248a.cB(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hma != null && downloadData2.getUrl().equals(a.this.hma.getUrl())) {
                        a.this.hma = null;
                    }
                    if (interfaceC0248a != null) {
                        interfaceC0248a.vp(str3);
                    }
                }
            });
            this.hma = downloadData;
            d.ID().f(downloadData);
        }
    }

    public void bDW() {
        if (this.hma != null) {
            d.ID().m(this.hma.getUrl(), true);
        }
    }
}
