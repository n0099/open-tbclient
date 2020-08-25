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
    private long fjg;
    private Context mContext;
    private Paint mPaint;
    private a mXI;
    private Matrix mXJ;
    private Matrix mXK;
    private PointF mXL;
    private b mXM;
    private boolean mXN;
    private com.baidu.tieba.write.write.sticker.a.a mXO;
    private float mXP;
    private float mXQ;
    private int mode;
    private boolean mrY;
    private float mxd;
    private float mxe;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.mXO = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mXJ = new Matrix();
        this.mXK = new Matrix();
        this.mXL = new PointF();
        this.mXN = true;
        this.mrY = false;
        this.fjg = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mXM = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mXI.getMatrix().postTranslate((getWidth() - this.mXI.dJp()) / 2, (getHeight() - this.mXI.dJq()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mXI != null) {
            this.mXI.draw(canvas);
            float[] a = g.a(this.mXI.dJr(), this.mXI.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.mrY) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.mXM.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mxd = motionEvent.getX();
                this.mxe = motionEvent.getY();
                if (this.mXI == null) {
                    return false;
                }
                if (this.mrY && this.mXM.aj(motionEvent)) {
                    this.mXN = false;
                    if (this.mXO != null) {
                        this.mXO.cyf();
                        break;
                    }
                } else if (a(this.mXI, motionEvent)) {
                    this.mXN = true;
                    if (System.currentTimeMillis() - this.fjg <= 300 && this.mXO != null) {
                        this.mXO.a(this);
                        this.mXN = false;
                    }
                    this.fjg = System.currentTimeMillis();
                    this.mode = 1;
                    this.mXJ.set(this.mXI.getMatrix());
                    break;
                } else {
                    this.mXN = false;
                    if (this.mXO == null) {
                        z = false;
                        break;
                    } else {
                        this.mXO.a(this, this.mXN);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.mXL = null;
                if (this.mXO != null) {
                    if (this.mXN) {
                        this.mXO.b(this);
                    }
                    if (this.mrY) {
                        this.mXN = false;
                    }
                    this.mXO.a(this, this.mXN);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.mXN || motionEvent.getX() != this.mxd || motionEvent.getY() != this.mxe) {
                    this.mXN = false;
                }
                if (this.mode == 2) {
                    this.mXK.set(this.mXJ);
                    float al = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent) / this.mXP;
                    float am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent) - this.mXQ;
                    PointF ak = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                    this.mXK.postScale(al, al, this.mXL.x, this.mXL.y);
                    this.mXK.postRotate(am, this.mXL.x, this.mXL.y);
                    this.mXK.postTranslate(ak.x - this.mXL.x, ak.y - this.mXL.y);
                    this.mXI.getMatrix().set(this.mXK);
                } else if (this.mode == 1) {
                    this.mXK.set(this.mXJ);
                    this.mXK.postTranslate(motionEvent.getX() - this.mxd, motionEvent.getY() - this.mxe);
                    this.mXI.getMatrix().set(this.mXK);
                }
                if (!this.mXN) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.mXP = com.baidu.tieba.write.write.sticker.b.a.al(motionEvent);
                this.mXQ = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.mXL = com.baidu.tieba.write.write.sticker.b.a.ak(motionEvent);
                this.mXJ.set(this.mXI.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.dJr(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mXI = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mXI = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.mrY = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.mXM.JU(i);
    }
}
