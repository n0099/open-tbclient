package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class bc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException e) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f5796a;

        /* renamed from: b  reason: collision with root package name */
        private final String f5797b;
        private final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        a(Runnable runnable, String str) {
            this.f5796a = runnable;
            this.f5797b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5796a.run();
            } catch (Exception e) {
                e.printStackTrace();
                bb.b("TrackerDr", "Thread:" + this.f5797b + " exception\n" + this.c, e);
            }
        }
    }
}
