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
    private static List<WeakReference<ScheduledFuture<?>>> lOZ = new ArrayList();
    private static int lPb = 30;
    private static ExecutorService lPa = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService lPc = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (lPa == null || lPa.isShutdown()) {
            lPa = Executors.newFixedThreadPool(2);
        }
        lPa.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (lPc == null || lPc.isShutdown()) {
                lPc = Executors.newScheduledThreadPool(2);
            }
            lOZ.add(new WeakReference<>(lPc.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (lPc == null || lPc.isShutdown()) {
                lPc = Executors.newScheduledThreadPool(2);
            }
            lPc.execute(runnable);
        }
    }
}
