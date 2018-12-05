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
    private static List<WeakReference<ScheduledFuture<?>>> idu = new ArrayList();
    private static int idw = 30;
    private static ExecutorService idv = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService idx = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (idv == null || idv.isShutdown()) {
            idv = Executors.newFixedThreadPool(2);
        }
        idv.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (idx == null || idx.isShutdown()) {
                idx = Executors.newScheduledThreadPool(2);
            }
            idu.add(new WeakReference<>(idx.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (idx == null || idx.isShutdown()) {
                idx = Executors.newScheduledThreadPool(2);
            }
            idx.execute(runnable);
        }
    }
}
