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
    private static List<WeakReference<ScheduledFuture<?>>> mNG = new ArrayList();
    private static int mNI = 30;
    private static ExecutorService mNH = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService mNJ = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (mNH == null || mNH.isShutdown()) {
            mNH = Executors.newFixedThreadPool(2);
        }
        mNH.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (mNJ == null || mNJ.isShutdown()) {
                mNJ = Executors.newScheduledThreadPool(2);
            }
            mNG.add(new WeakReference<>(mNJ.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (mNJ == null || mNJ.isShutdown()) {
                mNJ = Executors.newScheduledThreadPool(2);
            }
            mNJ.execute(runnable);
        }
    }
}
