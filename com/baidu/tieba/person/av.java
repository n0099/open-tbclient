package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.eeV.eeL = true;
            return false;
        }
        return false;
    }
}
