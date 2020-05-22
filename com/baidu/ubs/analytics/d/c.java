package com.baidu.ubs.analytics.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class c {
    private static List<WeakReference<ScheduledFuture<?>>> mit = new ArrayList();
    private static int miv = 30;
    private static ExecutorService miu = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService miw = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (miu == null || miu.isShutdown()) {
            miu = Executors.newFixedThreadPool(2);
        }
        miu.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (miw == null || miw.isShutdown()) {
                miw = Executors.newScheduledThreadPool(2);
            }
            mit.add(new WeakReference<>(miw.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (miw == null || miw.isShutdown()) {
                miw = Executors.newScheduledThreadPool(2);
            }
            miw.execute(runnable);
        }
    }
}
