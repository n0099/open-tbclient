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
    private static List<WeakReference<ScheduledFuture<?>>> ihM = new ArrayList();
    private static int ihO = 30;
    private static ExecutorService ihN = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService ihP = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (ihN == null || ihN.isShutdown()) {
            ihN = Executors.newFixedThreadPool(2);
        }
        ihN.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (ihP == null || ihP.isShutdown()) {
                ihP = Executors.newScheduledThreadPool(2);
            }
            ihM.add(new WeakReference<>(ihP.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (ihP == null || ihP.isShutdown()) {
                ihP = Executors.newScheduledThreadPool(2);
            }
            ihP.execute(runnable);
        }
    }
}
