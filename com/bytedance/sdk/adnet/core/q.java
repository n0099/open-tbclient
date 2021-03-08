package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class q {
    private static String b = "VNetLog";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4050a = Log.isLoggable(b, 2);

    public static void a(String str, Object... objArr) {
        if (f4050a) {
            Log.v(b, k(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(b, k(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(b, k(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(b, k(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(b, k(str, objArr));
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
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f4051a = q.f4050a;
        private final List<C1008a> b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.adnet.core.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1008a {

            /* renamed from: a  reason: collision with root package name */
            public final String f4052a;
            public final long b;
            public final long c;

            public C1008a(String str, long j, long j2) {
                this.f4052a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new C1008a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.b.get(0).c;
                q.b("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C1008a c1008a : this.b) {
                    long j3 = c1008a.c;
                    q.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c1008a.b), c1008a.f4052a);
                    j2 = j3;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.c) {
                a("Request on the loose");
                q.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            return this.b.get(this.b.size() - 1).c - this.b.get(0).c;
        }
    }
}
