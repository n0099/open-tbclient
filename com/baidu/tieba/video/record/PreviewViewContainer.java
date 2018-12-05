package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class PreviewViewContainer extends FrameLayout {
    private b hGW;
    private View hHd;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHd = null;
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHd = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hGW != null) {
            this.hGW.j(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.hGW = bVar;
        }
    }

    public void alm() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    public void aln() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.hHd == null) {
            this.hHd = LayoutInflater.from(getContext()).inflate(e.h.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.hHd, layoutParams);
        }
        this.hHd.setVisibility(z ? 0 : 8);
    }
}
