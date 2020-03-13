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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes13.dex */
public class StickerView extends ImageView {
    private long dSJ;
    private float gsl;
    private float gsm;
    private boolean isEdit;
    private a kVC;
    private Matrix kVD;
    private Matrix kVE;
    private PointF kVF;
    private b kVG;
    private boolean kVH;
    private com.baidu.tieba.write.write.sticker.a.a kVI;
    private float kVJ;
    private float kVK;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kVI = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kVD = new Matrix();
        this.kVE = new Matrix();
        this.kVF = new PointF();
        this.kVH = true;
        this.isEdit = false;
        this.dSJ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kVG = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kVC.getMatrix().postTranslate((getWidth() - this.kVC.cXg()) / 2, (getHeight() - this.kVC.cXh()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kVC != null) {
            this.kVC.draw(canvas);
            float[] a = g.a(this.kVC.cXi(), this.kVC.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.isEdit) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.kVG.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gsl = motionEvent.getX();
                this.gsm = motionEvent.getY();
                if (this.kVC == null) {
                    return false;
                }
                if (this.isEdit && this.kVG.L(motionEvent)) {
                    this.kVH = false;
                    if (this.kVI != null) {
                        this.kVI.cXj();
                        break;
                    }
                } else if (a(this.kVC, motionEvent)) {
                    this.kVH = true;
                    if (System.currentTimeMillis() - this.dSJ <= 300 && this.kVI != null) {
                        this.kVI.a(this);
                        this.kVH = false;
                    }
                    this.dSJ = System.currentTimeMillis();
                    this.mode = 1;
                    this.kVD.set(this.kVC.getMatrix());
                    break;
                } else {
                    this.kVH = false;
                    if (this.kVI == null) {
                        z = false;
                        break;
                    } else {
                        this.kVI.a(this, this.kVH);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kVF = null;
                if (this.kVI != null) {
                    if (this.kVH) {
                        this.kVI.b(this);
                    }
                    if (this.isEdit) {
                        this.kVH = false;
                    }
                    this.kVI.a(this, this.kVH);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kVH || motionEvent.getX() != this.gsl || motionEvent.getY() != this.gsm) {
                    this.kVH = false;
                }
                if (this.mode == 2) {
                    this.kVE.set(this.kVD);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kVJ;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kVK;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kVE.postScale(N, N, this.kVF.x, this.kVF.y);
                    this.kVE.postRotate(O, this.kVF.x, this.kVF.y);
                    this.kVE.postTranslate(M.x - this.kVF.x, M.y - this.kVF.y);
                    this.kVC.getMatrix().set(this.kVE);
                } else if (this.mode == 1) {
                    this.kVE.set(this.kVD);
                    this.kVE.postTranslate(motionEvent.getX() - this.gsl, motionEvent.getY() - this.gsm);
                    this.kVC.getMatrix().set(this.kVE);
                }
                if (!this.kVH) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kVJ = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kVK = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kVF = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kVD.set(this.kVC.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cXi(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kVC = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kVC = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kVG.Ex(i);
    }
}
