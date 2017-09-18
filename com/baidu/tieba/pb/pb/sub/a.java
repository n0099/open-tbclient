package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class a extends View {
    private InterfaceC0113a eWl;
    private Scroller mScroller;

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0113a {
        void aUM();
    }

    public void setScrollCallBack(InterfaceC0113a interfaceC0113a) {
        this.eWl = interfaceC0113a;
    }

    public a(Context context) {
        super(context);
    }

    public void aUL() {
        if (this.mScroller == null) {
            this.mScroller = new Scroller(getContext());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.mScroller.startScroll(0, layoutParams.height, 0, 0 - layoutParams.height);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller != null) {
            if (this.mScroller.computeScrollOffset()) {
                int currY = this.mScroller.getCurrY();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = currY;
                    setLayoutParams(layoutParams);
                }
            } else if (this.eWl != null) {
                this.eWl.aUM();
            }
        }
    }
}
