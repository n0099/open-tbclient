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
/* loaded from: classes6.dex */
public class EditHeadsImageView extends DragImageView {
    private int hNs;
    private int hNt;
    private float hNu;
    private float hNv;
    private int hNw;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNw = 0;
        this.hNv = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNw = 0;
        this.hNv = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNw = 0;
        this.hNv = 1.0f;
        init();
    }

    private void init() {
        this.hNw = getResources().getColor(d.C0277d.common_color_10226);
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
        float width = this.hNv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.hNs = (int) (((i4 - i2) - width) * this.hNu);
        this.hNt = (int) (((i4 - i2) - width) * (1.0f - this.hNu));
        setOffset(0, this.hNs, 0, this.hNt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.hNw);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap oC(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.hNs, getWidth(), (getHeight() - this.hNt) - this.hNs);
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
        this.hNv = f;
        invalidate();
    }
}
