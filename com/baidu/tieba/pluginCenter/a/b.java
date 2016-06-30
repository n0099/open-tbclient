package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a eEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eEq = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter kO;
        ViewEventCenter kO2;
        ViewEventCenter kO3;
        kO = this.eEq.kO();
        if (kO != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                kO3 = this.eEq.kO();
                kO3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.eEq.getData(), null, null));
                return;
            }
            kO2 = this.eEq.kO();
            kO2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.eEq.getData(), null, null));
        }
    }
}
