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
    private long fmc;
    private boolean mBP;
    private Context mContext;
    private float mHh;
    private float mHi;
    private Paint mPaint;
    private int mode;
    private a nhY;
    private Matrix nhZ;
    private Matrix nia;
    private PointF nib;
    private b nic;
    private boolean nie;
    private com.baidu.tieba.write.write.sticker.a.a nif;
    private float nig;
    private float nih;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.nif = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nhZ = new Matrix();
        this.nia = new Matrix();
        this.nib = new PointF();
        this.nie = true;
        this.mBP = false;
        this.fmc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.nic = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.nhY.getMatrix().postTranslate((getWidth() - this.nhY.dNw()) / 2, (getHeight() - this.nhY.dNx()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nhY != null) {
            this.nhY.draw(canvas);
            float[] a = h.a(this.nhY.dNy(), this.nhY.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.mBP) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.nic.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mHh = motionEvent.getX();
                this.mHi = motionEvent.getY();
                if (this.nhY == null) {
                    return false;
                }
                if (this.mBP && this.nic.aj(motionEvent)) {
                    this.nie = false;
                    if (this.nif != null) {
                        this.nif.cBO();
                        break;
                    }
                } else if (a(this.nhY, motionEvent)) {
                    this.nie = true;
                    if (System.currentTimeMillis() - this.fmc <= 300 && this.nif != null) {
                        this.nif.a(this);
                        this.nie = false;
                    }
                    this.fmc = System.currentTimeMillis();
                    this.mode = 1;
                    this.nhZ.set(this.nhY.getMatrix());
                    break;
                } else {
                    this.nie = false;
                    if (this.nif == null) {
                        z = false;
                        break;
                    } else {
                        this.nif.a(this, this.nie);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.nib = null;
                if (this.nif != null) {
                    if (this.nie) {
                        this.nif.b(this);
                    }
                    if (this.mBP) {
                        this.nie = false;
                    }
                    this.nif.a(this, this.nie);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.nie || motionEvent.getX() != this.mHh || motionEvent.getY() != this.mHi) {
                    this.nie = false;
                }
                if (this.mode == 2) {
                    this.nia.set(this.nhZ);
                    float al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent) / this.nig;
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) - this.nih;
                    PointF ak = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                    this.nia.postScale(al, al, this.nib.x, this.nib.y);
                    this.nia.postRotate(am, this.nib.x, this.nib.y);
                    this.nia.postTranslate(ak.x - this.nib.x, ak.y - this.nib.y);
                    this.nhY.getMatrix().set(this.nia);
                } else if (this.mode == 1) {
                    this.nia.set(this.nhZ);
                    this.nia.postTranslate(motionEvent.getX() - this.mHh, motionEvent.getY() - this.mHi);
                    this.nhY.getMatrix().set(this.nia);
                }
                if (!this.nie) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.nig = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.nih = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.nib = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                this.nhZ.set(this.nhY.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dNy(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.nhY = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.nhY = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.mBP = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.nic.Kz(i);
    }
}
