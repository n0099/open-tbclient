package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public interface TTAppDownloadListener {
    void onDownloadActive(long j, long j2, String str, String str2);

    void onDownloadFailed(long j, long j2, String str, String str2);

    void onDownloadFinished(long j, String str, String str2);

    void onDownloadPaused(long j, long j2, String str, String str2);

    void onIdle();

    void onInstalled(String str, String str2);
}
