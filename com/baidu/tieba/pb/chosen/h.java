package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tieba.pb.chosen.a.l lVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.adp.lib.util.k.c(this.cBV.getActivity(), this.cBV.getCurrentFocus());
        eVar = this.cBV.bbY;
        if (eVar != null) {
            eVar2 = this.cBV.bbY;
            if (eVar2.Bj() != null) {
                eVar3 = this.cBV.bbY;
                eVar3.Bj().hide();
            }
        }
        lVar = this.cBV.cBA;
        lVar.setVisible(true);
        return false;
    }
}
