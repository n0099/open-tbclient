package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a eZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eZR = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter lF;
        ViewEventCenter lF2;
        ViewEventCenter lF3;
        lF = this.eZR.lF();
        if (lF != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                lF3 = this.eZR.lF();
                lF3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.eZR.getData(), null, null));
                return;
            }
            lF2 = this.eZR.lF();
            lF2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.eZR.getData(), null, null));
        }
    }
}
