package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6842a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f6843b = new HashSet(1);
    private Looper c = Looper.getMainLooper();

    public abstract void a();

    public abstract void a(String str);

    public synchronized boolean b(String str) {
        Log.d(f6842a, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean a(@NonNull String str, int i) {
        return i == 0 ? a(str, c.GRANTED) : a(str, c.DENIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final synchronized boolean a(@NonNull final String str, c cVar) {
        boolean z = true;
        synchronized (this) {
            this.f6843b.remove(str);
            switch (cVar) {
                case GRANTED:
                    if (this.f6843b.isEmpty()) {
                        new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a();
                            }
                        });
                        break;
                    }
                    z = false;
                    break;
                case DENIED:
                    new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    break;
                case NOT_FOUND:
                    if (b(str)) {
                        if (this.f6843b.isEmpty()) {
                            new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.a();
                                }
                            });
                            break;
                        }
                        z = false;
                        break;
                    } else {
                        new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.4
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a(str);
                            }
                        });
                        break;
                    }
                default:
                    z = false;
                    break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(@NonNull String[] strArr) {
        Collections.addAll(this.f6843b, strArr);
    }
}
