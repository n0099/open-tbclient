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
    private long dSw;
    private float grY;
    private float grZ;
    private boolean isEdit;
    private a kVq;
    private Matrix kVr;
    private Matrix kVs;
    private PointF kVt;
    private b kVu;
    private boolean kVv;
    private com.baidu.tieba.write.write.sticker.a.a kVw;
    private float kVx;
    private float kVy;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kVw = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kVr = new Matrix();
        this.kVs = new Matrix();
        this.kVt = new PointF();
        this.kVv = true;
        this.isEdit = false;
        this.dSw = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kVu = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kVq.getMatrix().postTranslate((getWidth() - this.kVq.cXf()) / 2, (getHeight() - this.kVq.cXg()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kVq != null) {
            this.kVq.draw(canvas);
            float[] a = g.a(this.kVq.cXh(), this.kVq.getMatrix());
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
                this.kVu.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.grY = motionEvent.getX();
                this.grZ = motionEvent.getY();
                if (this.kVq == null) {
                    return false;
                }
                if (this.isEdit && this.kVu.L(motionEvent)) {
                    this.kVv = false;
                    if (this.kVw != null) {
                        this.kVw.cXi();
                        break;
                    }
                } else if (a(this.kVq, motionEvent)) {
                    this.kVv = true;
                    if (System.currentTimeMillis() - this.dSw <= 300 && this.kVw != null) {
                        this.kVw.a(this);
                        this.kVv = false;
                    }
                    this.dSw = System.currentTimeMillis();
                    this.mode = 1;
                    this.kVr.set(this.kVq.getMatrix());
                    break;
                } else {
                    this.kVv = false;
                    if (this.kVw == null) {
                        z = false;
                        break;
                    } else {
                        this.kVw.a(this, this.kVv);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kVt = null;
                if (this.kVw != null) {
                    if (this.kVv) {
                        this.kVw.b(this);
                    }
                    if (this.isEdit) {
                        this.kVv = false;
                    }
                    this.kVw.a(this, this.kVv);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kVv || motionEvent.getX() != this.grY || motionEvent.getY() != this.grZ) {
                    this.kVv = false;
                }
                if (this.mode == 2) {
                    this.kVs.set(this.kVr);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kVx;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kVy;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kVs.postScale(N, N, this.kVt.x, this.kVt.y);
                    this.kVs.postRotate(O, this.kVt.x, this.kVt.y);
                    this.kVs.postTranslate(M.x - this.kVt.x, M.y - this.kVt.y);
                    this.kVq.getMatrix().set(this.kVs);
                } else if (this.mode == 1) {
                    this.kVs.set(this.kVr);
                    this.kVs.postTranslate(motionEvent.getX() - this.grY, motionEvent.getY() - this.grZ);
                    this.kVq.getMatrix().set(this.kVs);
                }
                if (!this.kVv) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kVx = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kVy = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kVt = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kVr.set(this.kVq.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cXh(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kVq = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kVq = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kVu.Ex(i);
    }
}
