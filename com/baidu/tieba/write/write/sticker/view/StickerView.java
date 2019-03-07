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
    private float fcI;
    private float fcJ;
    private boolean iSS;
    private PointF jvA;
    private b jvB;
    private boolean jvC;
    private a jvD;
    private float jvE;
    private float jvF;
    private com.baidu.tieba.write.write.sticker.a jvx;
    private Matrix jvy;
    private Matrix jvz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.jvD = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvy = new Matrix();
        this.jvz = new Matrix();
        this.jvA = new PointF();
        this.jvC = true;
        this.iSS = false;
        this.cHh = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jvB = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jvx.getMatrix().postTranslate((getWidth() - this.jvx.crB()) / 2, (getHeight() - this.jvx.crC()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jvx != null) {
            this.jvx.draw(canvas);
            float[] a = f.a(this.jvx.crD(), this.jvx.getMatrix());
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
                this.jvB.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fcI = motionEvent.getX();
                this.fcJ = motionEvent.getY();
                if (this.jvx == null) {
                    return false;
                }
                if (this.iSS && this.jvB.R(motionEvent)) {
                    this.jvC = false;
                    if (this.jvD != null) {
                        this.jvD.crE();
                        break;
                    }
                } else if (a(this.jvx, motionEvent)) {
                    this.jvC = true;
                    if (System.currentTimeMillis() - this.cHh <= 300 && this.jvD != null) {
                        this.jvD.a(this);
                        this.jvC = false;
                    }
                    this.cHh = System.currentTimeMillis();
                    this.mode = 1;
                    this.jvy.set(this.jvx.getMatrix());
                    break;
                } else {
                    this.jvC = false;
                    if (this.jvD == null) {
                        z = false;
                        break;
                    } else {
                        this.jvD.a(this, this.jvC);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jvA = null;
                if (this.jvD != null) {
                    if (this.jvC) {
                        this.jvD.b(this);
                    }
                    if (this.iSS) {
                        this.jvC = false;
                    }
                    this.jvD.a(this, this.jvC);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jvC || motionEvent.getX() != this.fcI || motionEvent.getY() != this.fcJ) {
                    this.jvC = false;
                }
                if (this.mode == 2) {
                    this.jvz.set(this.jvy);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.jvE;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.jvF;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.jvz.postScale(T, T, this.jvA.x, this.jvA.y);
                    this.jvz.postRotate(U, this.jvA.x, this.jvA.y);
                    this.jvz.postTranslate(S.x - this.jvA.x, S.y - this.jvA.y);
                    this.jvx.getMatrix().set(this.jvz);
                } else if (this.mode == 1) {
                    this.jvz.set(this.jvy);
                    this.jvz.postTranslate(motionEvent.getX() - this.fcI, motionEvent.getY() - this.fcJ);
                    this.jvx.getMatrix().set(this.jvz);
                }
                if (!this.jvC) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jvE = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.jvF = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.jvA = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.jvy.set(this.jvx.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(f.a(aVar.crD(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jvx = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jvx = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.iSS = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jvB.BC(i);
    }
}
