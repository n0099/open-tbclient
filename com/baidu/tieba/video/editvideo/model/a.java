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
    private static volatile a gFm;
    private HashMap<String, String> gFn;
    private DownloadData gFo;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0134a {
        void byC();

        void cj(String str, String str2);

        void tl(String str);
    }

    private a() {
    }

    public static a bzc() {
        if (gFm == null) {
            synchronized (a.class) {
                if (gFm == null) {
                    gFm = new a();
                }
            }
        }
        return gFm;
    }

    public String tp(String str) {
        String dV = ao.dV(str);
        if (dV == null) {
            return null;
        }
        if (this.gFn == null) {
            this.gFn = new HashMap<>();
            bzd();
            if (this.gFn.size() > 0) {
                return this.gFn.get(dV);
            }
            return null;
        }
        return this.gFn.get(dV);
    }

    public void bzd() {
        if (this.gFn == null) {
            this.gFn = new HashMap<>();
        } else {
            this.gFn.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gDz);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gFn.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0134a interfaceC0134a) {
        String dV;
        if (!TextUtils.isEmpty(str2) && (dV = ao.dV(str2)) != null) {
            if (this.gFo != null) {
                e.CM().o(this.gFo.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gDz);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gDz + dV + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gFo != null && downloadData2.getUrl().equals(a.this.gFo.getUrl())) {
                            a.this.gFo = null;
                        }
                        if (interfaceC0134a != null) {
                            interfaceC0134a.byC();
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
                        if (a.this.gFo != null && downloadData2.getUrl().equals(a.this.gFo.getUrl())) {
                            a.this.gFo = null;
                        }
                        if (interfaceC0134a != null) {
                            a.this.gFn.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gDz.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0134a.cj(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gFo != null && downloadData2.getUrl().equals(a.this.gFo.getUrl())) {
                        a.this.gFo = null;
                    }
                    if (interfaceC0134a != null) {
                        interfaceC0134a.tl(str3);
                    }
                }
            });
            this.gFo = downloadData;
            e.CM().f(downloadData);
        }
    }

    public void bze() {
        if (this.gFo != null) {
            e.CM().o(this.gFo.getUrl(), true);
        }
    }
}
