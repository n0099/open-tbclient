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
    private static List<WeakReference<ScheduledFuture<?>>> jxq = new ArrayList();
    private static int jxs = 30;
    private static ExecutorService jxr = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService jxt = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (jxr == null || jxr.isShutdown()) {
            jxr = Executors.newFixedThreadPool(2);
        }
        jxr.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (jxt == null || jxt.isShutdown()) {
                jxt = Executors.newScheduledThreadPool(2);
            }
            jxq.add(new WeakReference<>(jxt.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (jxt == null || jxt.isShutdown()) {
                jxt = Executors.newScheduledThreadPool(2);
            }
            jxt.execute(runnable);
        }
    }
}
