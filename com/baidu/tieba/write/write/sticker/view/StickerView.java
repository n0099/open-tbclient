package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.z0.h;
import d.b.i0.v3.v.n.a;
import d.b.i0.v3.v.n.b.b;
/* loaded from: classes5.dex */
public class StickerView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public Context f22284e;

    /* renamed from: f  reason: collision with root package name */
    public a f22285f;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f22286g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f22287h;
    public PointF i;
    public b j;
    public Paint k;
    public int l;
    public boolean m;
    public boolean n;
    public d.b.i0.v3.v.n.b.a o;
    public long p;
    public float q;
    public float r;
    public float s;
    public float t;

    public StickerView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f22284e = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.j = new b(context);
        Paint paint = new Paint();
        this.k = paint;
        paint.setColor(-1);
        this.k.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.k.setAntiAlias(true);
    }

    public final boolean b(a aVar, MotionEvent motionEvent) {
        return d.b.i0.v3.v.n.c.a.e(h.b(aVar.c(), aVar.b()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar = this.f22285f;
        if (aVar == null) {
            return;
        }
        aVar.a(canvas);
        float[] b2 = h.b(this.f22285f.c(), this.f22285f.b());
        float f2 = b2[0];
        float f3 = b2[1];
        float f4 = b2[2];
        float f5 = b2[3];
        float f6 = b2[4];
        float f7 = b2[5];
        float f8 = b2[6];
        float f9 = b2[7];
        if (this.n) {
            canvas.drawLine(f2, f3, f4, f5, this.k);
            canvas.drawLine(f4, f5, f8, f9, this.k);
            canvas.drawLine(f8, f9, f6, f7, this.k);
            canvas.drawLine(f6, f7, f2, f3, this.k);
            canvas.drawPoint(f2, f3, this.k);
            canvas.drawPoint(f4, f5, this.k);
            canvas.drawPoint(f6, f7, this.k);
            canvas.drawPoint(f8, f9, this.k);
            this.j.a(canvas, f4, f5);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f22285f.b().postTranslate((getWidth() - this.f22285f.e()) / 2, (getHeight() - this.f22285f.d()) / 2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d.b.i0.v3.v.n.b.a aVar;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.m || motionEvent.getX() != this.q || motionEvent.getY() != this.r) {
                        this.m = false;
                    }
                    int i = this.l;
                    if (i == 2) {
                        this.f22287h.set(this.f22286g);
                        float d2 = d.b.i0.v3.v.n.c.a.d(motionEvent) / this.s;
                        float c2 = d.b.i0.v3.v.n.c.a.c(motionEvent) - this.t;
                        PointF b2 = d.b.i0.v3.v.n.c.a.b(motionEvent);
                        Matrix matrix = this.f22287h;
                        PointF pointF = this.i;
                        matrix.postScale(d2, d2, pointF.x, pointF.y);
                        Matrix matrix2 = this.f22287h;
                        PointF pointF2 = this.i;
                        matrix2.postRotate(c2, pointF2.x, pointF2.y);
                        Matrix matrix3 = this.f22287h;
                        float f2 = b2.x;
                        PointF pointF3 = this.i;
                        matrix3.postTranslate(f2 - pointF3.x, b2.y - pointF3.y);
                        this.f22285f.b().set(this.f22287h);
                    } else if (i == 1) {
                        this.f22287h.set(this.f22286g);
                        this.f22287h.postTranslate(motionEvent.getX() - this.q, motionEvent.getY() - this.r);
                        this.f22285f.b().set(this.f22287h);
                    }
                    if (this.m) {
                        return true;
                    }
                    invalidate();
                    return true;
                } else if (actionMasked == 5) {
                    this.l = 2;
                    this.s = d.b.i0.v3.v.n.c.a.d(motionEvent);
                    this.t = d.b.i0.v3.v.n.c.a.c(motionEvent);
                    this.i = d.b.i0.v3.v.n.c.a.b(motionEvent);
                    this.f22286g.set(this.f22285f.b());
                    return true;
                } else if (actionMasked != 6) {
                    return true;
                }
            }
            this.l = 0;
            this.i = null;
            d.b.i0.v3.v.n.b.a aVar2 = this.o;
            if (aVar2 != null) {
                if (this.m) {
                    aVar2.d(this);
                }
                if (this.n) {
                    this.m = false;
                }
                this.o.c(this, this.m);
                invalidate();
                return true;
            }
            return true;
        }
        this.q = motionEvent.getX();
        this.r = motionEvent.getY();
        if (this.f22285f == null) {
            return false;
        }
        if (this.n && this.j.b(motionEvent)) {
            this.m = false;
            d.b.i0.v3.v.n.b.a aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.a();
                return true;
            }
            return true;
        } else if (b(this.f22285f, motionEvent)) {
            this.m = true;
            if (System.currentTimeMillis() - this.p <= 300 && (aVar = this.o) != null) {
                aVar.b(this);
                this.m = false;
            }
            this.p = System.currentTimeMillis();
            this.l = 1;
            this.f22286g.set(this.f22285f.b());
            return true;
        } else {
            this.m = false;
            d.b.i0.v3.v.n.b.a aVar4 = this.o;
            if (aVar4 != null) {
                aVar4.c(this, false);
                invalidate();
            }
            return false;
        }
    }

    public void setEdit(boolean z) {
        this.n = z;
        postInvalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f22285f = new a(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f22285f = new a(BitmapHelper.getResBitmap(this.f22284e, i));
    }

    public void setRemoveRes(int i) {
        this.j.c(i);
    }

    public void setmOnStickerActionListener(d.b.i0.v3.v.n.b.a aVar) {
        this.o = aVar;
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22286g = new Matrix();
        this.f22287h = new Matrix();
        this.i = new PointF();
        this.m = true;
        this.n = false;
        this.p = 0L;
        a(context);
    }
}
