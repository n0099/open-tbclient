package com.baidu.zeus;

import android.content.Context;
import com.baidu.zeus.CookieManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class CookieSyncManager extends WebSyncManager {
    private static CookieSyncManager sRef;
    private long mLastUpdate;

    @Override // com.baidu.zeus.WebSyncManager
    public /* bridge */ /* synthetic */ void resetSync() {
        super.resetSync();
    }

    @Override // com.baidu.zeus.WebSyncManager, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // com.baidu.zeus.WebSyncManager
    public /* bridge */ /* synthetic */ void startSync() {
        super.startSync();
    }

    @Override // com.baidu.zeus.WebSyncManager
    public /* bridge */ /* synthetic */ void stopSync() {
        super.stopSync();
    }

    @Override // com.baidu.zeus.WebSyncManager
    public /* bridge */ /* synthetic */ void sync() {
        super.sync();
    }

    private CookieSyncManager(Context context) {
        super(context, "CookieSyncManager");
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (sRef == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = sRef;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (sRef == null) {
                sRef = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = sRef;
        }
        return cookieSyncManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList getCookiesForDomain(String str) {
        return this.mDataBase == null ? new ArrayList() : this.mDataBase.getCookiesForDomain(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAllCookies() {
        if (this.mDataBase != null) {
            this.mDataBase.clearCookies();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCookies() {
        if (this.mDataBase == null) {
            return false;
        }
        return this.mDataBase.hasCookies();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearSessionCookies() {
        if (this.mDataBase != null) {
            this.mDataBase.clearSessionCookies();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearExpiredCookies(long j) {
        if (this.mDataBase != null) {
            this.mDataBase.clearExpiredCookies(j);
        }
    }

    @Override // com.baidu.zeus.WebSyncManager
    protected void syncFromRamToFlash() {
        if (CookieManager.getInstance().acceptCookie()) {
            if (JniUtil.useChromiumHttpStack()) {
                CookieManager.getInstance().flushCookieStore();
                return;
            }
            ArrayList updatedCookiesSince = CookieManager.getInstance().getUpdatedCookiesSince(this.mLastUpdate);
            this.mLastUpdate = System.currentTimeMillis();
            syncFromRamToFlash(updatedCookiesSince);
            syncFromRamToFlash(CookieManager.getInstance().deleteLRUDomain());
        }
    }

    private void syncFromRamToFlash(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CookieManager.Cookie cookie = (CookieManager.Cookie) it.next();
            if (cookie.mode != 1) {
                if (cookie.mode != 0) {
                    this.mDataBase.deleteCookies(cookie.domain, cookie.path, cookie.name);
                }
                if (cookie.mode != 2) {
                    this.mDataBase.addCookie(cookie);
                    CookieManager.getInstance().syncedACookie(cookie);
                } else {
                    CookieManager.getInstance().deleteACookie(cookie);
                }
            }
        }
    }
}
