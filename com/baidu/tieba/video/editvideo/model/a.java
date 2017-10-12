package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import com.baidu.tieba.video.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a gvs;
    private HashMap<String, String> gvt;
    private DownloadData gvu;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0131a {
        void bvv();

        void cj(String str, String str2);

        void sy(String str);
    }

    private a() {
    }

    public static a bvS() {
        if (gvs == null) {
            synchronized (a.class) {
                if (gvs == null) {
                    gvs = new a();
                }
            }
        }
        return gvs;
    }

    public String sB(String str) {
        String dQ = ao.dQ(str);
        if (dQ == null) {
            return null;
        }
        if (this.gvt == null) {
            this.gvt = new HashMap<>();
            bvT();
            if (this.gvt.size() > 0) {
                return this.gvt.get(dQ);
            }
            return null;
        }
        return this.gvt.get(dQ);
    }

    public void bvT() {
        if (this.gvt == null) {
            this.gvt = new HashMap<>();
        } else {
            this.gvt.clear();
        }
        File file = new File(b.gtT);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gvt.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0131a interfaceC0131a) {
        String dQ;
        if (!TextUtils.isEmpty(str2) && (dQ = ao.dQ(str2)) != null) {
            if (this.gvu != null) {
                e.Cr().q(this.gvu.getUrl(), true);
            }
            File file = new File(b.gtT);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(b.gtT + dQ + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gvu != null && downloadData2.getUrl().equals(a.this.gvu.getUrl())) {
                            a.this.gvu = null;
                        }
                        if (interfaceC0131a != null) {
                            interfaceC0131a.bvv();
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
                        if (a.this.gvu != null && downloadData2.getUrl().equals(a.this.gvu.getUrl())) {
                            a.this.gvu = null;
                        }
                        if (interfaceC0131a != null) {
                            a.this.gvt.put(downloadData2.getPath().substring(b.gtT.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0131a.cj(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gvu != null && downloadData2.getUrl().equals(a.this.gvu.getUrl())) {
                        a.this.gvu = null;
                    }
                    if (interfaceC0131a != null) {
                        interfaceC0131a.sy(str3);
                    }
                }
            });
            this.gvu = downloadData;
            e.Cr().f(downloadData);
        }
    }

    public void bvU() {
        if (this.gvu != null) {
            e.Cr().q(this.gvu.getUrl(), true);
        }
    }
}
