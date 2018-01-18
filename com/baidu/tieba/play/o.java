package com.baidu.tieba.play;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes.dex */
public class o extends TextureView {
    private int grX;
    private int mVideoHeight;
    private int mVideoWidth;

    public o(Context context) {
        super(context);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.grX = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.grX == 90 || this.grX == 270) {
            i = i2;
            i2 = i;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int size = View.MeasureSpec.getSize(i);
            i3 = View.MeasureSpec.getSize(i2);
            float f = size / i3;
            float f2 = this.mVideoWidth / this.mVideoHeight;
            if (Math.abs(f2 - f) > 0.05d) {
                if (f2 > f) {
                    i3 = (int) (size / f2);
                    i4 = size;
                } else {
                    i4 = (int) (i3 * f2);
                }
                setMeasuredDimension(i4, i3);
            }
        }
        i3 = defaultSize2;
        i4 = defaultSize;
        setMeasuredDimension(i4, i3);
    }

    public void af(int i, int i2, int i3) {
        setRotation(i3);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.grX = i3;
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            requestLayout();
        }
    }
}
