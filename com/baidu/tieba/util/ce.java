package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class ce implements Thread.UncaughtExceptionHandler {
    private static final String b = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:119:0x0225 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022a A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:85:0x0225, B:87:0x022a, B:89:0x022f), top: B:119:0x0225 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022f A[Catch: Exception -> 0x0250, TRY_LEAVE, TryCatch #0 {Exception -> 0x0250, blocks: (B:85:0x0225, B:87:0x022a, B:89:0x022f), top: B:119:0x0225 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0238  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void uncaughtException(Thread thread, Throwable th) {
        FileWriter fileWriter;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        FileWriter fileWriter2 = null;
        if (com.baidu.tieba.data.i.F() && a(th)) {
            com.baidu.adp.lib.util.e.b("OOM!!!please keep alive, and getting in touch with RD!");
            try {
                File file = new File(b);
                if (!file.exists()) {
                    file.mkdir();
                }
                Debug.dumpHprofData(String.valueOf(b) + System.currentTimeMillis());
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("couldn’t dump hprof:Exception");
            } catch (OutOfMemoryError e2) {
                com.baidu.adp.lib.util.e.b("couldn’t dump hprof: OutOfMemoryError");
            }
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    try {
                        th.printStackTrace(printStream);
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (com.baidu.tieba.data.i.F()) {
                            str = "fatal_error_debug.log";
                        } else {
                            str = "fatal_error.log";
                        }
                        File g = af.g(str);
                        if (g != null && g.length() < 204800) {
                            fileWriter = new FileWriter(g, true);
                            try {
                                a(fileWriter, bs.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.data.i.u());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", com.baidu.tieba.data.i.l());
                                a(fileWriter, "current_from", com.baidu.tieba.data.i.m());
                                a(fileWriter, SapiAccountManager.SESSION_UID, TiebaApplication.v());
                                a(fileWriter, SocialConstants.PARAM_CLIENT_ID, TiebaApplication.E());
                                a(fileWriter, "imei", TiebaApplication.g().k());
                                a(fileWriter, "uname", TiebaApplication.z());
                                a(fileWriter, "activity", cc.b());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                a(fileWriter, "crash_type", th.getClass().getName());
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.g().b().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i2).pid != myPid) {
                                            i = i2 + 1;
                                        } else {
                                            a(fileWriter, "process_name", runningAppProcesses.get(i2).processName);
                                            break;
                                        }
                                    }
                                }
                                a(fileWriter, "error", str2);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
                                fileWriter.flush();
                                fileWriter2 = fileWriter;
                            } catch (Exception e3) {
                                e = e3;
                                fileWriter2 = fileWriter;
                                printStream2 = printStream;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    e.printStackTrace();
                                    if (printStream2 != null) {
                                        try {
                                            printStream2.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            if (!com.baidu.tieba.data.i.F() && this.a != null) {
                                                this.a.uncaughtException(thread, th);
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
                                    if (!com.baidu.tieba.data.i.F()) {
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
                                    if (!com.baidu.tieba.data.i.F()) {
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
                                if (!com.baidu.tieba.data.i.F()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        try {
                            if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                TiebaApplication.g().g(TiebaApplication.g().af() + 1);
                            } else if (str2.contains("com.baidu.location")) {
                                TiebaApplication.g().ai();
                            } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                com.baidu.adp.lib.a.d.a().a(SwitchKey.MOTU, 1);
                            }
                            if (cc.a() != null && cc.a().indexOf("NewVcode") != -1) {
                                TiebaApplication.g().i(TiebaApplication.g().ah() + 1);
                            }
                            com.baidu.adp.lib.a.d.a().a(str2);
                            if (!TextUtils.isEmpty(str2)) {
                                com.baidu.adp.lib.util.e.b(str2);
                            }
                            try {
                                printStream.close();
                                byteArrayOutputStream.close();
                                if (fileWriter2 != null) {
                                    fileWriter2.close();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            if (com.baidu.tieba.data.i.F() && this.a != null) {
                                this.a.uncaughtException(thread, th);
                            } else {
                                Process.killProcess(Process.myPid());
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileWriter = fileWriter2;
                            if (printStream != null) {
                                try {
                                    printStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    if (!com.baidu.tieba.data.i.F() && this.a != null) {
                                        this.a.uncaughtException(thread, th);
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
                            if (!com.baidu.tieba.data.i.F()) {
                            }
                            Process.killProcess(Process.myPid());
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        printStream2 = printStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileWriter = null;
                }
            } catch (Exception e8) {
                e = e8;
                printStream2 = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th6) {
                th = th6;
                fileWriter = null;
                printStream = null;
            }
        } catch (Exception e9) {
            e = e9;
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
            com.baidu.adp.lib.util.e.b(getClass().getName(), "addInfo", e.getMessage());
        }
    }

    private static boolean a(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }
}
