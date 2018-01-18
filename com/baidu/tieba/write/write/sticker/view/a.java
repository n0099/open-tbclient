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
    private com.baidu.tieba.write.write.sticker.a hLI;
    private Matrix hLJ;
    private Matrix hLK;
    private PointF hLL;
    private b hLM;
    private boolean hLN;
    private com.baidu.tieba.write.write.sticker.a.a hLO;
    private float hLP;
    private float hLQ;
    private boolean hjA;
    private float hpR;
    private float hpS;
    private long hye;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hLO = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLJ = new Matrix();
        this.hLK = new Matrix();
        this.hLL = new PointF();
        this.hLN = true;
        this.hjA = false;
        this.hye = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hLM = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.s(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hLI.getMatrix().postTranslate((getWidth() - this.hLI.bIM()) / 2, (getHeight() - this.hLI.bIN()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hLI != null) {
            this.hLI.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hLI.bIO(), this.hLI.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hjA) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hLM.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hpR = motionEvent.getX();
                this.hpS = motionEvent.getY();
                if (this.hLI == null) {
                    return false;
                }
                if (this.hjA && this.hLM.R(motionEvent)) {
                    this.hLN = false;
                    if (this.hLO != null) {
                        this.hLO.bIP();
                        break;
                    }
                } else if (a(this.hLI, motionEvent)) {
                    this.hLN = true;
                    if (System.currentTimeMillis() - this.hye <= 300 && this.hLO != null) {
                        this.hLO.a(this);
                        this.hLN = false;
                    }
                    this.hye = System.currentTimeMillis();
                    this.mode = 1;
                    this.hLJ.set(this.hLI.getMatrix());
                    break;
                } else {
                    this.hLN = false;
                    if (this.hLO == null) {
                        z = false;
                        break;
                    } else {
                        this.hLO.a(this, this.hLN);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hLL = null;
                if (this.hLO != null) {
                    if (this.hLN) {
                        this.hLO.b(this);
                    }
                    if (this.hjA) {
                        this.hLN = false;
                    }
                    this.hLO.a(this, this.hLN);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hLN || motionEvent.getX() != this.hpR || motionEvent.getY() != this.hpS) {
                    this.hLN = false;
                }
                if (this.mode == 2) {
                    this.hLK.set(this.hLJ);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hLP;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hLQ;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hLK.postScale(T, T, this.hLL.x, this.hLL.y);
                    this.hLK.postRotate(U, this.hLL.x, this.hLL.y);
                    this.hLK.postTranslate(S.x - this.hLL.x, S.y - this.hLL.y);
                    this.hLI.getMatrix().set(this.hLK);
                } else if (this.mode == 1) {
                    this.hLK.set(this.hLJ);
                    this.hLK.postTranslate(motionEvent.getX() - this.hpR, motionEvent.getY() - this.hpS);
                    this.hLI.getMatrix().set(this.hLK);
                }
                if (!this.hLN) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hLP = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hLQ = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hLL = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hLJ.set(this.hLI.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bIO(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hLI = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hLI;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hLI = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hjA = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hLM.xQ(i);
    }
}
