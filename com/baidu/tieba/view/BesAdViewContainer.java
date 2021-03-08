package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class BesAdViewContainer extends RelativeLayout {
    private a nYZ;
    private boolean nZa;

    /* loaded from: classes.dex */
    public interface a {
        void a(BesAdViewContainer besAdViewContainer);
    }

    public BesAdViewContainer(Context context) {
        super(context);
        this.nZa = true;
    }

    public BesAdViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZa = true;
    }

    public a getListener() {
        return this.nYZ;
    }

    public void setListener(a aVar) {
        this.nYZ = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.nZa && this.nYZ != null) {
            this.nYZ.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setEnableClick(boolean z) {
        this.nZa = z;
    }
}
