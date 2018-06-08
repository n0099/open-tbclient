package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PreviewViewContainer extends FrameLayout {
    private b hdC;
    private View hdJ;

    public PreviewViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdJ = null;
    }

    public PreviewViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdJ = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hdC != null) {
            this.hdC.j(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setZoomHelper(b bVar) {
        if (bVar != null) {
            this.hdC = bVar;
        }
    }

    public void bDw() {
        setFaceFailIdentifyLayoutVisiable(true);
    }

    public void bDx() {
        setFaceFailIdentifyLayoutVisiable(false);
    }

    private void setFaceFailIdentifyLayoutVisiable(boolean z) {
        if (this.hdJ == null) {
            this.hdJ = LayoutInflater.from(getContext()).inflate(d.i.camera_face_fail_identify, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.hdJ, layoutParams);
        }
        this.hdJ.setVisibility(z ? 0 : 8);
    }
}
