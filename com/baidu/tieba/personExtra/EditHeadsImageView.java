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
/* loaded from: classes11.dex */
public class EditHeadsImageView extends DragImageView {
    private int aBe;
    private int aBf;
    private float aBg;
    private float aBh;
    private int aBj;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBj = 0;
        this.aBh = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBj = 0;
        this.aBh = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBj = 0;
        this.aBh = 1.0f;
        init();
    }

    private void init() {
        this.aBj = getResources().getColor(R.color.common_color_10226);
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
        float width = this.aBh * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBe = (int) (((i4 - i2) - width) * this.aBg);
        this.aBf = (int) (((i4 - i2) - width) * (1.0f - this.aBg));
        setOffset(0, this.aBe, 0, this.aBf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.aBj);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap bm(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aBe, getWidth(), (getHeight() - this.aBf) - this.aBe);
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
        this.aBh = f;
        invalidate();
    }
}
