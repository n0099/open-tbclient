package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
@TargetApi(5)
/* loaded from: classes10.dex */
public class b extends a {
    private int mActivePointerId;
    private int oVE;

    public b(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.oVE = 0;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float ar(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.oVE);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float as(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.oVE);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
            case 3:
                this.mActivePointerId = -1;
                break;
            case 6:
                int Nt = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.Nt(motionEvent.getAction());
                if (motionEvent.getPointerId(Nt) == this.mActivePointerId) {
                    int i = Nt == 0 ? 1 : 0;
                    this.mActivePointerId = motionEvent.getPointerId(i);
                    this.bDi = motionEvent.getX(i);
                    this.bDj = motionEvent.getY(i);
                    break;
                }
                break;
        }
        this.oVE = motionEvent.findPointerIndex(this.mActivePointerId != -1 ? this.mActivePointerId : 0);
        return super.onTouchEvent(motionEvent);
    }
}
