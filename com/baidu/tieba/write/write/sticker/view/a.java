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
    private com.baidu.tieba.write.write.sticker.a hNo;
    private Matrix hNp;
    private Matrix hNq;
    private PointF hNr;
    private b hNs;
    private boolean hNt;
    private com.baidu.tieba.write.write.sticker.a.a hNu;
    private float hNv;
    private float hNw;
    private boolean hlV;
    private float hrn;
    private float hro;
    private long hzR;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hNu = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNp = new Matrix();
        this.hNq = new Matrix();
        this.hNr = new PointF();
        this.hNt = true;
        this.hlV = false;
        this.hzR = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hNs = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.t(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hNo.getMatrix().postTranslate((getWidth() - this.hNo.bJA()) / 2, (getHeight() - this.hNo.bJB()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hNo != null) {
            this.hNo.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hNo.bJC(), this.hNo.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hlV) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hNs.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hrn = motionEvent.getX();
                this.hro = motionEvent.getY();
                if (this.hNo == null) {
                    return false;
                }
                if (this.hlV && this.hNs.V(motionEvent)) {
                    this.hNt = false;
                    if (this.hNu != null) {
                        this.hNu.bJD();
                        break;
                    }
                } else if (a(this.hNo, motionEvent)) {
                    this.hNt = true;
                    if (System.currentTimeMillis() - this.hzR <= 300 && this.hNu != null) {
                        this.hNu.a(this);
                        this.hNt = false;
                    }
                    this.hzR = System.currentTimeMillis();
                    this.mode = 1;
                    this.hNp.set(this.hNo.getMatrix());
                    break;
                } else {
                    this.hNt = false;
                    if (this.hNu == null) {
                        z = false;
                        break;
                    } else {
                        this.hNu.a(this, this.hNt);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hNr = null;
                if (this.hNu != null) {
                    if (this.hNt) {
                        this.hNu.b(this);
                    }
                    if (this.hlV) {
                        this.hNt = false;
                    }
                    this.hNu.a(this, this.hNt);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hNt || motionEvent.getX() != this.hrn || motionEvent.getY() != this.hro) {
                    this.hNt = false;
                }
                if (this.mode == 2) {
                    this.hNq.set(this.hNp);
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) / this.hNv;
                    float Y = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent) - this.hNw;
                    PointF W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                    this.hNq.postScale(X, X, this.hNr.x, this.hNr.y);
                    this.hNq.postRotate(Y, this.hNr.x, this.hNr.y);
                    this.hNq.postTranslate(W.x - this.hNr.x, W.y - this.hNr.y);
                    this.hNo.getMatrix().set(this.hNq);
                } else if (this.mode == 1) {
                    this.hNq.set(this.hNp);
                    this.hNq.postTranslate(motionEvent.getX() - this.hrn, motionEvent.getY() - this.hro);
                    this.hNo.getMatrix().set(this.hNq);
                }
                if (!this.hNt) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hNv = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.hNw = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent);
                this.hNr = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.hNp.set(this.hNo.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bJC(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hNo = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hNo;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hNo = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hlV = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hNs.xQ(i);
    }
}
