package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> mFz = new ArrayList();
    private static int mFB = 30;
    private static ExecutorService mFA = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService mFC = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (mFA == null || mFA.isShutdown()) {
            mFA = Executors.newFixedThreadPool(2);
        }
        mFA.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (mFC == null || mFC.isShutdown()) {
                mFC = Executors.newScheduledThreadPool(2);
            }
            mFz.add(new WeakReference<>(mFC.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (mFC == null || mFC.isShutdown()) {
                mFC = Executors.newScheduledThreadPool(2);
            }
            mFC.execute(runnable);
        }
    }
}
