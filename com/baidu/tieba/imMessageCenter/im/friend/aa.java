package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    final /* synthetic */ t bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(t tVar) {
        this.bsV = tVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bsV.VF();
        return false;
    }
}
