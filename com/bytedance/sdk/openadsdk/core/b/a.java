package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f28574a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f28575b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f28576c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f28578e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0302a> f28577d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f28579f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0302a {

        /* renamed from: a  reason: collision with root package name */
        public final long f28581a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28582b;

        public C0302a(long j, String str) {
            this.f28581a = j;
            this.f28582b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f28579f.k();
        long j = this.f28579f.j();
        if (this.f28577d.size() > 0 && this.f28577d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f28577d.peek().f28581a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f28577d.poll();
            this.f28577d.offer(new C0302a(currentTimeMillis, str));
        } else {
            this.f28577d.offer(new C0302a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0302a c0302a : this.f28577d) {
            if (hashMap.containsKey(c0302a.f28582b)) {
                hashMap.put(c0302a.f28582b, Integer.valueOf(((Integer) hashMap.get(c0302a.f28582b)).intValue() + 1));
            } else {
                hashMap.put(c0302a.f28582b, 1);
            }
        }
        int i2 = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i2 < intValue) {
                str = str2;
                i2 = intValue;
            }
        }
        return str;
    }

    public static a a() {
        if (f28574a == null) {
            synchronized (a.class) {
                if (f28574a == null) {
                    f28574a = new a();
                }
            }
        }
        return f28574a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f28576c);
        } else {
            a(false);
        }
        return f28575b;
    }

    private synchronized void a(long j) {
        if (this.f28578e == null) {
            this.f28578e = new Handler(Looper.getMainLooper());
        }
        this.f28578e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f28575b;
    }

    private synchronized void b(long j) {
        f28576c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f28575b = z;
    }
}
