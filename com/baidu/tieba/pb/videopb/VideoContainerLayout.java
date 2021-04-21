package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class VideoContainerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f19656e;

    /* renamed from: f  reason: collision with root package name */
    public int f19657f;

    /* renamed from: g  reason: collision with root package name */
    public int f19658g;

    /* renamed from: h  reason: collision with root package name */
    public int f19659h;

    public VideoContainerLayout(Context context) {
        super(context);
        this.f19659h = l.k(context) / 10;
    }

    public int getMaxHeight() {
        return this.f19657f;
    }

    public int getMinHeight() {
        return this.f19656e;
    }

    public int getOriginHeight() {
        return this.f19658g;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.f19659h && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setMaxHeight(int i) {
        this.f19657f = i;
    }

    public void setMinHeight(int i) {
        this.f19656e = i;
    }

    public void setOriginHeight(int i) {
        this.f19658g = i;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19659h = l.k(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19659h = l.k(context) / 10;
    }
}
