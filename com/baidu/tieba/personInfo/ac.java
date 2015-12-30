package com.baidu.tieba.personInfo;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ac implements View.OnTouchListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(d dVar) {
        this.cWV = dVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                return true;
            default:
                return false;
        }
    }
}
