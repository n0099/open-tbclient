package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private float coA;
    private int coB;
    private float coC;
    private Paint cow;
    private Paint cox;
    private int coy;
    private int coz;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cow = null;
        this.cox = null;
        this.coy = 0;
        this.coz = 0;
        this.coA = 0.42857143f;
        this.coB = 0;
        this.coC = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cow = null;
        this.cox = null;
        this.coy = 0;
        this.coz = 0;
        this.coA = 0.42857143f;
        this.coB = 0;
        this.coC = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.cow = null;
        this.cox = null;
        this.coy = 0;
        this.coz = 0;
        this.coA = 0.42857143f;
        this.coB = 0;
        this.coC = 1.0f;
        init();
    }

    private void init() {
        this.cow = new Paint();
        this.cow.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cow.setAlpha(153);
        this.cox = new Paint();
        this.cox.setStyle(Paint.Style.STROKE);
        this.cox.setColor(-1);
        this.coB = getResources().getColor(i.c.editimage_bg);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.coC * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.coy = (int) (((i4 - i2) - width) * this.coA);
        this.coz = (int) (((i4 - i2) - width) * (1.0f - this.coA));
        setOffset(0, this.coy, 0, this.coz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.coB);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.coy, this.cow);
        canvas.drawRect(0.0f, getHeight() - this.coz, getWidth(), getHeight(), this.cow);
        canvas.drawRect(0.0f, this.coy, getWidth() - 1, getHeight() - this.coz, this.cox);
    }

    public Bitmap eU(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.coy, getWidth(), (getHeight() - this.coz) - this.coy);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, TbConfig.HEAD_IMG_SIZE, TbConfig.HEAD_IMG_SIZE, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return bitmap;
    }

    public void setCutImageHeightScale(float f) {
        this.coC = f;
        invalidate();
    }
}
