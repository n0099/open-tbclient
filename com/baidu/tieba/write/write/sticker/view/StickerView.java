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
    private long cQN;
    private float fxF;
    private float fxG;
    private a jVE;
    private Matrix jVF;
    private Matrix jVG;
    private PointF jVH;
    private b jVI;
    private boolean jVJ;
    private com.baidu.tieba.write.write.sticker.a.a jVK;
    private float jVL;
    private float jVM;
    private boolean jsa;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jVK = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jVF = new Matrix();
        this.jVG = new Matrix();
        this.jVH = new PointF();
        this.jVJ = true;
        this.jsa = false;
        this.cQN = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jVI = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.g(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jVE.getMatrix().postTranslate((getWidth() - this.jVE.cCS()) / 2, (getHeight() - this.jVE.cCT()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jVE != null) {
            this.jVE.draw(canvas);
            float[] a = f.a(this.jVE.cCU(), this.jVE.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.jsa) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jVI.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fxF = motionEvent.getX();
                this.fxG = motionEvent.getY();
                if (this.jVE == null) {
                    return false;
                }
                if (this.jsa && this.jVI.V(motionEvent)) {
                    this.jVJ = false;
                    if (this.jVK != null) {
                        this.jVK.cCV();
                        break;
                    }
                } else if (a(this.jVE, motionEvent)) {
                    this.jVJ = true;
                    if (System.currentTimeMillis() - this.cQN <= 300 && this.jVK != null) {
                        this.jVK.a(this);
                        this.jVJ = false;
                    }
                    this.cQN = System.currentTimeMillis();
                    this.mode = 1;
                    this.jVF.set(this.jVE.getMatrix());
                    break;
                } else {
                    this.jVJ = false;
                    if (this.jVK == null) {
                        z = false;
                        break;
                    } else {
                        this.jVK.a(this, this.jVJ);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jVH = null;
                if (this.jVK != null) {
                    if (this.jVJ) {
                        this.jVK.b(this);
                    }
                    if (this.jsa) {
                        this.jVJ = false;
                    }
                    this.jVK.a(this, this.jVJ);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jVJ || motionEvent.getX() != this.fxF || motionEvent.getY() != this.fxG) {
                    this.jVJ = false;
                }
                if (this.mode == 2) {
                    this.jVG.set(this.jVF);
                    float X = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent) / this.jVL;
                    float Y = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent) - this.jVM;
                    PointF W = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                    this.jVG.postScale(X, X, this.jVH.x, this.jVH.y);
                    this.jVG.postRotate(Y, this.jVH.x, this.jVH.y);
                    this.jVG.postTranslate(W.x - this.jVH.x, W.y - this.jVH.y);
                    this.jVE.getMatrix().set(this.jVG);
                } else if (this.mode == 1) {
                    this.jVG.set(this.jVF);
                    this.jVG.postTranslate(motionEvent.getX() - this.fxF, motionEvent.getY() - this.fxG);
                    this.jVE.getMatrix().set(this.jVG);
                }
                if (!this.jVJ) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jVL = com.baidu.tieba.write.write.sticker.b.a.X(motionEvent);
                this.jVM = com.baidu.tieba.write.write.sticker.b.a.Y(motionEvent);
                this.jVH = com.baidu.tieba.write.write.sticker.b.a.W(motionEvent);
                this.jVF.set(this.jVE.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.cCU(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jVE = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jVE = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.jsa = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jVI.Dp(i);
    }
}
