package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static String f6346b = "VNetLog";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6345a = Log.isLoggable(f6346b, 2);

    public static void a(String str, Object... objArr) {
        if (f6345a) {
            Log.v(f6346b, k(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f6346b, k(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f6346b, k(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f6346b, k(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f6346b, k(str, objArr));
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
        public static final boolean f6347a = r.f6345a;

        /* renamed from: b  reason: collision with root package name */
        private final List<C0973a> f6348b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.adnet.core.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0973a {

            /* renamed from: a  reason: collision with root package name */
            public final String f6349a;

            /* renamed from: b  reason: collision with root package name */
            public final long f6350b;
            public final long c;

            public C0973a(String str, long j, long j2) {
                this.f6349a = str;
                this.f6350b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6348b.add(new C0973a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.f6348b.get(0).c;
                r.b("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C0973a c0973a : this.f6348b) {
                    long j3 = c0973a.c;
                    r.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0973a.f6350b), c0973a.f6349a);
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
            if (this.f6348b.size() == 0) {
                return 0L;
            }
            return this.f6348b.get(this.f6348b.size() - 1).c - this.f6348b.get(0).c;
        }
    }
}
