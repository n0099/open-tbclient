package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tieba.pb.chosen.a.l lVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.adp.lib.util.k.c(this.cIA.getActivity(), this.cIA.getCurrentFocus());
        eVar = this.cIA.bej;
        if (eVar != null) {
            eVar2 = this.cIA.bej;
            if (eVar2.Cz() != null) {
                eVar3 = this.cIA.bej;
                eVar3.Cz().hide();
            }
        }
        lVar = this.cIA.cIg;
        lVar.setVisible(true);
        return false;
    }
}
