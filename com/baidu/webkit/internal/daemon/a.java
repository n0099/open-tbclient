package com.baidu.webkit.internal.daemon;

import com.baidu.webkit.sdk.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public final class a {
    private static ThreadPoolExecutor a = null;

    /* renamed from: com.baidu.webkit.internal.daemon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class ThreadFactoryC0694a implements ThreadFactory {
        private ThreadFactoryC0694a() {
        }

        /* synthetic */ ThreadFactoryC0694a(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("T7@SDKDaemon");
            return thread;
        }
    }

    public static void a() {
        Log.d("SdkDaemon", "start");
        try {
            if (a == null) {
                a = new ThreadPoolExecutor(2, 30, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0694a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    public static void a(Runnable runnable) {
        try {
            if (a != null) {
                Log.d("SdkDaemon", "execute");
                a.execute(runnable);
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }
}
