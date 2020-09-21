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
/* loaded from: classes25.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> lMc = new HashMap();
    private final com.baidu.tieba.ad.download.a.c lMd = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.lMc.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.PQ(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.drg().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void DW(String str) {
        DownloadCacheKey downloadCacheKey = this.lMc.get(str);
        if (downloadCacheKey != null) {
            i.drg().B(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void DX(String str) {
        DownloadCacheKey downloadCacheKey = this.lMc.get(str);
        if (downloadCacheKey != null) {
            this.lMc.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.PQ(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.drg().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c bCB() {
        return this.lMd;
    }

    /* loaded from: classes25.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void DV(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bCs().c((DownloadCacheKey) b.this.lMc.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.DV(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void av(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bCs().c((DownloadCacheKey) b.this.lMc.get(str));
            if (c != null) {
                c.av(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bCs().c((DownloadCacheKey) b.this.lMc.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.lMc.get(str);
            String ay = com.baidu.tieba.ad.download.a.ay(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.lMc.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = ay;
            com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey).setupPkgName(ay);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bCs().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), ay)) {
                    c.bCz();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void aw(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bCs().c((DownloadCacheKey) b.this.lMc.get(str));
            if (c != null) {
                c.aw(str, i);
            }
        }
    }
}
