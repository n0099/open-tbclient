package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.bGa.bFQ = true;
            return false;
        }
        return false;
    }
}
