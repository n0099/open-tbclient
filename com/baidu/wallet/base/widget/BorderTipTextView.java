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
    public int f23418a;

    /* renamed from: b  reason: collision with root package name */
    public int f23419b;

    /* renamed from: c  reason: collision with root package name */
    public int f23420c;

    /* renamed from: d  reason: collision with root package name */
    public int f23421d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f23422e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23423f;

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23418a = getPaddingLeft();
        this.f23419b = getPaddingRight();
        this.f23420c = getPaddingTop();
        this.f23421d = getPaddingBottom();
        this.f23422e = getTextColors();
        this.f23423f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f23423f);
        setTextColor(this.f23422e);
        setText(charSequence);
        setPadding(this.f23418a, this.f23420c, this.f23419b, this.f23421d);
    }
}
