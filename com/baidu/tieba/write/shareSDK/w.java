package com.baidu.tieba.write.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ o dmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(o oVar) {
        this.dmr = oVar;
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
