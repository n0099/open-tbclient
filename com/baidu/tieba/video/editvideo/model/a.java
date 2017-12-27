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
    private static volatile a hzf;
    private HashMap<String, String> hzg;
    private DownloadData hzh;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0160a {
        void bGJ();

        void co(String str, String str2);

        void tX(String str);
    }

    private a() {
    }

    public static a bHw() {
        if (hzf == null) {
            synchronized (a.class) {
                if (hzf == null) {
                    hzf = new a();
                }
            }
        }
        return hzf;
    }

    public String ug(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hzg == null) {
            this.hzg = new HashMap<>();
            bHx();
            if (this.hzg.size() > 0) {
                return this.hzg.get(ee);
            }
            return null;
        }
        return this.hzg.get(ee);
    }

    public void bHx() {
        if (this.hzg == null) {
            this.hzg = new HashMap<>();
        } else {
            this.hzg.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hwC);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hzg.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0160a interfaceC0160a) {
        String ee;
        if (!TextUtils.isEmpty(str2) && (ee = ao.ee(str2)) != null) {
            if (this.hzh != null) {
                if (!str2.equals(this.hzh.getUrl())) {
                    e.Kx().o(this.hzh.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.hwC);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hwC + ee + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hzh != null && downloadData2.getUrl().equals(a.this.hzh.getUrl())) {
                            a.this.hzh = null;
                        }
                        if (interfaceC0160a != null) {
                            interfaceC0160a.bGJ();
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
                        if (a.this.hzh != null && downloadData2.getUrl().equals(a.this.hzh.getUrl())) {
                            a.this.hzh = null;
                        }
                        if (interfaceC0160a != null) {
                            a.this.hzg.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hwC.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0160a.co(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hzh != null && downloadData2.getUrl().equals(a.this.hzh.getUrl())) {
                        a.this.hzh = null;
                    }
                    if (interfaceC0160a != null) {
                        interfaceC0160a.tX(str3);
                    }
                }
            });
            this.hzh = downloadData;
            e.Kx().f(downloadData);
        }
    }

    public void bHy() {
        if (this.hzh != null) {
            e.Kx().o(this.hzh.getUrl(), true);
        }
    }
}
