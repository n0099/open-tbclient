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
    public g<T> f27331a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27332b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f27333c;

    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile a f27334a;

        public static a e() {
            if (f27334a == null) {
                synchronized (a.class) {
                    if (f27334a == null) {
                        f27334a = new a();
                    }
                }
            }
            return f27334a;
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
    public static class C0285b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public static volatile C0285b f27335a;

        public static C0285b e() {
            if (f27335a == null) {
                synchronized (C0285b.class) {
                    if (f27335a == null) {
                        f27335a = new C0285b();
                    }
                }
            }
            return f27335a;
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
        this.f27331a = new g<>(eVar, qVar, bVar, aVar);
        this.f27333c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0285b d() {
        return C0285b.e();
    }

    public synchronized void a() {
        if ((this.f27333c == null || !this.f27333c.get()) && this.f27331a.getLooper() == null) {
            if (this.f27333c != null && !this.f27333c.get()) {
                this.f27331a.start();
                Handler handler = new Handler(this.f27331a.getLooper(), this.f27331a);
                this.f27332b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.f27332b.sendMessageDelayed(obtainMessage, 10000L);
                this.f27333c.set(true);
            }
        }
    }

    public void b() {
        this.f27333c.set(false);
        this.f27331a.quit();
        this.f27332b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f27331a = gVar;
        this.f27333c = new AtomicBoolean(false);
    }

    public b() {
    }

    public void a(@NonNull T t) {
        if (!this.f27333c.get()) {
            a();
        }
        Message obtainMessage = this.f27332b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = t;
        this.f27332b.sendMessage(obtainMessage);
    }
}
