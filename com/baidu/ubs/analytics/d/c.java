package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hCA = new ArrayList();
    private static int hCC = 30;
    private static ExecutorService hCB = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hCD = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hCB == null || hCB.isShutdown()) {
            hCB = Executors.newFixedThreadPool(2);
        }
        hCB.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hCD == null || hCD.isShutdown()) {
                hCD = Executors.newScheduledThreadPool(2);
            }
            hCA.add(new WeakReference<>(hCD.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hCD == null || hCD.isShutdown()) {
                hCD = Executors.newScheduledThreadPool(2);
            }
            hCD.execute(runnable);
        }
    }
}
