package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes4.dex */
public final class Statistics implements INoProGuard {
    private static boolean mIsInited;

    public static synchronized void close() {
        synchronized (Statistics.class) {
            try {
                if (mIsInited) {
                    nativeClose();
                    mIsInited = false;
                }
            } finally {
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
            if (!mIsInited) {
                mIsInited = nativeInit(str, str2, str3);
            }
            z = mIsInited;
        }
        return z;
    }

    private static native void nativeClose();

    private static native String nativeGetPhoenixString();

    private static native String nativeGetString();

    private static native boolean nativeInit(String str, String str2, String str3);

    private static native void nativeRecord(int i, String str);

    private static native void nativeUpdatePhoenixConfig(String str);

    private static native void nativeUploadSuccessfully();

    public static void record(int i, String str) {
        if (str == null) {
            str = "";
        }
        try {
            if (mIsInited) {
                nativeRecord(i, str);
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
