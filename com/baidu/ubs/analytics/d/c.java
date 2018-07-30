package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hDf = new ArrayList();
    private static int hDh = 30;
    private static ExecutorService hDg = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hDi = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hDg == null || hDg.isShutdown()) {
            hDg = Executors.newFixedThreadPool(2);
        }
        hDg.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hDi == null || hDi.isShutdown()) {
                hDi = Executors.newScheduledThreadPool(2);
            }
            hDf.add(new WeakReference<>(hDi.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hDi == null || hDi.isShutdown()) {
                hDi = Executors.newScheduledThreadPool(2);
            }
            hDi.execute(runnable);
        }
    }
}
