package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.dfE = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.dfE.asO();
        return false;
    }
}
