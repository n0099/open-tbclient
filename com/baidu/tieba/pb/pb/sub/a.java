package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class a extends View {
    private InterfaceC0112a eTD;
    private Scroller mScroller;

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0112a {
        void aUC();
    }

    public void setScrollCallBack(InterfaceC0112a interfaceC0112a) {
        this.eTD = interfaceC0112a;
    }

    public a(Context context) {
        super(context);
    }

    public void aUB() {
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
            } else if (this.eTD != null) {
                this.eTD.aUC();
            }
        }
    }
}
