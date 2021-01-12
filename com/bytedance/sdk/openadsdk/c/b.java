package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.h.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class b<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    private g<T> f6218a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f6219b;
    private AtomicBoolean c;

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar) {
        this.f6218a = new g<>(eVar, qVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f6218a = gVar;
        this.c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
    }

    public synchronized void a() {
        if ((this.c == null || !this.c.get()) && this.f6218a.getLooper() == null && this.c != null && !this.c.get()) {
            this.f6218a.start();
            this.f6219b = new Handler(this.f6218a.getLooper(), this.f6218a);
            Message obtainMessage = this.f6219b.obtainMessage();
            obtainMessage.what = 5;
            this.f6219b.sendMessage(obtainMessage);
            this.c.set(true);
        }
    }

    public void b() {
        this.c.set(false);
        this.f6218a.quit();
        this.f6219b.removeCallbacksAndMessages(null);
    }

    public void a(@NonNull T t) {
        if (this.c.get()) {
            Message obtainMessage = this.f6219b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f6219b.sendMessage(obtainMessage);
        }
    }

    public static a c() {
        return a.e();
    }

    public static C0995b d() {
        return C0995b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f6220a;

        public static a e() {
            if (f6220a == null) {
                synchronized (a.class) {
                    if (f6220a == null) {
                        f6220a = new a();
                    }
                }
            }
            return f6220a;
        }

        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull com.bytedance.sdk.openadsdk.c.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0995b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile C0995b f6221a;

        public static C0995b e() {
            if (f6221a == null) {
                synchronized (C0995b.class) {
                    if (f6221a == null) {
                        f6221a = new C0995b();
                    }
                }
            }
            return f6221a;
        }

        C0995b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull c.a aVar) {
        }
    }
}
