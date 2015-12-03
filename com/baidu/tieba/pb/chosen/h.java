package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tieba.pb.chosen.a.l lVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.adp.lib.util.k.c(this.cyo.getActivity(), this.cyo.getCurrentFocus());
        eVar = this.cyo.aXY;
        if (eVar != null) {
            eVar2 = this.cyo.aXY;
            if (eVar2.Bu() != null) {
                eVar3 = this.cyo.aXY;
                eVar3.Bu().hide();
            }
        }
        lVar = this.cyo.cxT;
        lVar.setVisible(true);
        return false;
    }
}
