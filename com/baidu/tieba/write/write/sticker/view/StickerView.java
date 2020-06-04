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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes2.dex */
public class StickerView extends ImageView {
    private long eHO;
    private float lEo;
    private float lEp;
    private boolean lzo;
    private Context mContext;
    private Paint mPaint;
    private a mbL;
    private Matrix mbM;
    private Matrix mbN;
    private PointF mbO;
    private b mbP;
    private boolean mbQ;
    private com.baidu.tieba.write.write.sticker.a.a mbR;
    private float mbS;
    private float mbT;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mbR = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mbM = new Matrix();
        this.mbN = new Matrix();
        this.mbO = new PointF();
        this.mbQ = true;
        this.lzo = false;
        this.eHO = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mbP = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mbL.getMatrix().postTranslate((getWidth() - this.mbL.dpP()) / 2, (getHeight() - this.mbL.dpQ()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mbL != null) {
            this.mbL.draw(canvas);
            float[] a = g.a(this.mbL.dpR(), this.mbL.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.lzo) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mbP.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.lEo = motionEvent.getX();
                this.lEp = motionEvent.getY();
                if (this.mbL == null) {
                    return false;
                }
                if (this.lzo && this.mbP.Q(motionEvent)) {
                    this.mbQ = false;
                    if (this.mbR != null) {
                        this.mbR.dpS();
                        break;
                    }
                } else if (a(this.mbL, motionEvent)) {
                    this.mbQ = true;
                    if (System.currentTimeMillis() - this.eHO <= 300 && this.mbR != null) {
                        this.mbR.a(this);
                        this.mbQ = false;
                    }
                    this.eHO = System.currentTimeMillis();
                    this.mode = 1;
                    this.mbM.set(this.mbL.getMatrix());
                    break;
                } else {
                    this.mbQ = false;
                    if (this.mbR == null) {
                        z = false;
                        break;
                    } else {
                        this.mbR.a(this, this.mbQ);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mbO = null;
                if (this.mbR != null) {
                    if (this.mbQ) {
                        this.mbR.b(this);
                    }
                    if (this.lzo) {
                        this.mbQ = false;
                    }
                    this.mbR.a(this, this.mbQ);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mbQ || motionEvent.getX() != this.lEo || motionEvent.getY() != this.lEp) {
                    this.mbQ = false;
                }
                if (this.mode == 2) {
                    this.mbN.set(this.mbM);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.mbS;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.mbT;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.mbN.postScale(S, S, this.mbO.x, this.mbO.y);
                    this.mbN.postRotate(T, this.mbO.x, this.mbO.y);
                    this.mbN.postTranslate(R.x - this.mbO.x, R.y - this.mbO.y);
                    this.mbL.getMatrix().set(this.mbN);
                } else if (this.mode == 1) {
                    this.mbN.set(this.mbM);
                    this.mbN.postTranslate(motionEvent.getX() - this.lEo, motionEvent.getY() - this.lEp);
                    this.mbL.getMatrix().set(this.mbN);
                }
                if (!this.mbQ) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mbS = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.mbT = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.mbO = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.mbM.set(this.mbL.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dpR(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mbL = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mbL = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.lzo = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mbP.FU(i);
    }
}
