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
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private boolean gUx;
    private float gZV;
    private float gZW;
    private long hiL;
    private boolean hwA;
    private a hwB;
    private float hwC;
    private float hwD;
    private com.baidu.tieba.write.write.sticker.a hwv;
    private Matrix hww;
    private Matrix hwx;
    private PointF hwy;
    private b hwz;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(a aVar) {
        this.hwB = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hww = new Matrix();
        this.hwx = new Matrix();
        this.hwy = new PointF();
        this.hwA = true;
        this.gUx = false;
        this.hiL = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hwz = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.e(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hwv.getMatrix().postTranslate((getWidth() - this.hwv.bJv()) / 2, (getHeight() - this.hwv.bJw()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hwv != null) {
            this.hwv.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hwv.bJx(), this.hwv.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gUx) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hwz.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gZV = motionEvent.getX();
                this.gZW = motionEvent.getY();
                if (this.hwv == null) {
                    return false;
                }
                if (this.gUx && this.hwz.R(motionEvent)) {
                    this.hwA = false;
                    if (this.hwB != null) {
                        this.hwB.bJy();
                        break;
                    }
                } else if (a(this.hwv, motionEvent)) {
                    this.hwA = true;
                    if (System.currentTimeMillis() - this.hiL <= 300 && this.hwB != null) {
                        this.hwB.a(this);
                        this.hwA = false;
                    }
                    this.hiL = System.currentTimeMillis();
                    this.mode = 1;
                    this.hww.set(this.hwv.getMatrix());
                    break;
                } else {
                    this.hwA = false;
                    if (this.hwB == null) {
                        z = false;
                        break;
                    } else {
                        this.hwB.a(this, this.hwA);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.hwy = null;
                if (this.hwB != null) {
                    if (this.hwA) {
                        this.hwB.b(this);
                    }
                    if (this.gUx) {
                        this.hwA = false;
                    }
                    this.hwB.a(this, this.hwA);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.hwA || motionEvent.getX() != this.gZV || motionEvent.getY() != this.gZW) {
                    this.hwA = false;
                }
                if (this.mode == 2) {
                    this.hwx.set(this.hww);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.hwC;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.hwD;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.hwx.postScale(T, T, this.hwy.x, this.hwy.y);
                    this.hwx.postRotate(U, this.hwy.x, this.hwy.y);
                    this.hwx.postTranslate(S.x - this.hwy.x, S.y - this.hwy.y);
                    this.hwv.getMatrix().set(this.hwx);
                } else if (this.mode == 1) {
                    this.hwx.set(this.hww);
                    this.hwx.postTranslate(motionEvent.getX() - this.gZV, motionEvent.getY() - this.gZW);
                    this.hwv.getMatrix().set(this.hwx);
                }
                if (!this.hwA) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.hwC = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.hwD = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.hwy = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.hww.set(this.hwv.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.bJx(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hwv = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hwv = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gUx = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hwz.vD(i);
    }
}
