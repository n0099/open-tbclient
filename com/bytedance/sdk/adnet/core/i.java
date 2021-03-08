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
    private final Executor f4043a;
    private final Executor b = Executors.newCachedThreadPool();
    private com.bytedance.sdk.adnet.c.c pxH = com.bytedance.sdk.adnet.c.f.eqZ();

    public i(final Handler handler) {
        this.f4043a = new Executor() { // from class: com.bytedance.sdk.adnet.core.i.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor e(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f4043a : this.b;
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        if (this.pxH != null) {
            this.pxH.a(request, oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        e(request).execute(new a(request, oVar, runnable));
        if (this.pxH != null) {
            this.pxH.a(request, oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        e(request).execute(new a(request, o.c(vAdError), null));
        if (this.pxH != null) {
            this.pxH.a(request, vAdError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final o b;
        private final Runnable c;
        private final Request pxq;

        public a(Request request, o oVar, Runnable runnable) {
            this.pxq = request;
            this.b = oVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pxq.isCanceled()) {
                this.pxq.a("canceled-at-delivery");
                return;
            }
            this.b.g = this.pxq.getExtra();
            this.b.iu(SystemClock.elapsedRealtime() - this.pxq.getStartTime());
            this.b.iv(this.pxq.getNetDuration());
            if (this.b.a()) {
                try {
                    this.pxq.a(this.b);
                } catch (Throwable th) {
                }
            } else {
                try {
                    this.pxq.deliverError(this.b);
                } catch (Throwable th2) {
                }
            }
            if (this.b.d) {
                this.pxq.addMarker("intermediate-response");
            } else {
                this.pxq.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
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
