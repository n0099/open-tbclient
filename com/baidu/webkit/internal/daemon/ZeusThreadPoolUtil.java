package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class ZeusThreadPoolUtil implements INoProGuard {
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    public static final String LOG_TAG = "ZeusThreadPoolUtil";
    public static final int THREAD_POOL_KEEP_ALIVE_TIME = 60;
    public static final int THREAD_POOL_MAX = 4;
    public static final int THREAD_POOL_MIN = 2;
    public static ThreadPoolExecutor mExecutor;
    public static Queue<Runnable> mLazyRunQueue;
    public static volatile boolean sIsZeusLoaded;

    /* loaded from: classes9.dex */
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
            thread.setName("T7@ZeusThreadPool");
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

    public static void execute(Runnable runnable) {
        synchronized (ZeusThreadPoolUtil.class) {
            if (sIsZeusLoaded) {
                doExecute(runnable);
                return;
            }
            if (mLazyRunQueue == null) {
                mLazyRunQueue = new ConcurrentLinkedQueue();
            }
            mLazyRunQueue.add(runnable);
            Log.d(LOG_TAG, "WebkitUnLoaded execute task=".concat(String.valueOf(runnable)));
        }
    }

    public static void executeIgnoreZeus(Runnable runnable) {
        doExecute(runnable);
    }

    public static void notifyZeusLoaded() {
        Log.d(LOG_TAG, "notifyZeusLoaded");
        synchronized (ZeusThreadPoolUtil.class) {
            sIsZeusLoaded = true;
            if (mLazyRunQueue != null) {
                Runnable poll = mLazyRunQueue.poll();
                while (true) {
                    Runnable runnable = poll;
                    if (runnable == null) {
                        break;
                    }
                    doExecute(runnable);
                    poll = mLazyRunQueue.poll();
                }
            }
        }
    }

    public static void start() {
        Log.d(LOG_TAG, "start");
        try {
            synchronized (ZeusThreadPoolUtil.class) {
                if (mExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
                    mExecutor = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        Log.d(LOG_TAG, "stop");
        try {
            synchronized (ZeusThreadPoolUtil.class) {
                if (mExecutor != null) {
                    mExecutor.shutdownNow();
                    mExecutor = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
