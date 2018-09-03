package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PreviewViewContainer extends FrameLayout {
    private b hiX;
    private View hje;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hje = null;
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hje = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hiX != null) {
            this.hiX.j(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.hiX = bVar;
        }
    }

    public void afn() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    public void afo() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.hje == null) {
            this.hje = LayoutInflater.from(getContext()).inflate(f.h.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.hje, layoutParams);
        }
        this.hje.setVisibility(z ? 0 : 8);
    }
}
