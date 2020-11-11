package com.baidu.tieba.recapp.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes26.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> mtP = new HashMap();
    private final com.baidu.tieba.ad.download.a.c mtQ = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.mtP.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.Ru(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.dAA().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Fo(String str) {
        DownloadCacheKey downloadCacheKey = this.mtP.get(str);
        if (downloadCacheKey != null) {
            i.dAA().C(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Fp(String str) {
        DownloadCacheKey downloadCacheKey = this.mtP.get(str);
        if (downloadCacheKey != null) {
            this.mtP.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.Ru(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.dAA().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c bJF() {
        return this.mtQ;
    }

    /* loaded from: classes26.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void Fn(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bJw().c((DownloadCacheKey) b.this.mtP.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.Fn(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void ay(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bJw().c((DownloadCacheKey) b.this.mtP.get(str));
            if (c != null) {
                c.ay(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bJw().c((DownloadCacheKey) b.this.mtP.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.mtP.get(str);
            String aC = com.baidu.tieba.ad.download.a.aC(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.mtP.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = aC;
            com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey).setupPkgName(aC);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bJw().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aC)) {
                    c.bJD();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void az(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bJw().c((DownloadCacheKey) b.this.mtP.get(str));
            if (c != null) {
                c.az(str, i);
            }
        }
    }
}
