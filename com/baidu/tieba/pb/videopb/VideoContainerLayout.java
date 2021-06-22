package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class VideoContainerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f19508e;

    /* renamed from: f  reason: collision with root package name */
    public int f19509f;

    /* renamed from: g  reason: collision with root package name */
    public int f19510g;

    /* renamed from: h  reason: collision with root package name */
    public int f19511h;

    public VideoContainerLayout(Context context) {
        super(context);
        this.f19511h = l.k(context) / 10;
    }

    public int getMaxHeight() {
        return this.f19509f;
    }

    public int getMinHeight() {
        return this.f19508e;
    }

    public int getOriginHeight() {
        return this.f19510g;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.f19511h && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setMaxHeight(int i2) {
        this.f19509f = i2;
    }

    public void setMinHeight(int i2) {
        this.f19508e = i2;
    }

    public void setOriginHeight(int i2) {
        this.f19510g = i2;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19511h = l.k(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19511h = l.k(context) / 10;
    }
}
