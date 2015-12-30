package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnTouchListener {
    final /* synthetic */ AtListActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.dWP = atListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.baidu.adp.lib.util.k.c(this.dWP.getPageContext().getPageActivity(), this.dWP.cbx);
            return false;
        }
        return false;
    }
}
