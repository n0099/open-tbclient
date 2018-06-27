package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tbadk.download.e;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private static volatile a hcT;
    private HashMap<String, String> hcU;
    private DownloadData hcV;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0242a {
        void bBG();

        void cu(String str, String str2);

        void uE(String str);
    }

    private a() {
    }

    public static a bCs() {
        if (hcT == null) {
            synchronized (a.class) {
                if (hcT == null) {
                    hcT = new a();
                }
            }
        }
        return hcT;
    }

    public String uN(String str) {
        String eO = as.eO(str);
        if (eO == null) {
            return null;
        }
        if (this.hcU == null) {
            this.hcU = new HashMap<>();
            bCt();
            if (this.hcU.size() > 0) {
                return this.hcU.get(eO);
            }
            return null;
        }
        return this.hcU.get(eO);
    }

    public void bCt() {
        if (this.hcU == null) {
            this.hcU = new HashMap<>();
        } else {
            this.hcU.clear();
        }
        File file = new File(com.baidu.tieba.video.b.hao);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.hcU.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0242a interfaceC0242a) {
        String eO;
        if (!TextUtils.isEmpty(str2) && (eO = as.eO(str2)) != null) {
            if (this.hcV != null) {
                if (!str2.equals(this.hcV.getUrl())) {
                    e.Hr().l(this.hcV.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(com.baidu.tieba.video.b.hao);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(com.baidu.tieba.video.b.hao + eO + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new d() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.d
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.hcV != null && downloadData2.getUrl().equals(a.this.hcV.getUrl())) {
                            a.this.hcV = null;
                        }
                        if (interfaceC0242a != null) {
                            interfaceC0242a.bBG();
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
                        if (a.this.hcV != null && downloadData2.getUrl().equals(a.this.hcV.getUrl())) {
                            a.this.hcV = null;
                        }
                        if (interfaceC0242a != null) {
                            a.this.hcU.put(downloadData2.getPath().substring(com.baidu.tieba.video.b.hao.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0242a.cu(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.d
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.hcV != null && downloadData2.getUrl().equals(a.this.hcV.getUrl())) {
                        a.this.hcV = null;
                    }
                    if (interfaceC0242a != null) {
                        interfaceC0242a.uE(str3);
                    }
                }
            });
            this.hcV = downloadData;
            e.Hr().f(downloadData);
        }
    }

    public void bCu() {
        if (this.hcV != null) {
            e.Hr().l(this.hcV.getUrl(), true);
        }
    }
}
