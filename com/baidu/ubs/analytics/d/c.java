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
    private static List<WeakReference<ScheduledFuture<?>>> kYx = new ArrayList();
    private static int kYz = 30;
    private static ExecutorService kYy = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kYA = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kYy == null || kYy.isShutdown()) {
            kYy = Executors.newFixedThreadPool(2);
        }
        kYy.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kYA == null || kYA.isShutdown()) {
                kYA = Executors.newScheduledThreadPool(2);
            }
            kYx.add(new WeakReference<>(kYA.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kYA == null || kYA.isShutdown()) {
                kYA = Executors.newScheduledThreadPool(2);
            }
            kYA.execute(runnable);
        }
    }
}
