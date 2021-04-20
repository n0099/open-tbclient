package com.baidu.tieba.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/* loaded from: classes5.dex */
public class CustomVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public int f21379e;

    /* renamed from: f  reason: collision with root package name */
    public int f21380f;

    public CustomVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f21380f == 0 && this.f21379e == 0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(this.f21379e, this.f21380f);
        }
    }

    public void setVideoHeight(int i) {
        this.f21380f = i;
    }

    public void setVideoWidth(int i) {
        this.f21379e = i;
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
