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
    private long bvW;
    private float dOT;
    private float dOU;
    private boolean hCw;
    private a ieM;
    private Matrix ieN;
    private Matrix ieO;
    private PointF ieP;
    private b ieQ;
    private boolean ieR;
    private com.baidu.tieba.write.write.sticker.a.a ieS;
    private float ieT;
    private float ieU;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.ieS = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieN = new Matrix();
        this.ieO = new Matrix();
        this.ieP = new PointF();
        this.ieR = true;
        this.hCw = false;
        this.bvW = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ieQ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0210e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ieM.getMatrix().postTranslate((getWidth() - this.ieM.bRS()) / 2, (getHeight() - this.ieM.bRT()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ieM != null) {
            this.ieM.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.ieM.bRU(), this.ieM.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hCw) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.ieQ.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dOT = motionEvent.getX();
                this.dOU = motionEvent.getY();
                if (this.ieM == null) {
                    return false;
                }
                if (this.hCw && this.ieQ.Q(motionEvent)) {
                    this.ieR = false;
                    if (this.ieS != null) {
                        this.ieS.bRV();
                        break;
                    }
                } else if (a(this.ieM, motionEvent)) {
                    this.ieR = true;
                    if (System.currentTimeMillis() - this.bvW <= 300 && this.ieS != null) {
                        this.ieS.a(this);
                        this.ieR = false;
                    }
                    this.bvW = System.currentTimeMillis();
                    this.mode = 1;
                    this.ieN.set(this.ieM.getMatrix());
                    break;
                } else {
                    this.ieR = false;
                    if (this.ieS == null) {
                        z = false;
                        break;
                    } else {
                        this.ieS.a(this, this.ieR);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.ieP = null;
                if (this.ieS != null) {
                    if (this.ieR) {
                        this.ieS.b(this);
                    }
                    if (this.hCw) {
                        this.ieR = false;
                    }
                    this.ieS.a(this, this.ieR);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.ieR || motionEvent.getX() != this.dOT || motionEvent.getY() != this.dOU) {
                    this.ieR = false;
                }
                if (this.mode == 2) {
                    this.ieO.set(this.ieN);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.ieT;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.ieU;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.ieO.postScale(S, S, this.ieP.x, this.ieP.y);
                    this.ieO.postRotate(T, this.ieP.x, this.ieP.y);
                    this.ieO.postTranslate(R.x - this.ieP.x, R.y - this.ieP.y);
                    this.ieM.getMatrix().set(this.ieO);
                } else if (this.mode == 1) {
                    this.ieO.set(this.ieN);
                    this.ieO.postTranslate(motionEvent.getX() - this.dOT, motionEvent.getY() - this.dOU);
                    this.ieM.getMatrix().set(this.ieO);
                }
                if (!this.ieR) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.ieT = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.ieU = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.ieP = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.ieN.set(this.ieM.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bRU(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ieM = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ieM = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hCw = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.ieQ.xN(i);
    }
}
