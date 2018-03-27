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
    private int gls;
    private int glt;
    private float glu;
    private float glv;
    private int glw;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glw = 0;
        this.glv = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glw = 0;
        this.glv = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glw = 0;
        this.glv = 1.0f;
        init();
    }

    private void init() {
        this.glw = getResources().getColor(d.C0141d.common_color_10226);
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
        float width = this.glv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gls = (int) (((i4 - i2) - width) * this.glu);
        this.glt = (int) (((i4 - i2) - width) * (1.0f - this.glu));
        q(0, this.gls, 0, this.glt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.glw);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap lz(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.gls, getWidth(), (getHeight() - this.glt) - this.gls);
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
        this.glv = f;
        invalidate();
    }
}
