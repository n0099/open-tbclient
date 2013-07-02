package com.baidu.zeus;

import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public final class WebKitInit {
    private static String mStrPath;
    private static String m_version;
    private static String LOGTAG = "WebKitInit";
    private static String mLibPath = "/data/data/com.baidu.browser.apps/files";
    private static int drawableId = 17301688;
    private static CrashHandler handler = null;
    private static int osId = 0;
    private static boolean useLocalLib = false;
    private static boolean mIsVersion40 = false;
    private static boolean mIsVersion41 = false;
    private static boolean mIsVersion21 = false;
    private static boolean mIsVersionUseGL = false;
    private static int mSdkVersion = -1;
    private static int m_NEON_OS_ID = 0;
    private static boolean mVersionInitCalled = false;
    public static int gBackgroundNightColor = -13290187;

    private static native void nativeInitProxy(int i);

    public static native void nativeSetBackgroundNightColor(int i);

    public static native void setBorderNightColor(int i);

    public static native void setDefaultLinkTextNightCr(int i);

    public static native void setLinkTextNightColor(int i);

    public static native void setTextNightColor(int i);

    public static native String setVersion();

    public static native void setVisitedLinkNightColor(int i);

    /* loaded from: classes.dex */
    public class OSID {
        public static final int ANDROID_ZEUS_21_AR = 2;
        public static final int ANDROID_ZEUS_21_NEON = 1;
        public static final int ANDROID_ZEUS_22_AR = 4;
        public static final int ANDROID_ZEUS_22_NEON = 3;
        public static final int ANDROID_ZEUS_23_AR = 6;
        public static final int ANDROID_ZEUS_23_NEON = 5;
        public static final int ANDROID_ZEUS_40_AR = 8;
        public static final int ANDROID_ZEUS_40_NEON = 7;
        public static final int ANDROID_ZEUS_41_AR = 10;
        public static final int ANDROID_ZEUS_41_NEON = 9;
        public static final int UNKNOWN_OS = 0;

        public OSID() {
        }
    }

    /* loaded from: classes.dex */
    public class SDK_VERSION {
        public static final int SDK_21 = 7;
        public static final int SDK_22 = 8;
        public static final int SDK_23 = 9;
        public static final int SDK_23X = 10;
        public static final int SDK_40 = 14;
        public static final int SDK_403 = 15;
        public static final int SDK_41 = 16;

        public SDK_VERSION() {
        }
    }

    public static boolean isVersion40() {
        return mIsVersion40;
    }

    public static boolean isVersionCanUseGL() {
        return mIsVersionUseGL;
    }

    public static boolean isAndroidVersion21() {
        return mIsVersion21;
    }

    public static boolean isVersion41() {
        return mIsVersion41;
    }

    public static void checkOSId() {
        get_OS_SDK_VersionNumber();
        int i = mSdkVersion;
        if (i == 7) {
            m_NEON_OS_ID = 1;
        } else if (i == 8) {
            m_NEON_OS_ID = 3;
        } else if (i == 9 || i == 10) {
            m_NEON_OS_ID = 5;
        } else if (i == 14 || i == 15) {
            m_NEON_OS_ID = 7;
        } else if (i == 16) {
            m_NEON_OS_ID = 9;
        }
    }

    public static int getSDKVersion() {
        return mSdkVersion;
    }

    private static void get_OS_SDK_VersionNumber() {
        int i = -1;
        try {
            i = Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            Log.e(LOGTAG, "getSDKVersionNumber error");
        }
        mSdkVersion = i;
        Log.e(LOGTAG, "getSDKVersion :" + mSdkVersion);
    }

    public static String getVersion() {
        return m_version;
    }

    public static void setUseLocalLib() {
        useLocalLib = true;
    }

    public static void setLibPath(String str) {
        int length = str.length() - 1;
        if (str.charAt(length) == '/') {
            str = str.substring(0, length);
        }
        mLibPath = str;
    }

    private static boolean loadZeusJniGL() {
        try {
            String str = mStrPath;
            if (useLocalLib) {
                System.loadLibrary("ZeusJNIGL");
            } else {
                System.load(str + "/libZeusJNIGL.so");
            }
            return true;
        } catch (NullPointerException e) {
            Log.e(LOGTAG, " java.lang.Exception Load Library error! error: " + e);
            return false;
        } catch (SecurityException e2) {
            Log.e(LOGTAG, " java.lang.SecurityException Load Library error! error: " + e2);
            return false;
        } catch (Exception e3) {
            Log.e(LOGTAG, " java.lang.Exception Load Library error! error: " + e3);
            return false;
        } catch (UnsatisfiedLinkError e4) {
            Log.e(LOGTAG, "java.lang.UnsatisfiedLinkError Load Library error! error: " + e4);
            return false;
        }
    }

    private static boolean loadZeusJniNormal() {
        try {
            String str = mStrPath;
            if (useLocalLib) {
                System.loadLibrary("ZeusJNI");
            } else {
                System.load(str + "/libZeusJNI.so");
            }
            return true;
        } catch (NullPointerException e) {
            Log.e(LOGTAG, " java.lang.Exception Load Library ZeusJNI error! error: " + e);
            return false;
        } catch (SecurityException e2) {
            Log.e(LOGTAG, " java.lang.SecurityException Load Library ZeusJNI error! error: " + e2);
            return false;
        } catch (Exception e3) {
            Log.e(LOGTAG, " java.lang.Exception Load Library ZeusJNI error! error: " + e3);
            return false;
        } catch (UnsatisfiedLinkError e4) {
            Log.e(LOGTAG, "java.lang.UnsatisfiedLinkError Load Library ZeusJNI error! error: " + e4);
            return false;
        }
    }

    private static void loadBaiduJni() {
        try {
            if (useLocalLib) {
                System.loadLibrary("flyflowjni");
            }
        } catch (NullPointerException e) {
            Log.e(LOGTAG, " java.lang.Exception Load Library flyflowjni error! error: " + e);
        } catch (SecurityException e2) {
            Log.e(LOGTAG, " java.lang.SecurityException Load Library flyflowjni error! error: " + e2);
        } catch (Exception e3) {
            Log.e(LOGTAG, " java.lang.Exception Load Library flyflowjni error! error: " + e3);
        } catch (UnsatisfiedLinkError e4) {
            Log.e(LOGTAG, "java.lang.UnsatisfiedLinkError Load Library flyflowjni error! error: " + e4);
        }
    }

    public static boolean versionInit() {
        checkOSId();
        if (useLocalLib) {
            mStrPath = "/data/data/com.baidu.browser.apps/lib";
        } else {
            mStrPath = mLibPath;
        }
        if (mIsVersion40) {
            if (!loadZeusJniNormal() && !loadZeusJniGL()) {
                Log.e(LOGTAG, "loadZeusJni error");
                return false;
            }
        } else if (!loadZeusJniNormal()) {
            Log.e(LOGTAG, "loadZeusJni error");
            return false;
        }
        m_version = setVersion();
        Log.e(LOGTAG, "versionInit kernerl version:" + m_version);
        return true;
    }

    public static boolean init() {
        Log.e(LOGTAG, "Webkit Init OS ID: " + osId);
        if (useLocalLib) {
            mStrPath = "/data/data/com.baidu.browser.apps/lib";
        } else {
            mStrPath = mLibPath;
        }
        loadBaiduJni();
        try {
            String str = mStrPath;
            switch (osId) {
                case 1:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 2:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 3:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 4:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 5:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 6:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 7:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 8:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 9:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                case 10:
                    if (useLocalLib) {
                        System.loadLibrary("zeus");
                        break;
                    } else {
                        System.load(str + "/libzeus.so");
                        break;
                    }
                default:
                    Log.e(LOGTAG, "not load lizeus");
                    return false;
            }
            nativeInitProxy(osId);
            return true;
        } catch (NullPointerException e) {
            Log.e(LOGTAG, " java.lang.Exception Load Library zeus error! error: " + e);
            return false;
        } catch (SecurityException e2) {
            Log.e(LOGTAG, " java.lang.SecurityException Load Library zeus error! error: " + e2);
            return false;
        } catch (Exception e3) {
            Log.e(LOGTAG, " java.lang.Exception Load Library zeus error! error: " + e3);
            return false;
        } catch (UnsatisfiedLinkError e4) {
            Log.e(LOGTAG, "java.lang.UnsatisfiedLinkError Load Library zeus error! error: " + e4);
            return false;
        }
    }

    public static void setDrawableId(int i) {
        drawableId = i;
    }

    public static int drawableId() {
        return drawableId;
    }

    public static void setOSId(int i) {
        osId = i;
        mIsVersion40 = osId == 7 || osId == 8;
        mIsVersion41 = osId == 9 || osId == 10;
        mIsVersion21 = osId == 1 || osId == 2;
        mIsVersionUseGL = osId > 6;
        Log.e(LOGTAG, "setOSId:" + osId + " mIsVersion40:" + mIsVersion40 + " mIsVersion41:" + mIsVersion41 + " " + mIsVersionUseGL);
    }

    public static int getOSId() {
        return osId;
    }

    public static void setCrashHandler(CrashHandler crashHandler) {
        Log.e("webkitinit", "setCrashHandler + " + crashHandler);
        handler = crashHandler;
    }

    public static CrashHandler getCrashHandler() {
        return handler;
    }

    public static void crashHandler(int i) {
        if (handler != null) {
            Log.e("webkitinit", "crash !! " + i + " handler: " + handler);
            handler.onNativeCrash(i, "test");
        }
        Log.e("webkitinit", "crashHandler out");
    }

    public static void setBackgroundNightColor(int i) {
        gBackgroundNightColor = i;
        nativeSetBackgroundNightColor(i);
    }
}
