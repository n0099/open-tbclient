package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes10.dex */
public class g implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setAlpha(0.7f);
            return false;
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            view.setAlpha(1.0f);
            return false;
        } else {
            return false;
        }
    }
}
