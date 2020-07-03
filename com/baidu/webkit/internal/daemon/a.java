package com.baidu.webkit.internal.daemon;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes11.dex */
public final class a {
    public static ThreadPoolExecutor a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.daemon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class ThreadFactoryC0788a implements ThreadFactory {
        private ThreadFactoryC0788a() {
        }

        public /* synthetic */ ThreadFactoryC0788a(byte b) {
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
}
