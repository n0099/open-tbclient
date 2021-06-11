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
    public static volatile a f27851a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27852b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27853c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27855e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0292a> f27854d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27856f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0292a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27858a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27859b;

        public C0292a(long j, String str) {
            this.f27858a = j;
            this.f27859b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27856f.k();
        long j = this.f27856f.j();
        if (this.f27854d.size() > 0 && this.f27854d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27854d.peek().f27858a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27854d.poll();
            this.f27854d.offer(new C0292a(currentTimeMillis, str));
        } else {
            this.f27854d.offer(new C0292a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0292a c0292a : this.f27854d) {
            if (hashMap.containsKey(c0292a.f27859b)) {
                hashMap.put(c0292a.f27859b, Integer.valueOf(((Integer) hashMap.get(c0292a.f27859b)).intValue() + 1));
            } else {
                hashMap.put(c0292a.f27859b, 1);
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
        if (f27851a == null) {
            synchronized (a.class) {
                if (f27851a == null) {
                    f27851a = new a();
                }
            }
        }
        return f27851a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27853c);
        } else {
            a(false);
        }
        return f27852b;
    }

    private synchronized void a(long j) {
        if (this.f27855e == null) {
            this.f27855e = new Handler(Looper.getMainLooper());
        }
        this.f27855e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27852b;
    }

    private synchronized void b(long j) {
        f27853c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27852b = z;
    }
}
