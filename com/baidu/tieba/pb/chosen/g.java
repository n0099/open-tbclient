package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.adp.lib.util.k.c(this.cfa.getActivity(), this.cfa.getCurrentFocus());
        dVar = this.cfa.aSr;
        if (dVar != null) {
            dVar2 = this.cfa.aSr;
            if (dVar2.Ax() != null) {
                dVar3 = this.cfa.aSr;
                dVar3.Ax().hide();
            }
        }
        mVar = this.cfa.ceH;
        mVar.setVisible(true);
        return false;
    }
}
