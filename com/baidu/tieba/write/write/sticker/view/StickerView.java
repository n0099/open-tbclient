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
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private boolean gIV;
    private float gOt;
    private float gOu;
    private long gXj;
    private a hkA;
    private Matrix hkB;
    private Matrix hkC;
    private PointF hkD;
    private b hkE;
    private boolean hkF;
    private com.baidu.tieba.write.write.sticker.a.a hkG;
    private float hkH;
    private float hkI;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hkG = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkB = new Matrix();
        this.hkC = new Matrix();
        this.hkD = new PointF();
        this.hkF = true;
        this.gIV = false;
        this.gXj = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hkE = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.e(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hkA.getMatrix().postTranslate((getWidth() - this.hkA.bEq()) / 2, (getHeight() - this.hkA.bEr()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hkA != null) {
            this.hkA.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hkA.bEs(), this.hkA.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gIV) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hkE.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gOt = motionEvent.getX();
                this.gOu = motionEvent.getY();
                if (this.hkA == null) {
                    return false;
                }
                if (this.gIV && this.hkE.Q(motionEvent)) {
                    this.hkF = false;
                    if (this.hkG != null) {
                        this.hkG.bEt();
                        break;
                    }
                } else if (a(this.hkA, motionEvent)) {
                    this.hkF = true;
                    if (System.currentTimeMillis() - this.gXj <= 300 && this.hkG != null) {
                        this.hkG.a(this);
                        this.hkF = false;
                    }
                    this.gXj = System.currentTimeMillis();
                    this.mode = 1;
                    this.hkB.set(this.hkA.getMatrix());
                    break;
                } else {
                    this.hkF = false;
                    if (this.hkG == null) {
                        z = false;
                        break;
                    } else {
                        this.hkG.a(this, this.hkF);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hkD = null;
                if (this.hkG != null) {
                    if (this.hkF) {
                        this.hkG.b(this);
                    }
                    if (this.gIV) {
                        this.hkF = false;
                    }
                    this.hkG.a(this, this.hkF);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hkF || motionEvent.getX() != this.gOt || motionEvent.getY() != this.gOu) {
                    this.hkF = false;
                }
                if (this.mode == 2) {
                    this.hkC.set(this.hkB);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.hkH;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.hkI;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.hkC.postScale(S, S, this.hkD.x, this.hkD.y);
                    this.hkC.postRotate(T, this.hkD.x, this.hkD.y);
                    this.hkC.postTranslate(R.x - this.hkD.x, R.y - this.hkD.y);
                    this.hkA.getMatrix().set(this.hkC);
                } else if (this.mode == 1) {
                    this.hkC.set(this.hkB);
                    this.hkC.postTranslate(motionEvent.getX() - this.gOt, motionEvent.getY() - this.gOu);
                    this.hkA.getMatrix().set(this.hkC);
                }
                if (!this.hkF) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hkH = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hkI = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hkD = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.hkB.set(this.hkA.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bEs(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hkA = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hkA = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gIV = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hkE.vl(i);
    }
}
