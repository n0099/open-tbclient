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
    private static List<WeakReference<ScheduledFuture<?>>> igE = new ArrayList();
    private static int igG = 30;
    private static ExecutorService igF = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService igH = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (igF == null || igF.isShutdown()) {
            igF = Executors.newFixedThreadPool(2);
        }
        igF.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (igH == null || igH.isShutdown()) {
                igH = Executors.newScheduledThreadPool(2);
            }
            igE.add(new WeakReference<>(igH.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (igH == null || igH.isShutdown()) {
                igH = Executors.newScheduledThreadPool(2);
            }
            igH.execute(runnable);
        }
    }
}
