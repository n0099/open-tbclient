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
    private a onJ;
    private Matrix onK;
    private Matrix onL;
    private PointF onM;
    private b onN;
    private boolean onO;
    private boolean onP;
    private com.baidu.tieba.write.write.sticker.a.a onQ;
    private float onR;
    private float onS;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.onQ = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onK = new Matrix();
        this.onL = new Matrix();
        this.onM = new PointF();
        this.onO = true;
        this.onP = false;
        this.gbc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.onN = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.onJ.getMatrix().postTranslate((getWidth() - this.onJ.dZS()) / 2, (getHeight() - this.onJ.dZT()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.onJ != null) {
            this.onJ.draw(canvas);
            float[] a2 = h.a(this.onJ.dZU(), this.onJ.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.onP) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.onN.a(canvas, f3, f4);
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
                if (this.onJ == null) {
                    return false;
                }
                if (this.onP && this.onN.al(motionEvent)) {
                    this.onO = false;
                    if (this.onQ != null) {
                        this.onQ.cRw();
                        break;
                    }
                } else if (a(this.onJ, motionEvent)) {
                    this.onO = true;
                    if (System.currentTimeMillis() - this.gbc <= 300 && this.onQ != null) {
                        this.onQ.a(this);
                        this.onO = false;
                    }
                    this.gbc = System.currentTimeMillis();
                    this.mode = 1;
                    this.onK.set(this.onJ.getMatrix());
                    break;
                } else {
                    this.onO = false;
                    if (this.onQ == null) {
                        z = false;
                        break;
                    } else {
                        this.onQ.a(this, this.onO);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.onM = null;
                if (this.onQ != null) {
                    if (this.onO) {
                        this.onQ.b(this);
                    }
                    if (this.onP) {
                        this.onO = false;
                    }
                    this.onQ.a(this, this.onO);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.onO || motionEvent.getX() != this.bqb || motionEvent.getY() != this.bqc) {
                    this.onO = false;
                }
                if (this.mode == 2) {
                    this.onL.set(this.onK);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.onR;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.onS;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.onL.postScale(an, an, this.onM.x, this.onM.y);
                    this.onL.postRotate(ao, this.onM.x, this.onM.y);
                    this.onL.postTranslate(am.x - this.onM.x, am.y - this.onM.y);
                    this.onJ.getMatrix().set(this.onL);
                } else if (this.mode == 1) {
                    this.onL.set(this.onK);
                    this.onL.postTranslate(motionEvent.getX() - this.bqb, motionEvent.getY() - this.bqc);
                    this.onJ.getMatrix().set(this.onL);
                }
                if (!this.onO) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.onR = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.onS = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.onM = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.onK.set(this.onJ.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(h.a(aVar.dZU(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.onJ = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.onJ = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.onP = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.onN.LF(i);
    }
}
