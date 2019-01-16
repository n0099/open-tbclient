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
    private static List<WeakReference<ScheduledFuture<?>>> ihL = new ArrayList();
    private static int ihN = 30;
    private static ExecutorService ihM = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService ihO = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (ihM == null || ihM.isShutdown()) {
            ihM = Executors.newFixedThreadPool(2);
        }
        ihM.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (ihO == null || ihO.isShutdown()) {
                ihO = Executors.newScheduledThreadPool(2);
            }
            ihL.add(new WeakReference<>(ihO.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (ihO == null || ihO.isShutdown()) {
                ihO = Executors.newScheduledThreadPool(2);
            }
            ihO.execute(runnable);
        }
    }
}
