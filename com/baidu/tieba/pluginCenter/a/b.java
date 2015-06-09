package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ a bXK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bXK = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        ViewEventCenter AM;
        ViewEventCenter AM2;
        ViewEventCenter AM3;
        AM = this.bXK.AM();
        if (AM != null && switchState != null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                AM3 = this.bXK.AM();
                AM3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(0, this.bXK.getData(), null, null));
                return;
            }
            AM2 = this.bXK.AM();
            AM2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bXK.getData(), null, null));
        }
    }
}
