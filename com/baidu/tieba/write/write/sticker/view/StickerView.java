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
    private long bgZ;
    private boolean gZW;
    private a hBM;
    private Matrix hBN;
    private Matrix hBO;
    private PointF hBP;
    private b hBQ;
    private boolean hBR;
    private com.baidu.tieba.write.write.sticker.a.a hBS;
    private float hBT;
    private float hBU;
    private float hfo;
    private float hfp;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hBS = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hBN = new Matrix();
        this.hBO = new Matrix();
        this.hBP = new PointF();
        this.hBR = true;
        this.gZW = false;
        this.bgZ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hBQ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.f(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hBM.getMatrix().postTranslate((getWidth() - this.hBM.bIJ()) / 2, (getHeight() - this.hBM.bIK()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hBM != null) {
            this.hBM.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hBM.bIL(), this.hBM.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gZW) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hBQ.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hfo = motionEvent.getX();
                this.hfp = motionEvent.getY();
                if (this.hBM == null) {
                    return false;
                }
                if (this.gZW && this.hBQ.R(motionEvent)) {
                    this.hBR = false;
                    if (this.hBS != null) {
                        this.hBS.bIM();
                        break;
                    }
                } else if (a(this.hBM, motionEvent)) {
                    this.hBR = true;
                    if (System.currentTimeMillis() - this.bgZ <= 300 && this.hBS != null) {
                        this.hBS.a(this);
                        this.hBR = false;
                    }
                    this.bgZ = System.currentTimeMillis();
                    this.mode = 1;
                    this.hBN.set(this.hBM.getMatrix());
                    break;
                } else {
                    this.hBR = false;
                    if (this.hBS == null) {
                        z = false;
                        break;
                    } else {
                        this.hBS.a(this, this.hBR);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hBP = null;
                if (this.hBS != null) {
                    if (this.hBR) {
                        this.hBS.b(this);
                    }
                    if (this.gZW) {
                        this.hBR = false;
                    }
                    this.hBS.a(this, this.hBR);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hBR || motionEvent.getX() != this.hfo || motionEvent.getY() != this.hfp) {
                    this.hBR = false;
                }
                if (this.mode == 2) {
                    this.hBO.set(this.hBN);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hBT;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hBU;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hBO.postScale(T, T, this.hBP.x, this.hBP.y);
                    this.hBO.postRotate(U, this.hBP.x, this.hBP.y);
                    this.hBO.postTranslate(S.x - this.hBP.x, S.y - this.hBP.y);
                    this.hBM.getMatrix().set(this.hBO);
                } else if (this.mode == 1) {
                    this.hBO.set(this.hBN);
                    this.hBO.postTranslate(motionEvent.getX() - this.hfo, motionEvent.getY() - this.hfp);
                    this.hBM.getMatrix().set(this.hBO);
                }
                if (!this.hBR) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hBT = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hBU = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hBP = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hBN.set(this.hBM.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bIL(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hBM = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hBM = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gZW = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hBQ.vL(i);
    }
}
