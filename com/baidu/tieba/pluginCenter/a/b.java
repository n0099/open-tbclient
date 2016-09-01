package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a eXk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eXk = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter lF;
        ViewEventCenter lF2;
        ViewEventCenter lF3;
        lF = this.eXk.lF();
        if (lF != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                lF3 = this.eXk.lF();
                lF3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.eXk.getData(), null, null));
                return;
            }
            lF2 = this.eXk.lF();
            lF2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.eXk.getData(), null, null));
        }
    }
}
