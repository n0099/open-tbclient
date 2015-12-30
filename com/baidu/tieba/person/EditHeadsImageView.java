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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private Paint cNO;
    private Paint cNP;
    private int cNQ;
    private int cNR;
    private float cNS;
    private int cNT;
    private float cNU;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNO = null;
        this.cNP = null;
        this.cNQ = 0;
        this.cNR = 0;
        this.cNS = 0.42857143f;
        this.cNT = 0;
        this.cNU = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNO = null;
        this.cNP = null;
        this.cNQ = 0;
        this.cNR = 0;
        this.cNS = 0.42857143f;
        this.cNT = 0;
        this.cNU = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.cNO = null;
        this.cNP = null;
        this.cNQ = 0;
        this.cNR = 0;
        this.cNS = 0.42857143f;
        this.cNT = 0;
        this.cNU = 1.0f;
        init();
    }

    private void init() {
        this.cNO = new Paint();
        this.cNO.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cNO.setAlpha(153);
        this.cNP = new Paint();
        this.cNP.setStyle(Paint.Style.STROKE);
        this.cNP.setColor(-1);
        this.cNT = getResources().getColor(n.d.editimage_bg);
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
        float width = this.cNU * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.cNQ = (int) (((i4 - i2) - width) * this.cNS);
        this.cNR = (int) (((i4 - i2) - width) * (1.0f - this.cNS));
        setOffset(0, this.cNQ, 0, this.cNR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.cNT);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.cNQ, this.cNO);
        canvas.drawRect(0.0f, getHeight() - this.cNR, getWidth(), getHeight(), this.cNO);
        canvas.drawRect(0.0f, this.cNQ, getWidth() - 1, getHeight() - this.cNR, this.cNP);
    }

    public Bitmap fB(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.cNQ, getWidth(), (getHeight() - this.cNR) - this.cNQ);
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
        this.cNU = f;
        invalidate();
    }
}
