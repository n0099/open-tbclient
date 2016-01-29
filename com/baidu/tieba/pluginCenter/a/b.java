package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements BdSwitchView.a {
    final /* synthetic */ a dxx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dxx = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter oF;
        ViewEventCenter oF2;
        ViewEventCenter oF3;
        oF = this.dxx.oF();
        if (oF != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                oF3 = this.dxx.oF();
                oF3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.dxx.getData(), null, null));
                return;
            }
            oF2 = this.dxx.oF();
            oF2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.dxx.getData(), null, null));
        }
    }
}
