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
    private static List<WeakReference<ScheduledFuture<?>>> kVU = new ArrayList();
    private static int kVW = 30;
    private static ExecutorService kVV = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kVX = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kVV == null || kVV.isShutdown()) {
            kVV = Executors.newFixedThreadPool(2);
        }
        kVV.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kVX == null || kVX.isShutdown()) {
                kVX = Executors.newScheduledThreadPool(2);
            }
            kVU.add(new WeakReference<>(kVX.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kVX == null || kVX.isShutdown()) {
                kVX = Executors.newScheduledThreadPool(2);
            }
            kVX.execute(runnable);
        }
    }
}
