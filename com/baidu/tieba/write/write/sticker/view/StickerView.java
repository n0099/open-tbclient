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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes2.dex */
public class StickerView extends ImageView {
    private long eSa;
    private boolean lST;
    private float lXX;
    private float lXY;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private Matrix mwA;
    private Matrix mwB;
    private PointF mwC;
    private b mwD;
    private boolean mwE;
    private a mwF;
    private float mwG;
    private float mwH;
    private com.baidu.tieba.write.write.sticker.a mwz;

    public void setmOnStickerActionListener(a aVar) {
        this.mwF = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mwA = new Matrix();
        this.mwB = new Matrix();
        this.mwC = new PointF();
        this.mwE = true;
        this.lST = false;
        this.eSa = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mwD = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mwz.getMatrix().postTranslate((getWidth() - this.mwz.duk()) / 2, (getHeight() - this.mwz.dul()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mwz != null) {
            this.mwz.draw(canvas);
            float[] a = g.a(this.mwz.dum(), this.mwz.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lST) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mwD.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lXX = motionEvent.getX();
                this.lXY = motionEvent.getY();
                if (this.mwz == null) {
                    return false;
                }
                if (this.lST && this.mwD.Q(motionEvent)) {
                    this.mwE = false;
                    if (this.mwF != null) {
                        this.mwF.dun();
                        break;
                    }
                } else if (a(this.mwz, motionEvent)) {
                    this.mwE = true;
                    if (System.currentTimeMillis() - this.eSa <= 300 && this.mwF != null) {
                        this.mwF.a(this);
                        this.mwE = false;
                    }
                    this.eSa = System.currentTimeMillis();
                    this.mode = 1;
                    this.mwA.set(this.mwz.getMatrix());
                    break;
                } else {
                    this.mwE = false;
                    if (this.mwF == null) {
                        z = false;
                        break;
                    } else {
                        this.mwF.a(this, this.mwE);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mwC = null;
                if (this.mwF != null) {
                    if (this.mwE) {
                        this.mwF.b(this);
                    }
                    if (this.lST) {
                        this.mwE = false;
                    }
                    this.mwF.a(this, this.mwE);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mwE || motionEvent.getX() != this.lXX || motionEvent.getY() != this.lXY) {
                    this.mwE = false;
                }
                if (this.mode == 2) {
                    this.mwB.set(this.mwA);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.mwG;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.mwH;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.mwB.postScale(S, S, this.mwC.x, this.mwC.y);
                    this.mwB.postRotate(T, this.mwC.x, this.mwC.y);
                    this.mwB.postTranslate(R.x - this.mwC.x, R.y - this.mwC.y);
                    this.mwz.getMatrix().set(this.mwB);
                } else if (this.mode == 1) {
                    this.mwB.set(this.mwA);
                    this.mwB.postTranslate(motionEvent.getX() - this.lXX, motionEvent.getY() - this.lXY);
                    this.mwz.getMatrix().set(this.mwB);
                }
                if (!this.mwE) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mwG = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.mwH = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.mwC = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.mwA.set(this.mwz.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dum(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mwz = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mwz = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lST = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mwD.GZ(i);
    }
}
