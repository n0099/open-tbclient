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
/* loaded from: classes11.dex */
public class StickerView extends ImageView {
    private long dOp;
    private float gpV;
    private float gpW;
    private boolean isEdit;
    private a kUI;
    private Matrix kUJ;
    private Matrix kUK;
    private PointF kUL;
    private b kUM;
    private boolean kUN;
    private com.baidu.tieba.write.write.sticker.a.a kUO;
    private float kUP;
    private float kUQ;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kUO = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kUJ = new Matrix();
        this.kUK = new Matrix();
        this.kUL = new PointF();
        this.kUN = true;
        this.isEdit = false;
        this.dOp = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kUM = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kUI.getMatrix().postTranslate((getWidth() - this.kUI.cVP()) / 2, (getHeight() - this.kUI.cVQ()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kUI != null) {
            this.kUI.draw(canvas);
            float[] a = g.a(this.kUI.cVR(), this.kUI.getMatrix());
            float f = a[0];
            float f2 = a[1];
            float f3 = a[2];
            float f4 = a[3];
            float f5 = a[4];
            float f6 = a[5];
            float f7 = a[6];
            float f8 = a[7];
            if (this.isEdit) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.kUM.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.gpV = motionEvent.getX();
                this.gpW = motionEvent.getY();
                if (this.kUI == null) {
                    return false;
                }
                if (this.isEdit && this.kUM.L(motionEvent)) {
                    this.kUN = false;
                    if (this.kUO != null) {
                        this.kUO.cVS();
                        break;
                    }
                } else if (a(this.kUI, motionEvent)) {
                    this.kUN = true;
                    if (System.currentTimeMillis() - this.dOp <= 300 && this.kUO != null) {
                        this.kUO.a(this);
                        this.kUN = false;
                    }
                    this.dOp = System.currentTimeMillis();
                    this.mode = 1;
                    this.kUJ.set(this.kUI.getMatrix());
                    break;
                } else {
                    this.kUN = false;
                    if (this.kUO == null) {
                        z = false;
                        break;
                    } else {
                        this.kUO.a(this, this.kUN);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kUL = null;
                if (this.kUO != null) {
                    if (this.kUN) {
                        this.kUO.b(this);
                    }
                    if (this.isEdit) {
                        this.kUN = false;
                    }
                    this.kUO.a(this, this.kUN);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kUN || motionEvent.getX() != this.gpV || motionEvent.getY() != this.gpW) {
                    this.kUN = false;
                }
                if (this.mode == 2) {
                    this.kUK.set(this.kUJ);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kUP;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kUQ;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kUK.postScale(N, N, this.kUL.x, this.kUL.y);
                    this.kUK.postRotate(O, this.kUL.x, this.kUL.y);
                    this.kUK.postTranslate(M.x - this.kUL.x, M.y - this.kUL.y);
                    this.kUI.getMatrix().set(this.kUK);
                } else if (this.mode == 1) {
                    this.kUK.set(this.kUJ);
                    this.kUK.postTranslate(motionEvent.getX() - this.gpV, motionEvent.getY() - this.gpW);
                    this.kUI.getMatrix().set(this.kUK);
                }
                if (!this.kUN) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kUP = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kUQ = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kUL = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kUJ.set(this.kUI.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cVR(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kUI = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kUI = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kUM.Es(i);
    }
}
