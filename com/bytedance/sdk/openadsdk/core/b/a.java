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
    public static volatile a f27734a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27735b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27736c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27738e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0309a> f27737d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27739f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0309a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27741a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27742b;

        public C0309a(long j, String str) {
            this.f27741a = j;
            this.f27742b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27739f.k();
        long j = this.f27739f.j();
        if (this.f27737d.size() > 0 && this.f27737d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27737d.peek().f27741a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27737d.poll();
            this.f27737d.offer(new C0309a(currentTimeMillis, str));
        } else {
            this.f27737d.offer(new C0309a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0309a c0309a : this.f27737d) {
            if (hashMap.containsKey(c0309a.f27742b)) {
                hashMap.put(c0309a.f27742b, Integer.valueOf(((Integer) hashMap.get(c0309a.f27742b)).intValue() + 1));
            } else {
                hashMap.put(c0309a.f27742b, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    public static a a() {
        if (f27734a == null) {
            synchronized (a.class) {
                if (f27734a == null) {
                    f27734a = new a();
                }
            }
        }
        return f27734a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27736c);
        } else {
            a(false);
        }
        return f27735b;
    }

    private synchronized void a(long j) {
        if (this.f27738e == null) {
            this.f27738e = new Handler(Looper.getMainLooper());
        }
        this.f27738e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27735b;
    }

    private synchronized void b(long j) {
        f27736c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27735b = z;
    }
}
