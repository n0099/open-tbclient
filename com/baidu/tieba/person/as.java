package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cry.cro = true;
            return false;
        }
        return false;
    }
}
