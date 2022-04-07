package com.bytedance.sdk.openadsdk.api.plugin;

import com.bytedance.pangle.download.PluginDownloadBean;
import java.io.File;
/* loaded from: classes4.dex */
public final class d extends PluginDownloadBean {
    public String a = "";
    public File b = null;

    public d() {
        this.mOrder = 0;
        this.isOffline = false;
        this.isWifiOnly = true;
        this.mDownloadType = 1;
        this.mBackupUrlList = null;
    }
}
