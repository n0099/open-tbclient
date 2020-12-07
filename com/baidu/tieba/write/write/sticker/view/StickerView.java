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
    private boolean nzi;
    private a ogq;
    private Matrix ogr;
    private Matrix ogs;
    private PointF ogt;
    private b ogu;
    private boolean ogv;
    private com.baidu.tieba.write.write.sticker.a.a ogw;
    private float ogx;
    private float ogy;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.ogw = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ogr = new Matrix();
        this.ogs = new Matrix();
        this.ogt = new PointF();
        this.ogv = true;
        this.nzi = false;
        this.fTP = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ogu = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ogq.getMatrix().postTranslate((getWidth() - this.ogq.ect()) / 2, (getHeight() - this.ogq.ecu()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ogq != null) {
            this.ogq.draw(canvas);
            float[] a2 = h.a(this.ogq.ecv(), this.ogq.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.nzi) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.ogu.a(canvas, f3, f4);
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
                if (this.ogq == null) {
                    return false;
                }
                if (this.nzi && this.ogu.al(motionEvent)) {
                    this.ogv = false;
                    if (this.ogw != null) {
                        this.ogw.cQa();
                        break;
                    }
                } else if (a(this.ogq, motionEvent)) {
                    this.ogv = true;
                    if (System.currentTimeMillis() - this.fTP <= 300 && this.ogw != null) {
                        this.ogw.a(this);
                        this.ogv = false;
                    }
                    this.fTP = System.currentTimeMillis();
                    this.mode = 1;
                    this.ogr.set(this.ogq.getMatrix());
                    break;
                } else {
                    this.ogv = false;
                    if (this.ogw == null) {
                        z = false;
                        break;
                    } else {
                        this.ogw.a(this, this.ogv);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.ogt = null;
                if (this.ogw != null) {
                    if (this.ogv) {
                        this.ogw.b(this);
                    }
                    if (this.nzi) {
                        this.ogv = false;
                    }
                    this.ogw.a(this, this.ogv);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.ogv || motionEvent.getX() != this.bpE || motionEvent.getY() != this.bpF) {
                    this.ogv = false;
                }
                if (this.mode == 2) {
                    this.ogs.set(this.ogr);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.ogx;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.ogy;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.ogs.postScale(an, an, this.ogt.x, this.ogt.y);
                    this.ogs.postRotate(ao, this.ogt.x, this.ogt.y);
                    this.ogs.postTranslate(am.x - this.ogt.x, am.y - this.ogt.y);
                    this.ogq.getMatrix().set(this.ogs);
                } else if (this.mode == 1) {
                    this.ogs.set(this.ogr);
                    this.ogs.postTranslate(motionEvent.getX() - this.bpE, motionEvent.getY() - this.bpF);
                    this.ogq.getMatrix().set(this.ogs);
                }
                if (!this.ogv) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.ogx = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.ogy = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.ogt = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.ogr.set(this.ogq.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.ecv(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ogq = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ogq = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.nzi = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.ogu.Nf(i);
    }
}
