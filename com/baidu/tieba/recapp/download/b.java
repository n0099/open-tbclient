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
/* loaded from: classes20.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> lmw = new HashMap();
    private final com.baidu.tieba.ad.download.a.c lmx = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.lmw.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.Mr(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.dcm().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Be(String str) {
        DownloadCacheKey downloadCacheKey = this.lmw.get(str);
        if (downloadCacheKey != null) {
            i.dcm().C(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Bf(String str) {
        DownloadCacheKey downloadCacheKey = this.lmw.get(str);
        if (downloadCacheKey != null) {
            this.lmw.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.Mr(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.dcm().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c bsr() {
        return this.lmx;
    }

    /* loaded from: classes20.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void Bd(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bsi().c((DownloadCacheKey) b.this.lmw.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.Bd(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void as(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bsi().c((DownloadCacheKey) b.this.lmw.get(str));
            if (c != null) {
                c.as(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bsi().c((DownloadCacheKey) b.this.lmw.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.lmw.get(str);
            String ar = com.baidu.tieba.ad.download.a.ar(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.lmw.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = ar;
            com.baidu.tieba.ad.download.d.bsi().d(downloadCacheKey).setupPkgName(ar);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bsi().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), ar)) {
                    c.bsp();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void at(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bsi().c((DownloadCacheKey) b.this.lmw.get(str));
            if (c != null) {
                c.at(str, i);
            }
        }
    }
}
