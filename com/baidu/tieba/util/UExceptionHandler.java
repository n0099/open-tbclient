package com.baidu.tieba.util;

import android.os.Build;
import com.baidu.tieba.data.Config;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
/* loaded from: classes.dex */
public class UExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mHandler;

    public UExceptionHandler() {
        this.mHandler = null;
        this.mHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable ex) {
        Exception e;
        FileWriter writer;
        ByteArrayOutputStream baos = null;
        PrintStream printStream = null;
        FileWriter writer2 = null;
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
                            if (info != null) {
                                try {
                                    writer = new FileWriter(file, true);
                                } catch (Exception e2) {
                                    e = e2;
                                    printStream = printStream2;
                                    baos = baos2;
                                } catch (Throwable th) {
                                    th = th;
                                    printStream = printStream2;
                                    baos = baos2;
                                }
                                try {
                                    String time = StringHelper.getCurrentString();
                                    writer.append((CharSequence) time);
                                    writer.append((CharSequence) "\n");
                                    writer.append((CharSequence) Config.VERSION);
                                    writer.append((CharSequence) "\n");
                                    writer.append((CharSequence) Build.MODEL);
                                    writer.append((CharSequence) "\nandroid:");
                                    writer.append((CharSequence) Build.VERSION.RELEASE);
                                    writer.append((CharSequence) "\n");
                                    writer.append((CharSequence) info);
                                    writer.append((CharSequence) "\n\n");
                                    writer.flush();
                                    writer2 = writer;
                                    printStream = printStream2;
                                    baos = baos2;
                                } catch (Exception e3) {
                                    e = e3;
                                    writer2 = writer;
                                    printStream = printStream2;
                                    baos = baos2;
                                    e.printStackTrace();
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
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
                                    if (writer2 != null) {
                                        writer2.close();
                                    }
                                    if (this.mHandler == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    writer2 = writer;
                                    printStream = printStream2;
                                    baos = baos2;
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            if (this.mHandler != null) {
                                                this.mHandler.uncaughtException(thread, ex);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (baos != null) {
                                        baos.close();
                                    }
                                    if (writer2 != null) {
                                        writer2.close();
                                    }
                                    if (this.mHandler != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                printStream = printStream2;
                                baos = baos2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            printStream = printStream2;
                            baos = baos2;
                        } catch (Throwable th3) {
                            th = th3;
                            printStream = printStream2;
                            baos = baos2;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        baos = baos2;
                    } catch (Throwable th4) {
                        th = th4;
                        baos = baos2;
                    }
                }
                if (printStream != null) {
                    try {
                        printStream.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                if (baos != null) {
                    baos.close();
                }
                if (writer2 != null) {
                    writer2.close();
                }
                if (this.mHandler != null) {
                    this.mHandler.uncaughtException(thread, ex);
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }
}
