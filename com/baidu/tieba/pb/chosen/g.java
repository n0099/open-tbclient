package com.baidu.tieba.pb.chosen;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.e eVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        com.baidu.tbadk.editortools.c.e eVar2;
        com.baidu.tbadk.editortools.c.e eVar3;
        com.baidu.adp.lib.util.k.c(this.cfM.getActivity(), this.cfM.getCurrentFocus());
        eVar = this.cfM.aSK;
        if (eVar != null) {
            eVar2 = this.cfM.aSK;
            if (eVar2.Az() != null) {
                eVar3 = this.cfM.aSK;
                eVar3.Az().hide();
            }
        }
        mVar = this.cfM.cft;
        mVar.setVisible(true);
        return false;
    }
}
