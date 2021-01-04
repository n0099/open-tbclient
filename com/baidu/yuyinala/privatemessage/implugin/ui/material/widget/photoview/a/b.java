package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
@TargetApi(5)
/* loaded from: classes11.dex */
public class b extends a {
    private int mActivePointerId;
    private int pag;

    public b(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.pag = 0;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float ar(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.pag);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float as(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.pag);
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
                int Pa = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.Pa(motionEvent.getAction());
                if (motionEvent.getPointerId(Pa) == this.mActivePointerId) {
                    int i = Pa == 0 ? 1 : 0;
                    this.mActivePointerId = motionEvent.getPointerId(i);
                    this.bHU = motionEvent.getX(i);
                    this.bHV = motionEvent.getY(i);
                    break;
                }
                break;
        }
        this.pag = motionEvent.findPointerIndex(this.mActivePointerId != -1 ? this.mActivePointerId : 0);
        return super.onTouchEvent(motionEvent);
    }
}
