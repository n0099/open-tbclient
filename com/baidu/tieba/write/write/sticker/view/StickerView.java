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
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long bqU;
    private float dDH;
    private float dDI;
    private Matrix hRA;
    private PointF hRB;
    private b hRC;
    private boolean hRD;
    private a hRE;
    private float hRF;
    private float hRG;
    private com.baidu.tieba.write.write.sticker.a hRy;
    private Matrix hRz;
    private boolean hph;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.hRE = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRz = new Matrix();
        this.hRA = new Matrix();
        this.hRB = new PointF();
        this.hRD = true;
        this.hph = false;
        this.bqU = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hRC = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0175e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hRy.getMatrix().postTranslate((getWidth() - this.hRy.bOP()) / 2, (getHeight() - this.hRy.bOQ()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hRy != null) {
            this.hRy.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.hRy.bOR(), this.hRy.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hph) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hRC.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dDH = motionEvent.getX();
                this.dDI = motionEvent.getY();
                if (this.hRy == null) {
                    return false;
                }
                if (this.hph && this.hRC.Q(motionEvent)) {
                    this.hRD = false;
                    if (this.hRE != null) {
                        this.hRE.bOS();
                        break;
                    }
                } else if (a(this.hRy, motionEvent)) {
                    this.hRD = true;
                    if (System.currentTimeMillis() - this.bqU <= 300 && this.hRE != null) {
                        this.hRE.a(this);
                        this.hRD = false;
                    }
                    this.bqU = System.currentTimeMillis();
                    this.mode = 1;
                    this.hRz.set(this.hRy.getMatrix());
                    break;
                } else {
                    this.hRD = false;
                    if (this.hRE == null) {
                        z = false;
                        break;
                    } else {
                        this.hRE.a(this, this.hRD);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hRB = null;
                if (this.hRE != null) {
                    if (this.hRD) {
                        this.hRE.b(this);
                    }
                    if (this.hph) {
                        this.hRD = false;
                    }
                    this.hRE.a(this, this.hRD);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hRD || motionEvent.getX() != this.dDH || motionEvent.getY() != this.dDI) {
                    this.hRD = false;
                }
                if (this.mode == 2) {
                    this.hRA.set(this.hRz);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.hRF;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.hRG;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.hRA.postScale(S, S, this.hRB.x, this.hRB.y);
                    this.hRA.postRotate(T, this.hRB.x, this.hRB.y);
                    this.hRA.postTranslate(R.x - this.hRB.x, R.y - this.hRB.y);
                    this.hRy.getMatrix().set(this.hRA);
                } else if (this.mode == 1) {
                    this.hRA.set(this.hRz);
                    this.hRA.postTranslate(motionEvent.getX() - this.dDH, motionEvent.getY() - this.dDI);
                    this.hRy.getMatrix().set(this.hRA);
                }
                if (!this.hRD) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hRF = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hRG = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hRB = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.hRz.set(this.hRy.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bOR(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hRy = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hRy = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hph = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hRC.wI(i);
    }
}
