package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f5793a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static String f5794b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        if (f5793a.compareAndSet(false, true)) {
            f5794b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(f5794b)) {
                f5794b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f5794b).apply();
            }
        }
        return f5794b;
    }
}
