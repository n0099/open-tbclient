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
    private Paint coH;
    private Paint coI;
    private int coJ;
    private int coK;
    private float coL;
    private int coM;
    private float coN;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coH = null;
        this.coI = null;
        this.coJ = 0;
        this.coK = 0;
        this.coL = 0.42857143f;
        this.coM = 0;
        this.coN = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coH = null;
        this.coI = null;
        this.coJ = 0;
        this.coK = 0;
        this.coL = 0.42857143f;
        this.coM = 0;
        this.coN = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.coH = null;
        this.coI = null;
        this.coJ = 0;
        this.coK = 0;
        this.coL = 0.42857143f;
        this.coM = 0;
        this.coN = 1.0f;
        init();
    }

    private void init() {
        this.coH = new Paint();
        this.coH.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.coH.setAlpha(153);
        this.coI = new Paint();
        this.coI.setStyle(Paint.Style.STROKE);
        this.coI.setColor(-1);
        this.coM = getResources().getColor(i.c.editimage_bg);
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
        float width = this.coN * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.coJ = (int) (((i4 - i2) - width) * this.coL);
        this.coK = (int) (((i4 - i2) - width) * (1.0f - this.coL));
        setOffset(0, this.coJ, 0, this.coK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.coM);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.coJ, this.coH);
        canvas.drawRect(0.0f, getHeight() - this.coK, getWidth(), getHeight(), this.coH);
        canvas.drawRect(0.0f, this.coJ, getWidth() - 1, getHeight() - this.coK, this.coI);
    }

    public Bitmap eU(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.coJ, getWidth(), (getHeight() - this.coK) - this.coJ);
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
        this.coN = f;
        invalidate();
    }
}
