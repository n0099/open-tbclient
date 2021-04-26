package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class VideoContainerLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f20140e;

    /* renamed from: f  reason: collision with root package name */
    public int f20141f;

    /* renamed from: g  reason: collision with root package name */
    public int f20142g;

    /* renamed from: h  reason: collision with root package name */
    public int f20143h;

    public VideoContainerLayout(Context context) {
        super(context);
        this.f20143h = l.k(context) / 10;
    }

    public int getMaxHeight() {
        return this.f20141f;
    }

    public int getMinHeight() {
        return this.f20140e;
    }

    public int getOriginHeight() {
        return this.f20142g;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getX() > this.f20143h && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
            ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setMaxHeight(int i2) {
        this.f20141f = i2;
    }

    public void setMinHeight(int i2) {
        this.f20140e = i2;
    }

    public void setOriginHeight(int i2) {
        this.f20142g = i2;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20143h = l.k(context) / 10;
    }

    public VideoContainerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20143h = l.k(context) / 10;
    }
}
