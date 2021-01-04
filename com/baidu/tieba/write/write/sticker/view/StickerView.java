package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.a;
import com.baidu.tieba.write.write.sticker.a.b;
/* loaded from: classes8.dex */
public class StickerView extends ImageView {
    private float brm;
    private float brn;
    private long gdt;
    private Context mContext;
    private Paint mPaint;
    private int mode;
    private a ohX;
    private Matrix ohY;
    private Matrix ohZ;
    private PointF oia;
    private b oib;
    private boolean oic;
    private boolean oid;
    private com.baidu.tieba.write.write.sticker.a.a oie;
    private float oif;
    private float oig;

    public void setmOnStickerActionListener(com.baidu.tieba.write.write.sticker.a.a aVar) {
        this.oie = aVar;
    }

    public StickerView(Context context) {
        this(context, null);
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ohY = new Matrix();
        this.ohZ = new Matrix();
        this.oia = new PointF();
        this.oic = true;
        this.oid = false;
        this.gdt = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.oib = new b(context);
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(l.getDimens(context, R.dimen.ds4));
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.ohX.getMatrix().postTranslate((getWidth() - this.ohX.ebq()) / 2, (getHeight() - this.ohX.ebr()) / 2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ohX != null) {
            this.ohX.draw(canvas);
            float[] a2 = g.a(this.ohX.ebs(), this.ohX.getMatrix());
            float f = a2[0];
            float f2 = a2[1];
            float f3 = a2[2];
            float f4 = a2[3];
            float f5 = a2[4];
            float f6 = a2[5];
            float f7 = a2[6];
            float f8 = a2[7];
            if (this.oid) {
                canvas.drawLine(f, f2, f3, f4, this.mPaint);
                canvas.drawLine(f3, f4, f7, f8, this.mPaint);
                canvas.drawLine(f7, f8, f5, f6, this.mPaint);
                canvas.drawLine(f5, f6, f, f2, this.mPaint);
                canvas.drawPoint(f, f2, this.mPaint);
                canvas.drawPoint(f3, f4, this.mPaint);
                canvas.drawPoint(f5, f6, this.mPaint);
                canvas.drawPoint(f7, f8, this.mPaint);
                this.oib.a(canvas, f3, f4);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.brm = motionEvent.getX();
                this.brn = motionEvent.getY();
                if (this.ohX == null) {
                    return false;
                }
                if (this.oid && this.oib.al(motionEvent)) {
                    this.oic = false;
                    if (this.oie != null) {
                        this.oie.cTh();
                        break;
                    }
                } else if (a(this.ohX, motionEvent)) {
                    this.oic = true;
                    if (System.currentTimeMillis() - this.gdt <= 300 && this.oie != null) {
                        this.oie.a(this);
                        this.oic = false;
                    }
                    this.gdt = System.currentTimeMillis();
                    this.mode = 1;
                    this.ohY.set(this.ohX.getMatrix());
                    break;
                } else {
                    this.oic = false;
                    if (this.oie == null) {
                        z = false;
                        break;
                    } else {
                        this.oie.a(this, this.oic);
                        invalidate();
                        z = false;
                        break;
                    }
                }
                break;
            case 1:
            case 6:
                this.mode = 0;
                this.oia = null;
                if (this.oie != null) {
                    if (this.oic) {
                        this.oie.b(this);
                    }
                    if (this.oid) {
                        this.oic = false;
                    }
                    this.oie.a(this, this.oic);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (!this.oic || motionEvent.getX() != this.brm || motionEvent.getY() != this.brn) {
                    this.oic = false;
                }
                if (this.mode == 2) {
                    this.ohZ.set(this.ohY);
                    float an = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent) / this.oif;
                    float ao = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent) - this.oig;
                    PointF am = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                    this.ohZ.postScale(an, an, this.oia.x, this.oia.y);
                    this.ohZ.postRotate(ao, this.oia.x, this.oia.y);
                    this.ohZ.postTranslate(am.x - this.oia.x, am.y - this.oia.y);
                    this.ohX.getMatrix().set(this.ohZ);
                } else if (this.mode == 1) {
                    this.ohZ.set(this.ohY);
                    this.ohZ.postTranslate(motionEvent.getX() - this.brm, motionEvent.getY() - this.brn);
                    this.ohX.getMatrix().set(this.ohZ);
                }
                if (!this.oic) {
                    invalidate();
                    break;
                }
                break;
            case 5:
                this.mode = 2;
                this.oif = com.baidu.tieba.write.write.sticker.b.a.an(motionEvent);
                this.oig = com.baidu.tieba.write.write.sticker.b.a.ao(motionEvent);
                this.oia = com.baidu.tieba.write.write.sticker.b.a.am(motionEvent);
                this.ohY.set(this.ohX.getMatrix());
                break;
        }
        return z;
    }

    private boolean a(a aVar, MotionEvent motionEvent) {
        return com.baidu.tieba.write.write.sticker.b.a.b(g.a(aVar.ebs(), aVar.getMatrix()), motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.ohX = new a(BitmapHelper.getResBitmap(this.mContext, i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ohX = new a(bitmap);
    }

    public void setEdit(boolean z) {
        this.oid = z;
        postInvalidate();
    }

    public void setRemoveRes(int i) {
        this.oib.MR(i);
    }
}
