package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class VideoContainerLayout extends FrameLayout {
    private int jiy;
    private int mMaxHeight;
    private int mMinHeight;
    private int mjR;

    public VideoContainerLayout(Context context) {
        super(context);
        this.mjR = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjR = l.getEquipmentWidth(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjR = l.getEquipmentWidth(context) / 10;
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
        this.jiy = i;
    }

    public int getOriginHeight() {
        return this.jiy;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.mjR && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
