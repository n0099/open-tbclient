package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class bi implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2486a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:122:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e5 A[Catch: Exception -> 0x01fd, TryCatch #9 {Exception -> 0x01fd, blocks: (B:77:0x01e0, B:79:0x01e5, B:81:0x01ea), top: B:122:0x01e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ea A[Catch: Exception -> 0x01fd, TRY_LEAVE, TryCatch #9 {Exception -> 0x01fd, blocks: (B:77:0x01e0, B:79:0x01e5, B:81:0x01ea), top: B:122:0x01e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f3  */
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
        int i;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        String str;
        FileWriter fileWriter2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    try {
                        th.printStackTrace(printStream);
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (com.baidu.tieba.data.h.s()) {
                            str = "fatal_error_debug.log";
                        } else {
                            str = "fatal_error.log";
                        }
                        File g = af.g(str);
                        if (g != null && g.length() < 204800 && str2 != null) {
                            fileWriter = new FileWriter(g, true);
                            try {
                                a(fileWriter, be.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.data.h.j());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", com.baidu.tieba.data.h.a());
                                a(fileWriter, "current_from", com.baidu.tieba.data.h.b());
                                a(fileWriter, "uid", TiebaApplication.A());
                                a(fileWriter, SocialConstants.PARAM_CLIENT_ID, TiebaApplication.N());
                                a(fileWriter, "imei", TiebaApplication.g().p());
                                a(fileWriter, "uname", TiebaApplication.F());
                                a(fileWriter, "activity", TiebaApplication.g().h());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                a(fileWriter, "crash_type", th.getClass().getName());
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.g().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i3).pid != myPid) {
                                            i2 = i3 + 1;
                                        } else {
                                            a(fileWriter, "process_name", runningAppProcesses.get(i3).processName);
                                            break;
                                        }
                                    }
                                }
                                a(fileWriter, "error", str2);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append("\n");
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
                                            if (!com.baidu.tieba.data.h.s() && this.f2486a != null) {
                                                uncaughtExceptionHandler = this.f2486a;
                                                uncaughtExceptionHandler.uncaughtException(thread, th);
                                                return;
                                            }
                                            i = Process.myPid();
                                            Process.killProcess(i);
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    if (!com.baidu.tieba.data.h.s()) {
                                    }
                                    i = Process.myPid();
                                    Process.killProcess(i);
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    fileWriter = fileWriter2;
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            if (!com.baidu.tieba.data.h.s()) {
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
                                    if (!com.baidu.tieba.data.h.s() && this.f2486a != null) {
                                        this.f2486a.uncaughtException(thread, th);
                                    } else {
                                        Process.killProcess(Process.myPid());
                                    }
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
                                if (!com.baidu.tieba.data.h.s()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        if (str2 != null) {
                            try {
                                if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TiebaApplication.g().h(TiebaApplication.g().aq() + 1);
                                } else if (str2.contains("com.baidu.location")) {
                                    TiebaApplication.g().at();
                                } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                    com.baidu.adp.lib.a.d.a().a(SwitchKey.MOTU, 1);
                                }
                                if (TiebaApplication.g().h() != null && TiebaApplication.g().h().indexOf("NewVcodeActivity") != -1) {
                                    TiebaApplication.g().j(TiebaApplication.g().as() + 1);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileWriter = fileWriter2;
                                if (printStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (fileWriter != null) {
                                }
                                if (!com.baidu.tieba.data.h.s()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        com.baidu.adp.lib.a.d.a().a(str2);
                        if (!TextUtils.isEmpty(str2)) {
                            bg.a(str2);
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
        if (com.baidu.tieba.data.h.s() && this.f2486a != null) {
            uncaughtExceptionHandler = this.f2486a;
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        i = Process.myPid();
        Process.killProcess(i);
    }

    private void a(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
            bg.b(getClass().getName(), "addInfo", e.getMessage());
        }
    }
}
