package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class PreviewViewContainer extends FrameLayout {
    private b mAH;
    private View mAO;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAO = null;
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAO = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mAH != null) {
            this.mAH.handleTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.mAH = bVar;
        }
    }

    public void dDn() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    public void dDo() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.mAO == null) {
            this.mAO = LayoutInflater.from(getContext()).inflate(R.layout.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.mAO, layoutParams);
        }
        this.mAO.setVisibility(z ? 0 : 8);
    }
}
