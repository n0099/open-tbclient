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
    private boolean gHV;
    private float gNt;
    private float gNu;
    private long gWi;
    private Matrix hjA;
    private Matrix hjB;
    private PointF hjC;
    private b hjD;
    private boolean hjE;
    private a hjF;
    private float hjG;
    private float hjH;
    private com.baidu.tieba.write.write.sticker.a hjz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.hjF = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjA = new Matrix();
        this.hjB = new Matrix();
        this.hjC = new PointF();
        this.hjE = true;
        this.gHV = false;
        this.gWi = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hjD = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.e(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hjz.getMatrix().postTranslate((getWidth() - this.hjz.bEs()) / 2, (getHeight() - this.hjz.bEt()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hjz != null) {
            this.hjz.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hjz.bEu(), this.hjz.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gHV) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hjD.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gNt = motionEvent.getX();
                this.gNu = motionEvent.getY();
                if (this.hjz == null) {
                    return false;
                }
                if (this.gHV && this.hjD.Q(motionEvent)) {
                    this.hjE = false;
                    if (this.hjF != null) {
                        this.hjF.bEv();
                        break;
                    }
                } else if (a(this.hjz, motionEvent)) {
                    this.hjE = true;
                    if (System.currentTimeMillis() - this.gWi <= 300 && this.hjF != null) {
                        this.hjF.a(this);
                        this.hjE = false;
                    }
                    this.gWi = System.currentTimeMillis();
                    this.mode = 1;
                    this.hjA.set(this.hjz.getMatrix());
                    break;
                } else {
                    this.hjE = false;
                    if (this.hjF == null) {
                        z = false;
                        break;
                    } else {
                        this.hjF.a(this, this.hjE);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hjC = null;
                if (this.hjF != null) {
                    if (this.hjE) {
                        this.hjF.b(this);
                    }
                    if (this.gHV) {
                        this.hjE = false;
                    }
                    this.hjF.a(this, this.hjE);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hjE || motionEvent.getX() != this.gNt || motionEvent.getY() != this.gNu) {
                    this.hjE = false;
                }
                if (this.mode == 2) {
                    this.hjB.set(this.hjA);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.hjG;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.hjH;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.hjB.postScale(S, S, this.hjC.x, this.hjC.y);
                    this.hjB.postRotate(T, this.hjC.x, this.hjC.y);
                    this.hjB.postTranslate(R.x - this.hjC.x, R.y - this.hjC.y);
                    this.hjz.getMatrix().set(this.hjB);
                } else if (this.mode == 1) {
                    this.hjB.set(this.hjA);
                    this.hjB.postTranslate(motionEvent.getX() - this.gNt, motionEvent.getY() - this.gNu);
                    this.hjz.getMatrix().set(this.hjB);
                }
                if (!this.hjE) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hjG = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hjH = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hjC = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.hjA.set(this.hjz.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bEu(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hjz = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hjz = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gHV = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hjD.vm(i);
    }
}
