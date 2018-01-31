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
    private com.baidu.tieba.write.write.sticker.a hMc;
    private Matrix hMd;
    private Matrix hMe;
    private PointF hMf;
    private b hMg;
    private boolean hMh;
    private com.baidu.tieba.write.write.sticker.a.a hMi;
    private float hMj;
    private float hMk;
    private boolean hjU;
    private float hql;
    private float hqm;
    private long hyy;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hMi = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMd = new Matrix();
        this.hMe = new Matrix();
        this.hMf = new PointF();
        this.hMh = true;
        this.hjU = false;
        this.hyy = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hMg = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.s(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hMc.getMatrix().postTranslate((getWidth() - this.hMc.bIO()) / 2, (getHeight() - this.hMc.bIP()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hMc != null) {
            this.hMc.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hMc.bIQ(), this.hMc.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hjU) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hMg.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hql = motionEvent.getX();
                this.hqm = motionEvent.getY();
                if (this.hMc == null) {
                    return false;
                }
                if (this.hjU && this.hMg.R(motionEvent)) {
                    this.hMh = false;
                    if (this.hMi != null) {
                        this.hMi.bIR();
                        break;
                    }
                } else if (a(this.hMc, motionEvent)) {
                    this.hMh = true;
                    if (System.currentTimeMillis() - this.hyy <= 300 && this.hMi != null) {
                        this.hMi.a(this);
                        this.hMh = false;
                    }
                    this.hyy = System.currentTimeMillis();
                    this.mode = 1;
                    this.hMd.set(this.hMc.getMatrix());
                    break;
                } else {
                    this.hMh = false;
                    if (this.hMi == null) {
                        z = false;
                        break;
                    } else {
                        this.hMi.a(this, this.hMh);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hMf = null;
                if (this.hMi != null) {
                    if (this.hMh) {
                        this.hMi.b(this);
                    }
                    if (this.hjU) {
                        this.hMh = false;
                    }
                    this.hMi.a(this, this.hMh);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hMh || motionEvent.getX() != this.hql || motionEvent.getY() != this.hqm) {
                    this.hMh = false;
                }
                if (this.mode == 2) {
                    this.hMe.set(this.hMd);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hMj;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hMk;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hMe.postScale(T, T, this.hMf.x, this.hMf.y);
                    this.hMe.postRotate(U, this.hMf.x, this.hMf.y);
                    this.hMe.postTranslate(S.x - this.hMf.x, S.y - this.hMf.y);
                    this.hMc.getMatrix().set(this.hMe);
                } else if (this.mode == 1) {
                    this.hMe.set(this.hMd);
                    this.hMe.postTranslate(motionEvent.getX() - this.hql, motionEvent.getY() - this.hqm);
                    this.hMc.getMatrix().set(this.hMe);
                }
                if (!this.hMh) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hMj = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hMk = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hMf = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hMd.set(this.hMc.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bIQ(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hMc = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hMc;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hMc = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hjU = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hMg.xQ(i);
    }
}
