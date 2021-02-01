package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes15.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oUv = new ArrayList();
    private static int oUx = 30;
    private static ExecutorService oUw = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oUy = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oUw == null || oUw.isShutdown()) {
            oUw = Executors.newFixedThreadPool(2);
        }
        oUw.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oUy == null || oUy.isShutdown()) {
                oUy = Executors.newScheduledThreadPool(2);
            }
            oUv.add(new WeakReference<>(oUy.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oUy == null || oUy.isShutdown()) {
                oUy = Executors.newScheduledThreadPool(2);
            }
            oUy.execute(runnable);
        }
    }
}
