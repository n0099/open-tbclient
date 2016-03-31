package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a dSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dSd = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter oy;
        ViewEventCenter oy2;
        ViewEventCenter oy3;
        oy = this.dSd.oy();
        if (oy != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                oy3 = this.dSd.oy();
                oy3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.dSd.getData(), null, null));
                return;
            }
            oy2 = this.dSd.oy();
            oy2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.dSd.getData(), null, null));
        }
    }
}
