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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private float bkM;
    private float bkN;
    private long fGL;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a nJV;
    private Matrix nJW;
    private Matrix nJX;
    private PointF nJY;
    private b nJZ;
    private boolean nKa;
    private com.baidu.tieba.write.write.sticker.a.a nKb;
    private float nKc;
    private float nKd;
    private boolean neg;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.nKb = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJW = new Matrix();
        this.nJX = new Matrix();
        this.nJY = new PointF();
        this.nKa = true;
        this.neg = false;
        this.fGL = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.nJZ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.nJV.getMatrix().postTranslate((getWidth() - this.nJV.dUq()) / 2, (getHeight() - this.nJV.dUr()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nJV != null) {
            this.nJV.draw(canvas);
            float[] a2 = h.a(this.nJV.dUs(), this.nJV.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.neg) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.nJZ.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bkM = motionEvent.getX();
                this.bkN = motionEvent.getY();
                if (this.nJV == null) {
                    return false;
                }
                if (this.neg && this.nJZ.aj(motionEvent)) {
                    this.nKa = false;
                    if (this.nKb != null) {
                        this.nKb.cIE();
                        break;
                    }
                } else if (a(this.nJV, motionEvent)) {
                    this.nKa = true;
                    if (System.currentTimeMillis() - this.fGL <= 300 && this.nKb != null) {
                        this.nKb.a(this);
                        this.nKa = false;
                    }
                    this.fGL = System.currentTimeMillis();
                    this.mode = 1;
                    this.nJW.set(this.nJV.getMatrix());
                    break;
                } else {
                    this.nKa = false;
                    if (this.nKb == null) {
                        z = false;
                        break;
                    } else {
                        this.nKb.a(this, this.nKa);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.nJY = null;
                if (this.nKb != null) {
                    if (this.nKa) {
                        this.nKb.b(this);
                    }
                    if (this.neg) {
                        this.nKa = false;
                    }
                    this.nKb.a(this, this.nKa);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.nKa || motionEvent.getX() != this.bkM || motionEvent.getY() != this.bkN) {
                    this.nKa = false;
                }
                if (this.mode == 2) {
                    this.nJX.set(this.nJW);
                    float al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent) / this.nKc;
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) - this.nKd;
                    PointF ak = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                    this.nJX.postScale(al, al, this.nJY.x, this.nJY.y);
                    this.nJX.postRotate(am, this.nJY.x, this.nJY.y);
                    this.nJX.postTranslate(ak.x - this.nJY.x, ak.y - this.nJY.y);
                    this.nJV.getMatrix().set(this.nJX);
                } else if (this.mode == 1) {
                    this.nJX.set(this.nJW);
                    this.nJX.postTranslate(motionEvent.getX() - this.bkM, motionEvent.getY() - this.bkN);
                    this.nJV.getMatrix().set(this.nJX);
                }
                if (!this.nKa) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.nKc = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.nKd = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.nJY = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                this.nJW.set(this.nJV.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dUs(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.nJV = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.nJV = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.neg = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.nJZ.Lx(i);
    }
}
