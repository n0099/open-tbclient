package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f6091a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static String f6092b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        if (f6091a.compareAndSet(false, true)) {
            f6092b = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(f6092b)) {
                f6092b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f6092b).apply();
            }
        }
        return f6092b;
    }
}
