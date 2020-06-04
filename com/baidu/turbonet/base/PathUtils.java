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
/* loaded from: classes.dex */
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AtomicBoolean mcx;
    private static AsyncTask<Void, Void, String[]> mcy;
    private static Context mcz;
    private static String sDataDirectorySuffix;

    static {
        $assertionsDisabled = !PathUtils.class.desiredAssertionStatus();
        mcx = new AtomicBoolean();
    }

    private PathUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final String[] mcA = PathUtils.dqi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] dqi() {
        try {
            if (mcy.cancel(false)) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
                try {
                    return dqj();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return mcy.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    private static String[] dqj() {
        String[] strArr = new String[4];
        strArr[0] = mcz.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[1] = mcz.getDir("textures", 0).getPath();
        strArr[2] = mcz.getDatabasePath("foo").getParent();
        if (mcz.getCacheDir() != null) {
            strArr[3] = mcz.getCacheDir().getPath();
        }
        return strArr;
    }

    private static String FY(int i) {
        return a.mcA[i];
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        if ($assertionsDisabled || mcy != null) {
            return FY(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        if ($assertionsDisabled || mcy != null) {
            return FY(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        if ($assertionsDisabled || mcy != null) {
            return FY(3);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        if ($assertionsDisabled || mcy != null) {
            return FY(1);
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
