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
    public g<T> f27413a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27414b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27415c;

    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27416a;

        public static a e() {
            if (f27416a == null) {
                synchronized (a.class) {
                    if (f27416a == null) {
                        f27416a = new a();
                    }
                }
            }
            return f27416a;
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
    public static class C0288b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0288b f27417a;

        public static C0288b e() {
            if (f27417a == null) {
                synchronized (C0288b.class) {
                    if (f27417a == null) {
                        f27417a = new C0288b();
                    }
                }
            }
            return f27417a;
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
        this.f27413a = new g<>(eVar, qVar, bVar, aVar);
        this.f27415c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0288b d() {
        return C0288b.e();
    }

    public synchronized void a() {
        if ((this.f27415c == null || !this.f27415c.get()) && this.f27413a.getLooper() == null) {
            if (this.f27415c != null && !this.f27415c.get()) {
                this.f27413a.start();
                Handler handler = new Handler(this.f27413a.getLooper(), this.f27413a);
                this.f27414b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27414b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27415c.set(true);
            }
        }
    }

    public void b() {
        this.f27415c.set(false);
        this.f27413a.quit();
        this.f27414b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27413a = gVar;
        this.f27415c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27415c.get()) {
            a();
        }
        Message obtainMessage = this.f27414b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27414b.sendMessage(obtainMessage);
    }
}
