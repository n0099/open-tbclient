package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g;
/* loaded from: classes5.dex */
public class f extends g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f28028a;

    public f(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g
    public /* bridge */ /* synthetic */ g.c a() {
        return super.a();
    }

    public static f a(Context context) {
        if (f28028a == null) {
            synchronized (f.class) {
                if (f28028a == null) {
                    f28028a = new f(context);
                }
            }
        }
        return f28028a;
    }
}
