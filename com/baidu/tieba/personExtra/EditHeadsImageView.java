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
/* loaded from: classes18.dex */
public class EditHeadsImageView extends DragImageView {
    private int bnG;
    private int bnH;
    private float bnI;
    private float bnJ;
    private int bnL;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnL = 0;
        this.bnJ = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnL = 0;
        this.bnJ = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnL = 0;
        this.bnJ = 1.0f;
        init();
    }

    private void init() {
        this.bnL = getResources().getColor(R.color.common_color_10226);
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
        float width = this.bnJ * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bnG = (int) (((i4 - i2) - width) * this.bnI);
        this.bnH = (int) (((i4 - i2) - width) * (1.0f - this.bnI));
        setOffset(0, this.bnG, 0, this.bnH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.bnL);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap cs(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.bnG, getWidth(), (getHeight() - this.bnH) - this.bnG);
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
        this.bnJ = f;
        invalidate();
    }
}
