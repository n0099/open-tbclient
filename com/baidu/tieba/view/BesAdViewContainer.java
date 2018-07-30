package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class BesAdViewContainer extends RelativeLayout {
    private a hoE;

    /* loaded from: classes.dex */
    public interface a {
        void a(BesAdViewContainer besAdViewContainer);
    }

    public BesAdViewContainer(Context context) {
        super(context);
    }

    public BesAdViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getListener() {
        return this.hoE;
    }

    public void setListener(a aVar) {
        this.hoE = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.hoE != null) {
            this.hoE.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
