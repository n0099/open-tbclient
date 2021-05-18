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
import d.a.c.e.p.l;
import d.a.j0.z0.h;
import d.a.k0.v3.u.n.a;
import d.a.k0.v3.u.n.b.b;
/* loaded from: classes5.dex */
public class StickerView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public Context f22227e;

    /* renamed from: f  reason: collision with root package name */
    public a f22228f;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f22229g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f22230h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f22231i;
    public b j;
    public Paint k;
    public int l;
    public boolean m;
    public boolean n;
    public d.a.k0.v3.u.n.b.a o;
    public long p;
    public float q;
    public float r;
    public float s;
    public float t;

    public StickerView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f22227e = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.j = new b(context);
        Paint paint = new Paint();
        this.k = paint;
        paint.setColor(-1);
        this.k.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.k.setAntiAlias(true);
    }

    public final boolean b(a aVar, MotionEvent motionEvent) {
        return d.a.k0.v3.u.n.c.a.e(h.b(aVar.c(), aVar.b()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar = this.f22228f;
        if (aVar == null) {
            return;
        }
        aVar.a(canvas);
        float[] b2 = h.b(this.f22228f.c(), this.f22228f.b());
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f22228f.b().postTranslate((getWidth() - this.f22228f.e()) / 2, (getHeight() - this.f22228f.d()) / 2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d.a.k0.v3.u.n.b.a aVar;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.m || motionEvent.getX() != this.q || motionEvent.getY() != this.r) {
                        this.m = false;
                    }
                    int i2 = this.l;
                    if (i2 == 2) {
                        this.f22230h.set(this.f22229g);
                        float d2 = d.a.k0.v3.u.n.c.a.d(motionEvent) / this.s;
                        float c2 = d.a.k0.v3.u.n.c.a.c(motionEvent) - this.t;
                        PointF b2 = d.a.k0.v3.u.n.c.a.b(motionEvent);
                        Matrix matrix = this.f22230h;
                        PointF pointF = this.f22231i;
                        matrix.postScale(d2, d2, pointF.x, pointF.y);
                        Matrix matrix2 = this.f22230h;
                        PointF pointF2 = this.f22231i;
                        matrix2.postRotate(c2, pointF2.x, pointF2.y);
                        Matrix matrix3 = this.f22230h;
                        float f2 = b2.x;
                        PointF pointF3 = this.f22231i;
                        matrix3.postTranslate(f2 - pointF3.x, b2.y - pointF3.y);
                        this.f22228f.b().set(this.f22230h);
                    } else if (i2 == 1) {
                        this.f22230h.set(this.f22229g);
                        this.f22230h.postTranslate(motionEvent.getX() - this.q, motionEvent.getY() - this.r);
                        this.f22228f.b().set(this.f22230h);
                    }
                    if (this.m) {
                        return true;
                    }
                    invalidate();
                    return true;
                } else if (actionMasked == 5) {
                    this.l = 2;
                    this.s = d.a.k0.v3.u.n.c.a.d(motionEvent);
                    this.t = d.a.k0.v3.u.n.c.a.c(motionEvent);
                    this.f22231i = d.a.k0.v3.u.n.c.a.b(motionEvent);
                    this.f22229g.set(this.f22228f.b());
                    return true;
                } else if (actionMasked != 6) {
                    return true;
                }
            }
            this.l = 0;
            this.f22231i = null;
            d.a.k0.v3.u.n.b.a aVar2 = this.o;
            if (aVar2 != null) {
                if (this.m) {
                    aVar2.c(this);
                }
                if (this.n) {
                    this.m = false;
                }
                this.o.b(this, this.m);
                invalidate();
                return true;
            }
            return true;
        }
        this.q = motionEvent.getX();
        this.r = motionEvent.getY();
        if (this.f22228f == null) {
            return false;
        }
        if (this.n && this.j.b(motionEvent)) {
            this.m = false;
            d.a.k0.v3.u.n.b.a aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.onDelete();
                return true;
            }
            return true;
        } else if (b(this.f22228f, motionEvent)) {
            this.m = true;
            if (System.currentTimeMillis() - this.p <= 300 && (aVar = this.o) != null) {
                aVar.a(this);
                this.m = false;
            }
            this.p = System.currentTimeMillis();
            this.l = 1;
            this.f22229g.set(this.f22228f.b());
            return true;
        } else {
            this.m = false;
            d.a.k0.v3.u.n.b.a aVar4 = this.o;
            if (aVar4 != null) {
                aVar4.b(this, false);
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
        this.f22228f = new a(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.f22228f = new a(BitmapHelper.getResBitmap(this.f22227e, i2));
    }

    public void setRemoveRes(int i2) {
        this.j.c(i2);
    }

    public void setmOnStickerActionListener(d.a.k0.v3.u.n.b.a aVar) {
        this.o = aVar;
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22229g = new Matrix();
        this.f22230h = new Matrix();
        this.f22231i = new PointF();
        this.m = true;
        this.n = false;
        this.p = 0L;
        a(context);
    }
}
