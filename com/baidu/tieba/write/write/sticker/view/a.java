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
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes2.dex */
public class a extends ImageView {
    private Matrix gvT;
    private Matrix gvU;
    private PointF gvV;
    private boolean gvX;
    private boolean gvY;
    private long gwa;
    private float gwb;
    private float gwc;
    private float gwd;
    private float gwe;
    private com.baidu.tieba.write.write.sticker.a hnM;
    private b hnN;
    private com.baidu.tieba.write.write.sticker.a.a hnO;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.hnO = aVar;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvT = new Matrix();
        this.gvU = new Matrix();
        this.gvV = new PointF();
        this.gvX = true;
        this.gvY = false;
        this.gwa = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.hnN = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.f(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.hnM.getMatrix().postTranslate((getWidth() - this.hnM.btT()) / 2, (getHeight() - this.hnM.btU()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hnM != null) {
            this.hnM.draw(canvas);
            float[] a = com.baidu.tbadk.util.d.a(this.hnM.btV(), this.hnM.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.gvY) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.hnN.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gwb = motionEvent.getX();
                this.gwc = motionEvent.getY();
                if (this.hnM == null) {
                    return false;
                }
                if (this.gvY && this.hnN.B(motionEvent)) {
                    this.gvX = false;
                    if (this.hnO != null) {
                        this.hnO.btW();
                        break;
                    }
                } else if (a(this.hnM, motionEvent)) {
                    this.gvX = true;
                    if (System.currentTimeMillis() - this.gwa <= 300 && this.hnO != null) {
                        this.hnO.a(this);
                        this.gvX = false;
                    }
                    this.gwa = System.currentTimeMillis();
                    this.mode = 1;
                    this.gvT.set(this.hnM.getMatrix());
                    break;
                } else {
                    this.gvX = false;
                    if (this.hnO == null) {
                        z = false;
                        break;
                    } else {
                        this.hnO.a(this, this.gvX);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.gvV = null;
                if (this.hnO != null) {
                    if (this.gvX) {
                        this.hnO.b(this);
                    }
                    if (this.gvY) {
                        this.gvX = false;
                    }
                    this.hnO.a(this, this.gvX);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.gvX || motionEvent.getX() != this.gwb || motionEvent.getY() != this.gwc) {
                    this.gvX = false;
                }
                if (this.mode == 2) {
                    this.gvU.set(this.gvT);
                    float D = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent) / this.gwd;
                    float E = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent) - this.gwe;
                    PointF C = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                    this.gvU.postScale(D, D, this.gvV.x, this.gvV.y);
                    this.gvU.postRotate(E, this.gvV.x, this.gvV.y);
                    this.gvU.postTranslate(C.x - this.gvV.x, C.y - this.gvV.y);
                    this.hnM.getMatrix().set(this.gvU);
                } else if (this.mode == 1) {
                    this.gvU.set(this.gvT);
                    this.gvU.postTranslate(motionEvent.getX() - this.gwb, motionEvent.getY() - this.gwc);
                    this.hnM.getMatrix().set(this.gvU);
                }
                if (!this.gvX) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.gwd = com.baidu.tieba.write.write.sticker.b.a.D(motionEvent);
                this.gwe = com.baidu.tieba.write.write.sticker.b.a.E(motionEvent);
                this.gvV = com.baidu.tieba.write.write.sticker.b.a.C(motionEvent);
                this.gvT.set(this.hnM.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(com.baidu.tieba.write.write.sticker.a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.d.a(aVar.btV(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.hnM = new com.baidu.tieba.write.write.sticker.a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    public com.baidu.tieba.write.write.sticker.a getmSticker() {
        return this.hnM;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.hnM = new com.baidu.tieba.write.write.sticker.a(bitmap);
    }

    public void setEdit(boolean z) {
        this.gvY = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.hnN.ud(i);
    }
}
