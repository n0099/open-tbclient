package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    private static volatile a jpS;
    private HashMap<String, String> jpT;
    private DownloadData jpU;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0417a {
        void EQ(String str);

        void crc();

        void er(String str, String str2);
    }

    private a() {
    }

    public static a crM() {
        if (jpS == null) {
            synchronized (a.class) {
                if (jpS == null) {
                    jpS = new a();
                }
            }
        }
        return jpS;
    }

    public String EY(String str) {
        String nS = as.nS(str);
        if (nS == null) {
            return null;
        }
        if (this.jpT == null) {
            this.jpT = new HashMap<>();
            crN();
            if (this.jpT.size() > 0) {
                return this.jpT.get(nS);
            }
            return null;
        }
        return this.jpT.get(nS);
    }

    public void crN() {
        if (this.jpT == null) {
            this.jpT = new HashMap<>();
        } else {
            this.jpT.clear();
        }
        File file = new File(c.jnq);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.jpT.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0417a interfaceC0417a) {
        String nS;
        if (!TextUtils.isEmpty(str2) && (nS = as.nS(str2)) != null) {
            if (this.jpU != null) {
                if (!str2.equals(this.jpU.getUrl())) {
                    d.aqM().Q(this.jpU.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.jnq);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.jnq + nS + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.jpU != null && downloadData2.getUrl().equals(a.this.jpU.getUrl())) {
                            a.this.jpU = null;
                        }
                        if (interfaceC0417a != null) {
                            interfaceC0417a.crc();
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
                        if (a.this.jpU != null && downloadData2.getUrl().equals(a.this.jpU.getUrl())) {
                            a.this.jpU = null;
                        }
                        if (interfaceC0417a != null) {
                            a.this.jpT.put(downloadData2.getPath().substring(c.jnq.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0417a.er(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.jpU != null && downloadData2.getUrl().equals(a.this.jpU.getUrl())) {
                        a.this.jpU = null;
                    }
                    if (interfaceC0417a != null) {
                        interfaceC0417a.EQ(str3);
                    }
                }
            });
            this.jpU = downloadData;
            d.aqM().f(downloadData);
        }
    }

    public void crO() {
        if (this.jpU != null) {
            d.aqM().Q(this.jpU.getUrl(), true);
        }
    }
}
