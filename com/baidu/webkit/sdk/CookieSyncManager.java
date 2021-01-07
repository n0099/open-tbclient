package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
@Deprecated
/* loaded from: classes15.dex */
public class CookieSyncManager implements Runnable {
    private static boolean sGetInstanceAllowed;
    private static String TAG = "CookieSyncManager";
    private static final CookieSyncManager mInstance = new CookieSyncManager();
    private static final Object sLockObject = new Object();

    private static void checkInstanceIsAllowed() {
        if (!sGetInstanceAllowed) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
    }

    public static CookieSyncManager createInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Log.e(TAG, "CookieSyncManager.createInstance() must be called on the main thread.");
        }
        synchronized (sLockObject) {
            setGetInstanceIsAllowed();
        }
        return getInstance();
    }

    public static CookieSyncManager getInstance() {
        synchronized (sLockObject) {
            checkInstanceIsAllowed();
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setGetInstanceIsAllowed() {
        sGetInstanceAllowed = true;
    }

    @Deprecated
    public void resetSync() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().resetSync();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().run();
        }
    }

    @Deprecated
    public void startSync() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().startSync();
        }
    }

    @Deprecated
    public void stopSync() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().stopSync();
        }
    }

    @Deprecated
    public void sync() {
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().sync();
        }
    }
}
