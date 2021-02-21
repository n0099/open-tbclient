package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes15.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oUV = new ArrayList();
    private static int oUX = 30;
    private static ExecutorService oUW = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oUY = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oUW == null || oUW.isShutdown()) {
            oUW = Executors.newFixedThreadPool(2);
        }
        oUW.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oUY == null || oUY.isShutdown()) {
                oUY = Executors.newScheduledThreadPool(2);
            }
            oUV.add(new WeakReference<>(oUY.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oUY == null || oUY.isShutdown()) {
                oUY = Executors.newScheduledThreadPool(2);
            }
            oUY.execute(runnable);
        }
    }
}
