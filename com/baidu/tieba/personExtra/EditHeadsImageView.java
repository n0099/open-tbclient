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
/* loaded from: classes5.dex */
public class EditHeadsImageView extends DragImageView {
    public int A0;
    public float B0;
    public int x0;
    public int y0;
    public float z0;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = 0.42857143f;
        this.A0 = 0;
        this.B0 = 1.0f;
        w0();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.A0);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        float width = this.B0 * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        float f2 = (i5 - i3) - width;
        float f3 = this.z0;
        int i6 = (int) (f2 * f3);
        this.x0 = i6;
        int i7 = (int) (f2 * (1.0f - f3));
        this.y0 = i7;
        setOffset(0, i6, 0, i7);
    }

    public void setCutImageHeightScale(float f2) {
        this.B0 = f2;
        invalidate();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public Bitmap v0(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.x0, getWidth(), (getHeight() - this.y0) - this.x0);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, TbConfig.HEAD_IMG_SIZE, TbConfig.HEAD_IMG_SIZE, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        return bitmap;
    }

    public final void w0() {
        this.A0 = getResources().getColor(R.color.common_color_10226);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = 0.42857143f;
        this.A0 = 0;
        this.B0 = 1.0f;
        w0();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = 0.42857143f;
        this.A0 = 0;
        this.B0 = 1.0f;
        w0();
    }
}
