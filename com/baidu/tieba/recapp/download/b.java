package com.baidu.tieba.recapp.download;

import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.ad.download.b.a {
    private static final String TAG = b.class.getSimpleName();
    private final Map<String, DownloadCacheKey> mSx = new HashMap();
    private final com.baidu.tieba.ad.download.a.c mSy = new a();

    @Override // com.baidu.tieba.ad.download.b.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.mSx.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.RD(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.dDF().a(downloadData);
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void EM(String str) {
        DownloadCacheKey downloadCacheKey = this.mSx.get(str);
        if (downloadCacheKey != null) {
            i.dDF().F(downloadCacheKey.mDownloadUrl, str, true);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public void EN(String str) {
        DownloadCacheKey downloadCacheKey = this.mSx.get(str);
        if (downloadCacheKey != null) {
            this.mSx.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.RD(downloadData.getName()).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.dDF().a(downloadData);
        }
    }

    @Override // com.baidu.tieba.ad.download.b.a
    public com.baidu.tieba.ad.download.a.c bLH() {
        return this.mSy;
    }

    /* loaded from: classes8.dex */
    private class a implements com.baidu.tieba.ad.download.a.c {
        private a() {
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void EL(String str) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bLy().c((DownloadCacheKey) b.this.mSx.get(str));
            if (c != null) {
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                c.EL(str);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void aC(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bLy().c((DownloadCacheKey) b.this.mSx.get(str));
            if (c != null) {
                c.aC(str, i);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void a(String str, StopStatus stopStatus) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bLy().c((DownloadCacheKey) b.this.mSx.get(str));
            if (c != null) {
                c.a(str, stopStatus);
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.mSx.get(str);
            String aJ = com.baidu.tieba.ad.download.a.aJ(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.mSx.put(str, downloadCacheKey);
            }
            if (!TextUtils.isEmpty(aJ)) {
                downloadCacheKey.mPackageName = aJ;
            }
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
            if (!TextUtils.isEmpty(aJ)) {
                d.setupPkgName(aJ);
            }
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bLy().c(downloadCacheKey);
            if (c != null) {
                if (com.baidu.tieba.ad.download.a.isAppInstalled(TbadkCoreApplication.getInst(), aJ)) {
                    c.bLF();
                } else {
                    c.onSuccess(str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ad.download.a.c
        public void aD(String str, int i) {
            com.baidu.tieba.ad.download.a.a c = com.baidu.tieba.ad.download.d.bLy().c((DownloadCacheKey) b.this.mSx.get(str));
            if (c != null) {
                c.aD(str, i);
            }
        }
    }
}
