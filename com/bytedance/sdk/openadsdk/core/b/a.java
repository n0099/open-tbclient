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
    public static volatile a f28041a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f28042b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f28043c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f28045e;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0305a> f28044d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public final h f28046f = p.h();

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0305a {

        /* renamed from: a  reason: collision with root package name */
        public final long f28048a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28049b;

        public C0305a(long j, String str) {
            this.f28048a = j;
            this.f28049b = str;
        }
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f28046f.k();
        long j = this.f28046f.j();
        if (this.f28044d.size() > 0 && this.f28044d.size() >= k) {
            long abs = Math.abs(currentTimeMillis - this.f28044d.peek().f28048a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.f28044d.poll();
            this.f28044d.offer(new C0305a(currentTimeMillis, str));
        } else {
            this.f28044d.offer(new C0305a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0305a c0305a : this.f28044d) {
            if (hashMap.containsKey(c0305a.f28049b)) {
                hashMap.put(c0305a.f28049b, Integer.valueOf(((Integer) hashMap.get(c0305a.f28049b)).intValue() + 1));
            } else {
                hashMap.put(c0305a.f28049b, 1);
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
        if (f28041a == null) {
            synchronized (a.class) {
                if (f28041a == null) {
                    f28041a = new a();
                }
            }
        }
        return f28041a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f28043c);
        } else {
            a(false);
        }
        return f28042b;
    }

    private synchronized void a(long j) {
        if (this.f28045e == null) {
            this.f28045e = new Handler(Looper.getMainLooper());
        }
        this.f28045e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f28042b;
    }

    private synchronized void b(long j) {
        f28043c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f28042b = z;
    }
}
