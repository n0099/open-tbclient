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
    private static volatile a f4359a;
    private static volatile boolean b;
    private static volatile long c;
    private Handler e;
    private final Queue<C1017a> d = new LinkedList();
    private final h f = p.h();

    private a() {
    }

    public static a a() {
        if (f4359a == null) {
            synchronized (a.class) {
                if (f4359a == null) {
                    f4359a = new a();
                }
            }
        }
        return f4359a;
    }

    private synchronized boolean b(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f.k();
        long j = this.f.j();
        if (this.d.size() > 0 && this.d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.d.peek().f4361a);
            if (abs <= j) {
                b(j - abs);
                z = true;
            } else {
                this.d.poll();
                this.d.offer(new C1017a(currentTimeMillis, str));
            }
        } else {
            this.d.offer(new C1017a(currentTimeMillis, str));
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
        return b;
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
        b = z;
    }

    public synchronized boolean b() {
        return b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C1017a c1017a : this.d) {
            if (hashMap.containsKey(c1017a.b)) {
                hashMap.put(c1017a.b, Integer.valueOf(((Integer) hashMap.get(c1017a.b)).intValue() + 1));
            } else {
                hashMap.put(c1017a.b, 1);
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
    public static class C1017a {

        /* renamed from: a  reason: collision with root package name */
        private final long f4361a;
        private final String b;

        private C1017a(long j, String str) {
            this.f4361a = j;
            this.b = str;
        }
    }
}
