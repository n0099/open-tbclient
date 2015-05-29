package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ a bXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bXJ = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter AL;
        ViewEventCenter AL2;
        ViewEventCenter AL3;
        AL = this.bXJ.AL();
        if (AL != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                AL3 = this.bXJ.AL();
                AL3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.bXJ.getData(), null, null));
                return;
            }
            AL2 = this.bXJ.AL();
            AL2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bXJ.getData(), null, null));
        }
    }
}
