package com.baidu.tieba.write.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    final /* synthetic */ q cAM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar) {
        this.cAM = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            return false;
        }
        return false;
    }
}
