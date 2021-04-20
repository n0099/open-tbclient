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
/* loaded from: classes5.dex */
public abstract class PathUtils {

    /* renamed from: a  reason: collision with root package name */
    public static AsyncTask<Void, Void, String[]> f22337a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f22338b;

    /* renamed from: c  reason: collision with root package name */
    public static String f22339c;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f22340a = PathUtils.c();
    }

    static {
        new AtomicBoolean();
    }

    public static String b(int i) {
        return a.f22340a[i];
    }

    public static String[] c() {
        try {
            if (f22337a.cancel(false)) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
                String[] d2 = d();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return d2;
            }
            return f22337a.get();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public static String[] d() {
        String[] strArr = new String[4];
        strArr[0] = f22338b.getDir(f22339c, 0).getPath();
        strArr[1] = f22338b.getDir("textures", 0).getPath();
        strArr[2] = f22338b.getDatabasePath("foo").getParent();
        if (f22338b.getCacheDir() != null) {
            strArr[3] = f22338b.getCacheDir().getPath();
        }
        return strArr;
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        return b(3);
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        return b(0);
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        return b(2);
    }

    @CalledByNative
    public static String getDownloadsDirectory(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            SystemClock.elapsedRealtime();
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    public static String getNativeLibraryDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.flags;
        return ((i & 128) != 0 || (i & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        return b(1);
    }
}
