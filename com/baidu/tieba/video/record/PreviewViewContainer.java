package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import d.a.o0.r3.l.b;
/* loaded from: classes5.dex */
public class PreviewViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f21477e;

    /* renamed from: f  reason: collision with root package name */
    public View f21478f;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21478f = null;
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.f21478f == null) {
            this.f21478f = LayoutInflater.from(getContext()).inflate(R.layout.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.f21478f, layoutParams);
        }
        this.f21478f.setVisibility(z ? 0 : 8);
    }

    public void a() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    public void b() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar = this.f21477e;
        if (bVar != null) {
            bVar.b(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.f21477e = bVar;
        }
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21478f = null;
    }
}
