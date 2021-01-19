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
    private final Executor f6033a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6034b = Executors.newCachedThreadPool();
    private com.bytedance.sdk.adnet.c.c pkN = com.bytedance.sdk.adnet.c.f.eor();

    public i(final Handler handler) {
        this.f6033a = new Executor() { // from class: com.bytedance.sdk.adnet.core.i.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor e(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f6033a : this.f6034b;
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar) {
        a(request, pVar, null);
        if (this.pkN != null) {
            this.pkN.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, p<?> pVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        e(request).execute(new a(request, pVar, runnable));
        if (this.pkN != null) {
            this.pkN.a(request, pVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.e.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        e(request).execute(new a(request, p.c(vAdError), null));
        if (this.pkN != null) {
            this.pkN.a(request, vAdError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final p f6036b;
        private final Runnable c;
        private final Request pkw;

        public a(Request request, p pVar, Runnable runnable) {
            this.pkw = request;
            this.f6036b = pVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pkw.isCanceled()) {
                this.pkw.a("canceled-at-delivery");
                return;
            }
            this.f6036b.g = this.pkw.getExtra();
            this.f6036b.ir(SystemClock.elapsedRealtime() - this.pkw.getStartTime());
            this.f6036b.is(this.pkw.getNetDuration());
            if (this.f6036b.a()) {
                try {
                    this.pkw.a(this.f6036b);
                } catch (Throwable th) {
                }
            } else {
                try {
                    this.pkw.deliverError(this.f6036b);
                } catch (Throwable th2) {
                }
            }
            if (this.f6036b.d) {
                this.pkw.addMarker("intermediate-response");
            } else {
                this.pkw.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
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
