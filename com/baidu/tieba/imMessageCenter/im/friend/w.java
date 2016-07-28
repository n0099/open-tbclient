package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.dfx = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.dfx.atR();
        return false;
    }
}
