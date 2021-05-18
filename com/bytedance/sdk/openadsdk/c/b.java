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
    public g<T> f27299a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27300b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27301c;

    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27302a;

        public static a e() {
            if (f27302a == null) {
                synchronized (a.class) {
                    if (f27302a == null) {
                        f27302a = new a();
                    }
                }
            }
            return f27302a;
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
    public static class C0282b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0282b f27303a;

        public static C0282b e() {
            if (f27303a == null) {
                synchronized (C0282b.class) {
                    if (f27303a == null) {
                        f27303a = new C0282b();
                    }
                }
            }
            return f27303a;
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
        this.f27299a = new g<>(eVar, qVar, bVar, aVar);
        this.f27301c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0282b d() {
        return C0282b.e();
    }

    public synchronized void a() {
        if ((this.f27301c == null || !this.f27301c.get()) && this.f27299a.getLooper() == null) {
            if (this.f27301c != null && !this.f27301c.get()) {
                this.f27299a.start();
                Handler handler = new Handler(this.f27299a.getLooper(), this.f27299a);
                this.f27300b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27300b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27301c.set(true);
            }
        }
    }

    public void b() {
        this.f27301c.set(false);
        this.f27299a.quit();
        this.f27300b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27299a = gVar;
        this.f27301c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27301c.get()) {
            a();
        }
        Message obtainMessage = this.f27300b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27300b.sendMessage(obtainMessage);
    }
}
