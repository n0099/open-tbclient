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
    public int f23753a;

    /* renamed from: b  reason: collision with root package name */
    public int f23754b;

    /* renamed from: c  reason: collision with root package name */
    public int f23755c;

    /* renamed from: d  reason: collision with root package name */
    public int f23756d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23757e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23758f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23753a = getPaddingLeft();
        this.f23754b = getPaddingRight();
        this.f23755c = getPaddingTop();
        this.f23756d = getPaddingBottom();
        this.f23757e = getTextColors();
        this.f23758f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23758f);
        setTextColor(this.f23757e);
        setText(charSequence);
        setPadding(this.f23753a, this.f23755c, this.f23754b, this.f23756d);
    }
}
