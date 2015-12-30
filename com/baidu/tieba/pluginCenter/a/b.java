package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.djD = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter ok;
        ViewEventCenter ok2;
        ViewEventCenter ok3;
        ok = this.djD.ok();
        if (ok != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                ok3 = this.djD.ok();
                ok3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.djD.getData(), null, null));
                return;
            }
            ok2 = this.djD.ok();
            ok2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.djD.getData(), null, null));
        }
    }
}
