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
    private float fsJ;
    private float fsK;
    private a jOC;
    private Matrix jOD;
    private Matrix jOE;
    private PointF jOF;
    private b jOG;
    private boolean jOH;
    private com.baidu.tieba.write.write.sticker.a.a jOI;
    private float jOJ;
    private float jOK;
    private boolean jlO;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jOI = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOD = new Matrix();
        this.jOE = new Matrix();
        this.jOF = new PointF();
        this.jOH = true;
        this.jlO = false;
        this.cPq = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jOG = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jOC.getMatrix().postTranslate((getWidth() - this.jOC.czV()) / 2, (getHeight() - this.jOC.czW()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jOC != null) {
            this.jOC.draw(canvas);
            float[] a = f.a(this.jOC.czX(), this.jOC.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jlO) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jOG.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fsJ = motionEvent.getX();
                this.fsK = motionEvent.getY();
                if (this.jOC == null) {
                    return false;
                }
                if (this.jlO && this.jOG.U(motionEvent)) {
                    this.jOH = false;
                    if (this.jOI != null) {
                        this.jOI.czY();
                        break;
                    }
                } else if (a(this.jOC, motionEvent)) {
                    this.jOH = true;
                    if (System.currentTimeMillis() - this.cPq <= 300 && this.jOI != null) {
                        this.jOI.a(this);
                        this.jOH = false;
                    }
                    this.cPq = System.currentTimeMillis();
                    this.mode = 1;
                    this.jOD.set(this.jOC.getMatrix());
                    break;
                } else {
                    this.jOH = false;
                    if (this.jOI == null) {
                        z = false;
                        break;
                    } else {
                        this.jOI.a(this, this.jOH);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jOF = null;
                if (this.jOI != null) {
                    if (this.jOH) {
                        this.jOI.b(this);
                    }
                    if (this.jlO) {
                        this.jOH = false;
                    }
                    this.jOI.a(this, this.jOH);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jOH || motionEvent.getX() != this.fsJ || motionEvent.getY() != this.fsK) {
                    this.jOH = false;
                }
                if (this.mode == 2) {
                    this.jOE.set(this.jOD);
                    float W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent) / this.jOJ;
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) - this.jOK;
                    PointF V = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                    this.jOE.postScale(W, W, this.jOF.x, this.jOF.y);
                    this.jOE.postRotate(X, this.jOF.x, this.jOF.y);
                    this.jOE.postTranslate(V.x - this.jOF.x, V.y - this.jOF.y);
                    this.jOC.getMatrix().set(this.jOE);
                } else if (this.mode == 1) {
                    this.jOE.set(this.jOD);
                    this.jOE.postTranslate(motionEvent.getX() - this.fsJ, motionEvent.getY() - this.fsK);
                    this.jOC.getMatrix().set(this.jOE);
                }
                if (!this.jOH) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jOJ = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jOK = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jOF = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                this.jOD.set(this.jOC.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.czX(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jOC = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jOC = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jlO = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jOG.CI(i);
    }
}
