package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oKn = new ArrayList();
    private static int oKp = 30;
    private static ExecutorService oKo = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oKq = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oKo == null || oKo.isShutdown()) {
            oKo = Executors.newFixedThreadPool(2);
        }
        oKo.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oKq == null || oKq.isShutdown()) {
                oKq = Executors.newScheduledThreadPool(2);
            }
            oKn.add(new WeakReference<>(oKq.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oKq == null || oKq.isShutdown()) {
                oKq = Executors.newScheduledThreadPool(2);
            }
            oKq.execute(runnable);
        }
    }
}
