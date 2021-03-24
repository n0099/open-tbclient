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
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19854e;

    /* renamed from: f  reason: collision with root package name */
    public int f19855f;

    /* renamed from: g  reason: collision with root package name */
    public int f19856g;

    /* renamed from: h  reason: collision with root package name */
    public int f19857h;
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
            c a2 = c.a(this);
            a2.n(R.color.CAM_X0105);
            a2.s(R.string.F_X02);
            return;
        }
        c a3 = c.a(this);
        a3.n(R.color.CAM_X0108);
        a3.s(R.string.F_X01);
    }

    public final void a() {
        if (this.f19854e == null) {
            this.f19854e = new Paint();
        }
        this.f19854e.setAntiAlias(true);
        this.f19854e.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.f19854e.setColor(SkinManager.getColor(R.color.transparent));
        } else {
            this.f19854e.setColor(SkinManager.getColor(R.color.transparent));
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
        int i3 = this.f19857h;
        rectF.set(i + 0, (i2 - i3) - this.f19855f, this.l - i, i2 - i3);
        RectF rectF2 = this.k;
        int i4 = this.o;
        canvas.drawRoundRect(rectF2, i4, i4, this.f19854e);
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
        this.f19855f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_height, 0);
        this.f19856g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_top_margin, 0);
        this.f19857h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.i = obtainStyledAttributes.getColor(R$styleable.TextLineView_text_selected_color, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(R$styleable.TextLineView_text_unselected_color, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f19856g + this.f19855f + this.f19857h);
        setTextColor(this.i);
        this.j = l.g(context, R.dimen.ds56);
        this.k = new RectF();
        this.o = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }
}
