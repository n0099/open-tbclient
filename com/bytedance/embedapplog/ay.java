package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f5791a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static String f5792b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        if (f5791a.compareAndSet(false, true)) {
            f5792b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(f5792b)) {
                f5792b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f5792b).apply();
            }
        }
        return f5792b;
    }
}
