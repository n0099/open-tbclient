package com.bytedance.sdk.adnet.core;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request<?>> f4045a;
    private volatile boolean e = false;
    private final com.bytedance.sdk.adnet.e.c pxJ;
    private final com.bytedance.sdk.adnet.e.b pxK;
    private final com.bytedance.sdk.adnet.e.d pxL;

    public j(BlockingQueue<Request<?>> blockingQueue, com.bytedance.sdk.adnet.e.c cVar, com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.d dVar) {
        this.f4045a = blockingQueue;
        this.pxJ = cVar;
        this.pxK = bVar;
        this.pxL = dVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    @TargetApi(14)
    private void f(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException e) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        b(this.f4045a.take());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [193=6] */
    @VisibleForTesting
    void b(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.a(3);
        try {
            try {
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.a("network-discard-cancelled");
                        request.e();
                        return;
                    }
                    f(request);
                    k c = this.pxJ.c(request);
                    request.setNetDuration(c.f);
                    request.addMarker("network-http-complete");
                    if (c.e && request.hasHadResponseDelivered()) {
                        request.a("not-modified");
                        request.e();
                        return;
                    }
                    o<?> a2 = request.a(c);
                    request.setNetDuration(c.f);
                    request.addMarker("network-parse-complete");
                    if (request.shouldCache() && a2.pxS != null) {
                        this.pxK.a(request.getCacheKey(), a2.pxS);
                        request.addMarker("network-cache-written");
                    }
                    request.markDelivered();
                    this.pxL.a(request, a2);
                    request.b(a2);
                } catch (VAdError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(request, e);
                    request.e();
                }
            } catch (Exception e2) {
                q.a(e2, "Unhandled exception %s", e2.toString());
                VAdError vAdError = new VAdError(e2);
                vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.pxL.a(request, vAdError);
                request.e();
            }
        } finally {
            request.a(4);
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        this.pxL.a(request, request.a(vAdError));
    }
}
