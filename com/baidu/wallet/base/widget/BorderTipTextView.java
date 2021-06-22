package com.baidu.wallet.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class BorderTipTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public int f23532a;

    /* renamed from: b  reason: collision with root package name */
    public int f23533b;

    /* renamed from: c  reason: collision with root package name */
    public int f23534c;

    /* renamed from: d  reason: collision with root package name */
    public int f23535d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23536e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23537f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23532a = getPaddingLeft();
        this.f23533b = getPaddingRight();
        this.f23534c = getPaddingTop();
        this.f23535d = getPaddingBottom();
        this.f23536e = getTextColors();
        this.f23537f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23537f);
        setTextColor(this.f23536e);
        setText(charSequence);
        setPadding(this.f23532a, this.f23534c, this.f23533b, this.f23535d);
    }
}
