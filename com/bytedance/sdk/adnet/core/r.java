package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static String f6047b = "VNetLog";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6046a = Log.isLoggable(f6047b, 2);

    public static void a(String str, Object... objArr) {
        if (f6046a) {
            Log.v(f6047b, k(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f6047b, k(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f6047b, k(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f6047b, k(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f6047b, k(str, objArr));
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
        public static final boolean f6048a = r.f6046a;

        /* renamed from: b  reason: collision with root package name */
        private final List<C0994a> f6049b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.adnet.core.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0994a {

            /* renamed from: a  reason: collision with root package name */
            public final String f6050a;

            /* renamed from: b  reason: collision with root package name */
            public final long f6051b;
            public final long c;

            public C0994a(String str, long j, long j2) {
                this.f6050a = str;
                this.f6051b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6049b.add(new C0994a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.f6049b.get(0).c;
                r.b("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C0994a c0994a : this.f6049b) {
                    long j3 = c0994a.c;
                    r.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0994a.f6051b), c0994a.f6050a);
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
            if (this.f6049b.size() == 0) {
                return 0L;
            }
            return this.f6049b.get(this.f6049b.size() - 1).c - this.f6049b.get(0).c;
        }
    }
}
