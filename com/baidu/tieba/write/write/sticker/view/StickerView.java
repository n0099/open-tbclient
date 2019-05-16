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
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long cPq;
    private float fsI;
    private float fsJ;
    private a jOB;
    private Matrix jOC;
    private Matrix jOD;
    private PointF jOE;
    private b jOF;
    private boolean jOG;
    private com.baidu.tieba.write.write.sticker.a.a jOH;
    private float jOI;
    private float jOJ;
    private boolean jlN;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jOH = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOC = new Matrix();
        this.jOD = new Matrix();
        this.jOE = new PointF();
        this.jOG = true;
        this.jlN = false;
        this.cPq = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jOF = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jOB.getMatrix().postTranslate((getWidth() - this.jOB.czT()) / 2, (getHeight() - this.jOB.czU()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jOB != null) {
            this.jOB.draw(canvas);
            float[] a = f.a(this.jOB.czV(), this.jOB.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jlN) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jOF.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fsI = motionEvent.getX();
                this.fsJ = motionEvent.getY();
                if (this.jOB == null) {
                    return false;
                }
                if (this.jlN && this.jOF.U(motionEvent)) {
                    this.jOG = false;
                    if (this.jOH != null) {
                        this.jOH.czW();
                        break;
                    }
                } else if (a(this.jOB, motionEvent)) {
                    this.jOG = true;
                    if (System.currentTimeMillis() - this.cPq <= 300 && this.jOH != null) {
                        this.jOH.a(this);
                        this.jOG = false;
                    }
                    this.cPq = System.currentTimeMillis();
                    this.mode = 1;
                    this.jOC.set(this.jOB.getMatrix());
                    break;
                } else {
                    this.jOG = false;
                    if (this.jOH == null) {
                        z = false;
                        break;
                    } else {
                        this.jOH.a(this, this.jOG);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jOE = null;
                if (this.jOH != null) {
                    if (this.jOG) {
                        this.jOH.b(this);
                    }
                    if (this.jlN) {
                        this.jOG = false;
                    }
                    this.jOH.a(this, this.jOG);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jOG || motionEvent.getX() != this.fsI || motionEvent.getY() != this.fsJ) {
                    this.jOG = false;
                }
                if (this.mode == 2) {
                    this.jOD.set(this.jOC);
                    float W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent) / this.jOI;
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) - this.jOJ;
                    PointF V = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                    this.jOD.postScale(W, W, this.jOE.x, this.jOE.y);
                    this.jOD.postRotate(X, this.jOE.x, this.jOE.y);
                    this.jOD.postTranslate(V.x - this.jOE.x, V.y - this.jOE.y);
                    this.jOB.getMatrix().set(this.jOD);
                } else if (this.mode == 1) {
                    this.jOD.set(this.jOC);
                    this.jOD.postTranslate(motionEvent.getX() - this.fsI, motionEvent.getY() - this.fsJ);
                    this.jOB.getMatrix().set(this.jOD);
                }
                if (!this.jOG) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jOI = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jOJ = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jOE = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                this.jOC.set(this.jOB.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.czV(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jOB = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jOB = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jlN = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jOF.CI(i);
    }
}
