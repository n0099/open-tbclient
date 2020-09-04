package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> ngS = new ArrayList();
    private static int ngU = 30;
    private static ExecutorService ngT = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService ngV = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (ngT == null || ngT.isShutdown()) {
            ngT = Executors.newFixedThreadPool(2);
        }
        ngT.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (ngV == null || ngV.isShutdown()) {
                ngV = Executors.newScheduledThreadPool(2);
            }
            ngS.add(new WeakReference<>(ngV.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (ngV == null || ngV.isShutdown()) {
                ngV = Executors.newScheduledThreadPool(2);
            }
            ngV.execute(runnable);
        }
    }
}
