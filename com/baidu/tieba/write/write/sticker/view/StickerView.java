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
import com.baidu.tbadk.util.f;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long cHh;
    private float fcI;
    private float fcJ;
    private boolean iTm;
    private a jvQ;
    private Matrix jvR;
    private Matrix jvS;
    private PointF jvT;
    private b jvU;
    private boolean jvV;
    private com.baidu.tieba.write.write.sticker.a.a jvW;
    private float jvX;
    private float jvY;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jvW = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvR = new Matrix();
        this.jvS = new Matrix();
        this.jvT = new PointF();
        this.jvV = true;
        this.iTm = false;
        this.cHh = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jvU = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jvQ.getMatrix().postTranslate((getWidth() - this.jvQ.crL()) / 2, (getHeight() - this.jvQ.crM()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jvQ != null) {
            this.jvQ.draw(canvas);
            float[] a = f.a(this.jvQ.crN(), this.jvQ.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.iTm) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jvU.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fcI = motionEvent.getX();
                this.fcJ = motionEvent.getY();
                if (this.jvQ == null) {
                    return false;
                }
                if (this.iTm && this.jvU.R(motionEvent)) {
                    this.jvV = false;
                    if (this.jvW != null) {
                        this.jvW.crO();
                        break;
                    }
                } else if (a(this.jvQ, motionEvent)) {
                    this.jvV = true;
                    if (System.currentTimeMillis() - this.cHh <= 300 && this.jvW != null) {
                        this.jvW.a(this);
                        this.jvV = false;
                    }
                    this.cHh = System.currentTimeMillis();
                    this.mode = 1;
                    this.jvR.set(this.jvQ.getMatrix());
                    break;
                } else {
                    this.jvV = false;
                    if (this.jvW == null) {
                        z = false;
                        break;
                    } else {
                        this.jvW.a(this, this.jvV);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jvT = null;
                if (this.jvW != null) {
                    if (this.jvV) {
                        this.jvW.b(this);
                    }
                    if (this.iTm) {
                        this.jvV = false;
                    }
                    this.jvW.a(this, this.jvV);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jvV || motionEvent.getX() != this.fcI || motionEvent.getY() != this.fcJ) {
                    this.jvV = false;
                }
                if (this.mode == 2) {
                    this.jvS.set(this.jvR);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.jvX;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.jvY;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.jvS.postScale(T, T, this.jvT.x, this.jvT.y);
                    this.jvS.postRotate(U, this.jvT.x, this.jvT.y);
                    this.jvS.postTranslate(S.x - this.jvT.x, S.y - this.jvT.y);
                    this.jvQ.getMatrix().set(this.jvS);
                } else if (this.mode == 1) {
                    this.jvS.set(this.jvR);
                    this.jvS.postTranslate(motionEvent.getX() - this.fcI, motionEvent.getY() - this.fcJ);
                    this.jvQ.getMatrix().set(this.jvS);
                }
                if (!this.jvV) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jvX = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.jvY = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.jvT = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.jvR.set(this.jvQ.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(f.a(aVar.crN(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jvQ = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jvQ = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.iTm = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jvU.BD(i);
    }
}
