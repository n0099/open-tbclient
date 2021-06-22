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
import d.a.o0.e2.i.b;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class TextSizeSeekBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f19730e;

    /* renamed from: f  reason: collision with root package name */
    public int f19731f;

    /* renamed from: g  reason: collision with root package name */
    public int f19732g;

    /* renamed from: h  reason: collision with root package name */
    public int f19733h;

    /* renamed from: i  reason: collision with root package name */
    public int f19734i;
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
        int i2 = this.f19733h;
        int i3 = this.j;
        canvas.drawLine((float) (i2 / 2.0d), i3, (float) (this.f19730e - (i2 / 2.0d)), i3, this.k);
        this.k.setStrokeWidth(this.v);
        this.k.setStrokeCap(Paint.Cap.ROUND);
        for (int i4 = 0; i4 < 4; i4++) {
            canvas.drawPoint((this.f19732g * i4) + (this.f19733h / 2), this.j, this.k);
        }
    }

    public final void c(Canvas canvas) {
        for (int i2 = 0; i2 < this.o.length; i2++) {
            if (i2 == this.n) {
                this.k.setColor(this.p);
            } else {
                this.k.setColor(this.q);
            }
            this.k.setTextSize(this.l);
            this.k.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.o[i2], (this.f19732g * i2) + (this.f19733h / 2), this.j - this.w, this.k);
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
        this.f19733h = dimensionPixelSize;
        this.f19734i = dimensionPixelSize;
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
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f19730e == 0 || this.f19731f == 0) {
            this.f19730e = View.MeasureSpec.getSize(i2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.f19731f = dimensionPixelSize;
            this.f19732g = (this.f19730e - this.f19733h) / 3;
            this.j = dimensionPixelSize / 2;
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = this.f19732g;
                int i6 = this.j;
                int i7 = this.f19734i;
                this.t.add(new Rect(i5 * i4, i6 - (i7 / 2), (i5 * i4) + this.f19733h, i6 + (i7 / 2)));
            }
        }
        setMeasuredDimension(this.f19730e, this.f19731f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 2) {
            int i2 = 0;
            while (true) {
                if (i2 > 3) {
                    break;
                } else if (this.t.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.n = i2;
                    b.a(Math.abs(i2 - 3));
                    invalidate();
                    break;
                } else {
                    i2++;
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

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }
}
