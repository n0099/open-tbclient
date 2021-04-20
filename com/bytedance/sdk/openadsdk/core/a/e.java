package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes5.dex */
public abstract class e extends a {
    public e(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        a_(view, i, i2, i3, i4);
        super.a(view, i, i2, i3, i4);
    }

    public abstract void a_(View view, int i, int i2, int i3, int i4);
}
