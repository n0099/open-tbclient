package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity cPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PersonChangeActivity personChangeActivity) {
        this.cPi = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cPi.cOY = true;
            return false;
        }
        return false;
    }
}
