package com.baidu.tieba.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/* loaded from: classes5.dex */
public class CustomVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public int f21387e;

    /* renamed from: f  reason: collision with root package name */
    public int f21388f;

    public CustomVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f21388f == 0 && this.f21387e == 0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(this.f21387e, this.f21388f);
        }
    }

    public void setVideoHeight(int i) {
        this.f21388f = i;
    }

    public void setVideoWidth(int i) {
        this.f21387e = i;
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
