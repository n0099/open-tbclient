package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a hqr;
    private HashMap<String, String> hqs;
    private DownloadData hqt;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0241a {
        void bAS();

        void cj(String str, String str2);

        void tE(String str);
    }

    private a() {
    }

    public static a bBE() {
        if (hqr == null) {
            synchronized (a.class) {
                if (hqr == null) {
                    hqr = new a();
                }
            }
        }
        return hqr;
    }

    public String tN(String str) {
        String eu = ap.eu(str);
        if (eu == null) {
            return null;
        }
        if (this.hqs == null) {
            this.hqs = new HashMap<>();
            bBF();
            if (this.hqs.size() > 0) {
                return this.hqs.get(eu);
            }
            return null;
        }
        return this.hqs.get(eu);
    }

    public void bBF() {
        if (this.hqs == null) {
            this.hqs = new HashMap<>();
        } else {
            this.hqs.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hnO);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hqs.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0241a interfaceC0241a) {
        String eu;
        if (!TextUtils.isEmpty(str2) && (eu = ap.eu(str2)) != null) {
            if (this.hqt != null) {
                if (!str2.equals(this.hqt.getUrl())) {
                    e.KU().o(this.hqt.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.hnO);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hnO + eu + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hqt != null && downloadData2.getUrl().equals(a.this.hqt.getUrl())) {
                            a.this.hqt = null;
                        }
                        if (interfaceC0241a != null) {
                            interfaceC0241a.bAS();
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
                        if (a.this.hqt != null && downloadData2.getUrl().equals(a.this.hqt.getUrl())) {
                            a.this.hqt = null;
                        }
                        if (interfaceC0241a != null) {
                            a.this.hqs.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hnO.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
                            interfaceC0241a.cj(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hqt != null && downloadData2.getUrl().equals(a.this.hqt.getUrl())) {
                        a.this.hqt = null;
                    }
                    if (interfaceC0241a != null) {
                        interfaceC0241a.tE(str3);
                    }
                }
            });
            this.hqt = downloadData;
            e.KU().f(downloadData);
        }
    }

    public void bBG() {
        if (this.hqt != null) {
            e.KU().o(this.hqt.getUrl(), true);
        }
    }
}
