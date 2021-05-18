package com.baidu.tieba.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/* loaded from: classes5.dex */
public class CustomVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public int f21249e;

    /* renamed from: f  reason: collision with root package name */
    public int f21250f;

    public CustomVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f21250f == 0 && this.f21249e == 0) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(this.f21249e, this.f21250f);
        }
    }

    public void setVideoHeight(int i2) {
        this.f21250f = i2;
    }

    public void setVideoWidth(int i2) {
        this.f21249e = i2;
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
