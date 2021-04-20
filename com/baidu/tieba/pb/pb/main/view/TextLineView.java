package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.c.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes3.dex */
public class TextLineView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19540e;

    /* renamed from: f  reason: collision with root package name */
    public int f19541f;

    /* renamed from: g  reason: collision with root package name */
    public int f19542g;

    /* renamed from: h  reason: collision with root package name */
    public int f19543h;
    public int i;
    public int j;
    public RectF k;
    public int l;
    public int m;
    public int n;
    public int o;

    public TextLineView(Context context) {
        super(context);
    }

    private void setTextSelectedUI(boolean z) {
        if (z) {
            c d2 = c.d(this);
            d2.q(R.color.CAM_X0105);
            d2.v(R.string.F_X02);
            return;
        }
        c d3 = c.d(this);
        d3.q(R.color.CAM_X0108);
        d3.v(R.string.F_X01);
    }

    public final void a() {
        if (this.f19540e == null) {
            this.f19540e = new Paint();
        }
        this.f19540e.setAntiAlias(true);
        this.f19540e.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.f19540e.setColor(SkinManager.getColor(R.color.transparent));
        } else {
            this.f19540e.setColor(SkinManager.getColor(R.color.transparent));
        }
    }

    public void b(int i) {
        setTextSelectedUI(isSelected());
        a();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a();
        if (this.k == null) {
            this.k = new RectF();
        }
        RectF rectF = this.k;
        int i = this.n;
        int i2 = this.m;
        int i3 = this.f19543h;
        rectF.set(i + 0, (i2 - i3) - this.f19541f, this.l - i, i2 - i3);
        RectF rectF2 = this.k;
        int i4 = this.o;
        canvas.drawRoundRect(rectF2, i4, i4, this.f19540e);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = i;
        this.m = i2;
        this.n = (i - this.j) / 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        setTextSelectedUI(z);
        invalidate();
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextLineView);
        this.f19541f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_height, 0);
        this.f19542g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_top_margin, 0);
        this.f19543h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.i = obtainStyledAttributes.getColor(R$styleable.TextLineView_text_selected_color, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(R$styleable.TextLineView_text_unselected_color, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f19542g + this.f19541f + this.f19543h);
        setTextColor(this.i);
        this.j = l.g(context, R.dimen.ds56);
        this.k = new RectF();
        this.o = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }
}
