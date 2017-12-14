package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a gRY;
    private HashMap<String, String> gRZ;
    private DownloadData gSa;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0148a {
        void bBm();

        void cn(String str, String str2);

        void tW(String str);
    }

    private a() {
    }

    public static a bBZ() {
        if (gRY == null) {
            synchronized (a.class) {
                if (gRY == null) {
                    gRY = new a();
                }
            }
        }
        return gRY;
    }

    public String uf(String str) {
        String dX = ao.dX(str);
        if (dX == null) {
            return null;
        }
        if (this.gRZ == null) {
            this.gRZ = new HashMap<>();
            bCa();
            if (this.gRZ.size() > 0) {
                return this.gRZ.get(dX);
            }
            return null;
        }
        return this.gRZ.get(dX);
    }

    public void bCa() {
        if (this.gRZ == null) {
            this.gRZ = new HashMap<>();
        } else {
            this.gRZ.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gPz);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gRZ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0148a interfaceC0148a) {
        String dX;
        if (!TextUtils.isEmpty(str2) && (dX = ao.dX(str2)) != null) {
            if (this.gSa != null) {
                e.CW().p(this.gSa.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gPz);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gPz + dX + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gSa != null && downloadData2.getUrl().equals(a.this.gSa.getUrl())) {
                            a.this.gSa = null;
                        }
                        if (interfaceC0148a != null) {
                            interfaceC0148a.bBm();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (a.this.gSa != null && downloadData2.getUrl().equals(a.this.gSa.getUrl())) {
                            a.this.gSa = null;
                        }
                        if (interfaceC0148a != null) {
                            a.this.gRZ.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gPz.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0148a.cn(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gSa != null && downloadData2.getUrl().equals(a.this.gSa.getUrl())) {
                        a.this.gSa = null;
                    }
                    if (interfaceC0148a != null) {
                        interfaceC0148a.tW(str3);
                    }
                }
            });
            this.gSa = downloadData;
            e.CW().f(downloadData);
        }
    }

    public void bCb() {
        if (this.gSa != null) {
            e.CW().p(this.gSa.getUrl(), true);
        }
    }
}
