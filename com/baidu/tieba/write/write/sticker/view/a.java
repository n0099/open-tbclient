package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes2.dex */
public class a extends ImageView {
    private Matrix gth;
    private Matrix gti;
    private PointF gtj;
    private boolean gtl;
    private boolean gtm;
    private long gto;
    private float gtp;
    private float gtq;
    private float gtr;
    private float gts;
    private com.baidu.tieba.write.write.sticker.a hkP;
    private b hkQ;
    private com.baidu.tieba.write.write.sticker.a.a hkR;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hkR = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gth = new Matrix();
        this.gti = new Matrix();
        this.gtj = new PointF();
        this.gtl = true;
        this.gtm = false;
        this.gto = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hkQ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.f(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hkP.getMatrix().postTranslate((getWidth() - this.hkP.btn()) / 2, (getHeight() - this.hkP.bto()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hkP != null) {
            this.hkP.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hkP.btp(), this.hkP.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gtm) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hkQ.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gtp = motionEvent.getX();
                this.gtq = motionEvent.getY();
                if (this.hkP == null) {
                    return false;
                }
                if (this.gtm && this.hkQ.B(motionEvent)) {
                    this.gtl = false;
                    if (this.hkR != null) {
                        this.hkR.btq();
                        break;
                    }
                } else if (a(this.hkP, motionEvent)) {
                    this.gtl = true;
                    if (System.currentTimeMillis() - this.gto <= 300 && this.hkR != null) {
                        this.hkR.a(this);
                        this.gtl = false;
                    }
                    this.gto = System.currentTimeMillis();
                    this.mode = 1;
                    this.gth.set(this.hkP.getMatrix());
                    break;
                } else {
                    this.gtl = false;
                    if (this.hkR == null) {
                        z = false;
                        break;
                    } else {
                        this.hkR.a(this, this.gtl);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.gtj = null;
                if (this.hkR != null) {
                    if (this.gtl) {
                        this.hkR.b(this);
                    }
                    if (this.gtm) {
                        this.gtl = false;
                    }
                    this.hkR.a(this, this.gtl);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.gtl || motionEvent.getX() != this.gtp || motionEvent.getY() != this.gtq) {
                    this.gtl = false;
                }
                if (this.mode == 2) {
                    this.gti.set(this.gth);
                    float D = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent) / this.gtr;
                    float E = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent) - this.gts;
                    PointF C = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                    this.gti.postScale(D, D, this.gtj.x, this.gtj.y);
                    this.gti.postRotate(E, this.gtj.x, this.gtj.y);
                    this.gti.postTranslate(C.x - this.gtj.x, C.y - this.gtj.y);
                    this.hkP.getMatrix().set(this.gti);
                } else if (this.mode == 1) {
                    this.gti.set(this.gth);
                    this.gti.postTranslate(motionEvent.getX() - this.gtp, motionEvent.getY() - this.gtq);
                    this.hkP.getMatrix().set(this.gti);
                }
                if (!this.gtl) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.gtr = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent);
                this.gts = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent);
                this.gtj = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                this.gth.set(this.hkP.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.btp(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hkP = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hkP;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hkP = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gtm = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hkQ.tS(i);
    }
}
