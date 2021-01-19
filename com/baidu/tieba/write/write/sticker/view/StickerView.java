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
/* loaded from: classes7.dex */
public class StickerView extends ImageView {
    private float bmA;
    private float bmB;
    private long fYK;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private float odA;
    private a odr;
    private Matrix ods;
    private Matrix odt;
    private PointF odu;
    private b odv;
    private boolean odw;
    private boolean odx;
    private com.baidu.tieba.write.write.sticker.a.a ody;
    private float odz;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.ody = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ods = new Matrix();
        this.odt = new Matrix();
        this.odu = new PointF();
        this.odw = true;
        this.odx = false;
        this.fYK = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.odv = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.odr.getMatrix().postTranslate((getWidth() - this.odr.dXz()) / 2, (getHeight() - this.odr.dXA()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.odr != null) {
            this.odr.draw(canvas);
            float[] a2 = g.a(this.odr.dXB(), this.odr.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.odx) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.odv.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.bmA = motionEvent.getX();
                this.bmB = motionEvent.getY();
                if (this.odr == null) {
                    return false;
                }
                if (this.odx && this.odv.al(motionEvent)) {
                    this.odw = false;
                    if (this.ody != null) {
                        this.ody.cPq();
                        break;
                    }
                } else if (a(this.odr, motionEvent)) {
                    this.odw = true;
                    if (System.currentTimeMillis() - this.fYK <= 300 && this.ody != null) {
                        this.ody.a(this);
                        this.odw = false;
                    }
                    this.fYK = System.currentTimeMillis();
                    this.mode = 1;
                    this.ods.set(this.odr.getMatrix());
                    break;
                } else {
                    this.odw = false;
                    if (this.ody == null) {
                        z = false;
                        break;
                    } else {
                        this.ody.a(this, this.odw);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.odu = null;
                if (this.ody != null) {
                    if (this.odw) {
                        this.ody.b(this);
                    }
                    if (this.odx) {
                        this.odw = false;
                    }
                    this.ody.a(this, this.odw);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.odw || motionEvent.getX() != this.bmA || motionEvent.getY() != this.bmB) {
                    this.odw = false;
                }
                if (this.mode == 2) {
                    this.odt.set(this.ods);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.odz;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.odA;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.odt.postScale(an, an, this.odu.x, this.odu.y);
                    this.odt.postRotate(ao, this.odu.x, this.odu.y);
                    this.odt.postTranslate(am.x - this.odu.x, am.y - this.odu.y);
                    this.odr.getMatrix().set(this.odt);
                } else if (this.mode == 1) {
                    this.odt.set(this.ods);
                    this.odt.postTranslate(motionEvent.getX() - this.bmA, motionEvent.getY() - this.bmB);
                    this.odr.getMatrix().set(this.odt);
                }
                if (!this.odw) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.odz = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.odA = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.odu = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.ods.set(this.odr.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dXB(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.odr = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.odr = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.odx = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.odv.Lk(i);
    }
}
