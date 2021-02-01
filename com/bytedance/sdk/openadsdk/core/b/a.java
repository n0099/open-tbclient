package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6451a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f6452b;
    private static volatile long c;
    private Handler e;
    private final Queue<C1006a> d = new LinkedList();
    private final l f = p.h();

    private a() {
    }

    public static a a() {
        if (f6451a == null) {
            synchronized (a.class) {
                if (f6451a == null) {
                    f6451a = new a();
                }
            }
        }
        return f6451a;
    }

    private synchronized boolean b(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int l = this.f.l();
        long k = this.f.k();
        if (this.d.size() > 0 && this.d.size() >= l) {
            long abs = Math.abs(currentTimeMillis - this.d.peek().f6454a);
            if (abs <= k) {
                b(k - abs);
                z = true;
            } else {
                this.d.poll();
                this.d.offer(new C1006a(currentTimeMillis, str));
            }
        } else {
            this.d.offer(new C1006a(currentTimeMillis, str));
        }
        z = false;
        return z;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(c);
        } else {
            a(false);
        }
        return f6452b;
    }

    private synchronized void a(long j) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f6452b = z;
    }

    public synchronized boolean b() {
        return f6452b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C1006a c1006a : this.d) {
            if (hashMap.containsKey(c1006a.f6455b)) {
                hashMap.put(c1006a.f6455b, Integer.valueOf(((Integer) hashMap.get(c1006a.f6455b)).intValue() + 1));
            } else {
                hashMap.put(c1006a.f6455b, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1006a {

        /* renamed from: a  reason: collision with root package name */
        private final long f6454a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6455b;

        private C1006a(long j, String str) {
            this.f6454a = j;
            this.f6455b = str;
        }
    }
}
