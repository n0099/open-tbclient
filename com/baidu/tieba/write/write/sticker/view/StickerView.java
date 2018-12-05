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
    private long bvf;
    private float dLw;
    private float dLx;
    private boolean hyd;
    private float iaA;
    private a ias;
    private Matrix iat;
    private Matrix iau;
    private PointF iav;
    private b iaw;
    private boolean iax;
    private com.baidu.tieba.write.write.sticker.a.a iay;
    private float iaz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.iay = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iat = new Matrix();
        this.iau = new Matrix();
        this.iav = new PointF();
        this.iax = true;
        this.hyd = false;
        this.bvf = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.iaw = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0210e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ias.getMatrix().postTranslate((getWidth() - this.ias.bQu()) / 2, (getHeight() - this.ias.bQv()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ias != null) {
            this.ias.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.ias.bQw(), this.ias.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hyd) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.iaw.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dLw = motionEvent.getX();
                this.dLx = motionEvent.getY();
                if (this.ias == null) {
                    return false;
                }
                if (this.hyd && this.iaw.R(motionEvent)) {
                    this.iax = false;
                    if (this.iay != null) {
                        this.iay.bQx();
                        break;
                    }
                } else if (a(this.ias, motionEvent)) {
                    this.iax = true;
                    if (System.currentTimeMillis() - this.bvf <= 300 && this.iay != null) {
                        this.iay.a(this);
                        this.iax = false;
                    }
                    this.bvf = System.currentTimeMillis();
                    this.mode = 1;
                    this.iat.set(this.ias.getMatrix());
                    break;
                } else {
                    this.iax = false;
                    if (this.iay == null) {
                        z = false;
                        break;
                    } else {
                        this.iay.a(this, this.iax);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.iav = null;
                if (this.iay != null) {
                    if (this.iax) {
                        this.iay.b(this);
                    }
                    if (this.hyd) {
                        this.iax = false;
                    }
                    this.iay.a(this, this.iax);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.iax || motionEvent.getX() != this.dLw || motionEvent.getY() != this.dLx) {
                    this.iax = false;
                }
                if (this.mode == 2) {
                    this.iau.set(this.iat);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.iaz;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.iaA;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.iau.postScale(T, T, this.iav.x, this.iav.y);
                    this.iau.postRotate(U, this.iav.x, this.iav.y);
                    this.iau.postTranslate(S.x - this.iav.x, S.y - this.iav.y);
                    this.ias.getMatrix().set(this.iau);
                } else if (this.mode == 1) {
                    this.iau.set(this.iat);
                    this.iau.postTranslate(motionEvent.getX() - this.dLw, motionEvent.getY() - this.dLx);
                    this.ias.getMatrix().set(this.iau);
                }
                if (!this.iax) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.iaz = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.iaA = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.iav = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.iat.set(this.ias.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bQw(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ias = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ias = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hyd = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.iaw.xy(i);
    }
}
