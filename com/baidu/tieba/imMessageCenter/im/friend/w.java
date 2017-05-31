package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ p dkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.dkY = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.dkY.atJ();
        return false;
    }
}
