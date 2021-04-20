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
    public static volatile a f27726a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f27727b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f27728c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27730e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0307a> f27729d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f27731f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0307a {

        /* renamed from: a  reason: collision with root package name */
        public final long f27733a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27734b;

        public C0307a(long j, String str) {
            this.f27733a = j;
            this.f27734b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f27731f.k();
        long j = this.f27731f.j();
        if (this.f27729d.size() > 0 && this.f27729d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f27729d.peek().f27733a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f27729d.poll();
            this.f27729d.offer(new C0307a(currentTimeMillis, str));
        } else {
            this.f27729d.offer(new C0307a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0307a c0307a : this.f27729d) {
            if (hashMap.containsKey(c0307a.f27734b)) {
                hashMap.put(c0307a.f27734b, Integer.valueOf(((Integer) hashMap.get(c0307a.f27734b)).intValue() + 1));
            } else {
                hashMap.put(c0307a.f27734b, 1);
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
        if (f27726a == null) {
            synchronized (a.class) {
                if (f27726a == null) {
                    f27726a = new a();
                }
            }
        }
        return f27726a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f27728c);
        } else {
            a(false);
        }
        return f27727b;
    }

    private synchronized void a(long j) {
        if (this.f27730e == null) {
            this.f27730e = new Handler(Looper.getMainLooper());
        }
        this.f27730e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f27727b;
    }

    private synchronized void b(long j) {
        f27728c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f27727b = z;
    }
}
