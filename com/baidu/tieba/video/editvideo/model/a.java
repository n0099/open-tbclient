package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.d;
import com.baidu.tieba.video.c;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class a {
    private static volatile a mVM;
    private HashMap<String, String> mVN;
    private DownloadData mVO;

    /* renamed from: com.baidu.tieba.video.editvideo.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0830a {
        void SQ(String str);

        void dIT();

        void gr(String str, String str2);
    }

    private a() {
    }

    public static a dJz() {
        if (mVM == null) {
            synchronized (a.class) {
                if (mVM == null) {
                    mVM = new a();
                }
            }
        }
        return mVM;
    }

    public String SW(String str) {
        String nameMd5FromUrl = av.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.mVN == null) {
            this.mVN = new HashMap<>();
            dJA();
            if (this.mVN.size() > 0) {
                return this.mVN.get(nameMd5FromUrl);
            }
            return null;
        }
        return this.mVN.get(nameMd5FromUrl);
    }

    public void dJA() {
        if (this.mVN == null) {
            this.mVN = new HashMap<>();
        } else {
            this.mVN.clear();
        }
        File file = new File(c.mTn);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    this.mVN.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, final String str2, final InterfaceC0830a interfaceC0830a) {
        String nameMd5FromUrl;
        if (!TextUtils.isEmpty(str2) && (nameMd5FromUrl = av.getNameMd5FromUrl(str2)) != null) {
            if (this.mVO != null) {
                if (!str2.equals(this.mVO.getUrl())) {
                    d.bvb().cancelDownLoadByUrl(this.mVO.getUrl(), true);
                } else {
                    return;
                }
            }
            File file = new File(c.mTn);
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(17);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setPath(c.mTn + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.video.editvideo.model.a.1
                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2.getStatus() == 4) {
                        File file2 = new File(downloadData2.getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (a.this.mVO != null && downloadData2.getUrl().equals(a.this.mVO.getUrl())) {
                            a.this.mVO = null;
                        }
                        if (interfaceC0830a != null) {
                            interfaceC0830a.dIT();
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
                        if (a.this.mVO != null && downloadData2.getUrl().equals(a.this.mVO.getUrl())) {
                            a.this.mVO = null;
                        }
                        if (interfaceC0830a != null) {
                            a.this.mVN.put(downloadData2.getPath().substring(c.mTn.length(), downloadData2.getPath().lastIndexOf(".")), downloadData2.getPath());
                            interfaceC0830a.gr(str2, downloadData2.getPath());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str3) {
                    File file2 = new File(downloadData2.getPath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a.this.mVO != null && downloadData2.getUrl().equals(a.this.mVO.getUrl())) {
                        a.this.mVO = null;
                    }
                    if (interfaceC0830a != null) {
                        interfaceC0830a.SQ(str3);
                    }
                }
            });
            this.mVO = downloadData;
            d.bvb().f(downloadData);
        }
    }

    public void dJB() {
        if (this.mVO != null) {
            d.bvb().cancelDownLoadByUrl(this.mVO.getUrl(), true);
        }
    }
}
