package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.webkit.internal.CpuInfo;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.DumperService;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
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
/* loaded from: classes5.dex */
public class ZeusCrashHandler implements Thread.UncaughtExceptionHandler {
    public static final long APPROXIMATE_START_TIME = System.currentTimeMillis();
    public static final boolean DEBUG = false;
    public static volatile boolean INITED = false;
    public static final String LOG_FILE_DIR_NAME = "zeuslogs";
    public static final String LOG_FILE_NAME = "logFile";
    public static final String NAME_SEPERATOR = " : ";
    public static final String TAG = "ZeusCrashHandler";
    public static ZeusCrashHandler sInstance;
    public ZeusCrashHandlerClient mClient;
    public Throwable mCrash;
    public Thread mCrashThread;
    public long mCrashTime;
    public CrashFilter mFilter;
    public final Thread.UncaughtExceptionHandler mPreviousHandler;

    /* renamed from: com.baidu.webkit.sdk.dumper.ZeusCrashHandler$5  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$webkit$sdk$dumper$ZeusCrashHandler$ExtraInfo;

        static {
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

    /* loaded from: classes5.dex */
    public interface CrashFilter {
        boolean filt(Thread thread, Throwable th);
    }

    /* loaded from: classes5.dex */
    public enum ExtraInfo {
        CUID("CUID"),
        EMULATOR("Emulator"),
        START_TIME("StartTime"),
        CRASH_TIME("CrashTime"),
        VISITED_URLS("VisitedUrls(Descending Order)"),
        JAVA_EXCEPTION("JavaFatalException"),
        ANDROID_FINGERPRINT("AndroidFingerprint"),
        SDK_LEVEL("SdkLevel"),
        GPU("GPU"),
        CHANNEL_NAME("ChannelName"),
        ANDROID_BASEBAND("AndroidBaseBand"),
        ANDROID_DISPLAY("AndroidDisplay"),
        LOGCAT("");
        
        public final String mName;

        ExtraInfo(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.mName;
        }
    }

    /* loaded from: classes5.dex */
    public static final class ZeusCrashHandlerClient {
        public static final String TAG = "CrashHandlerClientImpl";
        public PackageInfo mAppPackageInfo;
        public String mChannelName;
        public ZeusCrashHandler mHandler;

        public ZeusCrashHandlerClient(ZeusCrashHandler zeusCrashHandler) {
            this.mHandler = zeusCrashHandler;
        }

        private String getAndroidVersion() {
            String str = Build.VERSION.RELEASE;
            return (str == null || str.length() <= 0) ? "0" : str;
        }

        private String getAppName() {
            return getAppPackageInfo() != null ? getAppPackageInfo().packageName : "0";
        }

        private PackageInfo getAppPackageInfo() {
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

        private String getAppVersion() {
            return getAppPackageInfo() != null ? getAppPackageInfo().versionName : "0";
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000f: IGET  (r1v1 int A[REMOVE]) = 
          (wrap: android.content.pm.PackageInfo : 0x000b: INVOKE  (r1v0 android.content.pm.PackageInfo A[REMOVE]) = (r2v0 'this' com.baidu.webkit.sdk.dumper.ZeusCrashHandler$ZeusCrashHandlerClient A[IMMUTABLE_TYPE, THIS]) type: DIRECT call: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.ZeusCrashHandlerClient.getAppPackageInfo():android.content.pm.PackageInfo)
         android.content.pm.PackageInfo.versionCode int)] */
        private String getAppVersionCode() {
            if (getAppPackageInfo() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(getAppPackageInfo().versionCode);
                return sb.toString();
            }
            return "0";
        }

        private String getBaseBand() {
            return Build.VERSION.SDK_INT >= 14 ? Build.getRadioVersion() : Build.RADIO;
        }

        private String getCPU() {
            String cpuInfoString = CpuInfo.getCpuInfoString();
            return (cpuInfoString == null || cpuInfoString.length() <= 0) ? "0" : cpuInfoString;
        }

        private String getChannelName() {
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

        private String getDeviceId() {
            String deviceId;
            try {
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enableIMEI");
                return (GetCloudSettingsValue == null || !GetCloudSettingsValue.toLowerCase(Locale.getDefault()).equals("true") || (deviceId = ((TelephonyManager) WebViewFactory.getContext().getSystemService("phone")).getDeviceId()) == null) ? "0" : deviceId.length() > 0 ? deviceId : "0";
            } catch (Throwable th) {
                th.printStackTrace();
                return "0";
            }
        }

        private String getModel() {
            String str = Build.MODEL;
            return (str == null || str.length() <= 0) ? "0" : str.replaceAll("[-_ ]", ".");
        }

        private String getZeusVersion() {
            String str;
            PackageInfo loadedPackageInfo = WebViewFactory.getLoadedPackageInfo();
            return (loadedPackageInfo == null || (str = loadedPackageInfo.versionName) == null) ? "0" : str.replace(' ', '_');
        }

        public final String getExtraInfo(ExtraInfo extraInfo) {
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

        public final File getLogFile() {
            return getLogFile("", ZeusCrashHandler.LOG_FILE_DIR_NAME);
        }

        public final File getLogFile(String str, String str2) {
            try {
                return ZeusCrashHandler.createFileInSpecifiedDir(new File(WebViewFactory.getContext().getFilesDir(), str2), String.format("%s-%s-%s-%s-%s-%s-%s-%s-%d.bdmp", str + getAppVersion(), getAppVersionCode(), getAppName(), getZeusVersion(), getModel(), getCPU(), getAndroidVersion(), getDeviceId(), Long.valueOf(this.mHandler.getCrashTimestamp())));
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public final void onUploadLogFile(File file) {
            if (file == null) {
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

    public ZeusCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    public static File createFileInSpecifiedDir(File file, String str) {
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

    private void dumpCrashThread(Writer writer) throws IOException {
        writer.write("Crash reason: ");
        writer.write(this.mCrash.toString());
        writer.write("\n");
        StackTraceElement[] stackTrace = this.mCrash.getStackTrace();
        writer.write("Crash address: ");
        writer.write(stackTrace != null ? stackTrace[0].toString() : "Unkown");
        writer.write("\n");
        double d2 = this.mCrashTime - APPROXIMATE_START_TIME;
        Double.isNaN(d2);
        writer.write(String.format("Process uptime: %s H\n\n", String.valueOf(d2 / 3600000.0d)));
        writer.write(String.format("Thread %d:%s (crashed)\n", Long.valueOf(this.mCrashThread.getId()), this.mCrashThread.getName()));
        this.mCrash.printStackTrace(new PrintWriter(writer));
    }

    private void dumpExtraInfo(Writer writer) throws IOException {
        long approximateStartTimestamp;
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

    private void dumpExtraLogcatInfo(final Writer writer) throws IOException {
        try {
            final Process exec = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t150", "-vthreadtime"}, (String[]) null);
            Thread thread = new Thread(new Runnable() { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    ZeusCrashHandler.this.wirteStream(writer, exec.getInputStream());
                }
            });
            Thread thread2 = new Thread(new Runnable() { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    ZeusCrashHandler.this.wirteStream(writer, exec.getErrorStream());
                }
            });
            thread.start();
            thread2.start();
            int waitFor = exec.waitFor();
            thread.join();
            thread2.join();
            Log.d(TAG, "dumpExtraLogcatInfo exitCode=" + waitFor);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void dumpIdentification(Writer writer) throws IOException {
        StackTraceElement[] stackTrace = this.mCrash.getStackTrace();
        writer.write("JavaCrashID");
        writer.write(NAME_SEPERATOR);
        Object[] objArr = new Object[3];
        objArr[0] = stackTrace != null ? stackTrace[0].toString() : "Unkown";
        objArr[1] = this.mCrash.getClass().getName();
        objArr[2] = this.mCrash.getLocalizedMessage();
        writer.write(String.format("%s|%s(\"%s\")", objArr));
    }

    private void dumpMapInfo(Writer writer) throws IOException {
        File file = new File(String.format("/proc/%d/maps", Integer.valueOf(Process.myPid())));
        if (file.exists() && file.canRead()) {
            writer.write("Maps:\n");
            writeFile(writer, file);
        }
    }

    private void dumpProcStatus(Writer writer) throws IOException {
        File file = new File(String.format("/proc/%d/status", Integer.valueOf(Process.myPid())));
        if (file.exists() && file.canRead()) {
            writer.write("PROC_STATUS:\n");
            writeFile(writer, file);
        }
    }

    private void dumpSystemInfo(Writer writer) throws IOException {
        File file = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
        if (file.exists() && file.canRead()) {
            writer.write("Operating system: Android\n");
            writeFile(writer, file);
        }
        File file2 = new File("/proc/cpuinfo");
        if (file2.exists() && file2.canRead()) {
            writer.write(String.format("\nCPU: %s\n", Build.CPU_ABI));
            writeFile(writer, file2);
        }
    }

    private boolean generateNativeCrashLog(File file) {
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
        return sInstance;
    }

    private File getLogFile() {
        Context context;
        ZeusCrashHandlerClient zeusCrashHandlerClient = this.mClient;
        File logFile = zeusCrashHandlerClient != null ? zeusCrashHandlerClient.getLogFile() : null;
        return (logFile != null || (context = WebViewFactory.getContext()) == null) ? logFile : createFileInSpecifiedDir(context.getExternalFilesDir(LOG_FILE_DIR_NAME), LOG_FILE_NAME);
    }

    public static String getTimestmapString(long j) {
        return DateFormat.getDateTimeInstance().format(Long.valueOf(j));
    }

    public static void init() {
        if (INITED) {
            return;
        }
        INITED = true;
        ZeusCrashHandler zeusCrashHandler = new ZeusCrashHandler(Thread.getDefaultUncaughtExceptionHandler());
        sInstance = zeusCrashHandler;
        Thread.setDefaultUncaughtExceptionHandler(zeusCrashHandler);
        ZeusCrashHandler zeusCrashHandler2 = sInstance;
        zeusCrashHandler2.setClient(new ZeusCrashHandlerClient(zeusCrashHandler2));
        sInstance.setCrashFilter(new CrashFilter() { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.1
            @Override // com.baidu.webkit.sdk.dumper.ZeusCrashHandler.CrashFilter
            public boolean filt(Thread thread, Throwable th) {
                return (th instanceof UnsatisfiedLinkError) || (th instanceof AbstractMethodError) || (th instanceof StackOverflowError) || (th instanceof NoSuchFieldError) || (th instanceof NoClassDefFoundError) || (th instanceof NoSuchMethodError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wirteStream(Writer writer, InputStream inputStream) {
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
        return APPROXIMATE_START_TIME;
    }

    public long getCrashTimestamp() {
        return this.mCrashTime;
    }

    public void logException(final Throwable th) {
        setCrashTime(System.currentTimeMillis());
        Log.i(TAG, "logException", th);
        final Thread currentThread = Thread.currentThread();
        new Thread() { // from class: com.baidu.webkit.sdk.dumper.ZeusCrashHandler.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ZeusCrashHandler.this.onJavaCrash(currentThread, th);
            }
        }.start();
    }

    public synchronized void onJavaCrash(Thread thread, Throwable th) {
        this.mCrashThread = thread;
        this.mCrash = th;
        File logFile = getLogFile();
        if (logFile != null && generateNativeCrashLog(logFile) && this.mClient != null) {
            this.mClient.onUploadLogFile(logFile);
        }
    }

    public void setClient(ZeusCrashHandlerClient zeusCrashHandlerClient) {
        this.mClient = zeusCrashHandlerClient;
    }

    public void setCrashFilter(CrashFilter crashFilter) {
        this.mFilter = crashFilter;
    }

    public void setCrashTime(long j) {
        this.mCrashTime = j;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
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
