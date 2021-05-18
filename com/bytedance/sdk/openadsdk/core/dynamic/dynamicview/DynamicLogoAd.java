package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
/* loaded from: classes6.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 17) {
            this.n.setTextAlignment(this.j.h());
        }
        ((TextView) this.n).setText("广告");
        ((TextView) this.n).setTextColor(this.j.g());
        ((TextView) this.n).setTextSize(this.j.e());
        return true;
    }
}
