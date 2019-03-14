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
import com.baidu.tbadk.util.f;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long cHe;
    private float fcH;
    private float fcI;
    private boolean iTe;
    private a jvI;
    private Matrix jvJ;
    private Matrix jvK;
    private PointF jvL;
    private b jvM;
    private boolean jvN;
    private com.baidu.tieba.write.write.sticker.a.a jvO;
    private float jvP;
    private float jvQ;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jvO = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvJ = new Matrix();
        this.jvK = new Matrix();
        this.jvL = new PointF();
        this.jvN = true;
        this.iTe = false;
        this.cHe = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jvM = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.h(context, d.e.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jvI.getMatrix().postTranslate((getWidth() - this.jvI.crO()) / 2, (getHeight() - this.jvI.crP()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jvI != null) {
            this.jvI.draw(canvas);
            float[] a = f.a(this.jvI.crQ(), this.jvI.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.iTe) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jvM.draw(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fcH = motionEvent.getX();
                this.fcI = motionEvent.getY();
                if (this.jvI == null) {
                    return false;
                }
                if (this.iTe && this.jvM.R(motionEvent)) {
                    this.jvN = false;
                    if (this.jvO != null) {
                        this.jvO.crR();
                        break;
                    }
                } else if (a(this.jvI, motionEvent)) {
                    this.jvN = true;
                    if (System.currentTimeMillis() - this.cHe <= 300 && this.jvO != null) {
                        this.jvO.a(this);
                        this.jvN = false;
                    }
                    this.cHe = System.currentTimeMillis();
                    this.mode = 1;
                    this.jvJ.set(this.jvI.getMatrix());
                    break;
                } else {
                    this.jvN = false;
                    if (this.jvO == null) {
                        z = false;
                        break;
                    } else {
                        this.jvO.a(this, this.jvN);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jvL = null;
                if (this.jvO != null) {
                    if (this.jvN) {
                        this.jvO.b(this);
                    }
                    if (this.iTe) {
                        this.jvN = false;
                    }
                    this.jvO.a(this, this.jvN);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jvN || motionEvent.getX() != this.fcH || motionEvent.getY() != this.fcI) {
                    this.jvN = false;
                }
                if (this.mode == 2) {
                    this.jvK.set(this.jvJ);
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) / this.jvP;
                    float U = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent) - this.jvQ;
                    PointF S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                    this.jvK.postScale(T, T, this.jvL.x, this.jvL.y);
                    this.jvK.postRotate(U, this.jvL.x, this.jvL.y);
                    this.jvK.postTranslate(S.x - this.jvL.x, S.y - this.jvL.y);
                    this.jvI.getMatrix().set(this.jvK);
                } else if (this.mode == 1) {
                    this.jvK.set(this.jvJ);
                    this.jvK.postTranslate(motionEvent.getX() - this.fcH, motionEvent.getY() - this.fcI);
                    this.jvI.getMatrix().set(this.jvK);
                }
                if (!this.jvN) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jvP = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.jvQ = com.baidu.tieba.write.write.sticker.b.a.U(motionEvent);
                this.jvL = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.jvJ.set(this.jvI.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.a(f.a(aVar.crQ(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jvI = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jvI = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.iTe = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jvM.BD(i);
    }
}
