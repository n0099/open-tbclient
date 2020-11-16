package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes17.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oty = new ArrayList();
    private static int otA = 30;
    private static ExecutorService otz = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService otB = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (otz == null || otz.isShutdown()) {
            otz = Executors.newFixedThreadPool(2);
        }
        otz.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (otB == null || otB.isShutdown()) {
                otB = Executors.newScheduledThreadPool(2);
            }
            oty.add(new WeakReference<>(otB.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (otB == null || otB.isShutdown()) {
                otB = Executors.newScheduledThreadPool(2);
            }
            otB.execute(runnable);
        }
    }
}
