package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
final class bc {
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

    /* loaded from: classes4.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f6096a;

        /* renamed from: b  reason: collision with root package name */
        private final String f6097b;
        private final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        a(Runnable runnable, String str) {
            this.f6096a = runnable;
            this.f6097b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6096a.run();
            } catch (Exception e) {
                e.printStackTrace();
                bb.b("TrackerDr", "Thread:" + this.f6097b + " exception\n" + this.c, e);
            }
        }
    }
}
