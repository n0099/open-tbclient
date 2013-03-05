package com.baidu.tieba.nearby;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnTouchListener {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a.w = true;
            return false;
        }
        return false;
    }
}
