package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes9.dex */
public final class CookieSyncManagerImpl extends CookieSyncManager {
    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void resetSync() {
        android.webkit.CookieSyncManager.getInstance().resetSync();
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void startSync() {
        android.webkit.CookieSyncManager.getInstance().startSync();
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void stopSync() {
        android.webkit.CookieSyncManager.getInstance().stopSync();
    }

    @Override // com.baidu.webkit.sdk.CookieSyncManager
    public final void sync() {
        android.webkit.CookieSyncManager.getInstance().sync();
    }
}
