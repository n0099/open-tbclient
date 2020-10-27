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
    private static List<WeakReference<ScheduledFuture<?>>> oiP = new ArrayList();
    private static int oiR = 30;
    private static ExecutorService oiQ = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService oiS = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (oiQ == null || oiQ.isShutdown()) {
            oiQ = Executors.newFixedThreadPool(2);
        }
        oiQ.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (oiS == null || oiS.isShutdown()) {
                oiS = Executors.newScheduledThreadPool(2);
            }
            oiP.add(new WeakReference<>(oiS.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (oiS == null || oiS.isShutdown()) {
                oiS = Executors.newScheduledThreadPool(2);
            }
            oiS.execute(runnable);
        }
    }
}
