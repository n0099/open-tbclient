package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CpuInfo;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.internal.daemon.JsUploadTask;
import com.baidu.webkit.internal.daemon.Statistics;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.resource.ResourceSchedulerEngine;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.internal.utils.b;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.dumper.ZwDebug;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public final class WebKitFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARCH_ARM = "armv";
    public static final int ARCH_ARM_INT = 7;
    public static final int DEFAULT_INIT = 0;
    public static final int ENGINE_BLINK = 1;
    public static final int ENGINE_INVALID = -1;
    public static final int ENGINE_ORIGINAL = 0;
    public static final int FORCE_INIT_STATE_DEFAULT = 0;
    public static final int FORCE_INIT_STATE_FINISH = 2;
    public static final int FORCE_INIT_STATE_START = 1;
    public static final int FORCE_INIT_ZEUS = 1;
    public static final int FORCE_INIT_ZEUS_BY_USER = 2;
    public static final String OS_64 = "64";
    public static final String OS_ARCH = "os.arch";
    public static final String PROCESS_TYPE_BROWSER = "3";
    public static final String PROCESS_TYPE_RENDERER = "2";
    public static final String PROCESS_TYPE_SINGLE_PROCESS = "0";
    public static final String PROCESS_TYPE_SWAN = "1";
    public static final String PROCESS_TYPE_UNKOWN = "-1";
    public static final String START_UP_RECORD_PATH = "start_up_record.dat";
    public static final String TAG = "WebKitFactory";
    public static final String X64_BL = "asus_t00i,asus_t00q,asus_t00j,asus_t00k,asus_t00g,asus_z002,asus_z007,asus_z00d,asus_z008d,asus_z00ad,asus_z00adb,lenovoyt3-x90f,mipad2";
    public static DelayedInitTask mDelayedInitTask = null;
    public static int mInitWebkitType = 0;
    public static JsUploadTask mJavaScriptInterface = null;
    public static ArrayList<IForceInitZeusListener> mListenerLst = null;
    public static FileLock mLock = null;
    public static String sAppId = null;
    public static String sAppVersion = null;
    public static String sCUID = "0";
    public static String sCrashCallback = null;
    public static String sDumpCopyDir = null;
    public static String sEmulator = null;
    public static boolean sEnableIntegratedCrashpad = true;
    public static SwitchState sEnableMultipleProcess = null;
    public static Object sForceInitLock = null;
    public static boolean sForceInitResult = false;
    public static volatile int sForceInitedState = 0;
    public static int sHashSign = 0;
    public static int sHttpCacheMbSize = -1;
    public static volatile boolean sInited = false;
    public static volatile boolean sIsNeedDownloadCloudResource = true;
    public static volatile boolean sIsWebKitBuiltin = false;
    public static String sKernelSessionId = null;
    public static volatile String sLoadPath = null;
    public static long sPageStartTimeStamp = 0;
    public static String sProcessType = null;
    public static String sSearchId = null;
    public static int sStartUpFreq = -1;
    public static String sStatisticsSessionId = null;
    public static HashMap<String, String> sUploadParams = null;
    public static volatile boolean sUserPrivacyConfirm = true;
    public static WebKitClient sWebKitClient = null;
    public static String sZID = null;
    public static boolean sZeusSupported = true;
    public static boolean sZeusSupportedLoaded;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class DelayedInitTask extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mResult;

        public DelayedInitTask(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mResult = z;
        }

        private void checkRetryInstallZeus() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                String retryInstallZeusPath = EngineManager.getInstance().getRetryInstallZeusPath();
                if (TextUtils.isEmpty(retryInstallZeusPath)) {
                    return;
                }
                if (!EngineManager.getInstance().checkRetryInstallZeus()) {
                    EngineManager.getInstance().resetRetryInstallZeus();
                    return;
                }
                Log.i(EngineManager.LOG_TAG, " checkRetryInstallZeus start ");
                if (!retryInstallZeusPath.startsWith("file://")) {
                    retryInstallZeusPath = "file://".concat(String.valueOf(retryInstallZeusPath));
                }
                WebKitFactory.installAsync(retryInstallZeusPath, new WebkitInstallListener(this) { // from class: com.baidu.webkit.sdk.WebKitFactory.DelayedInitTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DelayedInitTask this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallFinish(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            Log.i(EngineManager.LOG_TAG, " RetryInstallZeus onInstallFinish");
                        }
                    }

                    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
                    public void onInstallStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            Log.i(EngineManager.LOG_TAG, " RetryInstallZeus onInstallStart");
                        }
                    }
                });
            }
        }

        private void checkUpdateZeusVersion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                String sdkVersionName = WebKitFactory.getSdkVersionName();
                if (sdkVersionName.equalsIgnoreCase(ZeusInitConfigUtils.get("sdk_version", ""))) {
                    return;
                }
                ZeusInitConfigUtils.set("sdk_version", sdkVersionName);
            }
        }

        private void doInitStatistics() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                try {
                    String str = WebKitFactory.getContext().getFilesDir().getCanonicalPath() + "/zeus/statistics/";
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str2 = "[[19, \"aosmith.com.cn\", \"aosmith.com.cn/query=\", \"/lookup.dll\", 1, \"AST=.*\", 88715],[20, \"028hk.net\", \"028hk.net/option.php\\\\?\", \"/search.htm\", 0, \"\", 89519],[21, \"ssk.com.cn\", \"ssk.com.cn/mongo.*\", \"/InfoCheck\", 0, \"\", 58003],[31, \"m.baidu.com\", \"m.biadu.com/baike\", \"/CH/webid=\", 0, \"\", 44232],[221, \"youth.net\", \"youth.net/newsid=.*\", \"newstitle=\", 0, \"\", 69022],[34, \"weiphone.com\", \"weiphone.com/bbs\", \"postid=\", 0, \"\", 21802],[41, \"ymyjy.com\", \"ymyjy.com/daily.*\", \"searchitem=.*\", 0, \"\", 39800],[1, \"kuaishang.com.cn\", \"kuaishang.com.cn/bs/im.htm\", \"/msg.htm\", 0, \"\", 31125],[4, \"eic.org.cn\", \"/chatClient/chatbox.jsp\", \"/ChaterServer\\\\?cmd=203.*&msgContent=\", 0, \" \", 99233],[14, \"gaodun.com\", \"/LR/Chatpre.aspx\\\\?\", \"/LR/CdCheck.aspx\", 1, \"_text=%2CACT_TEMP%7C0%7C%2C\", 56423],[2, \"meiqia.com\", \"meiqia.com/widget/phone/index.html\",\"meiqia.com/mobile/sendMsg\", 0, \" \", 52398], [3, \"qiao.baidu.com\", \"qiao.baidu.com/im/index\\\\?siteid\", \"qiao.baidu.com/communicate\\\\?\", 0, \" \", 86929], [5, \"looyu.com\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 98323], [51, \"talk99.cn\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 15720], [52, \"looyuoms.com\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 15720],[6, \"tq.cn\", \"tq.cn/sendmain.jsp\\\\?\", \"tq.cn/sendmsg.jsp\\\\?.*&msg=[^&]*&type_code=\", 0, \" \", 97521],[11, \"53kf.com\", \"53kf.com/m.php\\\\?cid\", \"53kf.com/sendmsg.jsp\\\\?_=\", 1, \"QST\", 32100],[13, \"zoosnet.net\", \"/LR/Chatpre.aspx\\\\?\", \"/LR/CdCheck.aspx\", 1, \"_text=%2C.\\\\{1,\\\\}&lng=\", 42083],[222, \"linking.baidu.com\", \"linking.baidu.com/actionads/*\", \"linking.baidu.com/communicate?*\", 0, \"\", 12945]]";
                    File file2 = new File(WebKitFactory.getContext().getCacheDir(), "phoenix.dudu");
                    if (file2.exists()) {
                        byte[] bArr = null;
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        if (fileInputStream.available() > 0) {
                            bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                        }
                        fileInputStream.close();
                        str2 = new String(bArr, "utf-8");
                    }
                    Statistics.init(str + "error.log", str + "phoenix_ad.log", str2);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public void doDelayedTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    WebKitFactory.setAppidJs(WebKitFactory.getAppIdString());
                    WebKitFactory.setAppVersionJs(WebKitFactory.getAppVersionString());
                    WebKitFactory.setCuidJs(WebKitFactory.getCUIDString());
                    WebKitFactory.setCpuTypeJs(CpuInfo.getCpuInfoString());
                    WebKitFactory.setSdkVerJs(WebKitFactory.getSdkVersionName());
                    WebKitFactory.setStatisticsSessionIdJs(WebKitFactory.getStatisticsSessionId());
                    WebKitFactory.getZeusInitModeOptABValue();
                    if (this.mResult) {
                        WebKitFactory.setZeusVerJs(WebKitFactory.getZeusVersionName());
                        WebSettingsGlobalBlink.setAppId(WebKitFactory.getAppIdString());
                        WebSettingsGlobalBlink.setCuid(WebKitFactory.getCUIDString());
                        WebSettingsGlobalBlink.setSendEngineUsageInfoEnabled(true);
                        ZeusWebViewPreloadClass.getInstance().preloadZeusWebViewClasses(WebViewFactory.getProvider().getClass().getClassLoader());
                        WebViewFactory.getProvider().preInitWebView();
                    } else {
                        ZeusWebViewPreloadClass.getInstance().destroy();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    WebViewFactory.getProvider().initPageCacheCounts(WebViewFactory.getContext());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                WebViewFactory.isZeusProvider();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Process.setThreadPriority(10);
                WebKitFactory.lockUpdateZeus();
                WebKitFactory.forceInitZeusInternal();
                WebKitFactory.unLockUpdateZeus();
                if (WebViewFactory.isMainAppProcess()) {
                    checkRetryInstallZeus();
                    checkUpdateZeusVersion();
                }
                doDelayedTask();
                WebViewFactory.handleTaskAfterWebkitInited();
                ResourceSchedulerEngine.getInstance().fetchIntegrationInfoFromServer();
                if (WebKitFactory.getNeedDownloadCloudResource()) {
                    Log.w(WebKitFactory.TAG, "CloudSettings.tryToUpdateCloudSettings");
                    CloudSettings.tryToUpdateCloudSettings(WebViewFactory.getContext());
                    Log.e(WebKitFactory.TAG, "StartUpFreq: " + WebKitFactory.getStartUpFreq());
                } else {
                    Log.w(WebKitFactory.TAG, "CloudSettings.restoreLastSentTimeFromCfg");
                    CloudSettings.restoreLastSentTimeFromCfg();
                }
                if (!WebSettingsGlobalBlink.getHttpDnsUpdateEnabled() && (WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) == null || !WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false"))) {
                    HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
                }
                Context context = WebViewFactory.getContext();
                String str = V8Engine.ALTERNATIVE_CACHE_PATH;
                if (WebViewFactory.getDataDirectorySuffix() != null) {
                    str = V8Engine.ALTERNATIVE_CACHE_PATH + "_" + WebViewFactory.getDataDirectorySuffix();
                }
                ZeusLogUploader.UploadLogDirectory(context.getDir(str, 0).getPath() + "/nr/", "nrlog", true, null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface IForceInitZeusListener {
        @Keep
        void onForceInitZeusFinish(boolean z);

        @Keep
        void onForceInitZeusStart();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SwitchState {
        public static final /* synthetic */ SwitchState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchState Invalid;
        public static final SwitchState Off;
        public static final SwitchState On;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2084548366, "Lcom/baidu/webkit/sdk/WebKitFactory$SwitchState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2084548366, "Lcom/baidu/webkit/sdk/WebKitFactory$SwitchState;");
                    return;
                }
            }
            Invalid = new SwitchState("Invalid", 0);
            On = new SwitchState("On", 1);
            SwitchState switchState = new SwitchState("Off", 2);
            Off = switchState;
            $VALUES = new SwitchState[]{Invalid, On, switchState};
        }

        public SwitchState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SwitchState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwitchState) Enum.valueOf(SwitchState.class, str) : (SwitchState) invokeL.objValue;
        }

        public static SwitchState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwitchState[]) $VALUES.clone() : (SwitchState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface WebkitInstallListener {
        public static final int RET_CANCELED = 3;
        public static final int RET_FAILED_ALREADY_RUNNING = 8;
        public static final int RET_FAILED_INVALID_ARCHIVE = 6;
        public static final int RET_FAILED_INVALID_PATCH_ARCHIVE = 11;
        public static final int RET_FAILED_INVALID_PATCH_FILE = 12;
        public static final int RET_FAILED_INVALID_WEBKIT = 7;
        public static final int RET_FAILED_NETWORK = 5;
        public static final int RET_FAILED_OTHERS = 13;
        public static final int RET_FAILED_STORAGE_IO = 4;
        public static final int RET_ILLEGAL_ARGUMENTS = 10;
        public static final int RET_NEW_PACKAGE_INSTALLED = 0;
        public static final int RET_NO_CORRESPONDING_PACKAGE = 9;
        public static final int RET_NO_NEW_PACKAGE = 1;
        public static final int RET_STOPPED = 2;

        void onInstallFinish(int i2, String str);

        void onInstallStart();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(401987815, "Lcom/baidu/webkit/sdk/WebKitFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(401987815, "Lcom/baidu/webkit/sdk/WebKitFactory;");
                return;
            }
        }
        sForceInitLock = new Object();
        sEnableMultipleProcess = SwitchState.Invalid;
    }

    public WebKitFactory() {
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

    public static String[] GetKernelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Log.i("CRASHPAD", "WebkitFactory.GetKernelInfo");
            WebViewFactoryProvider provider = WebViewFactory.getProvider();
            if (provider == null || getCurEngine() != 1) {
                return new String[0];
            }
            String[] GetKernelInfo = provider.GetKernelInfo();
            if (GetKernelInfo == null || GetKernelInfo.length == 0) {
                return new String[0];
            }
            String checkProcessType = checkProcessType();
            if (checkProcessType != null && !checkProcessType.isEmpty()) {
                GetKernelInfo[8] = checkProcessType;
            }
            return GetKernelInfo;
        }
        return (String[]) invokeV.objValue;
    }

    public static Object JavascriptInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JsUploadTask jsUploadTask = mJavaScriptInterface;
            if (jsUploadTask != null) {
                return jsUploadTask;
            }
            Log.w(TAG, "mJavaScriptInterface = null");
            return null;
        }
        return invokeV.objValue;
    }

    public static void RecordUrl(String str) {
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || (provider = WebViewFactory.getProvider()) == null) {
            return;
        }
        provider.RecordUrl(str);
    }

    public static void addListener(IForceInitZeusListener iForceInitZeusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iForceInitZeusListener) == null) {
            synchronized (sForceInitLock) {
                if (mListenerLst == null) {
                    mListenerLst = new ArrayList<>();
                }
                mListenerLst.add(iForceInitZeusListener);
            }
        }
    }

    public static void addStatisticParam(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            if (sUploadParams == null) {
                sUploadParams = new HashMap<>();
            }
            if (sUploadParams.containsKey(str)) {
                sUploadParams.remove(str);
            }
            sUploadParams.put(str, str2);
            WebSettingsGlobalBlink.setStatisticParam(sUploadParams.toString());
        }
    }

    public static void addUploadNumJs() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.addUploadNum();
    }

    public static String checkProcessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? WebViewFactory.isMainAppProcess() ? (getCurEngine() == 1 && WebSettingsGlobalBlink.isMultiProcessEnabled()) ? "3" : "0" : WebViewFactory.isSwanProcess() ? "1" : WebViewFactory.isRendererProcess() ? "2" : WebViewFactory.isMediaProcess() ? "4" : "" : (String) invokeV.objValue;
    }

    public static boolean checkZeusCompatibility(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (WebKitFactory.class) {
                LoadErrorCode.Statistics.destroy();
                Statistics.close();
                mDelayedInitTask = null;
            }
        }
    }

    public static void forceInitT7(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i2) == null) {
            if (i2 == 0 || 1 == i2 || 2 == i2) {
                mInitWebkitType = i2;
            }
        }
    }

    public static void forceInitZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            if (WebViewFactory.isZeusProvider()) {
                notifyForceInitZeusListener(false);
                return;
            }
            int i2 = sForceInitedState;
            if (i2 != 0) {
                if (i2 == 1) {
                    notifyForceInitZeusListener(true);
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    notifyForceInitZeusListener(false);
                    return;
                }
            }
            sForceInitedState = 1;
            notifyForceInitZeusListener(true);
            System.currentTimeMillis();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            sForceInitResult = WebViewFactory.forceInitZeusProvider();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            sForceInitedState = 2;
            notifyForceInitZeusListener(false);
            ZeusPerformanceTiming.recordWebkitInitStatistics(2);
        }
    }

    public static void forceInitZeusByUser() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            if (2 != mInitWebkitType) {
                notifyForceInitZeusListener(false);
                return;
            }
            Log.i(TAG, "forceInitZeusByUser mInitWebkitType=" + mInitWebkitType + ", sForceInitedState=" + sForceInitedState);
            forceInitZeus();
        }
    }

    public static void forceInitZeusInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            if (1 == mInitWebkitType) {
                forceInitZeus();
            } else {
                notifyForceInitZeusListener(false);
            }
        }
    }

    public static boolean forceNoZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? WebViewFactory.forceNoZeus() : invokeV.booleanValue;
    }

    public static String getAppIdString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? sAppId : (String) invokeV.objValue;
    }

    public static String getAppVersionString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? sAppVersion : (String) invokeV.objValue;
    }

    public static String getCPUType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? CpuInfo.getCpuInfoString() : (String) invokeV.objValue;
    }

    public static String getCUIDString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? sCUID : (String) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? WebViewFactory.getContext() : (Context) invokeV.objValue;
    }

    public static String getCrashCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? sCrashCallback : (String) invokeV.objValue;
    }

    public static int getCurEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (!WebViewFactory.hasProvider() || WebViewFactory.getProvider() == null) {
                return -1;
            }
            return WebViewFactory.isZeusProvider() ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public static String getCyberSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? VideoCloudSetting.getCyberSdkVersion() : (String) invokeV.objValue;
    }

    public static String getDumpCopyDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            String str = sDumpCopyDir;
            return str != null ? str : "";
        }
        return (String) invokeV.objValue;
    }

    public static String getEmulatorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            String str = sEmulator;
            return str != null ? str : "";
        }
        return (String) invokeV.objValue;
    }

    public static SwitchState getEnableMultipleProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? sEnableMultipleProcess : (SwitchState) invokeV.objValue;
    }

    public static String getEngineInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? mJavaScriptInterface != null ? JsUploadTask.getEngineInfo() : "" : (String) invokeV.objValue;
    }

    public static String getEngineInfoJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? mJavaScriptInterface != null ? JsUploadTask.getEngineInfoInternal() : "" : (String) invokeV.objValue;
    }

    public static String getFirstJumpUrlJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? mJavaScriptInterface != null ? JsUploadTask.getFirstJumpUrl() : "" : (String) invokeV.objValue;
    }

    public static int getHashSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? sHashSign : invokeV.intValue;
    }

    public static int getHttpCacheMbSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? sHttpCacheMbSize : invokeV.intValue;
    }

    public static boolean getIntegratedCrashpad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? sEnableIntegratedCrashpad : invokeV.booleanValue;
    }

    public static String getKernelSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? sKernelSessionId : (String) invokeV.objValue;
    }

    public static LoadErrorCode getLoadErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? LoadErrorCode.getInstance() : (LoadErrorCode) invokeV.objValue;
    }

    public static boolean getNeedDownloadCloudResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? WebViewFactory.isMainAppProcess() : invokeV.booleanValue;
    }

    public static String getNetTypeJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? mJavaScriptInterface != null ? JsUploadTask.getNetType() : "" : (String) invokeV.objValue;
    }

    public static long getPageStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? sPageStartTimeStamp : invokeV.longValue;
    }

    public static String getProcessTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            String str = sProcessType;
            return str != null ? str : "-1";
        }
        return (String) invokeV.objValue;
    }

    public static String getSdkVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? GlobalConstants.ZEUS_VERSION_NAME : (String) invokeV.objValue;
    }

    public static String getSdkVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? getSdkVersionCode() : (String) invokeV.objValue;
    }

    public static String getSearchId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? sSearchId : (String) invokeV.objValue;
    }

    public static boolean getSpdyAlreadySetJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            if (mJavaScriptInterface != null) {
                return JsUploadTask.getSpdyAlreadySet();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:9|(4:10|11|(1:13)|14)|15|(3:17|(5:20|21|(2:25|26)|27|18)|33)|34|(1:36)|37|38|(2:41|39)|42|43|44|45) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010b, code lost:
        r0 = "read private file " + r6 + " failed: " + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0122, code lost:
        r0 = "private file " + r6 + " is not found when reading";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0131, code lost:
        com.baidu.webkit.sdk.Log.v(com.baidu.webkit.sdk.WebKitFactory.TAG, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9 A[Catch: IOException -> 0x010a, FileNotFoundException -> 0x0122, LOOP:1: B:38:0x00e3->B:40:0x00e9, LOOP_END, TryCatch #5 {FileNotFoundException -> 0x0122, IOException -> 0x010a, blocks: (B:37:0x00da, B:38:0x00e3, B:40:0x00e9, B:41:0x0106), top: B:57:0x00da }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getStartUpFreq() {
        InterceptResult invokeV;
        String str;
        String str2;
        Iterator it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            if (sStartUpFreq <= 0 && getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getDitingMaxForceLoadSwitch()) {
                String str3 = getContext().getFilesDir().getAbsolutePath() + File.separator + START_UP_RECORD_PATH;
                byte[] bArr = null;
                try {
                    FileInputStream fileInputStream = new FileInputStream(str3);
                    if (fileInputStream.available() > 0) {
                        bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                    }
                    fileInputStream.close();
                } catch (FileNotFoundException unused) {
                    str = "private file " + str3 + " is not found when reading";
                    Log.v(TAG, str);
                    ArrayList arrayList = new ArrayList();
                    if (bArr != null) {
                    }
                    str2 = sStatisticsSessionId;
                    if (str2 != null) {
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(str3, false);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                    }
                    fileOutputStream.close();
                    int size = arrayList.size();
                    sStartUpFreq = size;
                    return size;
                } catch (IOException e2) {
                    str = "read private file " + str3 + " failed: " + e2.getMessage();
                    Log.v(TAG, str);
                    ArrayList arrayList2 = new ArrayList();
                    if (bArr != null) {
                    }
                    str2 = sStatisticsSessionId;
                    if (str2 != null) {
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str3, false);
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                    }
                    fileOutputStream2.close();
                    int size2 = arrayList2.size();
                    sStartUpFreq = size2;
                    return size2;
                }
                ArrayList arrayList22 = new ArrayList();
                if (bArr != null) {
                    String[] split = new String(bArr).split(StringUtils.LF);
                    long parseLong = Long.parseLong(sStatisticsSessionId);
                    for (int i2 = 0; i2 < split.length; i2++) {
                        try {
                            if (Long.parseLong(split[i2]) >= parseLong - 86400000 && split.length - i2 < 100) {
                                arrayList22.add(split[i2]);
                            }
                        } catch (NumberFormatException unused2) {
                            Log.e(TAG, "parseLong err: " + split[i2]);
                        }
                    }
                }
                str2 = sStatisticsSessionId;
                if (str2 != null) {
                    arrayList22.add(str2);
                }
                FileOutputStream fileOutputStream22 = new FileOutputStream(str3, false);
                it = arrayList22.iterator();
                while (it.hasNext()) {
                    fileOutputStream22.write((((String) it.next()) + StringUtils.LF).getBytes());
                }
                fileOutputStream22.close();
                int size22 = arrayList22.size();
                sStartUpFreq = size22;
                return size22;
            }
            return sStartUpFreq;
        }
        return invokeV.intValue;
    }

    public static HashMap<String, String> getStatisticParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? sUploadParams : (HashMap) invokeV.objValue;
    }

    public static String getStatisticsSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? sStatisticsSessionId : (String) invokeV.objValue;
    }

    public static boolean getUsingCloudSettingsJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (mJavaScriptInterface != null) {
                return JsUploadTask.getUsingCloudSettings();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static WebKitClient getWebKitClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? sWebKitClient : (WebKitClient) invokeV.objValue;
    }

    public static String getZIDString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? sZID : (String) invokeV.objValue;
    }

    public static void getZeusInitModeOptABValue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, null) == null) {
            b.a();
        }
    }

    public static String getZeusVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? WebKitVersionBlink.getVersionName() : (String) invokeV.objValue;
    }

    public static String getZeusVersionNamekernel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? WebKitVersionBlink.getZeusVersionByUpdate() : (String) invokeV.objValue;
    }

    public static synchronized boolean init(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65590, null, context, str, str2)) == null) {
            synchronized (WebKitFactory.class) {
                if (sInited) {
                    return true;
                }
                sInited = true;
                sAppId = str;
                if (context != null) {
                    try {
                        sAppVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    } catch (Exception unused) {
                        Log.e(TAG, "Get App Version Name Failed!");
                    }
                }
                if (context != null) {
                    try {
                        sHashSign = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].hashCode();
                        Log.e("WebkitFactory", "get sHashSign:" + sHashSign);
                    } catch (Exception unused2) {
                        Log.e(TAG, "Get App sign Name Failed!");
                    }
                }
                setCUIDString(str2);
                sStatisticsSessionId = String.valueOf(System.currentTimeMillis());
                mJavaScriptInterface = new JsUploadTask();
                ZwDebug.init(WebViewFactory.getContext());
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void installAsync(String str, WebkitInstallListener webkitInstallListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65591, null, str, webkitInstallListener) == null) {
            EngineManager.getInstance().installAsync(str, webkitInstallListener);
        }
    }

    public static boolean isEngineAvailable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65592, null, i2)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean isForceInitT7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            int i2 = mInitWebkitType;
            return 1 == i2 || 2 == i2;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNeedKillProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? EngineManager.getInstance().isNeedKillProcess() : invokeV.booleanValue;
    }

    public static boolean isPlatformSupported() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65595, null)) != null) {
            return invokeV.booleanValue;
        }
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("t7_max_sdk_version_supported");
        if (!TextUtils.isEmpty(GetCloudSettingsValue)) {
            try {
                intValue = Integer.valueOf(GetCloudSettingsValue).intValue();
            } catch (Exception e2) {
                Log.e(TAG, "in isPlatformSupported, cloudSetting is not digit", e2);
            }
            int i2 = Build.VERSION.SDK_INT;
            return i2 >= 14 && i2 <= intValue;
        }
        intValue = 30;
        int i22 = Build.VERSION.SDK_INT;
        if (i22 >= 14) {
            return false;
        }
    }

    public static boolean isUserPrivacyEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? sUserPrivacyConfirm : invokeV.booleanValue;
    }

    public static boolean isZeusSupported() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            if (!sZeusSupportedLoaded) {
                if (X64_BL.indexOf(Build.MODEL.replace(" ", "").toLowerCase()) != -1) {
                    Log.w(TAG, "not support intel x86");
                    sZeusSupported = false;
                    sZeusSupportedLoaded = true;
                    return false;
                }
                String property = System.getProperty("os.arch");
                boolean z2 = !TextUtils.isEmpty(property) && property.endsWith(OS_64);
                if (!TextUtils.isEmpty(property) && property.toLowerCase().contains("armv")) {
                    try {
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (Integer.valueOf(property.substring(4, 5)).intValue() >= 7) {
                        z = true;
                        if ((!z || z2) && isPlatformSupported()) {
                            sZeusSupported = true;
                        } else {
                            sZeusSupported = false;
                        }
                        sZeusSupportedLoaded = true;
                    }
                }
                z = false;
                if (z) {
                }
                sZeusSupported = true;
                sZeusSupportedLoaded = true;
            }
            return sZeusSupported;
        }
        return invokeV.booleanValue;
    }

    public static boolean lockUpdateZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            try {
                if (WebViewFactory.getContext() != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(WebViewFactory.getContext().getFilesDir().getAbsolutePath() + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH, "update_zeus"), "rw");
                    Log.i(EngineManager.LOG_TAG, " invoke lockUpdateZeus");
                    mLock = randomAccessFile.getChannel().lock();
                    Log.i(EngineManager.LOG_TAG, " lockUpdateZeus time = " + (System.currentTimeMillis() - currentTimeMillis));
                    return mLock != null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void notifyCuidChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, null) == null) {
            setCuidJs(getCUIDString());
            if (WebViewFactory.isZeusProvider()) {
                WebSettingsGlobalBlink.setCuid(getCUIDString());
            }
            SessionMonitorEngine.getInstance().updateCuidIfNeeded();
        }
    }

    public static void notifyForceInitZeusListener(boolean z) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65600, null, z) == null) || mListenerLst == null) {
            return;
        }
        synchronized (sForceInitLock) {
            arrayList = (ArrayList) mListenerLst.clone();
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IForceInitZeusListener iForceInitZeusListener = (IForceInitZeusListener) it.next();
                if (z) {
                    iForceInitZeusListener.onForceInitZeusStart();
                } else {
                    iForceInitZeusListener.onForceInitZeusFinish(sForceInitResult);
                }
            }
        }
    }

    public static void notifyUserPrivacyConfirmIfNeeded(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65601, null, z) == null) || sUserPrivacyConfirm == z) {
            return;
        }
        sUserPrivacyConfirm = z;
        if (z) {
            Log.i(TAG, "notifyUserPrivacyConfirmIfNeeded confirm=".concat(String.valueOf(z)));
            notifyUserPrivacyConfirmedInner();
        }
    }

    public static void notifyUserPrivacyConfirmedInner() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65602, null) == null) || WebViewFactory.getProvider() == null) {
            return;
        }
        ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.sdk.WebKitFactory.1
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
                    ResourceSchedulerEngine.getInstance().fetchIntegrationInfoFromServer();
                    CloudSettings.tryToUpdateCloudSettings(WebViewFactory.getContext());
                }
            }
        });
    }

    public static void removeListener(IForceInitZeusListener iForceInitZeusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, null, iForceInitZeusListener) == null) {
            synchronized (sForceInitLock) {
                if (mListenerLst.contains(iForceInitZeusListener)) {
                    mListenerLst.remove(iForceInitZeusListener);
                }
            }
        }
    }

    public static void setAlreadySetEnabledJs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65604, null, z) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setAlreadySetEnabled(z);
    }

    public static void setApkLibLoadType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65605, null, z) == null) {
            sIsWebKitBuiltin = z;
        }
    }

    public static void setAppVersionJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65606, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setAppVersion(str);
    }

    public static void setAppidJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65607, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setAppid(str);
    }

    public static void setBTransUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, null, str) == null) {
            mJavaScriptInterface.setBTransUrl(str);
        }
    }

    public static void setBlockedAdCountJs(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65609, null, i2) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setBlockedAdCount(i2);
    }

    public static void setCUIDString(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65610, null, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, sCUID)) {
            return;
        }
        sCUID = str;
        notifyCuidChanged();
    }

    public static void setCpuTypeJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65611, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setCpuType(str);
    }

    public static void setCrashCallback(Context context, Class<? extends Object> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65612, null, context, cls) == null) {
            Log.v("BR", "--WebKitFactory.java--setCrashCallback----".concat(String.valueOf(cls)));
            if (cls != null) {
                sCrashCallback = cls.getName();
            }
        }
    }

    public static void setCssLoadedJs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65613, null, z) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setCssLoaded(z);
    }

    public static void setCuidJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65614, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setCuid(str);
    }

    public static void setCurrentUrlJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setCurrentUrl(str);
    }

    public static void setDumpCopyDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, null, str) == null) {
            sDumpCopyDir = str;
        }
    }

    public static void setEmulator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65617, null, str) == null) {
            sEmulator = str;
        }
    }

    public static void setEnableIntegratedCrashpad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65618, null, z) == null) {
            sEnableIntegratedCrashpad = z;
        }
    }

    public static void setEnableMultiprocess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65619, null, z) == null) {
            sEnableMultipleProcess = z ? SwitchState.On : SwitchState.Off;
        }
    }

    public static synchronized boolean setEngine(int i2) {
        InterceptResult invokeI;
        int curEngine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65620, null, i2)) == null) {
            synchronized (WebKitFactory.class) {
                WebViewFactory.installZesEngineIfNeeded(!ZeusSDK.usingZeusSDK(), false);
                lockUpdateZeus();
                WebViewFactory.setUseSystemWebView(1 != i2);
                if (1 == i2) {
                    WebViewFactory.unzip();
                }
                WebViewFactory.getProvider();
                unLockUpdateZeus();
                if (mDelayedInitTask == null) {
                    DelayedInitTask delayedInitTask = new DelayedInitTask(WebViewFactory.hasProvider());
                    mDelayedInitTask = delayedInitTask;
                    delayedInitTask.start();
                }
                curEngine = getCurEngine();
            }
            return curEngine == 1;
        }
        return invokeI.booleanValue;
    }

    public static void setEngineJs(int i2) {
        JsUploadTask jsUploadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65621, null, i2) == null) || (jsUploadTask = mJavaScriptInterface) == null) {
            return;
        }
        jsUploadTask.setEngine(i2);
    }

    public static void setErrorCodeJs(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65622, null, i2) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setErrorCode(i2);
    }

    public static void setFirstJumpTypeJs(JsUploadTask.JumpType jumpType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65623, null, jumpType) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setFirstJumpType(jumpType);
    }

    public static void setFirstJumpUrlJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65624, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setFirstJumpUrl(str);
    }

    public static void setFirstScreenTimeJs(long j) {
        JsUploadTask jsUploadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65625, null, j) == null) || (jsUploadTask = mJavaScriptInterface) == null) {
            return;
        }
        jsUploadTask.setFirstScreenTime(j);
    }

    public static void setGpuTypeJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65626, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setGpuType(str);
    }

    public static void setHttpCacheMbSize(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65627, null, i2) == null) || i2 == sHttpCacheMbSize) {
            return;
        }
        Log.i("maqian04-httpcache", " WebKitFactory setHttpCacheSize size is ".concat(String.valueOf(i2)));
        sHttpCacheMbSize = i2;
    }

    public static void setHttpDnsJs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65628, null, z) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setHttpDns(z);
    }

    public static void setHttpcode(int i2) {
        JsUploadTask jsUploadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65629, null, i2) == null) || (jsUploadTask = mJavaScriptInterface) == null) {
            return;
        }
        jsUploadTask.setHttpcode(i2);
    }

    public static void setIsMobileSiteJs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65630, null, z) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setIsMobileSite(z);
    }

    public static void setKernelSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65631, null, str) == null) {
            sKernelSessionId = str;
        }
    }

    public static void setLastJumpTypeJs(JsUploadTask.JumpType jumpType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65632, null, jumpType) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setLastJumpType(jumpType);
    }

    public static void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65633, null, zeusGeoLocationInfo, z) == null) && getCurEngine() == 1 && (provider = WebViewFactory.getProvider()) != null) {
            provider.setLocation(zeusGeoLocationInfo, z);
        }
    }

    public static void setNeedDownloadCloudResource(boolean z) throws RuntimeException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65634, null, z) == null) {
            if (sInited) {
                throw new RuntimeException("you should call method setNeedDownloadCloudResource before BdSailor.getInstance().initWebkit()");
            }
            sIsNeedDownloadCloudResource = z;
        }
    }

    public static void setNetErrorJs(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65635, null, i2) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setNetError(i2);
    }

    public static void setNetTypeJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65636, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setNetType(str);
    }

    public static void setNetcode(int i2) {
        JsUploadTask jsUploadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65637, null, i2) == null) || (jsUploadTask = mJavaScriptInterface) == null) {
            return;
        }
        jsUploadTask.setNetcode(i2);
    }

    public static void setPageFinishedTimeJs(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65638, null, j) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setPageFinishedTime(j);
    }

    public static void setPageStartTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65639, null, j) == null) {
            sPageStartTimeStamp = j;
            mJavaScriptInterface.setPageStartTime(j);
        }
    }

    public static void setParsedTokensJs(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65640, null, i2) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setParsedTokens(i2);
    }

    public static void setProcessType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65641, null, str) == null) {
            sProcessType = str;
        }
    }

    public static void setReceivedDataSizeJs(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65642, null, i2) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setReceivedDataSize(i2);
    }

    public static void setSdkVerJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65643, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setSdkVer(str);
    }

    public static void setSearchId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65644, null, str) == null) {
            sSearchId = str;
            mJavaScriptInterface.setSearchId(str);
        }
    }

    public static void setSpdyEnabledJs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65645, null, z) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setSpdyEnabled(z);
    }

    public static void setStatisticsSessionIdJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65646, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setStatisticsSessionId(str);
    }

    public static void setTimeStampJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65647, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setTimeStamp(str);
    }

    public static void setWebKitClient(WebKitClient webKitClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65648, null, webKitClient) == null) {
            sWebKitClient = webKitClient;
        }
    }

    public static void setWebviewNumber(String str) {
        WebViewFactoryProvider provider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65649, null, str) == null) || (provider = WebViewFactory.getProvider()) == null) {
            return;
        }
        provider.setWebviewNumber(str);
    }

    public static void setWiseLandingPageType(int i2) {
        JsUploadTask jsUploadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65650, null, i2) == null) || (jsUploadTask = mJavaScriptInterface) == null) {
            return;
        }
        jsUploadTask.setWiseLandingPageType(i2);
    }

    public static void setZID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65651, null, str) == null) {
            sZID = str;
        }
    }

    public static void setZeusVerJs(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65652, null, str) == null) || mJavaScriptInterface == null) {
            return;
        }
        JsUploadTask.setZeusVer(str);
    }

    public static void unLockUpdateZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65653, null) == null) {
            try {
                if (mLock != null) {
                    mLock.release();
                    mLock = null;
                    Log.i(EngineManager.LOG_TAG, " unLockUpdateZeus");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
