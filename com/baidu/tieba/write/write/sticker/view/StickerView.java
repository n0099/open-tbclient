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
import com.baidu.tbadk.util.f;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long cHh;
    private float fcu;
    private float fcv;
    private boolean iST;
    private Matrix jvA;
    private Matrix jvB;
    private PointF jvC;
    private b jvD;
    private boolean jvE;
    private a jvF;
    private float jvG;
    private float jvH;
    private com.baidu.tieba.write.write.sticker.a jvz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.jvF = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvA = new Matrix();
        this.jvB = new Matrix();
        this.jvC = new PointF();
        this.jvE = true;
        this.iST = false;
        this.cHh = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jvD = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jvz.getMatrix().postTranslate((getWidth() - this.jvz.crM()) / 2, (getHeight() - this.jvz.crN()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jvz != null) {
            this.jvz.draw(canvas);
            float[] a = f.a(this.jvz.crO(), this.jvz.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.iST) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jvD.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fcu = motionEvent.getX();
                this.fcv = motionEvent.getY();
                if (this.jvz == null) {
                    return false;
                }
                if (this.iST && this.jvD.R(motionEvent)) {
                    this.jvE = false;
                    if (this.jvF != null) {
                        this.jvF.crP();
                        break;
                    }
                } else if (a(this.jvz, motionEvent)) {
                    this.jvE = true;
                    if (System.currentTimeMillis() - this.cHh <= 300 && this.jvF != null) {
                        this.jvF.a(this);
                        this.jvE = false;
                    }
                    this.cHh = System.currentTimeMillis();
                    this.mode = 1;
                    this.jvA.set(this.jvz.getMatrix());
                    break;
                } else {
                    this.jvE = false;
                    if (this.jvF == null) {
                        z = false;
                        break;
                    } else {
                        this.jvF.a(this, this.jvE);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jvC = null;
                if (this.jvF != null) {
                    if (this.jvE) {
                        this.jvF.b(this);
                    }
                    if (this.iST) {
                        this.jvE = false;
                    }
                    this.jvF.a(this, this.jvE);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jvE || motionEvent.getX() != this.fcu || motionEvent.getY() != this.fcv) {
                    this.jvE = false;
                }
                if (this.mode == 2) {
                    this.jvB.set(this.jvA);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.jvG;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.jvH;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.jvB.postScale(T, T, this.jvC.x, this.jvC.y);
                    this.jvB.postRotate(U, this.jvC.x, this.jvC.y);
                    this.jvB.postTranslate(S.x - this.jvC.x, S.y - this.jvC.y);
                    this.jvz.getMatrix().set(this.jvB);
                } else if (this.mode == 1) {
                    this.jvB.set(this.jvA);
                    this.jvB.postTranslate(motionEvent.getX() - this.fcu, motionEvent.getY() - this.fcv);
                    this.jvz.getMatrix().set(this.jvB);
                }
                if (!this.jvE) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jvG = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.jvH = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.jvC = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.jvA.set(this.jvz.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(f.a(aVar.crO(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jvz = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jvz = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.iST = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jvD.Bz(i);
    }
}
