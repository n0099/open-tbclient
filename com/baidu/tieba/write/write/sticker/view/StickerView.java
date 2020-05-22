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
    private long eHD;
    private float lDf;
    private float lDg;
    private boolean lye;
    private Context mContext;
    private Paint mPaint;
    private a maB;
    private Matrix maC;
    private Matrix maD;
    private PointF maE;
    private b maF;
    private boolean maG;
    private com.baidu.tieba.write.write.sticker.a.a maH;
    private float maI;
    private float maJ;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.maH = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maC = new Matrix();
        this.maD = new Matrix();
        this.maE = new PointF();
        this.maG = true;
        this.lye = false;
        this.eHD = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.maF = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.maB.getMatrix().postTranslate((getWidth() - this.maB.dpB()) / 2, (getHeight() - this.maB.dpC()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.maB != null) {
            this.maB.draw(canvas);
            float[] a = g.a(this.maB.dpD(), this.maB.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lye) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.maF.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lDf = motionEvent.getX();
                this.lDg = motionEvent.getY();
                if (this.maB == null) {
                    return false;
                }
                if (this.lye && this.maF.Q(motionEvent)) {
                    this.maG = false;
                    if (this.maH != null) {
                        this.maH.dpE();
                        break;
                    }
                } else if (a(this.maB, motionEvent)) {
                    this.maG = true;
                    if (System.currentTimeMillis() - this.eHD <= 300 && this.maH != null) {
                        this.maH.a(this);
                        this.maG = false;
                    }
                    this.eHD = System.currentTimeMillis();
                    this.mode = 1;
                    this.maC.set(this.maB.getMatrix());
                    break;
                } else {
                    this.maG = false;
                    if (this.maH == null) {
                        z = false;
                        break;
                    } else {
                        this.maH.a(this, this.maG);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.maE = null;
                if (this.maH != null) {
                    if (this.maG) {
                        this.maH.b(this);
                    }
                    if (this.lye) {
                        this.maG = false;
                    }
                    this.maH.a(this, this.maG);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.maG || motionEvent.getX() != this.lDf || motionEvent.getY() != this.lDg) {
                    this.maG = false;
                }
                if (this.mode == 2) {
                    this.maD.set(this.maC);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.maI;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.maJ;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.maD.postScale(S, S, this.maE.x, this.maE.y);
                    this.maD.postRotate(T, this.maE.x, this.maE.y);
                    this.maD.postTranslate(R.x - this.maE.x, R.y - this.maE.y);
                    this.maB.getMatrix().set(this.maD);
                } else if (this.mode == 1) {
                    this.maD.set(this.maC);
                    this.maD.postTranslate(motionEvent.getX() - this.lDf, motionEvent.getY() - this.lDg);
                    this.maB.getMatrix().set(this.maD);
                }
                if (!this.maG) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.maI = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.maJ = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.maE = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.maC.set(this.maB.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dpD(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.maB = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.maB = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lye = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.maF.FS(i);
    }
}
