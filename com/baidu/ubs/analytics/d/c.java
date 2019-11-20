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
    private static List<WeakReference<ScheduledFuture<?>>> jXY = new ArrayList();
    private static int jYa = 30;
    private static ExecutorService jXZ = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jYb = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jXZ == null || jXZ.isShutdown()) {
            jXZ = Executors.newFixedThreadPool(2);
        }
        jXZ.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jYb == null || jYb.isShutdown()) {
                jYb = Executors.newScheduledThreadPool(2);
            }
            jXY.add(new WeakReference<>(jYb.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jYb == null || jYb.isShutdown()) {
                jYb = Executors.newScheduledThreadPool(2);
            }
            jYb.execute(runnable);
        }
    }
}
