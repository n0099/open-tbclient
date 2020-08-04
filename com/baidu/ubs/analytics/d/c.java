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
    private static List<WeakReference<ScheduledFuture<?>>> mNI = new ArrayList();
    private static int mNK = 30;
    private static ExecutorService mNJ = Executors.newFixedThreadPool(2);
    private static ScheduledExecutorService mNL = Executors.newScheduledThreadPool(2);

    public static void execute(Runnable runnable) {
        if (mNJ == null || mNJ.isShutdown()) {
            mNJ = Executors.newFixedThreadPool(2);
        }
        mNJ.execute(runnable);
    }

    public static synchronized void a(Runnable runnable, long j, long j2) {
        synchronized (c.class) {
            if (mNL == null || mNL.isShutdown()) {
                mNL = Executors.newScheduledThreadPool(2);
            }
            mNI.add(new WeakReference<>(mNL.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (c.class) {
            if (mNL == null || mNL.isShutdown()) {
                mNL = Executors.newScheduledThreadPool(2);
            }
            mNL.execute(runnable);
        }
    }
}
