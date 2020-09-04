package com.baidu.tieba.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/* loaded from: classes.dex */
public class CustomVideoView extends VideoView {
    private int mVideoHeight;
    private int mVideoWidth;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mVideoHeight == 0 && this.mVideoWidth == 0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(this.mVideoWidth, this.mVideoHeight);
        }
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }
}
