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
    private static volatile a hoI;
    private HashMap<String, String> hoJ;
    private DownloadData hoK;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0159a {
        void bAg();

        void ci(String str, String str2);

        void ts(String str);
    }

    private a() {
    }

    public static a bAT() {
        if (hoI == null) {
            synchronized (a.class) {
                if (hoI == null) {
                    hoI = new a();
                }
            }
        }
        return hoI;
    }

    public String tB(String str) {
        String ee = ao.ee(str);
        if (ee == null) {
            return null;
        }
        if (this.hoJ == null) {
            this.hoJ = new HashMap<>();
            bAU();
            if (this.hoJ.size() > 0) {
                return this.hoJ.get(ee);
            }
            return null;
        }
        return this.hoJ.get(ee);
    }

    public void bAU() {
        if (this.hoJ == null) {
            this.hoJ = new HashMap<>();
        } else {
            this.hoJ.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hmf);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hoJ.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0159a interfaceC0159a) {
        String ee;
        if (!TextUtils.isEmpty(str2) && (ee = ao.ee(str2)) != null) {
            if (this.hoK != null) {
                if (!str2.equals(this.hoK.getUrl())) {
                    e.Km().o(this.hoK.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.hmf);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hmf + ee + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hoK != null && downloadData2.getUrl().equals(a.this.hoK.getUrl())) {
                            a.this.hoK = null;
                        }
                        if (interfaceC0159a != null) {
                            interfaceC0159a.bAg();
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
                        if (a.this.hoK != null && downloadData2.getUrl().equals(a.this.hoK.getUrl())) {
                            a.this.hoK = null;
                        }
                        if (interfaceC0159a != null) {
                            a.this.hoJ.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hmf.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0159a.ci(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hoK != null && downloadData2.getUrl().equals(a.this.hoK.getUrl())) {
                        a.this.hoK = null;
                    }
                    if (interfaceC0159a != null) {
                        interfaceC0159a.ts(str3);
                    }
                }
            });
            this.hoK = downloadData;
            e.Km().f(downloadData);
        }
    }

    public void bAV() {
        if (this.hoK != null) {
            e.Km().o(this.hoK.getUrl(), true);
        }
    }
}
