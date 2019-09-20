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
    private long cRK;
    private float fzR;
    private float fzS;
    private a jZh;
    private Matrix jZi;
    private Matrix jZj;
    private PointF jZk;
    private b jZl;
    private boolean jZm;
    private com.baidu.tieba.write.write.sticker.a.a jZn;
    private float jZo;
    private float jZp;
    private boolean jvC;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jZn = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZi = new Matrix();
        this.jZj = new Matrix();
        this.jZk = new PointF();
        this.jZm = true;
        this.jvC = false;
        this.cRK = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jZl = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jZh.getMatrix().postTranslate((getWidth() - this.jZh.cEb()) / 2, (getHeight() - this.jZh.cEc()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jZh != null) {
            this.jZh.draw(canvas);
            float[] a = f.a(this.jZh.cEd(), this.jZh.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jvC) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jZl.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fzR = motionEvent.getX();
                this.fzS = motionEvent.getY();
                if (this.jZh == null) {
                    return false;
                }
                if (this.jvC && this.jZl.U(motionEvent)) {
                    this.jZm = false;
                    if (this.jZn != null) {
                        this.jZn.cEe();
                        break;
                    }
                } else if (a(this.jZh, motionEvent)) {
                    this.jZm = true;
                    if (System.currentTimeMillis() - this.cRK <= 300 && this.jZn != null) {
                        this.jZn.a(this);
                        this.jZm = false;
                    }
                    this.cRK = System.currentTimeMillis();
                    this.mode = 1;
                    this.jZi.set(this.jZh.getMatrix());
                    break;
                } else {
                    this.jZm = false;
                    if (this.jZn == null) {
                        z = false;
                        break;
                    } else {
                        this.jZn.a(this, this.jZm);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jZk = null;
                if (this.jZn != null) {
                    if (this.jZm) {
                        this.jZn.b(this);
                    }
                    if (this.jvC) {
                        this.jZm = false;
                    }
                    this.jZn.a(this, this.jZm);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jZm || motionEvent.getX() != this.fzR || motionEvent.getY() != this.fzS) {
                    this.jZm = false;
                }
                if (this.mode == 2) {
                    this.jZj.set(this.jZi);
                    float W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent) / this.jZo;
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) - this.jZp;
                    PointF V = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                    this.jZj.postScale(W, W, this.jZk.x, this.jZk.y);
                    this.jZj.postRotate(X, this.jZk.x, this.jZk.y);
                    this.jZj.postTranslate(V.x - this.jZk.x, V.y - this.jZk.y);
                    this.jZh.getMatrix().set(this.jZj);
                } else if (this.mode == 1) {
                    this.jZj.set(this.jZi);
                    this.jZj.postTranslate(motionEvent.getX() - this.fzR, motionEvent.getY() - this.fzS);
                    this.jZh.getMatrix().set(this.jZj);
                }
                if (!this.jZm) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jZo = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jZp = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jZk = com.baidu.tieba.write.write.sticker.b.a.V(motionEvent);
                this.jZi.set(this.jZh.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.cEd(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jZh = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jZh = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jvC = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jZl.Dv(i);
    }
}
