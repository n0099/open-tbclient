package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.t = true;
            return false;
        }
        return false;
    }
}
