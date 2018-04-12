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
    private static List<WeakReference<ScheduledFuture<?>>> hlw = new ArrayList();
    private static int hly = 30;
    private static ExecutorService hlx = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hlz = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hlx == null || hlx.isShutdown()) {
            hlx = Executors.newFixedThreadPool(2);
        }
        hlx.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hlz == null || hlz.isShutdown()) {
                hlz = Executors.newScheduledThreadPool(2);
            }
            hlw.add(new WeakReference<>(hlz.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hlz == null || hlz.isShutdown()) {
                hlz = Executors.newScheduledThreadPool(2);
            }
            hlz.execute(runnable);
        }
    }
}
