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
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long bvi;
    private float dOk;
    private float dOl;
    private boolean hBp;
    private a idF;
    private Matrix idG;
    private Matrix idH;
    private PointF idI;
    private b idJ;
    private boolean idK;
    private com.baidu.tieba.write.write.sticker.a.a idL;
    private float idM;
    private float idN;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.idL = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.idG = new Matrix();
        this.idH = new Matrix();
        this.idI = new PointF();
        this.idK = true;
        this.hBp = false;
        this.bvi = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.idJ = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, e.C0210e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.idF.getMatrix().postTranslate((getWidth() - this.idF.bRk()) / 2, (getHeight() - this.idF.bRl()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.idF != null) {
            this.idF.draw(canvas);
            float[] a = com.baidu.tbadk.util.e.a(this.idF.bRm(), this.idF.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.hBp) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.idJ.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.dOk = motionEvent.getX();
                this.dOl = motionEvent.getY();
                if (this.idF == null) {
                    return false;
                }
                if (this.hBp && this.idJ.Q(motionEvent)) {
                    this.idK = false;
                    if (this.idL != null) {
                        this.idL.bRn();
                        break;
                    }
                } else if (a(this.idF, motionEvent)) {
                    this.idK = true;
                    if (System.currentTimeMillis() - this.bvi <= 300 && this.idL != null) {
                        this.idL.a(this);
                        this.idK = false;
                    }
                    this.bvi = System.currentTimeMillis();
                    this.mode = 1;
                    this.idG.set(this.idF.getMatrix());
                    break;
                } else {
                    this.idK = false;
                    if (this.idL == null) {
                        z = false;
                        break;
                    } else {
                        this.idL.a(this, this.idK);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.idI = null;
                if (this.idL != null) {
                    if (this.idK) {
                        this.idL.b(this);
                    }
                    if (this.hBp) {
                        this.idK = false;
                    }
                    this.idL.a(this, this.idK);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.idK || motionEvent.getX() != this.dOk || motionEvent.getY() != this.dOl) {
                    this.idK = false;
                }
                if (this.mode == 2) {
                    this.idH.set(this.idG);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.idM;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.idN;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.idH.postScale(S, S, this.idI.x, this.idI.y);
                    this.idH.postRotate(T, this.idI.x, this.idI.y);
                    this.idH.postTranslate(R.x - this.idI.x, R.y - this.idI.y);
                    this.idF.getMatrix().set(this.idH);
                } else if (this.mode == 1) {
                    this.idH.set(this.idG);
                    this.idH.postTranslate(motionEvent.getX() - this.dOk, motionEvent.getY() - this.dOl);
                    this.idF.getMatrix().set(this.idH);
                }
                if (!this.idK) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.idM = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.idN = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.idI = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.idG.set(this.idF.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(com.baidu.tbadk.util.e.a(aVar.bRm(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.idF = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.idF = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.hBp = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.idJ.xL(i);
    }
}
