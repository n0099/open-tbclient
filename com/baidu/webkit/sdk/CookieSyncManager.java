package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
@Deprecated
/* loaded from: classes9.dex */
public class CookieSyncManager implements Runnable {
    public static String TAG = "CookieSyncManager";
    public static boolean sGetInstanceAllowed;
    public static final CookieSyncManager mInstance = new CookieSyncManager();
    public static final Object sLockObject = new Object();

    public static void checkInstanceIsAllowed() {
        if (!sGetInstanceAllowed) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
    }

    public static CookieSyncManager createInstance(Context context) {
        if (context != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                Log.e(TAG, "CookieSyncManager.createInstance() must be called on the main thread.");
            }
            synchronized (sLockObject) {
                setGetInstanceIsAllowed();
            }
            return getInstance();
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    public static CookieSyncManager getInstance() {
        synchronized (sLockObject) {
            checkInstanceIsAllowed();
        }
        return mInstance;
    }

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
