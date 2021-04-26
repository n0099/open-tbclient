package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes5.dex */
public final class Statistics implements INoProGuard {
    public static boolean mIsInited;

    public static synchronized void close() {
        synchronized (Statistics.class) {
            try {
                if (mIsInited) {
                    nativeClose();
                    mIsInited = false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String getPhoenixString() {
        try {
            return mIsInited ? nativeGetPhoenixString() : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getString() {
        try {
            return mIsInited ? nativeGetString() : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static synchronized boolean init(String str, String str2, String str3) {
        boolean z;
        synchronized (Statistics.class) {
            try {
                if (!mIsInited) {
                    mIsInited = nativeInit(str, str2, str3);
                }
                z = mIsInited;
            }
        }
        return z;
    }

    public static native void nativeClose();

    public static native String nativeGetPhoenixString();

    public static native String nativeGetString();

    public static native boolean nativeInit(String str, String str2, String str3);

    public static native void nativeRecord(int i2, String str);

    public static native void nativeUpdatePhoenixConfig(String str);

    public static native void nativeUploadSuccessfully();

    public static void record(int i2, String str) {
        if (str == null) {
            str = "";
        }
        try {
            if (mIsInited) {
                nativeRecord(i2, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void updatePhoenixConfig(String str) {
        try {
            if (mIsInited) {
                nativeUpdatePhoenixConfig(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void uploadSuccessfully() {
        try {
            if (mIsInited) {
                nativeUploadSuccessfully();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
