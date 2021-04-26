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
    public int f24173a;

    /* renamed from: b  reason: collision with root package name */
    public int f24174b;

    /* renamed from: c  reason: collision with root package name */
    public int f24175c;

    /* renamed from: d  reason: collision with root package name */
    public int f24176d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f24177e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f24178f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24173a = getPaddingLeft();
        this.f24174b = getPaddingRight();
        this.f24175c = getPaddingTop();
        this.f24176d = getPaddingBottom();
        this.f24177e = getTextColors();
        this.f24178f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f24178f);
        setTextColor(this.f24177e);
        setText(charSequence);
        setPadding(this.f24173a, this.f24175c, this.f24174b, this.f24176d);
    }
}
