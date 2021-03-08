package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
/* loaded from: classes6.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp {
    public DynamicVideoView(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        super.b();
        this.m.a(this.f4420a, this.b, this.c, this.d);
        return true;
    }
}
