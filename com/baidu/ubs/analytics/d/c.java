package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> nqT = new ArrayList();
    private static int nqV = 30;
    private static ExecutorService nqU = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService nqW = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (nqU == null || nqU.isShutdown()) {
            nqU = Executors.newFixedThreadPool(2);
        }
        nqU.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (nqW == null || nqW.isShutdown()) {
                nqW = Executors.newScheduledThreadPool(2);
            }
            nqT.add(new WeakReference<>(nqW.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (nqW == null || nqW.isShutdown()) {
                nqW = Executors.newScheduledThreadPool(2);
            }
            nqW.execute(runnable);
        }
    }
}
