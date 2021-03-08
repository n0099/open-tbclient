package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    private g<T> f4195a;
    private Handler b;
    private AtomicBoolean c;

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar) {
        this.f4195a = new g<>(eVar, qVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f4195a = gVar;
        this.c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
    }

    public synchronized void a() {
        if ((this.c == null || !this.c.get()) && this.f4195a.getLooper() == null && this.c != null && !this.c.get()) {
            this.f4195a.start();
            this.b = new Handler(this.f4195a.getLooper(), this.f4195a);
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 5;
            this.b.sendMessage(obtainMessage);
            this.c.set(true);
        }
    }

    public void b() {
        this.c.set(false);
        this.f4195a.quit();
        this.b.removeCallbacksAndMessages(null);
    }

    public void a(@NonNull T t) {
        if (this.c.get()) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.b.sendMessage(obtainMessage);
        }
    }

    public static a c() {
        return a.e();
    }

    public static C1010b d() {
        return C1010b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f4196a;

        public static a e() {
            if (f4196a == null) {
                synchronized (a.class) {
                    if (f4196a == null) {
                        f4196a = new a();
                    }
                }
            }
            return f4196a;
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
    /* loaded from: classes6.dex */
    public static class C1010b extends b<c.a> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile C1010b f4197a;

        public static C1010b e() {
            if (f4197a == null) {
                synchronized (C1010b.class) {
                    if (f4197a == null) {
                        f4197a = new C1010b();
                    }
                }
            }
            return f4197a;
        }

        C1010b() {
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
