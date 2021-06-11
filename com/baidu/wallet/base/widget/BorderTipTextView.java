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
    public int f23450a;

    /* renamed from: b  reason: collision with root package name */
    public int f23451b;

    /* renamed from: c  reason: collision with root package name */
    public int f23452c;

    /* renamed from: d  reason: collision with root package name */
    public int f23453d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23454e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23455f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23450a = getPaddingLeft();
        this.f23451b = getPaddingRight();
        this.f23452c = getPaddingTop();
        this.f23453d = getPaddingBottom();
        this.f23454e = getTextColors();
        this.f23455f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23455f);
        setTextColor(this.f23454e);
        setText(charSequence);
        setPadding(this.f23450a, this.f23452c, this.f23451b, this.f23453d);
    }
}
