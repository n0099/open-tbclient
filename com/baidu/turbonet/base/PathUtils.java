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
/* loaded from: classes14.dex */
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AtomicBoolean oBs;
    private static AsyncTask<Void, Void, String[]> oBt;
    private static Context oBu;
    private static String sDataDirectorySuffix;

    static {
        $assertionsDisabled = !PathUtils.class.desiredAssertionStatus();
        oBs = new AtomicBoolean();
    }

    private PathUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a {
        private static final String[] oBv = PathUtils.egQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] egQ() {
        try {
            if (oBt.cancel(false)) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
                try {
                    return egR();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return oBt.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    private static String[] egR() {
        String[] strArr = new String[4];
        strArr[0] = oBu.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[1] = oBu.getDir("textures", 0).getPath();
        strArr[2] = oBu.getDatabasePath("foo").getParent();
        if (oBu.getCacheDir() != null) {
            strArr[3] = oBu.getCacheDir().getPath();
        }
        return strArr;
    }

    private static String Ob(int i) {
        return a.oBv[i];
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        if ($assertionsDisabled || oBt != null) {
            return Ob(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        if ($assertionsDisabled || oBt != null) {
            return Ob(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        if ($assertionsDisabled || oBt != null) {
            return Ob(3);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        if ($assertionsDisabled || oBt != null) {
            return Ob(1);
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
