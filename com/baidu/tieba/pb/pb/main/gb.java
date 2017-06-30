package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gb implements View.OnTouchListener {
    final /* synthetic */ ga eBA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(ga gaVar) {
        this.eBA = gaVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.view.l lVar;
        com.baidu.tieba.pb.view.l lVar2;
        lVar = this.eBA.eBy;
        if (lVar != null) {
            lVar2 = this.eBA.eBy;
            return lVar2.onTouch(view, motionEvent);
        }
        return false;
    }
}
