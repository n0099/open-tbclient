package com.bytedance.sdk.component.adnet.core;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes9.dex */
public class h extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f64149a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.b f64150b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.a f64151c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.c f64152d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64153e;

    public h(BlockingQueue<Request<?>> blockingQueue, com.bytedance.sdk.component.adnet.face.b bVar, com.bytedance.sdk.component.adnet.face.a aVar, com.bytedance.sdk.component.adnet.face.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {blockingQueue, bVar, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64153e = false;
        this.f64149a = blockingQueue;
        this.f64150b = bVar;
        this.f64151c = aVar;
        this.f64152d = cVar;
    }

    @TargetApi(14)
    private void b(Request<?> request) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, request) == null) || Build.VERSION.SDK_INT < 14) {
            return;
        }
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64153e = true;
            interrupt();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f64153e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            a(this.f64149a.take());
        }
    }

    @VisibleForTesting
    public void a(Request<?> request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            request.a(3);
            try {
                try {
                    try {
                        request.addMarker("network-queue-take");
                    } catch (Exception e2) {
                        o.a(e2, "Unhandled exception %s", e2.toString());
                        VAdError vAdError = new VAdError(e2, 608);
                        vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                        this.f64152d.a(request, vAdError);
                        request.e();
                    }
                } catch (VAdError e3) {
                    e3.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(request, e3);
                    request.e();
                }
                if (request.isCanceled()) {
                    request.a("network-discard-cancelled");
                    request.e();
                    request.a(4);
                    return;
                }
                b(request);
                i a2 = this.f64150b.a(request);
                request.setNetDuration(a2.f64159f);
                request.addMarker("network-http-complete");
                if (a2.f64158e && request.hasHadResponseDelivered()) {
                    request.a("not-modified");
                    request.e();
                    request.a(4);
                    return;
                }
                m<?> a3 = request.a(a2);
                request.setNetDuration(a2.f64159f);
                request.addMarker("network-parse-complete");
                if (request.shouldCache() && a3.f64173b != null) {
                    this.f64151c.a(request.getCacheKey(), a3.f64173b);
                    request.addMarker("network-cache-written");
                }
                request.markDelivered();
                this.f64152d.a(request, a3);
                request.b(a3);
                request.a(4);
            }
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, request, vAdError) == null) {
            this.f64152d.a(request, request.a(vAdError));
        }
    }
}
