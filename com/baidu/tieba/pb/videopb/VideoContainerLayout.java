package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public class VideoContainerLayout extends FrameLayout {
    private int hoV;
    private int kbU;
    private int mMaxHeight;
    private int mMinHeight;

    public VideoContainerLayout(Context context) {
        super(context);
        this.kbU = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kbU = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kbU = l.getEquipmentWidth(context) / 10;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public void setOriginHeight(int i) {
        this.hoV = i;
    }

    public int getOriginHeight() {
        return this.hoV;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.kbU && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
