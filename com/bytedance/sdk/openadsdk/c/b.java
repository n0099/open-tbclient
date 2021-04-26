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
    public g<T> f28054a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f28055b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f28056c;

    /* loaded from: classes5.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f28057a;

        public static a e() {
            if (f28057a == null) {
                synchronized (a.class) {
                    if (f28057a == null) {
                        f28057a = new a();
                    }
                }
            }
            return f28057a;
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
    public static class C0295b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0295b f28058a;

        public static C0295b e() {
            if (f28058a == null) {
                synchronized (C0295b.class) {
                    if (f28058a == null) {
                        f28058a = new C0295b();
                    }
                }
            }
            return f28058a;
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
        this.f28054a = new g<>(eVar, qVar, bVar, aVar);
        this.f28056c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0295b d() {
        return C0295b.e();
    }

    public synchronized void a() {
        if ((this.f28056c == null || !this.f28056c.get()) && this.f28054a.getLooper() == null) {
            if (this.f28056c != null && !this.f28056c.get()) {
                this.f28054a.start();
                Handler handler = new Handler(this.f28054a.getLooper(), this.f28054a);
                this.f28055b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f28055b.sendMessageDelayed(obtainMessage, 10000L);
                this.f28056c.set(true);
            }
        }
    }

    public void b() {
        this.f28056c.set(false);
        this.f28054a.quit();
        this.f28055b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f28054a = gVar;
        this.f28056c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f28056c.get()) {
            a();
        }
        Message obtainMessage = this.f28055b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f28055b.sendMessage(obtainMessage);
    }
}
