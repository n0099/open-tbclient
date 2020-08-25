package com.baidu.webkit.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.util.AndroidRuntimeException;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.ApisInteractWithMario;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.internal.blink.e;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
public final class WebViewFactory {
    private static final String CHROMIUM_HOST_APP = "com.baidu.browser.apps";
    private static final String CHROMIUM_LIBS_PATH = "files/zeus/libs";
    private static final String CHROMIUM_WEBVIEW_FACTORY = "com.baidu.zeus.WebViewChromiumFactoryProvider";
    private static final boolean DEBUG = true;
    private static final String SYSTEM_WEBVIEW_FACTORY = "com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider";
    private static final String TAG = "WebViewFactory";
    private static final String ZEUS_APK_NAME = "com.baidu.zeus.apk";
    private static final String ZEUS_LIB_NAME = "libcom.baidu.zeus.so";
    private static IABTestInterface mABTestObject;
    private static Context mContext;
    private static ICronetListenerInterface mCronetListenerObject;
    private static Thread mInitWebViewThread;
    private static boolean mIsInstallUpdate;
    private static boolean mIsZeusProvideInit;
    private static INetProbeInterface mNetProbeObject;
    private static PackageInfo mPackageInfo;
    private static WebViewFactoryProvider mProvider;
    private static boolean sCloudSettingInit;
    private static String sDataDirectorySuffix;
    private static final boolean sEnableSharedEngine = false;
    private static Boolean sIsRendererProcess;
    private static String sProcessSuffix;
    private static boolean sProcessSuffixDone;
    private static boolean sUsingSystemWebView;
    private static boolean sWebViewDisabled;
    private static boolean sforceMainProcessNoZeus;
    private static final String SPLASH = File.separator;
    private static final Object mProviderLock = new Object();
    private static final Object mZeusProviderLock = new Object();
    private static AtomicInteger mEngineType = new AtomicInteger(-1);
    private static int sIsPreInitWebViewEnable = -1;
    private static final Object sProviderLock = new Object();

    /* loaded from: classes19.dex */
    public interface WebKitUnzipCallback {
        void unzipFinished();
    }

    private static void checkNativeLibraryIntegrity() throws Throwable {
        d.a aVar;
        long j;
        if (Build.VERSION.SDK_INT != 19) {
            return;
        }
        if (d.a(mContext).a.a()) {
            String str = aVar.d + GlobalConstants.LIB_ZEUS_CHROMIUM;
            File file = new File(str);
            if (GlobalConstants.FILE_SIZE_LIB_ZEUS_WEBVIEW_CHROMIUM != -1) {
                try {
                    j = file.length();
                } catch (Throwable th) {
                    th.printStackTrace();
                    j = 0;
                }
                Log.i(TAG, "checkNativeLibraryIntegrity: " + str + ", 27057988, " + j);
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enable_sosize_check");
                if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals("false")) {
                    if (GlobalConstants.FILE_SIZE_LIB_ZEUS_WEBVIEW_CHROMIUM != j || j == 0) {
                        mProvider = null;
                        throw new Exception("checkNativeLibraryIntegrity: " + str + ", 27057988, " + j);
                    }
                }
            }
        }
    }

    private static void checkNativeLibraryVersion(PackageInfo packageInfo, WebViewFactoryProvider webViewFactoryProvider) throws Throwable {
        String str = packageInfo.versionName;
        try {
            String zeusJarVersion = webViewFactoryProvider.getZeusJarVersion();
            String zeusNativeLibraryVersion = webViewFactoryProvider.getZeusNativeLibraryVersion();
            String sdkVersionCode = WebKitFactory.getSdkVersionCode();
            Log.i(TAG, "[checkNativeLibraryVersion] zeus version=" + str + ", zeus jar version=" + zeusJarVersion + ", blink version=" + zeusNativeLibraryVersion);
            if (isVersionMatched(str, zeusNativeLibraryVersion, true) && isVersionMatched(str, zeusJarVersion, true) && isVersionMatched(sdkVersionCode, str, false)) {
                return;
            }
            SevenZipUtils.getInstance().clearTimestamp(d.a(mContext).a.d);
            throw new Exception("sdk and native library dismatch " + str + ", " + zeusJarVersion + ", " + zeusNativeLibraryVersion);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("sdk and zeus jar dismatch " + str + ", 9.0.0.0");
        }
    }

    private static boolean checkZeusVersion(PackageInfo packageInfo) throws Throwable {
        if (packageInfo == null) {
            return false;
        }
        String sdkVersionCode = WebKitFactory.getSdkVersionCode();
        String str = packageInfo.versionName;
        Log.i(TAG, "[checkZeusVersion] sdk version=" + sdkVersionCode + ", zeus version=" + str);
        if (isVersionMatched(sdkVersionCode, str, false)) {
            return true;
        }
        File optFile = getOptFile();
        FileUtils.deleteDir(optFile, optFile);
        LoadErrorCode.getInstance().trace(500);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disableWebView() {
        synchronized (sProviderLock) {
            if (mProvider != null) {
                throw new IllegalStateException("Can't disable WebView: WebView already initialized");
            }
            sWebViewDisabled = true;
        }
    }

    private static void fetchDefaultPackageInfo() {
        if (hasProvider()) {
            return;
        }
        PackageInfo packedPackageInfo = getPackedPackageInfo(mContext);
        mPackageInfo = packedPackageInfo;
        if (packedPackageInfo == null) {
            mPackageInfo = getInternPackageInfo(mContext);
        }
        if (mPackageInfo != null) {
            Log.d(TAG, "-mPackageInfo.packageName=" + mPackageInfo.packageName);
            Log.d(TAG, "-mPackageInfo.versionCode=" + mPackageInfo.versionCode);
            Log.d(TAG, "-mPackageInfo.versionName=" + mPackageInfo.versionName);
            Log.d(TAG, "-mPackageInfo.sourceDir=" + mPackageInfo.applicationInfo.sourceDir);
            Log.d(TAG, "-mPackageInfo.nativeLibraryDir=" + mPackageInfo.applicationInfo.nativeLibraryDir);
        }
    }

    private static PackageInfo fetchPackageInfo() {
        PackageInfo packedPackageInfo = getPackedPackageInfo(mContext);
        if (packedPackageInfo == null) {
            packedPackageInfo = getInternPackageInfo(mContext);
        }
        if (packedPackageInfo != null) {
            Log.d(TAG, "-ForceLoad PackageInfo.packageName=" + packedPackageInfo.packageName);
            Log.d(TAG, "-ForceLoad PackageInfo.versionCode=" + packedPackageInfo.versionCode);
            Log.d(TAG, "-ForceLoad PackageInfo.versionName=" + packedPackageInfo.versionName);
            Log.d(TAG, "-ForceLoad PackageInfo.sourceDir=" + packedPackageInfo.applicationInfo.sourceDir);
            Log.d(TAG, "-ForceLoad PackageInfo.nativeLibraryDir=" + packedPackageInfo.applicationInfo.nativeLibraryDir);
        }
        return packedPackageInfo;
    }

    private static void fetchSystemPackageInfo() {
        if (hasProvider()) {
            return;
        }
        mPackageInfo = null;
        if (Build.VERSION.SDK_INT > 20) {
            if (mPackageInfo == null) {
                if (Build.VERSION.SDK_INT > 23) {
                    try {
                        Method declaredMethod = Class.forName("android.webkit.WebViewFactory").getDeclaredMethod("getWebViewContextAndSetProvider", null);
                        boolean isAccessible = declaredMethod.isAccessible();
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(null, null);
                        declaredMethod.setAccessible(isAccessible);
                        try {
                            mPackageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                    }
                } else {
                    try {
                        mPackageInfo = mContext.getPackageManager().getPackageInfo((String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, null), 0);
                    } catch (Throwable th2) {
                    }
                }
            }
            if (mPackageInfo == null) {
                try {
                    Method declaredMethod2 = Class.forName("android.webkit.WebViewFactory").getDeclaredMethod("getProvider", null);
                    boolean isAccessible2 = declaredMethod2.isAccessible();
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(null, null);
                    declaredMethod2.setAccessible(isAccessible2);
                    mPackageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, null);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        if (mPackageInfo == null) {
            PackageInfo packageInfo = new PackageInfo();
            mPackageInfo = packageInfo;
            packageInfo.packageName = "system_webview";
            mPackageInfo.versionName = "Android" + Build.VERSION.RELEASE + "_webview";
            mPackageInfo.versionCode = 0;
            mPackageInfo.applicationInfo = new ApplicationInfo();
            mPackageInfo.applicationInfo.sourceDir = "?frameworks.jar";
            mPackageInfo.applicationInfo.nativeLibraryDir = "/system/lib";
        }
        Log.i(TAG, "Package=" + mPackageInfo.packageName + ", Version=" + mPackageInfo.versionName);
        if (mPackageInfo != null) {
            Log.d(TAG, "-mSystemWebView.packageName=" + mPackageInfo.packageName);
            Log.d(TAG, "-mSystemWebView.versionCode=" + mPackageInfo.versionCode);
            Log.d(TAG, "-mSystemWebView.versionName=" + mPackageInfo.versionName);
            Log.d(TAG, "-mSystemWebView.sourceDir=" + mPackageInfo.applicationInfo.sourceDir);
            Log.d(TAG, "-mSystemWebView.nativeLibraryDir=" + mPackageInfo.applicationInfo.nativeLibraryDir);
        }
    }

    public static boolean forceInitZeusProvider() {
        if (!mIsZeusProvideInit) {
            synchronized (mZeusProviderLock) {
                ZeusPerformanceTiming.forceInitT7();
                d.a(mContext).a();
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_GET_PROVIDER);
                ZeusCrashHandler.init();
                LoadErrorCode.Statistics.init(getContext());
                if (mContext == null) {
                    throw new AndroidRuntimeException("WebViewFactory.setContext must be called before getProvider()");
                }
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    WebViewFactoryProvider zeusProviderImpl = getZeusProviderImpl();
                    if (zeusProviderImpl != null && !isRendererProcess()) {
                        ApisInteractWithMario.initialize();
                    }
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_GET_PROVIDER);
                    mIsZeusProvideInit = true;
                    r0 = zeusProviderImpl != null;
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                } catch (Exception e) {
                    throw new AndroidRuntimeException(e);
                }
            }
        }
        return r0;
    }

    public static boolean forceNoZeus() {
        return sforceMainProcessNoZeus;
    }

    public static IABTestInterface getAbTestInterface() {
        return mABTestObject;
    }

    public static Context getContext() {
        return mContext;
    }

    public static ICronetListenerInterface getCronetListenerInterface() {
        return mCronetListenerObject;
    }

    public static String getDataDirectorySuffix() {
        String str;
        synchronized (sProviderLock) {
            str = sDataDirectorySuffix;
        }
        return str;
    }

    private static PackageInfo getInternPackageInfo(Context context) {
        PackageInfo packageInfo;
        Throwable th = null;
        try {
            packageInfo = Class.forName(CHROMIUM_WEBVIEW_FACTORY, false, WebViewFactory.class.getClassLoader()) != null ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0) : null;
        } catch (Throwable th2) {
            packageInfo = null;
            th = th2;
        }
        if (th != null || packageInfo == null) {
            LoadErrorCode.getInstance().set(2, LoadErrorCode.getRootMessage(th));
        }
        return packageInfo;
    }

    public static String getLoadErrorMsg() {
        return LoadErrorCode.getInstance().getString();
    }

    public static PackageInfo getLoadedPackageInfo() {
        PackageInfo packageInfo;
        synchronized (mProviderLock) {
            packageInfo = mPackageInfo;
        }
        return packageInfo;
    }

    public static INetProbeInterface getNetProbeInterface() {
        return mNetProbeObject;
    }

    @SuppressLint({"NewApi"})
    private static File getOptFile() {
        if (!isRendererProcess() || Build.VERSION.SDK_INT <= 22) {
            File file = new File(Build.VERSION.SDK_INT < 21 ? mContext.getDir("zeus", 0) : mContext.getCodeCacheDir(), "engine_code_cache");
            if (!file.exists() && file.mkdirs()) {
                file.setReadable(true, false);
                file.setWritable(true, false);
            }
            return file;
        }
        return null;
    }

    private static PackageInfo getPackedPackageInfo(Context context) {
        PackageInfo packageInfo;
        Object obj;
        Throwable th = null;
        Log.i(TAG, "[getPackedPackageInfo] begin ...");
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            d a = d.a(context);
            d.a aVar = a.a;
            mIsInstallUpdate = false;
            String str = applicationInfo.nativeLibraryDir + SPLASH + "libcom.baidu.zeus.so";
            String downloadLibPath = UtilsBlink.getDownloadLibPath(context);
            if (downloadLibPath != null) {
                String str2 = downloadLibPath + "libcom.baidu.zeus.so";
                if (new File(str2).exists() && EngineManager.getInstance().isInstalled()) {
                    mIsInstallUpdate = true;
                    str = str2;
                }
            }
            if (!a.a.a() && !EngineManager.getInstance().isInstalled()) {
                LoadErrorCode.getInstance().trace(513);
            }
            packageInfo = context.getPackageManager().getPackageArchiveInfo(str, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
            if (packageInfo != null) {
                try {
                    packageInfo.applicationInfo.sourceDir = str;
                    packageInfo.applicationInfo.publicSourceDir = packageInfo.applicationInfo.sourceDir;
                    if (aVar.a() || mIsInstallUpdate) {
                        packageInfo.applicationInfo.nativeLibraryDir = aVar.d + ":" + applicationInfo.nativeLibraryDir;
                    } else {
                        packageInfo.applicationInfo.nativeLibraryDir = applicationInfo.nativeLibraryDir;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            packageInfo = null;
            th = th3;
        }
        StringBuilder sb = new StringBuilder("[getPackedPackageInfo] finish - ");
        if (th == null) {
            obj = Boolean.valueOf(packageInfo != null);
        } else {
            obj = "exception:" + th.getCause();
        }
        Log.i(TAG, sb.append(obj).toString());
        if (th != null || packageInfo == null) {
            LoadErrorCode.getInstance().set(1, LoadErrorCode.getRootMessage(th));
        }
        return packageInfo;
    }

    public static String getProcessName() {
        return getProcessName(mContext, Process.myPid());
    }

    private static String getProcessName(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    public static String getProcessSuffix(Context context) {
        if (sProcessSuffixDone) {
            return sProcessSuffix;
        }
        String processName = getProcessName(context, Process.myPid());
        android.util.Log.d(TAG, "context=" + context + ", processName=" + processName);
        if (processName != null) {
            int indexOf = processName.indexOf(58);
            String substring = indexOf >= 0 ? processName.substring(indexOf + 1) : null;
            Log.d(TAG, "suffix=" + substring);
            sProcessSuffix = substring;
            sProcessSuffixDone = true;
            return substring;
        }
        return null;
    }

    public static WebViewFactoryProvider getProvider() {
        if (hasProvider()) {
            return mProvider;
        }
        synchronized (mProviderLock) {
            if (mProvider != null) {
                ZeusPerformanceTiming.setIsGetProviderHitSynchronized(true);
                return mProvider;
            } else if (sWebViewDisabled) {
                throw new IllegalStateException("WebView.disableWebView() was called: WebView is disabled");
            } else {
                if (!sUsingSystemWebView) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_GET_PROVIDER);
                }
                if (!isRendererProcess()) {
                    ZeusCrashHandler.init();
                    LoadErrorCode.Statistics.init(getContext());
                }
                if (mContext == null) {
                    throw new AndroidRuntimeException("WebViewFactory.setContext must be called before getProvider(), or invoke getProvider() on MainThread.");
                }
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    WebViewFactoryProvider providerImpl = getProviderImpl();
                    if (providerImpl != null && !isRendererProcess()) {
                        ApisInteractWithMario.initialize();
                    }
                    if (!sUsingSystemWebView) {
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_GET_PROVIDER);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return providerImpl;
                } catch (Exception e) {
                    throw new AndroidRuntimeException(e);
                }
            }
        }
    }

    private static WebViewFactoryProvider getProviderImpl() {
        if (!sUsingSystemWebView) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
        }
        boolean shouldUseSystemWebView = shouldUseSystemWebView(false);
        if (!sUsingSystemWebView) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
        }
        if (getDataDirectorySuffix() == null) {
            String processSuffix = getProcessSuffix(mContext);
            if (processSuffix == null) {
                android.util.Log.w(TAG, "process suffix is null, context=" + mContext);
            } else {
                WebView.setDataDirectorySuffix(processSuffix);
                android.util.Log.i(TAG, "set default suffix: " + getDataDirectorySuffix());
            }
        }
        if (mPackageInfo == null && !shouldUseSystemWebView) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
            fetchDefaultPackageInfo();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
            if (mPackageInfo == null && ZeusSDK.usingZeusSDK() && installZesEngineIfNeeded(false, true)) {
                fetchDefaultPackageInfo();
            }
        }
        sforceMainProcessNoZeus = false;
        if (mPackageInfo != null && !shouldUseSystemWebView) {
            try {
                if (!checkZeusVersion(mPackageInfo)) {
                    throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + ", " + mPackageInfo.versionName);
                }
                boolean equals = mPackageInfo.packageName.equals(mContext.getPackageName());
                File optFile = getOptFile();
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                ClassLoader classLoader = equals ? WebViewFactory.class.getClassLoader() : new ZeusClassLoader(mPackageInfo.applicationInfo.sourceDir, optFile, mPackageInfo.applicationInfo.nativeLibraryDir, WebViewFactory.class.getClassLoader());
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                Class<?> loadClass = classLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                if (!isRendererProcess()) {
                    d.a(mContext).b();
                }
                if (Build.VERSION.SDK_INT < 21 && isMainAppProcess() && ZeusInitConfigUtils.get("no_zeus_under_5", false)) {
                    sforceMainProcessNoZeus = true;
                    throw new Exception("disable main process zeus under android 5.0");
                }
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                mProvider = (WebViewFactoryProvider) loadClass.getMethod("getInstance", null).invoke(null, null);
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                if (mProvider != null && !isRendererProcess()) {
                    checkNativeLibraryVersion(mPackageInfo, mProvider);
                    mEngineType.set(1);
                }
            } catch (Throwable th) {
                mProvider = null;
                LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
            }
        }
        if (mProvider == null) {
            if (mIsInstallUpdate && !sforceMainProcessNoZeus) {
                EngineManager.getInstance().resetZeus();
                EngineManager.getInstance().setNeedKillProcess(true);
            }
            if (LoadErrorCode.getInstance().getInt() == 0) {
                LoadErrorCode.getInstance().set(6, "6:" + shouldUseSystemWebView + Constants.ACCEPT_TIME_SEPARATOR_SP + (mPackageInfo != null));
            }
            fetchSystemPackageInfo();
            try {
                WebViewFactoryProvider webViewFactoryProvider = (WebViewFactoryProvider) Class.forName(SYSTEM_WEBVIEW_FACTORY).getMethod("getInstance", null).invoke(null, null);
                mProvider = webViewFactoryProvider;
                if (webViewFactoryProvider != null) {
                    mEngineType.set(0);
                }
            } catch (Exception e) {
                mProvider = null;
                if (!isRendererProcess()) {
                    LoadErrorCode.Statistics.record();
                }
                throw new AndroidRuntimeException(e);
            }
        } else if (mIsInstallUpdate) {
            EngineManager.getInstance().setNeedKillProcess(false);
        }
        Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  mProvider = " + mProvider);
        if (!isRendererProcess()) {
            mProvider.createCookieSyncManager(mContext);
        }
        if (LoadErrorCode.getInstance().getInt() != 0) {
            Log.i(TAG, "getProvider error code : " + LoadErrorCode.getInstance().getInt() + " , " + LoadErrorCode.getInstance().getString());
        }
        if (!isRendererProcess()) {
            LoadErrorCode.Statistics.record();
        }
        return mProvider;
    }

    private static PackageInfo getSharedPackageInfo(Context context) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Throwable th = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(CHROMIUM_HOST_APP, 128);
        } catch (Throwable th2) {
            th = th2;
            packageInfo = null;
        }
        if (applicationInfo.metaData == null || applicationInfo.metaData.getString("zeus.engine") == null) {
            throw new AndroidRuntimeException("no metaData about shared-engine");
        }
        String str = applicationInfo.dataDir + "/" + applicationInfo.metaData.getString("zeus.engine");
        packageInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        try {
            new File(str);
            if (packageInfo != null) {
                packageInfo.applicationInfo.sourceDir = str;
                packageInfo.applicationInfo.nativeLibraryDir = applicationInfo.dataDir + "/files/zeus/libs/:" + applicationInfo.nativeLibraryDir;
            }
        } catch (Throwable th3) {
            th = th3;
            th = th;
            if (th == null) {
            }
            LoadErrorCode.getInstance().set(3, LoadErrorCode.getRootMessage(th));
            return packageInfo;
        }
        if (th == null || packageInfo == null) {
            LoadErrorCode.getInstance().set(3, LoadErrorCode.getRootMessage(th));
        }
        return packageInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static WebViewFactoryProvider getZeusProviderImpl() {
        PackageInfo packageInfo;
        WebViewFactoryProvider webViewFactoryProvider;
        Throwable th;
        if (!sUsingSystemWebView) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
        }
        boolean shouldUseSystemWebView = shouldUseSystemWebView(true);
        if (!sUsingSystemWebView) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
        }
        if (shouldUseSystemWebView) {
            packageInfo = null;
        } else {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
            PackageInfo fetchPackageInfo = fetchPackageInfo();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
            packageInfo = fetchPackageInfo;
        }
        if (packageInfo == null || shouldUseSystemWebView) {
            webViewFactoryProvider = null;
        } else {
            try {
                if (!checkZeusVersion(packageInfo)) {
                    throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + ", " + packageInfo.versionName);
                }
                boolean equals = packageInfo.packageName.equals(mContext.getPackageName());
                File optFile = getOptFile();
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                ClassLoader classLoader = equals ? WebViewFactory.class.getClassLoader() : new ZeusClassLoader(packageInfo.applicationInfo.sourceDir, optFile, packageInfo.applicationInfo.nativeLibraryDir, WebViewFactory.class.getClassLoader());
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                Class<?> loadClass = classLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                if (!isRendererProcess()) {
                    d.a(mContext).b();
                }
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                webViewFactoryProvider = (WebViewFactoryProvider) loadClass.getMethod("getInstance", null).invoke(null, null);
                try {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                    if (webViewFactoryProvider != null) {
                        checkNativeLibraryVersion(packageInfo, webViewFactoryProvider);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
                    Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  zeusProvider = " + webViewFactoryProvider);
                    if (webViewFactoryProvider != null) {
                    }
                    if (LoadErrorCode.getInstance().getInt() != 0) {
                    }
                    LoadErrorCode.Statistics.record();
                    return webViewFactoryProvider;
                }
            } catch (Throwable th3) {
                webViewFactoryProvider = null;
                th = th3;
            }
        }
        Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  zeusProvider = " + webViewFactoryProvider);
        if (webViewFactoryProvider != null) {
            webViewFactoryProvider.createCookieSyncManager(mContext);
        }
        if (LoadErrorCode.getInstance().getInt() != 0) {
            Log.i(TAG, "getProvider error code : " + LoadErrorCode.getInstance().getInt() + " , " + LoadErrorCode.getInstance().getString());
        }
        LoadErrorCode.Statistics.record();
        return webViewFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void handleTaskAfterWebkitInited() {
        if (mProvider != null) {
            mProvider.commonInitialize();
            if (isRendererProcess()) {
                return;
            }
            if (mABTestObject != null) {
                mProvider.onABTestReady();
            }
            mProvider.lazyInitialize();
        }
    }

    public static boolean hasProvider() {
        return mEngineType.get() != -1;
    }

    private static void initCloudSetting() {
        if (sCloudSettingInit) {
            return;
        }
        try {
            CloudSettings.restoreSettingsToFrameWork();
        } catch (Throwable th) {
            Log.e(TAG, "restoreSettingsToFrameWork  failed:", th);
        }
        sCloudSettingInit = true;
    }

    public static void initOnAppStart(Context context, boolean z, boolean z2) {
        ZeusPerformanceTiming.initOnAppStart();
        if (context != null) {
            mContext = context.getApplicationContext();
        }
        setUseSystemWebView(z2);
        if (z2) {
            return;
        }
        setUsingLzma(context, z, null);
    }

    public static void initWebViewInBackgroundThread() {
        synchronized (WebViewFactory.class) {
            if (mInitWebViewThread == null) {
                Thread thread = new Thread(new Runnable() { // from class: com.baidu.webkit.sdk.WebViewFactory.2
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z = true;
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (WebViewFactory.isPreInitWebViewEnable() && WebKitFactory.getCurEngine() == 1) {
                                Log.d("ZeusStartupTimingMonitor", "init bg webview start");
                                WebView webView = new WebView(WebViewFactory.getContext(), true);
                                Log.d("ZeusStartupTimingMonitor", "new bg webview in backgroudthread  " + (System.currentTimeMillis() - currentTimeMillis));
                                webView.destroy();
                            }
                            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("zeus_init_opt_enable");
                            if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("false")) {
                                z = false;
                            }
                            if (z) {
                                IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
                                if (2 == (abTestInterface != null ? abTestInterface.getSwitch(ABTestConstants.ZEUS_INIT_OPT_KEY, 0) : 0) && WebViewFactory.hasProvider()) {
                                    Log.i(GlobalConstants.LOG_PER_TAG, " startBrowserProcessBackground from task");
                                    WebViewFactory.getProvider().startBrowserProcess(false);
                                }
                            }
                        } catch (Throwable th) {
                            Log.i(WebViewFactory.TAG, "[init webview] exception =" + th);
                        }
                    }
                }, "T7@initBaiduWebView");
                mInitWebViewThread = thread;
                thread.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 8)
    public static boolean installZesEngineIfNeeded(boolean z, boolean z2) {
        boolean z3 = z && isDebugApk(getContext());
        if (!z || z3) {
            String requestZeusEngine = (!z3 || z2 || mContext == null) ? z2 ? ZeusSDK.getClient().requestZeusEngine(ZeusSDK.getSDKVersionName()) : null : "file://" + mContext.getExternalFilesDir("").getAbsolutePath() + "/zeus-engine-debug/zeus-engine.zes";
            if (requestZeusEngine == null || requestZeusEngine.length() == 0) {
                return false;
            }
            File file = new File(requestZeusEngine.substring("file://".length()));
            if (file.exists() && file.isFile()) {
                boolean installSync = EngineManager.getInstance().installSync(requestZeusEngine, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.webkit.sdk.WebViewFactory.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i, String str) {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                    }
                });
                ZeusSDK.getClient().onInstallFinished(installSync, 0);
                if (z3) {
                    File file2 = new File(requestZeusEngine.substring("file://".length()));
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
                return installSync;
            }
            return false;
        }
        return false;
    }

    private static boolean isDebugApk(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isForceZeusProviderInited() {
        return mIsZeusProvideInit;
    }

    public static boolean isMainAppProcess() {
        return getProcessSuffix(mContext) == null;
    }

    public static boolean isPreInitWebViewEnable() {
        if (isRendererProcess()) {
            return false;
        }
        if (-1 == sIsPreInitWebViewEnable) {
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue(ABTestConstants.PRE_INIT_WEBVIEW);
            if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("0")) {
                sIsPreInitWebViewEnable = 0;
            }
            sIsPreInitWebViewEnable = 0;
            IABTestInterface abTestInterface = getAbTestInterface();
            if (abTestInterface != null) {
                sIsPreInitWebViewEnable = abTestInterface.getSwitch(ABTestConstants.PRE_INIT_WEBVIEW, 0);
            }
        }
        return sIsPreInitWebViewEnable == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r2.indexOf(com.baidu.webkit.sdk.WebViewRendererService.RENDER_SERVICE_PROCESS_NAME_SUFFIX) >= 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRendererProcess() {
        boolean z = true;
        if (sIsRendererProcess == null) {
            try {
                String processSuffix = getProcessSuffix(mContext);
                if (processSuffix != null) {
                }
                z = false;
            } catch (Exception e) {
                Log.w(TAG, "failed to get process info", e);
            }
            sIsRendererProcess = Boolean.valueOf(z);
            return z;
        }
        return sIsRendererProcess.booleanValue();
    }

    public static boolean isSwanProcess() {
        try {
            String processSuffix = getProcessSuffix(mContext);
            if (processSuffix != null) {
                return processSuffix.indexOf("swan") >= 0;
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, "failed to get process info", e);
            return false;
        }
    }

    private static boolean isVersionMatched(String str, String str2, boolean z) {
        boolean z2 = false;
        if (str == null || str2 == null) {
            return false;
        }
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        try {
            String[] split = str.split("\\.", 4);
            String[] split2 = str2.split("\\.", 4);
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            iArr[2] = Integer.parseInt(split[2]);
            iArr[3] = Integer.parseInt(split[3]);
            iArr2[0] = Integer.parseInt(split2[0]);
            iArr2[1] = Integer.parseInt(split2[1]);
            iArr2[2] = Integer.parseInt(split2[2]);
            iArr2[3] = Integer.parseInt(split2[3]);
        } catch (Throwable th) {
        }
        if (iArr[0] == 0 || iArr2[0] == 0) {
            return false;
        }
        boolean z3 = iArr[0] == iArr2[0] && iArr[1] == iArr2[1] && iArr[2] == iArr2[2];
        boolean z4 = z3 && iArr[3] == iArr2[3];
        if (z3 && iArr[3] <= iArr2[3]) {
            z2 = true;
        }
        return !z ? z2 : z4;
    }

    public static boolean isZeusProvider() {
        return mEngineType.get() == 1;
    }

    public static void setAbTestInterface(IABTestInterface iABTestInterface) {
        mABTestObject = iABTestInterface;
    }

    public static void setCronetListenerInterface(ICronetListenerInterface iCronetListenerInterface) {
        Log.i(TAG, "setCronetListernerInterface " + iCronetListenerInterface);
        mCronetListenerObject = iCronetListenerInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDataDirectorySuffix(String str) {
        synchronized (sProviderLock) {
            if (mProvider != null) {
                throw new IllegalStateException("Can't set data directory suffix: WebView already initialized");
            }
            if (str.indexOf(File.separatorChar) >= 0) {
                throw new IllegalArgumentException("Suffix " + str + " contains a path separator");
            }
            sDataDirectorySuffix = str;
        }
    }

    public static void setNetProbeInterface(INetProbeInterface iNetProbeInterface) {
        Log.i(TAG, "setNetProbeInterface " + iNetProbeInterface);
        mNetProbeObject = iNetProbeInterface;
    }

    static boolean setPackageInfo(PackageInfo packageInfo) {
        synchronized (mProviderLock) {
            if (mProvider != null) {
                throw new AndroidRuntimeException("cannot setPackageInfo while provider is loaded.");
            }
            mPackageInfo = packageInfo;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUseSystemWebView(boolean z) {
        sUsingSystemWebView = z;
    }

    public static void setUsingLzma(Context context, boolean z, WebKitUnzipCallback webKitUnzipCallback) {
        d a = d.a(context);
        a.a.a(z);
        if (!z || isRendererProcess()) {
            return;
        }
        synchronized (d.e) {
            if (context != null) {
                if (a.a != null && a.b == null) {
                    a.b = new d.b(context);
                }
            }
        }
        synchronized (d.e) {
            if (a.c != webKitUnzipCallback) {
                a.c = webKitUnzipCallback;
                if (a.d == null) {
                    a.d = new Handler(Looper.getMainLooper());
                }
                a.d.postDelayed(new e(a), 15000L);
            }
        }
    }

    private static boolean shouldUseSystemWebView(boolean z) {
        boolean z2;
        boolean z3;
        if ((sUsingSystemWebView && !z) || !WebKitFactory.isPlatformSupported()) {
            LoadErrorCode.getInstance().trace("511:" + sUsingSystemWebView + Constants.ACCEPT_TIME_SEPARATOR_SP + WebKitFactory.isPlatformSupported() + Constants.ACCEPT_TIME_SEPARATOR_SP + WebKitFactory.isZeusSupported());
            return true;
        }
        initCloudSetting();
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("chromium63_zeus_enable");
        Log.i(TAG, "chromium63_zeus_enable = " + GetCloudSettingsValue);
        if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals("false")) {
            z2 = true;
        } else {
            LoadErrorCode.getInstance().trace(510);
            z2 = false;
        }
        IABTestInterface abTestInterface = getAbTestInterface();
        if (abTestInterface != null && abTestInterface.getSwitch(ABTestConstants.T7_V10_BLACK_LIST, false)) {
            String[] strArr = {"MI 6X", "MI 6X MIKU", "REDMI NOTE 5", "REDMI NOTE 7", "V1814A", "V1814T", "V1816A", "V1816T", "VIVO X21", "VIVO X21A", "VIVO X21UD", "VIVO X21UD A", "VIVO Z3X"};
            for (int i = 0; i < 13; i++) {
                if (strArr[i].equals(Build.MODEL.toUpperCase())) {
                    LoadErrorCode.getInstance().trace(515);
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        Log.i(TAG, "shouldUseSystemWebView isHitTarget = " + z3);
        return !z2 || z3;
    }

    public static void startBrowserProcess() {
        boolean z = true;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.webkit.sdk.WebViewFactory.3
                @Override // java.lang.Runnable
                public void run() {
                    WebViewFactory.startBrowserProcess();
                }
            });
            return;
        }
        try {
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("zeus_init_opt_enable");
            if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("false")) {
                z = false;
            }
            if (z && hasProvider()) {
                Log.i(GlobalConstants.LOG_PER_TAG, " startBrowserProcessBackground from API");
                getProvider().startBrowserProcess(true);
            }
        } catch (Throwable th) {
            Log.i(GlobalConstants.LOG_PER_TAG, "[startBrowserProcess] exception =" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean unzip() {
        if (hasProvider()) {
            return false;
        }
        initCloudSetting();
        d.a(mContext).a();
        return true;
    }

    public static boolean unzipOnAppStart(Context context, boolean z, boolean z2, WebKitUnzipCallback webKitUnzipCallback) {
        if (z2 || !z || context == null) {
            return false;
        }
        if (mContext == null) {
            mContext = context.getApplicationContext();
        }
        setUsingLzma(context, true, webKitUnzipCallback);
        return unzip();
    }
}
