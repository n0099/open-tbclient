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
    private static List<WeakReference<ScheduledFuture<?>>> jxr = new ArrayList();
    private static int jxt = 30;
    private static ExecutorService jxs = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jxu = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jxs == null || jxs.isShutdown()) {
            jxs = Executors.newFixedThreadPool(2);
        }
        jxs.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jxu == null || jxu.isShutdown()) {
                jxu = Executors.newScheduledThreadPool(2);
            }
            jxr.add(new WeakReference<>(jxu.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jxu == null || jxu.isShutdown()) {
                jxu = Executors.newScheduledThreadPool(2);
            }
            jxu.execute(runnable);
        }
    }
}
