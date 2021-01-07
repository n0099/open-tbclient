package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g;
/* loaded from: classes4.dex */
public class f extends g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f6836a;

    @Override // com.bytedance.sdk.openadsdk.core.g
    public /* bridge */ /* synthetic */ g.c a() {
        return super.a();
    }

    public static f a(Context context) {
        if (f6836a == null) {
            synchronized (f.class) {
                if (f6836a == null) {
                    f6836a = new f(context);
                }
            }
        }
        return f6836a;
    }

    private f(Context context) {
        super(context);
    }
}
