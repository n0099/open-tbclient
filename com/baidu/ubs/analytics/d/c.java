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
    private static List<WeakReference<ScheduledFuture<?>>> jXm = new ArrayList();
    private static int jXo = 30;
    private static ExecutorService jXn = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jXp = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jXn == null || jXn.isShutdown()) {
            jXn = Executors.newFixedThreadPool(2);
        }
        jXn.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jXp == null || jXp.isShutdown()) {
                jXp = Executors.newScheduledThreadPool(2);
            }
            jXm.add(new WeakReference<>(jXp.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jXp == null || jXp.isShutdown()) {
                jXp = Executors.newScheduledThreadPool(2);
            }
            jXp.execute(runnable);
        }
    }
}
