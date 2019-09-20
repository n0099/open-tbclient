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
    private static List<WeakReference<ScheduledFuture<?>>> kaP = new ArrayList();
    private static int kaR = 30;
    private static ExecutorService kaQ = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService kaS = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (kaQ == null || kaQ.isShutdown()) {
            kaQ = Executors.newFixedThreadPool(2);
        }
        kaQ.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (kaS == null || kaS.isShutdown()) {
                kaS = Executors.newScheduledThreadPool(2);
            }
            kaP.add(new WeakReference<>(kaS.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (kaS == null || kaS.isShutdown()) {
                kaS = Executors.newScheduledThreadPool(2);
            }
            kaS.execute(runnable);
        }
    }
}
