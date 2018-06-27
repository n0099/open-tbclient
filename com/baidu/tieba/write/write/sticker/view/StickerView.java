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
    private boolean gYY;
    private a hAE;
    private Matrix hAF;
    private Matrix hAG;
    private PointF hAH;
    private b hAI;
    private boolean hAJ;
    private com.baidu.tieba.write.write.sticker.a.a hAK;
    private float hAL;
    private float hAM;
    private float hea;
    private float heb;
    private long hmQ;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hAK = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAF = new Matrix();
        this.hAG = new Matrix();
        this.hAH = new PointF();
        this.hAJ = true;
        this.gYY = false;
        this.hmQ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hAI = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.e(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hAE.getMatrix().postTranslate((getWidth() - this.hAE.bJW()) / 2, (getHeight() - this.hAE.bJX()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hAE != null) {
            this.hAE.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hAE.bJY(), this.hAE.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gYY) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hAI.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.hea = motionEvent.getX();
                this.heb = motionEvent.getY();
                if (this.hAE == null) {
                    return false;
                }
                if (this.gYY && this.hAI.R(motionEvent)) {
                    this.hAJ = false;
                    if (this.hAK != null) {
                        this.hAK.bJZ();
                        break;
                    }
                } else if (a(this.hAE, motionEvent)) {
                    this.hAJ = true;
                    if (System.currentTimeMillis() - this.hmQ <= 300 && this.hAK != null) {
                        this.hAK.a(this);
                        this.hAJ = false;
                    }
                    this.hmQ = System.currentTimeMillis();
                    this.mode = 1;
                    this.hAF.set(this.hAE.getMatrix());
                    break;
                } else {
                    this.hAJ = false;
                    if (this.hAK == null) {
                        z = false;
                        break;
                    } else {
                        this.hAK.a(this, this.hAJ);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hAH = null;
                if (this.hAK != null) {
                    if (this.hAJ) {
                        this.hAK.b(this);
                    }
                    if (this.gYY) {
                        this.hAJ = false;
                    }
                    this.hAK.a(this, this.hAJ);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hAJ || motionEvent.getX() != this.hea || motionEvent.getY() != this.heb) {
                    this.hAJ = false;
                }
                if (this.mode == 2) {
                    this.hAG.set(this.hAF);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hAL;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hAM;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hAG.postScale(T, T, this.hAH.x, this.hAH.y);
                    this.hAG.postRotate(U, this.hAH.x, this.hAH.y);
                    this.hAG.postTranslate(S.x - this.hAH.x, S.y - this.hAH.y);
                    this.hAE.getMatrix().set(this.hAG);
                } else if (this.mode == 1) {
                    this.hAG.set(this.hAF);
                    this.hAG.postTranslate(motionEvent.getX() - this.hea, motionEvent.getY() - this.heb);
                    this.hAE.getMatrix().set(this.hAG);
                }
                if (!this.hAJ) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hAL = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hAM = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hAH = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hAF.set(this.hAE.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bJY(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hAE = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hAE = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gYY = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hAI.vM(i);
    }
}
