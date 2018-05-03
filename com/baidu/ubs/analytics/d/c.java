package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hlt = new ArrayList();
    private static int hlv = 30;
    private static ExecutorService hlu = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hlw = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hlu == null || hlu.isShutdown()) {
            hlu = Executors.newFixedThreadPool(2);
        }
        hlu.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hlw == null || hlw.isShutdown()) {
                hlw = Executors.newScheduledThreadPool(2);
            }
            hlt.add(new WeakReference<>(hlw.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hlw == null || hlw.isShutdown()) {
                hlw = Executors.newScheduledThreadPool(2);
            }
            hlw.execute(runnable);
        }
    }
}
