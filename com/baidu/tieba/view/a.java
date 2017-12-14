package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private InterfaceC0155a haz;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0155a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
    }

    public InterfaceC0155a getListener() {
        return this.haz;
    }

    public void setListener(InterfaceC0155a interfaceC0155a) {
        this.haz = interfaceC0155a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.haz != null) {
            this.haz.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
