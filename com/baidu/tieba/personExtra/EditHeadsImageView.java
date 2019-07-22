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
/* loaded from: classes6.dex */
public class EditHeadsImageView extends DragImageView {
    private int imh;
    private int imi;
    private float imj;
    private float imk;
    private int iml;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.iml = 0;
        this.imk = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.iml = 0;
        this.imk = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.iml = 0;
        this.imk = 1.0f;
        init();
    }

    private void init() {
        this.iml = getResources().getColor(R.color.common_color_10226);
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
        float width = this.imk * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.imh = (int) (((i4 - i2) - width) * this.imj);
        this.imi = (int) (((i4 - i2) - width) * (1.0f - this.imj));
        setOffset(0, this.imh, 0, this.imi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.iml);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap pG(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.imh, getWidth(), (getHeight() - this.imi) - this.imh);
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
        this.imk = f;
        invalidate();
    }
}
