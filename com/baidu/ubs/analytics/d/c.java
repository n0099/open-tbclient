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
    private static List<WeakReference<ScheduledFuture<?>>> oOO = new ArrayList();
    private static int oOQ = 30;
    private static ExecutorService oOP = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oOR = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oOP == null || oOP.isShutdown()) {
            oOP = Executors.newFixedThreadPool(2);
        }
        oOP.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oOR == null || oOR.isShutdown()) {
                oOR = Executors.newScheduledThreadPool(2);
            }
            oOO.add(new WeakReference<>(oOR.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oOR == null || oOR.isShutdown()) {
                oOR = Executors.newScheduledThreadPool(2);
            }
            oOR.execute(runnable);
        }
    }
}
