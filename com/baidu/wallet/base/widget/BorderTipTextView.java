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
    public int f23347a;

    /* renamed from: b  reason: collision with root package name */
    public int f23348b;

    /* renamed from: c  reason: collision with root package name */
    public int f23349c;

    /* renamed from: d  reason: collision with root package name */
    public int f23350d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23351e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23352f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23347a = getPaddingLeft();
        this.f23348b = getPaddingRight();
        this.f23349c = getPaddingTop();
        this.f23350d = getPaddingBottom();
        this.f23351e = getTextColors();
        this.f23352f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23352f);
        setTextColor(this.f23351e);
        setText(charSequence);
        setPadding(this.f23347a, this.f23349c, this.f23348b, this.f23350d);
    }
}
