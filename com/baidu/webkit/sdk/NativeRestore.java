package com.baidu.webkit.sdk;
/* loaded from: classes7.dex */
public abstract class NativeRestore {
    public static final String CRASH_IMEI = "imei";
    public static final String CRASH_IS_NATIVE = "is_native";
    public static final String CRASH_SIGNAL = "signal";
    public static final String CRASH_TIME = "time_crash";

    public static NativeRestore createInstance(String str) {
        try {
            NativeRestore nativeRestoreImpl = WebViewFactory.getProvider().getNativeRestoreImpl(str);
            if (nativeRestoreImpl != null) {
                if (nativeRestoreImpl.isValid()) {
                    return nativeRestoreImpl;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
    }

    public boolean flush() {
        return false;
    }

    public byte[] get(String str) {
        return null;
    }

    public String getCrashID() {
        if (isNativeCrash()) {
            return getCrashImei() + "-" + getCrashTime();
        }
        return null;
    }

    public String getCrashImei() {
        return getString("imei");
    }

    public String getCrashSingal() {
        return getString("signal");
    }

    public String getCrashTime() {
        return getString("time_crash");
    }

    public int getInt(String str, int i) {
        return 0;
    }

    public String getString(String str) {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isNativeCrash() {
        String string = getString("is_native");
        return string != null && string.equalsIgnoreCase("TRUE");
    }

    public boolean isValid() {
        return false;
    }

    public String[] keys() {
        return null;
    }

    public boolean put(String str, byte[] bArr) {
        return false;
    }

    public boolean putInt(String str, int i) {
        return false;
    }

    public boolean putString(String str, String str2) {
        return false;
    }

    public boolean remove(String str) {
        return false;
    }

    public void setNativeCrash(boolean z) {
        putString("is_native", String.valueOf(z));
    }

    public int size() {
        return 0;
    }

    public boolean unflush() {
        return false;
    }
}
