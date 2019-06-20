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
    private long cPr;
    private float fsJ;
    private float fsK;
    private a jOF;
    private Matrix jOG;
    private Matrix jOH;
    private PointF jOI;
    private b jOJ;
    private boolean jOK;
    private com.baidu.tieba.write.write.sticker.a.a jOL;
    private float jOM;
    private float jON;
    private boolean jlS;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jOL = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOG = new Matrix();
        this.jOH = new Matrix();
        this.jOI = new PointF();
        this.jOK = true;
        this.jlS = false;
        this.cPr = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jOJ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jOF.getMatrix().postTranslate((getWidth() - this.jOF.czU()) / 2, (getHeight() - this.jOF.czV()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jOF != null) {
            this.jOF.draw(canvas);
            float[] a = f.a(this.jOF.czW(), this.jOF.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jlS) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jOJ.draw(canvas, f3, f4);
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
                if (this.jOF == null) {
                    return false;
                }
                if (this.jlS && this.jOJ.U(motionEvent)) {
                    this.jOK = false;
                    if (this.jOL != null) {
                        this.jOL.czX();
                        break;
                    }
                } else if (a(this.jOF, motionEvent)) {
                    this.jOK = true;
                    if (System.currentTimeMillis() - this.cPr <= 300 && this.jOL != null) {
                        this.jOL.a(this);
                        this.jOK = false;
                    }
                    this.cPr = System.currentTimeMillis();
                    this.mode = 1;
                    this.jOG.set(this.jOF.getMatrix());
                    break;
                } else {
                    this.jOK = false;
                    if (this.jOL == null) {
                        z = false;
                        break;
                    } else {
                        this.jOL.a(this, this.jOK);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jOI = null;
                if (this.jOL != null) {
                    if (this.jOK) {
                        this.jOL.b(this);
                    }
                    if (this.jlS) {
                        this.jOK = false;
                    }
                    this.jOL.a(this, this.jOK);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jOK || motionEvent.getX() != this.fsJ || motionEvent.getY() != this.fsK) {
                    this.jOK = false;
                }
                if (this.mode == 2) {
                    this.jOH.set(this.jOG);
                    float W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent) / this.jOM;
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) - this.jON;
                    PointF V = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                    this.jOH.postScale(W, W, this.jOI.x, this.jOI.y);
                    this.jOH.postRotate(X, this.jOI.x, this.jOI.y);
                    this.jOH.postTranslate(V.x - this.jOI.x, V.y - this.jOI.y);
                    this.jOF.getMatrix().set(this.jOH);
                } else if (this.mode == 1) {
                    this.jOH.set(this.jOG);
                    this.jOH.postTranslate(motionEvent.getX() - this.fsJ, motionEvent.getY() - this.fsK);
                    this.jOF.getMatrix().set(this.jOH);
                }
                if (!this.jOK) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jOM = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jON = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jOI = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                this.jOG.set(this.jOF.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.czW(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jOF = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jOF = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jlS = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jOJ.CI(i);
    }
}
