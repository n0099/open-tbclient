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
    private static List<WeakReference<ScheduledFuture<?>>> hyt = new ArrayList();
    private static int hyv = 30;
    private static ExecutorService hyu = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hyw = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hyu == null || hyu.isShutdown()) {
            hyu = Executors.newFixedThreadPool(2);
        }
        hyu.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hyw == null || hyw.isShutdown()) {
                hyw = Executors.newScheduledThreadPool(2);
            }
            hyt.add(new WeakReference<>(hyw.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hyw == null || hyw.isShutdown()) {
                hyw = Executors.newScheduledThreadPool(2);
            }
            hyw.execute(runnable);
        }
    }
}
