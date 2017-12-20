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
    private Matrix gvO;
    private Matrix gvP;
    private PointF gvQ;
    private boolean gvS;
    private boolean gvT;
    private long gvV;
    private float gvW;
    private float gvX;
    private float gvY;
    private float gvZ;
    private com.baidu.tieba.write.write.sticker.a hnH;
    private b hnI;
    private com.baidu.tieba.write.write.sticker.a.a hnJ;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hnJ = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvO = new Matrix();
        this.gvP = new Matrix();
        this.gvQ = new PointF();
        this.gvS = true;
        this.gvT = false;
        this.gvV = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hnI = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.f(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hnH.getMatrix().postTranslate((getWidth() - this.hnH.btS()) / 2, (getHeight() - this.hnH.btT()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hnH != null) {
            this.hnH.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hnH.btU(), this.hnH.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gvT) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hnI.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gvW = motionEvent.getX();
                this.gvX = motionEvent.getY();
                if (this.hnH == null) {
                    return false;
                }
                if (this.gvT && this.hnI.B(motionEvent)) {
                    this.gvS = false;
                    if (this.hnJ != null) {
                        this.hnJ.btV();
                        break;
                    }
                } else if (a(this.hnH, motionEvent)) {
                    this.gvS = true;
                    if (System.currentTimeMillis() - this.gvV <= 300 && this.hnJ != null) {
                        this.hnJ.a(this);
                        this.gvS = false;
                    }
                    this.gvV = System.currentTimeMillis();
                    this.mode = 1;
                    this.gvO.set(this.hnH.getMatrix());
                    break;
                } else {
                    this.gvS = false;
                    if (this.hnJ == null) {
                        z = false;
                        break;
                    } else {
                        this.hnJ.a(this, this.gvS);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.gvQ = null;
                if (this.hnJ != null) {
                    if (this.gvS) {
                        this.hnJ.b(this);
                    }
                    if (this.gvT) {
                        this.gvS = false;
                    }
                    this.hnJ.a(this, this.gvS);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.gvS || motionEvent.getX() != this.gvW || motionEvent.getY() != this.gvX) {
                    this.gvS = false;
                }
                if (this.mode == 2) {
                    this.gvP.set(this.gvO);
                    float D = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent) / this.gvY;
                    float E = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent) - this.gvZ;
                    PointF C = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                    this.gvP.postScale(D, D, this.gvQ.x, this.gvQ.y);
                    this.gvP.postRotate(E, this.gvQ.x, this.gvQ.y);
                    this.gvP.postTranslate(C.x - this.gvQ.x, C.y - this.gvQ.y);
                    this.hnH.getMatrix().set(this.gvP);
                } else if (this.mode == 1) {
                    this.gvP.set(this.gvO);
                    this.gvP.postTranslate(motionEvent.getX() - this.gvW, motionEvent.getY() - this.gvX);
                    this.hnH.getMatrix().set(this.gvP);
                }
                if (!this.gvS) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.gvY = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent);
                this.gvZ = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent);
                this.gvQ = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                this.gvO.set(this.hnH.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.btU(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hnH = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hnH;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hnH = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gvT = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hnI.ud(i);
    }
}
