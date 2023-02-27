package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class NetProbeThreadPoolUtil implements INoProGuard {
    public static final String LOG_TAG = "NetProbeThreadPoolUtil";
    public static final int THREAD_POOL_KEEP_ALIVE_TIME = 60;
    public static final int THREAD_POOL_MAX = 2;
    public static final int THREAD_POOL_MIN = 2;
    public static ThreadPoolExecutor mExecutor;

    /* loaded from: classes7.dex */
    public static class a implements ThreadFactory {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("T7@NetProbeThreadPool");
            return thread;
        }
    }

    public static void doExecute(Runnable runnable) {
        try {
            if (mExecutor == null) {
                start();
            }
            if (mExecutor == null || runnable == null) {
                return;
            }
            Log.d(LOG_TAG, "execute task:".concat(String.valueOf(runnable)));
            mExecutor.execute(runnable);
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public static void executeIgnoreZeus(Runnable runnable) {
        doExecute(runnable);
    }

    public static long getActiveCount() {
        return mExecutor.getActiveCount();
    }

    public static long getCompletedTaskCount() {
        return mExecutor.getCompletedTaskCount();
    }

    public static long getTaskCount() {
        return mExecutor.getTaskCount();
    }

    public static boolean isStarted() {
        return mExecutor != null;
    }

    public static void start() {
        Log.d(LOG_TAG, "start");
        try {
            synchronized (NetProbeThreadPoolUtil.class) {
                if (mExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
                    mExecutor = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
