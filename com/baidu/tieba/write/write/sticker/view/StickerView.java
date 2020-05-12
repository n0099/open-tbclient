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
    private long ete;
    private a lHk;
    private Matrix lHl;
    private Matrix lHm;
    private PointF lHn;
    private b lHo;
    private boolean lHp;
    private com.baidu.tieba.write.write.sticker.a.a lHq;
    private float lHr;
    private float lHs;
    private boolean lfu;
    private float lku;
    private float lkv;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.lHq = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lHl = new Matrix();
        this.lHm = new Matrix();
        this.lHn = new PointF();
        this.lHp = true;
        this.lfu = false;
        this.ete = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.lHo = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.lHk.getMatrix().postTranslate((getWidth() - this.lHk.dik()) / 2, (getHeight() - this.lHk.dil()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.lHk != null) {
            this.lHk.draw(canvas);
            float[] a = g.a(this.lHk.dim(), this.lHk.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lfu) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.lHo.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lku = motionEvent.getX();
                this.lkv = motionEvent.getY();
                if (this.lHk == null) {
                    return false;
                }
                if (this.lfu && this.lHo.L(motionEvent)) {
                    this.lHp = false;
                    if (this.lHq != null) {
                        this.lHq.din();
                        break;
                    }
                } else if (a(this.lHk, motionEvent)) {
                    this.lHp = true;
                    if (System.currentTimeMillis() - this.ete <= 300 && this.lHq != null) {
                        this.lHq.a(this);
                        this.lHp = false;
                    }
                    this.ete = System.currentTimeMillis();
                    this.mode = 1;
                    this.lHl.set(this.lHk.getMatrix());
                    break;
                } else {
                    this.lHp = false;
                    if (this.lHq == null) {
                        z = false;
                        break;
                    } else {
                        this.lHq.a(this, this.lHp);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.lHn = null;
                if (this.lHq != null) {
                    if (this.lHp) {
                        this.lHq.b(this);
                    }
                    if (this.lfu) {
                        this.lHp = false;
                    }
                    this.lHq.a(this, this.lHp);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.lHp || motionEvent.getX() != this.lku || motionEvent.getY() != this.lkv) {
                    this.lHp = false;
                }
                if (this.mode == 2) {
                    this.lHm.set(this.lHl);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.lHr;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.lHs;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.lHm.postScale(N, N, this.lHn.x, this.lHn.y);
                    this.lHm.postRotate(O, this.lHn.x, this.lHn.y);
                    this.lHm.postTranslate(M.x - this.lHn.x, M.y - this.lHn.y);
                    this.lHk.getMatrix().set(this.lHm);
                } else if (this.mode == 1) {
                    this.lHm.set(this.lHl);
                    this.lHm.postTranslate(motionEvent.getX() - this.lku, motionEvent.getY() - this.lkv);
                    this.lHk.getMatrix().set(this.lHm);
                }
                if (!this.lHp) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.lHr = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.lHs = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.lHn = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.lHl.set(this.lHk.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dim(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.lHk = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.lHk = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lfu = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.lHo.Ff(i);
    }
}
