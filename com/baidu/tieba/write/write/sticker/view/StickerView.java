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
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes2.dex */
public class StickerView extends ImageView {
    private long eSa;
    private boolean lSW;
    private float lYa;
    private float lYb;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a mwC;
    private Matrix mwD;
    private Matrix mwE;
    private PointF mwF;
    private b mwG;
    private boolean mwH;
    private com.baidu.tieba.write.write.sticker.a.a mwI;
    private float mwJ;
    private float mwK;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mwI = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mwD = new Matrix();
        this.mwE = new Matrix();
        this.mwF = new PointF();
        this.mwH = true;
        this.lSW = false;
        this.eSa = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mwG = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mwC.getMatrix().postTranslate((getWidth() - this.mwC.duo()) / 2, (getHeight() - this.mwC.dup()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mwC != null) {
            this.mwC.draw(canvas);
            float[] a = g.a(this.mwC.duq(), this.mwC.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lSW) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mwG.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lYa = motionEvent.getX();
                this.lYb = motionEvent.getY();
                if (this.mwC == null) {
                    return false;
                }
                if (this.lSW && this.mwG.Q(motionEvent)) {
                    this.mwH = false;
                    if (this.mwI != null) {
                        this.mwI.dur();
                        break;
                    }
                } else if (a(this.mwC, motionEvent)) {
                    this.mwH = true;
                    if (System.currentTimeMillis() - this.eSa <= 300 && this.mwI != null) {
                        this.mwI.a(this);
                        this.mwH = false;
                    }
                    this.eSa = System.currentTimeMillis();
                    this.mode = 1;
                    this.mwD.set(this.mwC.getMatrix());
                    break;
                } else {
                    this.mwH = false;
                    if (this.mwI == null) {
                        z = false;
                        break;
                    } else {
                        this.mwI.a(this, this.mwH);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mwF = null;
                if (this.mwI != null) {
                    if (this.mwH) {
                        this.mwI.b(this);
                    }
                    if (this.lSW) {
                        this.mwH = false;
                    }
                    this.mwI.a(this, this.mwH);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mwH || motionEvent.getX() != this.lYa || motionEvent.getY() != this.lYb) {
                    this.mwH = false;
                }
                if (this.mode == 2) {
                    this.mwE.set(this.mwD);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.mwJ;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.mwK;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.mwE.postScale(S, S, this.mwF.x, this.mwF.y);
                    this.mwE.postRotate(T, this.mwF.x, this.mwF.y);
                    this.mwE.postTranslate(R.x - this.mwF.x, R.y - this.mwF.y);
                    this.mwC.getMatrix().set(this.mwE);
                } else if (this.mode == 1) {
                    this.mwE.set(this.mwD);
                    this.mwE.postTranslate(motionEvent.getX() - this.lYa, motionEvent.getY() - this.lYb);
                    this.mwC.getMatrix().set(this.mwE);
                }
                if (!this.mwH) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mwJ = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.mwK = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.mwF = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.mwD.set(this.mwC.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.duq(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mwC = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mwC = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lSW = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mwG.GZ(i);
    }
}
