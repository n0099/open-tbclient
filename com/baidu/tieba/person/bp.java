package com.baidu.tieba.person;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
final class bp implements View.OnTouchListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.v = true;
            return false;
        }
        return false;
    }
}
