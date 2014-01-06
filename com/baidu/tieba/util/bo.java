package com.baidu.tieba.util;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
/* loaded from: classes.dex */
public class bo {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;

    public static int a(String str, String str2, String str3) {
        if (com.baidu.tieba.data.h.v()) {
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x008c A[Catch: Exception -> 0x0090, TRY_LEAVE, TryCatch #0 {Exception -> 0x0090, blocks: (B:26:0x0087, B:28:0x008c), top: B:45:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(String str) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        String str2;
        String message;
        FileWriter fileWriter2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        File g = aa.g("log_" + bm.c(new Date()));
        if (g != null) {
            try {
                fileWriter = new FileWriter(g, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter.write(bm.a(currentTimeMillis) + "\t\t" + str);
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
                                    str2 = "tieba";
                                    message = e2.getMessage();
                                    Log.d(str2, message);
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
                str2 = "tieba";
                message = e6.getMessage();
                Log.d(str2, message);
                return;
            }
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    public static int b(String str, String str2, String str3) {
        if (com.baidu.tieba.data.h.v()) {
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
        if (com.baidu.tieba.data.h.v()) {
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
        if (com.baidu.tieba.data.h.v()) {
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
        if (com.baidu.tieba.data.h.v()) {
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
        if (com.baidu.tieba.data.h.v()) {
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

    public static void a(int i, String str, String str2, String str3) {
        FileWriter fileWriter;
        Throwable th;
        boolean z = false;
        FileWriter fileWriter2 = null;
        switch (i) {
            case 1:
                if (a < 10) {
                    a++;
                    z = true;
                    break;
                }
                break;
            case 2:
                if (b < 10) {
                    b++;
                    z = true;
                    break;
                }
                break;
            case 3:
                if (c < 10) {
                    c++;
                    z = true;
                    break;
                }
                break;
            case 4:
                if (d < 10) {
                    d++;
                    z = true;
                    break;
                }
                break;
        }
        try {
            if (com.baidu.tieba.data.h.v() || z) {
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
                if (com.baidu.tieba.data.h.v()) {
                    Log.e("TiebaLog", sb2);
                }
                if (z) {
                    File g = aa.g("log_error.log");
                    if (sb2 != null && g != null && g.length() < 204800) {
                        fileWriter = new FileWriter(g, true);
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
                                    e = e2;
                                    e.printStackTrace();
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
                    e = e4;
                    e.printStackTrace();
                }
            }
        } catch (Exception e5) {
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
