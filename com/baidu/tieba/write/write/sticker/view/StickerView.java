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
    private long dTa;
    private boolean isEdit;
    private float kAa;
    private a kXf;
    private Matrix kXg;
    private Matrix kXh;
    private PointF kXi;
    private b kXj;
    private boolean kXk;
    private com.baidu.tieba.write.write.sticker.a.a kXl;
    private float kXm;
    private float kXn;
    private float kzZ;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kXl = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kXg = new Matrix();
        this.kXh = new Matrix();
        this.kXi = new PointF();
        this.kXk = true;
        this.isEdit = false;
        this.dTa = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kXj = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kXf.getMatrix().postTranslate((getWidth() - this.kXf.cXE()) / 2, (getHeight() - this.kXf.cXF()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kXf != null) {
            this.kXf.draw(canvas);
            float[] a = g.a(this.kXf.cXG(), this.kXf.getMatrix());
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
                this.kXj.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.kzZ = motionEvent.getX();
                this.kAa = motionEvent.getY();
                if (this.kXf == null) {
                    return false;
                }
                if (this.isEdit && this.kXj.L(motionEvent)) {
                    this.kXk = false;
                    if (this.kXl != null) {
                        this.kXl.cXH();
                        break;
                    }
                } else if (a(this.kXf, motionEvent)) {
                    this.kXk = true;
                    if (System.currentTimeMillis() - this.dTa <= 300 && this.kXl != null) {
                        this.kXl.a(this);
                        this.kXk = false;
                    }
                    this.dTa = System.currentTimeMillis();
                    this.mode = 1;
                    this.kXg.set(this.kXf.getMatrix());
                    break;
                } else {
                    this.kXk = false;
                    if (this.kXl == null) {
                        z = false;
                        break;
                    } else {
                        this.kXl.a(this, this.kXk);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kXi = null;
                if (this.kXl != null) {
                    if (this.kXk) {
                        this.kXl.b(this);
                    }
                    if (this.isEdit) {
                        this.kXk = false;
                    }
                    this.kXl.a(this, this.kXk);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kXk || motionEvent.getX() != this.kzZ || motionEvent.getY() != this.kAa) {
                    this.kXk = false;
                }
                if (this.mode == 2) {
                    this.kXh.set(this.kXg);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kXm;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kXn;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kXh.postScale(N, N, this.kXi.x, this.kXi.y);
                    this.kXh.postRotate(O, this.kXi.x, this.kXi.y);
                    this.kXh.postTranslate(M.x - this.kXi.x, M.y - this.kXi.y);
                    this.kXf.getMatrix().set(this.kXh);
                } else if (this.mode == 1) {
                    this.kXh.set(this.kXg);
                    this.kXh.postTranslate(motionEvent.getX() - this.kzZ, motionEvent.getY() - this.kAa);
                    this.kXf.getMatrix().set(this.kXh);
                }
                if (!this.kXk) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kXm = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kXn = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kXi = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kXg.set(this.kXf.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cXG(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kXf = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kXf = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kXj.EE(i);
    }
}
