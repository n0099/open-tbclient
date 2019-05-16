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
    private int ifM;
    private int ifN;
    private float ifO;
    private float ifP;
    private int ifQ;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifQ = 0;
        this.ifP = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifQ = 0;
        this.ifP = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifQ = 0;
        this.ifP = 1.0f;
        init();
    }

    private void init() {
        this.ifQ = getResources().getColor(R.color.common_color_10226);
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
        float width = this.ifP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ifM = (int) (((i4 - i2) - width) * this.ifO);
        this.ifN = (int) (((i4 - i2) - width) * (1.0f - this.ifO));
        setOffset(0, this.ifM, 0, this.ifN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.ifQ);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap pr(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.ifM, getWidth(), (getHeight() - this.ifN) - this.ifM);
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
        this.ifP = f;
        invalidate();
    }
}
