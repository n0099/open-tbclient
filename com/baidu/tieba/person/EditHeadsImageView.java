package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private int cXk;
    private int cXl;
    private float cXm;
    private float cXn;
    private int cXo;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXo = 0;
        this.cXn = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXo = 0;
        this.cXn = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXo = 0;
        this.cXn = 1.0f;
        init();
    }

    private void init() {
        this.cXo = getResources().getColor(t.d.editimage_bg);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.cXn * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.cXk = (int) (((i4 - i2) - width) * this.cXm);
        this.cXl = (int) (((i4 - i2) - width) * (1.0f - this.cXm));
        setOffset(0, this.cXk, 0, this.cXl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.cXo);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap fQ(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.cXk, getWidth(), (getHeight() - this.cXl) - this.cXk);
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
        this.cXn = f;
        invalidate();
    }
}
