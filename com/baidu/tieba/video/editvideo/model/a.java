package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a gYO;
    private HashMap<String, String> gYP;
    private DownloadData gYQ;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0240a {
        void bBg();

        void cq(String str, String str2);

        void uI(String str);
    }

    private a() {
    }

    public static a bBS() {
        if (gYO == null) {
            synchronized (a.class) {
                if (gYO == null) {
                    gYO = new a();
                }
            }
        }
        return gYO;
    }

    public String uR(String str) {
        String eL = ar.eL(str);
        if (eL == null) {
            return null;
        }
        if (this.gYP == null) {
            this.gYP = new HashMap<>();
            bBT();
            if (this.gYP.size() > 0) {
                return this.gYP.get(eL);
            }
            return null;
        }
        return this.gYP.get(eL);
    }

    public void bBT() {
        if (this.gYP == null) {
            this.gYP = new HashMap<>();
        } else {
            this.gYP.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gWj);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gYP.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0240a interfaceC0240a) {
        String eL;
        if (!TextUtils.isEmpty(str2) && (eL = ar.eL(str2)) != null) {
            if (this.gYQ != null) {
                if (!str2.equals(this.gYQ.getUrl())) {
                    e.GZ().l(this.gYQ.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.gWj);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gWj + eL + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gYQ != null && downloadData2.getUrl().equals(a.this.gYQ.getUrl())) {
                            a.this.gYQ = null;
                        }
                        if (interfaceC0240a != null) {
                            interfaceC0240a.bBg();
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
                        if (a.this.gYQ != null && downloadData2.getUrl().equals(a.this.gYQ.getUrl())) {
                            a.this.gYQ = null;
                        }
                        if (interfaceC0240a != null) {
                            a.this.gYP.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gWj.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0240a.cq(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gYQ != null && downloadData2.getUrl().equals(a.this.gYQ.getUrl())) {
                        a.this.gYQ = null;
                    }
                    if (interfaceC0240a != null) {
                        interfaceC0240a.uI(str3);
                    }
                }
            });
            this.gYQ = downloadData;
            e.GZ().f(downloadData);
        }
    }

    public void bBU() {
        if (this.gYQ != null) {
            e.GZ().l(this.gYQ.getUrl(), true);
        }
    }
}
