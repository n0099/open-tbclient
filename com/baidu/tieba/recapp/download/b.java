package com.baidu.tieba.recapp.download;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> mIX = new HashMap();
    private final com.baidu.tieba.ad.download.a.c mIY = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.mIX.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.Qv(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.dBq().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Ep(String str) {
        DownloadCacheKey downloadCacheKey = this.mIX.get(str);
        if (downloadCacheKey != null) {
            i.dBq().F(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void Eq(String str) {
        DownloadCacheKey downloadCacheKey = this.mIX.get(str);
        if (downloadCacheKey != null) {
            this.mIX.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.Qv(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.dBq().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c bLi() {
        return this.mIY;
    }

    /* loaded from: classes7.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void Eo(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bKZ().c((DownloadCacheKey) b.this.mIX.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.Eo(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void aA(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bKZ().c((DownloadCacheKey) b.this.mIX.get(str));
            if (c != null) {
                c.aA(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bKZ().c((DownloadCacheKey) b.this.mIX.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.mIX.get(str);
            String aK = com.baidu.tieba.ad.download.a.aK(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.mIX.put(str, downloadCacheKey);
            }
            downloadCacheKey.mPackageName = aK;
            com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey).setupPkgName(aK);
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bKZ().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aK)) {
                    c.bLg();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void aB(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bKZ().c((DownloadCacheKey) b.this.mIX.get(str));
            if (c != null) {
                c.aB(str, i);
            }
        }
    }
}
