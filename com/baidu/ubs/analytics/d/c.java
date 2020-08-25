package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> ngA = new ArrayList();
    private static int ngC = 30;
    private static ExecutorService ngB = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService ngD = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (ngB == null || ngB.isShutdown()) {
            ngB = Executors.newFixedThreadPool(2);
        }
        ngB.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (ngD == null || ngD.isShutdown()) {
                ngD = Executors.newScheduledThreadPool(2);
            }
            ngA.add(new WeakReference<>(ngD.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (ngD == null || ngD.isShutdown()) {
                ngD = Executors.newScheduledThreadPool(2);
            }
            ngD.execute(runnable);
        }
    }
}
