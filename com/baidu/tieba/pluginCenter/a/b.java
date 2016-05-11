package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a dUV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dUV = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter kL;
        ViewEventCenter kL2;
        ViewEventCenter kL3;
        kL = this.dUV.kL();
        if (kL != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                kL3 = this.dUV.kL();
                kL3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.dUV.getData(), null, null));
                return;
            }
            kL2 = this.dUV.kL();
            kL2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.dUV.getData(), null, null));
        }
    }
}
