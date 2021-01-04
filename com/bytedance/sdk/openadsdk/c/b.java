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
    private g<T> f6517a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f6518b;
    private AtomicBoolean c;

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar) {
        this.f6517a = new g<>(eVar, qVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f6517a = gVar;
        this.c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
    }

    public synchronized void a() {
        if ((this.c == null || !this.c.get()) && this.f6517a.getLooper() == null && this.c != null && !this.c.get()) {
            this.f6517a.start();
            this.f6518b = new Handler(this.f6517a.getLooper(), this.f6517a);
            Message obtainMessage = this.f6518b.obtainMessage();
            obtainMessage.what = 5;
            this.f6518b.sendMessage(obtainMessage);
            this.c.set(true);
        }
    }

    public void b() {
        this.c.set(false);
        this.f6517a.quit();
        this.f6518b.removeCallbacksAndMessages(null);
    }

    public void a(@NonNull T t) {
        if (this.c.get()) {
            Message obtainMessage = this.f6518b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f6518b.sendMessage(obtainMessage);
        }
    }

    public static a c() {
        return a.e();
    }

    public static C0974b d() {
        return C0974b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f6519a;

        public static a e() {
            if (f6519a == null) {
                synchronized (a.class) {
                    if (f6519a == null) {
                        f6519a = new a();
                    }
                }
            }
            return f6519a;
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
    public static class C0974b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile C0974b f6520a;

        public static C0974b e() {
            if (f6520a == null) {
                synchronized (C0974b.class) {
                    if (f6520a == null) {
                        f6520a = new C0974b();
                    }
                }
            }
            return f6520a;
        }

        C0974b() {
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
