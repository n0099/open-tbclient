package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private int drM;
    private int drN;
    private float drO;
    private float drP;
    private int drQ;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drQ = 0;
        this.drP = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drQ = 0;
        this.drP = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drQ = 0;
        this.drP = 1.0f;
        init();
    }

    private void init() {
        this.drQ = getResources().getColor(t.d.editimage_bg);
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
        float width = this.drP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.drM = (int) (((i4 - i2) - width) * this.drO);
        this.drN = (int) (((i4 - i2) - width) * (1.0f - this.drO));
        setOffset(0, this.drM, 0, this.drN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.drQ);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap gD(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.drM, getWidth(), (getHeight() - this.drN) - this.drM);
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
        this.drP = f;
        invalidate();
    }
}
