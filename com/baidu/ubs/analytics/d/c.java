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
    private static List<WeakReference<ScheduledFuture<?>>> hUx = new ArrayList();
    private static int hUz = 30;
    private static ExecutorService hUy = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hUA = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hUy == null || hUy.isShutdown()) {
            hUy = Executors.newFixedThreadPool(2);
        }
        hUy.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hUA == null || hUA.isShutdown()) {
                hUA = Executors.newScheduledThreadPool(2);
            }
            hUx.add(new WeakReference<>(hUA.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hUA == null || hUA.isShutdown()) {
                hUA = Executors.newScheduledThreadPool(2);
            }
            hUA.execute(runnable);
        }
    }
}
