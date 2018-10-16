package com.baidu.webkit.sdk.performance;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ZeusPerformanceTiming {
    private static boolean mIsMainThread;
    private static long mNewWebViewStart = 0;
    private static long mNewWebViewEnd = 0;
    private static long mInitProviderStart = 0;
    private static long mInitProviderEnd = 0;
    private static long mUnzipStart = 0;
    private static long mUnzipEnd = 0;
    private static long mNewZeusClassLoaderStart = 0;
    private static long mNewZeusClassLoaderEnd = 0;
    private static long mInitOnAppStart = 0;
    private static long sInitWebkitStart = 0;
    private static long sInitWebkitEnd = 0;
    private static List<Long> sWebViewInitTimingList = new ArrayList();
    private static long sWebViewInitTiming = 0;

    private static long getCurrentTimeMillis(long j) {
        return j == 0 ? System.currentTimeMillis() : j;
    }

    public static String getWebViewInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (mNewWebViewStart > 0 && mNewWebViewEnd > 0) {
            sb.append("new first WebView = ");
            sb.append(String.valueOf(mNewWebViewEnd - mNewWebViewStart));
        }
        return sb.toString();
    }

    public static List<Long> getWebViewInitTimings() {
        return sWebViewInitTimingList;
    }

    public static String getZeusInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (sInitWebkitStart > 0 && sInitWebkitEnd > 0) {
            sb.append("initWebkit = ");
            sb.append(String.valueOf(sInitWebkitEnd - sInitWebkitStart));
        }
        makeTimingFormat(sb, "unzip          ", mUnzipStart, mUnzipEnd, sInitWebkitStart);
        makeTimingFormat(sb, "ZeusClassLoader", mNewZeusClassLoaderStart, mNewZeusClassLoaderEnd, sInitWebkitStart);
        makeTimingFormat(sb, "initProvider   ", mInitProviderStart, mInitProviderEnd, sInitWebkitStart);
        return sb.toString();
    }

    public static void initOnAppStart() {
        mInitOnAppStart = getCurrentTimeMillis(mInitOnAppStart);
    }

    public static long initOnAppStartTime() {
        return mInitOnAppStart;
    }

    public static void initProviderEnd() {
        mInitProviderEnd = getCurrentTimeMillis(mInitProviderEnd);
    }

    public static boolean initProviderInMainThread() {
        return mIsMainThread;
    }

    public static void initProviderStart() {
        mInitProviderStart = getCurrentTimeMillis(mInitProviderStart);
        mIsMainThread = Looper.getMainLooper() == Looper.myLooper();
    }

    public static long initProviderTime() {
        return mInitProviderEnd - mInitProviderStart;
    }

    public static void initWebkitEnd() {
        sInitWebkitEnd = getCurrentTimeMillis(sInitWebkitEnd);
    }

    public static void initWebkitStart() {
        sInitWebkitStart = getCurrentTimeMillis(sInitWebkitStart);
    }

    public static long initWebkitStartTime() {
        return sInitWebkitStart;
    }

    public static long initWebkitTime() {
        return sInitWebkitEnd - sInitWebkitStart;
    }

    private static void makeTimingFormat(StringBuilder sb, String str, long j, long j2, long j3) {
        if (sb == null || str == null || j <= 0 || j2 <= 0) {
            return;
        }
        sb.append('\n');
        sb.append(str + " from init: ");
        sb.append(j2 - j3);
        sb.append(" self: ");
        sb.append(j2 - j);
    }

    public static void newWebViewEnd() {
        mNewWebViewEnd = getCurrentTimeMillis(mNewWebViewEnd);
        sWebViewInitTimingList.add(Long.valueOf(System.currentTimeMillis() - sWebViewInitTiming));
    }

    public static void newWebViewStart() {
        mNewWebViewStart = getCurrentTimeMillis(mNewWebViewStart);
        sWebViewInitTiming = System.currentTimeMillis();
    }

    public static long newWebViewTime() {
        return mNewWebViewEnd - mNewWebViewStart;
    }

    public static void newZeusClassLoaderEnd() {
        mNewZeusClassLoaderEnd = getCurrentTimeMillis(mNewZeusClassLoaderEnd);
    }

    public static void newZeusClassLoaderStart() {
        mNewZeusClassLoaderStart = getCurrentTimeMillis(mNewZeusClassLoaderStart);
    }

    public static long newZeusClassLoaderTime() {
        return mNewZeusClassLoaderEnd - mNewZeusClassLoaderStart;
    }

    public static void unzipEnd() {
        mUnzipEnd = getCurrentTimeMillis(mUnzipEnd);
    }

    public static long unzipEndDiff() {
        return mUnzipEnd - mNewZeusClassLoaderEnd;
    }

    public static void unzipStart() {
        mUnzipStart = getCurrentTimeMillis(mUnzipStart);
    }

    public static long unzipStartDiff() {
        return mNewZeusClassLoaderStart - mUnzipStart;
    }

    public static long unzipTime() {
        return mUnzipEnd - mUnzipStart;
    }
}
