package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes8.dex */
public class EditHeadsImageView extends DragImageView {
    private int bKS;
    private int bKT;
    private float bKU;
    private float bKV;
    private int bKX;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKX = 0;
        this.bKV = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKX = 0;
        this.bKV = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKX = 0;
        this.bKV = 1.0f;
        init();
    }

    private void init() {
        this.bKX = getResources().getColor(R.color.common_color_10226);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bKV * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bKS = (int) (((i4 - i2) - width) * this.bKU);
        this.bKT = (int) (((i4 - i2) - width) * (1.0f - this.bKU));
        setOffset(0, this.bKS, 0, this.bKT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.bKX);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap dc(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.bKS, getWidth(), (getHeight() - this.bKT) - this.bKS);
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
        this.bKV = f;
        invalidate();
    }
}
