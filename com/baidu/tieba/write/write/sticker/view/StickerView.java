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
    private float bkv;
    private float bkw;
    private long fMe;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private float nRA;
    private a nRs;
    private Matrix nRt;
    private Matrix nRu;
    private PointF nRv;
    private b nRw;
    private boolean nRx;
    private com.baidu.tieba.write.write.sticker.a.a nRy;
    private float nRz;
    private boolean nle;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.nRy = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRt = new Matrix();
        this.nRu = new Matrix();
        this.nRv = new PointF();
        this.nRx = true;
        this.nle = false;
        this.fMe = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.nRw = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.nRs.getMatrix().postTranslate((getWidth() - this.nRs.dWP()) / 2, (getHeight() - this.nRs.dWQ()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nRs != null) {
            this.nRs.draw(canvas);
            float[] a2 = h.a(this.nRs.dWR(), this.nRs.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.nle) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.nRw.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bkv = motionEvent.getX();
                this.bkw = motionEvent.getY();
                if (this.nRs == null) {
                    return false;
                }
                if (this.nle && this.nRw.ak(motionEvent)) {
                    this.nRx = false;
                    if (this.nRy != null) {
                        this.nRy.cKL();
                        break;
                    }
                } else if (a(this.nRs, motionEvent)) {
                    this.nRx = true;
                    if (System.currentTimeMillis() - this.fMe <= 300 && this.nRy != null) {
                        this.nRy.a(this);
                        this.nRx = false;
                    }
                    this.fMe = System.currentTimeMillis();
                    this.mode = 1;
                    this.nRt.set(this.nRs.getMatrix());
                    break;
                } else {
                    this.nRx = false;
                    if (this.nRy == null) {
                        z = false;
                        break;
                    } else {
                        this.nRy.a(this, this.nRx);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.nRv = null;
                if (this.nRy != null) {
                    if (this.nRx) {
                        this.nRy.b(this);
                    }
                    if (this.nle) {
                        this.nRx = false;
                    }
                    this.nRy.a(this, this.nRx);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.nRx || motionEvent.getX() != this.bkv || motionEvent.getY() != this.bkw) {
                    this.nRx = false;
                }
                if (this.mode == 2) {
                    this.nRu.set(this.nRt);
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) / this.nRz;
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) - this.nRA;
                    PointF al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                    this.nRu.postScale(am, am, this.nRv.x, this.nRv.y);
                    this.nRu.postRotate(an, this.nRv.x, this.nRv.y);
                    this.nRu.postTranslate(al.x - this.nRv.x, al.y - this.nRv.y);
                    this.nRs.getMatrix().set(this.nRu);
                } else if (this.mode == 1) {
                    this.nRu.set(this.nRt);
                    this.nRu.postTranslate(motionEvent.getX() - this.bkv, motionEvent.getY() - this.bkw);
                    this.nRs.getMatrix().set(this.nRu);
                }
                if (!this.nRx) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.nRz = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.nRA = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.nRv = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.nRt.set(this.nRs.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dWR(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.nRs = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.nRs = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.nle = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.nRw.Mn(i);
    }
}
