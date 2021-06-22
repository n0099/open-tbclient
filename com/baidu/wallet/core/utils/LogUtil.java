package com.baidu.wallet.core.utils;

import java.io.File;
/* loaded from: classes5.dex */
public final class LogUtil {
    public static final boolean DEBUG = false;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24090a = "LogUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f24091b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f24092c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f24093d = false;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f24094e = false;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f24095f = false;

    public static void d(String str) {
        d(f24090a, str);
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void errord(String str) {
    }

    public static void errord(String str, String str2) {
    }

    public static String getTAG() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[4];
                sb.append(((Object) stackTraceElement.getFileName().subSequence(0, stackTraceElement.getFileName().length() - 5)) + "." + stackTraceElement.getMethodName() + "#" + stackTraceElement.getLineNumber());
            }
            return sb.toString();
        } catch (NullPointerException unused) {
            return "PROGUARDED";
        }
    }

    public static void i(String str, String str2) {
    }

    public static void logd(String str) {
    }

    public static void logd(String str, String str2) {
    }

    public static void mark() {
    }

    public static void mark(String str) {
    }

    public static void methodTrace(String str) {
    }

    public static void saveLog(File file, String str) {
    }

    public static void traces() {
    }

    public static void v(String str, String str2) {
    }

    public static void w(String str, String str2) {
    }
}
