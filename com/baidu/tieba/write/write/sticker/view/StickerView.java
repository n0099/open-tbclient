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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private float bpE;
    private float bpF;
    private long fTP;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private boolean nzk;
    private float ogA;
    private a ogs;
    private Matrix ogt;
    private Matrix ogu;
    private PointF ogv;
    private b ogw;
    private boolean ogx;
    private com.baidu.tieba.write.write.sticker.a.a ogy;
    private float ogz;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.ogy = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ogt = new Matrix();
        this.ogu = new Matrix();
        this.ogv = new PointF();
        this.ogx = true;
        this.nzk = false;
        this.fTP = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ogw = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ogs.getMatrix().postTranslate((getWidth() - this.ogs.ecu()) / 2, (getHeight() - this.ogs.ecv()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ogs != null) {
            this.ogs.draw(canvas);
            float[] a2 = h.a(this.ogs.ecw(), this.ogs.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.nzk) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.ogw.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bpE = motionEvent.getX();
                this.bpF = motionEvent.getY();
                if (this.ogs == null) {
                    return false;
                }
                if (this.nzk && this.ogw.al(motionEvent)) {
                    this.ogx = false;
                    if (this.ogy != null) {
                        this.ogy.cQb();
                        break;
                    }
                } else if (a(this.ogs, motionEvent)) {
                    this.ogx = true;
                    if (System.currentTimeMillis() - this.fTP <= 300 && this.ogy != null) {
                        this.ogy.a(this);
                        this.ogx = false;
                    }
                    this.fTP = System.currentTimeMillis();
                    this.mode = 1;
                    this.ogt.set(this.ogs.getMatrix());
                    break;
                } else {
                    this.ogx = false;
                    if (this.ogy == null) {
                        z = false;
                        break;
                    } else {
                        this.ogy.a(this, this.ogx);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.ogv = null;
                if (this.ogy != null) {
                    if (this.ogx) {
                        this.ogy.b(this);
                    }
                    if (this.nzk) {
                        this.ogx = false;
                    }
                    this.ogy.a(this, this.ogx);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.ogx || motionEvent.getX() != this.bpE || motionEvent.getY() != this.bpF) {
                    this.ogx = false;
                }
                if (this.mode == 2) {
                    this.ogu.set(this.ogt);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.ogz;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.ogA;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.ogu.postScale(an, an, this.ogv.x, this.ogv.y);
                    this.ogu.postRotate(ao, this.ogv.x, this.ogv.y);
                    this.ogu.postTranslate(am.x - this.ogv.x, am.y - this.ogv.y);
                    this.ogs.getMatrix().set(this.ogu);
                } else if (this.mode == 1) {
                    this.ogu.set(this.ogt);
                    this.ogu.postTranslate(motionEvent.getX() - this.bpE, motionEvent.getY() - this.bpF);
                    this.ogs.getMatrix().set(this.ogu);
                }
                if (!this.ogx) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.ogz = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.ogA = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.ogv = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.ogt.set(this.ogs.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.ecw(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ogs = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ogs = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.nzk = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.ogw.Nf(i);
    }
}
