package com.baidu.tieba.play;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes.dex */
public class o extends TextureView {
    private int fOP;
    private int mVideoHeight;
    private int mVideoWidth;

    public o(Context context) {
        super(context);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.fOP = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fOP == 90 || this.fOP == 270) {
            i = i2;
            i2 = i;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            defaultSize = View.MeasureSpec.getSize(i);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            float f = defaultSize / defaultSize2;
            float f2 = this.mVideoWidth / this.mVideoHeight;
            if (f2 > f) {
                defaultSize2 = (int) (defaultSize / f2);
            } else {
                defaultSize = (int) (defaultSize2 * f2);
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void X(int i, int i2, int i3) {
        setRotation(i3);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.fOP = i3;
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            requestLayout();
        }
    }
}
