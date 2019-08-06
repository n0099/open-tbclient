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
    private int inl;
    private int inm;
    private float inn;
    private float ino;
    private int inp;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.inp = 0;
        this.ino = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.inp = 0;
        this.ino = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.inp = 0;
        this.ino = 1.0f;
        init();
    }

    private void init() {
        this.inp = getResources().getColor(R.color.common_color_10226);
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
        float width = this.ino * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.inl = (int) (((i4 - i2) - width) * this.inn);
        this.inm = (int) (((i4 - i2) - width) * (1.0f - this.inn));
        setOffset(0, this.inl, 0, this.inm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(this.inp);
        super.onDraw(canvas);
        canvas.restore();
    }

    public Bitmap pH(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.inl, getWidth(), (getHeight() - this.inm) - this.inl);
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
        this.ino = f;
        invalidate();
    }
}
