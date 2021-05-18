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
    public static volatile a f27819a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27820b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27821c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27823e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0289a> f27822d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27824f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0289a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27826a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27827b;

        public C0289a(long j, String str) {
            this.f27826a = j;
            this.f27827b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27824f.k();
        long j = this.f27824f.j();
        if (this.f27822d.size() > 0 && this.f27822d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27822d.peek().f27826a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27822d.poll();
            this.f27822d.offer(new C0289a(currentTimeMillis, str));
        } else {
            this.f27822d.offer(new C0289a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0289a c0289a : this.f27822d) {
            if (hashMap.containsKey(c0289a.f27827b)) {
                hashMap.put(c0289a.f27827b, Integer.valueOf(((Integer) hashMap.get(c0289a.f27827b)).intValue() + 1));
            } else {
                hashMap.put(c0289a.f27827b, 1);
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
        if (f27819a == null) {
            synchronized (a.class) {
                if (f27819a == null) {
                    f27819a = new a();
                }
            }
        }
        return f27819a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27821c);
        } else {
            a(false);
        }
        return f27820b;
    }

    private synchronized void a(long j) {
        if (this.f27823e == null) {
            this.f27823e = new Handler(Looper.getMainLooper());
        }
        this.f27823e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27820b;
    }

    private synchronized void b(long j) {
        f27821c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27820b = z;
    }
}
