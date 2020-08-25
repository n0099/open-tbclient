package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes19.dex */
public final class WebKitFactory {
    private static final String ARCH_ARM = "armv";
    private static final int ARCH_ARM_INT = 7;
    private static final int DEFAULT_INIT = 0;
    public static final int ENGINE_BLINK = 1;
    public static final int ENGINE_INVALID = -1;
    public static final int ENGINE_ORIGINAL = 0;
    public static final int FORCE_INIT_ZEUS = 1;
    private static final String OS_64 = "64";
    private static final String OS_ARCH = "os.arch";
    public static final String PROCESS_TYPE_BROWSER = "3";
    public static final String PROCESS_TYPE_RENDERER = "2";
    public static final String PROCESS_TYPE_SINGLE_PROCESS = "0";
    public static final String PROCESS_TYPE_SWAN = "1";
    public static final String PROCESS_TYPE_UNKOWN = "-1";
    public static final String START_UP_RECORD_PATH = "start_up_record.dat";
    private static final String TAG = "WebKitFactory";
    private static final String X64_BL = "asus_t00i,asus_t00q,asus_t00j,asus_t00k,asus_t00g,asus_z002,asus_z007,asus_z00d,asus_z008d,asus_z00ad,asus_z00adb,lenovoyt3-x90f,mipad2";
    private static DelayedInitTask mDelayedInitTask;
    private static JsUploadTask mJavaScriptInterface;
    private static List<IForceInitZeusListener> mListenerLst;
    private static String sAppId;
    private static String sAppVersion;
    private static String sCrashCallback;
    private static String sEmulator;
    private static int sHashSign;
    private static volatile boolean sInited;
    public static volatile boolean sIsWebKitBuiltin;
    private static String sKernelSessionId;
    public static volatile String sLoadPath;
    private static long sPageStartTimeStamp;
    private static String sProcessType;
    private static String sSearchId;
    private static String sStatisticsSessionId;
    private static HashMap<String, String> sUploadParams;
    private static WebKitClient sWebKitClient;
    private static String sZID;
    private static boolean sZeusSupportedLoaded;
    public static int sStartUpFreq = -1;
    private static String sCUID = "0";
    private static volatile boolean sIsNeedDownloadCloudResource = true;
    private static volatile boolean sUserPrivacyConfirm = true;
    public static int mInitWebkitType = 0;
    private static boolean sZeusSupported = true;
    private static boolean sEnableIntegratedCrashpad = true;
    private static SwitchState sEnableMultipleProcess = SwitchState.Invalid;

    /* loaded from: classes19.dex */
    private static class DelayedInitTask extends Thread {
        private boolean mResult;

        DelayedInitTask(boolean z) {
            this.mResult = z;
        }

        private void doInitStatistics() {
            byte[] bArr;
            try {
                String str = WebKitFactory.getContext().getFilesDir().getCanonicalPath() + "/zeus/statistics/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = "[[19, \"aosmith.com.cn\", \"aosmith.com.cn/query=\", \"/lookup.dll\", 1, \"AST=.*\", 88715],[20, \"028hk.net\", \"028hk.net/option.php\\\\?\", \"/search.htm\", 0, \"\", 89519],[21, \"ssk.com.cn\", \"ssk.com.cn/mongo.*\", \"/InfoCheck\", 0, \"\", 58003],[31, \"m.baidu.com\", \"m.biadu.com/baike\", \"/CH/webid=\", 0, \"\", 44232],[221, \"youth.net\", \"youth.net/newsid=.*\", \"newstitle=\", 0, \"\", 69022],[34, \"weiphone.com\", \"weiphone.com/bbs\", \"postid=\", 0, \"\", 21802],[41, \"ymyjy.com\", \"ymyjy.com/daily.*\", \"searchitem=.*\", 0, \"\", 39800],[1, \"kuaishang.com.cn\", \"kuaishang.com.cn/bs/im.htm\", \"/msg.htm\", 0, \"\", 31125],[4, \"eic.org.cn\", \"/chatClient/chatbox.jsp\", \"/ChaterServer\\\\?cmd=203.*&msgContent=\", 0, \" \", 99233],[14, \"gaodun.com\", \"/LR/Chatpre.aspx\\\\?\", \"/LR/CdCheck.aspx\", 1, \"_text=%2CACT_TEMP%7C0%7C%2C\", 56423],[2, \"meiqia.com\", \"meiqia.com/widget/phone/index.html\",\"meiqia.com/mobile/sendMsg\", 0, \" \", 52398], [3, \"qiao.baidu.com\", \"qiao.baidu.com/im/index\\\\?siteid\", \"qiao.baidu.com/communicate\\\\?\", 0, \" \", 86929], [5, \"looyu.com\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 98323], [51, \"talk99.cn\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 15720], [52, \"looyuoms.com\", \"chat/chat/p.do\\\\?\", \"chat/msg.dll\\\\?cmd=postMessage.*&msg=\", 0, \" \", 15720],[6, \"tq.cn\", \"tq.cn/sendmain.jsp\\\\?\", \"tq.cn/sendmsg.jsp\\\\?.*&msg=[^&]*&type_code=\", 0, \" \", 97521],[11, \"53kf.com\", \"53kf.com/m.php\\\\?cid\", \"53kf.com/sendmsg.jsp\\\\?_=\", 1, \"QST\", 32100],[13, \"zoosnet.net\", \"/LR/Chatpre.aspx\\\\?\", \"/LR/CdCheck.aspx\", 1, \"_text=%2C.\\\\{1,\\\\}&lng=\", 42083],[222, \"linking.baidu.com\", \"linking.baidu.com/actionads/*\", \"linking.baidu.com/communicate?*\", 0, \"\", 12945]]";
                File file2 = new File(WebKitFactory.getContext().getCacheDir(), "phoenix.dudu");
                if (file2.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    if (fileInputStream.available() > 0) {
                        byte[] bArr2 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr2);
                        bArr = bArr2;
                    } else {
                        bArr = null;
                    }
                    fileInputStream.close();
                    str2 = new String(bArr, "utf-8");
                }
                Statistics.init(str + "error.log", str + "phoenix_ad.log", str2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private void forceInitZeus() {
            if (1 != WebKitFactory.mInitWebkitType || WebViewFactory.isZeusProvider()) {
                return;
            }
            if (WebKitFactory.mListenerLst != null) {
                for (IForceInitZeusListener iForceInitZeusListener : WebKitFactory.mListenerLst) {
                    iForceInitZeusListener.onForceInitZeusStart();
                }
            }
            System.currentTimeMillis();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            boolean forceInitZeusProvider = WebViewFactory.forceInitZeusProvider();
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            if (WebKitFactory.mListenerLst != null) {
                for (IForceInitZeusListener iForceInitZeusListener2 : WebKitFactory.mListenerLst) {
                    iForceInitZeusListener2.onForceInitZeusFinish(forceInitZeusProvider);
                }
            }
            ZeusPerformanceTiming.recordWebkitInitStatistics(2);
        }

        protected void doDelayedTask() {
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

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            forceInitZeus();
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
            ZeusLogUploader.UploadLogDirectory(WebViewFactory.getContext().getDir(WebViewFactory.getDataDirectorySuffix() != null ? "webview_baidu" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + WebViewFactory.getDataDirectorySuffix() : "webview_baidu", 0).getPath() + "/nr/", ZeusLogUploader.NR_LOG, true, null);
        }
    }

    /* loaded from: classes19.dex */
    public interface IForceInitZeusListener {
        @Keep
        void onForceInitZeusFinish(boolean z);

        @Keep
        void onForceInitZeusStart();
    }

    /* loaded from: classes19.dex */
    public enum SwitchState {
        Invalid,
        On,
        Off
    }

    /* loaded from: classes19.dex */
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

        void onInstallFinish(int i, String str);

        void onInstallStart();
    }

    public static Object JavascriptInterface() {
        if (mJavaScriptInterface != null) {
            return mJavaScriptInterface;
        }
        Log.w(TAG, "mJavaScriptInterface = null");
        return null;
    }

    public static void RecordUrl(String str) {
        WebViewFactoryProvider provider = WebViewFactory.getProvider();
        if (provider != null) {
            provider.RecordUrl(str);
        }
    }

    public static synchronized void addListener(IForceInitZeusListener iForceInitZeusListener) {
        synchronized (WebKitFactory.class) {
            if (mListenerLst == null) {
                mListenerLst = new ArrayList();
            }
            mListenerLst.add(iForceInitZeusListener);
        }
    }

    public static void addStatisticParam(String str, String str2) {
        if (sUploadParams == null) {
            sUploadParams = new HashMap<>();
        }
        if (sUploadParams.containsKey(str)) {
            sUploadParams.remove(str);
        }
        sUploadParams.put(str, str2);
        WebSettingsGlobalBlink.setStatisticParam(sUploadParams.toString());
    }

    public static void addUploadNumJs() {
        if (mJavaScriptInterface != null) {
            JsUploadTask.addUploadNum();
        }
    }

    public static boolean checkZeusCompatibility(String str) {
        return true;
    }

    public static synchronized void destroy() {
        synchronized (WebKitFactory.class) {
            LoadErrorCode.Statistics.destroy();
            Statistics.close();
            mDelayedInitTask = null;
        }
    }

    public static void forceInitT7(int i) {
        if (i == 0 || 1 == i) {
            mInitWebkitType = i;
        }
    }

    public static boolean forceNoZeus() {
        return WebViewFactory.forceNoZeus();
    }

    public static String getAppIdString() {
        return sAppId;
    }

    public static String getAppVersionString() {
        return sAppVersion;
    }

    public static String getCPUType() {
        return CpuInfo.getCpuInfoString();
    }

    public static String getCUIDString() {
        return sCUID;
    }

    public static Context getContext() {
        return WebViewFactory.getContext();
    }

    public static String getCrashCallback() {
        return sCrashCallback;
    }

    public static int getCurEngine() {
        if (!WebViewFactory.hasProvider() || WebViewFactory.getProvider() == null) {
            return -1;
        }
        return WebViewFactory.isZeusProvider() ? 1 : 0;
    }

    public static String getCyberSdkVersion() {
        return VideoCloudSetting.getCyberSdkVersion();
    }

    public static String getEmulatorString() {
        return sEmulator != null ? sEmulator : "";
    }

    public static SwitchState getEnableMultipleProcess() {
        return sEnableMultipleProcess;
    }

    public static String getEngineInfo() {
        return mJavaScriptInterface != null ? JsUploadTask.getEngineInfo() : "";
    }

    public static String getEngineInfoJs() {
        return mJavaScriptInterface != null ? JsUploadTask.getEngineInfoInternal() : "";
    }

    public static String getFirstJumpUrlJs() {
        return mJavaScriptInterface != null ? JsUploadTask.getFirstJumpUrl() : "";
    }

    public static int getHashSign() {
        return sHashSign;
    }

    public static boolean getIntegratedCrashpad() {
        return sEnableIntegratedCrashpad;
    }

    public static String getKernelSessionId() {
        return sKernelSessionId;
    }

    public static LoadErrorCode getLoadErrorCode() {
        return LoadErrorCode.getInstance();
    }

    public static boolean getNeedDownloadCloudResource() {
        return WebViewFactory.isMainAppProcess();
    }

    public static String getNetTypeJs() {
        return mJavaScriptInterface != null ? JsUploadTask.getNetType() : "";
    }

    public static long getPageStartTimeStamp() {
        return sPageStartTimeStamp;
    }

    public static String getProcessTypeString() {
        return sProcessType != null ? sProcessType : "-1";
    }

    public static String getSdkVersionCode() {
        return GlobalConstants.ZEUS_VERSION_NAME;
    }

    public static String getSdkVersionName() {
        return getSdkVersionCode();
    }

    public static String getSearchId() {
        return sSearchId;
    }

    public static boolean getSpdyAlreadySetJs() {
        if (mJavaScriptInterface != null) {
            return JsUploadTask.getSpdyAlreadySet();
        }
        return false;
    }

    public static int getStartUpFreq() {
        if (sStartUpFreq <= 0 && getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getDitingMaxForceLoadSwitch()) {
            String str = getContext().getFilesDir().getAbsolutePath() + File.separator + START_UP_RECORD_PATH;
            byte[] bArr = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                if (fileInputStream.available() > 0) {
                    bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                Log.v(TAG, "private file " + str + " is not found when reading");
            } catch (IOException e2) {
                Log.v(TAG, "read private file " + str + " failed: " + e2.getMessage());
            }
            ArrayList arrayList = new ArrayList();
            if (bArr != null) {
                String[] split = new String(bArr).split("\n");
                long parseLong = Long.parseLong(sStatisticsSessionId);
                for (int i = 0; i < split.length; i++) {
                    try {
                        if (Long.parseLong(split[i]) >= parseLong - 86400000 && split.length - i < 100) {
                            arrayList.add(split[i]);
                        }
                    } catch (NumberFormatException e3) {
                        Log.e(TAG, "parseLong err: " + split[i]);
                    }
                }
            }
            if (sStatisticsSessionId != null) {
                arrayList.add(sStatisticsSessionId);
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str, false);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    fileOutputStream.write((((String) it.next()) + "\n").getBytes());
                }
                fileOutputStream.close();
            } catch (FileNotFoundException e4) {
                Log.v(TAG, "private file " + str + " is not found when reading");
            } catch (IOException e5) {
                Log.v(TAG, "read private file " + str + " failed: " + e5.getMessage());
            }
            int size = arrayList.size();
            sStartUpFreq = size;
            return size;
        }
        return sStartUpFreq;
    }

    public static HashMap<String, String> getStatisticParams() {
        return sUploadParams;
    }

    public static String getStatisticsSessionId() {
        return sStatisticsSessionId;
    }

    public static boolean getUsingCloudSettingsJs() {
        if (mJavaScriptInterface != null) {
            return JsUploadTask.getUsingCloudSettings();
        }
        return false;
    }

    public static WebKitClient getWebKitClient() {
        return sWebKitClient;
    }

    public static String getZIDString() {
        return sZID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getZeusInitModeOptABValue() {
        b.a();
    }

    public static String getZeusVersionName() {
        return WebKitVersionBlink.getVersionName();
    }

    public static synchronized boolean init(Context context, String str, String str2) {
        synchronized (WebKitFactory.class) {
            if (!sInited) {
                sInited = true;
                sAppId = str;
                if (context != null) {
                    try {
                        sAppVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    } catch (Exception e) {
                        Log.e(TAG, "Get App Version Name Failed!");
                    }
                }
                if (context != null) {
                    try {
                        sHashSign = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].hashCode();
                        Log.e("WebkitFactory", "get sHashSign:" + sHashSign);
                    } catch (Exception e2) {
                        Log.e(TAG, "Get App sign Name Failed!");
                    }
                }
                setCUIDString(str2);
                sStatisticsSessionId = String.valueOf(System.currentTimeMillis());
                mJavaScriptInterface = new JsUploadTask();
                ZwDebug.init(WebViewFactory.getContext());
            }
        }
        return true;
    }

    public static void installAsync(String str, WebkitInstallListener webkitInstallListener) {
        EngineManager.getInstance().installAsync(str, webkitInstallListener);
    }

    public static boolean isEngineAvailable(int i) {
        return true;
    }

    public static boolean isForceInitT7() {
        return 1 == mInitWebkitType;
    }

    public static boolean isNeedKillProcess() {
        return EngineManager.getInstance().isNeedKillProcess();
    }

    public static boolean isPlatformSupported() {
        return Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 29;
    }

    public static boolean isUserPrivacyEnabled() {
        return sUserPrivacyConfirm;
    }

    public static boolean isZeusSupported() {
        boolean z;
        if (!sZeusSupportedLoaded) {
            if (X64_BL.indexOf(Build.MODEL.replace(" ", "").toLowerCase()) != -1) {
                Log.w(TAG, "not support intel x86");
                sZeusSupported = false;
                sZeusSupportedLoaded = true;
                return sZeusSupported;
            }
            String property = System.getProperty(OS_ARCH);
            boolean z2 = !TextUtils.isEmpty(property) && property.endsWith(OS_64);
            if (!TextUtils.isEmpty(property) && property.toLowerCase().contains("armv")) {
                try {
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    z = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
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

    private static void notifyCuidChanged() {
        setCuidJs(getCUIDString());
        if (WebViewFactory.isZeusProvider()) {
            WebSettingsGlobalBlink.setCuid(getCUIDString());
        }
        SessionMonitorEngine.getInstance().updateCuidIfNeeded();
    }

    public static void notifyUserPrivacyConfirmIfNeeded(boolean z) {
        if (sUserPrivacyConfirm != z) {
            sUserPrivacyConfirm = z;
            if (z) {
                Log.i(TAG, "notifyUserPrivacyConfirmIfNeeded confirm=" + z);
                notifyUserPrivacyConfirmedInner();
            }
        }
    }

    private static void notifyUserPrivacyConfirmedInner() {
        if (WebViewFactory.getProvider() != null) {
            ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.sdk.WebKitFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    ResourceSchedulerEngine.getInstance().fetchIntegrationInfoFromServer();
                    CloudSettings.tryToUpdateCloudSettings(WebViewFactory.getContext());
                }
            });
        }
    }

    public static synchronized void removeListener(IForceInitZeusListener iForceInitZeusListener) {
        synchronized (WebKitFactory.class) {
            if (mListenerLst.contains(iForceInitZeusListener)) {
                mListenerLst.remove(iForceInitZeusListener);
            }
        }
    }

    public static void setAlreadySetEnabledJs(boolean z) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setAlreadySetEnabled(z);
        }
    }

    public static void setApkLibLoadType(boolean z) {
        sIsWebKitBuiltin = z;
    }

    public static void setAppVersionJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setAppVersion(str);
        }
    }

    public static void setAppidJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setAppid(str);
        }
    }

    public static void setBTransUrl(String str) {
        mJavaScriptInterface.setBTransUrl(str);
    }

    public static void setBlockedAdCountJs(int i) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setBlockedAdCount(i);
        }
    }

    public static void setCUIDString(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, sCUID)) {
            return;
        }
        sCUID = str;
        notifyCuidChanged();
    }

    public static void setCpuTypeJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setCpuType(str);
        }
    }

    public static void setCrashCallback(Context context, Class<? extends Object> cls) {
        Log.v("BR", "--WebKitFactory.java--setCrashCallback----" + cls);
        if (cls != null) {
            sCrashCallback = cls.getName();
        }
    }

    public static void setCssLoadedJs(boolean z) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setCssLoaded(z);
        }
    }

    public static void setCuidJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setCuid(str);
        }
    }

    public static void setCurrentUrlJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setCurrentUrl(str);
        }
    }

    public static void setEmulator(String str) {
        sEmulator = str;
    }

    public static void setEnableIntegratedCrashpad(boolean z) {
        sEnableIntegratedCrashpad = z;
    }

    public static void setEnableMultiprocess(boolean z) {
        sEnableMultipleProcess = z ? SwitchState.On : SwitchState.Off;
    }

    public static synchronized boolean setEngine(int i) {
        boolean z;
        synchronized (WebKitFactory.class) {
            WebViewFactory.installZesEngineIfNeeded(!ZeusSDK.usingZeusSDK(), false);
            WebViewFactory.setUseSystemWebView(1 != i);
            if (1 == i) {
                WebViewFactory.unzip();
            }
            WebViewFactory.getProvider();
            if (mDelayedInitTask == null) {
                DelayedInitTask delayedInitTask = new DelayedInitTask(WebViewFactory.hasProvider());
                mDelayedInitTask = delayedInitTask;
                delayedInitTask.start();
            }
            z = getCurEngine() == 1;
        }
        return z;
    }

    public static void setEngineJs(int i) {
        if (mJavaScriptInterface != null) {
            mJavaScriptInterface.setEngine(i);
        }
    }

    public static void setErrorCodeJs(int i) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setErrorCode(i);
        }
    }

    public static void setFirstJumpTypeJs(JsUploadTask.JumpType jumpType) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setFirstJumpType(jumpType);
        }
    }

    public static void setFirstJumpUrlJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setFirstJumpUrl(str);
        }
    }

    public static void setFirstScreenTimeJs(long j) {
        if (mJavaScriptInterface != null) {
            mJavaScriptInterface.setFirstScreenTime(j);
        }
    }

    public static void setGpuTypeJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setGpuType(str);
        }
    }

    public static void setHttpDnsJs(boolean z) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setHttpDns(z);
        }
    }

    public static void setHttpcode(int i) {
        if (mJavaScriptInterface != null) {
            mJavaScriptInterface.setHttpcode(i);
        }
    }

    public static void setIsMobileSiteJs(boolean z) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setIsMobileSite(z);
        }
    }

    public static void setKernelSessionId(String str) {
        sKernelSessionId = str;
    }

    public static void setLastJumpTypeJs(JsUploadTask.JumpType jumpType) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setLastJumpType(jumpType);
        }
    }

    public static void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
        WebViewFactoryProvider provider;
        if (getCurEngine() != 1 || (provider = WebViewFactory.getProvider()) == null) {
            return;
        }
        provider.setLocation(zeusGeoLocationInfo, z);
    }

    public static void setNeedDownloadCloudResource(boolean z) throws RuntimeException {
        if (sInited) {
            throw new RuntimeException("you should call method setNeedDownloadCloudResource before BdSailor.getInstance().initWebkit()");
        }
        sIsNeedDownloadCloudResource = z;
    }

    public static void setNetErrorJs(int i) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setNetError(i);
        }
    }

    public static void setNetTypeJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setNetType(str);
        }
    }

    public static void setNetcode(int i) {
        if (mJavaScriptInterface != null) {
            mJavaScriptInterface.setNetcode(i);
        }
    }

    public static void setPageFinishedTimeJs(long j) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setPageFinishedTime(j);
        }
    }

    public static void setPageStartTimeStamp(long j) {
        sPageStartTimeStamp = j;
        mJavaScriptInterface.setPageStartTime(j);
    }

    public static void setParsedTokensJs(int i) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setParsedTokens(i);
        }
    }

    public static void setProcessType(String str) {
        sProcessType = str;
    }

    public static void setReceivedDataSizeJs(int i) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setReceivedDataSize(i);
        }
    }

    public static void setSdkVerJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setSdkVer(str);
        }
    }

    public static void setSearchId(String str) {
        sSearchId = str;
        mJavaScriptInterface.setSearchId(str);
    }

    public static void setSpdyEnabledJs(boolean z) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setSpdyEnabled(z);
        }
    }

    public static void setStatisticsSessionIdJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setStatisticsSessionId(str);
        }
    }

    public static void setTimeStampJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setTimeStamp(str);
        }
    }

    public static void setWebKitClient(WebKitClient webKitClient) {
        sWebKitClient = webKitClient;
    }

    public static void setWebviewNumber(String str) {
        WebViewFactoryProvider provider = WebViewFactory.getProvider();
        if (provider != null) {
            provider.setWebviewNumber(str);
        }
    }

    public static void setWiseLandingPageType(int i) {
        if (mJavaScriptInterface != null) {
            mJavaScriptInterface.setWiseLandingPageType(i);
        }
    }

    public static void setZID(String str) {
        sZID = str;
    }

    public static void setZeusVerJs(String str) {
        if (mJavaScriptInterface != null) {
            JsUploadTask.setZeusVer(str);
        }
    }
}
