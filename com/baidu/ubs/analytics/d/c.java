package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hWh = new ArrayList();
    private static int hWj = 30;
    private static ExecutorService hWi = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hWk = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hWi == null || hWi.isShutdown()) {
            hWi = Executors.newFixedThreadPool(2);
        }
        hWi.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hWk == null || hWk.isShutdown()) {
                hWk = Executors.newScheduledThreadPool(2);
            }
            hWh.add(new WeakReference<>(hWk.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hWk == null || hWk.isShutdown()) {
                hWk = Executors.newScheduledThreadPool(2);
            }
            hWk.execute(runnable);
        }
    }
}
