package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
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
/* loaded from: classes8.dex */
public class ZeusCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final long APPROXIMATE_START_TIME = System.currentTimeMillis();
    private static final boolean DEBUG = false;
    private static volatile boolean INITED = false;
    private static final String LOG_FILE_DIR_NAME = "zeuslogs";
    private static final String LOG_FILE_NAME = "logFile";
    private static final String NAME_SEPERATOR = " : ";
    private static final String TAG = "ZeusCrashHandler";
    private static ZeusCrashHandler sInstance;
    private ZeusCrashHandlerClient mClient;
    private Throwable mCrash;
    private Thread mCrashThread;
    private long mCrashTime;
    private CrashFilter mFilter;
    private final Thread.UncaughtExceptionHandler mPreviousHandler;

    /* loaded from: classes8.dex */
    public interface CrashFilter {
        boolean filt(Thread thread, Throwable th);
    }

    /* loaded from: classes8.dex */
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
        
        private final String mName;

        ExtraInfo(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.mName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class ZeusCrashHandlerClient {
        private static final String TAG = "CrashHandlerClientImpl";
        private PackageInfo mAppPackageInfo;
        private String mChannelName;
        private ZeusCrashHandler mHandler;

        /* JADX INFO: Access modifiers changed from: package-private */
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
            return getAppPackageInfo() != null ? new StringBuilder().append(getAppPackageInfo().versionCode).toString() : "0";
        }

        private String getBaseBand() {
            return Build.VERSION.SDK_INT >= 14 ? Build.getRadioVersion() : Build.RADIO;
        }

        private String getCPU() {
            String cpuInfoString = CpuInfo.getCpuInfoString();
            return (cpuInfoString == null || cpuInfoString.length() <= 0) ? "0" : cpuInfoString;
        }

        private String getChannelName() {
            BufferedReader bufferedReader;
            if (this.mChannelName == null) {
                try {
                    Context context = WebViewFactory.getContext();
                    bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()))));
                } catch (Throwable th) {
                    bufferedReader = null;
                }
                try {
                    this.mChannelName = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    try {
                        this.mChannelName = "0";
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th4) {
                            }
                        }
                        return this.mChannelName;
                    } catch (Throwable th5) {
                        BufferedReader bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th5;
                    }
                }
            }
            return this.mChannelName;
        }

        private String getDeviceId() {
            String deviceId;
            try {
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enableIMEI");
                if (GetCloudSettingsValue != null && GetCloudSettingsValue.toLowerCase(Locale.getDefault()).equals("true") && (deviceId = ((TelephonyManager) WebViewFactory.getContext().getSystemService("phone")).getDeviceId()) != null) {
                    if (deviceId.length() > 0) {
                        return deviceId;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return "0";
        }

        private String getModel() {
            String str = Build.MODEL;
            return (str == null || str.length() <= 0) ? "0" : str.replaceAll("[-_ ]", ".");
        }

        private String getZeusVersion() {
            PackageInfo loadedPackageInfo = WebViewFactory.getLoadedPackageInfo();
            return (loadedPackageInfo == null || loadedPackageInfo.versionName == null) ? "0" : loadedPackageInfo.versionName.replace(' ', '_');
        }

        public final String getExtraInfo(ExtraInfo extraInfo) {
            switch (extraInfo) {
                case CUID:
                    return WebKitFactory.getCUIDString();
                case EMULATOR:
                    return WebKitFactory.getEmulatorString();
                case CHANNEL_NAME:
                    return getChannelName();
                case ANDROID_BASEBAND:
                    return getBaseBand();
                case ANDROID_DISPLAY:
                    return Build.DISPLAY;
                case ANDROID_FINGERPRINT:
                    return Build.FINGERPRINT;
                case SDK_LEVEL:
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
                if (context != null) {
                    Intent intent = new Intent();
                    intent.setClass(context, DumperService.class);
                    intent.putExtra("LOG_TYPE", ZeusLogUploader.CRASH_LOG);
                    intent.putExtra("CRASH_TIME", this.mHandler.getCrashTimestamp());
                    intent.putExtra("CRASH_FILE", file.getAbsolutePath());
                    intent.putExtra("CRASH_SIGNAL", 0);
                    intent.putExtra("HTTPS", true);
                    context.startService(intent);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ZeusCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    static File createFileInSpecifiedDir(File file, String str) {
        File file2;
        if (file != null) {
            try {
                if (file.exists() && !file.isDirectory()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                file2 = new File(file, str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            file2 = null;
        }
        return file2;
    }

    private void dumpCrashThread(Writer writer) throws IOException {
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

    private void dumpExtraInfo(Writer writer) throws IOException {
        String str;
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
                    switch (extraInfo) {
                        case START_TIME:
                            str = getTimestmapString(getApproximateStartTimestamp());
                            continue;
                        case CRASH_TIME:
                            str = getTimestmapString(getCrashTimestamp());
                            continue;
                        case JAVA_EXCEPTION:
                            StringWriter stringWriter = new StringWriter();
                            this.mCrash.printStackTrace(new PrintWriter(stringWriter));
                            str = stringWriter.toString();
                            continue;
                        default:
                            str = "UnsupportedInJavaCrash";
                            continue;
                    }
                } else {
                    str = extraInfo2;
                }
                writer.write(str);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        File file = new File("/proc/version");
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
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th) {
            th = th;
            bufferedWriter = null;
        }
        try {
            dumpExtraInfo(bufferedWriter);
            bufferedWriter.write("\n\n");
            dumpProcStatus(bufferedWriter);
            bufferedWriter.write("\n\n");
            dumpSystemInfo(bufferedWriter);
            bufferedWriter.write("\n\n");
            dumpCrashThread(bufferedWriter);
            bufferedWriter.write("\n\n");
            dumpMapInfo(bufferedWriter);
            bufferedWriter.flush();
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                return false;
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th4) {
                    }
                }
            }
        }
    }

    public static ZeusCrashHandler getInstance() {
        return sInstance;
    }

    private File getLogFile() {
        Context context;
        File logFile = this.mClient != null ? this.mClient.getLogFile() : null;
        return (logFile != null || (context = WebViewFactory.getContext()) == null) ? logFile : createFileInSpecifiedDir(context.getExternalFilesDir(LOG_FILE_DIR_NAME), LOG_FILE_NAME);
    }

    private static String getTimestmapString(long j) {
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
        sInstance.setClient(new ZeusCrashHandlerClient(sInstance));
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
            } catch (Throwable th2) {
            }
            Log.e(TAG, "", th);
        }
    }

    private void writeFile(Writer writer, File file) throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    writer.write(readLine);
                    writer.write("\n");
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public long getApproximateStartTimestamp() {
        return APPROXIMATE_START_TIME;
    }

    public long getCrashTimestamp() {
        return this.mCrashTime;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.webkit.sdk.dumper.ZeusCrashHandler$2] */
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

    protected synchronized void onJavaCrash(Thread thread, Throwable th) {
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
            if (this.mFilter == null || this.mFilter.filt(thread, th)) {
                onJavaCrash(thread, th);
            }
        }
        if (this.mPreviousHandler != null) {
            this.mPreviousHandler.uncaughtException(thread, th);
        }
    }
}
