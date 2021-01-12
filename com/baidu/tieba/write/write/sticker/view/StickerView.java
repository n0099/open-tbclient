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
    private a odq;
    private Matrix odr;
    private Matrix ods;
    private PointF odt;
    private b odu;
    private boolean odv;
    private boolean odw;
    private com.baidu.tieba.write.write.sticker.a.a odx;
    private float ody;
    private float odz;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.odx = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.odr = new Matrix();
        this.ods = new Matrix();
        this.odt = new PointF();
        this.odv = true;
        this.odw = false;
        this.fYK = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.odu = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.odq.getMatrix().postTranslate((getWidth() - this.odq.dXz()) / 2, (getHeight() - this.odq.dXA()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.odq != null) {
            this.odq.draw(canvas);
            float[] a2 = g.a(this.odq.dXB(), this.odq.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.odw) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.odu.a(canvas, f3, f4);
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
                if (this.odq == null) {
                    return false;
                }
                if (this.odw && this.odu.al(motionEvent)) {
                    this.odv = false;
                    if (this.odx != null) {
                        this.odx.cPq();
                        break;
                    }
                } else if (a(this.odq, motionEvent)) {
                    this.odv = true;
                    if (System.currentTimeMillis() - this.fYK <= 300 && this.odx != null) {
                        this.odx.a(this);
                        this.odv = false;
                    }
                    this.fYK = System.currentTimeMillis();
                    this.mode = 1;
                    this.odr.set(this.odq.getMatrix());
                    break;
                } else {
                    this.odv = false;
                    if (this.odx == null) {
                        z = false;
                        break;
                    } else {
                        this.odx.a(this, this.odv);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.odt = null;
                if (this.odx != null) {
                    if (this.odv) {
                        this.odx.b(this);
                    }
                    if (this.odw) {
                        this.odv = false;
                    }
                    this.odx.a(this, this.odv);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.odv || motionEvent.getX() != this.bmA || motionEvent.getY() != this.bmB) {
                    this.odv = false;
                }
                if (this.mode == 2) {
                    this.ods.set(this.odr);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.ody;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.odz;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.ods.postScale(an, an, this.odt.x, this.odt.y);
                    this.ods.postRotate(ao, this.odt.x, this.odt.y);
                    this.ods.postTranslate(am.x - this.odt.x, am.y - this.odt.y);
                    this.odq.getMatrix().set(this.ods);
                } else if (this.mode == 1) {
                    this.ods.set(this.odr);
                    this.ods.postTranslate(motionEvent.getX() - this.bmA, motionEvent.getY() - this.bmB);
                    this.odq.getMatrix().set(this.ods);
                }
                if (!this.odv) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.ody = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.odz = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.odt = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.odr.set(this.odq.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dXB(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.odq = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.odq = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.odw = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.odu.Lk(i);
    }
}
