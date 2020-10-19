package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> nGn = new ArrayList();
    private static int nGp = 30;
    private static ExecutorService nGo = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService nGq = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (nGo == null || nGo.isShutdown()) {
            nGo = Executors.newFixedThreadPool(2);
        }
        nGo.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (nGq == null || nGq.isShutdown()) {
                nGq = Executors.newScheduledThreadPool(2);
            }
            nGn.add(new WeakReference<>(nGq.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (nGq == null || nGq.isShutdown()) {
                nGq = Executors.newScheduledThreadPool(2);
            }
            nGq.execute(runnable);
        }
    }
}
