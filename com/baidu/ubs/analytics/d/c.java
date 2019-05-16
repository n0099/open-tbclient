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
    private static List<WeakReference<ScheduledFuture<?>>> jQh = new ArrayList();
    private static int jQj = 30;
    private static ExecutorService jQi = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jQk = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jQi == null || jQi.isShutdown()) {
            jQi = Executors.newFixedThreadPool(2);
        }
        jQi.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jQk == null || jQk.isShutdown()) {
                jQk = Executors.newScheduledThreadPool(2);
            }
            jQh.add(new WeakReference<>(jQk.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jQk == null || jQk.isShutdown()) {
                jQk = Executors.newScheduledThreadPool(2);
            }
            jQk.execute(runnable);
        }
    }
}
