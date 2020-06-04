package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> mjD = new ArrayList();
    private static int mjF = 30;
    private static ExecutorService mjE = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService mjG = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (mjE == null || mjE.isShutdown()) {
            mjE = Executors.newFixedThreadPool(2);
        }
        mjE.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (mjG == null || mjG.isShutdown()) {
                mjG = Executors.newScheduledThreadPool(2);
            }
            mjD.add(new WeakReference<>(mjG.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (mjG == null || mjG.isShutdown()) {
                mjG = Executors.newScheduledThreadPool(2);
            }
            mjG.execute(runnable);
        }
    }
}
