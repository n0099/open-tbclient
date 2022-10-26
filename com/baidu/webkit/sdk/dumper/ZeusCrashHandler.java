package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.baidu.webkit.internal.CpuInfo;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.DumperService;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kuaishou.weapon.p0.k1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread;
import java.text.DateFormat;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ZeusCrashHandler implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long APPROXIMATE_START_TIME;
    public static final boolean DEBUG = false;
    public static volatile boolean INITED = false;
    public static final String LOG_FILE_DIR_NAME = "zeuslogs";
    public static final String LOG_FILE_NAME = "logFile";
    public static final String NAME_SEPERATOR = " : ";
    public static final String TAG = "ZeusCrashHandler";
    public static ZeusCrashHandler sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ZeusCrashHandlerClient mClient;
    public Throwable mCrash;
    public Thread mCrashThread;
    public long mCrashTime;
    public CrashFilter mFilter;
    public final Thread.UncaughtExceptionHandler mPreviousHandler;

    /* renamed from: com.baidu.webkit.sdk.dumper.ZeusCrashHandler$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-701133116, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler$5;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-701133116, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler$5;");
                    return;
                }
            }
            int[] iArr = new int[ExtraInfo.values().length];
            $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo = iArr;
            try {
                iArr[ExtraInfo.CUID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.EMULATOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.CHANNEL_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.ANDROID_BASEBAND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.ANDROID_DISPLAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.ANDROID_FINGERPRINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.SDK_LEVEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.VISITED_URLS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.GPU.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.START_TIME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.CRASH_TIME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[ExtraInfo.JAVA_EXCEPTION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface CrashFilter {
        boolean filt(Thread thread, Throwable th);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public final class ExtraInfo {
        public static final /* synthetic */ ExtraInfo[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ExtraInfo ANDROID_BASEBAND;
        public static final ExtraInfo ANDROID_DISPLAY;
        public static final ExtraInfo ANDROID_FINGERPRINT;
        public static final ExtraInfo CHANNEL_NAME;
        public static final ExtraInfo CRASH_TIME;
        public static final ExtraInfo CUID;
        public static final ExtraInfo EMULATOR;
        public static final ExtraInfo GPU;
        public static final ExtraInfo JAVA_EXCEPTION;
        public static final ExtraInfo LOGCAT;
        public static final ExtraInfo SDK_LEVEL;
        public static final ExtraInfo START_TIME;
        public static final ExtraInfo VISITED_URLS;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(777985371, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler$ExtraInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(777985371, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler$ExtraInfo;");
                    return;
                }
            }
            CUID = new ExtraInfo("CUID", 0, "CUID");
            EMULATOR = new ExtraInfo("EMULATOR", 1, "Emulator");
            START_TIME = new ExtraInfo("START_TIME", 2, "StartTime");
            CRASH_TIME = new ExtraInfo("CRASH_TIME", 3, "CrashTime");
            VISITED_URLS = new ExtraInfo("VISITED_URLS", 4, "VisitedUrls(Descending Order)");
            JAVA_EXCEPTION = new ExtraInfo("JAVA_EXCEPTION", 5, "JavaFatalException");
            ANDROID_FINGERPRINT = new ExtraInfo("ANDROID_FINGERPRINT", 6, "AndroidFingerprint");
            SDK_LEVEL = new ExtraInfo("SDK_LEVEL", 7, "SdkLevel");
            GPU = new ExtraInfo("GPU", 8, "GPU");
            CHANNEL_NAME = new ExtraInfo(Tun2tornado.ENV_CHANNEL_NAME, 9, "ChannelName");
            ANDROID_BASEBAND = new ExtraInfo("ANDROID_BASEBAND", 10, "AndroidBaseBand");
            ANDROID_DISPLAY = new ExtraInfo("ANDROID_DISPLAY", 11, "AndroidDisplay");
            ExtraInfo extraInfo = new ExtraInfo("LOGCAT", 12, "");
            LOGCAT = extraInfo;
            $VALUES = new ExtraInfo[]{CUID, EMULATOR, START_TIME, CRASH_TIME, VISITED_URLS, JAVA_EXCEPTION, ANDROID_FINGERPRINT, SDK_LEVEL, GPU, CHANNEL_NAME, ANDROID_BASEBAND, ANDROID_DISPLAY, extraInfo};
        }

        public ExtraInfo(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mName = str2;
        }

        public static ExtraInfo valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ExtraInfo) Enum.valueOf(ExtraInfo.class, str) : (ExtraInfo) invokeL.objValue;
        }

        public static ExtraInfo[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ExtraInfo[]) $VALUES.clone() : (ExtraInfo[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mName : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class ZeusCrashHandlerClient {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "CrashHandlerClientImpl";
        public transient /* synthetic */ FieldHolder $fh;
        public PackageInfo mAppPackageInfo;
        public String mChannelName;
        public ZeusCrashHandler mHandler;

        public ZeusCrashHandlerClient(ZeusCrashHandler zeusCrashHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zeusCrashHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHandler = zeusCrashHandler;
        }

        private String getAndroidVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                String str = Build.VERSION.RELEASE;
                return (str == null || str.length() <= 0) ? "0" : str;
            }
            return (String) invokeV.objValue;
        }

        private String getAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? getAppPackageInfo() != null ? getAppPackageInfo().packageName : "0" : (String) invokeV.objValue;
        }

        private PackageInfo getAppPackageInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.mAppPackageInfo == null) {
                    try {
                        Context context = WebViewFactory.getContext();
                        this.mAppPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return this.mAppPackageInfo;
            }
            return (PackageInfo) invokeV.objValue;
        }

        private String getAppVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? getAppPackageInfo() != null ? getAppPackageInfo().versionName : "0" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0013: IGET  (r1v3 int A[REMOVE]) = 
          (wrap: android.content.pm.PackageInfo : 0x000f: INVOKE  (r1v2 android.content.pm.PackageInfo A[REMOVE]) = (r4v0 'this' com.baidu.webkit.sdk.dumper.ZeusCrashHandler$ZeusCrashHandlerClient A[IMMUTABLE_TYPE, THIS]) type: DIRECT call: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.ZeusCrashHandlerClient.getAppPackageInfo():android.content.pm.PackageInfo)
         android.content.pm.PackageInfo.versionCode int)] */
        private String getAppVersionCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                if (getAppPackageInfo() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getAppPackageInfo().versionCode);
                    return sb.toString();
                }
                return "0";
            }
            return (String) invokeV.objValue;
        }

        private String getBaseBand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? Build.VERSION.SDK_INT >= 14 ? Build.getRadioVersion() : Build.RADIO : (String) invokeV.objValue;
        }

        private String getCPU() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
                String cpuInfoString = CpuInfo.getCpuInfoString();
                return (cpuInfoString == null || cpuInfoString.length() <= 0) ? "0" : cpuInfoString;
            }
            return (String) invokeV.objValue;
        }

        private String getChannelName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
                if (this.mChannelName == null) {
                    BufferedReader bufferedReader = null;
                    try {
                        try {
                            Context context = WebViewFactory.getContext();
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()))));
                            try {
                                this.mChannelName = bufferedReader2.readLine();
                                bufferedReader2.close();
                            } catch (Throwable unused) {
                                bufferedReader = bufferedReader2;
                                try {
                                    this.mChannelName = "0";
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return this.mChannelName;
                                } catch (Throwable th) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                    }
                }
                return this.mChannelName;
            }
            return (String) invokeV.objValue;
        }

        private String getDeviceId() {
            String deviceId;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                try {
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enableIMEI");
                    return (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase(Locale.getDefault()).equals("true") || (deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) WebViewFactory.getContext().getSystemService("phone"))) == null) ? "0" : deviceId.length() > 0 ? deviceId : "0";
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "0";
                }
            }
            return (String) invokeV.objValue;
        }

        private String getModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
                String str = Build.MODEL;
                return (str == null || str.length() <= 0) ? "0" : str.replaceAll("[-_ ]", ".");
            }
            return (String) invokeV.objValue;
        }

        private String getZeusVersion() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
                PackageInfo loadedPackageInfo = WebViewFactory.getLoadedPackageInfo();
                return (loadedPackageInfo == null || (str = loadedPackageInfo.versionName) == null) ? "0" : str.replace(WebvttCueParser.CHAR_SPACE, '_');
            }
            return (String) invokeV.objValue;
        }

        public final String getExtraInfo(ExtraInfo extraInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extraInfo)) == null) {
                switch (AnonymousClass5.$SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[extraInfo.ordinal()]) {
                    case 1:
                        return WebKitFactory.getCUIDString();
                    case 2:
                        return WebKitFactory.getEmulatorString();
                    case 3:
                        return getChannelName();
                    case 4:
                        return getBaseBand();
                    case 5:
                        return Build.DISPLAY;
                    case 6:
                        return Build.FINGERPRINT;
                    case 7:
                        return String.valueOf(Build.VERSION.SDK_INT);
                    default:
                        return null;
                }
            }
            return (String) invokeL.objValue;
        }

        public final File getLogFile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getLogFile("", ZeusCrashHandler.LOG_FILE_DIR_NAME) : (File) invokeV.objValue;
        }

        public final File getLogFile(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                try {
                    return ZeusCrashHandler.createFileInSpecifiedDir(new File(WebViewFactory.getContext().getFilesDir(), str2), String.format("%s-%s-%s-%s-%s-%s-%s-%s-%d.bdmp", str + getAppVersion(), getAppVersionCode(), getAppName(), getZeusVersion(), getModel(), getCPU(), getAndroidVersion(), getDeviceId(), Long.valueOf(this.mHandler.getCrashTimestamp())));
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (File) invokeLL.objValue;
        }

        public final void onUploadLogFile(File file) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, file) == null) || file == null) {
                return;
            }
            try {
                Context context = WebViewFactory.getContext();
                if (context == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, DumperService.class);
                intent.putExtra("LOG_TYPE", "crashlog");
                intent.putExtra("CRASH_TIME", this.mHandler.getCrashTimestamp());
                intent.putExtra("CRASH_FILE", file.getAbsolutePath());
                intent.putExtra("CRASH_SIGNAL", 0);
                intent.putExtra("HTTPS", true);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737815989, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737815989, "Lcom/baidu/webkit/sdk/dumper/ZeusCrashHandler;");
                return;
            }
        }
        APPROXIMATE_START_TIME = System.currentTimeMillis();
    }

    public ZeusCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uncaughtExceptionHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    public static File createFileInSpecifiedDir(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, str)) == null) {
            if (file != null) {
                try {
                    if (file.exists() && !file.isDirectory()) {
                        file.delete();
                    }
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    return new File(file, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    private void dumpCrashThread(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, writer) == null) {
            writer.write("Crash reason: ");
            writer.write(this.mCrash.toString());
            writer.write("\n");
            StackTraceElement[] stackTrace = this.mCrash.getStackTrace();
            writer.write("Crash address: ");
            writer.write(stackTrace != null ? stackTrace[0].toString() : "Unkown");
            writer.write("\n");
            writer.write(String.format("Process uptime: %s H\n\n", String.valueOf((this.mCrashTime - APPROXIMATE_START_TIME) / 3600000.0d)));
            writer.write(String.format("Thread %d:%s (crashed)\n", Long.valueOf(this.mCrashThread.getId()), this.mCrashThread.getName()));
            this.mCrash.printStackTrace(new PrintWriter(writer));
        }
    }

    private void dumpExtraInfo(Writer writer) throws IOException {
        long approximateStartTimestamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, writer) == null) {
            dumpIdentification(writer);
            writer.write("\n************************************************\n");
            if (this.mClient != null) {
                Iterator it = EnumSet.range(ExtraInfo.CUID, ExtraInfo.ANDROID_DISPLAY).iterator();
                while (it.hasNext()) {
                    ExtraInfo extraInfo = (ExtraInfo) it.next();
                    writer.write(extraInfo.toString());
                    writer.write(NAME_SEPERATOR);
                    String extraInfo2 = this.mClient.getExtraInfo(extraInfo);
                    if (extraInfo2 == null) {
                        switch (AnonymousClass5.$SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo[extraInfo.ordinal()]) {
                            case 10:
                                approximateStartTimestamp = getApproximateStartTimestamp();
                                extraInfo2 = getTimestmapString(approximateStartTimestamp);
                                break;
                            case 11:
                                approximateStartTimestamp = getCrashTimestamp();
                                extraInfo2 = getTimestmapString(approximateStartTimestamp);
                                break;
                            case 12:
                                StringWriter stringWriter = new StringWriter();
                                this.mCrash.printStackTrace(new PrintWriter(stringWriter));
                                extraInfo2 = stringWriter.toString();
                                break;
                            default:
                                extraInfo2 = "UnsupportedInJavaCrash";
                                break;
                        }
                    }
                    writer.write(extraInfo2);
                    writer.write("\n************************************************\n");
                }
            }
            dumpExtraLogcatInfo(writer);
        }
    }

    private void dumpExtraLogcatInfo(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, writer) == null) {
            try {
                Process exec = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t150", "-vthreadtime"}, (String[]) null);
                Thread thread = new Thread(new Runnable(this, writer, exec) { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ZeusCrashHandler this$0;
                    public final /* synthetic */ Process val$process;
                    public final /* synthetic */ Writer val$writer;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, writer, exec};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$writer = writer;
                        this.val$process = exec;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.wirteStream(this.val$writer, this.val$process.getInputStream());
                        }
                    }
                });
                Thread thread2 = new Thread(new Runnable(this, writer, exec) { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ZeusCrashHandler this$0;
                    public final /* synthetic */ Process val$process;
                    public final /* synthetic */ Writer val$writer;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, writer, exec};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$writer = writer;
                        this.val$process = exec;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.wirteStream(this.val$writer, this.val$process.getErrorStream());
                        }
                    }
                });
                thread.start();
                thread2.start();
                int waitFor = exec.waitFor();
                thread.join();
                thread2.join();
                Log.d(TAG, "dumpExtraLogcatInfo exitCode=".concat(String.valueOf(waitFor)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dumpIdentification(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, writer) == null) {
            StackTraceElement[] stackTrace = this.mCrash.getStackTrace();
            writer.write("JavaCrashID");
            writer.write(NAME_SEPERATOR);
            Object[] objArr = new Object[3];
            objArr[0] = stackTrace != null ? stackTrace[0].toString() : "Unkown";
            objArr[1] = this.mCrash.getClass().getName();
            objArr[2] = this.mCrash.getLocalizedMessage();
            writer.write(String.format("%s|%s(\"%s\")", objArr));
        }
    }

    private void dumpMapInfo(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, writer) == null) {
            File file = new File(String.format("/proc/%d/maps", Integer.valueOf(Process.myPid())));
            if (file.exists() && file.canRead()) {
                writer.write("Maps:\n");
                writeFile(writer, file);
            }
        }
    }

    private void dumpProcStatus(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, writer) == null) {
            File file = new File(String.format("/proc/%d/status", Integer.valueOf(Process.myPid())));
            if (file.exists() && file.canRead()) {
                writer.write("PROC_STATUS:\n");
                writeFile(writer, file);
            }
        }
    }

    private void dumpSystemInfo(Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, writer) == null) {
            File file = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
            if (file.exists() && file.canRead()) {
                writer.write("Operating system: Android\n");
                writeFile(writer, file);
            }
            File file2 = new File(k1.a);
            if (file2.exists() && file2.canRead()) {
                writer.write(String.format("\nCPU: %s\n", Build.CPU_ABI));
                writeFile(writer, file2);
            }
        }
    }

    private boolean generateNativeCrashLog(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, this, file)) != null) {
            return invokeL.booleanValue;
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                dumpExtraInfo(bufferedWriter2);
                bufferedWriter2.write("\n\n");
                dumpProcStatus(bufferedWriter2);
                bufferedWriter2.write("\n\n");
                dumpSystemInfo(bufferedWriter2);
                bufferedWriter2.write("\n\n");
                dumpCrashThread(bufferedWriter2);
                bufferedWriter2.write("\n\n");
                dumpMapInfo(bufferedWriter2);
                bufferedWriter2.flush();
                try {
                    bufferedWriter2.close();
                    return true;
                } catch (Throwable unused) {
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                try {
                    th.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                            return false;
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static ZeusCrashHandler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sInstance : (ZeusCrashHandler) invokeV.objValue;
    }

    private File getLogFile() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ZeusCrashHandlerClient zeusCrashHandlerClient = this.mClient;
            File logFile = zeusCrashHandlerClient != null ? zeusCrashHandlerClient.getLogFile() : null;
            return (logFile != null || (context = WebViewFactory.getContext()) == null) ? logFile : createFileInSpecifiedDir(context.getExternalFilesDir(LOG_FILE_DIR_NAME), LOG_FILE_NAME);
        }
        return (File) invokeV.objValue;
    }

    public static String getTimestmapString(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j)) == null) ? DateFormat.getDateTimeInstance().format(Long.valueOf(j)) : (String) invokeJ.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || INITED) {
            return;
        }
        INITED = true;
        ZeusCrashHandler zeusCrashHandler = new ZeusCrashHandler(Thread.getDefaultUncaughtExceptionHandler());
        sInstance = zeusCrashHandler;
        Thread.setDefaultUncaughtExceptionHandler(zeusCrashHandler);
        ZeusCrashHandler zeusCrashHandler2 = sInstance;
        zeusCrashHandler2.setClient(new ZeusCrashHandlerClient(zeusCrashHandler2));
        sInstance.setCrashFilter(new CrashFilter() { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.webkit.sdk.dumper.ZeusCrashHandler.CrashFilter
            public boolean filt(Thread thread, Throwable th) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, thread, th)) == null) ? (th instanceof UnsatisfiedLinkError) || (th instanceof AbstractMethodError) || (th instanceof StackOverflowError) || (th instanceof NoSuchFieldError) || (th instanceof NoClassDefFoundError) || (th instanceof NoSuchMethodError) : invokeLL.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wirteStream(Writer writer, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65552, this, writer, inputStream) != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                writer.write(readLine);
                writer.write("\n");
            }
        } catch (Throwable th) {
            try {
                writer.write("Throwable:");
                writer.write(th.getMessage());
                writer.write("\n");
            } catch (Throwable unused) {
            }
            Log.e(TAG, "", th);
        }
    }

    private void writeFile(Writer writer, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65553, this, writer, file) != null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    writer.write(readLine);
                    writer.write("\n");
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public long getApproximateStartTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? APPROXIMATE_START_TIME : invokeV.longValue;
    }

    public long getCrashTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCrashTime : invokeV.longValue;
    }

    public void logException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            setCrashTime(System.currentTimeMillis());
            Log.i(TAG, "logException", th);
            new Thread(this, Thread.currentThread(), th) { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ZeusCrashHandler this$0;
                public final /* synthetic */ Thread val$exceptionThread;
                public final /* synthetic */ Throwable val$t;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, th};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$exceptionThread = r7;
                    this.val$t = th;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onJavaCrash(this.val$exceptionThread, this.val$t);
                    }
                }
            }.start();
        }
    }

    public synchronized void onJavaCrash(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, thread, th) == null) {
            synchronized (this) {
                this.mCrashThread = thread;
                this.mCrash = th;
                File logFile = getLogFile();
                if (logFile != null && generateNativeCrashLog(logFile) && this.mClient != null) {
                    this.mClient.onUploadLogFile(logFile);
                }
            }
        }
    }

    public void setClient(ZeusCrashHandlerClient zeusCrashHandlerClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zeusCrashHandlerClient) == null) {
            this.mClient = zeusCrashHandlerClient;
        }
    }

    public void setCrashFilter(CrashFilter crashFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, crashFilter) == null) {
            this.mFilter = crashFilter;
        }
    }

    public void setCrashTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mCrashTime = j;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, thread, th) == null) {
            setCrashTime(System.currentTimeMillis());
            if (!WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(TAG, "(ZeusCrashHandler)");
                CrashFilter crashFilter = this.mFilter;
                if (crashFilter == null || crashFilter.filt(thread, th)) {
                    onJavaCrash(thread, th);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mPreviousHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
