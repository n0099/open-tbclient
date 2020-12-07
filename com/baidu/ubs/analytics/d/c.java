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
    private static List<WeakReference<ScheduledFuture<?>>> oIF = new ArrayList();
    private static int oIH = 30;
    private static ExecutorService oIG = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oII = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oIG == null || oIG.isShutdown()) {
            oIG = Executors.newFixedThreadPool(2);
        }
        oIG.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oII == null || oII.isShutdown()) {
                oII = Executors.newScheduledThreadPool(2);
            }
            oIF.add(new WeakReference<>(oII.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oII == null || oII.isShutdown()) {
                oII = Executors.newScheduledThreadPool(2);
            }
            oII.execute(runnable);
        }
    }
}
