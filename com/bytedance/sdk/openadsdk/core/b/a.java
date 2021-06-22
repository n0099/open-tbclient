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
    public static volatile a f27933a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27934b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27935c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27937e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0295a> f27936d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27938f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0295a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27940a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27941b;

        public C0295a(long j, String str) {
            this.f27940a = j;
            this.f27941b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27938f.k();
        long j = this.f27938f.j();
        if (this.f27936d.size() > 0 && this.f27936d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27936d.peek().f27940a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27936d.poll();
            this.f27936d.offer(new C0295a(currentTimeMillis, str));
        } else {
            this.f27936d.offer(new C0295a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0295a c0295a : this.f27936d) {
            if (hashMap.containsKey(c0295a.f27941b)) {
                hashMap.put(c0295a.f27941b, Integer.valueOf(((Integer) hashMap.get(c0295a.f27941b)).intValue() + 1));
            } else {
                hashMap.put(c0295a.f27941b, 1);
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
        if (f27933a == null) {
            synchronized (a.class) {
                if (f27933a == null) {
                    f27933a = new a();
                }
            }
        }
        return f27933a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27935c);
        } else {
            a(false);
        }
        return f27934b;
    }

    private synchronized void a(long j) {
        if (this.f27937e == null) {
            this.f27937e = new Handler(Looper.getMainLooper());
        }
        this.f27937e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27934b;
    }

    private synchronized void b(long j) {
        f27935c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27934b = z;
    }
}
