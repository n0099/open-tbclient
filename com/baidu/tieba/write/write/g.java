package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnTouchListener {
    final /* synthetic */ AtListActivity fQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.fQD = atListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.baidu.adp.lib.util.k.b(this.fQD.getPageContext().getPageActivity(), this.fQD.dfv);
            return false;
        }
        return false;
    }
}
