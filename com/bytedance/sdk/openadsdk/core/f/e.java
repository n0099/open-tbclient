package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28257a = "e";

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f28258b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    public Looper f28259c = Looper.getMainLooper();

    /* renamed from: com.bytedance.sdk.openadsdk.core.f.e$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28266a;

        static {
            int[] iArr = new int[c.values().length];
            f28266a = iArr;
            try {
                iArr[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28266a[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28266a[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void a();

    public abstract void a(String str);

    public final synchronized boolean a(@NonNull String str, int i2) {
        if (i2 == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    public synchronized boolean b(String str) {
        String str2 = f28257a;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    public final synchronized boolean a(@NonNull final String str, c cVar) {
        this.f28258b.remove(str);
        int i2 = AnonymousClass5.f28266a[cVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                new Handler(this.f28259c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            } else if (i2 == 3) {
                if (b(str)) {
                    if (this.f28258b.isEmpty()) {
                        new Handler(this.f28259c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.3
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.f28259c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.4
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.f28258b.isEmpty()) {
            new Handler(this.f28259c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.a();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void a(@NonNull String[] strArr) {
        Collections.addAll(this.f28258b, strArr);
    }
}
