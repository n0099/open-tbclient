package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes7.dex */
public class EditHeadsImageView extends DragImageView {
    private int bLq;
    private int bLr;
    private float bLs;
    private float bLt;
    private int bLv;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLv = 0;
        this.bLt = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLv = 0;
        this.bLt = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLv = 0;
        this.bLt = 1.0f;
        init();
    }

    private void init() {
        this.bLv = getResources().getColor(R.color.common_color_10226);
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
        float width = this.bLt * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bLq = (int) (((i4 - i2) - width) * this.bLs);
        this.bLr = (int) (((i4 - i2) - width) * (1.0f - this.bLs));
        setOffset(0, this.bLq, 0, this.bLr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.bLv);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap dg(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.bLq, getWidth(), (getHeight() - this.bLr) - this.bLq);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, 960, 960, false) : createBitmap;
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
        this.bLt = f;
        invalidate();
    }
}
