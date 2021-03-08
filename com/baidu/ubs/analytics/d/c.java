package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oXa = new ArrayList();
    private static int oXc = 30;
    private static ExecutorService oXb = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oXd = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oXb == null || oXb.isShutdown()) {
            oXb = Executors.newFixedThreadPool(2);
        }
        oXb.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oXd == null || oXd.isShutdown()) {
                oXd = Executors.newScheduledThreadPool(2);
            }
            oXa.add(new WeakReference<>(oXd.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oXd == null || oXd.isShutdown()) {
                oXd = Executors.newScheduledThreadPool(2);
            }
            oXd.execute(runnable);
        }
    }
}
