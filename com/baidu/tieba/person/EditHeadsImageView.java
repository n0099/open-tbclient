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
    private int dvi;
    private int dvj;
    private float dvk;
    private float dvl;
    private int dvm;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvm = 0;
        this.dvl = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvm = 0;
        this.dvl = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvm = 0;
        this.dvl = 1.0f;
        init();
    }

    private void init() {
        this.dvm = getResources().getColor(t.d.editimage_bg);
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
        float width = this.dvl * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.dvi = (int) (((i4 - i2) - width) * this.dvk);
        this.dvj = (int) (((i4 - i2) - width) * (1.0f - this.dvk));
        g(0, this.dvi, 0, this.dvj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.dvm);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap hj(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.dvi, getWidth(), (getHeight() - this.dvj) - this.dvi);
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
        this.dvl = f;
        invalidate();
    }
}
