package com.baidu.yuyinala.privatemessage.implugin.b;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class b {
    private static b oxt;
    private ThreadPoolExecutor mThreadPool;
    private static final String TAG = b.class.getSimpleName();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static synchronized b gy(Context context) {
        b bVar;
        synchronized (b.class) {
            if (oxt == null) {
                oxt = new b();
            }
            bVar = oxt;
        }
        return bVar;
    }

    public b() {
        this.mThreadPool = null;
        this.mThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        this.mThreadPool.allowCoreThreadTimeOut(true);
    }

    public void C(Runnable runnable) {
        try {
            this.mThreadPool.submit(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
