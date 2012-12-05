package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.ReLoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.write.VcodeActivity;
import com.baidu.tieba.write.WriteImageActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class UExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mHandler;

    public UExceptionHandler() {
        this.mHandler = null;
        this.mHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ea  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable ex) {
        ByteArrayOutputStream baos = null;
        PrintStream printStream = null;
        FileWriter writer = null;
        try {
            try {
                File file = FileHelper.CreateFileIfNotFound(Config.FATAL_ERROR_FILE);
                if (file != null && file.length() < Config.FATAL_ERROR_FILE_MAX_SIZE) {
                    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                    try {
                        PrintStream printStream2 = new PrintStream(baos2);
                        try {
                            ex.printStackTrace(printStream2);
                            byte[] data = baos2.toByteArray();
                            String info = new String(data);
                            try {
                                byte[] bArr = null;
                                if (info != null) {
                                    FileWriter writer2 = new FileWriter(file, true);
                                    try {
                                        String time = StringHelper.getCurrentString();
                                        addInfo(writer2, time, null);
                                        addInfo(writer2, "tieba_crash_new_info", null);
                                        addInfo(writer2, TiebaUpdateService.TAG_VERSION, Config.VERSION);
                                        addInfo(writer2, VcodeActivity.SAVE_KEY, Build.MODEL);
                                        addInfo(writer2, "android_version", Build.VERSION.RELEASE);
                                        addInfo(writer2, WriteImageActivity.FROM, Config.FROM);
                                        addInfo(writer2, "uid", TiebaApplication.getCurrentAccount());
                                        addInfo(writer2, "client_id", TiebaApplication.getClientId());
                                        addInfo(writer2, "imei", TiebaApplication.app.getImei());
                                        addInfo(writer2, ReLoginActivity.UNAME, TiebaApplication.getCurrentAccountName());
                                        ActivityManager am = (ActivityManager) TiebaApplication.app.getSystemService("activity");
                                        List<ActivityManager.RunningAppProcessInfo> list = am.getRunningAppProcesses();
                                        int pid = Process.myPid();
                                        if (list != null) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= list.size()) {
                                                    break;
                                                } else if (list.get(i).pid != pid) {
                                                    i++;
                                                } else {
                                                    addInfo(writer2, "process_name", list.get(i).processName);
                                                    break;
                                                }
                                            }
                                        }
                                        addInfo(writer2, "error", info);
                                        addInfo(writer2, "tieba_crash_new_info_end", null);
                                        writer2.append("\n");
                                        writer2.flush();
                                        if (info.indexOf("java.lang.ExceptionInInitializerError") >= 0 || info.indexOf("java.lang.SecurityException") >= 0) {
                                            TiebaApplication.app.setIsLocationOn(false);
                                            writer = writer2;
                                            printStream = printStream2;
                                            baos = baos2;
                                        } else {
                                            writer = writer2;
                                            printStream = printStream2;
                                            baos = baos2;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        writer = writer2;
                                        printStream = printStream2;
                                        baos = baos2;
                                        e.printStackTrace();
                                        if (printStream != null) {
                                            try {
                                                printStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                if (this.mHandler == null) {
                                                    this.mHandler.uncaughtException(thread, ex);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (baos != null) {
                                            baos.close();
                                        }
                                        if (writer != null) {
                                            writer.close();
                                        }
                                        if (this.mHandler == null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        writer = writer2;
                                        printStream = printStream2;
                                        baos = baos2;
                                        if (printStream != null) {
                                            try {
                                                printStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                if (this.mHandler != null) {
                                                    this.mHandler.uncaughtException(thread, ex);
                                                }
                                                throw th;
                                            }
                                        }
                                        if (baos != null) {
                                            baos.close();
                                        }
                                        if (writer != null) {
                                            writer.close();
                                        }
                                        if (this.mHandler != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    printStream = printStream2;
                                    baos = baos2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                printStream = printStream2;
                                baos = baos2;
                            } catch (Throwable th2) {
                                th = th2;
                                printStream = printStream2;
                                baos = baos2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            printStream = printStream2;
                            baos = baos2;
                        } catch (Throwable th3) {
                            th = th3;
                            printStream = printStream2;
                            baos = baos2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        baos = baos2;
                    } catch (Throwable th4) {
                        th = th4;
                        baos = baos2;
                    }
                }
                if (printStream != null) {
                    try {
                        printStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (baos != null) {
                    baos.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (this.mHandler != null) {
                    this.mHandler.uncaughtException(thread, ex);
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    private void addInfo(FileWriter file, String key, String value) {
        try {
            file.append((CharSequence) key);
            if (value != null) {
                file.append("=");
                file.append((CharSequence) value);
            }
            file.append("\n");
        } catch (Exception e) {
        }
    }
}
