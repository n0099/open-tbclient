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
    private a kUD;
    private Matrix kUE;
    private Matrix kUF;
    private PointF kUG;
    private b kUH;
    private boolean kUI;
    private com.baidu.tieba.write.write.sticker.a.a kUJ;
    private float kUK;
    private float kUL;
    private Context mContext;
    private Paint mPaint;
    private int mode;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.kUJ = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kUE = new Matrix();
        this.kUF = new Matrix();
        this.kUG = new PointF();
        this.kUI = true;
        this.isEdit = false;
        this.dOp = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kUH = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.kUD.getMatrix().postTranslate((getWidth() - this.kUD.cVN()) / 2, (getHeight() - this.kUD.cVO()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.kUD != null) {
            this.kUD.draw(canvas);
            float[] a = g.a(this.kUD.cVP(), this.kUD.getMatrix());
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
                this.kUH.a(canvas, f3, f4);
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
                if (this.kUD == null) {
                    return false;
                }
                if (this.isEdit && this.kUH.L(motionEvent)) {
                    this.kUI = false;
                    if (this.kUJ != null) {
                        this.kUJ.cVQ();
                        break;
                    }
                } else if (a(this.kUD, motionEvent)) {
                    this.kUI = true;
                    if (System.currentTimeMillis() - this.dOp <= 300 && this.kUJ != null) {
                        this.kUJ.a(this);
                        this.kUI = false;
                    }
                    this.dOp = System.currentTimeMillis();
                    this.mode = 1;
                    this.kUE.set(this.kUD.getMatrix());
                    break;
                } else {
                    this.kUI = false;
                    if (this.kUJ == null) {
                        z = false;
                        break;
                    } else {
                        this.kUJ.a(this, this.kUI);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.kUG = null;
                if (this.kUJ != null) {
                    if (this.kUI) {
                        this.kUJ.b(this);
                    }
                    if (this.isEdit) {
                        this.kUI = false;
                    }
                    this.kUJ.a(this, this.kUI);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.kUI || motionEvent.getX() != this.gpV || motionEvent.getY() != this.gpW) {
                    this.kUI = false;
                }
                if (this.mode == 2) {
                    this.kUF.set(this.kUE);
                    float N = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent) / this.kUK;
                    float O = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent) - this.kUL;
                    PointF M = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                    this.kUF.postScale(N, N, this.kUG.x, this.kUG.y);
                    this.kUF.postRotate(O, this.kUG.x, this.kUG.y);
                    this.kUF.postTranslate(M.x - this.kUG.x, M.y - this.kUG.y);
                    this.kUD.getMatrix().set(this.kUF);
                } else if (this.mode == 1) {
                    this.kUF.set(this.kUE);
                    this.kUF.postTranslate(motionEvent.getX() - this.gpV, motionEvent.getY() - this.gpW);
                    this.kUD.getMatrix().set(this.kUF);
                }
                if (!this.kUI) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.kUK = com.baidu.tieba.write.write.sticker.b.a.N(motionEvent);
                this.kUL = com.baidu.tieba.write.write.sticker.b.a.O(motionEvent);
                this.kUG = com.baidu.tieba.write.write.sticker.b.a.M(motionEvent);
                this.kUE.set(this.kUD.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.c(g.a(aVar.cVP(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.kUD = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.kUD = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.kUH.Es(i);
    }
}
