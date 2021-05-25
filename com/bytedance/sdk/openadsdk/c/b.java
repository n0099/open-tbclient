package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    public g<T> f27228a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27229b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27230c;

    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27231a;

        public static a e() {
            if (f27231a == null) {
                synchronized (a.class) {
                    if (f27231a == null) {
                        f27231a = new a();
                    }
                }
            }
            return f27231a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull com.bytedance.sdk.openadsdk.c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0283b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0283b f27232a;

        public static C0283b e() {
            if (f27232a == null) {
                synchronized (C0283b.class) {
                    if (f27232a == null) {
                        f27232a = new C0283b();
                    }
                }
            }
            return f27232a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar) {
        this.f27228a = new g<>(eVar, qVar, bVar, aVar);
        this.f27230c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0283b d() {
        return C0283b.e();
    }

    public synchronized void a() {
        if ((this.f27230c == null || !this.f27230c.get()) && this.f27228a.getLooper() == null) {
            if (this.f27230c != null && !this.f27230c.get()) {
                this.f27228a.start();
                Handler handler = new Handler(this.f27228a.getLooper(), this.f27228a);
                this.f27229b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27229b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27230c.set(true);
            }
        }
    }

    public void b() {
        this.f27230c.set(false);
        this.f27228a.quit();
        this.f27229b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27228a = gVar;
        this.f27230c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27230c.get()) {
            a();
        }
        Message obtainMessage = this.f27229b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27229b.sendMessage(obtainMessage);
    }
}
