package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oKm = new ArrayList();
    private static int oKo = 30;
    private static ExecutorService oKn = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oKp = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oKn == null || oKn.isShutdown()) {
            oKn = Executors.newFixedThreadPool(2);
        }
        oKn.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oKp == null || oKp.isShutdown()) {
                oKp = Executors.newScheduledThreadPool(2);
            }
            oKm.add(new WeakReference<>(oKp.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oKp == null || oKp.isShutdown()) {
                oKp = Executors.newScheduledThreadPool(2);
            }
            oKp.execute(runnable);
        }
    }
}
