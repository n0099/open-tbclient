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
    public g<T> f27536a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27537b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27538c;

    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27539a;

        public static a e() {
            if (f27539a == null) {
                synchronized (a.class) {
                    if (f27539a == null) {
                        f27539a = new a();
                    }
                }
            }
            return f27539a;
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
    public static class C0297b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0297b f27540a;

        public static C0297b e() {
            if (f27540a == null) {
                synchronized (C0297b.class) {
                    if (f27540a == null) {
                        f27540a = new C0297b();
                    }
                }
            }
            return f27540a;
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
        this.f27536a = new g<>(eVar, qVar, bVar, aVar);
        this.f27538c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0297b d() {
        return C0297b.e();
    }

    public synchronized void a() {
        if ((this.f27538c == null || !this.f27538c.get()) && this.f27536a.getLooper() == null) {
            if (this.f27538c != null && !this.f27538c.get()) {
                this.f27536a.start();
                Handler handler = new Handler(this.f27536a.getLooper(), this.f27536a);
                this.f27537b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27537b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27538c.set(true);
            }
        }
    }

    public void b() {
        this.f27538c.set(false);
        this.f27536a.quit();
        this.f27537b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27536a = gVar;
        this.f27538c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27538c.get()) {
            a();
        }
        Message obtainMessage = this.f27537b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27537b.sendMessage(obtainMessage);
    }
}
