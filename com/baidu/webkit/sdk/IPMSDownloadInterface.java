package com.baidu.webkit.sdk;

import java.util.List;
/* loaded from: classes6.dex */
public interface IPMSDownloadInterface {
    void addPackage(String str);

    String getFileDir();

    IPMSDownloadListener getListener();

    List getPackages();

    boolean getRegistered();

    void onUnZipFailed(String str);

    void setFileDir(String str);

    void setListener(IPMSDownloadListener iPMSDownloadListener);

    void setRegistered(boolean z);
}
