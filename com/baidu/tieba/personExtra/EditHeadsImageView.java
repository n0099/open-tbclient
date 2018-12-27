package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class EditHeadsImageView extends DragImageView {
    private int gwC;
    private int gwD;
    private float gwE;
    private float gwF;
    private int gwG;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwG = 0;
        this.gwF = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwG = 0;
        this.gwF = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwG = 0;
        this.gwF = 1.0f;
        init();
    }

    private void init() {
        this.gwG = getResources().getColor(e.d.common_color_10226);
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
        float width = this.gwF * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gwC = (int) (((i4 - i2) - width) * this.gwE);
        this.gwD = (int) (((i4 - i2) - width) * (1.0f - this.gwE));
        setOffset(0, this.gwC, 0, this.gwD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.gwG);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap mf(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.gwC, getWidth(), (getHeight() - this.gwD) - this.gwC);
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
        this.gwF = f;
        invalidate();
    }
}
