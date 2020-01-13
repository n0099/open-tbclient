package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
@Deprecated
/* loaded from: classes10.dex */
public class CookieSyncManager implements Runnable {
    private static String TAG = "CookieSyncManager";
    private static boolean sGetInstanceAllowed = false;
    private static final CookieSyncManager mInstance = new CookieSyncManager();

    private static void checkInstanceIsAllowed() {
        if (!sGetInstanceAllowed) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (context == null) {
                throw new IllegalArgumentException("Invalid context argument");
            }
            if (Looper.getMainLooper() != Looper.myLooper()) {
                Log.e(TAG, "CookieSyncManager.createInstance() must be called on the main thread.");
            }
            setGetInstanceIsAllowed();
            cookieSyncManager = getInstance();
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            checkInstanceIsAllowed();
            cookieSyncManager = mInstance;
        }
        return cookieSyncManager;
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
