package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class a {
    private static volatile a npr;
    private HashMap<String, String> nps;
    private DownloadData npt;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0863a {
        void Tr(String str);

        void dOC();

        void gw(String str, String str2);
    }

    private a() {
    }

    public static a dPi() {
        if (npr == null) {
            synchronized (a.class) {
                if (npr == null) {
                    npr = new a();
                }
            }
        }
        return npr;
    }

    public String Tx(String str) {
        String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.nps == null) {
            this.nps = new HashMap<>();
            dPj();
            if (this.nps.size() > 0) {
                return this.nps.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.nps.get(nameMd5FromUrl);
    }

    public void dPj() {
        if (this.nps == null) {
            this.nps = new HashMap<>();
        } else {
            this.nps.clear();
        }
        File file = new File(c.nmS);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.nps.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0863a interfaceC0863a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = aw.getNameMd5FromUrl(str2)) != null) {
            if (this.npt != null) {
                if (!str2.equals(this.npt.getUrl())) {
                    d.byJ().cancelDownLoadByUrl(this.npt.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.nmS);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.nmS + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.npt != null && downloadData2.getUrl().equals(a.this.npt.getUrl())) {
                            a.this.npt = null;
                        }
                        if (interfaceC0863a != null) {
                            interfaceC0863a.dOC();
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                        if (a.this.npt != null && downloadData2.getUrl().equals(a.this.npt.getUrl())) {
                            a.this.npt = null;
                        }
                        if (interfaceC0863a != null) {
                            a.this.nps.put(downloadData2.getPath().substring(c.nmS.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0863a.gw(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.npt != null && downloadData2.getUrl().equals(a.this.npt.getUrl())) {
                        a.this.npt = null;
                    }
                    if (interfaceC0863a != null) {
                        interfaceC0863a.Tr(str3);
                    }
                }
            });
            this.npt = downloadData;
            d.byJ().f(downloadData);
        }
    }

    public void dPk() {
        if (this.npt != null) {
            d.byJ().cancelDownLoadByUrl(this.npt.getUrl(), true);
        }
    }
}
