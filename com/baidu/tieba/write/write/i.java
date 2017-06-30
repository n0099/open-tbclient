package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.baidu.adp.lib.util.k.b(this.gjY.getPageContext().getPageActivity(), this.gjY.dpg);
            return false;
        }
        return false;
    }
}
