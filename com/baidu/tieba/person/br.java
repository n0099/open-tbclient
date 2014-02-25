package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.v = true;
            return false;
        }
        return false;
    }
}
