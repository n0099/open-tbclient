package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements com.bytedance.sdk.adnet.e.d {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6332a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6333b = Executors.newCachedThreadPool();
    private com.bytedance.sdk.adnet.c.c pps = com.bytedance.sdk.adnet.c.f.esk();

    public i(final Handler handler) {
        this.f6332a = new Executor() { // from class: com.bytedance.sdk.adnet.core.i.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor e(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f6332a : this.f6333b;
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar) {
        a(request, pVar, null);
        if (this.pps != null) {
            this.pps.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        e(request).execute(new a(request, pVar, runnable));
        if (this.pps != null) {
            this.pps.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        e(request).execute(new a(request, p.c(vAdError), null));
        if (this.pps != null) {
            this.pps.a(request, vAdError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final p f6335b;
        private final Runnable c;
        private final Request ppa;

        public a(Request request, p pVar, Runnable runnable) {
            this.ppa = request;
            this.f6335b = pVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ppa.isCanceled()) {
                this.ppa.a("canceled-at-delivery");
                return;
            }
            this.f6335b.g = this.ppa.getExtra();
            this.f6335b.ir(SystemClock.elapsedRealtime() - this.ppa.getStartTime());
            this.f6335b.is(this.ppa.getNetDuration());
            if (this.f6335b.a()) {
                try {
                    this.ppa.a(this.f6335b);
                } catch (Throwable th) {
                }
            } else {
                try {
                    this.ppa.deliverError(this.f6335b);
                } catch (Throwable th2) {
                }
            }
            if (this.f6335b.d) {
                this.ppa.addMarker("intermediate-response");
            } else {
                this.ppa.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            if (this.c != null) {
                try {
                    this.c.run();
                } catch (Throwable th3) {
                }
            }
        }
    }
}
