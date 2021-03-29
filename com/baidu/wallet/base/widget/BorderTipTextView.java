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
    public int f23754a;

    /* renamed from: b  reason: collision with root package name */
    public int f23755b;

    /* renamed from: c  reason: collision with root package name */
    public int f23756c;

    /* renamed from: d  reason: collision with root package name */
    public int f23757d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23758e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23759f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23754a = getPaddingLeft();
        this.f23755b = getPaddingRight();
        this.f23756c = getPaddingTop();
        this.f23757d = getPaddingBottom();
        this.f23758e = getTextColors();
        this.f23759f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23759f);
        setTextColor(this.f23758e);
        setText(charSequence);
        setPadding(this.f23754a, this.f23756c, this.f23755b, this.f23757d);
    }
}
