package com.baidu.zeus;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import android.view.SurfaceView;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class JniUtil {
    private static final String ANDROID_CONTENT = "content:";
    private static final String LOGTAG = "JniUtil";
    public static final String WEB_AUTOFILL_QUERY_URL = "web_autofill_query_url";
    private static String sCacheDirectory;
    private static Context sContext;
    private static String sDatabaseDirectory;
    private static Boolean sUseChromiumHttpStack;

    private static native boolean nativeUseChromiumHttpStack();

    private JniUtil() {
    }

    private static void checkInitialized() {
        if (sContext == null) {
            throw new IllegalStateException("Call CookieSyncManager::createInstance() or create a webview before using this class");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void setContext(Context context) {
        synchronized (JniUtil.class) {
            if (sContext == null) {
                sContext = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized Context getContext() {
        Context context;
        synchronized (JniUtil.class) {
            context = sContext;
        }
        return context;
    }

    private static synchronized String getDatabaseDirectory() {
        String str;
        synchronized (JniUtil.class) {
            checkInitialized();
            if (sDatabaseDirectory == null) {
                sDatabaseDirectory = sContext.getDatabasePath("dummy").getParent();
            }
            str = sDatabaseDirectory;
        }
        return str;
    }

    private static synchronized String getCacheDirectory() {
        String str;
        synchronized (JniUtil.class) {
            checkInitialized();
            if (sCacheDirectory == null) {
                sCacheDirectory = sContext.getCacheDir().getAbsolutePath();
            }
            str = sCacheDirectory;
        }
        return str;
    }

    private static synchronized long contentUrlSize(String str) {
        long j;
        synchronized (JniUtil.class) {
            if (str.startsWith(ANDROID_CONTENT)) {
                try {
                    int lastIndexOf = str.lastIndexOf(63);
                    if (lastIndexOf != -1) {
                        str = str.substring(0, lastIndexOf);
                    }
                    InputStream openInputStream = sContext.getContentResolver().openInputStream(Uri.parse(str));
                    byte[] bArr = new byte[1024];
                    j = 0;
                    while (true) {
                        try {
                            int read = openInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            j += read;
                        } finally {
                            openInputStream.close();
                        }
                    }
                } catch (Exception e) {
                    Log.e(LOGTAG, "Exception: " + str);
                    j = 0;
                }
            } else {
                j = 0;
            }
        }
        return j;
    }

    private static synchronized InputStream contentUrlStream(String str) {
        InputStream inputStream = null;
        synchronized (JniUtil.class) {
            if (str.startsWith(ANDROID_CONTENT)) {
                try {
                    int lastIndexOf = str.lastIndexOf(63);
                    if (lastIndexOf != -1) {
                        str = str.substring(0, lastIndexOf);
                    }
                    inputStream = sContext.getContentResolver().openInputStream(Uri.parse(str));
                } catch (Exception e) {
                    Log.e(LOGTAG, "Exception: " + str);
                }
            }
        }
        return inputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean useChromiumHttpStack() {
        if (sUseChromiumHttpStack == null) {
            sUseChromiumHttpStack = Boolean.valueOf(nativeUseChromiumHttpStack());
        }
        return sUseChromiumHttpStack.booleanValue();
    }

    private static synchronized String getAutofillQueryUrl() {
        String string;
        synchronized (JniUtil.class) {
            checkInitialized();
            Log.e(LOGTAG, "getAutofillQueryUrl");
            string = Settings.Secure.getString(sContext.getContentResolver(), WEB_AUTOFILL_QUERY_URL);
        }
        return string;
    }

    private static boolean canSatisfyMemoryAllocation(long j) {
        checkInitialized();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) sContext.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return !memoryInfo.lowMemory && j < memoryInfo.availMem - memoryInfo.threshold;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean myIsUseHardwareAccelerate(Canvas canvas) {
        if (WebKitInit.isVersion40() || WebKitInit.isVersion41()) {
            try {
                Object invoke = canvas.getClass().getMethod("isHardwareAccelerated", null).invoke(canvas, null);
                if (invoke != null && (invoke instanceof Boolean)) {
                    if (((Boolean) invoke).booleanValue()) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void myCallDrawGLFunction(Canvas canvas, int i) {
        try {
            canvas.getClass().getMethod("callDrawGLFunction", Integer.TYPE).invoke(canvas, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean myIsSurfaceViewFixedSize(SurfaceView surfaceView) {
        if (WebKitInit.isAndroidVersion21()) {
            return true;
        }
        try {
            Object invoke = surfaceView.getClass().getMethod("isFixedSize", null).invoke(surfaceView, null);
            if (invoke != null && (invoke instanceof Boolean)) {
                if (((Boolean) invoke).booleanValue()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
