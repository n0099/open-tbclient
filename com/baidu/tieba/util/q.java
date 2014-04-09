package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class q implements Thread.UncaughtExceptionHandler {
    private static final String b = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:121:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0229 A[Catch: Exception -> 0x024f, TryCatch #1 {Exception -> 0x024f, blocks: (B:85:0x0224, B:87:0x0229, B:89:0x022e), top: B:121:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022e A[Catch: Exception -> 0x024f, TRY_LEAVE, TryCatch #1 {Exception -> 0x024f, blocks: (B:85:0x0224, B:87:0x0229, B:89:0x022e), top: B:121:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0237  */
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
        if (com.baidu.tbadk.core.data.n.a() && a(th)) {
            com.baidu.adp.lib.util.f.b("OOM!!!please keep alive, and getting in touch with RD!");
            try {
                File file = new File(b);
                if (!file.exists()) {
                    file.mkdir();
                }
                Debug.dumpHprofData(String.valueOf(b) + System.currentTimeMillis());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("couldn’t dump hprof:Exception");
            } catch (OutOfMemoryError e2) {
                com.baidu.adp.lib.util.f.b("couldn’t dump hprof: OutOfMemoryError");
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
                        if (com.baidu.tbadk.core.data.n.a()) {
                            str = "fatal_error_debug.log";
                        } else {
                            str = "fatal_error.log";
                        }
                        File g = w.g(str);
                        if (g != null && g.length() < 204800) {
                            fileWriter = new FileWriter(g, true);
                            try {
                                a(fileWriter, bc.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tbadk.core.data.n.c());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", com.baidu.tbadk.core.data.n.j());
                                a(fileWriter, "current_from", com.baidu.tbadk.core.data.n.k());
                                a(fileWriter, "uid", TbadkApplication.E());
                                a(fileWriter, "client_id", TbadkApplication.B());
                                a(fileWriter, "imei", TbadkApplication.j().C());
                                a(fileWriter, "uname", TbadkApplication.O());
                                a(fileWriter, "activity", be.b());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                a(fileWriter, "crash_type", th.getClass().getName());
                                com.baidu.tieba.p.c();
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) com.baidu.tieba.p.d().getSystemService("activity")).getRunningAppProcesses();
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
                                            if (!com.baidu.tbadk.core.data.n.a() && this.a != null) {
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
                                    if (!com.baidu.tbadk.core.data.n.a()) {
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
                                    if (!com.baidu.tbadk.core.data.n.a()) {
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
                                if (!com.baidu.tbadk.core.data.n.a()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        try {
                            if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                TbadkApplication.j().i(TbadkApplication.j().aF() + 1);
                            } else if (str2.contains("com.baidu.location")) {
                                com.baidu.tieba.p.c().v();
                            } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                com.baidu.adp.lib.a.f.a().a("motu_sdk", 1);
                            }
                            if (be.a() != null && be.a().indexOf("NewVcode") != -1) {
                                com.baidu.tieba.p.c().e(com.baidu.tieba.p.c().u() + 1);
                            }
                            com.baidu.adp.lib.a.f.a().a(str2);
                            if (!TextUtils.isEmpty(str2)) {
                                com.baidu.adp.lib.util.f.b(str2);
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
                            if (com.baidu.tbadk.core.data.n.a() && this.a != null) {
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
                                    if (!com.baidu.tbadk.core.data.n.a()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    throw th;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            if (!com.baidu.tbadk.core.data.n.a() && this.a != null) {
                                this.a.uncaughtException(thread, th);
                            } else {
                                Process.killProcess(Process.myPid());
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    printStream2 = printStream;
                    byteArrayOutputStream2 = byteArrayOutputStream;
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "addInfo", e.getMessage());
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
