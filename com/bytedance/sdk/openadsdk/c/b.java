package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class b<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    public g<T> f27230a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27231b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27232c;

    /* loaded from: classes5.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27233a;

        public static a e() {
            if (f27233a == null) {
                synchronized (a.class) {
                    if (f27233a == null) {
                        f27233a = new a();
                    }
                }
            }
            return f27233a;
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
    /* loaded from: classes5.dex */
    public static class C0302b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0302b f27234a;

        public static C0302b e() {
            if (f27234a == null) {
                synchronized (C0302b.class) {
                    if (f27234a == null) {
                        f27234a = new C0302b();
                    }
                }
            }
            return f27234a;
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
        this.f27230a = new g<>(eVar, qVar, bVar, aVar);
        this.f27232c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0302b d() {
        return C0302b.e();
    }

    public synchronized void a() {
        if ((this.f27232c == null || !this.f27232c.get()) && this.f27230a.getLooper() == null) {
            if (this.f27232c != null && !this.f27232c.get()) {
                this.f27230a.start();
                Handler handler = new Handler(this.f27230a.getLooper(), this.f27230a);
                this.f27231b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27231b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27232c.set(true);
            }
        }
    }

    public void b() {
        this.f27232c.set(false);
        this.f27230a.quit();
        this.f27231b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27230a = gVar;
        this.f27232c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27232c.get()) {
            a();
        }
        Message obtainMessage = this.f27231b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27231b.sendMessage(obtainMessage);
    }
}
