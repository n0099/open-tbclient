package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ddY = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter oM;
        ViewEventCenter oM2;
        ViewEventCenter oM3;
        oM = this.ddY.oM();
        if (oM != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                oM3 = this.ddY.oM();
                oM3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.ddY.getData(), null, null));
                return;
            }
            oM2 = this.ddY.oM();
            oM2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.ddY.getData(), null, null));
        }
    }
}
