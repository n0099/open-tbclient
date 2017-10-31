package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private InterfaceC0137a gLR;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0137a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
    }

    public InterfaceC0137a getListener() {
        return this.gLR;
    }

    public void setListener(InterfaceC0137a interfaceC0137a) {
        this.gLR = interfaceC0137a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.gLR != null) {
            this.gLR.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
