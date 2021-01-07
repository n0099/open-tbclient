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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes8.dex */
public class StickerView extends ImageView {
    private float brm;
    private float brn;
    private long gdt;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a ohW;
    private Matrix ohX;
    private Matrix ohY;
    private PointF ohZ;
    private b oia;
    private boolean oib;
    private boolean oic;
    private com.baidu.tieba.write.write.sticker.a.a oid;
    private float oie;
    private float oif;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.oid = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ohX = new Matrix();
        this.ohY = new Matrix();
        this.ohZ = new PointF();
        this.oib = true;
        this.oic = false;
        this.gdt = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.oia = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ohW.getMatrix().postTranslate((getWidth() - this.ohW.ebr()) / 2, (getHeight() - this.ohW.ebs()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ohW != null) {
            this.ohW.draw(canvas);
            float[] a2 = g.a(this.ohW.ebt(), this.ohW.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.oic) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.oia.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.brm = motionEvent.getX();
                this.brn = motionEvent.getY();
                if (this.ohW == null) {
                    return false;
                }
                if (this.oic && this.oia.al(motionEvent)) {
                    this.oib = false;
                    if (this.oid != null) {
                        this.oid.cTi();
                        break;
                    }
                } else if (a(this.ohW, motionEvent)) {
                    this.oib = true;
                    if (System.currentTimeMillis() - this.gdt <= 300 && this.oid != null) {
                        this.oid.a(this);
                        this.oib = false;
                    }
                    this.gdt = System.currentTimeMillis();
                    this.mode = 1;
                    this.ohX.set(this.ohW.getMatrix());
                    break;
                } else {
                    this.oib = false;
                    if (this.oid == null) {
                        z = false;
                        break;
                    } else {
                        this.oid.a(this, this.oib);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.ohZ = null;
                if (this.oid != null) {
                    if (this.oib) {
                        this.oid.b(this);
                    }
                    if (this.oic) {
                        this.oib = false;
                    }
                    this.oid.a(this, this.oib);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.oib || motionEvent.getX() != this.brm || motionEvent.getY() != this.brn) {
                    this.oib = false;
                }
                if (this.mode == 2) {
                    this.ohY.set(this.ohX);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.oie;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.oif;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.ohY.postScale(an, an, this.ohZ.x, this.ohZ.y);
                    this.ohY.postRotate(ao, this.ohZ.x, this.ohZ.y);
                    this.ohY.postTranslate(am.x - this.ohZ.x, am.y - this.ohZ.y);
                    this.ohW.getMatrix().set(this.ohY);
                } else if (this.mode == 1) {
                    this.ohY.set(this.ohX);
                    this.ohY.postTranslate(motionEvent.getX() - this.brm, motionEvent.getY() - this.brn);
                    this.ohW.getMatrix().set(this.ohY);
                }
                if (!this.oib) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.oie = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.oif = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.ohZ = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.ohX.set(this.ohW.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.ebt(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ohW = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ohW = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.oic = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.oia.MR(i);
    }
}
