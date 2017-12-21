package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private InterfaceC0154a haE;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0154a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
    }

    public InterfaceC0154a getListener() {
        return this.haE;
    }

    public void setListener(InterfaceC0154a interfaceC0154a) {
        this.haE = interfaceC0154a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.haE != null) {
            this.haE.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
