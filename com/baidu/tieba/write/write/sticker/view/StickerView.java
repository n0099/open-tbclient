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
/* loaded from: classes3.dex */
public class StickerView extends ImageView {
    private long eYv;
    private Context mContext;
    private a mEG;
    private Matrix mEH;
    private Matrix mEI;
    private PointF mEJ;
    private b mEK;
    private boolean mEL;
    private com.baidu.tieba.write.write.sticker.a.a mEM;
    private float mEN;
    private float mEO;
    private Paint mPaint;
    private boolean mak;
    private float mfr;
    private float mfs;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mEM = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEH = new Matrix();
        this.mEI = new Matrix();
        this.mEJ = new PointF();
        this.mEL = true;
        this.mak = false;
        this.eYv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mEK = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mEG.getMatrix().postTranslate((getWidth() - this.mEG.dxA()) / 2, (getHeight() - this.mEG.dxB()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mEG != null) {
            this.mEG.draw(canvas);
            float[] a = g.a(this.mEG.dxC(), this.mEG.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.mak) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mEK.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mfr = motionEvent.getX();
                this.mfs = motionEvent.getY();
                if (this.mEG == null) {
                    return false;
                }
                if (this.mak && this.mEK.Q(motionEvent)) {
                    this.mEL = false;
                    if (this.mEM != null) {
                        this.mEM.dxD();
                        break;
                    }
                } else if (a(this.mEG, motionEvent)) {
                    this.mEL = true;
                    if (System.currentTimeMillis() - this.eYv <= 300 && this.mEM != null) {
                        this.mEM.a(this);
                        this.mEL = false;
                    }
                    this.eYv = System.currentTimeMillis();
                    this.mode = 1;
                    this.mEH.set(this.mEG.getMatrix());
                    break;
                } else {
                    this.mEL = false;
                    if (this.mEM == null) {
                        z = false;
                        break;
                    } else {
                        this.mEM.a(this, this.mEL);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mEJ = null;
                if (this.mEM != null) {
                    if (this.mEL) {
                        this.mEM.b(this);
                    }
                    if (this.mak) {
                        this.mEL = false;
                    }
                    this.mEM.a(this, this.mEL);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mEL || motionEvent.getX() != this.mfr || motionEvent.getY() != this.mfs) {
                    this.mEL = false;
                }
                if (this.mode == 2) {
                    this.mEI.set(this.mEH);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.mEN;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.mEO;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.mEI.postScale(S, S, this.mEJ.x, this.mEJ.y);
                    this.mEI.postRotate(T, this.mEJ.x, this.mEJ.y);
                    this.mEI.postTranslate(R.x - this.mEJ.x, R.y - this.mEJ.y);
                    this.mEG.getMatrix().set(this.mEI);
                } else if (this.mode == 1) {
                    this.mEI.set(this.mEH);
                    this.mEI.postTranslate(motionEvent.getX() - this.mfr, motionEvent.getY() - this.mfs);
                    this.mEG.getMatrix().set(this.mEI);
                }
                if (!this.mEL) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mEN = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.mEO = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.mEJ = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.mEH.set(this.mEG.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dxC(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mEG = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mEG = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.mak = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mEK.Hu(i);
    }
}
