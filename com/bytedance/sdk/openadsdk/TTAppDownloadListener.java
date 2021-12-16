package com.bytedance.sdk.openadsdk;
/* loaded from: classes2.dex */
public interface TTAppDownloadListener {
    void onDownloadActive(long j2, long j3, String str, String str2);

    void onDownloadFailed(long j2, long j3, String str, String str2);

    void onDownloadFinished(long j2, String str, String str2);

    void onDownloadPaused(long j2, long j3, String str, String str2);

    void onIdle();

    void onInstalled(String str, String str2);
}
