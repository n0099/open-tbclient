package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g;
/* loaded from: classes6.dex */
public class f extends g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f28245a;

    public f(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public /* bridge */ /* synthetic */ g.c a() {
        return super.a();
    }

    public static f a(Context context) {
        if (f28245a == null) {
            synchronized (f.class) {
                if (f28245a == null) {
                    f28245a = new f(context);
                }
            }
        }
        return f28245a;
    }
}
