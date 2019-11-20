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
    private int aod;
    private int aoe;
    private float aof;
    private float aog;
    private int aoi;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aoi = 0;
        this.aog = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aoi = 0;
        this.aog = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aoi = 0;
        this.aog = 1.0f;
        init();
    }

    private void init() {
        this.aoi = getResources().getColor(R.color.common_color_10226);
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
        float width = this.aog * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aod = (int) (((i4 - i2) - width) * this.aof);
        this.aoe = (int) (((i4 - i2) - width) * (1.0f - this.aof));
        setOffset(0, this.aod, 0, this.aoe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.aoi);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap aJ(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aod, getWidth(), (getHeight() - this.aoe) - this.aod);
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
        this.aog = f;
        invalidate();
    }
}
