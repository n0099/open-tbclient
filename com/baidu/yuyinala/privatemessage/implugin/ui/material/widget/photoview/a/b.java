package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
@TargetApi(5)
/* loaded from: classes4.dex */
public class b extends a {
    private int mActivePointerId;
    private int otV;

    public b(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.otV = 0;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float an(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.otV);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a
    float ao(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.otV);
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
                int Nq = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.Nq(motionEvent.getAction());
                if (motionEvent.getPointerId(Nq) == this.mActivePointerId) {
                    int i = Nq == 0 ? 1 : 0;
                    this.mActivePointerId = motionEvent.getPointerId(i);
                    this.btz = motionEvent.getX(i);
                    this.btA = motionEvent.getY(i);
                    break;
                }
                break;
        }
        this.otV = motionEvent.findPointerIndex(this.mActivePointerId != -1 ? this.mActivePointerId : 0);
        return super.onTouchEvent(motionEvent);
    }
}
