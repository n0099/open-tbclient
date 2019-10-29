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
    private static List<WeakReference<ScheduledFuture<?>>> jYP = new ArrayList();
    private static int jYR = 30;
    private static ExecutorService jYQ = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jYS = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jYQ == null || jYQ.isShutdown()) {
            jYQ = Executors.newFixedThreadPool(2);
        }
        jYQ.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jYS == null || jYS.isShutdown()) {
                jYS = Executors.newScheduledThreadPool(2);
            }
            jYP.add(new WeakReference<>(jYS.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jYS == null || jYS.isShutdown()) {
                jYS = Executors.newScheduledThreadPool(2);
            }
            jYS.execute(runnable);
        }
    }
}
