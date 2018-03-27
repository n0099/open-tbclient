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
    private long hAp;
    private com.baidu.tieba.write.write.sticker.a hNM;
    private Matrix hNN;
    private Matrix hNO;
    private PointF hNP;
    private b hNQ;
    private boolean hNR;
    private com.baidu.tieba.write.write.sticker.a.a hNS;
    private float hNT;
    private float hNU;
    private boolean hmt;
    private float hrL;
    private float hrM;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hNS = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNN = new Matrix();
        this.hNO = new Matrix();
        this.hNP = new PointF();
        this.hNR = true;
        this.hmt = false;
        this.hAp = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hNQ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.t(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hNM.getMatrix().postTranslate((getWidth() - this.hNM.bJF()) / 2, (getHeight() - this.hNM.bJG()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hNM != null) {
            this.hNM.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hNM.bJH(), this.hNM.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hmt) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hNQ.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hrL = motionEvent.getX();
                this.hrM = motionEvent.getY();
                if (this.hNM == null) {
                    return false;
                }
                if (this.hmt && this.hNQ.V(motionEvent)) {
                    this.hNR = false;
                    if (this.hNS != null) {
                        this.hNS.bJI();
                        break;
                    }
                } else if (a(this.hNM, motionEvent)) {
                    this.hNR = true;
                    if (System.currentTimeMillis() - this.hAp <= 300 && this.hNS != null) {
                        this.hNS.a(this);
                        this.hNR = false;
                    }
                    this.hAp = System.currentTimeMillis();
                    this.mode = 1;
                    this.hNN.set(this.hNM.getMatrix());
                    break;
                } else {
                    this.hNR = false;
                    if (this.hNS == null) {
                        z = false;
                        break;
                    } else {
                        this.hNS.a(this, this.hNR);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hNP = null;
                if (this.hNS != null) {
                    if (this.hNR) {
                        this.hNS.b(this);
                    }
                    if (this.hmt) {
                        this.hNR = false;
                    }
                    this.hNS.a(this, this.hNR);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hNR || motionEvent.getX() != this.hrL || motionEvent.getY() != this.hrM) {
                    this.hNR = false;
                }
                if (this.mode == 2) {
                    this.hNO.set(this.hNN);
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) / this.hNT;
                    float Y = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent) - this.hNU;
                    PointF W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                    this.hNO.postScale(X, X, this.hNP.x, this.hNP.y);
                    this.hNO.postRotate(Y, this.hNP.x, this.hNP.y);
                    this.hNO.postTranslate(W.x - this.hNP.x, W.y - this.hNP.y);
                    this.hNM.getMatrix().set(this.hNO);
                } else if (this.mode == 1) {
                    this.hNO.set(this.hNN);
                    this.hNO.postTranslate(motionEvent.getX() - this.hrL, motionEvent.getY() - this.hrM);
                    this.hNM.getMatrix().set(this.hNO);
                }
                if (!this.hNR) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hNT = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.hNU = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent);
                this.hNP = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.hNN.set(this.hNM.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bJH(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hNM = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hNM;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hNM = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hmt = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hNQ.xQ(i);
    }
}
