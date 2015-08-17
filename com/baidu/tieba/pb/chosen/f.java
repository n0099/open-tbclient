package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.adp.lib.util.k.c(this.bYY.getActivity(), this.bYY.getCurrentFocus());
        dVar = this.bYY.aTh;
        if (dVar != null) {
            dVar2 = this.bYY.aTh;
            if (dVar2.Ay() != null) {
                dVar3 = this.bYY.aTh;
                dVar3.Ay().hide();
            }
        }
        mVar = this.bYY.bYF;
        mVar.setVisible(true);
        return false;
    }
}
