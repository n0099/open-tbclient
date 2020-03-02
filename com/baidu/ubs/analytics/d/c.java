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
    private static List<WeakReference<ScheduledFuture<?>>> kWH = new ArrayList();
    private static int kWJ = 30;
    private static ExecutorService kWI = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kWK = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kWI == null || kWI.isShutdown()) {
            kWI = Executors.newFixedThreadPool(2);
        }
        kWI.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kWK == null || kWK.isShutdown()) {
                kWK = Executors.newScheduledThreadPool(2);
            }
            kWH.add(new WeakReference<>(kWK.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kWK == null || kWK.isShutdown()) {
                kWK = Executors.newScheduledThreadPool(2);
            }
            kWK.execute(runnable);
        }
    }
}
