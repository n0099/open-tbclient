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
    private static volatile a gve;
    private HashMap<String, String> gvf;
    private DownloadData gvg;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0131a {
        void bvn();

        void ci(String str, String str2);

        void sx(String str);
    }

    private a() {
    }

    public static a bvK() {
        if (gve == null) {
            synchronized (a.class) {
                if (gve == null) {
                    gve = new a();
                }
            }
        }
        return gve;
    }

    public String sA(String str) {
        String dP = ao.dP(str);
        if (dP == null) {
            return null;
        }
        if (this.gvf == null) {
            this.gvf = new HashMap<>();
            bvL();
            if (this.gvf.size() > 0) {
                return this.gvf.get(dP);
            }
            return null;
        }
        return this.gvf.get(dP);
    }

    public void bvL() {
        if (this.gvf == null) {
            this.gvf = new HashMap<>();
        } else {
            this.gvf.clear();
        }
        File file = new File(b.gtF);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gvf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0131a interfaceC0131a) {
        String dP;
        if (!TextUtils.isEmpty(str2) && (dP = ao.dP(str2)) != null) {
            if (this.gvg != null) {
                e.Cl().q(this.gvg.getUrl(), true);
            }
            File file = new File(b.gtF);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(b.gtF + dP + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gvg != null && downloadData2.getUrl().equals(a.this.gvg.getUrl())) {
                            a.this.gvg = null;
                        }
                        if (interfaceC0131a != null) {
                            interfaceC0131a.bvn();
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
                        if (a.this.gvg != null && downloadData2.getUrl().equals(a.this.gvg.getUrl())) {
                            a.this.gvg = null;
                        }
                        if (interfaceC0131a != null) {
                            a.this.gvf.put(downloadData2.getPath().substring(b.gtF.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0131a.ci(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gvg != null && downloadData2.getUrl().equals(a.this.gvg.getUrl())) {
                        a.this.gvg = null;
                    }
                    if (interfaceC0131a != null) {
                        interfaceC0131a.sx(str3);
                    }
                }
            });
            this.gvg = downloadData;
            e.Cl().f(downloadData);
        }
    }

    public void bvM() {
        if (this.gvg != null) {
            e.Cl().q(this.gvg.getUrl(), true);
        }
    }
}
