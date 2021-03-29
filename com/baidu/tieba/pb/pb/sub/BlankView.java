package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes5.dex */
public class BlankView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f19873e;

    /* renamed from: f  reason: collision with root package name */
    public a f19874f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public BlankView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f19873e;
        if (scroller == null) {
            return;
        }
        if (scroller.computeScrollOffset()) {
            int currY = this.f19873e.getCurrY();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        a aVar = this.f19874f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(0);
    }

    public void setScrollCallBack(a aVar) {
        this.f19874f = aVar;
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
