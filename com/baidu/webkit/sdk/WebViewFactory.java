package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.AndroidRuntimeException;
import com.a.a.a.a.a.a.a;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.internal.blink.e;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
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
    private static Thread mInitWebViewThread;
    private static final boolean sEnableSharedEngine = false;
    private static boolean sUsingSystemWebView = false;
    private static final String SPLASH = File.separator;
    private static WebViewFactoryProvider mProvider = null;
    private static final Object mProviderLock = new Object();
    private static PackageInfo mPackageInfo = null;
    private static Context mContext = null;
    private static boolean mIsInstallUpdate = false;
    private static AtomicInteger mEngineType = new AtomicInteger(-1);

    /* loaded from: classes2.dex */
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
                    a.a(th);
                    j = 0;
                }
                Log.i(TAG, "checkNativeLibraryIntegrity: " + str + ", 27057988, " + j);
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enable_sosize_check");
                if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                    if (GlobalConstants.FILE_SIZE_LIB_ZEUS_WEBVIEW_CHROMIUM != j || j == 0) {
                        mProvider = null;
                        throw new Exception("checkNativeLibraryIntegrity: " + str + ", 27057988, " + j);
                    }
                }
            }
        }
    }

    private static void checkNativeLibraryVersion() throws Throwable {
        String str = mPackageInfo.versionName;
        try {
            String zeusJarVersion = mProvider.getZeusJarVersion();
            String zeusNativeLibraryVersion = mProvider.getZeusNativeLibraryVersion();
            String sdkVersionCode = WebKitFactory.getSdkVersionCode();
            Log.i(TAG, "[checkNativeLibraryVersion] zeus version=" + str + ", zeus jar version=" + zeusJarVersion + ", blink version=" + zeusNativeLibraryVersion);
            if (isVersionMatched(str, zeusNativeLibraryVersion, true) && isVersionMatched(str, zeusJarVersion, true) && isVersionMatched(sdkVersionCode, str, false)) {
                return;
            }
            SevenZipUtils.getInstance().clearTimestamp(d.a(mContext).a.d);
            throw new Exception("sdk and native library dismatch " + str + ", " + zeusJarVersion + ", " + zeusNativeLibraryVersion);
        } catch (Exception e) {
            a.a(e);
            throw new Exception("sdk and zeus jar dismatch " + str + ", " + GlobalConstants.DEFAULT_VERSION);
        }
    }

    private static boolean checkZeusVersion() throws Throwable {
        if (mPackageInfo == null) {
            return false;
        }
        String sdkVersionCode = WebKitFactory.getSdkVersionCode();
        String str = mPackageInfo.versionName;
        Log.i(TAG, "[checkZeusVersion] sdk version=" + sdkVersionCode + ", zeus version=" + str);
        if (isVersionMatched(sdkVersionCode, str, false)) {
            return true;
        }
        File optFile = getOptFile();
        FileUtils.deleteDir(optFile, optFile);
        LoadErrorCode.getInstance().trace(500);
        return false;
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
                            a.a(e);
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
                    a.a(th3);
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

    public static IABTestInterface getAbTestInterface() {
        return mABTestObject;
    }

    public static Context getContext() {
        return mContext;
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

    private static File getOptFile() {
        File file = new File(Build.VERSION.SDK_INT < 21 ? mContext.getDir("zeus", 0) : mContext.getCodeCacheDir(), "engine_code_cache");
        if (!file.exists() && file.mkdirs()) {
            file.setReadable(true, false);
            file.setWritable(true, false);
        }
        return file;
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
            packageInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
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

    public static WebViewFactoryProvider getProvider() {
        if (hasProvider()) {
            return mProvider;
        }
        ZeusPerformanceTiming.initProviderStart();
        synchronized (mProviderLock) {
            if (mProvider != null) {
                return mProvider;
            }
            ZeusCrashHandler.init();
            LoadErrorCode.Statistics.init(getContext());
            if (mContext == null) {
                throw new AndroidRuntimeException("WebViewFactory.setContext must be called before getProvider(), or invoke getProvider() on MainThread.");
            }
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                WebViewFactoryProvider providerImpl = getProviderImpl();
                if (providerImpl != null) {
                    providerImpl.lazyInitialize();
                }
                ZeusPerformanceTiming.initProviderEnd();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return providerImpl;
            } catch (Exception e) {
                throw new AndroidRuntimeException(e);
            }
        }
    }

    private static WebViewFactoryProvider getProviderImpl() {
        boolean shouldUseSystemWebView = shouldUseSystemWebView();
        if (mPackageInfo == null && !shouldUseSystemWebView) {
            fetchDefaultPackageInfo();
            if (mPackageInfo == null && ZeusSDK.usingZeusSDK() && installZesEngineIfNeeded(false)) {
                fetchDefaultPackageInfo();
            }
        }
        if (mPackageInfo != null && !shouldUseSystemWebView) {
            try {
                if (!checkZeusVersion()) {
                    throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + ", " + mPackageInfo.versionName);
                }
                boolean equals = mPackageInfo.packageName.equals(mContext.getPackageName());
                File optFile = getOptFile();
                ZeusPerformanceTiming.newZeusClassLoaderStart();
                ClassLoader classLoader = equals ? WebViewFactory.class.getClassLoader() : new ZeusClassLoader(mPackageInfo.applicationInfo.sourceDir, optFile, mPackageInfo.applicationInfo.nativeLibraryDir, WebViewFactory.class.getClassLoader());
                ZeusPerformanceTiming.newZeusClassLoaderEnd();
                Class<?> loadClass = classLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                d a = d.a(mContext);
                synchronized (d.e) {
                    try {
                        if (a.a.a() && a.b != null) {
                            a.a();
                            a.b.join(15000L);
                            if (!a.b.a) {
                                LoadErrorCode.getInstance().set(102);
                                throw new TimeoutException("unzip task not finished.");
                            }
                            a.b = null;
                        }
                    } catch (Exception e) {
                        LoadErrorCode.getInstance().set(103);
                        throw e;
                    }
                }
                WebViewFactoryProvider webViewFactoryProvider = (WebViewFactoryProvider) loadClass.getMethod("getInstance", null).invoke(null, null);
                mProvider = webViewFactoryProvider;
                if (webViewFactoryProvider != null) {
                    checkNativeLibraryVersion();
                    mEngineType.set(1);
                }
            } catch (Throwable th) {
                mProvider = null;
                LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
            }
        }
        if (mProvider == null) {
            if (mIsInstallUpdate) {
                EngineManager.getInstance().resetZeus();
                EngineManager.getInstance().setNeedKillProcess(true);
            }
            if (LoadErrorCode.getInstance().getInt() == 0) {
                LoadErrorCode.getInstance().set(6, "6:" + shouldUseSystemWebView + "," + (mPackageInfo != null));
            }
            fetchSystemPackageInfo();
            try {
                WebViewFactoryProvider webViewFactoryProvider2 = (WebViewFactoryProvider) Class.forName(SYSTEM_WEBVIEW_FACTORY).getMethod("getInstance", null).invoke(null, null);
                mProvider = webViewFactoryProvider2;
                if (webViewFactoryProvider2 != null) {
                    mEngineType.set(0);
                }
            } catch (Exception e2) {
                mProvider = null;
                LoadErrorCode.Statistics.record();
                throw new AndroidRuntimeException(e2);
            }
        } else if (mIsInstallUpdate) {
            EngineManager.getInstance().setNeedKillProcess(false);
        }
        Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  mProvider = " + mProvider);
        mProvider.createCookieSyncManager(mContext);
        if (LoadErrorCode.getInstance().getInt() != 0) {
            Log.i(TAG, "getProvider error code : " + LoadErrorCode.getInstance().getInt() + " , " + LoadErrorCode.getInstance().getString());
        }
        LoadErrorCode.Statistics.record();
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

    public static boolean hasProvider() {
        return mEngineType.get() != -1;
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
                    public final void run() {
                        try {
                            if (WebViewFactory.isPreInitWebViewEnable() && WebKitFactory.getCurEngine() == 1) {
                                Log.i(WebViewFactory.TAG, "[init bg webview] ");
                                new WebView(WebViewFactory.getContext(), true).destroy();
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
    public static boolean installZesEngineIfNeeded(boolean z) {
        boolean z2 = z && isDebugApk(getContext());
        if (!z || z2) {
            String requestZeusEngine = z2 ? "file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/zeus-engine/zeus-engine.zes" : ZeusSDK.getClient().requestZeusEngine(ZeusSDK.getSDKVersionName());
            if (requestZeusEngine == null || requestZeusEngine.length() == 0) {
                return false;
            }
            File file = new File(requestZeusEngine.substring("file://".length()));
            if (file.exists() && file.isFile()) {
                boolean installSync = EngineManager.getInstance().installSync(requestZeusEngine, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.webkit.sdk.WebViewFactory.1
                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public final void onInstallFinish(int i, String str) {
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public final void onInstallStart() {
                    }
                });
                ZeusSDK.getClient().onInstallFinished(installSync, 0);
                if (z2) {
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
            a.a(e);
            return false;
        }
    }

    public static boolean isPreInitWebViewEnable() {
        IABTestInterface abTestInterface;
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("preinit_webview_enable");
        if ((GetCloudSettingsValue == null || !GetCloudSettingsValue.equalsIgnoreCase("0")) && (abTestInterface = getAbTestInterface()) != null) {
            return abTestInterface.getSwitch("preinit_webview_enable", false);
        }
        return false;
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
        if (z) {
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
    }

    private static boolean shouldUseSystemWebView() {
        boolean z;
        if (sUsingSystemWebView || !WebKitFactory.isPlatformSupported()) {
            LoadErrorCode.getInstance().trace("511:" + sUsingSystemWebView + "," + WebKitFactory.isPlatformSupported() + "," + WebKitFactory.isZeusSupported());
            return true;
        }
        try {
            CloudSettings.restoreSettingsToFrameWork();
        } catch (Throwable th) {
            Log.e(TAG, "restoreSettingsToFrameWork  failed:", th);
        }
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("chromium63_zeus_enable");
        Log.i(TAG, "chromium63_zeus_enable = " + GetCloudSettingsValue);
        if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
            z = true;
        } else {
            LoadErrorCode.getInstance().trace(510);
            z = false;
        }
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean unzip() {
        if (hasProvider()) {
            return false;
        }
        d a = d.a(mContext);
        synchronized (d.e) {
            if (a.b != null && a.a != null) {
                a.a();
            }
        }
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
