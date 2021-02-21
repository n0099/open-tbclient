package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class bl {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f5806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public bl(Context context) {
        this.f5806a = context.getSharedPreferences("device_register_oaid_refine", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public void a(@Nullable bk bkVar) {
        if (bkVar != null) {
            this.f5806a.edit().putString("oaid", bkVar.b().toString()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public bk eob() {
        return bk.YK(this.f5806a.getString("oaid", ""));
    }
}
