package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes8.dex */
public class StickerView extends ImageView {
    private float bqb;
    private float bqc;
    private long gbc;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a onj;
    private Matrix onk;
    private Matrix onl;
    private PointF onm;
    private b onn;
    private boolean ono;
    private boolean onp;
    private com.baidu.tieba.write.write.sticker.a.a onq;
    private float onr;
    private float ons;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.onq = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onk = new Matrix();
        this.onl = new Matrix();
        this.onm = new PointF();
        this.ono = true;
        this.onp = false;
        this.gbc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.onn = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.onj.getMatrix().postTranslate((getWidth() - this.onj.dZK()) / 2, (getHeight() - this.onj.dZL()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.onj != null) {
            this.onj.draw(canvas);
            float[] a2 = h.a(this.onj.dZM(), this.onj.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.onp) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.onn.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bqb = motionEvent.getX();
                this.bqc = motionEvent.getY();
                if (this.onj == null) {
                    return false;
                }
                if (this.onp && this.onn.al(motionEvent)) {
                    this.ono = false;
                    if (this.onq != null) {
                        this.onq.cRp();
                        break;
                    }
                } else if (a(this.onj, motionEvent)) {
                    this.ono = true;
                    if (System.currentTimeMillis() - this.gbc <= 300 && this.onq != null) {
                        this.onq.a(this);
                        this.ono = false;
                    }
                    this.gbc = System.currentTimeMillis();
                    this.mode = 1;
                    this.onk.set(this.onj.getMatrix());
                    break;
                } else {
                    this.ono = false;
                    if (this.onq == null) {
                        z = false;
                        break;
                    } else {
                        this.onq.a(this, this.ono);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.onm = null;
                if (this.onq != null) {
                    if (this.ono) {
                        this.onq.b(this);
                    }
                    if (this.onp) {
                        this.ono = false;
                    }
                    this.onq.a(this, this.ono);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.ono || motionEvent.getX() != this.bqb || motionEvent.getY() != this.bqc) {
                    this.ono = false;
                }
                if (this.mode == 2) {
                    this.onl.set(this.onk);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.onr;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.ons;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.onl.postScale(an, an, this.onm.x, this.onm.y);
                    this.onl.postRotate(ao, this.onm.x, this.onm.y);
                    this.onl.postTranslate(am.x - this.onm.x, am.y - this.onm.y);
                    this.onj.getMatrix().set(this.onl);
                } else if (this.mode == 1) {
                    this.onl.set(this.onk);
                    this.onl.postTranslate(motionEvent.getX() - this.bqb, motionEvent.getY() - this.bqc);
                    this.onj.getMatrix().set(this.onl);
                }
                if (!this.ono) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.onr = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.ons = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.onm = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.onk.set(this.onj.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dZM(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.onj = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.onj = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.onp = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.onn.LE(i);
    }
}
