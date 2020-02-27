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
    private long dSv;
    private float grW;
    private float grX;
    private boolean isEdit;
    private a kVo;
    private Matrix kVp;
    private Matrix kVq;
    private PointF kVr;
    private b kVs;
    private boolean kVt;
    private com.baidu.tieba.write.write.sticker.a.a kVu;
    private float kVv;
    private float kVw;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kVu = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kVp = new Matrix();
        this.kVq = new Matrix();
        this.kVr = new PointF();
        this.kVt = true;
        this.isEdit = false;
        this.dSv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kVs = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kVo.getMatrix().postTranslate((getWidth() - this.kVo.cXd()) / 2, (getHeight() - this.kVo.cXe()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kVo != null) {
            this.kVo.draw(canvas);
            float[] a = g.a(this.kVo.cXf(), this.kVo.getMatrix());
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
                this.kVs.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.grW = motionEvent.getX();
                this.grX = motionEvent.getY();
                if (this.kVo == null) {
                    return false;
                }
                if (this.isEdit && this.kVs.L(motionEvent)) {
                    this.kVt = false;
                    if (this.kVu != null) {
                        this.kVu.cXg();
                        break;
                    }
                } else if (a(this.kVo, motionEvent)) {
                    this.kVt = true;
                    if (System.currentTimeMillis() - this.dSv <= 300 && this.kVu != null) {
                        this.kVu.a(this);
                        this.kVt = false;
                    }
                    this.dSv = System.currentTimeMillis();
                    this.mode = 1;
                    this.kVp.set(this.kVo.getMatrix());
                    break;
                } else {
                    this.kVt = false;
                    if (this.kVu == null) {
                        z = false;
                        break;
                    } else {
                        this.kVu.a(this, this.kVt);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kVr = null;
                if (this.kVu != null) {
                    if (this.kVt) {
                        this.kVu.b(this);
                    }
                    if (this.isEdit) {
                        this.kVt = false;
                    }
                    this.kVu.a(this, this.kVt);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kVt || motionEvent.getX() != this.grW || motionEvent.getY() != this.grX) {
                    this.kVt = false;
                }
                if (this.mode == 2) {
                    this.kVq.set(this.kVp);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kVv;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kVw;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kVq.postScale(N, N, this.kVr.x, this.kVr.y);
                    this.kVq.postRotate(O, this.kVr.x, this.kVr.y);
                    this.kVq.postTranslate(M.x - this.kVr.x, M.y - this.kVr.y);
                    this.kVo.getMatrix().set(this.kVq);
                } else if (this.mode == 1) {
                    this.kVq.set(this.kVp);
                    this.kVq.postTranslate(motionEvent.getX() - this.grW, motionEvent.getY() - this.grX);
                    this.kVo.getMatrix().set(this.kVq);
                }
                if (!this.kVt) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kVv = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kVw = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kVr = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kVp.set(this.kVo.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cXf(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kVo = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kVo = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kVs.Ex(i);
    }
}
