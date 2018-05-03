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
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private boolean gHS;
    private float gNq;
    private float gNr;
    private long gWf;
    private b hjA;
    private boolean hjB;
    private a hjC;
    private float hjD;
    private float hjE;
    private com.baidu.tieba.write.write.sticker.a hjw;
    private Matrix hjx;
    private Matrix hjy;
    private PointF hjz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.hjC = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjx = new Matrix();
        this.hjy = new Matrix();
        this.hjz = new PointF();
        this.hjB = true;
        this.gHS = false;
        this.gWf = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hjA = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.e(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hjw.getMatrix().postTranslate((getWidth() - this.hjw.bEs()) / 2, (getHeight() - this.hjw.bEt()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hjw != null) {
            this.hjw.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hjw.bEu(), this.hjw.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gHS) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hjA.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gNq = motionEvent.getX();
                this.gNr = motionEvent.getY();
                if (this.hjw == null) {
                    return false;
                }
                if (this.gHS && this.hjA.Q(motionEvent)) {
                    this.hjB = false;
                    if (this.hjC != null) {
                        this.hjC.bEv();
                        break;
                    }
                } else if (a(this.hjw, motionEvent)) {
                    this.hjB = true;
                    if (System.currentTimeMillis() - this.gWf <= 300 && this.hjC != null) {
                        this.hjC.a(this);
                        this.hjB = false;
                    }
                    this.gWf = System.currentTimeMillis();
                    this.mode = 1;
                    this.hjx.set(this.hjw.getMatrix());
                    break;
                } else {
                    this.hjB = false;
                    if (this.hjC == null) {
                        z = false;
                        break;
                    } else {
                        this.hjC.a(this, this.hjB);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hjz = null;
                if (this.hjC != null) {
                    if (this.hjB) {
                        this.hjC.b(this);
                    }
                    if (this.gHS) {
                        this.hjB = false;
                    }
                    this.hjC.a(this, this.hjB);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hjB || motionEvent.getX() != this.gNq || motionEvent.getY() != this.gNr) {
                    this.hjB = false;
                }
                if (this.mode == 2) {
                    this.hjy.set(this.hjx);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.hjD;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.hjE;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.hjy.postScale(S, S, this.hjz.x, this.hjz.y);
                    this.hjy.postRotate(T, this.hjz.x, this.hjz.y);
                    this.hjy.postTranslate(R.x - this.hjz.x, R.y - this.hjz.y);
                    this.hjw.getMatrix().set(this.hjy);
                } else if (this.mode == 1) {
                    this.hjy.set(this.hjx);
                    this.hjy.postTranslate(motionEvent.getX() - this.gNq, motionEvent.getY() - this.gNr);
                    this.hjw.getMatrix().set(this.hjy);
                }
                if (!this.hjB) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hjD = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hjE = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hjz = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.hjx.set(this.hjw.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bEu(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hjw = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hjw = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gHS = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hjA.vm(i);
    }
}
