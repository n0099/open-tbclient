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
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long cQU;
    private float fye;
    private float fyf;
    private a jWK;
    private Matrix jWL;
    private Matrix jWM;
    private PointF jWN;
    private b jWO;
    private boolean jWP;
    private com.baidu.tieba.write.write.sticker.a.a jWQ;
    private float jWR;
    private float jWS;
    private boolean jth;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jWQ = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWL = new Matrix();
        this.jWM = new Matrix();
        this.jWN = new PointF();
        this.jWP = true;
        this.jth = false;
        this.cQU = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jWO = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jWK.getMatrix().postTranslate((getWidth() - this.jWK.cDn()) / 2, (getHeight() - this.jWK.cDo()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jWK != null) {
            this.jWK.draw(canvas);
            float[] a = f.a(this.jWK.cDp(), this.jWK.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jth) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jWO.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fye = motionEvent.getX();
                this.fyf = motionEvent.getY();
                if (this.jWK == null) {
                    return false;
                }
                if (this.jth && this.jWO.V(motionEvent)) {
                    this.jWP = false;
                    if (this.jWQ != null) {
                        this.jWQ.cDq();
                        break;
                    }
                } else if (a(this.jWK, motionEvent)) {
                    this.jWP = true;
                    if (System.currentTimeMillis() - this.cQU <= 300 && this.jWQ != null) {
                        this.jWQ.a(this);
                        this.jWP = false;
                    }
                    this.cQU = System.currentTimeMillis();
                    this.mode = 1;
                    this.jWL.set(this.jWK.getMatrix());
                    break;
                } else {
                    this.jWP = false;
                    if (this.jWQ == null) {
                        z = false;
                        break;
                    } else {
                        this.jWQ.a(this, this.jWP);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jWN = null;
                if (this.jWQ != null) {
                    if (this.jWP) {
                        this.jWQ.b(this);
                    }
                    if (this.jth) {
                        this.jWP = false;
                    }
                    this.jWQ.a(this, this.jWP);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jWP || motionEvent.getX() != this.fye || motionEvent.getY() != this.fyf) {
                    this.jWP = false;
                }
                if (this.mode == 2) {
                    this.jWM.set(this.jWL);
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) / this.jWR;
                    float Y = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent) - this.jWS;
                    PointF W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                    this.jWM.postScale(X, X, this.jWN.x, this.jWN.y);
                    this.jWM.postRotate(Y, this.jWN.x, this.jWN.y);
                    this.jWM.postTranslate(W.x - this.jWN.x, W.y - this.jWN.y);
                    this.jWK.getMatrix().set(this.jWM);
                } else if (this.mode == 1) {
                    this.jWM.set(this.jWL);
                    this.jWM.postTranslate(motionEvent.getX() - this.fye, motionEvent.getY() - this.fyf);
                    this.jWK.getMatrix().set(this.jWM);
                }
                if (!this.jWP) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jWR = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jWS = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent);
                this.jWN = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jWL.set(this.jWK.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.cDp(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jWK = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jWK = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jth = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jWO.Dr(i);
    }
}
