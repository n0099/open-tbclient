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
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long bvX;
    private float dOU;
    private float dOV;
    private boolean hCx;
    private a ieN;
    private Matrix ieO;
    private Matrix ieP;
    private PointF ieQ;
    private b ieR;
    private boolean ieS;
    private com.baidu.tieba.write.write.sticker.a.a ieT;
    private float ieU;
    private float ieV;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.ieT = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieO = new Matrix();
        this.ieP = new Matrix();
        this.ieQ = new PointF();
        this.ieS = true;
        this.hCx = false;
        this.bvX = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ieR = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0210e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ieN.getMatrix().postTranslate((getWidth() - this.ieN.bRS()) / 2, (getHeight() - this.ieN.bRT()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ieN != null) {
            this.ieN.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.ieN.bRU(), this.ieN.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hCx) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.ieR.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dOU = motionEvent.getX();
                this.dOV = motionEvent.getY();
                if (this.ieN == null) {
                    return false;
                }
                if (this.hCx && this.ieR.Q(motionEvent)) {
                    this.ieS = false;
                    if (this.ieT != null) {
                        this.ieT.bRV();
                        break;
                    }
                } else if (a(this.ieN, motionEvent)) {
                    this.ieS = true;
                    if (System.currentTimeMillis() - this.bvX <= 300 && this.ieT != null) {
                        this.ieT.a(this);
                        this.ieS = false;
                    }
                    this.bvX = System.currentTimeMillis();
                    this.mode = 1;
                    this.ieO.set(this.ieN.getMatrix());
                    break;
                } else {
                    this.ieS = false;
                    if (this.ieT == null) {
                        z = false;
                        break;
                    } else {
                        this.ieT.a(this, this.ieS);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.ieQ = null;
                if (this.ieT != null) {
                    if (this.ieS) {
                        this.ieT.b(this);
                    }
                    if (this.hCx) {
                        this.ieS = false;
                    }
                    this.ieT.a(this, this.ieS);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.ieS || motionEvent.getX() != this.dOU || motionEvent.getY() != this.dOV) {
                    this.ieS = false;
                }
                if (this.mode == 2) {
                    this.ieP.set(this.ieO);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.ieU;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.ieV;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.ieP.postScale(S, S, this.ieQ.x, this.ieQ.y);
                    this.ieP.postRotate(T, this.ieQ.x, this.ieQ.y);
                    this.ieP.postTranslate(R.x - this.ieQ.x, R.y - this.ieQ.y);
                    this.ieN.getMatrix().set(this.ieP);
                } else if (this.mode == 1) {
                    this.ieP.set(this.ieO);
                    this.ieP.postTranslate(motionEvent.getX() - this.dOU, motionEvent.getY() - this.dOV);
                    this.ieN.getMatrix().set(this.ieP);
                }
                if (!this.ieS) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.ieU = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.ieV = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.ieQ = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.ieO.set(this.ieN.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bRU(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ieN = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ieN = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hCx = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.ieR.xN(i);
    }
}
