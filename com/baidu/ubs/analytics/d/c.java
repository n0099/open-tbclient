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
    private static List<WeakReference<ScheduledFuture<?>>> hLC = new ArrayList();
    private static int hLE = 30;
    private static ExecutorService hLD = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService hLF = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (hLD == null || hLD.isShutdown()) {
            hLD = Executors.newFixedThreadPool(2);
        }
        hLD.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (hLF == null || hLF.isShutdown()) {
                hLF = Executors.newScheduledThreadPool(2);
            }
            hLC.add(new WeakReference<>(hLF.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (hLF == null || hLF.isShutdown()) {
                hLF = Executors.newScheduledThreadPool(2);
            }
            hLF.execute(runnable);
        }
    }
}
