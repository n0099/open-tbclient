package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cqc.cpS = true;
            return false;
        }
        return false;
    }
}
