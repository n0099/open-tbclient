package com.baidu.webkit.internal.daemon;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class ZeusThreadPoolUtil implements INoProGuard {
    private static final int CPU_COUNT;
    private static final String LOG_TAG = "ZeusThreadPoolUtil";
    private static final int THREAD_POOL_KEEP_ALIVE_TIME = 60;
    private static final int THREAD_POOL_MAX;
    private static final int THREAD_POOL_MIN;
    private static ThreadPoolExecutor mExecutor;
    private static Queue<Runnable> mLazyRunQueue;
    private static volatile boolean sIsZeusLoaded;

    /* loaded from: classes2.dex */
    private static class a implements ThreadFactory {
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

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        THREAD_POOL_MIN = availableProcessors + 1;
        THREAD_POOL_MAX = (CPU_COUNT * 2) + 1;
        mExecutor = new ThreadPoolExecutor(THREAD_POOL_MIN, THREAD_POOL_MAX, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
        sIsZeusLoaded = false;
    }

    private static void doExecute(Runnable runnable) {
        try {
            if (mExecutor == null || runnable == null) {
                return;
            }
            Log.d(LOG_TAG, "execute task:" + runnable);
            mExecutor.execute(runnable);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
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
        Log.d(LOG_TAG, IntentConfig.START);
        try {
            if (mExecutor == null) {
                mExecutor = new ThreadPoolExecutor(THREAD_POOL_MIN, THREAD_POOL_MAX, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    public static void stop() {
        Log.d(LOG_TAG, IntentConfig.STOP);
        try {
            if (mExecutor != null) {
                mExecutor.shutdownNow();
                mExecutor = null;
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }
}
