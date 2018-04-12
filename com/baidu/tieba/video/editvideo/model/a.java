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
    private static volatile a gMm;
    private HashMap<String, String> gMn;
    private DownloadData gMo;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0223a {
        void bwb();

        void ci(String str, String str2);

        void tL(String str);
    }

    private a() {
    }

    public static a bwN() {
        if (gMm == null) {
            synchronized (a.class) {
                if (gMm == null) {
                    gMm = new a();
                }
            }
        }
        return gMm;
    }

    public String tU(String str) {
        String em = aq.em(str);
        if (em == null) {
            return null;
        }
        if (this.gMn == null) {
            this.gMn = new HashMap<>();
            bwO();
            if (this.gMn.size() > 0) {
                return this.gMn.get(em);
            }
            return null;
        }
        return this.gMn.get(em);
    }

    public void bwO() {
        if (this.gMn == null) {
            this.gMn = new HashMap<>();
        } else {
            this.gMn.clear();
        }
        File file = new File(com.baidu.tieba.video.b.gJH);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.gMn.put(file2.getName().substring(0, file2.getName().lastIndexOf(Constants.DOT)), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0223a interfaceC0223a) {
        String em;
        if (!TextUtils.isEmpty(str2) && (em = aq.em(str2)) != null) {
            if (this.gMo != null) {
                if (!str2.equals(this.gMo.getUrl())) {
                    e.Dy().l(this.gMo.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.gJH);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.gJH + em + (Constants.DOT + str2.substring(str2.lastIndexOf(Constants.DOT) + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.gMo != null && downloadData2.getUrl().equals(a.this.gMo.getUrl())) {
                            a.this.gMo = null;
                        }
                        if (interfaceC0223a != null) {
                            interfaceC0223a.bwb();
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
                        if (a.this.gMo != null && downloadData2.getUrl().equals(a.this.gMo.getUrl())) {
                            a.this.gMo = null;
                        }
                        if (interfaceC0223a != null) {
                            a.this.gMn.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.gJH.length(), downloadData2.getPath().lastIndexOf(Constants.DOT)), downloadData2.getPath());
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
                    if (a.this.gMo != null && downloadData2.getUrl().equals(a.this.gMo.getUrl())) {
                        a.this.gMo = null;
                    }
                    if (interfaceC0223a != null) {
                        interfaceC0223a.tL(str3);
                    }
                }
            });
            this.gMo = downloadData;
            e.Dy().f(downloadData);
        }
    }

    public void bwP() {
        if (this.gMo != null) {
            e.Dy().l(this.gMo.getUrl(), true);
        }
    }
}
