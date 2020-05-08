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
    private static List<WeakReference<ScheduledFuture<?>>> lPd = new ArrayList();
    private static int lPf = 30;
    private static ExecutorService lPe = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService lPg = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (lPe == null || lPe.isShutdown()) {
            lPe = Executors.newFixedThreadPool(2);
        }
        lPe.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (lPg == null || lPg.isShutdown()) {
                lPg = Executors.newScheduledThreadPool(2);
            }
            lPd.add(new WeakReference<>(lPg.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (lPg == null || lPg.isShutdown()) {
                lPg = Executors.newScheduledThreadPool(2);
            }
            lPg.execute(runnable);
        }
    }
}
