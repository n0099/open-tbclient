package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.yuyinala.privatemessage.implugin.a.a;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
/* loaded from: classes4.dex */
public class EventDispatchRelativeLayout extends RelativeLayout {
    private a.f oze;

    public EventDispatchRelativeLayout(Context context) {
        super(context);
    }

    public EventDispatchRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EventDispatchRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        c.d("EventDispatchRelativeLayout", "b191====dispatchTouchEvent===ev:" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                setPressed(true);
                break;
            case 1:
                setPressed(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSubviewLongClickListener(a.f fVar) {
        this.oze = fVar;
    }

    public a.f getSubViewLongClickListener() {
        return this.oze;
    }
}
