package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.bSO.bSE = true;
            return false;
        }
        return false;
    }
}
