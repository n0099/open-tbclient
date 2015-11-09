package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.baidu.adp.lib.util.k.c(this.dqn.getPageContext().getPageActivity(), this.dqn.bIr);
            return false;
        }
        return false;
    }
}
