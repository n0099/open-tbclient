package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p dbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.dbf = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.dbf.aux();
        return false;
    }
}
