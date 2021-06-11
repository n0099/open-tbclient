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
import d.a.m0.r.u.c;
/* loaded from: classes5.dex */
public class TextLineView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19311e;

    /* renamed from: f  reason: collision with root package name */
    public int f19312f;

    /* renamed from: g  reason: collision with root package name */
    public int f19313g;

    /* renamed from: h  reason: collision with root package name */
    public int f19314h;

    /* renamed from: i  reason: collision with root package name */
    public int f19315i;
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
            d2.s(R.color.CAM_X0105);
            d2.x(R.string.F_X02);
            return;
        }
        c d3 = c.d(this);
        d3.s(R.color.CAM_X0108);
        d3.x(R.string.F_X01);
    }

    public final void a() {
        if (this.f19311e == null) {
            this.f19311e = new Paint();
        }
        this.f19311e.setAntiAlias(true);
        this.f19311e.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.f19311e.setColor(SkinManager.getColor(R.color.transparent));
        } else {
            this.f19311e.setColor(SkinManager.getColor(R.color.transparent));
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
        int i4 = this.f19314h;
        rectF.set(i2 + 0, (i3 - i4) - this.f19312f, this.l - i2, i3 - i4);
        RectF rectF2 = this.k;
        int i5 = this.o;
        canvas.drawRoundRect(rectF2, i5, i5, this.f19311e);
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
        this.f19312f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_height, 0);
        this.f19313g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_top_margin, 0);
        this.f19314h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.f19315i = obtainStyledAttributes.getColor(R$styleable.TextLineView_text_selected_color, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(R$styleable.TextLineView_text_unselected_color, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f19313g + this.f19312f + this.f19314h);
        setTextColor(this.f19315i);
        this.j = l.g(context, R.dimen.ds56);
        this.k = new RectF();
        this.o = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }
}
