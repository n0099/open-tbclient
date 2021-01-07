package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static String f6347b = "VNetLog";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6346a = Log.isLoggable(f6347b, 2);

    public static void a(String str, Object... objArr) {
        if (f6346a) {
            Log.v(f6347b, k(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f6347b, k(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f6347b, k(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f6347b, k(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f6347b, k(str, objArr));
    }

    private static String k(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (stackTrace[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                i++;
            } else {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f6348a = r.f6346a;

        /* renamed from: b  reason: collision with root package name */
        private final List<C1011a> f6349b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.adnet.core.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1011a {

            /* renamed from: a  reason: collision with root package name */
            public final String f6350a;

            /* renamed from: b  reason: collision with root package name */
            public final long f6351b;
            public final long c;

            public C1011a(String str, long j, long j2) {
                this.f6350a = str;
                this.f6351b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6349b.add(new C1011a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.f6349b.get(0).c;
                r.b("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C1011a c1011a : this.f6349b) {
                    long j3 = c1011a.c;
                    r.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c1011a.f6351b), c1011a.f6350a);
                    j2 = j3;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.c) {
                a("Request on the loose");
                r.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.f6349b.size() == 0) {
                return 0L;
            }
            return this.f6349b.get(this.f6349b.size() - 1).c - this.f6349b.get(0).c;
        }
    }
}
