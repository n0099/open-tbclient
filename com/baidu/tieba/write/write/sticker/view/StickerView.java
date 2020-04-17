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
/* loaded from: classes2.dex */
public class StickerView extends ImageView {
    private long esY;
    private a lHg;
    private Matrix lHh;
    private Matrix lHi;
    private PointF lHj;
    private b lHk;
    private boolean lHl;
    private com.baidu.tieba.write.write.sticker.a.a lHm;
    private float lHn;
    private float lHo;
    private boolean lfq;
    private float lkq;
    private float lkr;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.lHm = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lHh = new Matrix();
        this.lHi = new Matrix();
        this.lHj = new PointF();
        this.lHl = true;
        this.lfq = false;
        this.esY = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.lHk = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.lHg.getMatrix().postTranslate((getWidth() - this.lHg.dim()) / 2, (getHeight() - this.lHg.din()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.lHg != null) {
            this.lHg.draw(canvas);
            float[] a = g.a(this.lHg.dio(), this.lHg.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lfq) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.lHk.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lkq = motionEvent.getX();
                this.lkr = motionEvent.getY();
                if (this.lHg == null) {
                    return false;
                }
                if (this.lfq && this.lHk.L(motionEvent)) {
                    this.lHl = false;
                    if (this.lHm != null) {
                        this.lHm.dip();
                        break;
                    }
                } else if (a(this.lHg, motionEvent)) {
                    this.lHl = true;
                    if (System.currentTimeMillis() - this.esY <= 300 && this.lHm != null) {
                        this.lHm.a(this);
                        this.lHl = false;
                    }
                    this.esY = System.currentTimeMillis();
                    this.mode = 1;
                    this.lHh.set(this.lHg.getMatrix());
                    break;
                } else {
                    this.lHl = false;
                    if (this.lHm == null) {
                        z = false;
                        break;
                    } else {
                        this.lHm.a(this, this.lHl);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.lHj = null;
                if (this.lHm != null) {
                    if (this.lHl) {
                        this.lHm.b(this);
                    }
                    if (this.lfq) {
                        this.lHl = false;
                    }
                    this.lHm.a(this, this.lHl);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.lHl || motionEvent.getX() != this.lkq || motionEvent.getY() != this.lkr) {
                    this.lHl = false;
                }
                if (this.mode == 2) {
                    this.lHi.set(this.lHh);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.lHn;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.lHo;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.lHi.postScale(N, N, this.lHj.x, this.lHj.y);
                    this.lHi.postRotate(O, this.lHj.x, this.lHj.y);
                    this.lHi.postTranslate(M.x - this.lHj.x, M.y - this.lHj.y);
                    this.lHg.getMatrix().set(this.lHi);
                } else if (this.mode == 1) {
                    this.lHi.set(this.lHh);
                    this.lHi.postTranslate(motionEvent.getX() - this.lkq, motionEvent.getY() - this.lkr);
                    this.lHg.getMatrix().set(this.lHi);
                }
                if (!this.lHl) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.lHn = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.lHo = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.lHj = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.lHh.set(this.lHg.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dio(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.lHg = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.lHg = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lfq = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.lHk.Ff(i);
    }
}
