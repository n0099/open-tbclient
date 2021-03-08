package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f3910a = new AtomicBoolean(false);
    private static String b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        if (f3910a.compareAndSet(false, true)) {
            b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(b)) {
                b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", b).apply();
            }
        }
        return b;
    }
}
