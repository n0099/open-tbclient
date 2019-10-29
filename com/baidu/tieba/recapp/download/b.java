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
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> iII = new HashMap();
    private final com.baidu.tieba.ad.download.a.c iIJ = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.iII.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.CB(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.cfY().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void rw(String str) {
        DownloadCacheKey downloadCacheKey = this.iII.get(str);
        if (downloadCacheKey != null) {
            i.cfY().z(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void rx(String str) {
        DownloadCacheKey downloadCacheKey = this.iII.get(str);
        if (downloadCacheKey != null) {
            this.iII.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.CB(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.cfY().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c aDR() {
        return this.iIJ;
    }

    /* loaded from: classes3.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void rv(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aDI().c((DownloadCacheKey) b.this.iII.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.rv(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void Y(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aDI().c((DownloadCacheKey) b.this.iII.get(str));
            if (c != null) {
                c.Y(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aDI().c((DownloadCacheKey) b.this.iII.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.iII.get(str);
            String aq = com.baidu.tieba.ad.download.a.aq(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.iII.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = aq;
            com.baidu.tieba.ad.download.d.aDI().d(downloadCacheKey).setupPkgName(aq);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aDI().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aq)) {
                    c.aDP();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void Z(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.aDI().c((DownloadCacheKey) b.this.iII.get(str));
            if (c != null) {
                c.Z(str, i);
            }
        }
    }
}
