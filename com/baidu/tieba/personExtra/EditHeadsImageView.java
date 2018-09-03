package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class EditHeadsImageView extends DragImageView {
    private int fWE;
    private int fWF;
    private float fWG;
    private float fWH;
    private int fWI;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWI = 0;
        this.fWH = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWI = 0;
        this.fWH = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWI = 0;
        this.fWH = 1.0f;
        init();
    }

    private void init() {
        this.fWI = getResources().getColor(f.d.common_color_10226);
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
        float width = this.fWH * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fWE = (int) (((i4 - i2) - width) * this.fWG);
        this.fWF = (int) (((i4 - i2) - width) * (1.0f - this.fWG));
        setOffset(0, this.fWE, 0, this.fWF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.fWI);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap lb(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.fWE, getWidth(), (getHeight() - this.fWF) - this.fWE);
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
        this.fWH = f;
        invalidate();
    }
}
