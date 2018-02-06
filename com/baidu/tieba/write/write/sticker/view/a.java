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
    private long hAe;
    private com.baidu.tieba.write.write.sticker.a hNB;
    private Matrix hNC;
    private Matrix hND;
    private PointF hNE;
    private b hNF;
    private boolean hNG;
    private com.baidu.tieba.write.write.sticker.a.a hNH;
    private float hNI;
    private float hNJ;
    private boolean hmk;
    private float hrA;
    private float hrB;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hNH = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNC = new Matrix();
        this.hND = new Matrix();
        this.hNE = new PointF();
        this.hNG = true;
        this.hmk = false;
        this.hAe = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hNF = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.t(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hNB.getMatrix().postTranslate((getWidth() - this.hNB.bJB()) / 2, (getHeight() - this.hNB.bJC()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hNB != null) {
            this.hNB.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hNB.bJD(), this.hNB.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hmk) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hNF.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hrA = motionEvent.getX();
                this.hrB = motionEvent.getY();
                if (this.hNB == null) {
                    return false;
                }
                if (this.hmk && this.hNF.V(motionEvent)) {
                    this.hNG = false;
                    if (this.hNH != null) {
                        this.hNH.bJE();
                        break;
                    }
                } else if (a(this.hNB, motionEvent)) {
                    this.hNG = true;
                    if (System.currentTimeMillis() - this.hAe <= 300 && this.hNH != null) {
                        this.hNH.a(this);
                        this.hNG = false;
                    }
                    this.hAe = System.currentTimeMillis();
                    this.mode = 1;
                    this.hNC.set(this.hNB.getMatrix());
                    break;
                } else {
                    this.hNG = false;
                    if (this.hNH == null) {
                        z = false;
                        break;
                    } else {
                        this.hNH.a(this, this.hNG);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hNE = null;
                if (this.hNH != null) {
                    if (this.hNG) {
                        this.hNH.b(this);
                    }
                    if (this.hmk) {
                        this.hNG = false;
                    }
                    this.hNH.a(this, this.hNG);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hNG || motionEvent.getX() != this.hrA || motionEvent.getY() != this.hrB) {
                    this.hNG = false;
                }
                if (this.mode == 2) {
                    this.hND.set(this.hNC);
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) / this.hNI;
                    float Y = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent) - this.hNJ;
                    PointF W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                    this.hND.postScale(X, X, this.hNE.x, this.hNE.y);
                    this.hND.postRotate(Y, this.hNE.x, this.hNE.y);
                    this.hND.postTranslate(W.x - this.hNE.x, W.y - this.hNE.y);
                    this.hNB.getMatrix().set(this.hND);
                } else if (this.mode == 1) {
                    this.hND.set(this.hNC);
                    this.hND.postTranslate(motionEvent.getX() - this.hrA, motionEvent.getY() - this.hrB);
                    this.hNB.getMatrix().set(this.hND);
                }
                if (!this.hNG) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hNI = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.hNJ = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent);
                this.hNE = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.hNC.set(this.hNB.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bJD(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hNB = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hNB;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hNB = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hmk = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hNF.xP(i);
    }
}
