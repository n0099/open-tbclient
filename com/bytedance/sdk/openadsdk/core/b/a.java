package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6749a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f6750b;
    private static volatile long c;
    private Handler e;
    private final Queue<C1019a> d = new LinkedList();
    private final l f = p.h();

    private a() {
    }

    public static a a() {
        if (f6749a == null) {
            synchronized (a.class) {
                if (f6749a == null) {
                    f6749a = new a();
                }
            }
        }
        return f6749a;
    }

    private synchronized boolean b(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int l = this.f.l();
        long k = this.f.k();
        if (this.d.size() > 0 && this.d.size() >= l) {
            long abs = Math.abs(currentTimeMillis - this.d.peek().f6752a);
            if (abs <= k) {
                b(k - abs);
                z = true;
            } else {
                this.d.poll();
                this.d.offer(new C1019a(currentTimeMillis, str));
            }
        } else {
            this.d.offer(new C1019a(currentTimeMillis, str));
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
        return f6750b;
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
        f6750b = z;
    }

    public synchronized boolean b() {
        return f6750b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C1019a c1019a : this.d) {
            if (hashMap.containsKey(c1019a.f6753b)) {
                hashMap.put(c1019a.f6753b, Integer.valueOf(((Integer) hashMap.get(c1019a.f6753b)).intValue() + 1));
            } else {
                hashMap.put(c1019a.f6753b, 1);
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
    /* loaded from: classes4.dex */
    public static class C1019a {

        /* renamed from: a  reason: collision with root package name */
        private final long f6752a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6753b;

        private C1019a(long j, String str) {
            this.f6752a = j;
            this.f6753b = str;
        }
    }
}
