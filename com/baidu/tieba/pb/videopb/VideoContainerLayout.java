package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes22.dex */
public class VideoContainerLayout extends FrameLayout {
    private int iVm;
    private int mMaxHeight;
    private int maf;
    private int mag;

    public VideoContainerLayout(Context context) {
        super(context);
        this.mag = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mag = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mag = l.getEquipmentWidth(context) / 10;
    }

    public void setMinHeight(int i) {
        this.maf = i;
    }

    public int getMinHeight() {
        return this.maf;
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public void setOriginHeight(int i) {
        this.iVm = i;
    }

    public int getOriginHeight() {
        return this.iVm;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.mag && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
