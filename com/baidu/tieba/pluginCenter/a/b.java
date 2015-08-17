package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a coD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.coD = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter oH;
        ViewEventCenter oH2;
        ViewEventCenter oH3;
        oH = this.coD.oH();
        if (oH != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                oH3 = this.coD.oH();
                oH3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.coD.getData(), null, null));
                return;
            }
            oH2 = this.coD.oH();
            oH2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.coD.getData(), null, null));
        }
    }
}
