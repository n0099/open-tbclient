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
    public int f19349e;

    /* renamed from: f  reason: collision with root package name */
    public int f19350f;

    /* renamed from: g  reason: collision with root package name */
    public int f19351g;

    /* renamed from: h  reason: collision with root package name */
    public int f19352h;

    public VideoContainerLayout(Context context) {
        super(context);
        this.f19352h = l.k(context) / 10;
    }

    public int getMaxHeight() {
        return this.f19350f;
    }

    public int getMinHeight() {
        return this.f19349e;
    }

    public int getOriginHeight() {
        return this.f19351g;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.f19352h && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setMaxHeight(int i2) {
        this.f19350f = i2;
    }

    public void setMinHeight(int i2) {
        this.f19349e = i2;
    }

    public void setOriginHeight(int i2) {
        this.f19351g = i2;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19352h = l.k(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19352h = l.k(context) / 10;
    }
}
