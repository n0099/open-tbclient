package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
final class bc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@Nullable String str, Runnable runnable) {
        if (runnable != null) {
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new a(runnable, str), str).start();
        }
    }

    /* loaded from: classes6.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f3913a;
        private final String b;
        private final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        a(Runnable runnable, String str) {
            this.f3913a = runnable;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3913a.run();
            } catch (Exception e) {
                e.printStackTrace();
                bb.b("TrackerDr", "Thread:" + this.b + " exception\n" + this.c, e);
            }
        }
    }
}
