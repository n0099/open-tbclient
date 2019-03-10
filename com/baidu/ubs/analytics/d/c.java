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
    private static List<WeakReference<ScheduledFuture<?>>> jxJ = new ArrayList();
    private static int jxL = 30;
    private static ExecutorService jxK = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jxM = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jxK == null || jxK.isShutdown()) {
            jxK = Executors.newFixedThreadPool(2);
        }
        jxK.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jxM == null || jxM.isShutdown()) {
                jxM = Executors.newScheduledThreadPool(2);
            }
            jxJ.add(new WeakReference<>(jxM.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jxM == null || jxM.isShutdown()) {
                jxM = Executors.newScheduledThreadPool(2);
            }
            jxM.execute(runnable);
        }
    }
}
