package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a ePZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ePZ = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter kK;
        ViewEventCenter kK2;
        ViewEventCenter kK3;
        kK = this.ePZ.kK();
        if (kK != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                kK3 = this.ePZ.kK();
                kK3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.ePZ.getData(), null, null));
                return;
            }
            kK2 = this.ePZ.kK();
            kK2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.ePZ.getData(), null, null));
        }
    }
}
