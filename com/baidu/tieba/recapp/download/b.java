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
/* loaded from: classes11.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> jFL = new HashMap();
    private final com.baidu.tieba.ad.download.a.c jFM = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.jFL.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.Hz(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.cBh().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void wJ(String str) {
        DownloadCacheKey downloadCacheKey = this.jFL.get(str);
        if (downloadCacheKey != null) {
            i.cBh().z(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void wK(String str) {
        DownloadCacheKey downloadCacheKey = this.jFL.get(str);
        if (downloadCacheKey != null) {
            this.jFL.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.Hz(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.cBh().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c aWc() {
        return this.jFM;
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void wI(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aVT().c((DownloadCacheKey) b.this.jFL.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.wI(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void al(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aVT().c((DownloadCacheKey) b.this.jFL.get(str));
            if (c != null) {
                c.al(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aVT().c((DownloadCacheKey) b.this.jFL.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.jFL.get(str);
            String aJ = com.baidu.tieba.ad.download.a.aJ(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.jFL.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = aJ;
            com.baidu.tieba.ad.download.d.aVT().d(downloadCacheKey).setupPkgName(aJ);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aVT().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aJ)) {
                    c.aWa();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void am(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aVT().c((DownloadCacheKey) b.this.jFL.get(str));
            if (c != null) {
                c.am(str, i);
            }
        }
    }
}
