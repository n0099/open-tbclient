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
    private long bmS;
    private float dvG;
    private float dvH;
    private a hKl;
    private Matrix hKm;
    private Matrix hKn;
    private PointF hKo;
    private b hKp;
    private boolean hKq;
    private com.baidu.tieba.write.write.sticker.a.a hKr;
    private float hKs;
    private float hKt;
    private boolean hhP;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hKr = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hKm = new Matrix();
        this.hKn = new Matrix();
        this.hKo = new PointF();
        this.hKq = true;
        this.hhP = false;
        this.bmS = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hKp = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0141e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hKl.getMatrix().postTranslate((getWidth() - this.hKl.bLE()) / 2, (getHeight() - this.hKl.bLF()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hKl != null) {
            this.hKl.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.hKl.bLG(), this.hKl.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hhP) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hKp.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dvG = motionEvent.getX();
                this.dvH = motionEvent.getY();
                if (this.hKl == null) {
                    return false;
                }
                if (this.hhP && this.hKp.R(motionEvent)) {
                    this.hKq = false;
                    if (this.hKr != null) {
                        this.hKr.bLH();
                        break;
                    }
                } else if (a(this.hKl, motionEvent)) {
                    this.hKq = true;
                    if (System.currentTimeMillis() - this.bmS <= 300 && this.hKr != null) {
                        this.hKr.a(this);
                        this.hKq = false;
                    }
                    this.bmS = System.currentTimeMillis();
                    this.mode = 1;
                    this.hKm.set(this.hKl.getMatrix());
                    break;
                } else {
                    this.hKq = false;
                    if (this.hKr == null) {
                        z = false;
                        break;
                    } else {
                        this.hKr.a(this, this.hKq);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hKo = null;
                if (this.hKr != null) {
                    if (this.hKq) {
                        this.hKr.b(this);
                    }
                    if (this.hhP) {
                        this.hKq = false;
                    }
                    this.hKr.a(this, this.hKq);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hKq || motionEvent.getX() != this.dvG || motionEvent.getY() != this.dvH) {
                    this.hKq = false;
                }
                if (this.mode == 2) {
                    this.hKn.set(this.hKm);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hKs;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hKt;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hKn.postScale(T, T, this.hKo.x, this.hKo.y);
                    this.hKn.postRotate(U, this.hKo.x, this.hKo.y);
                    this.hKn.postTranslate(S.x - this.hKo.x, S.y - this.hKo.y);
                    this.hKl.getMatrix().set(this.hKn);
                } else if (this.mode == 1) {
                    this.hKn.set(this.hKm);
                    this.hKn.postTranslate(motionEvent.getX() - this.dvG, motionEvent.getY() - this.dvH);
                    this.hKl.getMatrix().set(this.hKn);
                }
                if (!this.hKq) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hKs = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hKt = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hKo = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hKm.set(this.hKl.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bLG(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hKl = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hKl = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hhP = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hKp.wl(i);
    }
}
