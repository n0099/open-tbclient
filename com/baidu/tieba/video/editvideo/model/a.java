package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a gNm;
    private HashMap<String, String> gNn;
    private DownloadData gNo;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0223a {
        void bvZ();

        void ci(String str, String str2);

        void tO(String str);
    }

    private a() {
    }

    public static a bwL() {
        if (gNm == null) {
            synchronized (a.class) {
                if (gNm == null) {
                    gNm = new a();
                }
            }
        }
        return gNm;
    }

    public String tX(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gNn == null) {
            this.gNn = new HashMap<>();
            bwM();
            if (this.gNn.size() > 0) {
                return this.gNn.get(em);
            }
            return null;
        }
        return this.gNn.get(em);
    }

    public void bwM() {
        if (this.gNn == null) {
            this.gNn = new HashMap<>();
        } else {
            this.gNn.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gKH);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gNn.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0223a interfaceC0223a) {
        String em;
        if (!TextUtils.isEmpty(str2) && (em = aq.em(str2)) != null) {
            if (this.gNo != null) {
                if (!str2.equals(this.gNo.getUrl())) {
                    e.Dw().l(this.gNo.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.gKH);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gKH + em + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gNo != null && downloadData2.getUrl().equals(a.this.gNo.getUrl())) {
                            a.this.gNo = null;
                        }
                        if (interfaceC0223a != null) {
                            interfaceC0223a.bvZ();
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
                        if (a.this.gNo != null && downloadData2.getUrl().equals(a.this.gNo.getUrl())) {
                            a.this.gNo = null;
                        }
                        if (interfaceC0223a != null) {
                            a.this.gNn.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gKH.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
                            interfaceC0223a.ci(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.gNo != null && downloadData2.getUrl().equals(a.this.gNo.getUrl())) {
                        a.this.gNo = null;
                    }
                    if (interfaceC0223a != null) {
                        interfaceC0223a.tO(str3);
                    }
                }
            });
            this.gNo = downloadData;
            e.Dw().f(downloadData);
        }
    }

    public void bwN() {
        if (this.gNo != null) {
            e.Dw().l(this.gNo.getUrl(), true);
        }
    }
}
