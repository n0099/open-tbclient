package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements com.bytedance.sdk.adnet.e.d {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6035a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6036b = Executors.newCachedThreadPool();
    private com.bytedance.sdk.adnet.c.c pvc = com.bytedance.sdk.adnet.c.f.eqJ();

    public i(final Handler handler) {
        this.f6035a = new Executor() { // from class: com.bytedance.sdk.adnet.core.i.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor e(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f6035a : this.f6036b;
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar) {
        a(request, pVar, null);
        if (this.pvc != null) {
            this.pvc.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        e(request).execute(new a(request, pVar, runnable));
        if (this.pvc != null) {
            this.pvc.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        e(request).execute(new a(request, p.c(vAdError), null));
        if (this.pvc != null) {
            this.pvc.a(request, vAdError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final p f6038b;
        private final Runnable c;
        private final Request puL;

        public a(Request request, p pVar, Runnable runnable) {
            this.puL = request;
            this.f6038b = pVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.puL.isCanceled()) {
                this.puL.a("canceled-at-delivery");
                return;
            }
            this.f6038b.g = this.puL.getExtra();
            this.f6038b.iu(SystemClock.elapsedRealtime() - this.puL.getStartTime());
            this.f6038b.iv(this.puL.getNetDuration());
            if (this.f6038b.a()) {
                try {
                    this.puL.a(this.f6038b);
                } catch (Throwable th) {
                }
            } else {
                try {
                    this.puL.deliverError(this.f6038b);
                } catch (Throwable th2) {
                }
            }
            if (this.f6038b.d) {
                this.puL.addMarker("intermediate-response");
            } else {
                this.puL.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
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
