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
    private static volatile a gEe;
    private HashMap<String, String> gEf;
    private DownloadData gEg;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0131a {
        void byq();

        void cf(String str, String str2);

        void tf(String str);
    }

    private a() {
    }

    public static a byQ() {
        if (gEe == null) {
            synchronized (a.class) {
                if (gEe == null) {
                    gEe = new a();
                }
            }
        }
        return gEe;
    }

    public String tj(String str) {
        String dV = ao.dV(str);
        if (dV == null) {
            return null;
        }
        if (this.gEf == null) {
            this.gEf = new HashMap<>();
            byR();
            if (this.gEf.size() > 0) {
                return this.gEf.get(dV);
            }
            return null;
        }
        return this.gEf.get(dV);
    }

    public void byR() {
        if (this.gEf == null) {
            this.gEf = new HashMap<>();
        } else {
            this.gEf.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gCr);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gEf.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0131a interfaceC0131a) {
        String dV;
        if (!TextUtils.isEmpty(str2) && (dV = ao.dV(str2)) != null) {
            if (this.gEg != null) {
                e.CA().o(this.gEg.getUrl(), true);
            }
            File file = new File(com.baidu.tieba.video.b.gCr);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gCr + dV + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gEg != null && downloadData2.getUrl().equals(a.this.gEg.getUrl())) {
                            a.this.gEg = null;
                        }
                        if (interfaceC0131a != null) {
                            interfaceC0131a.byq();
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
                        if (a.this.gEg != null && downloadData2.getUrl().equals(a.this.gEg.getUrl())) {
                            a.this.gEg = null;
                        }
                        if (interfaceC0131a != null) {
                            a.this.gEf.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gCr.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0131a.cf(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gEg != null && downloadData2.getUrl().equals(a.this.gEg.getUrl())) {
                        a.this.gEg = null;
                    }
                    if (interfaceC0131a != null) {
                        interfaceC0131a.tf(str3);
                    }
                }
            });
            this.gEg = downloadData;
            e.CA().f(downloadData);
        }
    }

    public void byS() {
        if (this.gEg != null) {
            e.CA().o(this.gEg.getUrl(), true);
        }
    }
}
