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
/* loaded from: classes6.dex */
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AtomicBoolean oPe;
    private static AsyncTask<Void, Void, String[]> oPf;
    private static Context oPg;
    private static String sDataDirectorySuffix;

    static {
        $assertionsDisabled = !PathUtils.class.desiredAssertionStatus();
        oPe = new AtomicBoolean();
    }

    private PathUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final String[] DIRECTORY_PATHS = PathUtils.ege();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] ege() {
        try {
            if (oPf.cancel(false)) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
                try {
                    return setPrivateDataDirectorySuffixInternal();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return oPf.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[4];
        strArr[0] = oPg.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[1] = oPg.getDir("textures", 0).getPath();
        strArr[2] = oPg.getDatabasePath("foo").getParent();
        if (oPg.getCacheDir() != null) {
            strArr[3] = oPg.getCacheDir().getPath();
        }
        return strArr;
    }

    private static String getDirectoryPath(int i) {
        return a.DIRECTORY_PATHS[i];
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        if ($assertionsDisabled || oPf != null) {
            return getDirectoryPath(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        if ($assertionsDisabled || oPf != null) {
            return getDirectoryPath(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        if ($assertionsDisabled || oPf != null) {
            return getDirectoryPath(3);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        if ($assertionsDisabled || oPf != null) {
            return getDirectoryPath(1);
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
