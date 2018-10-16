package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> hUw = new ArrayList();
    private static int hUy = 30;
    private static ExecutorService hUx = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hUz = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hUx == null || hUx.isShutdown()) {
            hUx = Executors.newFixedThreadPool(2);
        }
        hUx.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hUz == null || hUz.isShutdown()) {
                hUz = Executors.newScheduledThreadPool(2);
            }
            hUw.add(new WeakReference<>(hUz.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hUz == null || hUz.isShutdown()) {
                hUz = Executors.newScheduledThreadPool(2);
            }
            hUz.execute(runnable);
        }
    }
}
