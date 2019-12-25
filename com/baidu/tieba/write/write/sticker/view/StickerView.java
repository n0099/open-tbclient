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
/* loaded from: classes10.dex */
public class StickerView extends ImageView {
    private long dOh;
    private float gmM;
    private float gmN;
    private boolean isEdit;
    private a kRc;
    private Matrix kRd;
    private Matrix kRe;
    private PointF kRf;
    private b kRg;
    private boolean kRh;
    private com.baidu.tieba.write.write.sticker.a.a kRi;
    private float kRj;
    private float kRk;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kRi = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kRd = new Matrix();
        this.kRe = new Matrix();
        this.kRf = new PointF();
        this.kRh = true;
        this.isEdit = false;
        this.dOh = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kRg = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kRc.getMatrix().postTranslate((getWidth() - this.kRc.cUK()) / 2, (getHeight() - this.kRc.cUL()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kRc != null) {
            this.kRc.draw(canvas);
            float[] a = g.a(this.kRc.cUM(), this.kRc.getMatrix());
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
                this.kRg.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gmM = motionEvent.getX();
                this.gmN = motionEvent.getY();
                if (this.kRc == null) {
                    return false;
                }
                if (this.isEdit && this.kRg.M(motionEvent)) {
                    this.kRh = false;
                    if (this.kRi != null) {
                        this.kRi.cUN();
                        break;
                    }
                } else if (a(this.kRc, motionEvent)) {
                    this.kRh = true;
                    if (System.currentTimeMillis() - this.dOh <= 300 && this.kRi != null) {
                        this.kRi.a(this);
                        this.kRh = false;
                    }
                    this.dOh = System.currentTimeMillis();
                    this.mode = 1;
                    this.kRd.set(this.kRc.getMatrix());
                    break;
                } else {
                    this.kRh = false;
                    if (this.kRi == null) {
                        z = false;
                        break;
                    } else {
                        this.kRi.a(this, this.kRh);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kRf = null;
                if (this.kRi != null) {
                    if (this.kRh) {
                        this.kRi.b(this);
                    }
                    if (this.isEdit) {
                        this.kRh = false;
                    }
                    this.kRi.a(this, this.kRh);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kRh || motionEvent.getX() != this.gmM || motionEvent.getY() != this.gmN) {
                    this.kRh = false;
                }
                if (this.mode == 2) {
                    this.kRe.set(this.kRd);
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) / this.kRj;
                    float P = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent) - this.kRk;
                    PointF N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                    this.kRe.postScale(O, O, this.kRf.x, this.kRf.y);
                    this.kRe.postRotate(P, this.kRf.x, this.kRf.y);
                    this.kRe.postTranslate(N.x - this.kRf.x, N.y - this.kRf.y);
                    this.kRc.getMatrix().set(this.kRe);
                } else if (this.mode == 1) {
                    this.kRe.set(this.kRd);
                    this.kRe.postTranslate(motionEvent.getX() - this.gmM, motionEvent.getY() - this.gmN);
                    this.kRc.getMatrix().set(this.kRe);
                }
                if (!this.kRh) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kRj = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kRk = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent);
                this.kRf = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kRd.set(this.kRc.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cUM(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kRc = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kRc = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kRg.En(i);
    }
}
