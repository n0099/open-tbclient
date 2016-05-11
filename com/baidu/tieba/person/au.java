package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.dwD.dwt = true;
            return false;
        }
        return false;
    }
}
