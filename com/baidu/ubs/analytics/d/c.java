package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> orV = new ArrayList();
    private static int orX = 30;
    private static ExecutorService orW = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService orY = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (orW == null || orW.isShutdown()) {
            orW = Executors.newFixedThreadPool(2);
        }
        orW.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (orY == null || orY.isShutdown()) {
                orY = Executors.newScheduledThreadPool(2);
            }
            orV.add(new WeakReference<>(orY.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (orY == null || orY.isShutdown()) {
                orY = Executors.newScheduledThreadPool(2);
            }
            orY.execute(runnable);
        }
    }
}
