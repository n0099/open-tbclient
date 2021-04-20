package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import d.b.i0.q3.m.b;
/* loaded from: classes5.dex */
public class PreviewViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f21507e;

    /* renamed from: f  reason: collision with root package name */
    public View f21508f;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21508f = null;
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.f21508f == null) {
            this.f21508f = LayoutInflater.from(getContext()).inflate(R.layout.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.f21508f, layoutParams);
        }
        this.f21508f.setVisibility(z ? 0 : 8);
    }

    public void a() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    public void b() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar = this.f21507e;
        if (bVar != null) {
            bVar.b(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.f21507e = bVar;
        }
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21508f = null;
    }
}
