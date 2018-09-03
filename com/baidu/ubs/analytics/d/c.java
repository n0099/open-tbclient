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
    private static List<WeakReference<ScheduledFuture<?>>> hDh = new ArrayList();
    private static int hDj = 30;
    private static ExecutorService hDi = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hDk = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hDi == null || hDi.isShutdown()) {
            hDi = Executors.newFixedThreadPool(2);
        }
        hDi.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hDk == null || hDk.isShutdown()) {
                hDk = Executors.newScheduledThreadPool(2);
            }
            hDh.add(new WeakReference<>(hDk.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hDk == null || hDk.isShutdown()) {
                hDk = Executors.newScheduledThreadPool(2);
            }
            hDk.execute(runnable);
        }
    }
}
