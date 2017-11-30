package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private InterfaceC0138a gXN;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0138a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
    }

    public InterfaceC0138a getListener() {
        return this.gXN;
    }

    public void setListener(InterfaceC0138a interfaceC0138a) {
        this.gXN = interfaceC0138a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.gXN != null) {
            this.gXN.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
