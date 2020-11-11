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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private float bmg;
    private float bmh;
    private long fMB;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a nPP;
    private Matrix nPQ;
    private Matrix nPR;
    private PointF nPS;
    private b nPT;
    private boolean nPU;
    private com.baidu.tieba.write.write.sticker.a.a nPV;
    private float nPW;
    private float nPX;
    private boolean nkd;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.nPV = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPQ = new Matrix();
        this.nPR = new Matrix();
        this.nPS = new PointF();
        this.nPU = true;
        this.nkd = false;
        this.fMB = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.nPT = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.nPP.getMatrix().postTranslate((getWidth() - this.nPP.dWQ()) / 2, (getHeight() - this.nPP.dWR()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nPP != null) {
            this.nPP.draw(canvas);
            float[] a2 = h.a(this.nPP.dWS(), this.nPP.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.nkd) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.nPT.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bmg = motionEvent.getX();
                this.bmh = motionEvent.getY();
                if (this.nPP == null) {
                    return false;
                }
                if (this.nkd && this.nPT.ak(motionEvent)) {
                    this.nPU = false;
                    if (this.nPV != null) {
                        this.nPV.cLf();
                        break;
                    }
                } else if (a(this.nPP, motionEvent)) {
                    this.nPU = true;
                    if (System.currentTimeMillis() - this.fMB <= 300 && this.nPV != null) {
                        this.nPV.a(this);
                        this.nPU = false;
                    }
                    this.fMB = System.currentTimeMillis();
                    this.mode = 1;
                    this.nPQ.set(this.nPP.getMatrix());
                    break;
                } else {
                    this.nPU = false;
                    if (this.nPV == null) {
                        z = false;
                        break;
                    } else {
                        this.nPV.a(this, this.nPU);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.nPS = null;
                if (this.nPV != null) {
                    if (this.nPU) {
                        this.nPV.b(this);
                    }
                    if (this.nkd) {
                        this.nPU = false;
                    }
                    this.nPV.a(this, this.nPU);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.nPU || motionEvent.getX() != this.bmg || motionEvent.getY() != this.bmh) {
                    this.nPU = false;
                }
                if (this.mode == 2) {
                    this.nPR.set(this.nPQ);
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) / this.nPW;
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) - this.nPX;
                    PointF al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                    this.nPR.postScale(am, am, this.nPS.x, this.nPS.y);
                    this.nPR.postRotate(an, this.nPS.x, this.nPS.y);
                    this.nPR.postTranslate(al.x - this.nPS.x, al.y - this.nPS.y);
                    this.nPP.getMatrix().set(this.nPR);
                } else if (this.mode == 1) {
                    this.nPR.set(this.nPQ);
                    this.nPR.postTranslate(motionEvent.getX() - this.bmg, motionEvent.getY() - this.bmh);
                    this.nPP.getMatrix().set(this.nPR);
                }
                if (!this.nPU) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.nPW = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.nPX = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.nPS = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.nPQ.set(this.nPP.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dWS(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.nPP = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.nPP = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.nkd = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.nPT.LK(i);
    }
}
