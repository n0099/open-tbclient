package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.clJ = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.clJ.ahr();
        return false;
    }
}
