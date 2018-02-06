package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private int gln;
    private int glo;
    private float glp;
    private float glq;
    private int glr;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glr = 0;
        this.glq = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glr = 0;
        this.glq = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glr = 0;
        this.glq = 1.0f;
        init();
    }

    private void init() {
        this.glr = getResources().getColor(d.C0140d.common_color_10226);
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
        float width = this.glq * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gln = (int) (((i4 - i2) - width) * this.glp);
        this.glo = (int) (((i4 - i2) - width) * (1.0f - this.glp));
        q(0, this.gln, 0, this.glo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.glr);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap lu(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.gln, getWidth(), (getHeight() - this.glo) - this.gln);
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
        this.glq = f;
        invalidate();
    }
}
