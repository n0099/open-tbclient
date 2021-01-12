package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
@TargetApi(8)
/* loaded from: classes10.dex */
public class c extends b {
    protected final ScaleGestureDetector oVE;

    public c(Context context) {
        super(context);
        this.oVE = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.c.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                c.this.oVA.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean ejn() {
        return this.oVE.isInProgress();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.b, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.oVE.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
