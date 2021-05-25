package com.baidu.tieba.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/* loaded from: classes5.dex */
public class CustomVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public int f21177e;

    /* renamed from: f  reason: collision with root package name */
    public int f21178f;

    public CustomVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f21178f == 0 && this.f21177e == 0) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(this.f21177e, this.f21178f);
        }
    }

    public void setVideoHeight(int i2) {
        this.f21178f = i2;
    }

    public void setVideoWidth(int i2) {
        this.f21177e = i2;
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
