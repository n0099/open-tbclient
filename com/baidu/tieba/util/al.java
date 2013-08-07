package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class al implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f1752a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:122:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01db A[Catch: Exception -> 0x0201, TryCatch #12 {Exception -> 0x0201, blocks: (B:78:0x01d6, B:80:0x01db, B:82:0x01e0), top: B:122:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e0 A[Catch: Exception -> 0x0201, TRY_LEAVE, TryCatch #12 {Exception -> 0x0201, blocks: (B:78:0x01d6, B:80:0x01db, B:82:0x01e0), top: B:122:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e9  */
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
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    try {
                        th.printStackTrace(printStream);
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (com.baidu.tieba.data.g.r()) {
                            str = "fatal_error_debug.log";
                        } else {
                            str = "fatal_error.log";
                        }
                        File f = p.f(str);
                        if (f != null && f.length() < 204800 && str2 != null) {
                            fileWriter = new FileWriter(f, true);
                            try {
                                a(fileWriter, ai.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.data.g.i());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", com.baidu.tieba.data.g.a());
                                a(fileWriter, "uid", TiebaApplication.E());
                                a(fileWriter, "client_id", TiebaApplication.Q());
                                a(fileWriter, "imei", TiebaApplication.f().p());
                                a(fileWriter, "uname", TiebaApplication.I());
                                a(fileWriter, "activity", TiebaApplication.f().g());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.f().getSystemService("activity")).getRunningAppProcesses();
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
                                            if (!com.baidu.tieba.data.g.r() && this.f1752a != null) {
                                                this.f1752a.uncaughtException(thread, th);
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
                                    if (!com.baidu.tieba.data.g.r()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    return;
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
                                            if (!com.baidu.tieba.data.g.r()) {
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
                                    if (!com.baidu.tieba.data.g.r() && this.f1752a != null) {
                                        this.f1752a.uncaughtException(thread, th);
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
                                if (!com.baidu.tieba.data.g.r()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        if (str2 != null) {
                            try {
                                if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TiebaApplication.f().j(TiebaApplication.f().av() + 1);
                                } else if (str2.contains("com.baidu.location")) {
                                    TiebaApplication.f().aA();
                                } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                    TiebaApplication.f().e(false);
                                }
                                if (TiebaApplication.f().g() != null && TiebaApplication.f().g().indexOf("NewVcodeActivity") != -1) {
                                    TiebaApplication.f().l(TiebaApplication.f().ax() + 1);
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
                                if (!com.baidu.tieba.data.g.r()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        ak.a(th.getClass().getName());
                        if (!TextUtils.isEmpty(str2)) {
                            aj.a(str2);
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
                        if (com.baidu.tieba.data.g.r() && this.f1752a != null) {
                            this.f1752a.uncaughtException(thread, th);
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
            fileWriter.append("\n");
        } catch (Exception e) {
            aj.b(getClass().getName(), "addInfo", e.getMessage());
        }
    }
}
