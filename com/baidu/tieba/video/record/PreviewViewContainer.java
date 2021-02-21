package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PreviewViewContainer extends FrameLayout {
    private b nQX;
    private View nRe;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRe = null;
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRe = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nQX != null) {
            this.nQX.handleTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.nQX = bVar;
        }
    }

    public void dUk() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    public void dUl() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.nRe == null) {
            this.nRe = LayoutInflater.from(getContext()).inflate(R.layout.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.nRe, layoutParams);
        }
        this.nRe.setVisibility(z ? 0 : 8);
    }
}
