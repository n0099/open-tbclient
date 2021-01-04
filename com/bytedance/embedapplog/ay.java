package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f6090a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static String f6091b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        if (f6090a.compareAndSet(false, true)) {
            f6091b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(f6091b)) {
                f6091b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f6091b).apply();
            }
        }
        return f6091b;
    }
}
