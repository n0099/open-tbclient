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
/* loaded from: classes4.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request<?>> f6039a;
    private volatile boolean e = false;
    private final com.bytedance.sdk.adnet.e.c pkQ;
    private final com.bytedance.sdk.adnet.e.b pkR;
    private final com.bytedance.sdk.adnet.e.d pkS;

    public k(BlockingQueue<Request<?>> blockingQueue, com.bytedance.sdk.adnet.e.c cVar, com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.d dVar) {
        this.f6039a = blockingQueue;
        this.pkQ = cVar;
        this.pkR = bVar;
        this.pkS = dVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    @TargetApi(14)
    private void g(Request<?> request) {
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
                r.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        b(this.f6039a.take());
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
                    g(request);
                    l c = this.pkQ.c(request);
                    request.setNetDuration(c.f);
                    request.addMarker("network-http-complete");
                    if (c.e && request.hasHadResponseDelivered()) {
                        request.a("not-modified");
                        request.e();
                        return;
                    }
                    p<?> a2 = request.a(c);
                    request.setNetDuration(c.f);
                    request.addMarker("network-parse-complete");
                    if (request.shouldCache() && a2.pkZ != null) {
                        this.pkR.a(request.getCacheKey(), a2.pkZ);
                        request.addMarker("network-cache-written");
                    }
                    request.markDelivered();
                    this.pkS.a(request, a2);
                    request.b(a2);
                } catch (VAdError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(request, e);
                    request.e();
                }
            } catch (Exception e2) {
                r.a(e2, "Unhandled exception %s", e2.toString());
                VAdError vAdError = new VAdError(e2);
                vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.pkS.a(request, vAdError);
                request.e();
            }
        } finally {
            request.a(4);
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        this.pkS.a(request, request.a(vAdError));
    }
}
