package com.baidu.webkit.sdk;
/* loaded from: classes4.dex */
public interface IPMSDownloadListener {
    void onDownloadError(String str);

    void onDownloadSuccess(String str, String str2);

    void onPackageCached(String str);

    boolean packageNeedUpdate(String str, String str2);
}
