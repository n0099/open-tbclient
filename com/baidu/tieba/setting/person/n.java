package com.baidu.tieba.setting.person;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.ccU.ccK = true;
            return false;
        }
        return false;
    }
}
