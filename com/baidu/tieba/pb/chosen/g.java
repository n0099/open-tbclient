package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.adp.lib.util.k.c(this.cfl.getActivity(), this.cfl.getCurrentFocus());
        dVar = this.cfl.aSC;
        if (dVar != null) {
            dVar2 = this.cfl.aSC;
            if (dVar2.Ax() != null) {
                dVar3 = this.cfl.aSC;
                dVar3.Ax().hide();
            }
        }
        mVar = this.cfl.ceS;
        mVar.setVisible(true);
        return false;
    }
}
