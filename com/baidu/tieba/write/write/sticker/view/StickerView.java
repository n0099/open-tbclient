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
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long fjk;
    private Context mContext;
    private Paint mPaint;
    private a mYa;
    private Matrix mYb;
    private Matrix mYc;
    private PointF mYd;
    private b mYe;
    private boolean mYf;
    private com.baidu.tieba.write.write.sticker.a.a mYg;
    private float mYh;
    private float mYi;
    private int mode;
    private boolean msr;
    private float mxv;
    private float mxw;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mYg = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mYb = new Matrix();
        this.mYc = new Matrix();
        this.mYd = new PointF();
        this.mYf = true;
        this.msr = false;
        this.fjk = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mYe = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mYa.getMatrix().postTranslate((getWidth() - this.mYa.dJy()) / 2, (getHeight() - this.mYa.dJz()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mYa != null) {
            this.mYa.draw(canvas);
            float[] a = g.a(this.mYa.dJA(), this.mYa.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.msr) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mYe.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mxv = motionEvent.getX();
                this.mxw = motionEvent.getY();
                if (this.mYa == null) {
                    return false;
                }
                if (this.msr && this.mYe.aj(motionEvent)) {
                    this.mYf = false;
                    if (this.mYg != null) {
                        this.mYg.cyg();
                        break;
                    }
                } else if (a(this.mYa, motionEvent)) {
                    this.mYf = true;
                    if (System.currentTimeMillis() - this.fjk <= 300 && this.mYg != null) {
                        this.mYg.a(this);
                        this.mYf = false;
                    }
                    this.fjk = System.currentTimeMillis();
                    this.mode = 1;
                    this.mYb.set(this.mYa.getMatrix());
                    break;
                } else {
                    this.mYf = false;
                    if (this.mYg == null) {
                        z = false;
                        break;
                    } else {
                        this.mYg.a(this, this.mYf);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mYd = null;
                if (this.mYg != null) {
                    if (this.mYf) {
                        this.mYg.b(this);
                    }
                    if (this.msr) {
                        this.mYf = false;
                    }
                    this.mYg.a(this, this.mYf);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mYf || motionEvent.getX() != this.mxv || motionEvent.getY() != this.mxw) {
                    this.mYf = false;
                }
                if (this.mode == 2) {
                    this.mYc.set(this.mYb);
                    float al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent) / this.mYh;
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) - this.mYi;
                    PointF ak = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                    this.mYc.postScale(al, al, this.mYd.x, this.mYd.y);
                    this.mYc.postRotate(am, this.mYd.x, this.mYd.y);
                    this.mYc.postTranslate(ak.x - this.mYd.x, ak.y - this.mYd.y);
                    this.mYa.getMatrix().set(this.mYc);
                } else if (this.mode == 1) {
                    this.mYc.set(this.mYb);
                    this.mYc.postTranslate(motionEvent.getX() - this.mxv, motionEvent.getY() - this.mxw);
                    this.mYa.getMatrix().set(this.mYc);
                }
                if (!this.mYf) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mYh = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.mYi = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.mYd = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                this.mYb.set(this.mYa.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dJA(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mYa = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mYa = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.msr = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mYe.JU(i);
    }
}
