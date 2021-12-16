package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes2.dex */
public interface ITTDownloadAdapter {

    /* loaded from: classes2.dex */
    public interface OnEventLogHandler {
        boolean onEventLog(int i2, String str, String str2, String str3, Object obj);
    }

    void addAppDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void addAppDownloadListener(TTAppDownloadListener tTAppDownloadListener, boolean z);

    void addOnEventLogHandler(int i2, OnEventLogHandler onEventLogHandler);

    boolean canOpenByDeepLink();

    boolean canOpenByDownload();

    boolean canOpenByMarketUrl(boolean z);

    boolean canOpenByPackage();

    boolean canOpenByQuickApp(boolean z);

    void cancelDownload();

    void cancelDownload(long j2);

    void changeDownloadStatus();

    long getDownloadId();

    boolean getShouldSendClick();

    void handleAdClick();

    void init();

    boolean isInterceptQuickApp();

    boolean isJsDownloader();

    void onDestroy();

    void onPause();

    void onResume();

    void removeAppDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void resetEventTag(String str);

    void setActivity(Activity activity);

    void setCheckCompliance(int i2);

    void setDirectDownload();

    void setDownloadId(long j2);

    void setView(View view);
}
