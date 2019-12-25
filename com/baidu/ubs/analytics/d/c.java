package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> kSt = new ArrayList();
    private static int kSv = 30;
    private static ExecutorService kSu = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kSw = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kSu == null || kSu.isShutdown()) {
            kSu = Executors.newFixedThreadPool(2);
        }
        kSu.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kSw == null || kSw.isShutdown()) {
                kSw = Executors.newScheduledThreadPool(2);
            }
            kSt.add(new WeakReference<>(kSw.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kSw == null || kSw.isShutdown()) {
                kSw = Executors.newScheduledThreadPool(2);
            }
            kSw.execute(runnable);
        }
    }
}
