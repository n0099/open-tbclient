package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Scroller;
/* loaded from: classes5.dex */
public class ExpandGridView extends GridView {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f21296e;

    /* renamed from: f  reason: collision with root package name */
    public a f21297f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(float f2);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.f21296e = new Scroller(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f21296e.computeScrollOffset()) {
            int currY = this.f21296e.getCurrY();
            a aVar = this.f21297f;
            if (aVar != null) {
                aVar.a(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        }
        super.computeScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3) {
            motionEvent.getAction();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollCallBack(a aVar) {
        this.f21297f = aVar;
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21296e = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21296e = new Scroller(context);
    }
}
