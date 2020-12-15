package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
@TargetApi(8)
/* loaded from: classes4.dex */
public class c extends b {
    protected final ScaleGestureDetector oUb;

    public c(Context context) {
        super(context);
        this.oUb = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.c.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                c.this.oTX.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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
    public boolean enf() {
        return this.oUb.isInProgress();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.b, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.a, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.oUb.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
