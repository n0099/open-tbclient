package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class EditHeadsImageView extends DragImageView {
    private int fWn;
    private int fWo;
    private float fWp;
    private float fWq;
    private int fWr;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWr = 0;
        this.fWq = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWr = 0;
        this.fWq = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWr = 0;
        this.fWq = 1.0f;
        init();
    }

    private void init() {
        this.fWr = getResources().getColor(d.C0142d.common_color_10226);
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
        float width = this.fWq * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fWn = (int) (((i4 - i2) - width) * this.fWp);
        this.fWo = (int) (((i4 - i2) - width) * (1.0f - this.fWp));
        setOffset(0, this.fWn, 0, this.fWo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.fWr);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap lp(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.fWn, getWidth(), (getHeight() - this.fWo) - this.fWn);
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
        this.fWq = f;
        invalidate();
    }
}
