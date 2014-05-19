package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ad;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class q implements Thread.UncaughtExceptionHandler {
    public static final String[] a = {"com.baidu.android.systemmonitor", "com.baidu.android.defense", "com.baidu.android.moplus", "com.baidu.android.nebula", "com.baidu.android.a."};
    public static final String[] b = {"com.baidu.lightapp", "com.baidu.channelrtc"};
    private static final String d = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler c = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:135:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023c A[Catch: Exception -> 0x028d, TryCatch #0 {Exception -> 0x028d, blocks: (B:92:0x0237, B:94:0x023c, B:96:0x0241), top: B:135:0x0237 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0241 A[Catch: Exception -> 0x028d, TRY_LEAVE, TryCatch #0 {Exception -> 0x028d, blocks: (B:92:0x0237, B:94:0x023c, B:96:0x0241), top: B:135:0x0237 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024a  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        FileWriter fileWriter;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        FileWriter fileWriter2 = null;
        if (TbConfig.getDebugSwitch() && a(th)) {
            a();
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    try {
                        th.printStackTrace(printStream);
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (TbConfig.getDebugSwitch()) {
                            str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                        } else {
                            str = TbConfig.FATAL_ERROR_FILE;
                        }
                        File g = x.g(str);
                        if (g != null && g.length() < 204800 && str2 != null) {
                            fileWriter = new FileWriter(g, true);
                            try {
                                a(fileWriter, be.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", TbConfig.getVersion());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", TbConfig.getFrom());
                                a(fileWriter, "current_from", TbConfig.getCurrentFrom());
                                a(fileWriter, SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
                                a(fileWriter, "client_id", TbadkApplication.getClientId());
                                a(fileWriter, "imei", TbadkApplication.m252getInst().getImei());
                                a(fileWriter, "uname", TbadkApplication.getCurrentAccountName());
                                a(fileWriter, "activity", bg.b());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                a(fileWriter, "crash_type", th.getClass().getName());
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) ad.c().d().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i).pid != myPid) {
                                            i++;
                                        } else {
                                            a(fileWriter, "process_name", runningAppProcesses.get(i).processName);
                                            break;
                                        }
                                    }
                                }
                                a(fileWriter, "error", str2);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
                                fileWriter.flush();
                                fileWriter2 = fileWriter;
                            } catch (Exception e) {
                                e = e;
                                fileWriter2 = fileWriter;
                                printStream2 = printStream;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    e.printStackTrace();
                                    if (printStream2 != null) {
                                        try {
                                            printStream2.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            if (!TbConfig.getDebugSwitch() && this.c != null) {
                                                this.c.uncaughtException(thread, th);
                                                return;
                                            } else {
                                                Process.killProcess(Process.myPid());
                                                return;
                                            }
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    fileWriter = fileWriter2;
                                    if (printStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (fileWriter != null) {
                                    }
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (printStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (fileWriter != null) {
                                }
                                if (!TbConfig.getDebugSwitch()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        if (str2 != null) {
                            try {
                                if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TbadkApplication.m252getInst().setWebviewCrashCount(TbadkApplication.m252getInst().getWebviewCrashCount() + 1);
                                } else if (str2.contains("com.baidu.location")) {
                                    ad.c().A();
                                } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                    com.baidu.adp.lib.a.f.a().a("motu_sdk", 1);
                                }
                                if (str2.contains("com.baidu.sapi2")) {
                                    TbadkApplication.m252getInst().incPassportV6CrashCount();
                                }
                                if (str2.contains("com.baidu.mobstat")) {
                                    TbadkApplication.m252getInst().incMobstatCrashCount();
                                }
                                String[] strArr = a;
                                int length = strArr.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        break;
                                    } else if (!str2.contains(strArr[i2])) {
                                        i2++;
                                    } else {
                                        TbadkApplication.m252getInst().incMoPlusCrashCount();
                                        break;
                                    }
                                }
                                String[] strArr2 = b;
                                int length2 = strArr2.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length2) {
                                        break;
                                    } else if (!str2.contains(strArr2[i3])) {
                                        i3++;
                                    } else {
                                        TbadkApplication.m252getInst().incLiveSdkCrashCount();
                                        break;
                                    }
                                }
                                if (bg.a() != null && bg.a().indexOf("NewVcode") != -1) {
                                    ad.c().e(ad.c().z() + 1);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileWriter = fileWriter2;
                                if (printStream != null) {
                                    try {
                                        printStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        if (!TbConfig.getDebugSwitch() && this.c != null) {
                                            this.c.uncaughtException(thread, th);
                                        } else {
                                            Process.killProcess(Process.myPid());
                                        }
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (fileWriter != null) {
                                    fileWriter.close();
                                }
                                if (!TbConfig.getDebugSwitch()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        com.baidu.adp.lib.a.f.a().a(str2);
                        if (!TextUtils.isEmpty(str2)) {
                            BdLog.e(str2);
                        }
                        if (printStream != null) {
                            try {
                                printStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (fileWriter2 != null) {
                            fileWriter2.close();
                        }
                        if (TbConfig.getDebugSwitch() && this.c != null) {
                            this.c.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    printStream2 = printStream;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                }
            } catch (Exception e6) {
                e = e6;
                printStream2 = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th6) {
                th = th6;
                fileWriter = null;
                printStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            printStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            fileWriter = null;
            printStream = null;
            byteArrayOutputStream = null;
        }
    }

    private void a(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "addInfo", e.getMessage());
        }
    }

    public static boolean a(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return a(cause);
        }
        return false;
    }

    private void a() {
        BdLog.e("OOM!!!please keep alive, and getting in touch with RD!");
        try {
            File file = new File(d);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(d) + System.currentTimeMillis());
        } catch (Exception e) {
            BdLog.e("couldn’t dump hprof:Exception");
        } catch (OutOfMemoryError e2) {
            BdLog.e("couldn’t dump hprof: OutOfMemoryError");
        }
    }
}
