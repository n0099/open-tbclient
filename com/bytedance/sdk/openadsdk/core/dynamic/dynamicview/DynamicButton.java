package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public int p;
    public int q;

    public DynamicButton(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    private void f() {
        this.p = ((this.f28305f - ((int) al.a(this.i, this.j.e()))) / 2) - this.j.a();
        this.q = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 17) {
            this.n.setTextAlignment(this.j.h());
        }
        ((TextView) this.n).setText(this.j.i());
        ((TextView) this.n).setTextColor(this.j.g());
        ((TextView) this.n).setTextSize(this.j.e());
        if (Build.VERSION.SDK_INT >= 16) {
            this.n.setBackground(getBackgroundDrawable());
        }
        ((TextView) this.n).setGravity(17);
        ((TextView) this.n).setIncludeFontPadding(false);
        f();
        this.n.setPadding(this.j.c(), this.p, this.j.d(), this.q);
        return true;
    }
}
