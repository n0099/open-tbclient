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
    private static List<WeakReference<ScheduledFuture<?>>> kWF = new ArrayList();
    private static int kWH = 30;
    private static ExecutorService kWG = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kWI = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kWG == null || kWG.isShutdown()) {
            kWG = Executors.newFixedThreadPool(2);
        }
        kWG.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kWI == null || kWI.isShutdown()) {
                kWI = Executors.newScheduledThreadPool(2);
            }
            kWF.add(new WeakReference<>(kWI.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kWI == null || kWI.isShutdown()) {
                kWI = Executors.newScheduledThreadPool(2);
            }
            kWI.execute(runnable);
        }
    }
}
