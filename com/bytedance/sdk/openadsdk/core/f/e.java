package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28032a = "e";

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f28033b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    public Looper f28034c = Looper.getMainLooper();

    /* renamed from: com.bytedance.sdk.openadsdk.core.f.e$5  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28041a;

        static {
            int[] iArr = new int[c.values().length];
            f28041a = iArr;
            try {
                iArr[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28041a[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28041a[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void a();

    public abstract void a(String str);

    public final synchronized boolean a(@NonNull String str, int i) {
        if (i == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    public synchronized boolean b(String str) {
        String str2 = f28032a;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    public final synchronized boolean a(@NonNull final String str, c cVar) {
        this.f28033b.remove(str);
        int i = AnonymousClass5.f28041a[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.f28034c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            } else if (i == 3) {
                if (b(str)) {
                    if (this.f28033b.isEmpty()) {
                        new Handler(this.f28034c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.3
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.f28034c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.4
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.f28033b.isEmpty()) {
            new Handler(this.f28034c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.1
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
        Collections.addAll(this.f28033b, strArr);
    }
}
