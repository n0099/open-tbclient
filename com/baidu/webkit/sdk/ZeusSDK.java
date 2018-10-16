package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
/* loaded from: classes2.dex */
public final class ZeusSDK {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean ENABLE_REPLACE_ZES_ENGINE = false;
    private static final String TAG = "ZeusSDK";
    private static Client mClient;
    private static Configuration mConfig;
    private static volatile boolean mHasInited;
    private static long mTimeInit;

    /* loaded from: classes2.dex */
    public static class Client {
        public void onInitFinished(boolean z) {
        }

        public void onInstallFinished(boolean z, int i) {
        }

        public String requestZeusEngine(String str) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Configuration {
        private String mAPPIDString;
        private String mCUIDString;
        private boolean mForceUsingSystemWebView = false;
        private boolean mThreadingInitialization = false;
        private volatile boolean mEnableBrandPromotion = true;
        private volatile boolean mEnablePullToRefresh = false;

        public final boolean forceUsingSystemWebView() {
            return this.mForceUsingSystemWebView;
        }

        public final String getAppID() {
            return this.mAPPIDString;
        }

        public final String getCUID() {
            return this.mCUIDString;
        }

        public final boolean getEnableBrandPromotion() {
            return this.mEnableBrandPromotion;
        }

        public final boolean getEnablePullToRefresh() {
            return this.mEnablePullToRefresh;
        }

        public final Configuration setAppID(String str) {
            this.mAPPIDString = str;
            return this;
        }

        public final Configuration setCUID(String str) {
            this.mCUIDString = str;
            return this;
        }

        public final Configuration setEnableBrandPromotion(boolean z) {
            this.mEnableBrandPromotion = z;
            if (z) {
                this.mEnablePullToRefresh = false;
            }
            return this;
        }

        public final Configuration setEnablePullToRefresh(boolean z) {
            this.mEnablePullToRefresh = z;
            if (z) {
                this.mEnableBrandPromotion = false;
            }
            return this;
        }

        public final Configuration setForceUsingSystemWebView(boolean z) {
            this.mForceUsingSystemWebView = z;
            return this;
        }

        public final Configuration setThreadingInitialization(boolean z) {
            this.mThreadingInitialization = z;
            return this;
        }

        public final boolean threadingInitialization() {
            return this.mThreadingInitialization;
        }
    }

    static {
        $assertionsDisabled = !ZeusSDK.class.desiredAssertionStatus();
        mClient = new Client();
        mConfig = new Configuration();
        mHasInited = false;
        mTimeInit = 0L;
        ENABLE_REPLACE_ZES_ENGINE = false;
    }

    public static void crashNow() {
    }

    public static void destroy() {
        if (mHasInited) {
            WebKitFactory.destroy();
            mHasInited = false;
        }
    }

    public static Context getAppContext() {
        return WebViewFactory.getContext();
    }

    public static Client getClient() {
        return mClient;
    }

    public static Configuration getConfig() {
        return mConfig;
    }

    public static String getSDKVersionName() {
        return WebKitFactory.getSdkVersionCode();
    }

    public static String getZeusVersionName() {
        return mHasInited ? WebKitFactory.getZeusVersionName() : "0.0.0.0";
    }

    public static void initSDKEnvironment(Context context, Client client, Configuration configuration) {
        if (!$assertionsDisabled && context == null) {
            throw new AssertionError();
        }
        final Context applicationContext = context.getApplicationContext();
        if (!$assertionsDisabled && applicationContext == null) {
            throw new AssertionError();
        }
        if (mHasInited) {
            return;
        }
        mHasInited = true;
        if (client != null) {
            mClient = client;
        }
        if (configuration != null) {
            mConfig = configuration;
        }
        if ((Looper.getMainLooper() == Looper.myLooper()) && mConfig.threadingInitialization()) {
            new Thread(new Runnable() { // from class: com.baidu.webkit.sdk.ZeusSDK.1
                @Override // java.lang.Runnable
                public final void run() {
                    Process.setThreadPriority(0);
                    long currentTimeMillis = System.currentTimeMillis();
                    long unused = ZeusSDK.mTimeInit = currentTimeMillis;
                    ZeusSDK.initZeusEngine(applicationContext);
                    Log.e(ZeusSDK.TAG, "initZeusEngine finished, time=" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }, "T7@initZeusThread").start();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        mTimeInit = currentTimeMillis;
        initZeusEngine(applicationContext);
        Log.e(TAG, "initZeusEngine finished, time=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean initZeusEngine(Context context) {
        if ($assertionsDisabled || mHasInited) {
            WebViewFactory.initOnAppStart(context, false, getConfig().forceUsingSystemWebView());
            WebKitFactory.setEngine(getConfig().forceUsingSystemWebView() ? 0 : 1);
            WebKitFactory.init(context, getConfig().getAppID(), getConfig().getCUID());
            getClient().onInitFinished(WebViewFactory.hasProvider());
            return WebViewFactory.hasProvider();
        }
        throw new AssertionError();
    }

    public static boolean usingZeusEngine() {
        return WebViewFactory.isZeusProvider();
    }

    public static boolean usingZeusSDK() {
        return mHasInited;
    }
}
