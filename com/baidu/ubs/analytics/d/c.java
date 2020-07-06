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
    private static List<WeakReference<ScheduledFuture<?>>> mFC = new ArrayList();
    private static int mFE = 30;
    private static ExecutorService mFD = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService mFF = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (mFD == null || mFD.isShutdown()) {
            mFD = Executors.newFixedThreadPool(2);
        }
        mFD.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (mFF == null || mFF.isShutdown()) {
                mFF = Executors.newScheduledThreadPool(2);
            }
            mFC.add(new WeakReference<>(mFF.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (mFF == null || mFF.isShutdown()) {
                mFF = Executors.newScheduledThreadPool(2);
            }
            mFF.execute(runnable);
        }
    }
}
