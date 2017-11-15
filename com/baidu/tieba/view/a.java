package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private InterfaceC0140a gMZ;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0140a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
    }

    public InterfaceC0140a getListener() {
        return this.gMZ;
    }

    public void setListener(InterfaceC0140a interfaceC0140a) {
        this.gMZ = interfaceC0140a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.gMZ != null) {
            this.gMZ.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
