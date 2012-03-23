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

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable ex) {
        PrintStream printStream;
        String info;
        FileWriter writer;
        ByteArrayOutputStream baos = null;
        PrintStream printStream2 = null;
        FileWriter writer2 = null;
        try {
            try {
                File file = FileHelper.CreateFileIfNotFound(Config.FATAL_ERROR_FILE);
                if (file != null && file.length() < Config.FATAL_ERROR_FILE_MAX_SIZE) {
                    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                    try {
                        printStream = new PrintStream(baos2);
                        try {
                            ex.printStackTrace(printStream);
                            byte[] data = baos2.toByteArray();
                            info = new String(data);
                            try {
                                byte[] bArr = null;
                                writer = new FileWriter(file, true);
                            } catch (Exception e) {
                                e = e;
                                printStream2 = printStream;
                                baos = baos2;
                            } catch (Throwable th) {
                                th = th;
                                printStream2 = printStream;
                                baos = baos2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            printStream2 = printStream;
                            baos = baos2;
                        } catch (Throwable th2) {
                            th = th2;
                            printStream2 = printStream;
                            baos = baos2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        baos = baos2;
                    } catch (Throwable th3) {
                        th = th3;
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
                        printStream2 = printStream;
                        baos = baos2;
                    } catch (Exception e4) {
                        e = e4;
                        writer2 = writer;
                        printStream2 = printStream;
                        baos = baos2;
                        e.printStackTrace();
                        if (printStream2 != null) {
                            try {
                                printStream2.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
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
                    } catch (Throwable th4) {
                        th = th4;
                        writer2 = writer;
                        printStream2 = printStream;
                        baos = baos2;
                        if (printStream2 != null) {
                            try {
                                printStream2.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
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
                }
                if (printStream2 != null) {
                    try {
                        printStream2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
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
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
