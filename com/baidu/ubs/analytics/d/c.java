package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hmx = new ArrayList();
    private static int hmz = 30;
    private static ExecutorService hmy = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hmA = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hmy == null || hmy.isShutdown()) {
            hmy = Executors.newFixedThreadPool(2);
        }
        hmy.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hmA == null || hmA.isShutdown()) {
                hmA = Executors.newScheduledThreadPool(2);
            }
            hmx.add(new WeakReference<>(hmA.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hmA == null || hmA.isShutdown()) {
                hmA = Executors.newScheduledThreadPool(2);
            }
            hmA.execute(runnable);
        }
    }
}
