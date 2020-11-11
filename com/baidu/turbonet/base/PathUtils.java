package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.os.SystemClock;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes17.dex */
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AtomicBoolean okO;
    private static AsyncTask<Void, Void, String[]> okP;
    private static Context okQ;
    private static String sDataDirectorySuffix;

    static {
        $assertionsDisabled = !PathUtils.class.desiredAssertionStatus();
        okO = new AtomicBoolean();
    }

    private PathUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private static final String[] okR = PathUtils.ebl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] ebl() {
        try {
            if (okP.cancel(false)) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
                try {
                    return ebm();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return okP.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    private static String[] ebm() {
        String[] strArr = new String[4];
        strArr[0] = okQ.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[1] = okQ.getDir("textures", 0).getPath();
        strArr[2] = okQ.getDatabasePath("foo").getParent();
        if (okQ.getCacheDir() != null) {
            strArr[3] = okQ.getCacheDir().getPath();
        }
        return strArr;
    }

    private static String MG(int i) {
        return a.okR[i];
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        if ($assertionsDisabled || okP != null) {
            return MG(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        if ($assertionsDisabled || okP != null) {
            return MG(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        if ($assertionsDisabled || okP != null) {
            return MG(3);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        if ($assertionsDisabled || okP != null) {
            return MG(1);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    private static String getDownloadsDirectory(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            SystemClock.elapsedRealtime();
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @CalledByNative
    private static String getNativeLibraryDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return ((applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
