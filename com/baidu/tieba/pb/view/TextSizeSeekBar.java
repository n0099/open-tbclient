package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.c2.i.b;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class TextSizeSeekBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f20164e;

    /* renamed from: f  reason: collision with root package name */
    public int f20165f;

    /* renamed from: g  reason: collision with root package name */
    public int f20166g;

    /* renamed from: h  reason: collision with root package name */
    public int f20167h;
    public int i;
    public int j;
    public Paint k;
    public int l;
    public Drawable m;
    public int n;
    public String[] o;
    public int p;
    public int q;
    public int r;
    public int s;
    public ArrayList<Rect> t;
    public int u;
    public int v;
    public int w;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    public final void a(Canvas canvas) {
        Drawable drawable;
        Rect rect = (Rect) ListUtils.getItem(this.t, this.n);
        if (rect == null || (drawable = this.m) == null) {
            return;
        }
        drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
        this.m.draw(canvas);
    }

    public final void b(Canvas canvas) {
        this.k.setColor(this.r);
        this.k.setStrokeWidth(this.u);
        int i = this.f20167h;
        int i2 = this.j;
        canvas.drawLine((float) (i / 2.0d), i2, (float) (this.f20164e - (i / 2.0d)), i2, this.k);
        this.k.setStrokeWidth(this.v);
        this.k.setStrokeCap(Paint.Cap.ROUND);
        for (int i3 = 0; i3 < 4; i3++) {
            canvas.drawPoint((this.f20166g * i3) + (this.f20167h / 2), this.j, this.k);
        }
    }

    public final void c(Canvas canvas) {
        for (int i = 0; i < this.o.length; i++) {
            if (i == this.n) {
                this.k.setColor(this.p);
            } else {
                this.k.setColor(this.q);
            }
            this.k.setTextSize(this.l);
            this.k.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.o[i], (this.f20166g * i) + (this.f20167h / 2), this.j - this.w, this.k);
        }
    }

    public final void d(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setDither(true);
        this.k.setFilterBitmap(true);
        this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
        this.f20167h = dimensionPixelSize;
        this.i = dimensionPixelSize;
        this.l = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.o = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.p = SkinManager.getColor(R.color.CAM_X0105);
        this.q = SkinManager.getColor(R.color.CAM_X0109);
        this.r = SkinManager.getColor(R.color.CAM_X0111);
        this.s = TbadkCoreApplication.getInst().getSkinType();
        this.n = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void e() {
        if (this.s != TbadkCoreApplication.getInst().getSkinType()) {
            this.s = TbadkCoreApplication.getInst().getSkinType();
            if (this.m != null) {
                this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.p = SkinManager.getColor(R.color.CAM_X0105);
            this.q = SkinManager.getColor(R.color.CAM_X0109);
            this.r = SkinManager.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
        this.n = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setCallback(null);
            this.m = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f20164e == 0 || this.f20165f == 0) {
            this.f20164e = View.MeasureSpec.getSize(i);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.f20165f = dimensionPixelSize;
            this.f20166g = (this.f20164e - this.f20167h) / 3;
            this.j = dimensionPixelSize / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = this.f20166g;
                int i5 = this.j;
                int i6 = this.i;
                this.t.add(new Rect(i4 * i3, i5 - (i6 / 2), (i4 * i3) + this.f20167h, i5 + (i6 / 2)));
            }
        }
        setMeasuredDimension(this.f20164e, this.f20165f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 2) {
            int i = 0;
            while (true) {
                if (i > 3) {
                    break;
                } else if (this.t.get(i).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.n = i;
                    b.a(Math.abs(i - 3));
                    invalidate();
                    break;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }
}
