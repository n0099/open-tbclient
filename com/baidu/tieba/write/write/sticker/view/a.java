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
    private float hAo;
    private float hAp;
    private long hIx;
    private com.baidu.tieba.write.write.sticker.a hVY;
    private Matrix hVZ;
    private Matrix hWa;
    private PointF hWb;
    private b hWc;
    private boolean hWd;
    private com.baidu.tieba.write.write.sticker.a.a hWe;
    private float hWf;
    private float hWg;
    private boolean htX;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hWe = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hVZ = new Matrix();
        this.hWa = new Matrix();
        this.hWb = new PointF();
        this.hWd = true;
        this.htX = false;
        this.hIx = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hWc = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.s(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hVY.getMatrix().postTranslate((getWidth() - this.hVY.bPj()) / 2, (getHeight() - this.hVY.bPk()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hVY != null) {
            this.hVY.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hVY.bPl(), this.hVY.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.htX) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hWc.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hAo = motionEvent.getX();
                this.hAp = motionEvent.getY();
                if (this.hVY == null) {
                    return false;
                }
                if (this.htX && this.hWc.R(motionEvent)) {
                    this.hWd = false;
                    if (this.hWe != null) {
                        this.hWe.bPm();
                        break;
                    }
                } else if (a(this.hVY, motionEvent)) {
                    this.hWd = true;
                    if (System.currentTimeMillis() - this.hIx <= 300 && this.hWe != null) {
                        this.hWe.a(this);
                        this.hWd = false;
                    }
                    this.hIx = System.currentTimeMillis();
                    this.mode = 1;
                    this.hVZ.set(this.hVY.getMatrix());
                    break;
                } else {
                    this.hWd = false;
                    if (this.hWe == null) {
                        z = false;
                        break;
                    } else {
                        this.hWe.a(this, this.hWd);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hWb = null;
                if (this.hWe != null) {
                    if (this.hWd) {
                        this.hWe.b(this);
                    }
                    if (this.htX) {
                        this.hWd = false;
                    }
                    this.hWe.a(this, this.hWd);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hWd || motionEvent.getX() != this.hAo || motionEvent.getY() != this.hAp) {
                    this.hWd = false;
                }
                if (this.mode == 2) {
                    this.hWa.set(this.hVZ);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hWf;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hWg;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hWa.postScale(T, T, this.hWb.x, this.hWb.y);
                    this.hWa.postRotate(U, this.hWb.x, this.hWb.y);
                    this.hWa.postTranslate(S.x - this.hWb.x, S.y - this.hWb.y);
                    this.hVY.getMatrix().set(this.hWa);
                } else if (this.mode == 1) {
                    this.hWa.set(this.hVZ);
                    this.hWa.postTranslate(motionEvent.getX() - this.hAo, motionEvent.getY() - this.hAp);
                    this.hVY.getMatrix().set(this.hWa);
                }
                if (!this.hWd) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hWf = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hWg = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hWb = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hVZ.set(this.hVY.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bPl(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hVY = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hVY;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hVY = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.htX = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hWc.zn(i);
    }
}
