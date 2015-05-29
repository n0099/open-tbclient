package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class l implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ k cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cfp = kVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.n.qc().ad(switchState == BdSwitchView.SwitchState.ON);
        this.cfp.aiG();
    }
}
