package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.adp.lib.util.k.c(this.bZS.getActivity(), this.bZS.getCurrentFocus());
        dVar = this.bZS.aTv;
        if (dVar != null) {
            dVar2 = this.bZS.aTv;
            if (dVar2.AL() != null) {
                dVar3 = this.bZS.aTv;
                dVar3.AL().hide();
            }
        }
        mVar = this.bZS.bZz;
        mVar.setVisible(true);
        return false;
    }
}
