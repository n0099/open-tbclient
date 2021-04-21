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
    public int f23447a;

    /* renamed from: b  reason: collision with root package name */
    public int f23448b;

    /* renamed from: c  reason: collision with root package name */
    public int f23449c;

    /* renamed from: d  reason: collision with root package name */
    public int f23450d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23451e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23452f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23447a = getPaddingLeft();
        this.f23448b = getPaddingRight();
        this.f23449c = getPaddingTop();
        this.f23450d = getPaddingBottom();
        this.f23451e = getTextColors();
        this.f23452f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23452f);
        setTextColor(this.f23451e);
        setText(charSequence);
        setPadding(this.f23447a, this.f23449c, this.f23448b, this.f23450d);
    }
}
