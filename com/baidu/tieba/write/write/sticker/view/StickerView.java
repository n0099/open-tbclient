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
    private long dal;
    private float fyp;
    private float fyq;
    private a jWp;
    private Matrix jWq;
    private Matrix jWr;
    private PointF jWs;
    private b jWt;
    private boolean jWu;
    private com.baidu.tieba.write.write.sticker.a.a jWv;
    private float jWw;
    private float jWx;
    private boolean juD;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.jWv = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWq = new Matrix();
        this.jWr = new Matrix();
        this.jWs = new PointF();
        this.jWu = true;
        this.juD = false;
        this.dal = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.jWt = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.jWp.getMatrix().postTranslate((getWidth() - this.jWp.cAJ()) / 2, (getHeight() - this.jWp.cAK()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jWp != null) {
            this.jWp.draw(canvas);
            float[] a = f.a(this.jWp.cAL(), this.jWp.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.juD) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.jWt.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.fyp = motionEvent.getX();
                this.fyq = motionEvent.getY();
                if (this.jWp == null) {
                    return false;
                }
                if (this.juD && this.jWt.M(motionEvent)) {
                    this.jWu = false;
                    if (this.jWv != null) {
                        this.jWv.cAM();
                        break;
                    }
                } else if (a(this.jWp, motionEvent)) {
                    this.jWu = true;
                    if (System.currentTimeMillis() - this.dal <= 300 && this.jWv != null) {
                        this.jWv.a(this);
                        this.jWu = false;
                    }
                    this.dal = System.currentTimeMillis();
                    this.mode = 1;
                    this.jWq.set(this.jWp.getMatrix());
                    break;
                } else {
                    this.jWu = false;
                    if (this.jWv == null) {
                        z = false;
                        break;
                    } else {
                        this.jWv.a(this, this.jWu);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.jWs = null;
                if (this.jWv != null) {
                    if (this.jWu) {
                        this.jWv.b(this);
                    }
                    if (this.juD) {
                        this.jWu = false;
                    }
                    this.jWv.a(this, this.jWu);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.jWu || motionEvent.getX() != this.fyp || motionEvent.getY() != this.fyq) {
                    this.jWu = false;
                }
                if (this.mode == 2) {
                    this.jWr.set(this.jWq);
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) / this.jWw;
                    float P = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent) - this.jWx;
                    PointF N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                    this.jWr.postScale(O, O, this.jWs.x, this.jWs.y);
                    this.jWr.postRotate(P, this.jWs.x, this.jWs.y);
                    this.jWr.postTranslate(N.x - this.jWs.x, N.y - this.jWs.y);
                    this.jWp.getMatrix().set(this.jWr);
                } else if (this.mode == 1) {
                    this.jWr.set(this.jWq);
                    this.jWr.postTranslate(motionEvent.getX() - this.fyp, motionEvent.getY() - this.fyq);
                    this.jWp.getMatrix().set(this.jWr);
                }
                if (!this.jWu) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.jWw = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.jWx = com.baidu.tieba.write.write.sticker.b.a.P(motionEvent);
                this.jWs = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.jWq.set(this.jWp.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(f.a(aVar.cAL(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.jWp = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.jWp = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.juD = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.jWt.BQ(i);
    }
}
