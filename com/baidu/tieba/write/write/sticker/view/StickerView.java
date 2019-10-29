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
import com.baidu.tbadk.util.f;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long dbd;
    private float fzg;
    private float fzh;
    private a jXg;
    private Matrix jXh;
    private Matrix jXi;
    private PointF jXj;
    private b jXk;
    private boolean jXl;
    private com.baidu.tieba.write.write.sticker.a.a jXm;
    private float jXn;
    private float jXo;
    private boolean jvu;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jXm = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXh = new Matrix();
        this.jXi = new Matrix();
        this.jXj = new PointF();
        this.jXl = true;
        this.jvu = false;
        this.dbd = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jXk = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jXg.getMatrix().postTranslate((getWidth() - this.jXg.cAL()) / 2, (getHeight() - this.jXg.cAM()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jXg != null) {
            this.jXg.draw(canvas);
            float[] a = f.a(this.jXg.cAN(), this.jXg.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jvu) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jXk.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fzg = motionEvent.getX();
                this.fzh = motionEvent.getY();
                if (this.jXg == null) {
                    return false;
                }
                if (this.jvu && this.jXk.M(motionEvent)) {
                    this.jXl = false;
                    if (this.jXm != null) {
                        this.jXm.cAO();
                        break;
                    }
                } else if (a(this.jXg, motionEvent)) {
                    this.jXl = true;
                    if (System.currentTimeMillis() - this.dbd <= 300 && this.jXm != null) {
                        this.jXm.a(this);
                        this.jXl = false;
                    }
                    this.dbd = System.currentTimeMillis();
                    this.mode = 1;
                    this.jXh.set(this.jXg.getMatrix());
                    break;
                } else {
                    this.jXl = false;
                    if (this.jXm == null) {
                        z = false;
                        break;
                    } else {
                        this.jXm.a(this, this.jXl);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jXj = null;
                if (this.jXm != null) {
                    if (this.jXl) {
                        this.jXm.b(this);
                    }
                    if (this.jvu) {
                        this.jXl = false;
                    }
                    this.jXm.a(this, this.jXl);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jXl || motionEvent.getX() != this.fzg || motionEvent.getY() != this.fzh) {
                    this.jXl = false;
                }
                if (this.mode == 2) {
                    this.jXi.set(this.jXh);
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) / this.jXn;
                    float P = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent) - this.jXo;
                    PointF N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                    this.jXi.postScale(O, O, this.jXj.x, this.jXj.y);
                    this.jXi.postRotate(P, this.jXj.x, this.jXj.y);
                    this.jXi.postTranslate(N.x - this.jXj.x, N.y - this.jXj.y);
                    this.jXg.getMatrix().set(this.jXi);
                } else if (this.mode == 1) {
                    this.jXi.set(this.jXh);
                    this.jXi.postTranslate(motionEvent.getX() - this.fzg, motionEvent.getY() - this.fzh);
                    this.jXg.getMatrix().set(this.jXi);
                }
                if (!this.jXl) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jXn = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.jXo = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent);
                this.jXj = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.jXh.set(this.jXg.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.cAN(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jXg = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jXg = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jvu = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jXk.BR(i);
    }
}
