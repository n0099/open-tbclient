package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class ZeusThreadPoolUtil implements INoProGuard {
    private static final String LOG_TAG = "ZeusThreadPoolUtil";
    private static final int THREAD_POOL_KEEP_ALIVE_TIME = 60;
    private static final int THREAD_POOL_MAX = 4;
    private static final int THREAD_POOL_MIN = 2;
    private static ThreadPoolExecutor mExecutor;
    private static Queue<Runnable> mLazyRunQueue;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static volatile boolean sIsZeusLoaded = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements ThreadFactory {
        private a() {
        }

        /* synthetic */ a(byte b) {
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

    private static void doExecute(Runnable runnable) {
        try {
            if (mExecutor == null) {
                start();
            }
            if (mExecutor == null || runnable == null) {
                return;
            }
            Log.d(LOG_TAG, "execute task:" + runnable);
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
            Log.d(LOG_TAG, "WebkitUnLoaded execute task=" + runnable);
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
                for (Runnable poll = mLazyRunQueue.poll(); poll != null; poll = mLazyRunQueue.poll()) {
                    doExecute(poll);
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
            com.a.a.a.a.a.a.a.a(e);
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
            com.a.a.a.a.a.a.a.a(e);
        }
    }
}
