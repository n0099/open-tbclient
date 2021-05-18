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
import d.a.c.e.p.l;
import d.a.j0.r.u.c;
/* loaded from: classes5.dex */
public class TextLineView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19314e;

    /* renamed from: f  reason: collision with root package name */
    public int f19315f;

    /* renamed from: g  reason: collision with root package name */
    public int f19316g;

    /* renamed from: h  reason: collision with root package name */
    public int f19317h;

    /* renamed from: i  reason: collision with root package name */
    public int f19318i;
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
        if (this.f19314e == null) {
            this.f19314e = new Paint();
        }
        this.f19314e.setAntiAlias(true);
        this.f19314e.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.f19314e.setColor(SkinManager.getColor(R.color.transparent));
        } else {
            this.f19314e.setColor(SkinManager.getColor(R.color.transparent));
        }
    }

    public void b(int i2) {
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
        int i2 = this.n;
        int i3 = this.m;
        int i4 = this.f19317h;
        rectF.set(i2 + 0, (i3 - i4) - this.f19315f, this.l - i2, i3 - i4);
        RectF rectF2 = this.k;
        int i5 = this.o;
        canvas.drawRoundRect(rectF2, i5, i5, this.f19314e);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.l = i2;
        this.m = i3;
        this.n = (i2 - this.j) / 2;
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
        this.f19315f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_height, 0);
        this.f19316g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_top_margin, 0);
        this.f19317h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.f19318i = obtainStyledAttributes.getColor(R$styleable.TextLineView_text_selected_color, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(R$styleable.TextLineView_text_unselected_color, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f19316g + this.f19315f + this.f19317h);
        setTextColor(this.f19318i);
        this.j = l.g(context, R.dimen.ds56);
        this.k = new RectF();
        this.o = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }
}
