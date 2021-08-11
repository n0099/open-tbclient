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
import android.util.AndroidRuntimeException;
import androidx.annotation.RequiresApi;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.ApisInteractWithMario;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.blink.c;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.baidubce.services.vod.VodClient;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class WebViewFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHROMIUM_HOST_APP = "com.baidu.browser.apps";
    public static final String CHROMIUM_LIBS_PATH = "files/zeus/libs";
    public static final String CHROMIUM_WEBVIEW_FACTORY = "com.baidu.zeus.WebViewChromiumFactoryProvider";
    public static final boolean DEBUG = true;
    public static final int INTERN_PACKAGE_INFO_TYPE = 2;
    public static final int NON_EXISTENT_PACKAGE_INFO_TYPE = 0;
    public static final int PACKED_PACKAGE_INFO_TYPE = 1;
    public static final int SHARED_PACKAGE_INFO_TYPE = 3;
    public static final String SPLASH;
    public static final String SYSTEM_WEBVIEW_FACTORY = "com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider";
    public static final String TAG = "WebViewFactory";
    public static final String ZEUS_APK_NAME = "com.baidu.zeus.apk";
    public static final String ZEUS_CONSTANTS_FILE = "com.baidu.zeus.ZeusConstants";
    public static final String ZEUS_LIB_NAME = "libcom.baidu.zeus.so";
    public static final String ZEUS_PACKAGE_NAME_FIELD = "ZEUS_PACKAGE_NAME";
    public static final String ZEUS_VERSION_NAME_FIELD = "ZEUS_VERSION_NAME";
    public static IABTestInterface mABTestObject;
    public static Context mContext;
    public static ICronetListenerInterface mCronetListenerObject;
    public static AtomicInteger mEngineType;
    public static Thread mInitWebViewThread;
    public static boolean mIsInstallUpdate;
    public static boolean mIsZeusProvideInit;
    public static INetProbeInterface mNetProbeObject;
    public static PackageInfo mPackageInfo;
    public static WebViewFactoryProvider mProvider;
    public static final Object mProviderLock;
    public static final Object mZeusProviderLock;
    public static boolean sCloudSettingInit;
    public static String sDataDirectorySuffix;
    public static final boolean sEnableSharedEngine = false;
    public static int sIsPreInitWebViewEnable;
    public static Boolean sIsRendererProcess;
    public static boolean sOptimizedPackageInfoEnabled;
    public static int sPackageInfoType;
    public static String sProcessSuffix;
    public static boolean sProcessSuffixDone;
    public static final Object sProviderLock;
    public static boolean sUsingSystemWebView;
    public static boolean sWebViewDisabled;
    public static boolean sZeusKernelInCurrentPackage;
    public static String sZeusNativeLibraryDir;
    public static String sZeusPackageName;
    public static String sZeusSourceDir;
    public static String sZeusVersionName;
    public static boolean sforceMainProcessNoZeus;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface WebKitUnzipCallback {
        void unzipFinished();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-790008138, "Lcom/baidu/webkit/sdk/WebViewFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-790008138, "Lcom/baidu/webkit/sdk/WebViewFactory;");
                return;
            }
        }
        SPLASH = File.separator;
        mProviderLock = new Object();
        mZeusProviderLock = new Object();
        mEngineType = new AtomicInteger(-1);
        sIsPreInitWebViewEnable = -1;
        sPackageInfoType = 0;
        sProviderLock = new Object();
    }

    public WebViewFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void checkNativeLibraryIntegrity() throws Throwable {
        c.a aVar;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && Build.VERSION.SDK_INT == 19) {
            if (c.a(mContext).f63400a.a()) {
                String str = aVar.f63408d + "libzeuswebviewchromium.so";
                try {
                    j2 = new File(str).length();
                } catch (Throwable th) {
                    th.printStackTrace();
                    j2 = 0;
                }
                Log.i(TAG, "checkNativeLibraryIntegrity: " + str + ", 27057988, " + j2);
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enable_sosize_check");
                if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals("false")) {
                    if (GlobalConstants.FILE_SIZE_LIB_ZEUS_WEBVIEW_CHROMIUM != j2 || j2 == 0) {
                        mProvider = null;
                        throw new Exception("checkNativeLibraryIntegrity: " + str + ", 27057988, " + j2);
                    }
                }
            }
        }
    }

    public static void checkNativeLibraryVersion(PackageInfo packageInfo, WebViewFactoryProvider webViewFactoryProvider) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, packageInfo, webViewFactoryProvider) == null) {
            String str = sOptimizedPackageInfoEnabled ? sZeusVersionName : packageInfo.versionName;
            try {
                String zeusJarVersion = webViewFactoryProvider.getZeusJarVersion();
                String zeusNativeLibraryVersion = webViewFactoryProvider.getZeusNativeLibraryVersion();
                String sdkVersionCode = WebKitFactory.getSdkVersionCode();
                Log.i(TAG, "[checkNativeLibraryVersion] zeus version=" + str + ", zeus jar version=" + zeusJarVersion + ", blink version=" + zeusNativeLibraryVersion);
                if (isVersionMatched(str, zeusNativeLibraryVersion, true) && isVersionMatched(str, zeusJarVersion, true) && isVersionMatched(sdkVersionCode, str, false)) {
                    return;
                }
                SevenZipUtils.getInstance().clearTimestamp(c.a(mContext).f63400a.f63408d);
                throw new Exception("sdk and native library dismatch " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + zeusJarVersion + StringUtil.ARRAY_ELEMENT_SEPARATOR + zeusNativeLibraryVersion);
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new Exception("sdk and zeus jar dismatch " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + "9.0.0.0");
            }
        }
    }

    public static void checkWaitRevertUpdateZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                String sdkVersionCode = WebKitFactory.getSdkVersionCode();
                if (!sdkVersionCode.equalsIgnoreCase(ZeusInitConfigUtils.get(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, sdkVersionCode)) && EngineManager.getInstance().isInstalled() && isMainAppProcess()) {
                    Log.i(EngineManager.LOG_TAG, "checkWaitRevertUpdateZeus 1");
                    c.a(mContext).b();
                    Log.i(EngineManager.LOG_TAG, "checkWaitRevertUpdateZeus 2");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean checkZeusVersion(PackageInfo packageInfo) throws Throwable {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, packageInfo)) == null) {
            String sdkVersionCode = WebKitFactory.getSdkVersionCode();
            if (sOptimizedPackageInfoEnabled) {
                str = sZeusVersionName;
            } else if (packageInfo == null) {
                return false;
            } else {
                str = packageInfo.versionName;
            }
            Log.i(EngineManager.LOG_TAG, "[checkZeusVersion] sdk version=" + sdkVersionCode + ", zeus version=" + str);
            Log.i(TAG, "[checkZeusVersion] sdk version=" + sdkVersionCode + ", zeus version=" + str);
            if (isVersionMatched(sdkVersionCode, str, false)) {
                return true;
            }
            File optFile = getOptFile();
            FileUtils.deleteDir(optFile, optFile);
            LoadErrorCode.getInstance().trace(500);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void disableWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (sProviderLock) {
                if (mProvider != null) {
                    throw new IllegalStateException("Can't disable WebView: WebView already initialized");
                }
                sWebViewDisabled = true;
            }
        }
    }

    public static void fetchDefaultPackageInfo() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, null) == null) || hasProvider()) {
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

    public static PackageInfo fetchPackageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        return (PackageInfo) invokeV.objValue;
    }

    public static void fetchSystemPackageInfo() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || hasProvider()) {
            return;
        }
        mPackageInfo = null;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 20) {
            if (mPackageInfo == null) {
                try {
                    if (i2 > 23) {
                        Method declaredMethod = Class.forName("android.webkit.WebViewFactory").getDeclaredMethod("getWebViewContextAndSetProvider", null);
                        boolean isAccessible = declaredMethod.isAccessible();
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(null, null);
                        declaredMethod.setAccessible(isAccessible);
                        try {
                            mPackageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, null);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        mPackageInfo = mContext.getPackageManager().getPackageInfo((String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, null), 0);
                    }
                } catch (Throwable unused) {
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
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (mPackageInfo == null) {
            PackageInfo packageInfo = new PackageInfo();
            mPackageInfo = packageInfo;
            packageInfo.packageName = "system_webview";
            packageInfo.versionName = "Android" + Build.VERSION.RELEASE + "_webview";
            PackageInfo packageInfo2 = mPackageInfo;
            packageInfo2.versionCode = 0;
            packageInfo2.applicationInfo = new ApplicationInfo();
            ApplicationInfo applicationInfo = mPackageInfo.applicationInfo;
            applicationInfo.sourceDir = "?frameworks.jar";
            applicationInfo.nativeLibraryDir = "/system/lib";
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
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (mIsZeusProvideInit) {
                return true;
            }
            synchronized (mZeusProviderLock) {
                ZeusPerformanceTiming.forceInitT7();
                c.a(mContext).a();
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
                    z = zeusProviderImpl != null;
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                } catch (Exception e2) {
                    throw new AndroidRuntimeException(e2);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean forceNoZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? sforceMainProcessNoZeus : invokeV.booleanValue;
    }

    public static IABTestInterface getAbTestInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? mABTestObject : (IABTestInterface) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? mContext : (Context) invokeV.objValue;
    }

    public static ICronetListenerInterface getCronetListenerInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? mCronetListenerObject : (ICronetListenerInterface) invokeV.objValue;
    }

    public static String getDataDirectorySuffix() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            synchronized (sProviderLock) {
                str = sDataDirectorySuffix;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static PackageInfo getInternPackageInfo(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            Throwable th = null;
            try {
                packageInfo = Class.forName(CHROMIUM_WEBVIEW_FACTORY, false, WebViewFactory.class.getClassLoader()) != null ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0) : null;
            } catch (Throwable th2) {
                th = th2;
                packageInfo = null;
            }
            if (th != null || packageInfo == null) {
                LoadErrorCode.getInstance().set(2, LoadErrorCode.getRootMessage(th));
            }
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getLoadErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? LoadErrorCode.getInstance().getString() : (String) invokeV.objValue;
    }

    public static PackageInfo getLoadedPackageInfo() {
        InterceptResult invokeV;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (mProviderLock) {
                packageInfo = mPackageInfo;
            }
            return packageInfo;
        }
        return (PackageInfo) invokeV.objValue;
    }

    public static INetProbeInterface getNetProbeInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? mNetProbeObject : (INetProbeInterface) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public static File getOptFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (!isRendererProcess() || Build.VERSION.SDK_INT <= 22) {
                File file = new File(Build.VERSION.SDK_INT < 21 ? mContext.getDir(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, 0) : mContext.getCodeCacheDir(), "engine_code_cache");
                if (!file.exists() && file.mkdirs()) {
                    file.setReadable(true, false);
                    file.setWritable(true, false);
                }
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static void getPackageInfoAsync(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65562, null, context, i2) == null) {
            ZeusThreadPoolUtil.execute(new Runnable(context, i2) { // from class: com.baidu.webkit.sdk.WebViewFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ int val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$type = i2;
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x007e A[Catch: Exception -> 0x0082, all -> 0x0088, TRY_LEAVE, TryCatch #1 {Exception -> 0x0082, blocks: (B:15:0x0018, B:27:0x007e, B:22:0x0025, B:23:0x0041, B:24:0x0044, B:25:0x0055), top: B:40:0x0018, outer: #0 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i3;
                    ApplicationInfo applicationInfo;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (WebViewFactory.mProviderLock) {
                            if (WebViewFactory.mPackageInfo != null) {
                                return;
                            }
                            if (this.val$context == null) {
                                return;
                            }
                            PackageInfo packageInfo = null;
                            try {
                                i3 = this.val$type;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (i3 != 1) {
                                if (i3 == 2) {
                                    packageInfo = this.val$context.getPackageManager().getPackageInfo(this.val$context.getPackageName(), 0);
                                } else if (i3 == 3) {
                                    packageInfo = this.val$context.getPackageManager().getPackageArchiveInfo(WebViewFactory.sZeusSourceDir, 0);
                                    packageInfo.applicationInfo.sourceDir = WebViewFactory.sZeusSourceDir;
                                    applicationInfo = packageInfo.applicationInfo;
                                    str = WebViewFactory.sZeusNativeLibraryDir;
                                }
                                if (packageInfo != null) {
                                    PackageInfo unused = WebViewFactory.mPackageInfo = packageInfo;
                                }
                            }
                            packageInfo = this.val$context.getPackageManager().getPackageArchiveInfo(WebViewFactory.sZeusSourceDir, 132);
                            packageInfo.applicationInfo.sourceDir = WebViewFactory.sZeusSourceDir;
                            packageInfo.applicationInfo.publicSourceDir = packageInfo.applicationInfo.sourceDir;
                            applicationInfo = packageInfo.applicationInfo;
                            str = WebViewFactory.sZeusNativeLibraryDir;
                            applicationInfo.nativeLibraryDir = str;
                            if (packageInfo != null) {
                            }
                        }
                    }
                }
            });
        }
    }

    public static PackageInfo getPackedPackageInfo(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Object obj;
        ApplicationInfo applicationInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            Log.i(TAG, "[getPackedPackageInfo] begin ...");
            Throwable th = null;
            try {
                ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                c a2 = c.a(context);
                c.a aVar = a2.f63400a;
                mIsInstallUpdate = false;
                String str2 = applicationInfo2.nativeLibraryDir + SPLASH + "libcom.baidu.zeus.so";
                String downloadLibPath = UtilsBlink.getDownloadLibPath(context);
                if (downloadLibPath != null) {
                    String str3 = downloadLibPath + "libcom.baidu.zeus.so";
                    if (new File(str3).exists() && EngineManager.getInstance().isInstalled()) {
                        mIsInstallUpdate = true;
                        str2 = str3;
                    }
                }
                if (!a2.f63400a.a() && !EngineManager.getInstance().isInstalled()) {
                    LoadErrorCode.getInstance().trace(513);
                }
                packageInfo = context.getPackageManager().getPackageArchiveInfo(str2, 132);
                if (packageInfo != null) {
                    try {
                        packageInfo.applicationInfo.sourceDir = str2;
                        packageInfo.applicationInfo.publicSourceDir = packageInfo.applicationInfo.sourceDir;
                        if (!aVar.a() && !mIsInstallUpdate) {
                            applicationInfo = packageInfo.applicationInfo;
                            str = applicationInfo2.nativeLibraryDir;
                            applicationInfo.nativeLibraryDir = str;
                        }
                        applicationInfo = packageInfo.applicationInfo;
                        str = aVar.f63408d + ":" + applicationInfo2.nativeLibraryDir;
                        applicationInfo.nativeLibraryDir = str;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                packageInfo = null;
            }
            StringBuilder sb = new StringBuilder("[getPackedPackageInfo] finish - ");
            if (th == null) {
                obj = Boolean.valueOf(packageInfo != null);
            } else {
                obj = "exception:" + th.getCause();
            }
            sb.append(obj);
            Log.i(TAG, sb.toString());
            if (th != null || packageInfo == null) {
                LoadErrorCode.getInstance().set(1, LoadErrorCode.getRootMessage(th));
            }
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? getProcessName(mContext, Process.myPid()) : (String) invokeV.objValue;
    }

    public static String getProcessName(Context context, int i2) {
        InterceptResult invokeLI;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65565, null, context, i2)) == null) {
            if (context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i2) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public static String getProcessSuffix(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (sProcessSuffixDone) {
                return sProcessSuffix;
            }
            String processName = getProcessName(context, Process.myPid());
            String str = "context=" + context + ", processName=" + processName;
            if (processName == null) {
                return null;
            }
            int indexOf = processName.indexOf(58);
            String substring = indexOf >= 0 ? processName.substring(indexOf + 1) : null;
            Log.d(TAG, "suffix=".concat(String.valueOf(substring)));
            sProcessSuffix = substring;
            sProcessSuffixDone = true;
            return substring;
        }
        return (String) invokeL.objValue;
    }

    public static WebViewFactoryProvider getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
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
                    if (mContext != null) {
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
                        } catch (Exception e2) {
                            throw new AndroidRuntimeException(e2);
                        }
                    }
                    throw new AndroidRuntimeException("WebViewFactory.setContext must be called before getProvider(), or invoke getProvider() on MainThread.");
                }
            }
        }
        return (WebViewFactoryProvider) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0295 A[Catch: all -> 0x034d, TryCatch #6 {all -> 0x034d, blocks: (B:132:0x028f, B:134:0x0295, B:136:0x02ae, B:138:0x02c9, B:140:0x02d8, B:141:0x02e1, B:143:0x02e7, B:145:0x02ed, B:148:0x02f6, B:149:0x02fd, B:150:0x02fe, B:152:0x0319, B:154:0x031f, B:137:0x02b3, B:155:0x032d, B:156:0x034c), top: B:219:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x032d A[Catch: all -> 0x034d, TryCatch #6 {all -> 0x034d, blocks: (B:132:0x028f, B:134:0x0295, B:136:0x02ae, B:138:0x02c9, B:140:0x02d8, B:141:0x02e1, B:143:0x02e7, B:145:0x02ed, B:148:0x02f6, B:149:0x02fd, B:150:0x02fe, B:152:0x0319, B:154:0x031f, B:137:0x02b3, B:155:0x032d, B:156:0x034c), top: B:219:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WebViewFactoryProvider getProviderImpl() {
        InterceptResult invokeV;
        boolean z;
        PackageInfo packageInfo;
        boolean z2;
        WebViewFactoryProvider webViewFactoryProvider;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        boolean z6;
        int i2;
        WebViewFactoryProvider webViewFactoryProvider2;
        WebViewFactoryProvider webViewFactoryProvider3;
        ClassLoader zeusClassLoader;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
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
                    sb = new StringBuilder("process suffix is null, context=");
                    sb.append(mContext);
                } else {
                    setDataDirectorySuffix(processSuffix);
                    sb = new StringBuilder("set default suffix: ");
                    sb.append(getDataDirectorySuffix());
                }
                sb.toString();
            }
            IABTestInterface iABTestInterface = mABTestObject;
            if (iABTestInterface != null) {
                sOptimizedPackageInfoEnabled = iABTestInterface.getSwitch(ABTestConstants.ZEUS_OPTIMIZED_PACKAGE_INFO_KEY, false);
            }
            if (sOptimizedPackageInfoEnabled) {
                if (mPackageInfo != null || shouldUseSystemWebView) {
                    z3 = false;
                    z4 = false;
                } else {
                    checkWaitRevertUpdateZeus();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
                    z4 = isDefaultPackageInfoExist();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
                    if (z4 || !ZeusSDK.usingZeusSDK()) {
                        z3 = false;
                    } else {
                        z3 = false;
                        if (installZesEngineIfNeeded(false, true)) {
                            z4 = isDefaultPackageInfoExist();
                        }
                    }
                }
                sforceMainProcessNoZeus = z3;
                if (!z4 || shouldUseSystemWebView) {
                    z5 = z4;
                    str = ",";
                } else {
                    try {
                        File optFile = getOptFile();
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                        if (sZeusKernelInCurrentPackage) {
                            zeusClassLoader = WebViewFactory.class.getClassLoader();
                            z5 = z4;
                            str = ",";
                        } else {
                            z5 = z4;
                            str = ",";
                            try {
                                zeusClassLoader = new ZeusClassLoader(sZeusSourceDir, optFile, sZeusNativeLibraryDir, WebViewFactory.class.getClassLoader());
                            } catch (Throwable th) {
                                th = th;
                                webViewFactoryProvider3 = null;
                                mProvider = webViewFactoryProvider3;
                                LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
                                z6 = false;
                                if (!z6) {
                                }
                                if (mEngineType.get() == 1) {
                                }
                                Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  mProvider = " + mProvider);
                                if (!isRendererProcess()) {
                                }
                                if (LoadErrorCode.getInstance().getInt() != 0) {
                                }
                                if (!isRendererProcess()) {
                                }
                                return mProvider;
                            }
                        }
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                        Class<?> loadClass = zeusClassLoader.loadClass(ZEUS_CONSTANTS_FILE);
                        try {
                            sZeusVersionName = (String) loadClass.getField(ZEUS_VERSION_NAME_FIELD).get(null);
                            sZeusPackageName = (String) loadClass.getField(ZEUS_PACKAGE_NAME_FIELD).get(null);
                            Log.i(TAG, "getProviderImpl sZeusVersionName=" + sZeusVersionName + ", sZeusPackageName=" + sZeusPackageName);
                            if (!checkZeusVersion(mPackageInfo)) {
                                throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + StringUtil.ARRAY_ELEMENT_SEPARATOR + sZeusVersionName);
                            }
                            Class<?> loadClass2 = zeusClassLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                            if (!isRendererProcess()) {
                                c.a(mContext).b();
                            }
                            if (Build.VERSION.SDK_INT < 21 && isMainAppProcess() && ZeusInitConfigUtils.get("no_zeus_under_5", false)) {
                                sforceMainProcessNoZeus = true;
                                throw new Exception("disable main process zeus under android 5.0");
                            }
                            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                            webViewFactoryProvider3 = null;
                            try {
                                mProvider = (WebViewFactoryProvider) loadClass2.getMethod("getInstance", null).invoke(null, null);
                                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                                if (mProvider != null && !isRendererProcess()) {
                                    checkNativeLibraryVersion(mPackageInfo, mProvider);
                                    mEngineType.set(1);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                mProvider = webViewFactoryProvider3;
                                LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
                                z6 = false;
                                if (!z6) {
                                }
                                if (mEngineType.get() == 1) {
                                    getPackageInfoAsync(mContext, i2);
                                }
                                Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  mProvider = " + mProvider);
                                if (!isRendererProcess()) {
                                }
                                if (LoadErrorCode.getInstance().getInt() != 0) {
                                }
                                if (!isRendererProcess()) {
                                }
                                return mProvider;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            webViewFactoryProvider3 = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str = ",";
                    }
                }
                z6 = z5;
                if (!z6) {
                    if (mIsInstallUpdate && !sforceMainProcessNoZeus) {
                        EngineManager.getInstance().resetZeus();
                        EngineManager.getInstance().setNeedKillProcess(true);
                    }
                    if (LoadErrorCode.getInstance().getInt() == 0) {
                        LoadErrorCode.getInstance().set(6, "6:" + shouldUseSystemWebView + str + z6);
                    }
                    fetchSystemPackageInfo();
                    try {
                        webViewFactoryProvider2 = null;
                    } catch (Exception e2) {
                        e = e2;
                        webViewFactoryProvider2 = null;
                    }
                    try {
                        WebViewFactoryProvider webViewFactoryProvider4 = (WebViewFactoryProvider) Class.forName(SYSTEM_WEBVIEW_FACTORY).getMethod("getInstance", null).invoke(null, null);
                        mProvider = webViewFactoryProvider4;
                        if (webViewFactoryProvider4 != null) {
                            mEngineType.set(0);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mProvider = webViewFactoryProvider2;
                        if (!isRendererProcess()) {
                            LoadErrorCode.Statistics.record();
                        }
                        throw new AndroidRuntimeException(e);
                    }
                } else if (mIsInstallUpdate) {
                    EngineManager.getInstance().setNeedKillProcess(false);
                }
                if (mEngineType.get() == 1 && (i2 = sPackageInfoType) > 0 && i2 <= 3) {
                    getPackageInfoAsync(mContext, i2);
                }
            } else {
                if (mPackageInfo == null && !shouldUseSystemWebView) {
                    checkWaitRevertUpdateZeus();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
                    fetchDefaultPackageInfo();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
                    if (mPackageInfo == null && ZeusSDK.usingZeusSDK()) {
                        z = false;
                        if (installZesEngineIfNeeded(false, true)) {
                            fetchDefaultPackageInfo();
                        }
                        sforceMainProcessNoZeus = z;
                        packageInfo = mPackageInfo;
                        if (packageInfo != null && !shouldUseSystemWebView) {
                            try {
                                if (checkZeusVersion(packageInfo)) {
                                    throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + StringUtil.ARRAY_ELEMENT_SEPARATOR + mPackageInfo.versionName);
                                }
                                boolean equals = mPackageInfo.packageName.equals(mContext.getPackageName());
                                File optFile2 = getOptFile();
                                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                                ClassLoader classLoader = equals ? WebViewFactory.class.getClassLoader() : new ZeusClassLoader(mPackageInfo.applicationInfo.sourceDir, optFile2, mPackageInfo.applicationInfo.nativeLibraryDir, WebViewFactory.class.getClassLoader());
                                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                                Class<?> loadClass3 = classLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                                if (!isRendererProcess()) {
                                    c.a(mContext).b();
                                }
                                if (Build.VERSION.SDK_INT < 21 && isMainAppProcess() && ZeusInitConfigUtils.get("no_zeus_under_5", false)) {
                                    sforceMainProcessNoZeus = true;
                                    throw new Exception("disable main process zeus under android 5.0");
                                }
                                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                                mProvider = (WebViewFactoryProvider) loadClass3.getMethod("getInstance", null).invoke(null, null);
                                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                                if (mProvider != null && !isRendererProcess()) {
                                    checkNativeLibraryVersion(mPackageInfo, mProvider);
                                    mEngineType.set(1);
                                }
                            } catch (Throwable th5) {
                                Log.e(TAG, "failed to load WebViewChromiumFactoryProvider", th5);
                                mProvider = null;
                                LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th5));
                            }
                        }
                        if (mProvider != null) {
                            if (!mIsInstallUpdate || sforceMainProcessNoZeus) {
                                z2 = true;
                            } else {
                                EngineManager.getInstance().resetZeus();
                                z2 = true;
                                EngineManager.getInstance().setNeedKillProcess(true);
                            }
                            if (LoadErrorCode.getInstance().getInt() == 0) {
                                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                                StringBuilder sb2 = new StringBuilder("6:");
                                sb2.append(shouldUseSystemWebView);
                                sb2.append(",");
                                if (mPackageInfo == null) {
                                    z2 = false;
                                }
                                sb2.append(z2);
                                loadErrorCode.set(6, sb2.toString());
                            }
                            fetchSystemPackageInfo();
                            try {
                                webViewFactoryProvider = null;
                            } catch (Exception e4) {
                                e = e4;
                                webViewFactoryProvider = null;
                            }
                            try {
                                WebViewFactoryProvider webViewFactoryProvider5 = (WebViewFactoryProvider) Class.forName(SYSTEM_WEBVIEW_FACTORY).getMethod("getInstance", null).invoke(null, null);
                                mProvider = webViewFactoryProvider5;
                                if (webViewFactoryProvider5 != null) {
                                    mEngineType.set(0);
                                }
                            } catch (Exception e5) {
                                e = e5;
                                mProvider = webViewFactoryProvider;
                                if (!isRendererProcess()) {
                                    LoadErrorCode.Statistics.record();
                                }
                                throw new AndroidRuntimeException(e);
                            }
                        } else if (mIsInstallUpdate) {
                            EngineManager.getInstance().setNeedKillProcess(false);
                        }
                    }
                }
                z = false;
                sforceMainProcessNoZeus = z;
                packageInfo = mPackageInfo;
                if (packageInfo != null) {
                    if (checkZeusVersion(packageInfo)) {
                    }
                }
                if (mProvider != null) {
                }
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
        return (WebViewFactoryProvider) invokeV.objValue;
    }

    public static PackageInfo getSharedPackageInfo(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
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
            }
            if (th != null || packageInfo == null) {
                LoadErrorCode.getInstance().set(3, LoadErrorCode.getRootMessage(th));
            }
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getZeusNativeLibraryDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? sZeusNativeLibraryDir : (String) invokeV.objValue;
    }

    public static String getZeusPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? sZeusPackageName : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WebViewFactoryProvider getZeusProviderImpl() {
        InterceptResult invokeV;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            if (!sUsingSystemWebView) {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
            }
            boolean shouldUseSystemWebView = shouldUseSystemWebView(true);
            if (!sUsingSystemWebView) {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_CHECK_USE_T7);
            }
            WebViewFactoryProvider webViewFactoryProvider = null;
            if (shouldUseSystemWebView) {
                packageInfo = null;
            } else {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
                packageInfo = fetchPackageInfo();
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_FETCH_PACKAGE_INFO);
            }
            if (packageInfo != null && !shouldUseSystemWebView) {
                try {
                    if (!checkZeusVersion(packageInfo)) {
                        throw new Exception("sdk and zeus dismatch " + WebKitFactory.getSdkVersionCode() + StringUtil.ARRAY_ELEMENT_SEPARATOR + packageInfo.versionName);
                    }
                    boolean equals = packageInfo.packageName.equals(mContext.getPackageName());
                    File optFile = getOptFile();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                    ClassLoader classLoader = equals ? WebViewFactory.class.getClassLoader() : new ZeusClassLoader(packageInfo.applicationInfo.sourceDir, optFile, packageInfo.applicationInfo.nativeLibraryDir, WebViewFactory.class.getClassLoader());
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_NEW_ZEUS_CL);
                    Class<?> loadClass = classLoader.loadClass(CHROMIUM_WEBVIEW_FACTORY);
                    if (!isRendererProcess()) {
                        c.a(mContext).b();
                    }
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                    WebViewFactoryProvider webViewFactoryProvider2 = (WebViewFactoryProvider) loadClass.getMethod("getInstance", null).invoke(null, null);
                    try {
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_T7_CHROMIUM_PROVIDER_INIT);
                        if (webViewFactoryProvider2 != null) {
                            checkNativeLibraryVersion(packageInfo, webViewFactoryProvider2);
                        }
                        webViewFactoryProvider = webViewFactoryProvider2;
                    } catch (Throwable th) {
                        th = th;
                        webViewFactoryProvider = webViewFactoryProvider2;
                        LoadErrorCode.getInstance().set(4, LoadErrorCode.getRootMessage(th));
                        Log.i(TAG, "**** getProvider end, sys = " + shouldUseSystemWebView + "  zeusProvider = " + webViewFactoryProvider);
                        if (webViewFactoryProvider != null) {
                        }
                        if (LoadErrorCode.getInstance().getInt() != 0) {
                        }
                        LoadErrorCode.Statistics.record();
                        return webViewFactoryProvider;
                    }
                } catch (Throwable th2) {
                    th = th2;
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
        return (WebViewFactoryProvider) invokeV.objValue;
    }

    public static String getZeusSourceDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? sZeusSourceDir : (String) invokeV.objValue;
    }

    public static String getZeusVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? sZeusVersionName : (String) invokeV.objValue;
    }

    public static void handleTaskAfterWebkitInited() {
        WebViewFactoryProvider webViewFactoryProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, null) == null) || (webViewFactoryProvider = mProvider) == null) {
            return;
        }
        webViewFactoryProvider.commonInitialize();
        if (isRendererProcess()) {
            return;
        }
        if (mABTestObject != null) {
            mProvider.onABTestReady();
        }
        mProvider.lazyInitialize();
    }

    public static boolean hasProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? mEngineType.get() != -1 : invokeV.booleanValue;
    }

    public static void initCloudSetting() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65577, null) == null) || sCloudSettingInit) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
    }

    public static void initWebViewInBackgroundThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, null) == null) {
            synchronized (WebViewFactory.class) {
                if (mInitWebViewThread == null) {
                    Thread thread = new Thread(new Runnable() { // from class: com.baidu.webkit.sdk.WebViewFactory.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    boolean z = true;
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
                                    Log.i(WebViewFactory.TAG, "[init webview] exception =".concat(String.valueOf(th)));
                                }
                            }
                        }
                    }, "T7@initBaiduWebView");
                    mInitWebViewThread = thread;
                    thread.start();
                }
            }
        }
    }

    @RequiresApi(api = 8)
    public static boolean installZesEngineIfNeeded(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = z && isDebugApk(getContext());
            if (!z || z3) {
                String str = null;
                if (z3 && !z2 && (context = mContext) != null) {
                    File externalFilesDir = context.getExternalFilesDir("");
                    if (externalFilesDir != null) {
                        str = "file://" + externalFilesDir.getAbsolutePath() + "/zeus-engine-debug/zeus-engine.zes";
                    }
                } else if (z2) {
                    str = ZeusSDK.getClient().requestZeusEngine(ZeusSDK.getSDKVersionName());
                }
                if (str != null && str.length() != 0) {
                    File file = new File(str.substring(7));
                    if (file.exists() && file.isFile()) {
                        boolean installSync = EngineManager.getInstance().installSync(str, new WebKitFactory.WebkitInstallListener() { // from class: com.baidu.webkit.sdk.WebViewFactory.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                            public void onInstallFinish(int i2, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                }
                            }

                            @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                            public void onInstallStart() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                }
                            }
                        });
                        ZeusSDK.getClient().onInstallFinished(installSync, 0);
                        if (z3) {
                            File file2 = new File(str.substring(7));
                            if (file2.exists() && file2.isFile()) {
                                file2.delete();
                            }
                        }
                        return installSync;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isDebugApk(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    return (applicationInfo.flags & 2) != 0;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isDefaultPackageInfoExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            if (hasProvider()) {
                return true;
            }
            boolean isPackedPackageInfoExist = isPackedPackageInfoExist(mContext);
            if (!isPackedPackageInfoExist) {
                isPackedPackageInfoExist = isInternPackageInfoExist(mContext);
            }
            Log.i(TAG, "isDefaultPackageInfoExist sourceDir=" + sZeusSourceDir + ", nativeLibraryDir=" + sZeusNativeLibraryDir);
            return isPackedPackageInfoExist;
        }
        return invokeV.booleanValue;
    }

    public static boolean isForceZeusProviderInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? mIsZeusProvideInit : invokeV.booleanValue;
    }

    public static boolean isInternPackageInfoExist(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            boolean z = false;
            try {
                if (Class.forName(CHROMIUM_WEBVIEW_FACTORY, false, WebViewFactory.class.getClassLoader()) != null) {
                    sZeusKernelInCurrentPackage = true;
                    sZeusSourceDir = context.getApplicationInfo().sourceDir;
                    sZeusNativeLibraryDir = context.getApplicationInfo().nativeLibraryDir;
                    sPackageInfoType = 2;
                    z = true;
                }
                th = null;
            } catch (Throwable th) {
                th = th;
                sZeusKernelInCurrentPackage = false;
            }
            if (th != null || !z) {
                LoadErrorCode.getInstance().set(2, LoadErrorCode.getRootMessage(th));
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMainAppProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? getProcessSuffix(mContext) == null : invokeV.booleanValue;
    }

    public static boolean isMediaProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                String processSuffix = getProcessSuffix(mContext);
                if (processSuffix != null) {
                    return processSuffix.indexOf(VodClient.PATH_MEDIA) >= 0;
                }
                return false;
            } catch (Exception e2) {
                Log.e(TAG, "failed to get process info", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptimizedPackageInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? sOptimizedPackageInfoEnabled : invokeV.booleanValue;
    }

    public static boolean isPackedPackageInfoExist(Context context) {
        InterceptResult invokeL;
        Object obj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            Log.i(TAG, "[isPackedPackageInfoExist] begin ...");
            boolean z = false;
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                c a2 = c.a(context);
                c.a aVar = a2.f63400a;
                mIsInstallUpdate = false;
                String str2 = applicationInfo.nativeLibraryDir + SPLASH + "libcom.baidu.zeus.so";
                String downloadLibPath = UtilsBlink.getDownloadLibPath(context);
                if (downloadLibPath != null) {
                    String str3 = downloadLibPath + "libcom.baidu.zeus.so";
                    if (new File(str3).exists() && EngineManager.getInstance().isInstalled()) {
                        mIsInstallUpdate = true;
                        str2 = str3;
                    }
                }
                if (!a2.f63400a.a() && !EngineManager.getInstance().isInstalled()) {
                    LoadErrorCode.getInstance().trace(513);
                }
                if (str2 != null && new File(str2).exists()) {
                    sZeusSourceDir = str2;
                    if (!aVar.a() && !mIsInstallUpdate) {
                        str = applicationInfo.nativeLibraryDir;
                        sZeusNativeLibraryDir = str;
                        sPackageInfoType = 1;
                        z = true;
                    }
                    str = aVar.f63408d + ":" + applicationInfo.nativeLibraryDir;
                    sZeusNativeLibraryDir = str;
                    sPackageInfoType = 1;
                    z = true;
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            StringBuilder sb = new StringBuilder("[isPackedPackageInfoExist] finish - ");
            if (th == null) {
                obj = Boolean.valueOf(z);
            } else {
                obj = "exception:" + th.getCause();
            }
            sb.append(obj);
            Log.i(TAG, sb.toString());
            if (th != null || !z) {
                LoadErrorCode.getInstance().set(1, LoadErrorCode.getRootMessage(th));
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPreInitWebViewEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
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
        return invokeV.booleanValue;
    }

    public static boolean isRendererProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            Boolean bool = sIsRendererProcess;
            if (bool == null) {
                boolean z = false;
                boolean z2 = true;
                try {
                    String processSuffix = getProcessSuffix(mContext);
                    if (processSuffix != null) {
                        if (processSuffix.indexOf(WebViewRendererService.RENDER_SERVICE_PROCESS_NAME_SUFFIX) >= 0) {
                            z = true;
                        }
                    }
                    z2 = z;
                } catch (Exception e2) {
                    Log.w(TAG, "failed to get process info", e2);
                }
                sIsRendererProcess = Boolean.valueOf(z2);
                return z2;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean isSharedPackageInfoExist(Context context) {
        InterceptResult invokeL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            boolean z = false;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(CHROMIUM_HOST_APP, 128);
            } catch (Throwable th) {
                th = th;
            }
            if (applicationInfo.metaData == null || applicationInfo.metaData.getString("zeus.engine") == null) {
                throw new AndroidRuntimeException("no metaData about shared-engine");
            }
            String str = applicationInfo.dataDir + "/" + applicationInfo.metaData.getString("zeus.engine");
            if (str != null && new File(str).exists()) {
                sZeusSourceDir = str;
                sZeusNativeLibraryDir = applicationInfo.dataDir + "/files/zeus/libs/:" + applicationInfo.nativeLibraryDir;
                sPackageInfoType = 3;
                z = true;
            }
            th = null;
            if (th != null || !z) {
                LoadErrorCode.getInstance().set(3, LoadErrorCode.getRootMessage(th));
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSwanProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            try {
                String processSuffix = getProcessSuffix(mContext);
                if (processSuffix != null) {
                    return processSuffix.indexOf("swan") >= 0;
                }
                return false;
            } catch (Exception e2) {
                Log.e(TAG, "failed to get process info", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isVersionMatched(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65593, null, str, str2, z)) == null) {
            boolean z2 = false;
            if (str != null && str2 != null) {
                int[] iArr = {0, 0, 0, 0};
                int[] iArr2 = {0, 0, 0, 0};
                try {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                    iArr[2] = Integer.parseInt(split[2]);
                    iArr[3] = Integer.parseInt(split[3]);
                    iArr2[0] = Integer.parseInt(split2[0]);
                    iArr2[1] = Integer.parseInt(split2[1]);
                    iArr2[2] = Integer.parseInt(split2[2]);
                    iArr2[3] = Integer.parseInt(split2[3]);
                } catch (Throwable unused) {
                }
                if (iArr[0] != 0 && iArr2[0] != 0) {
                    boolean z3 = iArr[0] == iArr2[0] && iArr[1] == iArr2[1] && iArr[2] == iArr2[2];
                    boolean z4 = z3 && iArr[3] == iArr2[3];
                    if (z3 && iArr[3] <= iArr2[3]) {
                        z2 = true;
                    }
                    if (z) {
                        return z4;
                    }
                }
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean isZeusKernelInCurrentPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? sZeusKernelInCurrentPackage : invokeV.booleanValue;
    }

    public static boolean isZeusProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? mEngineType.get() == 1 : invokeV.booleanValue;
    }

    public static void revertUpdateZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, null) == null) {
            try {
                if (EngineManager.getInstance().isInstalled()) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_REVERT_DOWNLOAD_ZEUS);
                    EngineManager.getInstance().resetZeus();
                    EngineManager.getInstance().removeUnusedFiles(WebKitFactory.getContext());
                    EngineManager.getInstance().removeOldStatisticsFiles(WebKitFactory.getContext());
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_REVERT_DOWNLOAD_ZEUS);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setAbTestInterface(IABTestInterface iABTestInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, iABTestInterface) == null) {
            mABTestObject = iABTestInterface;
        }
    }

    public static void setCronetListenerInterface(ICronetListenerInterface iCronetListenerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, null, iCronetListenerInterface) == null) {
            Log.i(TAG, "setCronetListernerInterface ".concat(String.valueOf(iCronetListenerInterface)));
            mCronetListenerObject = iCronetListenerInterface;
        }
    }

    public static void setDataDirectorySuffix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, null, str) == null) {
            synchronized (sProviderLock) {
                if (mProvider != null) {
                    throw new IllegalStateException("Can't set data directory suffix: WebView already initialized");
                }
                if (str.indexOf(File.separatorChar) >= 0) {
                    throw new IllegalArgumentException("Suffix " + str + " contains a path separator");
                }
                sDataDirectorySuffix = str;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    android.webkit.WebView.setDataDirectorySuffix(str);
                } catch (Throwable th) {
                    Log.e(TAG, "Failed to set data directory suffix:", th);
                }
            }
        }
    }

    public static void setNetProbeInterface(INetProbeInterface iNetProbeInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65600, null, iNetProbeInterface) == null) {
            Log.i(TAG, "setNetProbeInterface ".concat(String.valueOf(iNetProbeInterface)));
            mNetProbeObject = iNetProbeInterface;
        }
    }

    public static boolean setPackageInfo(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, packageInfo)) == null) {
            synchronized (mProviderLock) {
                if (mProvider != null) {
                    throw new AndroidRuntimeException("cannot setPackageInfo while provider is loaded.");
                }
                mPackageInfo = packageInfo;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void setUseSystemWebView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65602, null, z) == null) {
            sUsingSystemWebView = z;
        }
    }

    public static void setUsingLzma(Context context, boolean z, WebKitUnzipCallback webKitUnzipCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65603, null, new Object[]{context, Boolean.valueOf(z), webKitUnzipCallback}) == null) {
            final c a2 = c.a(context);
            a2.f63400a.a(z);
            if (!z || isRendererProcess()) {
                return;
            }
            synchronized (c.f63397e) {
                if (context != null) {
                    if (a2.f63400a != null && a2.f63401b == null) {
                        a2.f63401b = new c.b(a2, context);
                    }
                }
            }
            synchronized (c.f63397e) {
                if (a2.f63402c != webKitUnzipCallback) {
                    a2.f63402c = webKitUnzipCallback;
                    if (a2.f63403d == null) {
                        a2.f63403d = new Handler(Looper.getMainLooper());
                    }
                    a2.f63403d.postDelayed(new Runnable(a2) { // from class: com.baidu.webkit.internal.blink.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f63404a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f63404a = a2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                synchronized (c.f63399g) {
                                    if (this.f63404a.f63402c != null) {
                                        this.f63404a.f63402c.unzipFinished();
                                        this.f63404a.f63402c = null;
                                    }
                                }
                            }
                        }
                    }, 15000L);
                }
            }
        }
    }

    public static boolean shouldUseSystemWebView(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65604, null, z)) == null) {
            if ((sUsingSystemWebView && !z) || !WebKitFactory.isPlatformSupported()) {
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                loadErrorCode.trace("511:" + sUsingSystemWebView + "," + WebKitFactory.isPlatformSupported() + "," + WebKitFactory.isZeusSupported());
                return true;
            }
            initCloudSetting();
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("chromium63_zeus_enable");
            Log.i(TAG, "chromium63_zeus_enable = ".concat(String.valueOf(GetCloudSettingsValue)));
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase().equals("false")) {
                z2 = true;
            } else {
                LoadErrorCode.getInstance().trace(510);
                z2 = false;
            }
            IABTestInterface abTestInterface = getAbTestInterface();
            if (abTestInterface != null && abTestInterface.getSwitch(ABTestConstants.T7_V10_BLACK_LIST, false)) {
                String[] strArr = {"MI 6X", "MI 6X MIKU", "REDMI NOTE 5", "REDMI NOTE 7", "V1814A", "V1814T", "V1816A", "V1816T", "VIVO X21", "VIVO X21A", "VIVO X21UD", "VIVO X21UD A", "VIVO Z3X"};
                for (int i2 = 0; i2 < 13; i2++) {
                    if (strArr[i2].equals(Build.MODEL.toUpperCase())) {
                        LoadErrorCode.getInstance().trace(515);
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            Log.i(TAG, "shouldUseSystemWebView isHitTarget = ".concat(String.valueOf(z3)));
            return !z2 || z3;
        }
        return invokeZ.booleanValue;
    }

    public static void startBrowserProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65605, null) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.webkit.sdk.WebViewFactory.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebViewFactory.startBrowserProcess();
                        }
                    }
                });
                return;
            }
            try {
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("zeus_init_opt_enable");
                if ((GetCloudSettingsValue == null || !GetCloudSettingsValue.equalsIgnoreCase("false")) && hasProvider()) {
                    Log.i(GlobalConstants.LOG_PER_TAG, " startBrowserProcessBackground from API");
                    getProvider().startBrowserProcess(true);
                }
            } catch (Throwable th) {
                Log.i(GlobalConstants.LOG_PER_TAG, "[startBrowserProcess] exception =".concat(String.valueOf(th)));
            }
        }
    }

    public static boolean unzip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            boolean z = false;
            if (hasProvider()) {
                return false;
            }
            initCloudSetting();
            IABTestInterface abTestInterface = getAbTestInterface();
            boolean z2 = abTestInterface != null ? abTestInterface.getSwitch(ABTestConstants.SHOULD_RESET_DOWNLOAD_ZEUS, false) : false;
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("should_reset_download_zeus");
            if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("true")) {
                z = true;
            }
            Log.i("revertUpdateZeus", "in WebViewFactory.unzip, cloud: " + z + " | ab: " + z2 + " | hotfix: false");
            if (isMainAppProcess() && (z2 || z)) {
                revertUpdateZeus();
            }
            c.a(mContext).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean unzipOnAppStart(Context context, boolean z, boolean z2, WebKitUnzipCallback webKitUnzipCallback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65607, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), webKitUnzipCallback})) == null) {
            if (z2 || !z || context == null) {
                return false;
            }
            if (mContext == null) {
                mContext = context.getApplicationContext();
            }
            setUsingLzma(context, true, webKitUnzipCallback);
            return unzip();
        }
        return invokeCommon.booleanValue;
    }
}
