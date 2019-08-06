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
    private static List<WeakReference<ScheduledFuture<?>>> jYs = new ArrayList();
    private static int jYu = 30;
    private static ExecutorService jYt = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jYv = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jYt == null || jYt.isShutdown()) {
            jYt = Executors.newFixedThreadPool(2);
        }
        jYt.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jYv == null || jYv.isShutdown()) {
                jYv = Executors.newScheduledThreadPool(2);
            }
            jYs.add(new WeakReference<>(jYv.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jYv == null || jYv.isShutdown()) {
                jYv = Executors.newScheduledThreadPool(2);
            }
            jYv.execute(runnable);
        }
    }
}
