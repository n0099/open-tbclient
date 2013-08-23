package com.baidu.tieba.util;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
/* loaded from: classes.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static int f1789a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;

    public static int a(String str, String str2, String str3) {
        if (com.baidu.tieba.data.g.s()) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            return Log.i("TiebaLog", sb.toString());
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[Catch: Exception -> 0x008c, TRY_LEAVE, TryCatch #3 {Exception -> 0x008c, blocks: (B:25:0x0083, B:27:0x0088), top: B:44:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(String str) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        File f = p.f("log_" + ap.c(new Date()));
        if (f != null) {
            try {
                fileWriter = new FileWriter(f, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter.write(String.valueOf(ap.a(currentTimeMillis)) + "\t\t" + str);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } catch (Exception e) {
                        e = e;
                        fileWriter2 = fileWriter;
                        try {
                            Log.d("tieba", e.getMessage());
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (Exception e2) {
                                    Log.d("tieba", e2.getMessage());
                                    return;
                                }
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e3) {
                                    Log.d("tieba", e3.getMessage());
                                    throw th;
                                }
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                        }
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedWriter = null;
                    fileWriter2 = fileWriter;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = null;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = null;
                fileWriter = null;
            }
        } else {
            bufferedWriter = null;
            fileWriter = null;
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (Exception e6) {
                Log.d("tieba", e6.getMessage());
                return;
            }
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    public static int b(String str, String str2, String str3) {
        if (com.baidu.tieba.data.g.s()) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            d(sb.toString());
            return Log.e("TiebaLog", sb.toString());
        }
        return 0;
    }

    public static int c(String str, String str2, String str3) {
        if (com.baidu.tieba.data.g.s()) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            return Log.w("TiebaLog", sb.toString());
        }
        return 0;
    }

    public static int d(String str, String str2, String str3) {
        if (com.baidu.tieba.data.g.s()) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            return Log.v("TiebaLog", sb.toString());
        }
        return 0;
    }

    public static int e(String str, String str2, String str3) {
        if (com.baidu.tieba.data.g.s()) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            return Log.d("TiebaLog", sb.toString());
        }
        return 0;
    }

    public static int a(int i, String str) {
        if (com.baidu.tieba.data.g.s()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i == 0) {
                b(className, methodName, str);
            } else if (i == 1) {
                c(className, methodName, str);
            } else if (i == 2) {
                a(className, methodName, str);
            } else if (i == 3) {
                e(className, methodName, str);
            } else {
                d(className, methodName, str);
            }
            return 0;
        }
        return -1;
    }

    public static int a(String str) {
        return a(0, str);
    }

    public static int b(String str) {
        return a(2, str);
    }

    public static int c(String str) {
        return a(3, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i, String str, String str2, String str3) {
        FileWriter fileWriter;
        Throwable th;
        boolean z = true;
        FileWriter fileWriter2 = null;
        switch (i) {
            case 1:
                if (f1789a < 10) {
                    f1789a++;
                    break;
                }
                z = false;
                break;
            case 2:
                if (b < 10) {
                    b++;
                    break;
                }
                z = false;
                break;
            case 3:
                if (c < 10) {
                    c++;
                    break;
                }
                z = false;
                break;
            case 4:
                if (d < 10) {
                    d++;
                    break;
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        try {
            if (com.baidu.tieba.data.g.s() || z) {
                StringBuilder sb = new StringBuilder(100);
                sb.append(new Date().getTime() / 1000);
                sb.append("\t");
                sb.append(i);
                sb.append("\t");
                sb.append(str2);
                if (str3 != null) {
                    sb.append(":");
                    sb.append(str3.replace("\n", " ").replace("\t", " "));
                }
                sb.append("\t");
                sb.append(str);
                sb.append("\t");
                sb.append(0);
                sb.append("\n");
                String sb2 = sb.toString();
                if (com.baidu.tieba.data.g.s()) {
                    Log.e("TiebaLog", sb2);
                }
                if (z) {
                    File f = p.f("log_error.log");
                    if (sb2 != null && f != null && f.length() < 204800) {
                        fileWriter = new FileWriter(f, true);
                        try {
                            fileWriter.append((CharSequence) sb2);
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e) {
                            fileWriter2 = fileWriter;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
