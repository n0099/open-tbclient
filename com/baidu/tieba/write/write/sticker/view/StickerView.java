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
    private long brG;
    private float dEX;
    private float dEY;
    private a hTi;
    private Matrix hTj;
    private Matrix hTk;
    private PointF hTl;
    private b hTm;
    private boolean hTn;
    private com.baidu.tieba.write.write.sticker.a.a hTo;
    private float hTp;
    private float hTq;
    private boolean hqR;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hTo = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTj = new Matrix();
        this.hTk = new Matrix();
        this.hTl = new PointF();
        this.hTn = true;
        this.hqR = false;
        this.brG = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hTm = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0200e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hTi.getMatrix().postTranslate((getWidth() - this.hTi.bOo()) / 2, (getHeight() - this.hTi.bOp()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hTi != null) {
            this.hTi.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.hTi.bOq(), this.hTi.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hqR) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hTm.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dEX = motionEvent.getX();
                this.dEY = motionEvent.getY();
                if (this.hTi == null) {
                    return false;
                }
                if (this.hqR && this.hTm.R(motionEvent)) {
                    this.hTn = false;
                    if (this.hTo != null) {
                        this.hTo.bOr();
                        break;
                    }
                } else if (a(this.hTi, motionEvent)) {
                    this.hTn = true;
                    if (System.currentTimeMillis() - this.brG <= 300 && this.hTo != null) {
                        this.hTo.a(this);
                        this.hTn = false;
                    }
                    this.brG = System.currentTimeMillis();
                    this.mode = 1;
                    this.hTj.set(this.hTi.getMatrix());
                    break;
                } else {
                    this.hTn = false;
                    if (this.hTo == null) {
                        z = false;
                        break;
                    } else {
                        this.hTo.a(this, this.hTn);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hTl = null;
                if (this.hTo != null) {
                    if (this.hTn) {
                        this.hTo.b(this);
                    }
                    if (this.hqR) {
                        this.hTn = false;
                    }
                    this.hTo.a(this, this.hTn);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hTn || motionEvent.getX() != this.dEX || motionEvent.getY() != this.dEY) {
                    this.hTn = false;
                }
                if (this.mode == 2) {
                    this.hTk.set(this.hTj);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hTp;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hTq;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hTk.postScale(T, T, this.hTl.x, this.hTl.y);
                    this.hTk.postRotate(U, this.hTl.x, this.hTl.y);
                    this.hTk.postTranslate(S.x - this.hTl.x, S.y - this.hTl.y);
                    this.hTi.getMatrix().set(this.hTk);
                } else if (this.mode == 1) {
                    this.hTk.set(this.hTj);
                    this.hTk.postTranslate(motionEvent.getX() - this.dEX, motionEvent.getY() - this.dEY);
                    this.hTi.getMatrix().set(this.hTk);
                }
                if (!this.hTn) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hTp = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hTq = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hTl = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hTj.set(this.hTi.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bOq(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hTi = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hTi = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hqR = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hTm.xb(i);
    }
}
