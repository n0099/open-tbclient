package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public interface TTGlobalAppDownloadListener {
    void onDownloadActive(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadFailed(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadFinished(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadPaused(TTAppDownloadInfo tTAppDownloadInfo);

    void onInstalled(String str, String str2, long j, int i2);
}
