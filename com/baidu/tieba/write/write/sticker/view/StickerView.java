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
import com.baidu.tbadk.util.d;
import com.baidu.tieba.f;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long bha;
    private boolean gZY;
    private a hBO;
    private Matrix hBP;
    private Matrix hBQ;
    private PointF hBR;
    private b hBS;
    private boolean hBT;
    private com.baidu.tieba.write.write.sticker.a.a hBU;
    private float hBV;
    private float hBW;
    private float hfp;
    private float hfq;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hBU = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hBP = new Matrix();
        this.hBQ = new Matrix();
        this.hBR = new PointF();
        this.hBT = true;
        this.gZY = false;
        this.bha = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hBS = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.f(context, f.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hBO.getMatrix().postTranslate((getWidth() - this.hBO.bIN()) / 2, (getHeight() - this.hBO.bIO()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hBO != null) {
            this.hBO.draw(canvas);
            float[] a = d.a(this.hBO.bIP(), this.hBO.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gZY) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hBS.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hfp = motionEvent.getX();
                this.hfq = motionEvent.getY();
                if (this.hBO == null) {
                    return false;
                }
                if (this.gZY && this.hBS.R(motionEvent)) {
                    this.hBT = false;
                    if (this.hBU != null) {
                        this.hBU.bIQ();
                        break;
                    }
                } else if (a(this.hBO, motionEvent)) {
                    this.hBT = true;
                    if (System.currentTimeMillis() - this.bha <= 300 && this.hBU != null) {
                        this.hBU.a(this);
                        this.hBT = false;
                    }
                    this.bha = System.currentTimeMillis();
                    this.mode = 1;
                    this.hBP.set(this.hBO.getMatrix());
                    break;
                } else {
                    this.hBT = false;
                    if (this.hBU == null) {
                        z = false;
                        break;
                    } else {
                        this.hBU.a(this, this.hBT);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hBR = null;
                if (this.hBU != null) {
                    if (this.hBT) {
                        this.hBU.b(this);
                    }
                    if (this.gZY) {
                        this.hBT = false;
                    }
                    this.hBU.a(this, this.hBT);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hBT || motionEvent.getX() != this.hfp || motionEvent.getY() != this.hfq) {
                    this.hBT = false;
                }
                if (this.mode == 2) {
                    this.hBQ.set(this.hBP);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hBV;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hBW;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hBQ.postScale(T, T, this.hBR.x, this.hBR.y);
                    this.hBQ.postRotate(U, this.hBR.x, this.hBR.y);
                    this.hBQ.postTranslate(S.x - this.hBR.x, S.y - this.hBR.y);
                    this.hBO.getMatrix().set(this.hBQ);
                } else if (this.mode == 1) {
                    this.hBQ.set(this.hBP);
                    this.hBQ.postTranslate(motionEvent.getX() - this.hfp, motionEvent.getY() - this.hfq);
                    this.hBO.getMatrix().set(this.hBQ);
                }
                if (!this.hBT) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hBV = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hBW = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hBR = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hBP.set(this.hBO.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(d.a(aVar.bIP(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hBO = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hBO = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gZY = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hBS.vL(i);
    }
}
