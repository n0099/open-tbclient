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
    private a mEI;
    private Matrix mEJ;
    private Matrix mEK;
    private PointF mEL;
    private b mEM;
    private boolean mEN;
    private com.baidu.tieba.write.write.sticker.a.a mEO;
    private float mEP;
    private float mEQ;
    private Paint mPaint;
    private boolean mam;
    private float mft;
    private float mfu;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mEO = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEJ = new Matrix();
        this.mEK = new Matrix();
        this.mEL = new PointF();
        this.mEN = true;
        this.mam = false;
        this.eYv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mEM = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mEI.getMatrix().postTranslate((getWidth() - this.mEI.dxB()) / 2, (getHeight() - this.mEI.dxC()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mEI != null) {
            this.mEI.draw(canvas);
            float[] a = g.a(this.mEI.dxD(), this.mEI.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.mam) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mEM.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mft = motionEvent.getX();
                this.mfu = motionEvent.getY();
                if (this.mEI == null) {
                    return false;
                }
                if (this.mam && this.mEM.Q(motionEvent)) {
                    this.mEN = false;
                    if (this.mEO != null) {
                        this.mEO.dxE();
                        break;
                    }
                } else if (a(this.mEI, motionEvent)) {
                    this.mEN = true;
                    if (System.currentTimeMillis() - this.eYv <= 300 && this.mEO != null) {
                        this.mEO.a(this);
                        this.mEN = false;
                    }
                    this.eYv = System.currentTimeMillis();
                    this.mode = 1;
                    this.mEJ.set(this.mEI.getMatrix());
                    break;
                } else {
                    this.mEN = false;
                    if (this.mEO == null) {
                        z = false;
                        break;
                    } else {
                        this.mEO.a(this, this.mEN);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mEL = null;
                if (this.mEO != null) {
                    if (this.mEN) {
                        this.mEO.b(this);
                    }
                    if (this.mam) {
                        this.mEN = false;
                    }
                    this.mEO.a(this, this.mEN);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mEN || motionEvent.getX() != this.mft || motionEvent.getY() != this.mfu) {
                    this.mEN = false;
                }
                if (this.mode == 2) {
                    this.mEK.set(this.mEJ);
                    float S = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent) / this.mEP;
                    float T = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent) - this.mEQ;
                    PointF R = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                    this.mEK.postScale(S, S, this.mEL.x, this.mEL.y);
                    this.mEK.postRotate(T, this.mEL.x, this.mEL.y);
                    this.mEK.postTranslate(R.x - this.mEL.x, R.y - this.mEL.y);
                    this.mEI.getMatrix().set(this.mEK);
                } else if (this.mode == 1) {
                    this.mEK.set(this.mEJ);
                    this.mEK.postTranslate(motionEvent.getX() - this.mft, motionEvent.getY() - this.mfu);
                    this.mEI.getMatrix().set(this.mEK);
                }
                if (!this.mEN) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mEP = com.baidu.tieba.write.write.sticker.b.a.S(motionEvent);
                this.mEQ = com.baidu.tieba.write.write.sticker.b.a.T(motionEvent);
                this.mEL = com.baidu.tieba.write.write.sticker.b.a.R(motionEvent);
                this.mEJ.set(this.mEI.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dxD(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mEI = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mEI = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.mam = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mEM.Hu(i);
    }
}
