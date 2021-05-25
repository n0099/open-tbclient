package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f27748a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27749b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27750c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27752e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0290a> f27751d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27753f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0290a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27755a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27756b;

        public C0290a(long j, String str) {
            this.f27755a = j;
            this.f27756b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27753f.k();
        long j = this.f27753f.j();
        if (this.f27751d.size() > 0 && this.f27751d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27751d.peek().f27755a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27751d.poll();
            this.f27751d.offer(new C0290a(currentTimeMillis, str));
        } else {
            this.f27751d.offer(new C0290a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0290a c0290a : this.f27751d) {
            if (hashMap.containsKey(c0290a.f27756b)) {
                hashMap.put(c0290a.f27756b, Integer.valueOf(((Integer) hashMap.get(c0290a.f27756b)).intValue() + 1));
            } else {
                hashMap.put(c0290a.f27756b, 1);
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
        if (f27748a == null) {
            synchronized (a.class) {
                if (f27748a == null) {
                    f27748a = new a();
                }
            }
        }
        return f27748a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27750c);
        } else {
            a(false);
        }
        return f27749b;
    }

    private synchronized void a(long j) {
        if (this.f27752e == null) {
            this.f27752e = new Handler(Looper.getMainLooper());
        }
        this.f27752e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27749b;
    }

    private synchronized void b(long j) {
        f27750c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27749b = z;
    }
}
