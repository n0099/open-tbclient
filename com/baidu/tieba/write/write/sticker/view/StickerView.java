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
    private long cHg;
    private float fcu;
    private float fcv;
    private boolean iSS;
    private Matrix jvA;
    private PointF jvB;
    private b jvC;
    private boolean jvD;
    private a jvE;
    private float jvF;
    private float jvG;
    private com.baidu.tieba.write.write.sticker.a jvy;
    private Matrix jvz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.jvE = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvz = new Matrix();
        this.jvA = new Matrix();
        this.jvB = new PointF();
        this.jvD = true;
        this.iSS = false;
        this.cHg = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jvC = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jvy.getMatrix().postTranslate((getWidth() - this.jvy.crM()) / 2, (getHeight() - this.jvy.crN()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jvy != null) {
            this.jvy.draw(canvas);
            float[] a = f.a(this.jvy.crO(), this.jvy.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.iSS) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jvC.draw(canvas, f3, f4);
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
                if (this.jvy == null) {
                    return false;
                }
                if (this.iSS && this.jvC.R(motionEvent)) {
                    this.jvD = false;
                    if (this.jvE != null) {
                        this.jvE.crP();
                        break;
                    }
                } else if (a(this.jvy, motionEvent)) {
                    this.jvD = true;
                    if (System.currentTimeMillis() - this.cHg <= 300 && this.jvE != null) {
                        this.jvE.a(this);
                        this.jvD = false;
                    }
                    this.cHg = System.currentTimeMillis();
                    this.mode = 1;
                    this.jvz.set(this.jvy.getMatrix());
                    break;
                } else {
                    this.jvD = false;
                    if (this.jvE == null) {
                        z = false;
                        break;
                    } else {
                        this.jvE.a(this, this.jvD);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jvB = null;
                if (this.jvE != null) {
                    if (this.jvD) {
                        this.jvE.b(this);
                    }
                    if (this.iSS) {
                        this.jvD = false;
                    }
                    this.jvE.a(this, this.jvD);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jvD || motionEvent.getX() != this.fcu || motionEvent.getY() != this.fcv) {
                    this.jvD = false;
                }
                if (this.mode == 2) {
                    this.jvA.set(this.jvz);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.jvF;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.jvG;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.jvA.postScale(T, T, this.jvB.x, this.jvB.y);
                    this.jvA.postRotate(U, this.jvB.x, this.jvB.y);
                    this.jvA.postTranslate(S.x - this.jvB.x, S.y - this.jvB.y);
                    this.jvy.getMatrix().set(this.jvA);
                } else if (this.mode == 1) {
                    this.jvA.set(this.jvz);
                    this.jvA.postTranslate(motionEvent.getX() - this.fcu, motionEvent.getY() - this.fcv);
                    this.jvy.getMatrix().set(this.jvA);
                }
                if (!this.jvD) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jvF = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.jvG = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.jvB = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.jvz.set(this.jvy.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(f.a(aVar.crO(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jvy = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jvy = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.iSS = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jvC.Bz(i);
    }
}
