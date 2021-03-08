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
/* loaded from: classes7.dex */
public class StickerView extends ImageView {
    private float brB;
    private float brC;
    private long gcD;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a opP;
    private Matrix opQ;
    private Matrix opR;
    private PointF opS;
    private b opT;
    private boolean opU;
    private boolean opV;
    private com.baidu.tieba.write.write.sticker.a.a opW;
    private float opX;
    private float opY;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.opW = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.opQ = new Matrix();
        this.opR = new Matrix();
        this.opS = new PointF();
        this.opU = true;
        this.opV = false;
        this.gcD = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.opT = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.opP.getMatrix().postTranslate((getWidth() - this.opP.eaa()) / 2, (getHeight() - this.opP.eab()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.opP != null) {
            this.opP.draw(canvas);
            float[] a2 = h.a(this.opP.eac(), this.opP.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.opV) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.opT.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.brB = motionEvent.getX();
                this.brC = motionEvent.getY();
                if (this.opP == null) {
                    return false;
                }
                if (this.opV && this.opT.al(motionEvent)) {
                    this.opU = false;
                    if (this.opW != null) {
                        this.opW.cRD();
                        break;
                    }
                } else if (a(this.opP, motionEvent)) {
                    this.opU = true;
                    if (System.currentTimeMillis() - this.gcD <= 300 && this.opW != null) {
                        this.opW.a(this);
                        this.opU = false;
                    }
                    this.gcD = System.currentTimeMillis();
                    this.mode = 1;
                    this.opQ.set(this.opP.getMatrix());
                    break;
                } else {
                    this.opU = false;
                    if (this.opW == null) {
                        z = false;
                        break;
                    } else {
                        this.opW.a(this, this.opU);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.opS = null;
                if (this.opW != null) {
                    if (this.opU) {
                        this.opW.b(this);
                    }
                    if (this.opV) {
                        this.opU = false;
                    }
                    this.opW.a(this, this.opU);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.opU || motionEvent.getX() != this.brB || motionEvent.getY() != this.brC) {
                    this.opU = false;
                }
                if (this.mode == 2) {
                    this.opR.set(this.opQ);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.opX;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.opY;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.opR.postScale(an, an, this.opS.x, this.opS.y);
                    this.opR.postRotate(ao, this.opS.x, this.opS.y);
                    this.opR.postTranslate(am.x - this.opS.x, am.y - this.opS.y);
                    this.opP.getMatrix().set(this.opR);
                } else if (this.mode == 1) {
                    this.opR.set(this.opQ);
                    this.opR.postTranslate(motionEvent.getX() - this.brB, motionEvent.getY() - this.brC);
                    this.opP.getMatrix().set(this.opR);
                }
                if (!this.opU) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.opX = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.opY = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.opS = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.opQ.set(this.opP.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.eac(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.opP = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.opP = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.opV = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.opT.LJ(i);
    }
}
