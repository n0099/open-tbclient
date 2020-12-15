package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes17.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> oIH = new ArrayList();
    private static int oIJ = 30;
    private static ExecutorService oII = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oIK = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oII == null || oII.isShutdown()) {
            oII = Executors.newFixedThreadPool(2);
        }
        oII.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oIK == null || oIK.isShutdown()) {
                oIK = Executors.newScheduledThreadPool(2);
            }
            oIH.add(new WeakReference<>(oIK.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oIK == null || oIK.isShutdown()) {
                oIK = Executors.newScheduledThreadPool(2);
            }
            oIK.execute(runnable);
        }
    }
}
