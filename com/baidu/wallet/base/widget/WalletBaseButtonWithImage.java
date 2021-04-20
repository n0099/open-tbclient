package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class WalletBaseButtonWithImage extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f23659a;

    public WalletBaseButtonWithImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_widget_button_with_image"), this);
        Drawable drawable = ResUtils.getDrawable(getContext(), "wallet_base_blue_397be6_btn");
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        this.f23659a = (TextView) findViewById(ResUtils.id(context, "wallet_base_btn_image"));
        a();
    }

    private void a() {
        Drawable drawable = ResUtils.getDrawable(getContext(), "wallet_base_cashdesk_order_btn_img_selector");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f23659a.setCompoundDrawables(drawable, null, null, null);
    }

    public void setDrawableLeftVisible(boolean z) {
        if (z) {
            a();
        } else {
            this.f23659a.setCompoundDrawables(null, null, null, null);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f23659a.setText(charSequence);
    }
}
